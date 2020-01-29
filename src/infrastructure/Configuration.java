package infrastructure;

import infrastructure.lhc.detector.SearchAlgorithm;

public enum Configuration {
    instance;
    public String AESKey = "Geheim";
    public SearchAlgorithm searchAlgorithm = SearchAlgorithm.Native;
    // Pathes for search algorithms
    public String fs = System.getProperty("file.separator");
    public String ud = System.getProperty("user.dir");
    public String pathToJar = getSearchAlgorithmPath();

    public String protonData = ud + fs + "data" + fs;

    public String getSearchAlgorithmPath() {
        String path = ud + fs;
        switch (searchAlgorithm) {
            case Native:            path += "sa_native" + fs + "jar" + fs + "Native.jar"; break;
            case BoyerMoore:        path += "sa_boyerMoore" + fs + "jar" + fs + "BoyerMoore.jar"; break;
            case KnuthMorrisPratt:  path += "sa_knuthMorrisPratt" + fs + "jar" + fs + "KnuthMorrisPratt.jar"; break;
            default: path += "ERROR";
        }
        return path;
    }


}
