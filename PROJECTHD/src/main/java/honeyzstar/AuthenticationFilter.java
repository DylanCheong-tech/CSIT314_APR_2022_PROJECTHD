package honeyzstar;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AuthenticationFilter implements Filter {
    @Override
    public void init(FilterConfig config) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpSession session = ((HttpServletRequest) request).getSession(false);

        String requestPath = ((HttpServletRequest) request).getRequestURI();

        if (!requestPath.contains("customer") && !requestPath.equals("/login.html") && requestPath.endsWith(".html") && (session == null || session.getAttribute("username") == null)) {
            ((HttpServletResponse) response).sendRedirect("/login.html");
            
        } else {
            chain.doFilter(request, response);
        }
    }
}
