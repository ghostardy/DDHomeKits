package family.dd.DDHomeKits.AuthenticationCenter.member;

import family.dd.DDHomeKits.AuthenticationCenter.AuthenticationCenterApplication;
import family.dd.DDHomeKits.AuthenticationCenter.definition.ResponseCode;
import family.dd.DDHomeKits.AuthenticationCenter.domain.FamilyMember;
import family.dd.DDHomeKits.AuthenticationCenter.dao.HandleResult;
import family.dd.DDHomeKits.AuthenticationCenter.dao.UserInfo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AuthenticationCenterApplication.class)
class FamilyMemberTest {
    @Autowired
    FamilyMember familyMember;
    @Test
    void signUp() {
        String username = "TestNewFamilyMember_ShouldBeDeleted";
        String password = "TestNewFamilyMember_ShouldBeDeleted";
        UserInfo newUser = new UserInfo(username, password);
        familyMember.getRepository().rmvUserInfo(newUser);

        HandleResult signUpResult = familyMember.singUp(newUser);
        assertEquals(ResponseCode.SUCCESS, signUpResult.getCode());
        System.out.println(signUpResult.getMessage());

        signUpResult = familyMember.singUp(newUser);
        assertEquals(ResponseCode.REQUEST_FAILURE, signUpResult.getCode());
        System.out.println(signUpResult.getMessage());

        HandleResult loginResult = familyMember.login(newUser);

        System.out.println(loginResult.getCode() + loginResult.getMessage());
        UserInfo fakeUser = new UserInfo(newUser);
        fakeUser.setPassword("FakePassword");
        loginResult = familyMember.login(fakeUser);
        System.out.println(loginResult.getCode() + loginResult.getMessage());

        familyMember.getRepository().rmvUserInfo(newUser);
    }
}
