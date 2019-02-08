package lists;

import javabeans.SmallType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SmallTypeList {

    public List<SmallType> queryAll(String bigId){
        List<SmallType> list = new ArrayList<>();

        DBConn dbConn=new DBConn();
        Connection conn = dbConn.getConnection();
        String sql = "select * from smalltype where bigTypeId = "+bigId;
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                SmallType st = new SmallType();
                st.setBigTypeId(rs.getInt("bigTypeId"));
                st.setSmallTyped(rs.getInt("smallTypeId"));
                st.setSmallTypeName(rs.getString("smallTypeName"));
                list.add(st);
            }
            rs.close();
            pstmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
