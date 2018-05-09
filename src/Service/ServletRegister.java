package Service;

import DB.DBUtil;
import Dao.DBSQL;
import Pojo.USER;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;

/**
 * Created by Administrator on 2018/4/23.
 */
@WebServlet("/ServletRegister")
public class ServletRegister extends HttpServlet
{
    Connection conn= DBUtil.connGet();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset:utf-8");

        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String truename = request.getParameter("truename");

        HttpSession hs=request.getSession();
         if (checkName(name))
          {

              hs.setAttribute("err","该用户已存在！");
              response.sendRedirect("/page/register.jsp");
          }else{
             USER u=new USER();
             u.setUSER_ACCOUNT(name);
             u.setUSER_PASSWORD(password);
             u.setUSER_NAME(truename);
//           System.out.println("判断出现正确");
             hs.setAttribute("user",u);
             saveDB(u.getUSER_ACCOUNT(),u.getUSER_PASSWORD(),u.getUSER_NAME());

             response.sendRedirect("/page/editPersonalttt.jsp");
         }
    }

        private void saveDB (String name, String password, String truename)
        {
            DBSQL.saveDB(name,password,truename);
            DBUtil.colse();
        }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request, response);
    }


    private boolean checkName(String name)
    {
        try
        {
            PreparedStatement ps = conn.prepareStatement("select * from USER_ACCOUNT where USER_ACCOUNT=?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                System.out.println("SQLtrue"+name);
                return true;
            }

        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        System.out.println("SQLfalse"+name);
        return false;
    }
}