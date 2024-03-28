package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class ConnexionBD {
	Connection con;
	Statement st;
	ResultSet rs;
	public Connection connexion() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetstem", "root", "");
			System.out.println("Connection reussie");
		} catch (Exception er_con) {
			System.out.println("Erreur de connexion " + er_con.getMessage());
		}
		return con;
	}
	public Statement creeStatement(Connection con) {
		try {
			st = con.createStatement();
		} catch (SQLException er_st) {
			System.out.println("Erreur de Statement " + er_st.getMessage());
		}
		return st;
	}
	public ResultSet resultSet(Statement statement,String sql) {
		try {
			rs = statement.executeQuery(sql);
		} catch (Exception er_rs) {
			System.out.println("Erreur ResultSet " + er_rs.getMessage());
		}
		return rs;
	}
}
