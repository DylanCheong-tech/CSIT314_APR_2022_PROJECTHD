import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class UserAdminLogoutC extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getQueryString().split("=")[1];

        Account.logout(username);
    }
}
