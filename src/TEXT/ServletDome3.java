package TEXT;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Administrator on 2018/4/23.
 */
@WebServlet("/TEXT.ServletDome3")
public class ServletDome3 extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset:utf-8");

        String name=request.getParameter("name");
//        String passworld=request.getParameter("password");

        if(name.equals("zhang3")){
           // request.getRequestDispatcher("/page/personal.jsp").forward(request,response);
            HttpSession hs=request.getSession();

            hs.setAttribute("err",name);

            response.sendRedirect("/page/personal.jsp");
        }else{
            //session
            HttpSession hs=request.getSession();
            hs.setAttribute("err","用户不存在！");
            response.sendRedirect("/page/login.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request,response);
    }
}
