package proj.servlet;

import proj.logic.EmployeeLogic;
import proj.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Stephen on 2015/05/15.
 */
@WebServlet(name = "LogoutServlet")
public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        int EmployeeID=(int)session.getAttribute("userid");

        EmployeeLogic el= new EmployeeLogic();
        el.employeeLogout(EmployeeID);

        session.removeAttribute("userid");
        session.removeAttribute("name");
        session.removeAttribute("type");


        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
