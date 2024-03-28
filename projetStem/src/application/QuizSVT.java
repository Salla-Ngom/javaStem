package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class QuizSVT extends Application {
	Button Valider = new Button("Valider");
	private String nom1;
	public ImageView imageView(String nom,int l,int L) {
		String path = "D:\\eclipse\\avatars\\"+nom+".png";
		Image image = new Image(path);
		ImageView imageView = new ImageView(image);
		imageView.setFitWidth(l);
		imageView.setFitHeight(L);
		imageView.setPreserveRatio(true);
		return imageView;
		
		
	}
	public QuizSVT(String nom) {
		this.nom1= nom;
	}
	@Override
	public void start(Stage arg0) throws Exception {
		Button home = new Button();
		home.setOnAction(e->{
			Stage stage1 = (Stage) home.getScene().getWindow();
			Accueil itp = new Accueil(nom1);
			Stage stage = new Stage();
			try {
				itp.start(stage);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			stage1.close();
		});
		home.setGraphic(imageView("retour", 50, 50));
		Label label1 = new Label("QUIZ pas encore disponible");
		Valider.setStyle("-fx-base: green;");
		String [][]tab = new String[3][4];
		tab[0][0] = "Quelle est la formule generale d'un alcane :";
		tab[0][1] ="CnHn";
		tab[0][2] ="CnH2n";
		tab[0][3] ="CnH2n+2";
		tab[1][0] = "Quelle est la formule generale d'un alcool :";
		tab[1][1] ="CnHnO";
		tab[1][2] ="CnH2nO";
		tab[1][3] ="CnH2nOH";
		tab[2][0] = "Quelle est la formule generale d'un alcane :";
		tab[2][1] ="CnHn";
		tab[2][2] ="CnH2n";
		tab[2][3] ="CnH2n+2";
		arg0.setTitle("Quiz");

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));

        // Création des questions
//        for (int i = 0; i <= 2; i++) {
//            Question question = new Question(tab[i][0],tab[i][1],tab[i][2],tab[i][3]);
//            vbox.getChildren().add(question);
//        }
        vbox.getChildren().add(label1);
        vbox.getChildren().add(home);
        Scene scene = new Scene(vbox, 400, 600);
        arg0.setScene(scene);

        arg0.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class Question extends VBox {
    private final Label questionLabel;
    private final ToggleGroup toggleGroup;

    public Question(String question, String... options) {
        questionLabel = new Label(question);
        toggleGroup = new ToggleGroup();

        getChildren().add(questionLabel);

        for (String option : options) {
            RadioButton radioButton = new RadioButton(option);
            radioButton.setToggleGroup(toggleGroup);
            getChildren().add(radioButton);
        }
    }
}
