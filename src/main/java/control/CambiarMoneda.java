package control;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "CambiarMoneda", value = "/CambiarMoneda")
public class CambiarMoneda extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        if (request.getParameter("moneda") != null) {
            switch (request.getParameter("moneda")) {
                case "MXN":
                    session.setAttribute("moneda", request.getParameter("moneda"));
                    session.setAttribute("nom_moneda", "$ Pesos Mexicanos");
                    break;
                case "USD":
                    session.setAttribute("moneda", request.getParameter("moneda"));
                    session.setAttribute("nom_moneda", "$ Dolar (USA)");
                    break;
                case "PEN":
                    session.setAttribute("moneda", request.getParameter("moneda"));
                    session.setAttribute("nom_moneda", "$ Sol Peruano");
                    break;
                default:
                    session.setAttribute("moneda", "COP");
                    session.setAttribute("nom_moneda", "$ Pesos Colombianos");
                    break;
            }

        }
        response.sendRedirect("Inicio");
    }
}
