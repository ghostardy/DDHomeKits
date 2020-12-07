package family.dd.DDHomeKits.member.handler;

import family.dd.DDHomeKits.definition.ResponseCode;
import family.dd.DDHomeKits.entity.HandleResult;
import family.dd.DDHomeKits.entity.UserInfo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static family.dd.DDHomeKits.util.CommonUtil.isNull;

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
            user.setPassword(digest);
            return next.handle(user);
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
