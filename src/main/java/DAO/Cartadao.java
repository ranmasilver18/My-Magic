package DAO;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import MODEL.CartaModel;

public class CartaDao {

	public boolean CardRegister(CartaModel magic) {
		// VARIABEL QUE RECEBE A QUERY PARA ADICIONAR DADOS AO BANCO
		String iSQL = "INSERT INTO magic (CODE, NAME, CATEGORY, VALOR, QNT) VALUES (?,?,?,?,?)";
		PreparedStatement ps;

		try {
			ps = Dbconnection.getConnection().prepareStatement(iSQL);
			ps.setString(1, magic.getCODE()); // TALVES SEJA 2 POR CAUSA DO AUTO INCREMENT ID
			ps.setString(2, magic.getNAME());
			ps.setString(3, magic.getCATEGORY());
			ps.setString(4, magic.getVALOR());
			ps.setString(5, magic.getQNT());
			ps.executeUpdate();
			return true;
		} catch (SQLException error) {
			error.printStackTrace();
		}

		return false;
	}

	public boolean CardUpdate(CartaModel magic) {
		try {
		String isql = "UPDATE magic SET CODE = ?, NAME =?, CATEGORY =?, VALOR =?, QNT=? WHERE ID=?;";
		PreparedStatement ps = Dbconnection.getConnection().prepareStatement(isql);
		ps.setString(1, magic.getCODE());
		ps.setString(2, magic.getNAME());
		ps.setString(3, magic.getCATEGORY());
		ps.setString(4, magic.getQNT());
		ps.setString(5, magic.getVALOR());
		ps.setInt(6, magic.getID());
		
		int rowsUpdate = ps.executeUpdate();
		ps.close();
		return true;
			
		} catch (SQLException error) {
			error.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}


	public void CardDelete(CartaModel carta) throws SQLException {
		String delete = "DELETE FROM magic WHERE ID=?;";
		
		try {
			Connection cn = Dbconnection.getConnection();
			PreparedStatement ps = cn.prepareStatement(delete);
			ps.setInt(1, carta.getID());
			ps.executeUpdate();
			cn.close();
		}catch(SQLException error) {
			error.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * public void CardDelete(String toDelete) { //VARIAVEL QUE VAI RECEBER A QUERY
	 * PARA DELETAR ITEM DO BANCO String isql = "DELETE FROM magic WHERE ID=?;";
	 * PreparedStatement ps;
	 * 
	 * //CONDIÇÃO PARA EXECUTAR A QUERY try {
	 * 
	 * ps = Dbconnection.getConnection().prepareStatement(isql); ps.setString(1,
	 * toDelete); ps.executeUpdate(); //return true; }catch(SQLException error) {
	 * error.printStackTrace(); }
	 * 
	 * //return false; }
	 * 
	 * 
	 * 
	 */

	public CartaModel cardFindById(String ID) {

		// CODIGO PARA PROCURAR CARTA PELO ID DELA
		CartaModel cartamodel = new CartaModel();

		try {
			String sql = "SELECT ID, CODE, NAME, CATEGORY, VALOR, QNT FROM magic WHERE ID=?;";
			PreparedStatement connection = Dbconnection.getConnection().prepareStatement(sql);
			connection.setString(1, ID);
			ResultSet result = connection.executeQuery();

			if (result.next()) {
				cartamodel.setID(result.getInt("ID"));
				cartamodel.setCODE(result.getString("CODE"));
				cartamodel.setNAME(result.getString("NAME"));
				cartamodel.setCATEGORY(result.getString("CATEGORY"));
				cartamodel.setVALOR(result.getString("VALOR"));
				cartamodel.setQNT(result.getString("QNT"));
				return cartamodel;
			}
			result.close();
			connection.close();

		} catch (SQLException error) {
			error.printStackTrace();
		}
		return cartamodel;
	}

	public ArrayList<CartaModel> searchCards() {

		ArrayList<CartaModel> listCards = new ArrayList<>();
		// ESSA CLASSE ARRAI VAI TRAZER UMA LISTA COM TODOS OS CARDS CADASTRADOS
		try {
			String sql = "SELECT * FROM magic;";
			PreparedStatement connection = Dbconnection.getConnection().prepareStatement(sql);

			ResultSet result = connection.executeQuery();

			// CONDICIONAL PARA LISTA
			while (result.next()) {
				CartaModel cartamodel = new CartaModel();
				cartamodel.setID(result.getInt("ID"));
				cartamodel.setCODE(result.getString("CODE"));
				cartamodel.setNAME(result.getString("NAME"));
				cartamodel.setCATEGORY(result.getString("CATEGORY"));
				cartamodel.setVALOR(result.getString("VALOR"));
				cartamodel.setQNT(result.getString("QNT"));

				listCards.add(cartamodel);
			}

			result.close();
			connection.close();

		} catch (SQLException error) {
			error.printStackTrace();
		}

		return listCards;
	}

}
