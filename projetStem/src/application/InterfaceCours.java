package application;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InterfaceCours extends Application {
	ListView<String> list = new ListView<>();
	Connection con;
	Statement st;
	ResultSet rs;
	Label message = new Label("BIENVENU(E) DANS L'ONGLET DES COURS VEUILLEZ CHOISIR VOTRE COURS");
	HBox hboxBar = new HBox();
	HBox contenuGenerale = new HBox();
	VBox contenuCours = new VBox();
	VBox contenuTitre = new VBox();
	BorderPane root = new BorderPane();
	Scene scene = new Scene(root, 1354, 750);
	Label titre = new Label("COURS");
	Label svt = new Label("SVT");
	Label chimie = new Label("CHIMIE");
	String MAP_IMAGE1 = "C:\\Users\\HP\\Pictures\\maison2.png";
	Image mapImage1 = new Image(MAP_IMAGE1);
	ImageView mapView1 = new ImageView(mapImage1);
	Button sortir = new Button();
	VBox vb1 = new VBox(message);
	VBox vbChimie = new VBox();
	VBox vbSvt = new VBox();
	String nom;
	public String Accueil(String nom) {
		this.nom= nom;
		return nom;
	}
	public void start(Stage arg0) throws Exception {
		sortir.setOnAction(e->{
			Accueil acceuil = new Accueil(nom);
			Stage stage =  (Stage) sortir.getScene().getWindow();
			Stage stage1 = new Stage();
			acceuil.start(stage1);
			stage.close();
		});
		contenuTitre.getChildren().addAll(svt);
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetstem", "root", "");
			System.out.println("Connection reussie");
		} catch (Exception er_con) {
			System.out.println("Erreur de connexion " + er_con.getMessage());
		}
		try {
			st = con.createStatement();
		} catch (SQLException er_st) {
			System.out.println("Erreur de Statement " + er_st.getMessage());
		}
		try {
			rs = st.executeQuery("select coursID,titre,idDomaine from cours");
			while (rs.next()) {
				int id = (int) rs.getObject(1);
				int domaine = (int) rs.getObject(3);
				String ed = "";
				ed += rs.getObject(2);
			Button	titreCours = new Button(ed);
			titreCours.setOnAction(e->{
				coursClasse  coursClasse = new coursClasse(); 
				vb1.getChildren().clear();
				vb1.getChildren().add(coursClasse.corpsCours(id));
			});
			if(domaine == 1) {
				vbSvt.getChildren().add(titreCours);
			}else {
				vbChimie.getChildren().add(titreCours);
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
		contenuTitre.getChildren().add(vbSvt);
		mapView1.setFitWidth(30);
		mapView1.setPreserveRatio(true);
		sortir.setGraphic(mapView1);
		hboxBar.getChildren().addAll(sortir, titre);
		contenuTitre.getChildren().add(chimie);
		contenuTitre.getChildren().add(vbChimie);
		contenuGenerale.getChildren().addAll(contenuTitre, contenuCours);
		root.setTop(hboxBar);
		root.setCenter(contenuGenerale);
		arg0.setScene(scene);
		arg0.show();
		
		vb1.setMaxWidth(996);
        ScrollPane scrollPane = new ScrollPane(vb1);
        contenuCours.getChildren().add(scrollPane);
        scrollPane.setPrefSize(996, 700);
        vb1.setPrefWidth(996);
		double widthBar = 1300;
		double heightBar = 40;
		double widthContenuTitre = 300;
		double heightContenuTitre = 700;
		double widthContenuCours = 996;
		double heightContenuCours = 700;
		hboxBar.setPrefSize(widthBar, heightBar);
		sortir.setStyle("-fx-base :blue;");
		contenuCours.setPrefSize(widthContenuCours, heightContenuCours);
		contenuTitre.setPrefSize(widthContenuTitre, heightContenuTitre);
		titre.setStyle("-fx-font-size: 30;-fx-font-family:'Times New Roman';");
		contenuTitre.setStyle("-fx-border-color:black;-fx-border-size:4;");
		contenuTitre.setSpacing(5);
		hboxBar.setStyle("-fx-background-color: blue;");
		hboxBar.setPadding(new Insets(10,0,0,0));
		hboxBar.setSpacing(700);
		svt.setStyle("-fx-background-color: blue; -fx-padding: 7 7 7 130;-fx-border-color:black;-fx-border-size:4;-fx-font-size: 15;-fx-font-family:'Times New Roman';-fx-text-fill: white;");
		svt.setPrefSize(300,10);
		chimie.setStyle("-fx-background-color: blue; -fx-padding: 7 7 7 120;-fx-border-color:black;-fx-border-size:4;-fx-font-size: 15;-fx-font-family:'Times New Roman';-fx-text-fill: white;");
		chimie.setPrefSize(300,10);
		titre.setStyle("-fx-text-fill: white;-fx-border-size:4;-fx-font-size: 35;");
		contenuTitre.setStyle("-fx-background-color: lightgray;");
		vbChimie.setSpacing(5);
		vbSvt.setSpacing(5);
		scrollPane.setStyle("-fx-base: white;");
		message.setStyle("-fx-font-size: 28; -fx-padding: 330 7 7 20;");
		  HBox.setHgrow(contenuCours, javafx.scene.layout.Priority.ALWAYS);
	}
}
