package family.dd.DDHomeKits.AuthCenter.domain.UserAuthentication.entity;

import family.dd.DDHomeKits.AuthCenter.AuthCenterApplication;
import family.dd.DDHomeKits.AuthCenter.domain.UserAuthentication.UserAuthentication;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AuthCenterApplication.class)
class UserTest {
    @Autowired
    User user;
    @Test
    void signUp() {
//        String username = "TestNewFamilyMember_ShouldBeDeleted";
//        String password = "TestNewFamilyMember_ShouldBeDeleted";
//        UserIdentityPO newUser = new UserIdentityPO(username, password);
//        familyMember.getRepository().rmvUserInfo(newUser);
//
//        HandleResult signUpResult = familyMember.singUp(newUser);
//        assertEquals(ResponseCode.SUCCESS, signUpResult.getCode());
//        System.out.println(signUpResult.getMessage());
//
//        signUpResult = familyMember.singUp(newUser);
//        assertEquals(ResponseCode.REQUEST_FAILURE, signUpResult.getCode());
//        System.out.println(signUpResult.getMessage());
//
//        HandleResult loginResult = familyMember.login(newUser);
//
//        System.out.println(loginResult.getCode() + loginResult.getMessage());
//        UserIdentityPO fakeUser = new UserIdentityPO(newUser);
//        fakeUser.setPassword("FakePassword");
//        loginResult = familyMember.login(fakeUser);
//        System.out.println(loginResult.getCode() + loginResult.getMessage());
//
//        familyMember.getRepository().rmvUserInfo(newUser);
    }

    @Test
    void transPassword() {
        try {
            UserAuthentication ua = new UserAuthentication();
            assertEquals("94-12572-7611854-844-71107-62-1340-2771-73-29-378-43125-11211-46-91-122108-100-127-84-7635", ua.transPassword("username", "password"));
        }catch (Exception e){
            Assert.fail();
        }
    }
}
