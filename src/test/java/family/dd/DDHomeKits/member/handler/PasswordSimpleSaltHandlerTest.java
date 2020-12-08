package family.dd.DDHomeKits.member.handler;

import family.dd.DDHomeKits.definition.ResponseCode;
import family.dd.DDHomeKits.entity.HandleResult;
import family.dd.DDHomeKits.entity.UserInfo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordSimpleSaltHandlerTest {

    @Test
    void handle() {
        /**
         * Set test user data
         */
        final String testUsername = "testUsername";
        final String testPassword = "originalTestPassword";
        UserInfo userInfo = new UserInfo(testUsername, testPassword);
        /**
         * Execute
         */
        PasswordHandler handler = new PasswordSimpleSaltHandler();
        HandleResult result = handler.handle(userInfo);
        assertEquals(ResponseCode.SUCCESS, result.getCode());
        assertEquals(userInfo.getUsername()+userInfo.getPassword()+PasswordSimpleSaltHandler.getSalt(), result.getMessage());
    }
}
