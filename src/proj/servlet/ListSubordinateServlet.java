package proj.servlet;

import proj.logic.RelationLogic;
import proj.logic.SalaryLogic;
import proj.obj.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yayaz_33 on 5/28/2015.
 */
@WebServlet(name = "ListSubordinateServlet")
public class ListSubordinateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        if (session.getAttribute("userid") == null) {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else {
            int employeeID = (int) session.getAttribute("userid");
            int month=6;
            RelationLogic rl = new RelationLogic();
            List<Employee> subordinateList = rl.getAllSubordinates(employeeID);
            List<Float> subordinateSalaryList=new ArrayList<Float>();

            SalaryLogic salaryLogic=new SalaryLogic();

            for(int i=0; i<subordinateList.size(); i++)
            {
                int subordinateID=subordinateList.get(i).getEmployeeID();
                float salary=salaryLogic.calculateSalary(subordinateID, month);
                subordinateSalaryList.add(salary);
            }

            request.setAttribute("subordinateList", subordinateList);
            request.setAttribute("salaryList",subordinateSalaryList);

            request.getRequestDispatcher("/sublist.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }
}
