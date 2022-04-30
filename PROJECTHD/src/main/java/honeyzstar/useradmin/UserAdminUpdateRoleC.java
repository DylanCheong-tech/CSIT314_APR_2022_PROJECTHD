package honeyzstar.useradmin;
import javax.servlet.*;
import javax.servlet.http.*;

import honeyzstar.entity.Role;

import java.io.*;

public class UserAdminUpdateRoleC extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        int roleID = Integer.parseInt(request.getParameter("roleID"));
        String name = request.getParameter("name");
        String desc = request.getParameter("desc");
        
        Role updateRole = new Role(roleID, name, desc);

        if(updateRole.updateRole()){
            response.sendRedirect("/update-role.html?status=success");
        }
        else{
            response.sendRedirect("/update-role.html?status=fail");
        }
    }
}
