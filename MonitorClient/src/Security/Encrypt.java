package Security;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * Dit bestand is voor de encrypt
 *
 * @author michel_desktop
 */
public class Encrypt {

    /**
     *
     * @param strClearText text die encrypt moet worden
     * @param strKey Key
     * @return de versleuteling
     * @throws Exception het error opvangen
     */
    public String encrypt(String strClearText, String strKey) throws Exception {

        //string data
        String strData = "";
        System.out.println("Data om te versleutelen " + strData);

        SecretKeySpec skeyspec = new SecretKeySpec(strKey.getBytes(), "Blowfish");
        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.ENCRYPT_MODE, skeyspec);
        byte[] encrypted = cipher.doFinal(strClearText.getBytes());
        strData = new String(encrypted);

        //return data
        return strData;

    }
}
