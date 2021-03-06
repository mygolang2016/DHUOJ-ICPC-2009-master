package cn.edu.dhu.acm.oj.common.paperdistribute;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.InvalidKeyException;

import org.jdom.JDOMException;

import cn.edu.dhu.acm.oj.common.paper.PaperBean;
import cn.edu.dhu.acm.oj.common.util.AESInputStream;
import cn.edu.dhu.acm.oj.common.util.Cryptograph;

/**
 * Providing methods to decrypt paper distributed by
 * {@link PaperDistributor}.
 * 
 * @author Zhu Kai
 * 
 * @since SVN 107
 */
public class PaperDecryptor {
    
    /**
     * Decrypting a encrypted paper file, which is generated by
     * {@link PaperDistributor#distributePaper(File, File, String,
     * PaperUserID[])
     * PaperDistributor.distributePaper()}.
     * 
     * @param paperFile the paper file to decrypt.
     * @param paperPassword the password of the paper.
     * @param userPassword the user's password.
     * 
     * @return the decrypted paper object.
     * 
     * @throws JDOMException error occurs in parsing XML.
     * @throws IOException if I/O error occurs.
     */
    public static PaperBean decryptPaper(
        File paperFile, String paperPassword, String userPassword )
    throws IOException, JDOMException {
        return decryptPaper(paperFile, paperPassword + userPassword);
    }
    
    /**
     * Decrypting a encrypted paper file, which is generated by
     * {@link PaperDistributor#distributePaper(File, File, String)
     * PaperDistributor.distributePaper()}.
     * 
     * @param paperFile the paper file to decrypt.
     * @param password the password used by decryption.
     * 
     * @return the decrypted paper object.
     * 
     * @throws JDOMException error occurs in parsing XML.
     * @throws IOException if I/O error occurs.
     */
    public static PaperBean decryptPaper(File paperFile, String password)
    throws IOException, JDOMException {
        BufferedInputStream in = new BufferedInputStream(
            new FileInputStream(paperFile) );
        
        byte[] key = Cryptograph.stringMD5(password);
        
        AESInputStream aesInputStream = null;
        try {
            aesInputStream = new AESInputStream(in, key);
        } catch (InvalidKeyException ike) {
            // It can't happen, the key must be valid.
            ike.printStackTrace();
        }
        
        PaperBean paperBean = new PaperBean();
        paperBean.readPaper(aesInputStream);
        
        aesInputStream.close();
        
        return paperBean;
    }
    
}
