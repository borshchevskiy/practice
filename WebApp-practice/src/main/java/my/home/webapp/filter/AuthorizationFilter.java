package my.home.webapp.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import my.home.webapp.dto.UserDTO;
import my.home.webapp.util.UrlPath;

import java.io.IOException;
import java.util.Set;

@WebFilter("/*")
public class AuthorizationFilter implements Filter {


    private static final Set<String> PUBLIC_PATH = Set.of(UrlPath.LOGIN, UrlPath.REGISTRATION, UrlPath.IMAGES, UrlPath.LOCALE);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String requestURI = ((HttpServletRequest) request).getRequestURI();
        if (isPublicPath(requestURI) || isUserLoggedIn(request)) {
            chain.doFilter(request, response);
        } else {
            String prevPage = ((HttpServletRequest) request).getHeader("referer");
            ((HttpServletResponse)response).sendRedirect(prevPage != null ? prevPage : UrlPath.LOGIN);
        }
    }

    private boolean isUserLoggedIn(ServletRequest request) {
        UserDTO user = (UserDTO) ((HttpServletRequest) request).getSession().getAttribute("user");
        return user != null;
    }

    private boolean isPublicPath(String requestURI) {
        return PUBLIC_PATH.stream().anyMatch(requestURI::startsWith);

    }


}
