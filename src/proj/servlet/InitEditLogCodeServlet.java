package proj.servlet;

import proj.obj.LogCode;
import proj.service.LogCodeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Lozo on 6/19/2015.
 */
@WebServlet(name = "InitEditLogCodeServlet")
public class InitEditLogCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int logCodeID= Integer.parseInt(request.getParameter("logCodeID"));

        LogCodeService lcs=LogCodeService.getInstance();
        LogCode logCode= lcs.getLogCode(logCodeID);
        request.setAttribute("logCode", logCode);
        request.getRequestDispatcher("/logedit.jsp").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request,response);
    }
}
