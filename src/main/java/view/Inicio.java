package view;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "Home", value = "/Home")
public class Inicio extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
        HttpSession session = req.getSession();
        if (session.getAttribute("moneda") == null) {
            session.setAttribute("moneda", "COP");
            session.setAttribute("nom_moneda", "$ Pesos Colombianos");
        }
        req.getRequestDispatcher("WEB-INF/index.jsp").forward(req, res);
    }
}
