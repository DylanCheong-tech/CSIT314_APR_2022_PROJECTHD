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
        when(request.getQueryString()).thenReturn("orderID=15");

        StringWriter string_writer = new StringWriter();
        PrintWriter output_writer = new PrintWriter(string_writer);

        when(response.getWriter()).thenReturn(output_writer);

        StaffViewOrderC viewOrderServlet = new StaffViewOrderC();
        viewOrderServlet.doGet(request, response);

        verify(request, times(1)).getQueryString();
        verify(response, times(1)).getWriter();

        output_writer.flush();
        assertTrue("Asserting Returning Order Object", string_writer.toString().contains("{\"orderID\":15,\"createdAt\":\"2022-05-12 16:09:20\",\"status\":\"Created\",\"totalAmount\":23.76,\"tableNum\":4,\"menuItems\":{\"68\":6,\"45\":3},\"createdBy\":{\"accountID\":18,\"name\":\"Test Account 18\",\"role\":{\"roleID\":4,\"name\":\"User Admin\",\"descriptions\":\"This is User Admin\"},\"dateJoined\":\"2022-05-05 02:26:53\",\"username\":\"username18\",\"password\":\"password18\",\"status\":\"Active\"}}"));

        
        System.out.println(string_writer.toString());
    }

}