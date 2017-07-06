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
public class GetOsPlatform {
    
    //vul private met het os
    private String OS = System.getProperty("os.name").toLowerCase();
    
    /**
     * 
     * @return welke os je zit 
     */
    public String getOS() {

        if (isWindows()) {
            return "windows";
        } else if (isMac()) {
            return "mac";
        } else {
            return "false";
        }
    }

    private boolean isWindows() {
        return (OS.contains("win"));
    }

    private boolean isMac() {
        return (OS.contains("mac"));

    }
}