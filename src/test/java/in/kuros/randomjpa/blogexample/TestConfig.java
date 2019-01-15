package in.kuros.randomjpa.blogexample;

import com.github.kuros.random.jpa.Database;
import com.github.kuros.random.jpa.JPAContext;
import com.github.kuros.random.jpa.JPAContextFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class TestConfig {

    @Autowired private EntityManager entityManager;

    @Bean
    public JPAContext createJpaContext() {
        return JPAContextFactory.newInstance(Database.MY_SQL, entityManager).generate();
    }
}
