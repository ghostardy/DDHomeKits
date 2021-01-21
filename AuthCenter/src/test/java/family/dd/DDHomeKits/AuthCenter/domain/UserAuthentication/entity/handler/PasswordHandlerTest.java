package family.dd.DDHomeKits.AuthCenter.domain.UserAuthentication.entity.handler;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PasswordHandlerTest {
    @Test
    void handle() {
        PasswordHandler handler = PasswordHandlerFactory.getInstance();
        String username1 = "username1";
        String password1 = "password1";
        String username2 = "username2";
        String password2 = "password1";
        try {
            String result1 = handler.handle(username1, password1);
            String result2 = handler.handle(username2, password2);
            String result3 = handler.handle(username2, password2);
            assertNotEquals(result1, result2);
            assertEquals(result2, result3);
        }catch (Exception e){
            Assert.fail();
        }
    }
}
