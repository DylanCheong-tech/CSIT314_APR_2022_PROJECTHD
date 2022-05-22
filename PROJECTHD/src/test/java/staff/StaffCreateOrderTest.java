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

import honeyzstar.staff.StaffCreateOrderC;

public class StaffCreateOrderTest {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;

    @Before
    public void setUp() throws Exception {
        this.request = mock(HttpServletRequest.class);
        this.response = mock(HttpServletResponse.class);
        this.session = mock(HttpSession.class);
    }

    @After
    public void tearDown() throws Exception {
        this.request = null;
        this.response = null;
    }

    @Test
    public void testCreateOrder() throws ServletException, IOException {
        // test data
        when(request.getParameter("tableNum")).thenReturn("12");
        when(request.getParameter("menuItems")).thenReturn("{}");

        when(request.getSession()).thenReturn(this.session);
        when(session.getAttribute("userID")).thenReturn("3");

        StaffCreateOrderC createOrderServlet = new StaffCreateOrderC();
        createOrderServlet.doPost(request, response);
        ArgumentCaptor<String> args = ArgumentCaptor.forClass(String.class);

        verify(request, times(1)).getParameter("tableNum");
        verify(request, times(1)).getParameter("menuItems");
        verify(request, times(1)).getSession();
        verify(session, times(1)).getAttribute("userID");
        verify(response, times(1)).sendRedirect(args.capture());
        assertEquals("Create Order Successful Redirection", "/staff/staff-create-order.html?status=success", args.getValue());
    }

}