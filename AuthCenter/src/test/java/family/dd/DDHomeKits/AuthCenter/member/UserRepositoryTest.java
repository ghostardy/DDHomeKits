package family.dd.DDHomeKits.AuthCenter.member;

import family.dd.DDHomeKits.AuthCenter.AuthCenterApplication;
import family.dd.DDHomeKits.AuthCenter.domain.UserAuthentication.repository.UserIdentityPO;
import family.dd.DDHomeKits.AuthCenter.domain.UserAuthentication.entity.UserStatus;
import family.dd.DDHomeKits.AuthCenter.domain.UserAuthentication.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AuthCenterApplication.class)
class UserRepositoryTest {
    @Autowired
    UserRepository repository;

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
        UserIdentityPO userInfo = new UserIdentityPO(testUsername, testPassword);
        userInfo.setAuthority(testAuthority);
        userInfo.setStatus(testUserStatus);
        userInfo.setUserId(999); //no use
        /**
         * Delete test data if exists
         */
        repository.removeByUsername(testUsername);
        List<UserIdentityPO> users = repository.find(testUsername, testPassword);
        assertEquals(0, users.size());
        /**
         * Test addUserInfo & getUserInfo(username)
         */
        repository.add(userInfo);
        users = repository.find(testUsername, testPassword);
        assertEquals(1, users.size());
        assertEquals(testAuthority, users.get(0).getAuthority());
        assertEquals(1610612751L, users.get(0).getAuthority());
        assertEquals(testUserStatus, users.get(0).getStatus());
        assertEquals("", users.get(0).getPassword());
        /**
         * Test getUserInfo(userId)
         */
        users = repository.find(users.get(0).getUserId());
        assertEquals(1, users.size());
        assertEquals(testAuthority, users.get(0).getAuthority());
        assertEquals(1610612751L, users.get(0).getAuthority());
        assertEquals(testUserStatus, users.get(0).getStatus());
        assertEquals("", users.get(0).getPassword());
        /**
         * Clear Test Data
         */
        repository.removeByUsername(testUsername);
        users = repository.find(testUsername, testPassword);
        assertEquals(0, users.size());
    }
}
