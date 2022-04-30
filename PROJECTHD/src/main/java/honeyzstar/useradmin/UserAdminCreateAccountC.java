package honeyzstar.useradmin;

import javax.servlet.*;
import javax.servlet.http.*;

import honeyzstar.entity.Account;
import honeyzstar.entity.Role;

import java.io.*;

public class UserAdminCreateAccountC extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String name = request.getParameter("name");
        int roleId = Integer.parseInt(request.getParameter("role").substring(0,1));
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Account newAccount = new Account(username, password, name, new Role(roleId));
        
        if(newAccount.createAccount()){
            response.sendRedirect("/create-account.html?status=success");
        }
        else{
            response.sendRedirect("/create-account.html?status=fail");
        }
    }
}
