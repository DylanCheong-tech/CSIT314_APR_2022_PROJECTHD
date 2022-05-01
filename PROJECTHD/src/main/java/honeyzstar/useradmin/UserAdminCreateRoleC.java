package honeyzstar.useradmin;
import javax.servlet.*;
import javax.servlet.http.*;

import honeyzstar.entity.Role;

import java.io.*;

public class UserAdminCreateRoleC extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String name = request.getParameter("name");
        String descriptions = request.getParameter("descriptions");

        Role newRole = new Role(name, descriptions);
        
        if(newRole.createRole()){
            response.sendRedirect("/create-role.html?status=success");
        }
        else{
            response.sendRedirect("/create-role.html?status=fail");
        }
    }
}
