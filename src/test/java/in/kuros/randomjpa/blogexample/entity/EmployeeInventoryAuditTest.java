package in.kuros.randomjpa.blogexample.entity;

import com.github.kuros.random.jpa.JPAContext;
import com.github.kuros.random.jpa.persistor.model.ResultMap;
import com.github.kuros.random.jpa.types.Entity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeInventoryAuditTest {

    @Autowired private JPAContext jpaContext;

    @Test @Transactional
    public void createEmployeeInventoryAudit() {

        final ResultMap resultMap = jpaContext.createAndPersist(Entity.of(EmployeeInventoryAudit.class));

        resultMap.print(System.out::println);

    }
}
