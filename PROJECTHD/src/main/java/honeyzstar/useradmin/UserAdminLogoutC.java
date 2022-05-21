package honeyzstar.useradmin;

import javax.servlet.*;
import javax.servlet.http.*;

import honeyzstar.entity.Account;

import java.io.*;

public class UserAdminLogoutC extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String username = "";
        HttpSession session = request.getSession();

        username = (String) session.getAttribute("username");
        session.removeAttribute("username");

        Account account = new Account();
        account.setUsername(username);
        account.logout();
    }
}
