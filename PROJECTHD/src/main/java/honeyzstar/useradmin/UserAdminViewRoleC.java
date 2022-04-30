package honeyzstar.useradmin;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import com.google.gson.Gson;

import honeyzstar.entity.Role;

public class UserAdminViewRoleC extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("application/json; charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            System.out.println(request.getQueryString().split("=")[1]);
            int roleID = Integer.parseInt(request.getQueryString().split("=")[1]);

            Role resultRole = Role.getRole(roleID);

            if (resultRole == null) {
                out.println(new Gson().toJson(null));
            } else {
                out.println(new Gson().toJson(resultRole));
            }

        } finally {
            out.close();
        }

    }
}
