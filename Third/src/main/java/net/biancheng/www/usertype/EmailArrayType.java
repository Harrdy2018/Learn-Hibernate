package net.biancheng.www.usertype;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.type.StringType;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmailArrayType implements UserType {
    private static final String SPLITTER = ";";

    private static final int[] TYPES = new int[]{Types.VARCHAR};

    @Override
    public int[] sqlTypes() {
        return TYPES;
    }

    @Override
    public Class returnedClass() {
        System.out.println("returnedClass ...");
        return List.class;
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        System.out.println("equals ...");
        if(x == y){
            return true;
        }

        if(x != null && y != null){
            List xList = (List)x;
            List yList = (List)y;

            if(xList.size() != yList.size()){
                return false;
            }
            for(int index = 0; index < xList.size(); index++){
                String str1 = (String) xList.get(index);
                String str2 = (String) yList.get(index);
                if(str1 != str2){
                    return false;
                }
            }

            return true;
        }

        return false;
    }

    @Override
    public int hashCode(Object o) throws HibernateException {
        System.out.println("hashCode ...");
        return 0;
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor ssci, Object value) throws HibernateException, SQLException {
        System.out.println("nullSafeGet ...");
        String res = (String) StringType.INSTANCE.nullSafeGet(rs, names[0], ssci, value);
        String temp[]=res.split(SPLITTER);
        List<String> emailLists = new ArrayList<>();
        Arrays.stream(temp).forEach(x->{
            emailLists.add(x);
        });
        return emailLists;
    }

    @Override
    public void nullSafeSet(PreparedStatement pst, Object value, int i, SharedSessionContractImplementor ssci) throws HibernateException, SQLException {
        List<String> emailList = (List<String>)value;
        StringBuffer strBuf = new StringBuffer();
        for(int j=0;j<emailList.size()-1;j++){
            strBuf.append(emailList.get(j)).append(SPLITTER);
        }
        strBuf.append(emailList.get(emailList.size() - 1));
        String valueToStore = strBuf.toString();
        StringType.INSTANCE.nullSafeSet(pst, valueToStore, i, ssci);
    }

    @Override
    public Object deepCopy(Object value) throws HibernateException {
        System.out.println("deepCopy ...");
        List sourceList = (List) value;
        List targetList = new ArrayList();
        targetList.addAll(sourceList);
        return targetList;
    }

    @Override
    public boolean isMutable() {
        System.out.println("isMutable ...");
        return false;
    }

    @Override
    public Serializable disassemble(Object o) throws HibernateException {
        System.out.println("disassemble ...");
        return (Serializable) o;
    }

    @Override
    public Object assemble(Serializable serializable, Object value) throws HibernateException {
        System.out.println("assemble ...");
        return serializable;
    }

    @Override
    public Object replace(Object original, Object target, Object o2) throws HibernateException {
        System.out.println("replace ...");
        return original;
    }
}
