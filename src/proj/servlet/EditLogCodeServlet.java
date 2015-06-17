package proj.servlet;

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
@WebServlet(name = "EditLogCodeServlet")
public class EditLogCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {


        int logCodeID= Integer.parseInt(request.getParameter("logCodeID"));
        String logCodeName= request.getParameter("name");

        String logDescription=request.getParameter("desc");
        float logCost=Float.parseFloat(request.getParameter("cost"));
        String logUnit=request.getParameter("unit");
        float logCost_permission=Float.parseFloat(request.getParameter("costpermission"));

        LogCodeService lcs=LogCodeService.getInstance();
        LogCode logCode= lcs.getLogCode(logCodeID);
        logCode.setLogname(logCodeName);
        logCode.setLogunit(logUnit);
        logCode.setLogcost(logCost);
        logCode.setLogcost_permission(logCost_permission);
        logCode.setLogdescription(logDescription);

        lcs.editLogCode(logCode);

        request.getRequestDispatcher("/logcode.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
        this.doPost(request,response);
    }
}