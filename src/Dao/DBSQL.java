package Dao;

import DB.DBUtil;
import Pojo.USER;

import java.sql.*;

/**
 * Created by Administrator on 2018/4/23.
 */
public class DBSQL
{
    private static Connection conn=DBUtil.connGet();
    private static ResultSet rs=null;
    private static PreparedStatement ps=null;

    public static boolean select(String name)
    {
        String sql="select * from USER_ACCOUNT WHERE USER_ACCOUNT=?";
        try
        {
            ps=conn.prepareStatement(sql);
            ps.setString(1,name);
            rs=ps.executeQuery();
            if(rs.next()){
                System.out.println("该用户存在");
                return true;
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        System.out.println("该用户不存在");
        return false;
    }
    
    public static int upDate(USER u){
    /* Integer USER_GENDER,String USER_ADDRESS,
        String USER_INDUSTRY,String USER_EMAIL,
                String USER_EDUCATION,String USER_BIRTHDAY ,
                String USER_PHONE ,String USER_INTRODUCE ,
                String name*/
        String update="update USER_ACCOUNT set USER_GENDER=?,USER_ADDRESS=?," +
                "USER_INDUSTRY=?,USER_EMAIL=?,USER_EDUCATION=?,USER_BIRTHDAY=?," +
                "USER_PHONE=?,USER_INTRODUCE+?where USER_ACCOUNT=?";
        int ret=0;
        try
        {
            ps=conn.prepareStatement(update);
            ps.setInt(1,u.getUSER_GENDER());
            ps.setString(2,u.getUSER_ADDRESS());
            ps.setString(3,u.getUSER_INDUSTRY());
            ps.setString(4,u.getUSER_EMAIL());
            ps.setString(5,u.getUSER_EDUCATION());
            ps.setString(6,u.getUSER_BIRTHDAY());
            ps.setString(7,u.getUSER_PHONE());
            ps.setString(8,u.getUSER_INTRODUCE());
            ps.setString(9,u.getUSER_ACCOUNT());
            
            ret=ps.executeUpdate();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        return ret;
    }
    public static void saveDB(String ACCOUNT, String password, String NAME)
    {
        try
        {
            String sql = "insert into USER_ACCOUNT(USER_ID,USER_ACCOUNT,USER_PASSWORD,USER_NAME) VALUES(SQLID.Nextval,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,ACCOUNT);
            ps.setString(2,password);
            ps.setString(3,NAME);
            System.out.println("正在插入");
            int r = ps.executeUpdate();
            System.out.println("插入成功");
            if (r > 0)
            {
                System.out.println("用户注册成功");
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
