package TEXT;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2018/4/24.
 */
@WebServlet("/TEXT.ServletCookie1")
public class ServletCookie1 extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String username = request.getParameter("name");

        //产生当前时间
        Date d = new Date();
        SimpleDateFormat sd = new SimpleDateFormat("MM/dd hh:mm:ss");
        String date = sd.format(d);

        //获得请求中所有的cookie数据
        Cookie[] carr = request.getCookies();
        for (Cookie t: carr)
        {
            if(t.getName().equals("date"))
            {
                //取出保存在cookie的，上一次访问的时间
                String lasttime = t.getValue();

                //从cookie中取出数据时要进行解码
                lasttime = URLDecoder.decode(lasttime, "utf-8");

                String r = "欢迎"+username+", 今天是"+date+"<br>"
                        +"您上次访问的时间是："+lasttime;

                HttpSession hs = request.getSession();
                hs.setAttribute("date", r);

                //更新cookie
                date = URLEncoder.encode(date, "utf-8");
                t.setValue(date);
                response.addCookie(t);


                response.sendRedirect("/page/TextCOOKIE.jsp");

                return;
            }
        }



    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    doPost(request,response);
    }
}
