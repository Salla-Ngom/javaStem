package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TpUIAccueil extends Application {
	VBox vb = new VBox();
	String cheminBackground = "C:\\Users\\HP\\Pictures\\Saved Pictures\\background-chimie.jpg";
	BackgroundImage background = new BackgroundImage(new javafx.scene.image.Image(cheminBackground), BackgroundRepeat.NO_REPEAT,
			BackgroundRepeat.NO_REPEAT, null,
			new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true));
	BorderPane bp = new BorderPane();
	Scene scene = new Scene(bp, 1354, 750);
	Button creerMolecule = new Button("CREER UNE MOLECULE");
	Button retour = new Button("RETOUR");
	HBox hboxBt = new HBox(retour);
	Button faireSolution = new Button("FAIRE UNE EXPERIENCE");
	HBox hboxMenu = new HBox(creerMolecule,faireSolution);
	StackPane root = new StackPane();
	double width = 400;
	double height = 105;
	@Override
	public void start(Stage arg0) throws Exception {
		root.getChildren().add(hboxMenu);
		StackPane.setAlignment(hboxMenu, Pos.CENTER);
		vb.getChildren().addAll(root,hboxBt);
		bp.setCenter(vb);
		bp.setBackground(new javafx.scene.layout.Background(background));
		arg0.setScene(scene);
		arg0.show();
//	Mise ne forme 	
		creerMolecule.setPrefSize(width, height);
		faireSolution.setPrefSize(width, height);
		creerMolecule.setStyle("-fx-base: blue;-fx-font-size: 26;");
		faireSolution.setStyle("-fx-base: blue;-fx-font-size: 26;");
		hboxMenu.setSpacing(30);
		hboxMenu.setPadding(new Insets(50,0,0,300));
		hboxMenu.setPrefHeight(350);
		hboxBt.setPadding(new Insets(-100,0,0,580));
		retour.setPrefWidth(300);
//		Action des boutton
		retour.setOnAction(e->{
			Stage stage1 = (Stage) retour.getScene().getWindow();
			Accueil accueil = new Accueil();
			Stage stage = new Stage();
			try {
				accueil.start(stage);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			stage1.close();
		});
		faireSolution.setOnAction(e->{
			Stage stage1 = (Stage) faireSolution.getScene().getWindow();
			InterfaceTP tp = new InterfaceTP();
			Stage stage = new Stage();
			try {
				tp.start(stage);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			stage1.close();
		});
		creerMolecule.setOnAction(e1 -> {
			Stage stage1 = (Stage) creerMolecule.getScene().getWindow();
			TpCreation tpCreation = new TpCreation();
			Stage stage = new Stage();
			try {
				tpCreation.start(stage);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			stage1.close();
		});
	}

}
