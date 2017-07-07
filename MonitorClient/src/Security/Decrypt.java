package Security;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 * Bestand is voor de decrypt
 *
 * @author michel_desktop
 */
public class Decrypt {

    /**
     *
     * @param strEncrypted text wat er ontsluiteld moet worden.
     * @param strKey de ontsleutelings key.
     * @return return String.
     * @throws Exception Als er een error is/
     */
    public String decrypt(String strEncrypted, String strKey) throws Exception {
        String strData = "";
        System.out.println(strKey);

        try {
            SecretKeySpec skeyspec = new SecretKeySpec(strKey.getBytes(), "Blowfish");
            Cipher cipher = Cipher.getInstance("Blowfish");
            cipher.init(Cipher.DECRYPT_MODE, skeyspec);
            byte[] decrypted = cipher.doFinal(strEncrypted.getBytes());
            strData = new String(decrypted);

        } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            throw new Exception(e);
        }
        return strData;
    }
}
