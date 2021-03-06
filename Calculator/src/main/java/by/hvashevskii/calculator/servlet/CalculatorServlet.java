package by.hvashevskii.calculator.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/calc")
public class CalculatorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double num1 = Double.parseDouble(req.getParameter("num1"));
        double num2 = Double.parseDouble(req.getParameter("num2"));
        String operation = req.getParameter("operation");
        switch (operation) {
            case "addition":
                req.setAttribute("result",num1 + num2);
                break;
            case "subtraction":
                req.setAttribute("result",num1 - num2);
                break;
            case "multiplication":
                req.setAttribute("result",num1 * num2);
                break;
            case "division":
                req.setAttribute("result",num1 / num2);
                break;
        }
        getServletContext().getRequestDispatcher("/pages/calc.jsp").forward(req, resp);
    }
}

