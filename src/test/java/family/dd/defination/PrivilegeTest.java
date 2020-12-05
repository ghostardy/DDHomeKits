package family.dd.defination;

import family.dd.defination.Privilege;
import org.junit.jupiter.api.Test;

import static family.dd.defination.Privilege.*;
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
        assertEquals(true, Privilege.hasPermission(1610612751L, LOG_IN, USER_MANAGE, METER_VIEW, METER_REPORT, SYSTEM_ADMIN, EXTENSION));
        assertEquals(false, Privilege.hasPermission(0, LOG_IN));
        assertEquals(false, Privilege.hasPermission(0, USER_MANAGE));
        assertEquals(false, Privilege.hasPermission(0, METER_VIEW));
        assertEquals(false, Privilege.hasPermission(0, METER_REPORT));
        assertEquals(false, Privilege.hasPermission(0, SYSTEM_ADMIN));
        assertEquals(false, Privilege.hasPermission(0, EXTENSION));
    }
}
