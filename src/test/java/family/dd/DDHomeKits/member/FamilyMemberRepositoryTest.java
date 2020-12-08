package family.dd.DDHomeKits.member;

import family.dd.DDHomeKits.DDHomeKitsApplication;
import family.dd.DDHomeKits.definition.UserStatus;
import family.dd.DDHomeKits.entity.UserInfo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DDHomeKitsApplication.class)
class FamilyMemberRepositoryTest {
    @Autowired
    FamilyMemberRepository repository;

    @Test
    void getUserInfo() {
        /**
         * Test Data
         */
        final String testUsername = "TestUserAA1234567890123456789012345678901234567890";
        final String testPassword = "TestPassword1234567890123456789012345678901234567890";
        final long testAuthority = 1610612751L;
        final String testNickName = "TesterNickNameAAAAAA123456789012345678901234567890";
        final UserStatus testUserStatus = UserStatus.FREEZE_UP;
        UserInfo userInfo = new UserInfo(testUsername, testPassword);
        userInfo.setAuthority(testAuthority);
        userInfo.setNickName(testNickName);
        userInfo.setStatus(testUserStatus);
        userInfo.setUserId(999); //no use
        /**
         * Delete test data if exists
         */
        repository.rmvUserInfo(userInfo);
        List<UserInfo> users = repository.getUserInfo(testUsername, testPassword);
        assertEquals(0, users.size());
        /**
         * Test addUserInfo & getUserInfo(username)
         */
        repository.addUserInfo(userInfo);
        users = repository.getUserInfo(testUsername, testPassword);
        assertEquals(1, users.size());
        assertEquals(testAuthority, users.get(0).getAuthority());
        assertEquals(1610612751L, users.get(0).getAuthority());
        assertEquals(testNickName, users.get(0).getNickName());
        assertEquals(testUserStatus, users.get(0).getStatus());
        assertEquals("", users.get(0).getPassword());
        /**
         * Test getUserInfo(userId)
         */
        users = repository.getUserInfo(users.get(0).getUserId());
        assertEquals(1, users.size());
        assertEquals(testAuthority, users.get(0).getAuthority());
        assertEquals(1610612751L, users.get(0).getAuthority());
        assertEquals(testNickName, users.get(0).getNickName());
        assertEquals(testUserStatus, users.get(0).getStatus());
        assertEquals("", users.get(0).getPassword());
        /**
         * Clear Test Data
         */
        repository.rmvUserInfo(userInfo);
        users = repository.getUserInfo(testUsername, testPassword);
        assertEquals(0, users.size());
    }
}
