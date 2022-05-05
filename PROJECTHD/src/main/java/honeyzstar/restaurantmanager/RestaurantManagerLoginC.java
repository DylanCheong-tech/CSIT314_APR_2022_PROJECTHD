package honeyzstar.restaurantmanager;
import javax.servlet.*;
import javax.servlet.http.*;

import honeyzstar.entity.Account;
import honeyzstar.entity.Role;

import java.io.*;

public class RestaurantManagerLoginC extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		int roleID = Integer.parseInt(request.getParameter("roleID"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		Account acc = new Account(username, password, new Role(roleID));
		boolean loginSuccess = acc.login();

		if (loginSuccess) {
			response.sendRedirect("/restaurant-manager-portal.html?username=" + username);
		} else {
			response.sendRedirect("/login.html?status=fail");
		}

	}
}
