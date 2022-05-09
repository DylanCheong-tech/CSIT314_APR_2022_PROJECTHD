import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

import honeyzstar.useradmin.*;

public class UserAdminControllerTests {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private PrintWriter outWritter;

    @Before 
    public void setUp () throws Exception {
        this.request = mock(HttpServletRequest.class);
        this.response = mock(HttpServletResponse.class);
        this.session = mock(HttpSession.class);
        this.outWritter = mock(PrintWriter.class);
    }

    @After 
    public void tearDown () throws Exception {
        this.request = null;
        this.response = null;
    }

    @Test 
    public void testUserAdminLogin () throws ServletException, IOException {
        when(request.getParameter("username")).thenReturn("username1");
        when(request.getParameter("password")).thenReturn("password1");
        when(request.getParameter("roleID")).thenReturn("1");
        when(request.getSession()).thenReturn(this.session);

        UserAdminLoginC loginServlet = new UserAdminLoginC();
        loginServlet.doPost(request, response);

        verify(request, atMostOnce()).getParameter("username");
        verify(request, atMostOnce()).getParameter("password");
        verify(request, atMostOnce()).getParameter("roleID");
        verify(request, atMostOnce()).getSession();
        verify(response, atMostOnce()).sendRedirect("/user-admin-portal.html");
    }

    @Test 
    public void testUserAdminLogout () throws ServletException, IOException {
        when(request.getSession()).thenReturn(this.session);
        when(session.getAttribute("username")).thenReturn("username1");

        UserAdminLogoutC logoutServlet = new UserAdminLogoutC();
        logoutServlet.doGet(request, response);

        verify(request, atMostOnce()).getSession();
        verify(session, atMostOnce()).getAttribute("username");
        verify(session, atMostOnce()).removeAttribute("username");
    }

    @Test 
    public void testUserAdminCreateAccountC () throws ServletException, IOException {
        when(request.getParameter("name")).thenReturn("Unit Test Create Account");
        when(request.getParameter("username")).thenReturn("unitusername1");
        when(request.getParameter("password")).thenReturn("unitpassword1");
        when(request.getParameter("roleID")).thenReturn("2");
        

        UserAdminCreateAccountC createAccountServlet = new UserAdminCreateAccountC();
        createAccountServlet.doPost(request, response);

        verify(request, atMostOnce()).getParameter("name");
        verify(request, atMostOnce()).getParameter("username");
        verify(request, atMostOnce()).getParameter("password");
        verify(request, atMostOnce()).getParameter("roleID");
        verify(response, atMostOnce()).sendRedirect("/create-account.html?status=success");
        verify(response, never()).sendRedirect("/create-account.html?status=fail");
    }

    @Test 
    public void testUserAdminSuspendAccountC () throws ServletException, IOException {
        // id here
        when(request.getParameter("accountID")).thenReturn("110");
        

        UserAdminSuspendAccountC suspendAccountServlet = new UserAdminSuspendAccountC();
        suspendAccountServlet.doPost(request, response);

        verify(request, atMostOnce()).getParameter("accountID");
        verify(response, atMostOnce()).sendRedirect("/suspend-account.html?status=success");
        verify(response, never()).sendRedirect("/suspend-account.html?status=fail");
    }

    @Test 
    public void testUserAdminUpdateAccountC () throws ServletException, IOException {
        // id here
        when(request.getParameter("accountID")).thenReturn("110");
        when(request.getParameter("name")).thenReturn("Unit Test Update Account");
        when(request.getParameter("username")).thenReturn("unitusername1update");
        when(request.getParameter("password")).thenReturn("unitpassword1update");
        when(request.getParameter("roleID")).thenReturn("1");
        

        UserAdminUpdateAccountC updateAccountServlet = new UserAdminUpdateAccountC();
        updateAccountServlet.doPost(request, response);

        verify(request, atMostOnce()).getParameter("accountID");
        verify(request, atMostOnce()).getParameter("name");
        verify(request, atMostOnce()).getParameter("username");
        verify(request, atMostOnce()).getParameter("password");
        verify(request, atMostOnce()).getParameter("roleID");
        verify(response, atMostOnce()).sendRedirect("/update-account.html?status=success");
        verify(response, never()).sendRedirect("/update-account.html?status=fail");
    }

    @Test 
    public void testUserAdminSearchAccountC () throws ServletException, IOException {
        when(request.getQueryString()).thenReturn("name=unitusername1update");
        when(response.getWriter()).thenReturn(outWritter);  

        UserAdminSearchAccountC searchAccountServlet = new UserAdminSearchAccountC();
        searchAccountServlet.doGet(request, response);

        verify(request, atMostOnce()).getQueryString();
    }
}