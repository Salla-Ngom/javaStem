package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class QuizSVT extends Application {
	private static final int NUM_QUESTIONS = 20;
	@Override
	public void start(Stage arg0) throws Exception {
		arg0.setTitle("Quiz");

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));

        // Création des questions
        for (int i = 1; i <= NUM_QUESTIONS; i++) {
            Question question = new Question("Question " + i, "Option A", "Option B", "Option C", "Option D");
            vbox.getChildren().add(question);
        }

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
