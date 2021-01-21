package family.dd.DDHomeKits.AuthCenter.domain.UserAuthentication.definition;

import family.dd.DDHomeKits.AuthCenter.domain.UserAuthentication.entity.UserStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserStatusTest {

    @Test
    void getStatusCode() {
        assertEquals(0, UserStatus.valueOf("PREPARED").getStatusCode());
        assertEquals(1, UserStatus.INITIALIZED.getStatusCode());
        assertEquals(2, UserStatus.FREEZE_UP.getStatusCode());
        assertEquals(3, UserStatus.NEED_RESET_PASSWORD.getStatusCode());
        assertEquals(9, UserStatus.DELETED.getStatusCode());
        assertEquals(99, UserStatus.UNKNOWN.getStatusCode());
    }
}
