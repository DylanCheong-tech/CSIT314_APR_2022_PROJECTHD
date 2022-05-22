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

import honeyzstar.staff.StaffLoginC;

public class StaffLoginTest {

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
    public void testLogin () throws ServletException, IOException {
        // test data
        when(request.getParameter("username")).thenReturn("username3");
        when(request.getParameter("password")).thenReturn("password3");
        when(request.getParameter("roleID")).thenReturn("2");
        when(request.getSession()).thenReturn(this.session);

        StaffLoginC loginServlet = new StaffLoginC();
        loginServlet.doPost(request, response);
        ArgumentCaptor<String> args = ArgumentCaptor.forClass(String.class);

        verify(request, atMostOnce()).getParameter("username");
        verify(request, atMostOnce()).getParameter("password");
        verify(request, atMostOnce()).getParameter("roleID");
        verify(request, atMostOnce()).getSession();
        verify(response, atMostOnce()).sendRedirect(args.capture());
        assertEquals("Login Successful Redirection", "/staff-portal.html?userID=3", args.getValue());
    }

}