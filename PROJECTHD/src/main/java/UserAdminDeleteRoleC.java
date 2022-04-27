import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class UserAdminDeleteRoleC extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        int roleID = Integer.parseInt(request.getParameter("roleID"));

        if (Role.deleteRole(roleID)){
            response.sendRedirect("/delete-role.html?status=success");
        }else {
            response.sendRedirect("/delete-role.html?status=fail");
        }
    }
}
