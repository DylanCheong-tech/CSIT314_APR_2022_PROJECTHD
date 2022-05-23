package honeyzstar.restaurantowner;
import javax.servlet.*;
import javax.servlet.http.*;

import honeyzstar.entity.Report;
import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.Gson;

import java.io.*;

public class RestaurantOwnerGetMonthlyAverageSpendingReportC extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		response.setContentType("application/json; charset=UTF-8");
        PrintWriter out = response.getWriter();

        int year = Integer.parseInt(request.getQueryString().split("=")[1]);

        Report report = new Report();

        ArrayList<HashMap<String, Object>> reportArr = report.getMonthlyAverageSpendingReport(year);

        try {
            out.println(new Gson().toJson(reportArr));

        } finally {
            out.close();
        }

	}
}
