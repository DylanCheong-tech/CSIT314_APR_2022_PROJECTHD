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
        when(request.getQueryString()).thenReturn("tableNum=36");

        StringWriter string_writer = new StringWriter();
        PrintWriter output_writer = new PrintWriter(string_writer);

        when(response.getWriter()).thenReturn(output_writer);

        StaffSearchOrderC searchOrderServlet = new StaffSearchOrderC();
        searchOrderServlet.doGet(request, response);

        verify(request, times(1)).getQueryString();
        verify(response, times(1)).getWriter();

        output_writer.flush();
        assertTrue("Asserting Returning Order Object", string_writer.toString().contains("[{\"orderID\":34,\"createdAt\":\"2022-05-12 16:09:21\",\"status\":\"Created\",\"totalAmount\":102.67,\"tableNum\":36,\"menuItems\":{\"90\":7,\"42\":5,\"83\":4,\"85\":6,\"45\":2},\"createdBy\":{\"accountID\":16,\"name\":\"Test Account 16\",\"role\":{\"roleID\":2,\"name\":\"Staff\",\"descriptions\":\"This is Staff\"},\"dateJoined\":\"2022-05-05 02:26:53\",\"username\":\"username16\",\"password\":\"password16\",\"status\":\"Active\"}}]"));
        
        System.out.println(string_writer.toString());
    }

}