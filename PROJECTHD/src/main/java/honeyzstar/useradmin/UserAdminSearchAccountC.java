package honeyzstar.useradmin;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import com.google.gson.Gson;

import honeyzstar.entity.Account;

public class UserAdminSearchAccountC extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("application/json; charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            // replacing the query string <space> encoded value if any
            String name = request.getQueryString().split("=")[1].replaceAll("%20", " ");

            Account resultAcc = new Account(name);
            
            if (resultAcc.searchAccount() == null){
                out.println(new Gson().toJson(null));
            }else {
                out.println(new Gson().toJson(resultAcc));
            }

        } finally {
            out.close();
        }

    }
}
