package proj.servlet;

import proj.logic.RelationLogic;
import proj.obj.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Yayaz_33 on 5/28/2015.
 */
@WebServlet(name = "ListSubordinateServlet")
public class ListSubordinateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int employeeID = Integer.parseInt(request.getParameter("employeeID"));

        RelationLogic rl = new RelationLogic();
        List<Employee> subordinateList = rl.getAllSubordinates(employeeID);

        request.setAttribute("subordinateList", subordinateList);

        request.getRequestDispatcher("/sublist.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }
}
