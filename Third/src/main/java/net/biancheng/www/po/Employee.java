package net.biancheng.www.po;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter(value = AccessLevel.PUBLIC) // 生成的get方法全是public修饰的
@Setter(value = AccessLevel.PUBLIC) // 生成的set方法全是public修饰的
@ToString
@Entity
@Table(name = "tbl_employee")
public class Employee {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "birth", nullable = false)
    @Temporal(value = TemporalType.DATE)
    private Date birth;

    @Column(name = "salary", nullable = false)
    private Double salary;
}
