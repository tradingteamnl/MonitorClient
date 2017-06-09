/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceMethoden;

/**
 *
 * @author Jaros
 */

public class InterfaceGlobal {    
    public String productNaam(){
        String productNaam = "bitfarmer";        
        return productNaam;
    }
    
    public String Textnaam = "oplsagdata";
    public String OpslagDirectory = "test";
    
    
     public String gebruiker;

    public void setGebruiker(String gebruiker) {
        this.gebruiker = gebruiker;
    }

    public String getGebruiker() {
        return gebruiker;
    }
     
    
    
    
}
