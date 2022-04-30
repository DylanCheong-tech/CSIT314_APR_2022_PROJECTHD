package honeyzstar.useradmin;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import com.google.gson.Gson;

import honeyzstar.entity.Role;

import java.util.ArrayList;

public class UserAdminGetRoleList extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("application/json; charset=UTF-8");
        PrintWriter out = response.getWriter();

        ArrayList<Role> returnList = new ArrayList<Role>();

        try {

            returnList = Role.getRolelist();

            out.println(new Gson().toJson(returnList));

        } finally {
            out.close();
        }

    }
}
