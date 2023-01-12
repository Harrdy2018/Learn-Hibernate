package net.biancheng.www.dialect;

import net.biancheng.www.usertype.StringArrayType;
import org.hibernate.dialect.MySQL57Dialect;

import java.sql.Types;

// 自定义数据库方言
public class MySQL57CustomDialect extends MySQL57Dialect {
    public MySQL57CustomDialect() {
        super();
        // 理解下面两种类型的意思
        this.registerHibernateType(Types.ARRAY, StringArrayType.class.getName());
        this.registerColumnType(Types.ARRAY, "text[]");
    }
}
