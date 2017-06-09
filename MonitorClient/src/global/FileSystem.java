/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package global;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author michel
 */
public class FileSystem {
    
    //maakt objecten aan
    JFileChooser fr = new JFileChooser();
    GetOsPlatform getOsPlatform = new GetOsPlatform();

    private String fileLocation() {
        FileSystemView fw = fr.getFileSystemView();

        if ("windows".equals(getOsPlatform.getOS())) {
            return Paths.get("C:\\trading").toString() + "\\";
        }

        if ("mac".equals(getOsPlatform.getOS())) {
            return Paths.get(fw.getDefaultDirectory() + "//Documents//trading").toString() + "//";
        }

        return Paths.get(fw.getDefaultDirectory() + "//Documents//trading").toString() + "//";
    }
    
    /**
     * Deze methoden maakt de folder als die er niet is
     */
    public void folderExist() {

        //kijk of de folder bestaat
        if (!Files.exists(Paths.get(fileLocation()))) {
            System.out.println("No Folder");

            //folder word aangemaakt.
            File file = new File(fileLocation());
            file.mkdir();
            System.out.println("Folder created");
        } else {
            System.out.println("Folder exists");
        }
    }
    
    /**
     * 
     * @param file Bestand naam
     * @return return dde data
     */
    public String readFile (String file){
        try {
            FileSystemView fw = fr.getFileSystemView();
            return new String(Files.readAllBytes(Paths.get(fileLocation()+file)));
        } catch (IOException ex) {
            return "false";
        }
    }

}
