package honeyzstar.useradmin;
import javax.servlet.*;
import javax.servlet.http.*;

import honeyzstar.entity.Role;

import java.io.*;

public class UserAdminDeleteRoleC extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        int roleID = Integer.parseInt(request.getParameter("roleID"));

        Role role = new Role(roleID);

        if (role.deleteRole()){
            response.sendRedirect("/useradmin/delete-role.html?status=success");
        }else {
            response.sendRedirect("/useradmin/delete-role.html?status=fail");
        }
    }
}
