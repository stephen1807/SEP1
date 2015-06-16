package proj.servlet;

import proj.logic.LogCodeLogic;
import proj.obj.LogCode;
import proj.service.LogCodeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Yaz on 6/12/2015.
 */
@WebServlet(name = "DeleteLogCodeServlet")
public class DeleteLogCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {

        int logCodeID= Integer.parseInt(request.getParameter("logCodeID"));
        LogCodeLogic lcl=new LogCodeLogic();

        lcl.deleteLogCode(logCodeID);

        request.getRequestDispatcher("/logcode.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
        this.doPost(request,response);
    }
}
