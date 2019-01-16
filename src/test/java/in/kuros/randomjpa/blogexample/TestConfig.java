package in.kuros.randomjpa.blogexample;

import com.github.kuros.random.jpa.Database;
import com.github.kuros.random.jpa.JPAContext;
import com.github.kuros.random.jpa.JPAContextFactory;
import com.github.kuros.random.jpa.link.Dependencies;
import com.github.kuros.random.jpa.link.Link;
import in.kuros.randomjpa.blogexample.entity.EmployeeInventoryAudit_;
import in.kuros.randomjpa.blogexample.entity.Employee_;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class TestConfig {

    @Autowired private EntityManager entityManager;

    @Bean
    public JPAContext createJpaContext() {
        return JPAContextFactory
                .newInstance(Database.MY_SQL, entityManager)
                .with(getDependencies())
                .generate();
    }

    private Dependencies getDependencies() {
        final Dependencies dependencies = Dependencies.newInstance();
        dependencies.withLink(Link.newLink(EmployeeInventoryAudit_.employeeNumber, Employee_.empNo));

        return dependencies;
    }
}
