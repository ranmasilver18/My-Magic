package VIEW;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CartaDao; // CHAMAR O PACOTE DAO E A CLASSE
import MODEL.CartaModel;//CHAMAR O PACOTE MODEL E A CLASSE



@WebServlet(name = "CardUpdate", urlPatterns = { "/edit-produt.jsp", "/update" })
public class CardUpdate extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher =  getServletContext().getNamedDispatcher("/Servlet_Project/src/main/webapp/edit-produto.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("ID"));
		String code = req.getParameter("CODE");
        String name = req.getParameter("name");
        String category = req.getParameter("CATEGORY");
        String valor = req.getParameter("VALOR");
        String qnt = req.getParameter("QNT");
		
		
		CartaModel card = new CartaModel();
		card.setID(id);
		card.setCODE(code);
		card.setNAME(name);
		card.setCATEGORY(category);
		card.setVALOR(valor);
		card.setQNT(qnt);
		String page = "home.jsp";
		
		CartaDao dao = new CartaDao();
		
		if(dao.CardUpdate(card)){
			page = "index.jsp";
			req.setAttribute("magic", card);
		}else {
			req.setAttribute("ERROR", "CARTA NAO REGISTRADA");
		}
		
		RequestDispatcher request = req.getRequestDispatcher(page);
		request.forward(req, resp);
	}
	
}
