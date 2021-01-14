package family.dd.DDHomeKits.AuthCenter.util;

import family.dd.DDHomeKits.AuthCenter.domain.HandlePasswordException;
import family.dd.DDHomeKits.AuthCenter.domain.handler.PasswordHandler;
import family.dd.DDHomeKits.AuthCenter.domain.handler.PasswordHandlerFactory;

public class CommonUtil {
    public static boolean isNull(Object o){
        return null == o;
    }

    public static boolean isEmptyString(String str) {
        return null==str||str.isEmpty()||str.equals("");
    }

    /**
     * Handle password inputted by front user
     * @param username Use username as seed of password handler
     * @param password unhandled password
     * @throws Exception when failed to handle password
     * @return handled password
     */
    public static String transPassword(String username, String password) throws HandlePasswordException {
        try{
            PasswordHandler pwdHandler = PasswordHandlerFactory.getInstance();
            return pwdHandler.handle(password, username);
        }catch (Exception e) {
            throw new HandlePasswordException("Server ERROR, Login Failed!");
        }
    }
}
