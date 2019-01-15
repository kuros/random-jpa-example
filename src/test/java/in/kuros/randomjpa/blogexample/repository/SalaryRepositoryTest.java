package in.kuros.randomjpa.blogexample.repository;

import com.github.kuros.random.jpa.Database;
import com.github.kuros.random.jpa.JPAContext;
import com.github.kuros.random.jpa.JPAContextFactory;
import com.github.kuros.random.jpa.persistor.model.ResultMap;
import com.github.kuros.random.jpa.types.Entity;
import in.kuros.randomjpa.blogexample.entity.Salary;
import in.kuros.randomjpa.blogexample.entity.Salary_;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDate;
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

    @Test @Transactional
    public void shouldTestToFetchLatestSalaryRecordForMultipleEntry() {
        final JPAContext jpaContext = JPAContextFactory.newInstance(Database.MY_SQL, entityManager)
                .generate();

        final LocalDate oldFromDate = LocalDate.now().minusDays(2);
        final LocalDate oldToDate = LocalDate.now().minusDays(1);

        final LocalDate newFromDate = LocalDate.now();
        final LocalDate newToDate = LocalDate.now().plusDays(1);


        final ResultMap resultMap = jpaContext.createAndPersist(
                Entity.of(Salary.class, 2)
                        .with(0, Salary_.fromDate, oldFromDate)
                        .with(0, Salary_.toDate, oldToDate)
                        .with(1, Salary_.fromDate, newFromDate)
                        .with(1, Salary_.toDate, newToDate));

        resultMap.print(System.out::println); //just for debugging

        final Salary salary1 = resultMap.get(Salary.class, 0);
        final Salary salary2 = resultMap.get(Salary.class, 1);

        final List<Salary> latestSalaries = salaryRepository.findLatestSalaries();

        final Optional<Salary> result = latestSalaries
                .stream()
                .filter(sal -> sal.getEmployeeId().equals(salary1.getEmployeeId())).findFirst();

        Assert.assertTrue(result.isPresent());

        Assert.assertEquals("", salary2.getId(), result.get().getId());
        Assert.assertEquals(salary2.getSalary(), result.get().getSalary());
        Assert.assertEquals(salary2.getFromDate(), result.get().getFromDate());
        Assert.assertEquals(salary2.getToDate(), result.get().getToDate());
    }
}
