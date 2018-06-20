import org.junit.Test;

import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class test {

    @Test
    public void test() throws SQLException, ClassNotFoundException {

        final String url ="jdbc:mysql://127.0.0.1/teacher";

        final String user ="root";

        final String password ="root";

        Connection conn =null;

        Class.forName("com.mysql.jdbc.Driver");

        conn = DriverManager.getConnection(url, user, password);//获取连接

        if(conn!=null) {

            System.out.println("获取连接成功");

            insert(conn);

        }else{

            System.out.println("获取连接失败");

        }

    }


    private static void insert(Connection conn) {

        // 开始时间

        Long begin =new Date().getTime();

        // sql前缀

        String prefix ="INSERT INTO t_teacher (id,t_name,t_password,sex,description,pic_url,school_name,regist_date,remark) VALUES ";

        try{

            // 保存sql后缀

            StringBuffer suffix =new StringBuffer();

            // 设置事务为非自动提交

            conn.setAutoCommit(false);

            // 比起st，pst会更好些
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement("");//准备执行语句

            // 外层循环，总提交事务次数

            for(int i =1; i <=100; i++) {

                suffix =new StringBuffer();

                // 第j次提交步长

                for(int j =1; j <=100000; j++) {

                    // 构建SQL后缀
                    suffix.append("('"+ j +"','"+i*j+"','123456'"+",'男'"+",'教师'"+",'www.bbk.com'"+",'XX大学'"+",'"+"2016-08-12 14:43:26"+"','备注'"+"),");

                }

                // 构建完整SQL

                String sql = prefix + suffix.substring(0, suffix.length() -1);

                // 添加执行SQL

                pst.addBatch(sql);

                // 执行操作

                pst.executeBatch();

                // 提交事务

                conn.commit();

                // 清空上一次添加的数据

                suffix =new StringBuffer();

            }

            // 头等连接

            pst.close();

            conn.close();

        }catch(SQLException e) {

            e.printStackTrace();

        }

        // 结束时间

        Long end =new Date().getTime();

        // 耗时

        System.out.println("1000万条数据插入花费时间 : "+ (end - begin) /1000+" s");

        System.out.println("插入完成");

    }



}
