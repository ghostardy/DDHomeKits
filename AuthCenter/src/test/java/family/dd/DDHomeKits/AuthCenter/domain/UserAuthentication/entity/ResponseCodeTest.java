package family.dd.DDHomeKits.AuthCenter.domain.UserAuthentication.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResponseCodeTest {

    @Test
    void getCodeValue() {
        assertEquals(100, ResponseCode.HANDLING.getCodeValue());
        assertEquals(200, ResponseCode.SUCCESS.getCodeValue());
        assertEquals(400, ResponseCode.REQUEST_FAILURE.getCodeValue());
        assertEquals(401, ResponseCode.REQUEST_UNAUTHORIZED.getCodeValue());
        assertEquals(403, ResponseCode.REQUEST_FORBIDDEN.getCodeValue());
        assertEquals(500, ResponseCode.SERVER_ERROR.getCodeValue());
        assertEquals(999, ResponseCode.UNKNOWN.getCodeValue());

    }
}