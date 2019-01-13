package in.kuros.randomjpa.blogexample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogExampleApplicationTests {

    @Autowired private EntityManager entityManager;

    @Test @Transactional
    public void contextLoads() {

    }

}

