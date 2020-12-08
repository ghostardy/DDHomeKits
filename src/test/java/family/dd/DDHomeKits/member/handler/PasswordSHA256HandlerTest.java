package family.dd.DDHomeKits.member.handler;

import family.dd.DDHomeKits.definition.ResponseCode;
import family.dd.DDHomeKits.entity.HandleResult;
import family.dd.DDHomeKits.entity.UserInfo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordSHA256HandlerTest {

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
        PasswordHandler handler = new PasswordSHA256Handler();
        HandleResult result = handler.handle(userInfo);
        assertEquals(ResponseCode.SUCCESS, result.getCode());
        assertEquals("1035343-6186217241888276338763-38-1103154122-71-65431159119-106-2-746126", result.getMessage());
    }
}
