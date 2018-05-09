package Service;

import DB.DBUtil;
import Pojo.USER;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2018/4/24.
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet
{
    Connection conn= DBUtil.connGet();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset:utf-8");

        String name = request.getParameter("name");
        String passworld = request.getParameter("password");
        System.out.println(name+passworld);
        USER u=chaeckName(name,passworld);
        if (u!=null)
        {
            HttpSession hs = request.getSession();
            hs.setAttribute("user", u);
            response.sendRedirect("/page/personal.jsp");
        } else
        {

            HttpSession hs = request.getSession();
            hs.setAttribute("err","’À∫≈ªÚ√‹¬Î¥ÌŒÛ");
            response.sendRedirect("/page/login.jsp");
        }
    }
    private USER chaeckName(String name, String passworld)
    {
        try
        {   String sql="select * from USER_ACCOUNT where USER_ACCOUNT=? and USER_PASSWORD =?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,passworld);
            ResultSet rs=ps.executeQuery();

            if(rs.next()){
                USER u=new USER();

                u.setUSER_GENDER(rs.getInt("USER_GENDER"));
                u.setUSER_ADDRESS(rs.getString("USER_ADDRESS"));
                u.setUSER_INDUSTRY(rs.getString("USER_INDUSTRY"));
                u.setUSER_EMAIL(rs.getString("USER_EMAIL"));
                u.setUSER_EDUCATION(rs.getString("USER_EDUCATION"));
                u.setUSER_BIRTHDAY(rs.getString("USER_BIRTHDAY"));
                u.setUSER_PHONE(rs.getString("USER_PHONE"));
                u.setUSER_INTRODUCE(rs.getString("USER_INTRODUCE"));
                System.out.println(u.getUSER_ACCOUNT()+"e");
                return u;
            }

        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request,response);
    }
}
