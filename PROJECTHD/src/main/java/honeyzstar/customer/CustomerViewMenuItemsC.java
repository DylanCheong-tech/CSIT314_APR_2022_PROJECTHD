package honeyzstar.customer;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;
import com.google.gson.Gson;

import honeyzstar.entity.MenuItem;

public class CustomerViewMenuItemsC extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("application/json; charset=UTF-8");
        PrintWriter out = response.getWriter();

        ArrayList<MenuItem> returnList = new ArrayList<MenuItem>();

        try {

            returnList = MenuItem.getMenuItemList();

            out.println(new Gson().toJson(returnList));

        } finally {
            out.close();
        }

    }
}
