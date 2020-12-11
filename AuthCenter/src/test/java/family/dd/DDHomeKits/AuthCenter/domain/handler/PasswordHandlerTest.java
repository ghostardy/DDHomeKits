package family.dd.DDHomeKits.AuthCenter.domain.handler;

import family.dd.DDHomeKits.AuthCenter.dao.IdentificationPO;
import family.dd.DDHomeKits.AuthCenter.definition.ResponseCode;
import family.dd.DDHomeKits.AuthCenter.dao.HandleResult;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PasswordHandlerTest {
    @Test
    void handle() {
        PasswordHandler handler = PasswordHandlerFactory.getInstance();
        IdentificationPO userInfo1 = new IdentificationPO("username", "password");
        IdentificationPO userInfo2 = new IdentificationPO("username1", "password");
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
