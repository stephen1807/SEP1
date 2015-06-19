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
@WebServlet(name = "AddLogCodeServlet")
public class AddLogCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {

        String logCodeName= request.getParameter("name");

        String logDescription=request.getParameter("desc");
        float logCost=Float.parseFloat(request.getParameter("cost"));
        String logUnit=request.getParameter("unit");
        float logCost_permission=Float.parseFloat(request.getParameter("costpermission"));

        LogCodeService lcs=LogCodeService.getInstance();
        LogCode logCode=new LogCode();
        logCode.setLogname(logCodeName);
        logCode.setLogunit(logUnit);
        logCode.setLogcost(logCost);
        logCode.setLogcost_permission(logCost_permission);
        logCode.setLogdescription(logDescription);

        lcs.insertLogCode(logCode);

        request.getRequestDispatcher("/servlet/QueryLogCodeServlet").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
        this.doPost(request,response);
    }
}
