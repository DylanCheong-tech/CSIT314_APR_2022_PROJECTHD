package staff;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import org.mockito.ArgumentCaptor;
import static org.mockito.Mockito.*;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import honeyzstar.staff.StaffSubmitOrderC;

public class StaffSubmitOrderTest {

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
    public void testSubmitOrder() throws ServletException, IOException {
        // test data
        when(request.getParameter("orderID")).thenReturn("101");

        StaffSubmitOrderC submitOrderServlet = new StaffSubmitOrderC();
        submitOrderServlet.doPost(request, response);
        ArgumentCaptor<String> args = ArgumentCaptor.forClass(String.class);

        verify(request, times(1)).getParameter("orderID");

        verify(response, times(1)).sendRedirect(args.capture());
        assertEquals("Create Order Successful Redirection", "/staff/staff-submit-order.html?status=success", args.getValue());
    }

}