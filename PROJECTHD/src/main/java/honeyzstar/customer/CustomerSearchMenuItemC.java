package honeyzstar.customer;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;
import com.google.gson.Gson;

import honeyzstar.entity.MenuItem;

public class CustomerSearchMenuItemC extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("application/json; charset=UTF-8");
        PrintWriter out = response.getWriter();

        ArrayList<MenuItem> returnList = new ArrayList<MenuItem>();
        // replacing the query string <space> encoded value if any
        String name = request.getQueryString().split("=")[1].replaceAll("%20", " ");

        try {

            returnList = MenuItem.searchMenuItem(name);

            out.println(new Gson().toJson(returnList));

        } finally {
            out.close();
        }

    }
}