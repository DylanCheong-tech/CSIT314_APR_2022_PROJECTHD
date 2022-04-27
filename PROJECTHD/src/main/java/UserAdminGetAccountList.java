import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;
import com.google.gson.Gson;

public class UserAdminGetAccountList extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("application/json; charset=UTF-8");
        PrintWriter out = response.getWriter();

        ArrayList<Account> returnList = new ArrayList<Account>();

        try {

            returnList = Account.getAccountList();

            out.println(new Gson().toJson(returnList));

        } finally {
            out.close();
        }

    }
}
