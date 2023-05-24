package VIEW;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CartaDao;
import MODEL.CartaModel;



@WebServlet(name = "delete", urlPatterns = {"/delete" })
public class CardDelete extends HttpServlet {
	//private static final long serialVersionUID = 1L;

	CartaDao cartad = new CartaDao();
	CartaModel cartam = new CartaModel();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int userId = Integer.parseInt(req.getParameter("ID"));
		// Obtém o ID do item a ser excluído a partir dos parâmetros da requisição
		
		cartam.setID(userId);
		try {
			cartad.CardDelete(cartam);
			System.out.print("deletado");
			resp.sendRedirect("index.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
