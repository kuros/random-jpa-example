package in.kuros.randomjpa.blogexample.repository;

import in.kuros.randomjpa.blogexample.entity.Employees;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "employee", path = "employee")
public interface EmployeeRepository extends PagingAndSortingRepository<Employees, Integer> {
}
