import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class UserAdminLoginC extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// Set the response message's MIME type
		response.setContentType("application/json; charset=UTF-8");
		// Allocate a output writer to write the response message into the network
		// socket
		PrintWriter out = response.getWriter();

		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");

			Account acc = new Account(username, password);
			boolean loginSuccess = acc.login();
			
			Account.logout(username);

			System.out.println(Account.viewRole(1));

			for (Account account : Account.getAccountList()){
				System.out.println(account);
			}

			if (loginSuccess) {
				response.sendRedirect("/user-admin-portal.html");
			} else {
				response.sendRedirect("/login.html");
			}

		} finally {
			out.close();
		}
	}
}
