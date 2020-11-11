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
        System.out.println(Privilege.hasPermission(LOG_IN, 1));
        System.out.println(Privilege.hasPermission(LOG_IN, 2));
        System.out.println(Privilege.hasPermission(LOG_IN, 7));
        System.out.println(Privilege.hasPermission(LOG_IN, 127));
    }
}
