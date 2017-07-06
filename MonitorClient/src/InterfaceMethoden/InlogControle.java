package InterfaceMethoden;

/**
 *f
 * @author Jaros
 */
public class InlogControle {

    /**
     *
     * @param gebruiker username
     * @param wachtwoord wachtwoord wat is ingevuld.
     * @return
     */
    public boolean getLogin(String gebruiker, String wachtwoord) {
        return loginCheck(gebruiker, wachtwoord);
    }

    /**
     *
     * @param gebruiker username
     * @param wachtwoord wachtwoord wat is ingevuld
     * @return true of false
     */
    private boolean loginCheck(String gebruiker, String wachtwoord) {
        
        //laat het wachtwoord bestand
        boolean klopt = false;   
        return klopt;
    }    
    
    public boolean firstLogin(){
        boolean klopt = true;
        return klopt;
    }
}
