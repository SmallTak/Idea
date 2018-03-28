import org.apache.ibatis.jdbc.SQL;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.security.spec.ECField;
import java.sql.*;
import java.util.Collection;

public class MysqlCaseTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testJDBC(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql:///kaishengit_db","root","root");
            String sql = "select * from products where prod_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,"ANV02");
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                System.out.println(rs.getString("prod_name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testPro1(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql:///kaishengit_db","root","root");
            String sql = "{call p_1}";
            CallableStatement callableStatement = conn.prepareCall(sql);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString("prod_name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void testPro2(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql:///kaishengit_db","root","root");
            String sql = "{call p(?,?)}";
            CallableStatement callableStatement = conn.prepareCall(sql);
            callableStatement.registerOutParameter(1,Types.DECIMAL);
            callableStatement.registerOutParameter(2,Types.DECIMAL);
            callableStatement.executeUpdate();
            float max = callableStatement.getFloat(1);
            float min = callableStatement.getFloat(2);
            System.out.println(max);
            System.out.println(min);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void testPro3(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql:///kaishengit_db","root","root");
            String sql = "{call pq(?,?)}";
            CallableStatement call = conn.prepareCall(sql);
            call.setString(1,"ANV02");
            call.registerOutParameter(2,Types.DECIMAL);
            call.executeUpdate();
            float price = call.getFloat(2);
            System.out.println(price);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void textHomeWork(){
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql:///kaishengit_db","root","root");
            String sql = "{call test(?,?,?)}";
            CallableStatement call = conn.prepareCall(sql);
            call.setString(1,"ANV02");
            call.setFloat(2,11.4F);
            call.registerOutParameter(3,Types.INTEGER);
            call.executeUpdate();
            int num = call.getInt(3);
            System.out.println("价格小于10$:" + num);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
