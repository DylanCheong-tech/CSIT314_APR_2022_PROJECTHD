package honeyzstar.useradmin;

import javax.servlet.*;
import javax.servlet.http.*;

import honeyzstar.entity.Account;
import honeyzstar.entity.Role;

import java.io.*;

public class UserAdminLoginC extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		int roleID = Integer.parseInt(request.getParameter("roleID"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		Account acc = new Account(username, password, new Role(roleID));
		boolean loginSuccess = acc.login();

		HttpSession session = request.getSession();

		if (loginSuccess) {
			response.sendRedirect("/user-admin-portal.html");
			if (session.getAttribute("username") == null) {
				session.setAttribute("username", username);
				session.setMaxInactiveInterval(10);
			}

		} else {
			response.sendRedirect("/login.html?status=fail");
		}

	}
}
