package family.dd.DDHomeKits.AuthCenter.member;

import family.dd.DDHomeKits.AuthCenter.AuthCenterApplication;
import family.dd.DDHomeKits.AuthCenter.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
}
