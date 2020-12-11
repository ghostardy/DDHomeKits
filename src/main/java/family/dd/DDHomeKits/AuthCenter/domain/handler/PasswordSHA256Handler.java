package family.dd.DDHomeKits.AuthCenter.domain.handler;

import family.dd.DDHomeKits.AuthCenter.dao.IdentificationPO;
import family.dd.DDHomeKits.AuthCenter.definition.ResponseCode;
import family.dd.DDHomeKits.AuthCenter.dao.HandleResult;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import static family.dd.DDHomeKits.AuthCenter.util.CommonUtil.isNull;

/**
 * Handle user password by sha256
 * Added to Password handle chain
 */
public class PasswordSHA256Handler extends PasswordHandler{
    @Override
    public HandleResult handle(IdentificationPO user) {
        String digest;
        try {
            digest = sha256digest(user.getPassword());
        }catch (Exception e) {
            return new HandleResult(ResponseCode.SERVER_ERROR, "failed to encrypt password");
        }

        if (isNull(next)){
            return new HandleResult(ResponseCode.SUCCESS, digest);
        }else {
            IdentificationPO ui = new IdentificationPO(user);
            ui.setPassword(digest);
            return next.handle(ui);
        }
    }

    String sha256digest(String data) throws NoSuchAlgorithmException{
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
