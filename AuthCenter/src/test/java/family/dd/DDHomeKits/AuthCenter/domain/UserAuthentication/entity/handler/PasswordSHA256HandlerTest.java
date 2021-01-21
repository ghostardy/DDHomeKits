package family.dd.DDHomeKits.AuthCenter.domain.UserAuthentication.entity.handler;

import family.dd.DDHomeKits.AuthCenter.domain.UserAuthentication.repository.UserIdentityPO;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PasswordSHA256HandlerTest {

    @Test
    void handle() {
        /**
         * Set test user data
         */
        final String testUsername = "testUsername";
        final String testPassword = "originalTestPassword";
        UserIdentityPO userInfo = new UserIdentityPO(testUsername, testPassword);
        /**
         * Execute
         */
        PasswordHandler handler = new PasswordSHA256Handler();
        try {
            assertEquals("1035343-6186217241888276338763-38-1103154122-71-65431159119-106-2-746126", handler.handle(testPassword));
        }catch (Exception e){
            Assert.fail();
        }
    }
}
