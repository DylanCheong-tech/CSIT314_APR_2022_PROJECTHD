import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import honeyzstar.useradmin.*;

public class UserAdminLoginTest {

    @Mock
    private HttpServletRequest request;

    @Mock 
    private HttpServletResponse response;

    @Before 
    public void setUp () throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test 
    public void test () throws ServletException, IOException {
        when(request.getParameter("username")).thenReturn("username1");
        when(request.getParameter("password")).thenReturn("password");

        UserAdminLoginC loginServlet = new UserAdminLoginC();
        loginServlet.doPost(request, response);
    }
}