package staff;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import org.mockito.ArgumentCaptor;
import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.*;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import honeyzstar.staff.StaffUpdateOrderC;

public class StaffUpdateOrderTest {

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
    public void testUpdateOrder() throws ServletException, IOException {
        // test data
        when(request.getParameter("orderID")).thenReturn("3");
        when(request.getParameter("tableNum")).thenReturn("44");
        when(request.getParameter("menuItems")).thenReturn("{ \"100\" : 2, \"52\" : 2, \"55\" : 3, \"73\" : 2 }");

        StaffUpdateOrderC updateOrderServlet = new StaffUpdateOrderC();
        updateOrderServlet.doPost(request, response);
        ArgumentCaptor<String> args = ArgumentCaptor.forClass(String.class);

        verify(request, times(1)).getParameter("orderID");
        verify(request, times(1)).getParameter("tableNum");
        verify(request, times(1)).getParameter("menuItems");
        verify(response, atMostOnce()).sendRedirect(args.capture());
        assertEquals("Create Order Successful Redirection", "/staff/staff-update-order.html?status=success", args.getValue());
    }

}