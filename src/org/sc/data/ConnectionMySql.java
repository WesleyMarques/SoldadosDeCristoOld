package org.sc.data;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.*;

public class ConnectionMySql {
	
	private Connection conn;
	
	public Connection getConn(){
		return conn;
	}
	

	// M�todo Construtor da Classe
	public ConnectionMySql(String dName, String sName, String DB, String pw) throws Exception {
		conn = getConexaoMySQL(dName, sName, DB, pw);
	}
	
	// M�todo de Conex�o
	//user, server name, database e password
	private Connection getConexaoMySQL(String uName, String sName, String DB, String pw) throws Exception {
		Connection connection = null;
		// atributo do tipo Connection
		try {
			// Carregando o JDBC Driver padr�o
			String driverName = "com.mysql.jdbc.Driver";
			Class.forName(driverName);
			// nome do seu banco de dados
			String url = "jdbc:mysql://" + sName + "/" + DB;
			String username = uName;
			// nome de um usu�rio de seu BD
			String password = pw;
			// sua senha de acesso
			connection = (Connection) DriverManager.getConnection(url,
					username, password);
			return connection;
		} catch (ClassNotFoundException e) {
			// Driver n�o encontrado
			throw new Exception("O driver expecificado n�o foi encontrado.");
		} catch (SQLException e) {
			// N�o conseguindo se conectar ao banco
			throw new Exception("Nao foi possivel conectar ao Banco de Dados.");
		}
	} 
	
	// M�todo que retorna o status da sua conex�o
	public boolean isConnected() {
		return !conn.isClosed();
	}

	// M�todo que fecha sua conex�o//
	public boolean FecharConexao() {
		try {
			conn.close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
}
