package gui;
 
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
 
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
 
/**
 * Java utiliza cifrado y descifrado AES cifrado AES-128-ECB
   * Común con el algoritmo de cifrado aes de la base de datos mysql
   * Base de datos aes cifrado y descifrado
   * - cifrado
 *	SELECT to_base64(AES_ENCRYPT('www.gowhere.so','jkl;POIU1234++=='));
   * - descifrar
 *	SELECT AES_DECRYPT(from_base64('Oa1NPBSarXrPH8wqSRhh3g=='),'jkl;POIU1234++==');
 * @author 836508
 *
 */
public class MyAESUtil {
 
         // cifrado
    public static String Encrypt(String sSrc, String sKey) throws Exception {
        if (sKey == null) {
                         System.out.print ("La clave está vacía nula");
            return null;
        }
                 // Determinar si la clave es de 16 bits
        if (sKey.length() != 16) {
                         System.out.print ("La longitud de la clave no es de 16 bits");
            return null;
        }
        byte[] raw = sKey.getBytes("utf-8");
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
                 Cipher cipher = Cipher.getInstance ("AES / ECB / PKCS5Padding"); // "Algoritmo / modo / código complementario"
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes("utf-8"));
                 return new BASE64Encoder (). encode (encrypted); // Aquí BASE64 se usa como la función de transcodificación, que también puede desempeñar el papel de cifrado dos veces.
    }
 
         // descifrar
    public static String Decrypt(String sSrc, String sKey) throws Exception {
        try {
                         // Determinar si la clave es correcta
            if (sKey == null) {
                                 System.out.print ("La clave está vacía nula");
                return null;
            }
                         // Determinar si la clave es de 16 bits
            if (sKey.length() != 16) {
                                 System.out.print ("La longitud de la clave no es de 16 bits");
                return null;
            }
            byte[] raw = sKey.getBytes("utf-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
                         byte [] encrypted1 = new BASE64Decoder (). decodeBuffer (sSrc); // Primero descifrar con base64
            try {
                byte[] original = cipher.doFinal(encrypted1);
                String originalString = new String(original,"utf-8");
                return originalString;
            } catch (Exception e) {
                System.out.println(e.toString());
                return null;
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }
 
    public static void main(String[] args) throws Exception {
        /*
                   * Aquí se usa el modo de cifrado AES-128-ECB, y la clave debe ser de 16 bits.
         */
        String cKey = "jkl;POIU1234++==";
                 // cadena a cifrar
        String cSrc = "mario";
        System.out.println(cSrc);
                 // cifrado
        String enString = MyAESUtil.Encrypt(cSrc, cKey);
                 System.out.println ("La cadena encriptada es:" + enString);
 
                 // descifrar
        String DeString = MyAESUtil.Decrypt(enString, cKey);
                 System.out.println ("La cadena descifrada es:" + DeString);
    }
}