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

public class InlogControle {
    private String Gebruiker;
    private String Wachtwoord;
   
    
    
    public boolean login(String Gebruiker, String Wachtwoord){
        boolean klopt = false;
        this.Gebruiker = Gebruiker;
        this.Wachtwoord = Wachtwoord;
        
        
        
        return klopt;
    }
    
    
    
    
    
    
    
    
    
    public boolean firstLogin(){
        boolean klopt = true;
        
        
        
        return klopt;
    }
}
