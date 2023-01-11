package net.biancheng.www.po;

import net.biancheng.www.usertype.EmailArrayType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "tbl_emailuser")
@TypeDefs(value = {
        @TypeDef(name = "string-list", typeClass = EmailArrayType.class),
})
public class EmailUser {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Type(type = "string-list")
    @Column(name = "email_list", nullable = false, columnDefinition = "varchar(1000) NOT NULL COMMENT 'email网址集合'")
    private List<String> emailList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getEmailList() {
        return emailList;
    }

    public void setEmailList(List<String> emailList) {
        this.emailList = emailList;
    }

    @Override
    public String toString() {
        return "EmailUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", emailList=" + emailList +
                '}';
    }
}
