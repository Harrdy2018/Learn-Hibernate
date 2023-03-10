package net.biancheng.www.po;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
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

@Getter(value = AccessLevel.PUBLIC) // 生成的get方法全是public修饰的
@Setter(value = AccessLevel.PUBLIC) // 生成的set方法全是public修饰的
@ToString
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
}
