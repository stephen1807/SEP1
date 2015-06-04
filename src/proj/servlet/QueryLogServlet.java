package proj.servlet;

import proj.obj.AttendanceLog;
import proj.service.AttendanceLogService;

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

        int employeeID = Integer.parseInt(request.getParameter("employeeID"));
        int month = Integer.parseInt(request.getParameter("month"));

        AttendanceLogService service = AttendanceLogService.getInstance();

        List<AttendanceLog> tempList = service.getAttendanceLog(employeeID, month);

        request.setAttribute("attendanceList", tempList);

        request.getRequestDispatcher("/sublog.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }
}
