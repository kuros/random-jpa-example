package in.kuros.randomjpa.blogexample.repository;

import in.kuros.randomjpa.blogexample.entity.Salary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "salary", path = "salary")
public interface SalaryRepository extends PagingAndSortingRepository<Salary, Integer> {

    @RestResource(path = "latest")
    @Query("FROM Salary s WHERE NOT EXISTS (select 1 FROM Salary s2 WHERE s.employeeId = s2.employeeId and s.fromDate < s2.fromDate and s.toDate < s2.toDate) ")
    List<Salary> findLatestSalaries();
}
