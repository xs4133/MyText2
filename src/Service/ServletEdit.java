package Service;

import Dao.DBSQL;
import Pojo.USER;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static java.lang.Integer.parseInt;

/**
 * Created by Administrator on 2018/4/26.
 */
@WebServlet("/ServletEdit")
public class ServletEdit extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        USER user=new USER();
        HttpSession hs=request.getSession();
        hs.getAttribute(user.getUSER_ACCOUNT());
        user.setUSER_GENDER(parseInt(request.getParameter("sex")));
        user.setUSER_ADDRESS(request.getParameterValues("province")[0]+request.getParameterValues("province")[1]);
        user.setUSER_ADDRESS(request.getParameter("hy"));
        user.setUSER_ADDRESS(request.getParameter("email"));
        user.setUSER_ADDRESS(request.getParameter("education"));
        user.setUSER_ADDRESS(request.getParameter("birthday"));
        user.setUSER_ADDRESS(request.getParameter("phone"));
        user.setUSER_ADDRESS(request.getParameter("introduce"));
        saveDB(user);
    }

    private void saveDB(USER user)
    {
        DBSQL.upDate(user);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    doPost(request,response);
    }
}
