package honeyzstar.useradmin;
import javax.servlet.*;
import javax.servlet.http.*;

import honeyzstar.entity.Account;

import java.io.*;

public class UserAdminSuspendAccountC extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        int accountID = Integer.parseInt(request.getParameter("accountID"));

        Account account = new Account(accountID);

        if (account.suspendAccount()){
            response.sendRedirect("/useradmin/suspend-account.html?status=success");
        }else {
            response.sendRedirect("/useradmin/suspend-account.html?status=fail");
        }
    }
}
