package honeyzstar.useradmin;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import com.google.gson.Gson;

import honeyzstar.entity.Account;

public class UserAdminViewAccountC extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("application/json; charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            System.out.println(request.getQueryString().split("=")[1]);
            int accID = Integer.parseInt(request.getQueryString().split("=")[1]);

            Account resultAcc = Account.getAccount(accID);

            if (resultAcc == null) {
                out.println(new Gson().toJson(null));
            } else {
                out.println(new Gson().toJson(resultAcc));
            }

        } finally {
            out.close();
        }

    }
}
