package com.romaric.project.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class conBDD {
 
 
	private Connection connOjbect = null;
	public Statement st = null;
	//private static String URL      = "//127.0.0.1/jsf";
	private static String URL ="//localhost:5432/EDBM";
	private static String userName = "postgres";
	private static String userPWD  = "postgres";
 

 
	public conBDD() {
		super();
	connectToDB();
 
	}
 
	private boolean connectToDB(){
 
		try{
			//Class.forName("org.gjt.mm.mysql.Driver") ;
			Class.forName("org.postgresql.Driver") ;
			System.out.println("driver ok");
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try 
		{
			connOjbect = DriverManager.getConnection("jdbc:postgresql:"+URL,"postgres","postgres");
			System.out.println("connexion ok");
			//connOjbect = DriverManager.getConnection("jdbc:mysql:"+URL,userName, userPWD);
			st = connOjbect.createStatement();
						
			return true;
			
		} catch (SQLException e) 
		{
			System.err.println("Mysql Connection Error: ");
			e.printStackTrace();
		}
		return false;	
	}
 
	public ResultSet getData(String SQL) {
		ResultSet results = null;
 
		if (connOjbect==null)
			connectToDB();
		try {
			results = connOjbect.createStatement().executeQuery(SQL);
			System.err.println("Impossible d'executer la requete");
 
		} catch (SQLException e) {
			System.err.println("Impossible d'executer la requete");
			e.printStackTrace();
		}
 
		return results;
 
 
	}
 
 
	public Connection getConnectionObject(){
		return connOjbect;
	}
 
 
}
