package family.dd.DDHomeKits.AuthenticationCenter.domain.handler;

import family.dd.DDHomeKits.AuthenticationCenter.definition.ResponseCode;
import family.dd.DDHomeKits.AuthenticationCenter.dao.HandleResult;
import family.dd.DDHomeKits.AuthenticationCenter.dao.UserInfo;
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
