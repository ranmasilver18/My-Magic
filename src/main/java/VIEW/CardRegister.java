package VIEW;

import DAO.Cartadao;
import MODEL.Cartamodel;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "CardRegister", urlPatterns = { "/register_card" })
public class CardRegister extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/register_card");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cartamodel card = new Cartamodel();

		card.setCODE(req.getParameter("CODE"));
		card.setNAME(req.getParameter("NAME"));
		card.setCATEGORY(req.getParameter("CATEGORY"));
		card.setVALOR(req.getParameter("VALOR"));
		card.setQNT(req.getParameter("QNT"));

		Cartadao dao = new Cartadao();

		if (dao.CardRegister(card)) {
			req.setAttribute("magic", card);
			HttpSession session = req.getSession();
			session.setAttribute("magic", card);
		}
		
		resp.sendRedirect("index.jsp");
	}
	// private static final long serialVersionUID = 1L;

}
