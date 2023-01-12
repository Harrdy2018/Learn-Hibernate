package net.biancheng.www.usertype;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Arrays;

// mysql不支持插入数组，需要使用PostgreSQL数据库
public class StringArrayType implements UserType {
    @Override
    public int[] sqlTypes() {
        return new int[]{Types.ARRAY};
    }

    @Override
    public Class returnedClass() {
        return String[].class;
    }

    @Override
    public boolean equals(Object o1, Object o2) throws HibernateException {
        return o1 == null ? o2 == null : Arrays.equals((Object[])o1, (Object[])o2);
    }

    @Override
    public int hashCode(Object object) throws HibernateException {
        return object==null ? 0:object.hashCode();
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object value) throws HibernateException, SQLException {
        if (names != null && names.length>0 && rs != null) {
            Array array = rs.getArray(names[0]);
            if(array!=null){
                return array.getArray();
            }
        }
        return null;
    }

    @Override
    public void nullSafeSet(PreparedStatement ps, Object value, int index, SharedSessionContractImplementor session) throws HibernateException, SQLException {
        System.out.println("nullSafeSet ...");
        if(ps != null){
            if(value != null){
                String input[] = (String[])value;
                Array array = session.connection().createArrayOf("VARCHAR", input);
                ps.setArray(index, array);
            } else {
                ps.setNull(index, Types.ARRAY);
            }
        }
    }

    @Override
    public Object deepCopy(Object value) throws HibernateException {
        return value==null?null:((String[])value).clone();
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Object o) throws HibernateException {
        return (Serializable) o;
    }

    @Override
    public Object assemble(Serializable serializable, Object o) throws HibernateException {
        return serializable;
    }

    @Override
    public Object replace(Object original, Object target, Object o2) throws HibernateException {
        return original;
    }
}
