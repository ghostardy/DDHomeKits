package family.dd.DDHomeKits.member;

import family.dd.DDHomeKits.DDHomeKitsApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DDHomeKitsApplication.class)
class FamilyMemberRepositoryTest {
    @Autowired
    FamilyMemberRepository repository;

    @Test
    void getUserInfo() {
        assertEquals(new ArrayList(), repository.getUserInfo(1));
    }
}
