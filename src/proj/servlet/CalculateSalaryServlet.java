package proj.servlet;

import proj.logic.SalaryLogic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Yayaz_33 on 5/28/2015.
 */
@WebServlet(name = "CalculateSalaryServlet")
public class CalculateSalaryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int employeeID = Integer.parseInt(request.getParameter("employeeID"));
        int month = Integer.parseInt(request.getParameter("month"));

        SalaryLogic sl = new SalaryLogic();
        sl.calculateSalary(employeeID, month);

        request.getRequestDispatcher("/salary.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }
}
