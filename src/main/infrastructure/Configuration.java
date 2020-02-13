package main.infrastructure;

import main.infrastructure.lhc.detector.SearchAlgorithm;

public enum Configuration {
    instance;
    public String AESKey = "Geheim";
    public SearchAlgorithm searchAlgorithm = SearchAlgorithm.Native;
    // Pathes for search algorithms
    public final String fs = System.getProperty("file.separator");
    public final String ud = System.getProperty("user.dir");


    public final String dataBaseDir = ud + fs + "dataBase" + fs;
    public final String dataBaseFile = dataBaseDir + "dataStore.db";
    public String username = "sa";
    public String password = "";

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
