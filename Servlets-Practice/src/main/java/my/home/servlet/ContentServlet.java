package my.home.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import my.home.servlet.util.JspHelper;

import java.io.IOException;

@WebServlet("/content")
public class ContentServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //req.setAttribute();
        req.getRequestDispatcher(JspHelper.getPath("content"))
                .forward(req,resp);
    }
}
