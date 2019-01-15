package in.kuros.randomjpa.blogexample.repository;

import in.kuros.randomjpa.blogexample.entity.Salaries;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "salary", path = "salary")
public interface SalaryRepository extends PagingAndSortingRepository<Salaries, Integer> {

    @RestResource(path = "latest")
    @Query("FROM Salaries s WHERE NOT EXISTS (select 1 FROM Salaries s2 WHERE s.employeeId = s2.employeeId and s2.fromDate < s.fromDate and s2.toDate < s.toDate) ")
    List<Salaries> findLatestSalaries();
}
