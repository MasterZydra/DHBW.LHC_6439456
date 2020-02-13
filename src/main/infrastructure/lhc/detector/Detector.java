package main.infrastructure.lhc.detector;

import com.google.common.eventbus.Subscribe;
import main.infrastructure.Configuration;
import main.infrastructure.lhc.experiment.*;
import main.infrastructure.lhc.*;
import main.infrastructure.security.*;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.time.Duration;
import java.time.Instant;
import java.util.LinkedList;
import java.util.List;

public class Detector extends Subscriber implements IDetector {
    private static String higgsBosonStructure = "higgs";
    private boolean isActivated;
    private List<IExperiment> experimentList;
    private IReader reader;

    private Instant start;

    private IRing ring;

    private Method searchString;
    private Object port;

    public Detector() {
        super();
        this.experimentList = new LinkedList<>();
    }

    public void viewExperiments() {
        for(IExperiment experiment : this.experimentList) {
            System.out.println(experiment);
        }
    }

    public void addExperiment(IExperiment experiment) {
        this.experimentList.add(experiment);
    }

    public Object getPort()
    {
        return port;
    }

    public List<IExperiment> getExperimentList()
    {
        return this.experimentList;
    }

    private void createSearchMethod() {
        Object instance;
        try {
            URL[] urls = {new File(Configuration.instance.getSearchAlgorithmPath()).toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, Detector.class.getClassLoader());
            Class clazz = Class.forName(Configuration.instance.searchAlgorithm.toString(), true, urlClassLoader);

            instance = clazz.getMethod("getInstance").invoke(null);
            port = clazz.getDeclaredField("port").get(instance);
            searchString = port.getClass().getMethod("search", String.class, String.class);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void search(IExperiment experiment) {
        for (int i = 0; i < 200000; i++) {
            String hayStack = experiment.getBlock(i).getStructure();
            try {
                int pos = (Integer) this.searchString.invoke(this.port, hayStack, higgsBosonStructure);

                if (pos != -1) {
                    // Analysis time
                    Instant end = Instant.now();
                    long analyseTime = Duration.between(this.start, end).toMillis();

                    experiment.setHiggsBosonFound();

                    System.out.println(experiment + " -  Block-ID: " + Integer.toString(i) + " - "
                        + hayStack + " - Analyse-Time " + Long.toString(analyseTime) + " ms");

                    return;
                }

            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Subscribe
    public void receive(AnalyseEvent event) {
        this.createSearchMethod();
        start = Instant.now();
        for(IExperiment experiment : this.experimentList) {
            this.search(experiment);
        }
    }
}
