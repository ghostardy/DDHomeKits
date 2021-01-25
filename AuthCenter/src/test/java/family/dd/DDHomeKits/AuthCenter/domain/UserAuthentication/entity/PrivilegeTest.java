package family.dd.DDHomeKits.AuthCenter.domain.UserAuthentication.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrivilegeTest {

    @Test
    void toLongValue() {
        assertEquals(0L, Privilege.toLongValue());
        Assertions.assertEquals(1L, Privilege.toLongValue(Privilege.LOG_IN));
        Assertions.assertEquals(2L, Privilege.toLongValue(Privilege.USER_MANAGE));
        Assertions.assertEquals(536870912L, Privilege.toLongValue(Privilege.SYSTEM_ADMIN));
        Assertions.assertEquals(1073741824L, Privilege.toLongValue(Privilege.EXTENSION));
        assertEquals(1610612739L, Privilege.toLongValue(Privilege.LOG_IN, Privilege.USER_MANAGE, Privilege.SYSTEM_ADMIN, Privilege.EXTENSION));
    }

    @Test
    void hasPermission() {
        assertEquals(true, Privilege.hasPermission(1610612739L, Privilege.LOG_IN, Privilege.USER_MANAGE, Privilege.SYSTEM_ADMIN, Privilege.EXTENSION));
        assertEquals(false, Privilege.hasPermission(0, Privilege.LOG_IN));
        assertEquals(false, Privilege.hasPermission(0, Privilege.USER_MANAGE));
        assertEquals(false, Privilege.hasPermission(0, Privilege.SYSTEM_ADMIN));
        assertEquals(false, Privilege.hasPermission(0, Privilege.EXTENSION));
    }
}
