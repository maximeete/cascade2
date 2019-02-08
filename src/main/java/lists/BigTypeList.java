package lists;

import java.util.*;
import java.sql.*;
import javabeans.BigType;

public class BigTypeList {

    public List<BigType> queryAll()throws Exception{
        List<BigType> list=new ArrayList<BigType>();
        DBConn db=new DBConn();
        Connection conn=db.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql="select * from bigType";
        ps=conn.prepareStatement(sql);
        rs=ps.executeQuery();
        while(rs.next()){
            BigType big=new BigType();
            big.setBigTypeId(rs.getInt("bigTypeId"));
            big.setBigTypeName(rs.getString("bigTypeName"));
            list.add(big);
        }
        rs.close();
        ps.close();
        conn.close();
        return list;
    }
}
