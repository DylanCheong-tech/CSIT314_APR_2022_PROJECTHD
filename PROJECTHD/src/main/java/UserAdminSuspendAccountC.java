import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class UserAdminSuspendAccountC extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        int accountID = Integer.parseInt(request.getParameter("accID"));

        if (Account.suspendAccount(accountID)){
            response.sendRedirect("/suspend-account.html?status=success");
        }else {
            response.sendRedirect("/suspend-account.html?status=fail");
        }
    }
}