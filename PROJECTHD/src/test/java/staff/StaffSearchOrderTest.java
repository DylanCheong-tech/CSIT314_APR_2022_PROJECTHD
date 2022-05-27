package staff;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import honeyzstar.staff.StaffSearchOrderC;

public class StaffSearchOrderTest {

    private HttpServletRequest request;
    private HttpServletResponse response;

    @Before
    public void setUp() throws Exception {
        this.request = mock(HttpServletRequest.class);
        this.response = mock(HttpServletResponse.class);
    }

    @After
    public void tearDown() throws Exception {
        this.request = null;
        this.response = null;
    }

    @Test
    public void testSearchOrder() throws ServletException, IOException {
        // test data
        when(request.getQueryString()).thenReturn("tableNum=34");

        StringWriter string_writer = new StringWriter();
        PrintWriter output_writer = new PrintWriter(string_writer);

        when(response.getWriter()).thenReturn(output_writer);

        StaffSearchOrderC searchOrderServlet = new StaffSearchOrderC();
        searchOrderServlet.doGet(request, response);

        verify(request, times(1)).getQueryString();
        verify(response, times(1)).getWriter();

        output_writer.flush();
        assertTrue("Asserting Returning Order Object", string_writer.toString().contains("[{\"orderID\":5,\"createdAt\":\"2020-07-21 06:50:36\",\"updatedAt\":\"2020-07-21 07:00:36\",\"status\":\"Paid\",\"totalAmount\":117.03,\"tableNum\":34,\"menuItems\":{\"90\":3,\"35\":7,\"60\":4,\"77\":1,\"14\":3},\"createdBy\":{\"accountID\":8,\"name\":\"Test Account 8\",\"role\":{\"roleID\":1,\"name\":\"Restaurant Manager\",\"descriptions\":\"This is Restaurant Manager\"},\"dateJoined\":\"2022-05-05 02:26:53\",\"username\":\"username8\",\"password\":\"password8\",\"status\":\"Active\"}},{\"orderID\":10,\"createdAt\":\"2020-02-25 09:19:49\",\"updatedAt\":\"2020-02-25 09:34:49\",\"status\":\"Paid\",\"totalAmount\":100.96,\"tableNum\":34,\"menuItems\":{\"17\":2,\"9\":8,\"91\":3,\"12\":10,\"95\":2},\"createdBy\":{\"accountID\":8,\"name\":\"Test Account 8\",\"role\":{\"roleID\":1,\"name\":\"Restaurant Manager\",\"descriptions\":\"This is Restaurant Manager\"},\"dateJoined\":\"2022-05-05 02:26:53\",\"username\":\"username8\",\"password\":\"password8\",\"status\":\"Active\"}},{\"orderID\":50,\"createdAt\":\"2020-09-10 02:34:09\",\"updatedAt\":\"2020-09-10 02:49:09\",\"status\":\"Paid\",\"totalAmount\":54.81,\"tableNum\":34,\"menuItems\":{\"92\":3,\"44\":8,\"6\":3},\"createdBy\":{\"accountID\":6,\"name\":\"Test Account 6\",\"role\":{\"roleID\":1,\"name\":\"Restaurant Manager\",\"descriptions\":\"This is Restaurant Manager\"},\"dateJoined\":\"2022-05-05 02:26:53\",\"username\":\"username6\",\"password\":\"password6\",\"status\":\"Active\"}},{\"orderID\":52,\"createdAt\":\"2020-05-28 02:10:34\",\"updatedAt\":\"2020-05-28 02:25:34\",\"status\":\"Paid\",\"totalAmount\":150.66,\"tableNum\":34,\"menuItems\":{\"17\":9,\"68\":10,\"60\":1,\"22\":5,\"30\":1},\"createdBy\":{\"accountID\":3,\"name\":\"Test Account 3\",\"role\":{\"roleID\":2,\"name\":\"Staff\",\"descriptions\":\"This is Staff\"},\"dateJoined\":\"2022-05-05 02:26:53\",\"username\":\"username3\",\"password\":\"password3\",\"status\":\"Active\"}}]"));
        
        System.out.println(string_writer.toString());
    }

}