package in.kuros.randomjpa.blogexample.entity;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.time.LocalDate;

@StaticMetamodel(Salary.class)
public class Salary_ {

    public static volatile SingularAttribute<Salary, Integer> id;
    public static volatile SingularAttribute<Salary, Integer> employeeId;
    public static volatile SingularAttribute<Salary, Integer> salary;
    public static volatile SingularAttribute<Salary, LocalDate> fromDate;
    public static volatile SingularAttribute<Salary, LocalDate> toDate;

}
