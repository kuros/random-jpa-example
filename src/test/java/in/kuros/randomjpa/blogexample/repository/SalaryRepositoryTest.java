package in.kuros.randomjpa.blogexample.repository;

import com.github.kuros.random.jpa.Database;
import com.github.kuros.random.jpa.JPAContext;
import com.github.kuros.random.jpa.JPAContextFactory;
import com.github.kuros.random.jpa.persistor.model.ResultMap;
import com.github.kuros.random.jpa.types.Entity;
import in.kuros.randomjpa.blogexample.entity.Salary;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SalaryRepositoryTest {

    @Autowired private EntityManager entityManager;
    @Autowired private SalaryRepository salaryRepository;

    @Test @Transactional
    public void shouldTestForFetchingSalaryRecordForOnlyOneEntry() {
        final JPAContext jpaContext = JPAContextFactory.newInstance(Database.MY_SQL, entityManager)
                .generate();

        final ResultMap resultMap = jpaContext.createAndPersist(Entity.of(Salary.class));
        resultMap.print(System.out::println);

        final Salary salary = resultMap.get(Salary.class);

        final List<Salary> latestSalaries = salaryRepository.findLatestSalaries();

        final Optional<Salary> result = latestSalaries
                .stream()
                .filter(sal -> sal.getId().equals(salary.getId())).findFirst();

        Assert.assertTrue(result.isPresent());
        Assert.assertEquals(salary.getSalary(), result.get().getSalary());
        Assert.assertEquals(salary.getFromDate(), result.get().getFromDate());
        Assert.assertEquals(salary.getToDate(), result.get().getToDate());
    }
}
