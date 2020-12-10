package family.dd.DDHomeKits.AuthenticationCenter.util;

public class CommonUtil {
    public static boolean isNull(Object o){
        return null == o;
    }

    public static boolean isEmptyString(String str) {
        return null==str||str.isEmpty()||str.equals("");
    }
}
