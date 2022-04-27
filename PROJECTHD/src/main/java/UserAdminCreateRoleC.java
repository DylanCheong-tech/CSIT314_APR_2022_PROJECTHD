import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class UserAdminCreateRoleC extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String name = request.getParameter("name");
        String desc = request.getParameter("descriptions");

        Role newRole = new Role(name, desc);
        
        if(newRole.createRole()){
            response.sendRedirect("/create-role.html?status=success");
        }
        else{
            response.sendRedirect("/create-role.html?status=fail");
        }
    }
}
