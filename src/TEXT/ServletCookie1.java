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

        //������ǰʱ��
        Date d = new Date();
        SimpleDateFormat sd = new SimpleDateFormat("MM/dd hh:mm:ss");
        String date = sd.format(d);

        //������������е�cookie����
        Cookie[] carr = request.getCookies();
        for (Cookie t: carr)
        {
            if(t.getName().equals("date"))
            {
                //ȡ��������cookie�ģ���һ�η��ʵ�ʱ��
                String lasttime = t.getValue();

                //��cookie��ȡ������ʱҪ���н���
                lasttime = URLDecoder.decode(lasttime, "utf-8");

                String r = "��ӭ"+username+", ������"+date+"<br>"
                        +"���ϴη��ʵ�ʱ���ǣ�"+lasttime;

                HttpSession hs = request.getSession();
                hs.setAttribute("date", r);

                //����cookie
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
