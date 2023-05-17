package VIEW;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Cartadao; // CHAMAR O PACOTE DAO E A CLASSE
import MODEL.Cartamodel;//CHAMAR O PACOTE MODEL E A CLASSE



@WebServlet(name = "cardupdate", urlPatterns = {"/edit-produto"})
public class CardUpdate extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher =  getServletContext().getNamedDispatcher("/webapp/edit.produto.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("ALTERAR CARD");
		Cartamodel card = new Cartamodel();
		
		card.setCODE(req.getParameter("CODE"));
		card.setNAME(req.getParameter("NAME"));
		card.setCATEGORY(req.getParameter("CATEGORY"));
		card.setVALOR(req.getParameter("VALOR"));
		card.setQNT(req.getParameter("QNT"));
		String page = "home.jsp";
		
		Cartadao dao = new Cartadao();
		
		if(dao.CardUpdate(card)){
			page = "home.jsp";
			req.setAttribute("magic", card);
		}else {
			req.setAttribute("ERROR", "CARTA NAO REGISTRADA");
		}
		
		RequestDispatcher request = req.getRequestDispatcher(page);
		request.forward(req, resp);
	}
	//private static final long serialVersionUID = 1L;
	
	

}
