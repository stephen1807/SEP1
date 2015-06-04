package proj.servlet;

import proj.obj.AttendanceLog;
import proj.service.AttendanceLogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class AddAttendanceLogServlet extends HttpServlet {

    /**
     * Constructor of the object.
     */
    public AddAttendanceLogServlet() {
        super();
    }

    /**
     * Destruction of the servlet. <br>
     */
    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
        // Put your code here
    }

    /**
     * The doGet method of the servlet. <br>
     * <p/>
     * This method is called when a form has its tag value method equals to get.
     *
     * @param request  the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException      if an error occurred
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        this.doPost(request, response);

    }

    /**
     * The doPost method of the servlet. <br>
     * <p/>
     * This method is called when a form has its tag value method equals to post.
     *
     * @param request  the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException      if an error occurred
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int employeeID = Integer.parseInt(request.getParameter("employeeID"));
        int logcode = Integer.parseInt(request.getParameter("logcode"));
        Date entryDate = null;
        String entryDateStr = request.getParameter("entryDate");
        //TODO
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
        try {
            entryDate = sdf.parse(entryDateStr);
        } catch (Exception e) {
            e.printStackTrace();
        }

        AttendanceLog al = new AttendanceLog();
        al.setEmployeeid(employeeID);
        al.setLogcode(logcode);
        al.setEntrydate(entryDate);

        AttendanceLogService als = AttendanceLogService.getInstance();
        als.insertAttendanceLog(al);

        request.getRequestDispatcher("/sublog.jsp").forward(request, response);
    }

    /**
     * Initialization of the servlet. <br>
     *
     * @throws ServletException if an error occurs
     */
    public void init() throws ServletException {
        // Put your code here
    }

}
