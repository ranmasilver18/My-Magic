package VIEW;

import java.beans.JavaBean;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CartaDao;
import MODEL.CartaModel;

@WebServlet(urlPatterns = { "/delete" })
public class CardDelete extends HttpServlet {
	// private static final long serialVersionUID = 1L;

	CartaDao cartad = new CartaDao();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println();

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TRANSFORMA O ID STRING EM INT id
		
		int userId = Integer.parseInt(req.getParameter("id"));

		CartaModel carta = new CartaModel();
		carta.setID(userId);
		try {
			CartaDao cartad = new CartaDao();
			cartad.CardDelete(carta);
			System.out.print("deletado");
			resp.sendRedirect("index.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
