package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
//import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.BorderStroke;
//import javafx.scene.layout.BorderStrokeStyle;
//import javafx.scene.layout.BorderWidths;
//import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AuthentificationPage extends Application {
	Stage Windows;
	Scene scene;
	ImageView image = new ImageView();
	Image logo = new Image("D:\\eclipse\\avatars\\loginLogo.png");
	Label titre = new Label("Plateforme d'apprentissage");
	Label titreConnexion = new Label("Connexion");
	Label pied = new Label("Projet Java 2023|Salla NGOM - Fatou KASSE");
	TextField UserName = new TextField();
	PasswordField password = new PasswordField();
	Button connecter = new Button("Login");
	VBox FormulaireDeConnexion = new VBox();
	HBox hbox = new HBox();
	HBox ZoneDeConnexion = new HBox();
	HBox hboxTitrePrincipale = new HBox(titre);
	VBox vboxPrincipalConnexion = new VBox();
	HBox hboxtitreConnexion = new HBox(titreConnexion);
	VBox vboxpied = new VBox(pied);
	BorderPane borderPane = new BorderPane();
	Label labelstatut = new Label("Username|mot de passe incorrect");
	Label vide = new Label("un champ est vide");

	@Override
	public void start(Stage Windows) throws Exception {
		labelstatut.setStyle("-fx-text-fill: red");
		vide.setStyle("-fx-text-fill: red");
		labelstatut.setVisible(false);
		vide.setVisible(false);
		image.setImage(logo);
		UserName.setPromptText("Username");
		password.setPromptText("Password");
		FormulaireDeConnexion.getChildren().addAll(labelstatut, UserName, password, vide, connecter);
		ZoneDeConnexion.getChildren().addAll(image, FormulaireDeConnexion);
		vboxPrincipalConnexion.getChildren().addAll(hboxtitreConnexion, ZoneDeConnexion);
		borderPane.setTop(hboxTitrePrincipale);
		borderPane.setCenter(vboxPrincipalConnexion);
		borderPane.setBottom(vboxpied);
		String Chbg = "C:\\Users\\HP\\Pictures\\UNI107029.jpg";
		BackgroundImage bg = new BackgroundImage(new javafx.scene.image.Image(Chbg), BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, null,
				new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true));
		borderPane.setBackground(new javafx.scene.layout.Background(bg));
		scene = new Scene(borderPane, 1354, 750);
		Windows.setTitle("Connexion");
		Windows.setScene(scene);
		Windows.show();
		// stylisation
//		Border border = new Border(
//				new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(1)));

		titre.setStyle("-fx-background-color: blue;-fx-font-family:'Times New Roman'; -fx-font-size: 30 vm;");
		hboxTitrePrincipale.setPadding(new Insets(0, 100, 0, 600));
		hboxTitrePrincipale.setStyle("-fx-background-color: blue;");
//		vboxPrincipalConnexion.setStyle("-fx-background-color: gray;");
		titre.setPadding(new Insets(0, 0, 0, 0));
		image.setFitWidth(500);
		image.setFitHeight(200);
		image.setPreserveRatio(true);
		FormulaireDeConnexion.setPadding(new Insets(50, 0, 100, 0));
		FormulaireDeConnexion.setSpacing(10);
		hboxtitreConnexion.setPadding(new Insets(0, 0, 0, 150));
		BorderPane.setMargin(vboxPrincipalConnexion, new Insets(100, 100, 450, 200));
		VBox.setMargin(connecter, new Insets(0, 0, -100, 180));
		BorderPane.setMargin(vboxpied, new Insets(-150, 100, 10, 610));
		HBox.setMargin(titreConnexion, new Insets(0, 0, -20, 280));
		titreConnexion.setStyle("-fx-font-size: 70 vm; -fx-font-family: 'Roboto'; -fx-min-width: 200;");
		titreConnexion.setTextFill(Color.BLUE);
		ZoneDeConnexion.setPadding(new Insets(-20, 0, 0, 0));
//		vboxPrincipalConnexion.setBorder(border);
		UserName.setPrefSize(0, 50);
		password.setPrefSize(800, 50);
		UserName.setStyle("-fx-font-size: 15");
		password.setStyle("-fx-font-size: 15");
		connecter.setStyle("-fx-base: green;-fx-margin: 10; -fx-size: 10;");
		connecter.setPrefSize(500, 50);
		connecter.setOnAction(e -> {
			String userName = UserName.getText();
			String pdw = (String) password.getText().toString();
			if ((!userName.isEmpty()) && (!pdw.isEmpty())) {
				String sql = "select * from user where userName='" + userName + "' and password='" + pdw + "'";
				ConnexionBD connexionBd = new ConnexionBD();
				Connection con = connexionBd.connexion();
				Statement st = connexionBd.creeStatement(con);
				ResultSet rs = connexionBd.resultSet(st, sql);
				try {
					if (rs.next()) {
						String nom = "" + rs.getObject(2);
						if (rs.getObject(5).equals("utilisateur")) {
							Accueil acceuil = new Accueil(nom);
							Stage stage1 = new Stage();
							acceuil.start(stage1);
							Windows.close();
						} else {
							AdminPage adminPage = new AdminPage(nom);
							Stage stage1 = new Stage();
							adminPage.start(stage1);
							Windows.close();
						}
					} else {
						vide.setVisible(false);
						labelstatut.setVisible(true);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				UserName.clear();
				password.clear();
			} else {
				labelstatut.setVisible(false);
				vide.setVisible(true);
			}

		});
	}

	public static void main(String[] args) {
		launch(args);
	}
}
