package family.dd.DDHomeKits.AuthenticationCenter.domain.handler;

import family.dd.DDHomeKits.AuthenticationCenter.definition.ResponseCode;
import family.dd.DDHomeKits.AuthenticationCenter.dao.HandleResult;
import family.dd.DDHomeKits.AuthenticationCenter.dao.UserInfo;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import static family.dd.DDHomeKits.AuthenticationCenter.util.CommonUtil.isNull;

/**
 * Handle user password by sha256
 * Added to Password handle chain
 */
public class PasswordSHA256Handler extends PasswordHandler{
    @Override
    public HandleResult handle(UserInfo user) {
        String digest;
        try {
            digest = sha256digest(user.getPassword());
        }catch (Exception e) {
            return new HandleResult(ResponseCode.SERVER_ERROR, "failed to encrypt password");
        }

        if (isNull(next)){
            return new HandleResult(ResponseCode.SUCCESS, digest);
        }else {
            UserInfo ui = new UserInfo(user);
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
