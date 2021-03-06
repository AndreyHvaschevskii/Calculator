package by.hvashevskii.calculator.servlet;

import by.hvashevskii.calculator.entity.AuthService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "auth", value = "/auth")
public class AuthServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        boolean isAuth = AuthService.checkAuth(login, password);

        if (isAuth) {
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/calc");
            requestDispatcher.forward(req, resp);
        } else {
            req.setAttribute("errorMessage", "Неправильный логин или пароль!");

            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }

    }

}
