package family.dd.DDHomeKits.member.handler;

import family.dd.DDHomeKits.definition.ResponseCode;
import family.dd.DDHomeKits.entity.HandleResult;
import family.dd.DDHomeKits.entity.UserInfo;
import org.junit.jupiter.api.Test;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import static org.junit.jupiter.api.Assertions.*;

class PasswordHandlerTest {
    @Test
    void handle() {
        PasswordHandler handler = PasswordHandlerFactory.getInstance();
        UserInfo userInfo1 = new UserInfo("username", "password");
        UserInfo userInfo2 = new UserInfo("username1", "password");
        HandleResult result1 = handler.handle(userInfo1);
        HandleResult result2 = handler.handle(userInfo2);
        HandleResult result3 = handler.handle(userInfo2);
        assertEquals(result1.getCode(), ResponseCode.SUCCESS);
        assertEquals(result2.getCode(), ResponseCode.SUCCESS);
        assertEquals(result3.getCode(), ResponseCode.SUCCESS);
        assertNotEquals(result1.getMessage(), result2.getMessage());
        assertEquals(result2.getMessage(), result3.getMessage());
    }
}
