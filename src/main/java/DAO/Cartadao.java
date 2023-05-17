package DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import MODEL.Cartamodel;

public class Cartadao {
	
	
	
	public boolean CardRegister(Cartamodel magic) {
		//VARIABEL QUE RECEBE A QUERY PARA ADICIONAR DADOS AO BANCO 
		String iSQL = "INSERT INT magic"+"(CODE, NAME, CATEGORY, VALOR, QNT)"+"(?;?;?;?;?)";
		PreparedStatement ps ;
		
		try {
			ps = Dbconnection.getConnection().prepareStatement(iSQL);
			ps.setString(2, magic.getCODE()); //TALVES SEJA 2 POR CAUSA DO AUTO INCREMENT ID
			ps.setString(3, magic.getNAME());
			ps.setString(4, magic.getCATEGORY());
			ps.setString(5, magic.getVALOR());
			ps.setString(6, magic.getQNT());
			ps.executeUpdate();
			return true;
		}catch(SQLException error){
			error.printStackTrace();
		}
		
		return false;		
	}
	
	
	public boolean CardUpdate(Cartamodel magic) {
		//STRING QUE RECEBE A QUERY PARA ATUALIZAR NO BANCO DE DADOS
		String isql = "UPDATE magic SET CODE = ?, NAME =?, CATEGORY =?, VALOR =?, QNT=? + WHERE ID=?;";
		
		PreparedStatement ps;
		//CODIGO PARA GERAR O UPDATE
		try{
			ps = Dbconnection.getConnection().prepareStatement(isql);
			ps.setString(2, magic.getCODE());
			ps.setString(3, magic.getNAME());
			ps.setString(4, magic.getCATEGORY());
			ps.setString(5, magic.getVALOR());
			ps.setString(6, magic.getQNT());
			return true;
		}catch(SQLException error) {
			error.printStackTrace();
		}
		
		return false;
		
	}
	
	public boolean CardDelete(Integer toDelete) {
		//VARIAVEL QUE VAI RECEBER A QUERY PARA DELETAR ITEM DO BANCO
		String isql = "DELETE FROM magic WHERE ID=?;";
		PreparedStatement ps;
		
		//CONDIÇÃO PARA EXECUTAR A QUERY
		try {
			
			ps = Dbconnection.getConnection().prepareStatement(isql);
			ps.setInt(1, toDelete);
			ps.executeUpdate();
			return true;
		}catch(SQLException error) {
			error.printStackTrace();
		}
		
		return false;
	}
	
	
	public boolean CardUpdate(Integer ID) {
		
		//CODIGO PARA PROCURAR CARTA PELO ID DELA
		
		try {
			String sql = "SELECT FROM magic WHERE ID=?;";
			PreparedStatement connection = Dbconnection.getConnection().prepareStatement(sql);
			connection.setInt(1, ID);
			ResultSet result = connection.executeQuery();
			Cartamodel cartamodel = new Cartamodel();
			
			if(result.next()) {
				cartamodel.setID(result.getInt("ID"));
				cartamodel.setCODE(result.getString("CODE"));
				cartamodel.setNAME(result.getString("NOME"));
				cartamodel.setCATEGORY(result.getString("CATEGORY"));
				cartamodel.setVALOR(result.getString("VALOR"));
				cartamodel.setQNT(result.getString("QNT"));
			}
			result.close();
			connection.close();
			
		}catch(SQLException error) {
			error.printStackTrace();
		}
		return false;
	}
	
	public ArrayList<Cartamodel> searchCards(){
		
		//ESSA CLASSE ARRAI VAI TRAZER UMA LISTA COM TODOS OS CARDS CADASTRADOS
		try {
			String sql = "SELECT * FROM magic;";
			PreparedStatement connection = Dbconnection.getConnection().prepareStatement(sql);
			
			ResultSet result = connection.executeQuery();
			
			ArrayList<Cartamodel> listCards = new ArrayList<>();
			//CONDICIONAL PARA LISTA
			while(result.next()) {
				Cartamodel cartamodel = new Cartamodel();
				
				cartamodel.setID(result.getInt("ID"));
				cartamodel.setNAME(result.getString("NOME"));
				cartamodel.setCATEGORY(result.getString("CATEGORY"));
				cartamodel.setVALOR(result.getString("VALOR"));
				cartamodel.setQNT(result.getString("QNT"));
				
				listCards.add(cartamodel);
			}
			
			result.close();
			connection.close();
			
		}catch(SQLException error) {
			error.printStackTrace();
		}
		
		return null;
	}

}
