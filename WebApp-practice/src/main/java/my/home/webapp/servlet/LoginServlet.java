package my.home.webapp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import my.home.webapp.dto.UserDTO;
import my.home.webapp.service.UserService;
import my.home.webapp.util.JspHelper;
import my.home.webapp.util.UrlPath;

import java.io.IOException;

@WebServlet(UrlPath.LOGIN)
public class LoginServlet extends HttpServlet {

    private final UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(JspHelper.getPath("login"))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userService.login(req.getParameter("email"),req.getParameter("password"))
                .ifPresentOrElse(
                        user -> onLoginSuccess(user, req,resp),
                        () ->onLoginFail(req, resp)
                );
    }

    private void onLoginFail(HttpServletRequest req, HttpServletResponse resp) {
        try {
            resp.sendRedirect("/login?error&email=" + req.getParameter("email"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void onLoginSuccess(UserDTO userDTO, HttpServletRequest req, HttpServletResponse resp){
        req.getSession().setAttribute("user", userDTO);
        try {
            resp.sendRedirect("/flights");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
