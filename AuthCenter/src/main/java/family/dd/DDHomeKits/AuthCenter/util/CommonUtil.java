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
}
