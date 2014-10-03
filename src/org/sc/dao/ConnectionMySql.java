package org.sc.dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class ConnectionMySql {
	
	private Connection conn;
	private Statement statementm;
	
	public Connection getConn(){
		return conn;
	}	

	// Método Construtor da Classe
	public ConnectionMySql(String dName, String sName, String DB, String pw) throws Exception {
		conn = getConexaoMySQL(dName, sName, DB, pw);
	}

	
	// Método de Conexão
	//user, server name, database e password
	private Connection getConexaoMySQL(String uName, String sName, String DB, String pw) throws ClassNotFoundException, SQLException{
		Connection connection = null;
		// atributo do tipo Connection
		try {
			// Carregando o JDBC Driver padrão
			String driverName = "com.mysql.jdbc.Driver";
			Class.forName(driverName);
			// nome do seu banco de dados
			String url = "jdbc:mysql://" + sName + "/" + DB;
			String username = uName;
			// nome de um usu�rio de seu BD
			String password = pw;
			// sua senha de acesso
			connection = (Connection) DriverManager.getConnection(url,username, password);
			return connection;
		} catch (ClassNotFoundException e) {
			// Driver não encontrado
			throw new ClassNotFoundException("Drive not found!");
		} catch (SQLException e) {
			// Não conseguindo se conectar ao banco
			throw new SQLException("Database connect not is possible. Try again!");
		}
	} 
	
	// Método que retorna o status da sua conexão
	public boolean isConnected() {
		return !conn.isClosed();
	}

	// Método que fecha sua conexão//
	public boolean close() {
		try {
			conn.close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	public ResultSet query(String queryString) throws SQLException{
		statementm = (Statement) this.conn.createStatement();
		return ((ResultSet) statementm.executeQuery(queryString));
	}
}
