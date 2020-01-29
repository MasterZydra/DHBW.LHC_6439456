package infrastructure.lhc.detector;

import com.google.common.eventbus.Subscribe;
import infrastructure.Configuration;
import infrastructure.lhc.AnalyseEvent;
import infrastructure.lhc.Subscriber;
import infrastructure.lhc.experiment.IExperiment;
import infrastructure.lhc.IRing;
import infrastructure.security.IReader;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.LinkedList;
import java.util.List;

public class Detector extends Subscriber implements IDetector {
    private static String higgsBosonStructure = "higgs";
    private boolean isActivated;
    private List<IExperiment> experimentList;
    private IReader reader;

    private IRing ring;

    private Method searchString;
    private Object port;

    public Detector() {
        super();
        this.experimentList = new LinkedList<>();
        this.createSearchMethod();
    }

    public void viewExperiments() {
        for(IExperiment experiment : this.experimentList) {
            System.out.println(experiment);
        }
    }

    public void addExperiment(IExperiment experiment) {
        this.experimentList.add(experiment);
    }

    private void createSearchMethod() {
        Object instance;
        try {
            URL[] urls = {new File(Configuration.instance.pathToJar).toURI().toURL()};
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
        for (int i = 0; i < 20000; i++) {
            String hayStack = experiment.getBlock(i).getStructure();
            try {
                int pos = (Integer) this.searchString.invoke(this.port, hayStack, higgsBosonStructure);

                if (pos != -1) {
                    experiment.setHiggsBosonFound();
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

    }
}
