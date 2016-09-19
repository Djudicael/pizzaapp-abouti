package web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
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
		
		
		Map<String, List<Long>> mapPerf = (Map<String, List<Long>>) req.getServletContext().getAttribute("time");
		
		
	
		req.setAttribute("mapping", mapPerf);
		dispatcher1.forward(req, resp);
	}

}
