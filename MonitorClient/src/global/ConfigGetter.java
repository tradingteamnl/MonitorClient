/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package global;

/**
 *
 * @author michel
 */
public class ConfigGetter {

    //private
    private boolean loadCss = false;
    private String cssLocatie = "global/Style2.css";

    /**
     * Load css
     *
     * @return of css geladen mag worden
     */
    public boolean isLoadCss() {
        return loadCss;
    }

    /**
     * Laat css
     *
     * @return laat css locatie
     */
    public String getCssLocatie() {
        return cssLocatie;
    }

}
