package staff;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import honeyzstar.staff.StaffViewOrderC;

public class StaffViewOrderTest {

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
    public void testViewOrder() throws ServletException, IOException {
        // test data
        when(request.getQueryString()).thenReturn("orderID=100");

        StringWriter string_writer = new StringWriter();
        PrintWriter output_writer = new PrintWriter(string_writer);

        when(response.getWriter()).thenReturn(output_writer);

        StaffViewOrderC viewOrderServlet = new StaffViewOrderC();
        viewOrderServlet.doGet(request, response);

        verify(request, times(1)).getQueryString();
        verify(response, times(1)).getWriter();

        output_writer.flush();
        assertTrue("Asserting Returning Order Object", string_writer.toString().contains("{\"orderID\":100,\"createdAt\":\"2022-05-12 16:09:23\",\"status\":\"Paid\",\"totalAmount\":61.11,\"tableNum\":40,\"menuItems\":{\"66\":7,\"52\":3,\"63\":4},\"createdBy\":{\"accountID\":17,\"name\":\"Test Account 17\",\"role\":{\"roleID\":3,\"name\":\"Restaurant Owner\",\"descriptions\":\"This is Restaurant Owner\"},\"dateJoined\":\"2022-05-05 02:26:53\",\"username\":\"username17\",\"password\":\"password17\",\"status\":\"Suspended\"}}"));

        
        System.out.println(string_writer.toString());
    }

}