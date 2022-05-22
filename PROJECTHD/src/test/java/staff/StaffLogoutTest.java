package staff;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.*;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import honeyzstar.staff.StaffLogoutC;

public class StaffLogoutTest {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;

    @Before 
    public void setUp () throws Exception {
        this.request = mock(HttpServletRequest.class);
        this.response = mock(HttpServletResponse.class);
        this.session = mock(HttpSession.class);
    }

    @After 
    public void tearDown () throws Exception {
        this.request = null;
        this.response = null;
    }

    @Test 
    public void testLogout () throws ServletException, IOException {
        when(request.getSession()).thenReturn(this.session);
        when(session.getAttribute("username")).thenReturn("username3");

        StaffLogoutC loginServlet = new StaffLogoutC();
        loginServlet.doGet(request, response);

        verify(request, atMostOnce()).getSession();
    }

}