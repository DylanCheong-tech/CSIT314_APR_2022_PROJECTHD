package honeyzstar.restaurantmanager;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import com.google.gson.Gson;

import honeyzstar.entity.MenuItem;

public class RestaurantManagerViewMenuItemC extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("application/json; charset=UTF-8");
        PrintWriter out = response.getWriter();

        int menuItemID = Integer.parseInt(request.getQueryString().split("=")[1]);

        MenuItem viewMenuItem = (new MenuItem(menuItemID)).getMenuItem();

        try {
            out.println(new Gson().toJson(viewMenuItem));

        } finally {
            out.close();
        }

    }
}
