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
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import java.util.Date;

@MappedSuperclass // 类级别注解，该类所拥有的属性都会加入到子类的数据表的列中
@Getter
@Setter
class BaseEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "create_time")
    private Date createTime;
}

@Getter(value = AccessLevel.PUBLIC) // 生成的get方法全是public修饰的
@Setter(value = AccessLevel.PUBLIC) // 生成的set方法全是public修饰的
@ToString
@Entity
@Table(name = "tbl_person")
public class Person extends BaseEntity{
    private String name;

    private String email;
}

/*
create table tbl_person (
       id bigint not null,
        create_time datetime(6),
        email varchar(255),
        name varchar(255),
        primary key (id)
    ) engine=InnoDB
*/
