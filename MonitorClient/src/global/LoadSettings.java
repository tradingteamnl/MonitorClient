/*
 * Laat settings bestand
 */
package global;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author michel
 */
public class LoadSettings {

    //maak klasse
    FileSystem fileSystem = new FileSystem();

    //boolean
    private boolean loadBittrex = false;
    private boolean loadPoloniex = false;

    /**
     * Constructor
     *
     * @throws java.io.IOException Error
     */
    public LoadSettings() throws IOException {

        //kijk of het bestand bestaat
        boolean detectSettingsFile = fileSystem.fileExcist("settingsFile.properties");

        Properties prop;
        InputStream input = null;

        //if loop
        if (detectSettingsFile) {

            //prop flie
            prop = new Properties();

            //krijg de bestand locatie
            input = new FileInputStream(fileSystem.inputStreamFileLocation("settingsFile.properties"));

            // load a properties file
            prop.load(input);

            //kijk of bittrex geladen moet worden
            String loadBittrexString = prop.getProperty("bittrex");
            if ("true".equals(loadBittrexString)) {
                this.loadBittrex = true;
            }

            //poloniex
            String loadPoloniexString = prop.getProperty("poloniex");
            if ("true".equals(loadPoloniexString)) {
                this.loadPoloniex = true;
            }

        } else {
            System.err.println("[WARN] [LOADSETTINGS] Er is geen settings file!");
        }

    }

    /* ============== GETTERS ============== */
    /**
     * Moet bittrex geladen worden
     *
     * @return of exchange geladen moet worden
     */
    public boolean isLoadBittrex() {
        return loadBittrex;
    }

    /**
     * Moet poloniex geladen worden
     *
     * @return of exchange geladen moet worden
     */
    public boolean isLoadPoloniex() {
        return loadPoloniex;
    }

}
