package in.kuros.randomjpa.blogexample.repository;

import com.github.kuros.random.jpa.Database;
import com.github.kuros.random.jpa.JPAContext;
import com.github.kuros.random.jpa.JPAContextFactory;
import com.github.kuros.random.jpa.persistor.model.ResultMap;
import com.github.kuros.random.jpa.types.Entity;
import in.kuros.randomjpa.blogexample.entity.Salaries;
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

        final ResultMap resultMap = jpaContext.createAndPersist(Entity.of(Salaries.class));
        resultMap.print(System.out::println);

        final Salaries salaries = resultMap.get(Salaries.class);

        final List<Salaries> latestSalaries = salaryRepository.findLatestSalaries();

        final Optional<Salaries> result = latestSalaries
                .stream()
                .filter(sal -> sal.getId().equals(salaries.getId())).findFirst();

        Assert.assertTrue(result.isPresent());
        Assert.assertEquals(salaries.getSalary(), result.get().getSalary());
        Assert.assertEquals(salaries.getFromDate(), result.get().getFromDate());
        Assert.assertEquals(salaries.getToDate(), result.get().getToDate());
    }
}
