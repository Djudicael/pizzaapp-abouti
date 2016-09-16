package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Technique extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer comp = (Integer) req.getSession().getServletContext().getAttribute("compteur");
		RequestDispatcher dispatcher1 = (RequestDispatcher) this.getServletContext()
				.getRequestDispatcher("/WEB-INF/technique.jsp");
		req.setAttribute("compteur_affichage", comp);
		req.setAttribute("timer", req.getSession().getServletContext().getAttribute("time"));
		dispatcher1.forward(req, resp);
	}

}
