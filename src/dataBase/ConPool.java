package dataBase;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.Connection;

public class ConPool {

	ConNode[] queue;
	int front, rear, count;
	
	public ConPool() {
		this(5);
	}
	
	public ConPool(int size){
		queue = new ConNode[size];
		
		for(int i = 0; i < size; i++) {
			queue[i] = new ConNode();
		}
	}
	
	public Connection checkOut() {
		
	}
	
	public void returnCon(Connection con) {
		
	}
	
	public class ConNode{
		Connection con;
		
		public ConNode() {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3310/dnd","root","Ms@77798956");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		public Connection getCon() {
			return this.con;
		}
	}
}
