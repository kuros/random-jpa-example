package in.kuros.randomjpa.blogexample.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Departments {

    @Id
    @Column(name = "dept_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer deptNo;

    @Basic
    @Column(name = "dept_name")
    private String deptName;

    public Integer getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(final Integer deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(final String deptName) {
        this.deptName = deptName;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Departments that = (Departments) o;

        if (deptNo != null ? !deptNo.equals(that.deptNo) : that.deptNo != null) return false;
        if (deptName != null ? !deptName.equals(that.deptName) : that.deptName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = deptNo != null ? deptNo.hashCode() : 0;
        result = 31 * result + (deptName != null ? deptName.hashCode() : 0);
        return result;
    }
}
