package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
//import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class Accueil extends Application {
	String cheminBackground = "C:\\Users\\HP\\Pictures\\Saved Pictures\\background-Acceuil.jpg";
	BackgroundImage background = new BackgroundImage(new javafx.scene.image.Image(cheminBackground), BackgroundRepeat.NO_REPEAT,
			BackgroundRepeat.NO_REPEAT, null,
			new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true));
	Button cours = new Button("COURS");
	Button tp = new Button("TRAVEAUX PARATIQUES");
	Button quiz = new Button("QUIZ");
	Button quitter = new Button("QUITTER");
	VBox vboxMenu = new VBox();
	Label intro = new Label("BIENVENU(E) DANS NOTRE PLATEFORME D'APPRENTISSAGE");
	HBox titre = new HBox(intro);

	@Override
	public void start(Stage primaryStage) {
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(20);
		grid.setVgap(20);
		grid.add(cours, 0, 0);
		grid.add(quiz, 0, 1);
		grid.add(tp, 0, 2);
		grid.add(quitter, 0, 3);
		StackPane root = new StackPane();
		BorderPane bp = new BorderPane();
		root.getChildren().add(grid);
		bp.setCenter(root);
		bp.setTop(titre);
		StackPane.setAlignment(vboxMenu, Pos.CENTER);
		Scene scene = new Scene(bp, 1354, 750);
		primaryStage.setScene(scene);
		primaryStage.setTitle("EDUCATION");
		primaryStage.show();
		double width = 300;
		double height = 10;
		cours.setPrefSize(width, height);
		quiz.setPrefSize(width, height);
		quitter.setPrefSize(width, height);
		tp.setPrefSize(width, height);

//			Stylisation
		titre.setPadding(new Insets(100, 10, 50, 200));
		titre.setStyle("-fx-font-color: green;-fx-font-size:38");
		vboxMenu.setSpacing(10);
		cours.setStyle("-fx-base: blue;-fx-font-size: 26;");
		tp.setStyle("-fx-base: blue;-fx-font-size: 23;");
		quiz.setStyle("-fx-base: blue;-fx-font-size: 26;");
		quitter.setStyle("-fx-base: blue;-fx-font-size: 26;");
		bp.setBackground(new javafx.scene.layout.Background(background));
		root.setPadding(new Insets(10, 0, 0, 0));
//		Action des Bouttons
		cours.setOnAction(e -> {
			Stage stage1 = (Stage) quitter.getScene().getWindow();
			InterfaceCours cours = new InterfaceCours();
			Stage stage = new Stage(); 
			try {
				cours.start(stage);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			stage1.close();
		});
		quiz.setOnAction(e -> {

		});
		quitter.setOnAction(e -> {
			Stage stage = (Stage) quitter.getScene().getWindow();
			stage.close();
		});
		tp.setOnAction(e->{
			Stage stage1 = (Stage) quitter.getScene().getWindow();
			TpUIAccueil itp = new TpUIAccueil();
			Stage stage = new Stage();
			try {
				itp.start(stage);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			stage1.close();
		});

	}
	public static void main(String[] args) {
		launch(args);
	}
}
