package family.dd.DDHomeKits.AuthCenter.domain.handler;

import family.dd.DDHomeKits.AuthCenter.dao.IdentificationPO;
import family.dd.DDHomeKits.AuthCenter.definition.ResponseCode;
import family.dd.DDHomeKits.AuthCenter.dao.HandleResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PasswordSimpleSaltHandlerTest {

    @Test
    void handle() {
        /**
         * Set test user data
         */
        final String testUsername = "testUsername";
        final String testPassword = "originalTestPassword";
        IdentificationPO userInfo = new IdentificationPO(testUsername, testPassword);
        /**
         * Execute
         */
        PasswordHandler handler = new PasswordSimpleSaltHandler();
        HandleResult result = handler.handle(userInfo);
        assertEquals(ResponseCode.SUCCESS, result.getCode());
        assertEquals(userInfo.getUsername()+userInfo.getPassword()+PasswordSimpleSaltHandler.getSalt(), result.getMessage());
    }
}
