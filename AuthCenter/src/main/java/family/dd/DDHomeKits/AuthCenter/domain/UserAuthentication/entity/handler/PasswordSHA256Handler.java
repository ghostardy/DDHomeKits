package family.dd.DDHomeKits.AuthCenter.domain.UserAuthentication.entity.handler;

import family.dd.DDHomeKits.AuthCenter.infrastructure.util.CommonUtil;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Handle user password by sha256
 * Added to Password handle chain
 */
public class PasswordSHA256Handler extends PasswordHandler{
    @Override
    public String handle(String source, String...seed) throws Exception{
        String digest = sha256digest(source);
        if (CommonUtil.isNull(next)){
            return digest;
        }else {
            return next.handle(digest, seed);
        }
    }

    /**
     * Calculate digest of string data
     * @param data
     * @return digest string
     * @throws NoSuchAlgorithmException
     */
    private String sha256digest(String data) throws NoSuchAlgorithmException{
        MessageDigest digester = MessageDigest.getInstance("SHA-256");
        digester.update(data.getBytes());
        byte[] digest = digester.digest();

        StringBuilder res = new StringBuilder();
        for (byte b : digest) {
            res.append(b);
        }
        return res.toString();
    }
}
