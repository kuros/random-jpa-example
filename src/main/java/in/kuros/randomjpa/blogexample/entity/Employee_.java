package in.kuros.randomjpa.blogexample.entity;

import in.kuros.randomjpa.blogexample.type.Gender;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.time.LocalDate;

@StaticMetamodel(Employee.class)
public class Employee_ {

    public static volatile SingularAttribute<Employee, Integer> empNo;
    public static volatile SingularAttribute<Employee, LocalDate> birthDate;
    public static volatile SingularAttribute<Employee, String> firstName;
    public static volatile SingularAttribute<Employee, String> lastName;
    public static volatile SingularAttribute<Employee, Gender> gender;
    public static volatile SingularAttribute<Employee, LocalDate> hireDate;

}
