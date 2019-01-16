package in.kuros.randomjpa.blogexample.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "employee_inventory_audit")
public class EmployeeInventoryAudit {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "emp_no")
    private Integer employeeNumber;

    @Basic
    @Column(name = "inventory")
    private String inventory;

    @Basic
    @Column(name = "quantity")
    private Integer quantity;

    @Basic
    @Column(name = "purchase_date")
    private LocalDate purchaseDate;


    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public Integer getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(final Integer employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getInventory() {
        return inventory;
    }

    public void setInventory(final String inventory) {
        this.inventory = inventory;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(final Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(final LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final EmployeeInventoryAudit that = (EmployeeInventoryAudit) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (employeeNumber != null ? !employeeNumber.equals(that.employeeNumber) : that.employeeNumber != null)
            return false;
        if (inventory != null ? !inventory.equals(that.inventory) : that.inventory != null) return false;
        if (quantity != null ? !quantity.equals(that.quantity) : that.quantity != null) return false;
        if (purchaseDate != null ? !purchaseDate.equals(that.purchaseDate) : that.purchaseDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (employeeNumber != null ? employeeNumber.hashCode() : 0);
        result = 31 * result + (inventory != null ? inventory.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (purchaseDate != null ? purchaseDate.hashCode() : 0);
        return result;
    }
}
