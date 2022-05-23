package honeyzstar.restaurantowner;
import javax.servlet.*;
import javax.servlet.http.*;

import honeyzstar.entity.Report;
import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.Gson;

import java.io.*;

public class RestaurantOwnerGetWeeklyVisitFrequencyReportC extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		response.setContentType("application/json; charset=UTF-8");
        PrintWriter out = response.getWriter();

        String[] queries = request.getQueryString().split("&");

        int year = Integer.parseInt(queries[0].split("=")[1]);
        int month = Integer.parseInt(queries[1].split("=")[1]);

        Report report = new Report();

        ArrayList<HashMap<String, Object>> reportArr = report.getWeeklyVisitFrequencyReport(year, month);

        try {
            out.println(new Gson().toJson(reportArr));

        } finally {
            out.close();
        }

	}
}
