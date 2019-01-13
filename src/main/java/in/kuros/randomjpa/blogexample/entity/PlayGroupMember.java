package in.kuros.randomjpa.blogexample.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "play_group_member")
public class PlayGroupMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "member_id")
    private Integer memberId;

    @Basic
    @Column(name = "member_type")
    private String memberType;


    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(final Integer memberId) {
        this.memberId = memberId;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(final String memberType) {
        this.memberType = memberType;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final PlayGroupMember that = (PlayGroupMember) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (memberId != null ? !memberId.equals(that.memberId) : that.memberId != null) return false;
        if (memberType != null ? !memberType.equals(that.memberType) : that.memberType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (memberId != null ? memberId.hashCode() : 0);
        result = 31 * result + (memberType != null ? memberType.hashCode() : 0);
        return result;
    }
}
