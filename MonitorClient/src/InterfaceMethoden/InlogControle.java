/**
 * Deze class is voor de inlog check
 */
package InterfaceMethoden;

import Security.Decrypt;
import global.FileSystem;
import java.io.IOException;

/**
 *f
 * @author Jaros
 */
public class InlogControle {

    //roep object aan
    FileSystem fileSystem = new FileSystem();

    /**
     *
     * @param gebruiker username
     * @param wachtwoord wachtwoord wat is ingevuld.
     * @return
     * @throws java.io.IOException Error afvang systeem
     */
    public boolean getLogin(String gebruiker, String wachtwoord) throws IOException, Exception {
        return loginCheck(gebruiker, wachtwoord);
    }

    /**
     *
     * @param gebruiker username
     * @param wachtwoord wachtwoord wat is ingevuld
     * @return true of false
     * @throws java.io.IOException Error afvang systeem
     */
    private boolean loginCheck(String gebruiker, String wachtwoord) throws IOException, Exception {

        //laat het wachtwoord bestand
        String wachtwoordEncrypt = fileSystem.readFile("wachtwoord.txt");
        
        System.out.println("wachtwoordencrypt "+wachtwoordEncrypt);
        
        //ontsleutel de data
        String wachtwoordSave = Decrypt.decrypt(wachtwoordEncrypt, wachtwoord);

        //kijk of de data het zelfde is
        if (wachtwoordSave.equals(wachtwoord)) {
            return true;
        } else {
            return false;
        }
    }
}
