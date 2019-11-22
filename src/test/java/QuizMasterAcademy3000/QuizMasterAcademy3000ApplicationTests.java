package QuizMasterAcademy3000;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuizMasterAcademy3000ApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void nextQuestionNew() throws ExecutionException {
        Repository sut = new Repository();
        int i = sut.getQuestionList().size();
        Assert.assertEquals(3, i);
    }
}
