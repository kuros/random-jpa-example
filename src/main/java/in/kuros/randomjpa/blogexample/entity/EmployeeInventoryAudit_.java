package in.kuros.randomjpa.blogexample.entity;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.time.LocalDate;

@StaticMetamodel(EmployeeInventoryAudit.class)
public class EmployeeInventoryAudit_ {

    public static volatile SingularAttribute<EmployeeInventoryAudit, Integer> id;
    public static volatile SingularAttribute<EmployeeInventoryAudit, Integer> employeeNumber;
    public static volatile SingularAttribute<EmployeeInventoryAudit, String> inventory;
    public static volatile SingularAttribute<EmployeeInventoryAudit, Integer> quantity;
    public static volatile SingularAttribute<EmployeeInventoryAudit, LocalDate> purchaseDate;

}
