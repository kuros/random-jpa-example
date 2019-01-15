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
@Table(name = "salaries")
public class Salary {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "emp_no")
    private Integer employeeId;

    @Basic
    @Column(name = "salary")
    private Integer salary;

    @Basic
    @Column(name = "from_date")
    private LocalDate fromDate;

    @Basic
    @Column(name = "to_date")
    private LocalDate toDate;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(final Integer salary) {
        this.salary = salary;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(final Integer employeeId) {
        this.employeeId = employeeId;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(final LocalDate fromDate) {
        this.fromDate = fromDate;
    }


    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(final LocalDate toDate) {
        this.toDate = toDate;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Salary sal = (Salary) o;

        if (id != null ? !id.equals(sal.id) : sal.id != null) return false;
        if (this.salary != null ? !this.salary.equals(sal.salary) : sal.salary != null) return false;
        if (fromDate != null ? !fromDate.equals(sal.fromDate) : sal.fromDate != null) return false;
        if (toDate != null ? !toDate.equals(sal.toDate) : sal.toDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        result = 31 * result + (fromDate != null ? fromDate.hashCode() : 0);
        result = 31 * result + (toDate != null ? toDate.hashCode() : 0);
        return result;
    }
}
