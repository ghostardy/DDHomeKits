package family.dd.DDHomeKits.AuthCenter.definition;

import org.junit.jupiter.api.Test;

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
