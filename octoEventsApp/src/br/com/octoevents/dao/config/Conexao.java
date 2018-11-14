package br.com.octoevents.dao.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	private static Conexao instance;
	private Connection connection;
	private String hostName, userName, password, url, jdbcDriver, dbName, dbPrefix, dbPort;

	private Conexao(){
		hostName = "localhost";
		userName = "root";
		password ="";
		dbName = "/octoevent";
		dbPrefix ="jdbc:mysql://";
		dbPort = ":3306";
		jdbcDriver = "org.gjt.mm.mysql.Driver";
		url = dbPrefix + hostName + dbPort + dbName;
	}
	
	/**
	 * 
	 * @return
	 */
	public static synchronized Conexao getInstance(){
		if (instance == null){
			instance = new Conexao();	
		}
		return instance;
	}
	
	/**
	 * Pegando conexão
	 * 
	 * @return Connection
	 */
	public  Connection getConnection() {
		try{
			if(connection == null){
				Class.forName(jdbcDriver);
				connection = DriverManager.getConnection(url, userName, password);
			}
			else if(connection.isClosed()){
				connection = null;
				return getConnection();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	/**
	 * 
	 * 
	 */
	public void closeConnection(){
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}