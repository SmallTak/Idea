import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OracleJdbcTest {

    @Test
    public void testOracleJdbc(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:ORCL","tak","123123");
            String sql = "select * from t_stu where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,3);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                System.out.println(rs.getString("name"));
            }
        }catch (Exception e) {

        }

    }

}
