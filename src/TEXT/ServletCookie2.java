package TEXT;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2018/4/24.
 */
@WebServlet(name = "TEXT.ServletCookie2")
public class ServletCookie2 extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
      String name=request.getParameter("name");

        Date date=new Date();
        SimpleDateFormat sd=new SimpleDateFormat("yyyy年mm月dd日 hh:mi:ss");
        String s=sd.format(date);

        Cookie[] c=request.getCookies();
       for(Cookie t:c){
           if(t.getName().equals("date")){
               //取出保存在cookie上的上一次访问的时间
               String lasttime=t.getValue();
               //进行解码
               lasttime= URLEncoder.encode(lasttime,"utf-8");
               String r="欢迎"+name+",今天是："+s+"<br>"+"您上次访问的时间是："+lasttime;

               HttpSession  hs=request.getSession();
               hs.setAttribute("date",r);

               s=URLEncoder.encode(s,"utf-8");
               t.setValue(s);
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
