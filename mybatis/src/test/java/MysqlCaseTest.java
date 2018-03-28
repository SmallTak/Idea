import org.junit.Test;

import java.sql.*;

public class MysqlCaseTest {

    @Test
    public void testTransaction(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql:///kaishengit_db","root","root");
            conn.setAutoCommit(false);
            String sql = "delete from t_stu where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,39);
            ps.executeUpdate();

            //设置保留点
            Savepoint save = conn.setSavepoint("s1");
            String sqla = "delete from t_stu where id = ?";
            PreparedStatement psa = conn.prepareStatement(sqla);
            psa.setInt(1,40);
            psa.executeUpdate();

            conn.rollback(save);
            conn.commit();
            ps.close();
            conn.close();

        }catch (Exception e){
            e.printStackTrace();
        }
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
            rs.close();
            ps.close();
            conn.close();
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
            rs.close();
            callableStatement.close();
            conn.close();
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

            callableStatement.close();
            conn.close();
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
            call.close();
            conn.close();
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

            call.close();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
