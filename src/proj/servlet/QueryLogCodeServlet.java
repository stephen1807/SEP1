package proj.servlet;

import proj.obj.LogCode;
import proj.service.LogCodeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Lozo on 6/12/2015.
 */
@WebServlet(name = "QueryLogCodeServlet")
public class QueryLogCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        LogCodeService lcs=LogCodeService.getInstance();
        List<LogCode> tempList= lcs.getAllLogCodes();

        request.setAttribute("logCodeList", tempList);

        request.getRequestDispatcher("/logcode.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }
}
