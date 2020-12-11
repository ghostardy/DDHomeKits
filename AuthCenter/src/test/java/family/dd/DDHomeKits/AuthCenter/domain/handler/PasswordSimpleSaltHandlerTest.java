package family.dd.DDHomeKits.AuthCenter.domain.handler;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PasswordSimpleSaltHandlerTest {
    @Test
    void handle() {
        /**
         * Set test user data
         */
        final String seed = "testUsername";
        final String testPassword = "originalTestPassword";
        /**
         * Execute
         */
        PasswordHandler handler = new PasswordSimpleSaltHandler();
        try {
            assertEquals (seed + testPassword + PasswordSimpleSaltHandler.getSimpleSalt(), handler.handle(testPassword, seed));
        }catch (Exception e){
            Assertions.fail();
        }
    }
}
