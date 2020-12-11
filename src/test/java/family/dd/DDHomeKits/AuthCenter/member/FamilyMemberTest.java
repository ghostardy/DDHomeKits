package family.dd.DDHomeKits.AuthCenter.member;

import family.dd.DDHomeKits.AuthCenter.AuthenticationCenterApplication;
import family.dd.DDHomeKits.AuthCenter.dao.IdentificationPO;
import family.dd.DDHomeKits.AuthCenter.definition.ResponseCode;
import family.dd.DDHomeKits.AuthCenter.domain.FamilyMember;
import family.dd.DDHomeKits.AuthCenter.dao.HandleResult;
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
        IdentificationPO newUser = new IdentificationPO(username, password);
        familyMember.getRepository().rmvUserInfo(newUser);

        HandleResult signUpResult = familyMember.singUp(newUser);
        assertEquals(ResponseCode.SUCCESS, signUpResult.getCode());
        System.out.println(signUpResult.getMessage());

        signUpResult = familyMember.singUp(newUser);
        assertEquals(ResponseCode.REQUEST_FAILURE, signUpResult.getCode());
        System.out.println(signUpResult.getMessage());

        HandleResult loginResult = familyMember.login(newUser);

        System.out.println(loginResult.getCode() + loginResult.getMessage());
        IdentificationPO fakeUser = new IdentificationPO(newUser);
        fakeUser.setPassword("FakePassword");
        loginResult = familyMember.login(fakeUser);
        System.out.println(loginResult.getCode() + loginResult.getMessage());

        familyMember.getRepository().rmvUserInfo(newUser);
    }
}