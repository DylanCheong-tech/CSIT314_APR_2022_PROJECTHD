package honeyzstar.useradmin;
import javax.servlet.*;
import javax.servlet.http.*;

import honeyzstar.entity.Account;
import honeyzstar.entity.Role;

import java.io.*;

public class UserAdminUpdateAccountC extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        int accountID = Integer.parseInt(request.getParameter("accountID"));
        String name = request.getParameter("name");
        int roleId = Integer.parseInt(request.getParameter("roleID").substring(0,1));
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Account updateAccount = new Account(accountID, username, password, name, new Role(roleId));
        
        if(updateAccount.updateAccount()){
            response.sendRedirect("/update-account.html?status=success");
        }
        else{
            response.sendRedirect("/update-account.html?status=fail");
        }
    }
}
