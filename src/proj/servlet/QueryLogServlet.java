package proj.servlet;

import proj.obj.AttendanceLog;
import proj.obj.Employee;
import proj.service.AttendanceLogService;
import proj.service.EmployeeService;

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
@WebServlet(name = "QueryLogServlet")
public class QueryLogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int employeeID = Integer.parseInt(request.getParameter("subordinateID"));
        int month = Integer.parseInt(request.getParameter("month"));

        AttendanceLogService service = AttendanceLogService.getInstance();

        List<AttendanceLog> tempList = service.getAttendanceLog(employeeID, month);

        EmployeeService es=EmployeeService.getInstance();
        Employee e=es.getEmployee(employeeID);

        request.setAttribute("employeeName", e.getName());
        request.setAttribute("employeeID", employeeID);
        request.setAttribute("attendanceList", tempList);

        request.getRequestDispatcher("/sublog.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }
}
