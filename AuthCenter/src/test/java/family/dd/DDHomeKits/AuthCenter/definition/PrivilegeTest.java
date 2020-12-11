package family.dd.DDHomeKits.AuthCenter.definition;

import org.junit.jupiter.api.Test;

import static family.dd.DDHomeKits.AuthCenter.definition.Privilege.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PrivilegeTest {

    @Test
    void toLongValue() {
        assertEquals(0L, Privilege.toLongValue());
        assertEquals(1L, Privilege.toLongValue(LOG_IN));
        assertEquals(2L, Privilege.toLongValue(USER_MANAGE));
        assertEquals(536870912L, Privilege.toLongValue(SYSTEM_ADMIN));
        assertEquals(1073741824L, Privilege.toLongValue(EXTENSION));
        assertEquals(1610612739L, Privilege.toLongValue(LOG_IN,USER_MANAGE,SYSTEM_ADMIN,EXTENSION));
    }

    @Test
    void hasPermission() {
        assertEquals(true, Privilege.hasPermission(1610612739L, LOG_IN, USER_MANAGE, SYSTEM_ADMIN, EXTENSION));
        assertEquals(false, Privilege.hasPermission(0, LOG_IN));
        assertEquals(false, Privilege.hasPermission(0, USER_MANAGE));
        assertEquals(false, Privilege.hasPermission(0, SYSTEM_ADMIN));
        assertEquals(false, Privilege.hasPermission(0, EXTENSION));
    }
}
