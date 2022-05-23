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
        assertTrue("Asserting Returning Order Object", string_writer.toString().contains("[{\"orderID\":11,\"createdAt\":\"2022-05-12 16:09:20\",\"status\":\"Created\",\"totalAmount\":182.4,\"tableNum\":34,\"menuItems\":{\"97\":2,\"17\":6,\"39\":2,\"8\":3,\"73\":5,\"42\":10,\"27\":8},\"createdBy\":{\"accountID\":11,\"name\":\"Test Account 11\",\"role\":{\"roleID\":2,\"name\":\"Staff\",\"descriptions\":\"This is Staff\"},\"dateJoined\":\"2022-05-05 02:26:53\",\"username\":\"username11\",\"password\":\"password11\",\"status\":\"Active\"}},{\"orderID\":40,\"createdAt\":\"2022-05-12 16:09:21\",\"status\":\"Created\",\"totalAmount\":309.21,\"tableNum\":34,\"menuItems\":{\"96\":4,\"32\":8,\"66\":10,\"51\":4,\"85\":5,\"54\":3,\"7\":10,\"78\":9,\"14\":10,\"95\":6},\"createdBy\":{\"accountID\":6,\"name\":\"Test Account 6\",\"role\":{\"roleID\":1,\"name\":\"Restaurant Manager\",\"descriptions\":\"This is Restaurant Manager\"},\"dateJoined\":\"2022-05-05 02:26:53\",\"username\":\"username6\",\"password\":\"password6\",\"status\":\"Active\"}}]"));
        
        System.out.println(string_writer.toString());
    }

}