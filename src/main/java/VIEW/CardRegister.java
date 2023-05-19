package VIEW;

import DAO.CartaDao;
import MODEL.CartaModel;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "/register", urlPatterns = { "/add-produtos", "/register" })
public class CardRegister extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/add-produtos");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
			
		CartaModel card = new CartaModel();
		
		card.setCODE(req.getParameter("code"));
		card.setNAME(req.getParameter("name"));
		card.setCATEGORY(req.getParameter("category"));
		card.setVALOR(req.getParameter("valor"));
		card.setQNT(req.getParameter("qnt"));

		CartaDao dao = new CartaDao();

		if (dao.CardRegister(card)) {
			req.setAttribute("magic", card);
			HttpSession session = req.getSession();
			session.setAttribute("magic", card);
		}
		
		resp.sendRedirect("index.jsp");
	}
	// private static final long serialVersionUID = 1L;

}
