package honeyzstar.useradmin;
import javax.servlet.*;
import javax.servlet.http.*;

import honeyzstar.entity.Account;

import java.io.*;

public class UserAdminLoginC extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		Account acc = new Account(username, password);
		boolean loginSuccess = acc.login();

		if (loginSuccess) {
			response.sendRedirect("/user-admin-portal.html?username=" + username);
		} else {
			response.sendRedirect("/login.html?status=fail");
		}

	}
}
