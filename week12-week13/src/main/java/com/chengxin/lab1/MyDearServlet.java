package lab1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/mydearservlet")
public class MyDearServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("运行了");
        request.setCharacterEncoding("UTF-8");
        String name=request.getParameter("name");
        String Class=request.getParameter("class");
        String ID=request.getParameter("ID");
        request.setAttribute("name",name);
        request.setAttribute("Class",Class);
        request.setAttribute("ID",ID);
        request.getRequestDispatcher("show.jsp").forward(request,response);
        response.sendRedirect("show.jsp");


        //2020211001000630chengxin
    }
}
