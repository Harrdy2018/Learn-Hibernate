package net.biancheng.www.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 根据数据库表自定义主键生成策略

 DROP TABLE IF EXISTS `jpa_id_generators`;
 CREATE TABLE `jpa_id_generators` (
 `id` int NOT NULL AUTO_INCREMENT,
 `pk_name` varchar(255) DEFAULT NULL,
 `pk_value` int not null,
 PRIMARY KEY (`id`)
 ) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

 INSERT INTO `jpa_id_generators` VALUES (0, 'student_id', 1);
 */
@Entity
@Table(name = "tbl_stu")
public class Student {
    @TableGenerator(
            name = "id_generator",
            table = "jpa_id_generators",
            pkColumnName = "pk_name",
            pkColumnValue = "student_id",
            valueColumnName = "pk_value",
            initialValue = 9,
            allocationSize = 100
    )
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "id_generator")
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

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
}
