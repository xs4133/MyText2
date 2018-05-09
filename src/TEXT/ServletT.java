package TEXT;

import DB.DBUtil;

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
@WebServlet("/TEXT.ServletT")
public class ServletT extends HttpServlet
{
    Connection conn= DBUtil.connGet();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text.html;utf-8");

        String name=request.getParameter("name");
        String[] passworld=request.getParameterValues("password");
        String truename=request.getParameter("truename");

        if(chaeckName(name)){
            HttpSession hs=request.getSession();
            hs.setAttribute("err","用户存在");
            response.sendRedirect("/page/register.jsp");
        }else{
            System.out.println(name+","+passworld[0]+","+truename);
            saveDB(name,passworld[0],truename);
            response.sendRedirect("/page/login.jsp");
        }
    }

    private void saveDB(String name, String passworld, String truename)
    {
        try
        {
            String url="INSERT INTO USER_ACCOUNT (USER_ID,USER_ACCOUNT,USER_PASSWORD,USER_NAME)VALUES (userseq.nextval,?,?,?)";

            PreparedStatement ps=conn.prepareStatement(url);
            ps.setString(1,name);
            ps.setString(2,passworld);
            ps.setString(3,truename);
            int r=ps.executeUpdate();
            if(r>0){
                System.out.println("插入成功");
            }

        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    private boolean chaeckName(String name)
    {
        try
        {
            PreparedStatement ps=conn.prepareStatement("select * from USER_ACCOUNT where USER_NAME=?");
            ps.setString(1,name);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                System.out.println("用户存在");
                return true;
            }

        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request,response);
    }
}
