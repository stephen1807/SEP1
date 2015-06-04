package proj.servlet;

import proj.obj.PermissionIndividual;
import proj.service.PermissionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Yayaz_33 on 5/28/2015.
 */
@WebServlet(name = "AddPermissionServlet")
public class AddPermissionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int employeeID = Integer.parseInt(request.getParameter("employeeID"));
        Date startTime = null;
        Date endTime = null;
        String startTimeStr = request.getParameter("startTime");
        //TODO
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
        try {
            startTime = sdf.parse(startTimeStr);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String endTimeStr = request.getParameter("endTime");
        try {
            endTime = sdf.parse(endTimeStr);
        } catch (Exception e) {
            e.printStackTrace();
        }

        PermissionIndividual permission = new PermissionIndividual();
        permission.setEmployeeID(employeeID);
        permission.setStartTime(startTime);
        permission.setEndTime(endTime);

        PermissionService ps = PermissionService.getInstance();
        ps.insertPermission(permission);
        request.getRequestDispatcher("/sublogedit.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);

    }
}
