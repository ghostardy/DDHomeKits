package family.dd.member;

import org.junit.jupiter.api.Test;

import static family.dd.member.Privilege.*;
import static org.junit.jupiter.api.Assertions.*;

class PrivilegeTest {

    @Test
    void toLongValue() {
        assertEquals(0L, Privilege.toLongValue());
        assertEquals(1L, Privilege.toLongValue(LOG_IN));
        assertEquals(2L, Privilege.toLongValue(USER_MANAGE));
        assertEquals(4L, Privilege.toLongValue(METER_VIEW));
        assertEquals(8L, Privilege.toLongValue(METER_REPORT));
        assertEquals(536870912L, Privilege.toLongValue(SYSTEM_ADMIN));
        assertEquals(1073741824L, Privilege.toLongValue(EXTENSION));
        assertEquals(1610612751L, Privilege.toLongValue(LOG_IN,USER_MANAGE,METER_VIEW,METER_REPORT,SYSTEM_ADMIN,EXTENSION));
    }

    @Test
    void hasPermission() {
        assertEquals(true, Privilege.hasPermission(LOG_IN, 1610612751L));
        assertEquals(true, Privilege.hasPermission(USER_MANAGE, 1610612751L));
        assertEquals(true, Privilege.hasPermission(METER_VIEW, 1610612751L));
        assertEquals(true, Privilege.hasPermission(METER_REPORT, 1610612751L));
        assertEquals(true, Privilege.hasPermission(SYSTEM_ADMIN, 1610612751L));
        assertEquals(true, Privilege.hasPermission(EXTENSION, 1610612751L));
        assertEquals(false, Privilege.hasPermission(LOG_IN, 2));
        assertEquals(false, Privilege.hasPermission(USER_MANAGE, 1));
        assertEquals(false, Privilege.hasPermission(METER_VIEW, 1));
        assertEquals(false, Privilege.hasPermission(METER_REPORT, 1));
        assertEquals(false, Privilege.hasPermission(SYSTEM_ADMIN, 1));
        assertEquals(false, Privilege.hasPermission(EXTENSION, 1));
    }
}
