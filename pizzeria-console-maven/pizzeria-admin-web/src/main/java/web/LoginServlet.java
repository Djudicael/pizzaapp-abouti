package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/authe")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = (RequestDispatcher) this.getServletContext()
				.getRequestDispatcher("/WEB-INF/login.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String emailStocked = "admin@pizzeria.fr";
		String passwordStocked = "admin";

		if (email.equals(emailStocked) && password.equals(passwordStocked)) {
			/* Préparation de l'objet formulaire */

			/* Récupération de la session depuis la requête */
			HttpSession session = req.getSession();

			/**
			 * Si aucune erreur de validation n'a eu lieu, alors ajout du bean
			 * Utilisateur à la session, sinon suppression du bean de la
			 * session.
			 */

			/* Stockage du formulaire et du bean dans l'objet request */
			session.setAttribute("user", email);

			resp.sendRedirect(req.getContextPath() + "/listes");

		} else {
			doGet(req, resp);

		}

	}

}
