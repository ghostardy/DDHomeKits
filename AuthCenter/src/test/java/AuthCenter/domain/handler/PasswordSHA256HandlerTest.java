package family.dd.DDHomeKits.AuthCenter.domain.handler;

import family.dd.DDHomeKits.AuthCenter.dao.IdentificationPO;
import family.dd.DDHomeKits.AuthCenter.definition.ResponseCode;
import family.dd.DDHomeKits.AuthCenter.dao.HandleResult;
import org.junit.jupiter.api.Test;

class PasswordSHA256HandlerTest {

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
        PasswordHandler handler = new PasswordSHA256Handler();
        HandleResult result = handler.handle(userInfo);
        assertEquals(ResponseCode.SUCCESS, result.getCode());
        assertEquals("1035343-6186217241888276338763-38-1103154122-71-65431159119-106-2-746126", result.getMessage());
    }
}
