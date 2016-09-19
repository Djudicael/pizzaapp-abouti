package web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/techn")
public class Technique extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer comp = (Integer) req.getSession().getServletContext().getAttribute("compteur");
		RequestDispatcher dispatcher1 = (RequestDispatcher) this.getServletContext()
				.getRequestDispatcher("/WEB-INF/technique.jsp");
		req.setAttribute("compteur_affichage", comp);
		req.setAttribute("timer", req.getAttribute("time"));
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(comp, (String) req.getAttribute("time"));
		req.setAttribute("mapping", map);
		dispatcher1.forward(req, resp);
	}

}
