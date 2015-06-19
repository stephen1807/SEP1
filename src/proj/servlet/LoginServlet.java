package proj.servlet;

import proj.logic.AttendanceLogLogic;
import proj.logic.EmployeeLogic;
import proj.obj.Employee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class LoginServlet extends HttpServlet {

    /**
     * Constructor of the object.
     */
    public LoginServlet() {
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

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("loginusername");
        String password = request.getParameter("loginpassword");

        EmployeeLogic el = new EmployeeLogic();

        Employee employee = el.employeeLogin(username, password);

        if (employee == null) {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
            HttpSession session = request.getSession();
            if (employee.getEmployeetype() == 1) {
                session.setAttribute("userid", employee.getEmployeeID());
                session.setAttribute("name", employee.getName());
                session.setAttribute("type", employee.getEmployeetype());
                request.getRequestDispatcher("/home.jsp").forward(request, response);
            } else {
                session.setAttribute("userid", employee.getEmployeeID());
                session.setAttribute("name", employee.getName());
                session.setAttribute("type", employee.getEmployeetype());
                request.getRequestDispatcher("/home.jsp").forward(request, response);
            }
        }
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
