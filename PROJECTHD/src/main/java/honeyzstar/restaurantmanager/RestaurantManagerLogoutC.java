package honeyzstar.restaurantmanager;
import javax.servlet.*;
import javax.servlet.http.*;

import honeyzstar.entity.Account;

import java.io.*;

public class RestaurantManagerLogoutC extends HttpServlet {
	@Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // replacing the query string <space> encoded value if any
        String username = request.getQueryString().split("=")[1].replaceAll("%20", " ");

        Account.logout(username);
    }
}
