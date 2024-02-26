package application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class coursClasse extends VBox {
	Connection con;
	Statement st;
	ResultSet rs;
	public VBox corpsCours(int id) 
	{
		VBox vb = new VBox();
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetstem", "root", "");
//			System.out.println("Connection reussie");
		} catch (Exception er_con) {
			System.out.println("Erreur de connexion " + er_con.getMessage());
		}
		try {
			st = con.createStatement();
		} catch (SQLException er_st) {
			System.out.println("Erreur de Statement " + er_st.getMessage());
		}
		try {
			if(id==5) {
				RSRG rsrg = new RSRG();
				vb.getChildren().add(rsrg.corps());
			}else {
			rs = st.executeQuery("select path from chemin where coursID = "+id);
			while (rs.next()) {
				String pathIG1 = (String) rs.getObject(1);
				Image IG1 = new Image(pathIG1);
				ImageView IG1V = new ImageView(IG1);
				IG1V.setFitWidth(996);
				IG1V.setPreserveRatio(true);
				vb.getChildren().add(IG1V);
				vb.setPrefWidth(996);
				vb.setSpacing(0);
			}
			if(id==6) {
				Model3D model3D = new Model3D();
				vb.getChildren().add(model3D.CreationModel3D());
			}
			}
		} catch (Exception er_rs) {
			System.out.println("Erreur ResultSet " + er_rs.getMessage());
		}
		try {
			rs.close();
			st.close();
			con.close();
		} catch (Exception d) {
		}
		return vb;
	}
}
