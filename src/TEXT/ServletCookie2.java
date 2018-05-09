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
        SimpleDateFormat sd=new SimpleDateFormat("yyyy��mm��dd�� hh:mi:ss");
        String s=sd.format(date);

        Cookie[] c=request.getCookies();
       for(Cookie t:c){
           if(t.getName().equals("date")){
               //ȡ��������cookie�ϵ���һ�η��ʵ�ʱ��
               String lasttime=t.getValue();
               //���н���
               lasttime= URLEncoder.encode(lasttime,"utf-8");
               String r="��ӭ"+name+",�����ǣ�"+s+"<br>"+"���ϴη��ʵ�ʱ���ǣ�"+lasttime;

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
