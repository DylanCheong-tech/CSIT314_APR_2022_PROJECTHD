import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class UserAdminUpdateAccountC extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        int accID = Integer.parseInt(request.getParameter("accID"));
        String name = request.getParameter("name");
        int roleId = Integer.parseInt(request.getParameter("role").substring(0,1));
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Account newAccount = new Account(accID, username, password, name, new Role(roleId));
        
        if(newAccount.updateAccount()){
            response.sendRedirect("/update-account.html?status=success");
        }
        else{
            response.sendRedirect("/update-account.html?status=fail");
        }
    }
}
