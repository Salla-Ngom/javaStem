package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AdminPage extends Application {
	Button valider = new Button("Valider");
	Button validerM = new Button("Valider");
	Button annuler = new Button("Annuler");
	Button annulerM = new Button("Annuler");
	TextField tNomA = new TextField();
	String nomSecUser= "";
	TextField tUsernameA = new TextField();
	PasswordField tpwdA = new PasswordField();
	TextField tSituationM = new TextField();
	TextField tNomM = new TextField();
	TextField tUsernameM = new TextField();
	PasswordField tpwdM = new PasswordField();
	TextField tSituationA = new TextField();
	Label lNom = new Label("Nom");
	Label lUsername = new Label("Username");
	Label lPwd = new Label("Password");
	Label lSituation = new Label("Situation");
	Label lNomM = new Label("Nom");
	Label lUsernameM = new Label("Username");
	Label lPwdM = new Label("Password");
	Label lSituationM = new Label("Situation");
	GridPane gpA = new GridPane();
	GridPane gpM = new GridPane();
	Button bafficher = new Button();
	Button binserer = new Button();
	Button bsupprimer = new Button();
	Label titre = new Label();
	HBox user = new HBox();
	Label nbUtilisateur = new Label("34");
	Label nbCours = new Label("3");
	Label nbMatiere = new Label("3");
	HBox nombre = new HBox(nbUtilisateur, nbMatiere, nbCours);
	VBox vboxUser = new VBox();
	VBox vboxMatiere = new VBox();
	VBox vboxNiveau = new VBox();
	VBox vboxCours = new VBox();
	BorderPane bp = new BorderPane();
	Scene scene = new Scene(bp, 1354, 750);
	Label nomUser = new Label();
	Button Deconnexion = new Button("Deconnexion");
	Button accueil = new Button("Accueil");
	Button lister = new Button("Liste-Utilisateur");
	Button listerCours = new Button("Liste-Cours");
	Button listerMatiere = new Button("Liste-Matiere");
	HBox menu = new HBox(accueil, lister, listerMatiere, listerCours);
	HBox bDec = new HBox(Deconnexion);
	HBox hboxtable = new HBox();
	HBox hboxtable1 = new HBox();
	HBox hbox1 = new HBox(vboxUser, vboxMatiere, vboxCours);
	VBox vbox1 = new VBox(hbox1, nombre);
	HBox profil = new HBox(imageView("profil", 50, 50), nomUser);
	HBox hboxBar = new HBox(profil, menu, bDec);
	HBox hboxButton = new HBox(binserer, bafficher, bsupprimer);
	String nomuser;

	@Override
	public void start(Stage arg0) throws Exception {
		String sql1 = "select Count(statut) from user where statut = 'utilisateur'";
		String sql2 = "select Count(*) from cours";
		String sql3 = "select Count(*) from domaine";
		ConnexionBD connexionBd = new ConnexionBD();
		Connection con = connexionBd.connexion();
		Statement st = connexionBd.creeStatement(con);
		ResultSet rs1= connexionBd.resultSet(st, sql1);
		while (rs1.next()) {
			String b = (String) (rs1.getObject(1)).toString();
			nbUtilisateur.setText(b);
		}
		ResultSet rs2= connexionBd.resultSet(st, sql2);
		while (rs2.next()) {
			String b = (String) (rs2.getObject(1)).toString();
			nbCours.setText(b);
		}
		ResultSet rs3= connexionBd.resultSet(st, sql3);
		while (rs3.next()) {
			String b = (String) (rs3.getObject(1)).toString();
			nbMatiere.setText(b);
		}
		gpA.setHgap(20);
		gpA.setVgap(10);
		gpA.add(lNom, 0, 0);
		gpA.add(lUsername, 1, 0);
		gpA.add(lPwd, 2, 0);
		gpA.add(lSituation, 3, 0);
		gpA.add(tNomA, 0, 1);
		gpA.add(tUsernameA, 1, 1);
		gpA.add(tpwdA, 2, 1);
		gpA.add(tSituationA, 3, 1);
		gpA.add(valider, 1, 2);
		gpA.add(annuler, 2, 2);
		gpM.setHgap(20);
		gpM.setVgap(10);
		gpM.add(lNomM, 0, 0);
		gpM.add(lUsernameM, 1, 0);
		gpM.add(lPwdM, 2, 0);
		gpM.add(lSituationM, 3, 0);
		gpM.add(tNomM, 0, 1);
		gpM.add(tUsernameM, 1, 1);
		gpM.add(tpwdM, 2, 1);
		gpM.add(tSituationM, 3, 1);
		gpM.add(validerM, 1, 2);
		gpM.add(annulerM, 2, 2);
		GridPane.setMargin(valider, new Insets(0,0,0,50));
		GridPane.setMargin(validerM, new Insets(0,0,0,50));
		GridPane.setMargin(annuler, new Insets(0,0,0,50));
		GridPane.setMargin(annulerM, new Insets(0,0,0,50));
		accueil.setOnAction(e -> {
			AdminPage adminPage = new AdminPage(nomuser);
			Stage stage1 = new Stage();
			try {
				adminPage.start(stage1);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			arg0.close();
		});
		binserer.setGraphic(imageView(
				"22360049-ajouter-utilisateur-vecteur-icone-enregistrement-illustration-signe-avatar-symbole-nouveau-profil-logo-vectoriel-removebg-preview",
				200, 50));
		bafficher.setGraphic(imageView("png-transparent-computer-icons-avatar-user-profile-avatar", 200, 50));
		bsupprimer.setGraphic(imageView("6467134", 200, 50));
		TableView<Cours> tableCours;
		TableColumn<Cours, String> titreCours;
		tableCours = new TableView<>();
		titreCours = new TableColumn<>("COURS");
		titreCours.setCellValueFactory(new PropertyValueFactory<>("titre"));
		titreCours.setMinWidth(900);
		tableCours.getColumns().add(titreCours);
		TableView<Matiere> tableMatiere;
		TableColumn<Matiere, String> titreMatiere;
		tableMatiere = new TableView<>();
		titreMatiere = new TableColumn<>("Matieres");
		titreMatiere.setCellValueFactory(new PropertyValueFactory<>("titreMatiere"));
		titreMatiere.setMinWidth(900);
		tableMatiere.getColumns().add(titreMatiere);
		TableView<Utilisateur> table;
		TableColumn<Utilisateur, String> nom;
		TableColumn<Utilisateur, String> username;
		TableColumn<Utilisateur, String> motDePasse;
		TableColumn<Utilisateur, String> situation;
		table = new TableView<>();
		nom = new TableColumn<>("NOM");
		nom.setMinWidth(200);
		nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
		username = new TableColumn<>("USERNAME");
		username.setMinWidth(200);
		username.setCellValueFactory(new PropertyValueFactory<>("username"));
		motDePasse = new TableColumn<>("PASSWORD");
		motDePasse.setMinWidth(200);
		motDePasse.setCellValueFactory(new PropertyValueFactory<>("mdp"));
		situation = new TableColumn<>("SITUATION");
		situation.setMinWidth(200);
		situation.setCellValueFactory(new PropertyValueFactory<>("situation"));
		table.getColumns().add(nom);
		table.getColumns().add(username);
		table.getColumns().add(motDePasse);
		table.getColumns().add(situation);
		arg0.setScene(scene);
		arg0.setTitle("PageAdmin");
		arg0.show();
		nomUser.setText(nomuser);
		vboxUser.getChildren().addAll(imageView("png-transparent-computer-icons-avatar-user-profile-avatar", 200, 400));
		vboxMatiere.getChildren().add(imageView(
				"marche_livre_460-tt-width-460-height-260-fill-0-crop-0-bgcolor-eeeeee-removebg-preview", 400, 800));
		vboxCours.getChildren().add(imageView("3_15-removebg-preview", 220, 800));
		hboxBar.setSpacing(10);
		vbox1.setSpacing(20);
		hbox1.setSpacing(250);
		nombre.setSpacing(300);
		hboxBar.setStyle("-fx-background-color: blue;");
		VBox.setMargin(hbox1, new Insets(50, 0, 0, 100));
		VBox.setMargin(nombre, new Insets(0, 0, 0, 200));
		HBox.setMargin(vboxCours, new Insets(50, 0, 0, -70));
		HBox.setMargin(nbMatiere, new Insets(0, 0, 0, 200));
		VBox.setMargin(hboxtable, new Insets(0, 100, 0, 0));
		HBox.setMargin(nbCours, new Insets(0, 0, 0, 180));
		HBox.setMargin(vboxMatiere, new Insets(0, 0, 0, 0));
		bDec.setPadding(new Insets(15, 0, 0, 450));
		menu.setSpacing(50);
		menu.setPadding(new Insets(20, 0, 0, 200));
		nomUser.setPadding(new Insets(10, 0, 0, 0));
		nomUser.setTextFill(Color.WHITE);
		Deconnexion.setStyle("-fx-base:RED;");
		valider.setStyle("-fx-base : green;");
		annuler.setStyle("-fx-base : red;");
		validerM.setStyle("-fx-base : green;");
		annulerM.setStyle("-fx-base : red;");
		bp.setTop(hboxBar);
		bp.setCenter(vbox1);
		nbCours.setStyle("-fx-font-size:15;");
		nbMatiere.setStyle("-fx-font-size:15;");
		nbUtilisateur.setStyle("-fx-font-size:15;");
		hboxButton.setPadding(new Insets(20, 0, 0, 50));
		hboxButton.setSpacing(100);
		table.setPrefWidth(800);
		hboxtable.setPrefSize(50, 300);
		hboxtable1.setPrefSize(600, 100);

		Deconnexion.setOnAction(e -> {
			Stage stage = (Stage) Deconnexion.getScene().getWindow();
			AuthentificationPage authentificationPage = new AuthentificationPage();
			Stage stage1 = new Stage();
			try {
				authentificationPage.start(stage1);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			stage.close();

		});
		lister.setOnAction(e -> {
			vbox1.setPadding(new Insets(50, 0, 0, 200));
			vbox1.getChildren().clear();
			hboxtable1.getChildren().clear();
			titre.setText("Liste des utilisateurs");
			vbox1.getChildren().add(titre);
			String statut = "utilisateur";
			String sql = "select * from user where statut='" + statut + "'";
			ResultSet rs = connexionBd.resultSet(st, sql);
			table.getItems().clear();
			try {
				while (rs.next()) {
					String nomuser1 = "" + rs.getObject(2);
					String userName = "" + rs.getObject(3);
					String mdp = "" + rs.getObject(4);
					String situationUser = "" + rs.getObject(6);
					Utilisateur utilisateur = new Utilisateur();
					utilisateur.setNom(nomuser1);
					utilisateur.setUsername(userName);
					utilisateur.setMdp(mdp);
					utilisateur.setSituation(situationUser);
					table.getItems().add(utilisateur);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			hboxtable1.getChildren().add(table);
			HBox.setMargin(table, new Insets(0, 100, 0, 0));
			vbox1.getChildren().add(hboxtable1);
			vbox1.getChildren().add(hboxButton);
		});
		listerCours.setOnAction(e -> {
			vbox1.setPadding(new Insets(50, 0, 0, 200));
			vbox1.getChildren().clear();
			titre.setText("Liste des cours");
			hboxtable.getChildren().clear();
			vbox1.getChildren().add(titre);
			tableCours.getItems().clear();
			String sql = "select * from cours";
			ResultSet rs = connexionBd.resultSet(st, sql);
			try {
				while (rs.next()) {
					String titreq = "" + rs.getObject(2);
					Cours cs = new Cours();
					cs.setTitre(titreq);
					tableCours.getItems().add(cs);
//					System.out.println(titreq);
				}
			} catch (SQLException e1) {
//				 TODO Auto-generated catch block
				e1.printStackTrace();
			}

			hboxtable.getChildren().add(tableCours);

			vbox1.getChildren().add(hboxtable);
		});
		listerMatiere.setOnAction(e -> {
			vbox1.setPadding(new Insets(50, 0, 0, 200));
			vbox1.getChildren().clear();
			titre.setText("Liste des cours");
			hboxtable.getChildren().clear();
			vbox1.getChildren().add(titre);
			tableCours.getItems().clear();
			String sql = "select * from domaine";
			ResultSet rs = connexionBd.resultSet(st, sql);
			try {
				while (rs.next()) {
					String titreq = "" + rs.getObject(2);
					Matiere Mt = new Matiere();
					Mt.setTitreMatiere(titreq);
					tableMatiere.getItems().add(Mt);
//					System.out.println(titreq);
				}
			} catch (SQLException e1) {
//				 TODO Auto-generated catch block
				e1.printStackTrace();
			}

			hboxtable.getChildren().add(tableMatiere);

			vbox1.getChildren().add(hboxtable);
		});
		bsupprimer.setOnAction(e -> {
			Utilisateur selection = table.getSelectionModel().getSelectedItem();
			if (selection != null) {
				table.getItems().remove(selection);
				String suppression = "DELETE FROM user WHERE username='" + selection.getUsername() + "'";
				try (PreparedStatement delete = con.prepareStatement(suppression)) {
					int Rowi = delete.executeUpdate();
					if (Rowi > 0) {
						System.out.println("suppression reussie");
					} else {
						System.out.println("echec suppression");
					}
				} catch (Exception e2) {
				}
			}
		});
		binserer.setOnAction(e->{
			for(javafx.scene.Node node : vbox1.getChildren()) {
				if(node == gpM) {
					vbox1.getChildren().remove(gpM);
					break;
				}
			}
			vbox1.getChildren().add(gpA);
		});
		bafficher.setOnAction(e->{
			for(javafx.scene.Node node : vbox1.getChildren()) {
				if(node == gpA) {
					vbox1.getChildren().remove(gpA);
					break;
				}
			}
			tUsernameM.clear();
			tNomM.clear();
			tpwdM.clear();
			tSituationM.clear();
			vbox1.getChildren().add(gpM);
			Utilisateur selection = table.getSelectionModel().getSelectedItem();
			if (selection != null) {
				nomSecUser = selection.getUsername();
				tUsernameM.setText(selection.getUsername());
				tNomM.setText(selection.getNom());
				tpwdM.setText(selection.getMdp());
				tSituationM.setText(selection.getSituation());
			}
		});
		valider.setOnAction(e->{
			String usernameA = tUsernameA.getText();
			String nomA = tNomA.getText();
			String pwdA = (String) tpwdA.getText().toString();
			String sta = "utilisateur";
			String sit = tSituationA.getText();
			String sql ="INSERT INTO user(NomUser,userName,password,statut,situation) VALUES('"+nomA+"','"+usernameA+"','"+pwdA+"','"+sta+"','"+sit+"')";
			try {
				st.executeUpdate(sql);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			tUsernameA.clear();
			tNomA.clear();
			tpwdA.clear();
			tSituationA.clear();
		});
		validerM.setOnAction(e->{ 
			String nom1 = nomSecUser;
			String usernameM = tUsernameM.getText();
			String nomM = tNomM.getText();
			String pwdM = (String) tpwdM.getText().toString();
			String sitM= tSituationM.getText();
			String sql ="UPDATE user SET NomUser ='"+nomM+"', userName ='"+usernameM+"', password ='"+pwdM+"',situation ='"+sitM+"' where user.userName ='"+nom1+"'";
			try {
				st.executeUpdate(sql);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			tUsernameM.clear();
			tNomM.clear();
			tpwdM.clear();
			tSituationM.clear();
		});
	}

	public ImageView imageView(String nom, int l, int L) {
		String path = "D:\\eclipse\\avatars\\" + nom + ".png";
		Image image = new Image(path);
		ImageView imageView = new ImageView(image);
		imageView.setFitWidth(l);
		imageView.setFitHeight(L);
		imageView.setPreserveRatio(true);
		return imageView;
	}

	public AdminPage(String nom) {
		this.nomuser = nom;
	}
}
