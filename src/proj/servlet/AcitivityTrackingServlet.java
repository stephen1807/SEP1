package proj.servlet;

import proj.logic.EmployeeLogic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Yayaz_33 on 6/4/2015.
 */
@WebServlet(name = "AcitivityTrackingServlet")
public class AcitivityTrackingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        int EmployeeID=(int)session.getAttribute("userid");

        EmployeeLogic el= new EmployeeLogic();
//        el.
        session.removeAttribute("userid");
        session.removeAttribute("name");
        session.removeAttribute("type");


        request.getRequestDispatcher("/index.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }
}
