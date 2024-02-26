package application;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class TpCreation extends Application {
	BorderPane root = new BorderPane();
	Scene scene = new Scene(root,1354, 750);
	@Override
	public void start(Stage arg0) throws Exception {
		arg0.setTitle("Creation Molecule");
		arg0.setScene(scene);
		arg0.show();
		Box base1 = new Box(250,10, 0);
		base1.setMaterial(new javafx.scene.paint.PhongMaterial(Color.BROWN));
		base1.setTranslateY(97);
		Box base2 = new Box(10,3, 0);
		Box base3 = new Box(10,3, 0);
		Line barreGauche1 = new Line(-150,0,-125,100);
		barreGauche1.setStroke(Color.BROWN);
		barreGauche1.setStrokeWidth(4);
		Line barreGauche2 = new Line(20,20,20,10);
		Line barreGauche3 = new Line(20,20,20,10);
		Line barreDroite1 = new Line(153,0,125,100);
		barreDroite1.setStroke(Color.BROWN);
		barreDroite1.setStrokeWidth(4);
		Line barreDroite2 = new Line(20,20,20,10);
		Line barreDroite3 = new Line(20,20,20,10);
		Group bole1 = new Group(barreGauche1,base1,barreDroite1);
		root.setCenter(bole1);
		Circle hydrogene = new Circle(10, Color.WHITESMOKE);
		hydrogene.setTranslateX(559);
		hydrogene.setTranslateY(407);
		Circle hydrogene2 = new Circle(10, Color.WHITESMOKE);
		hydrogene2.setTranslateX(579);
		hydrogene2.setTranslateY(407);
		root.getChildren().addAll(hydrogene,hydrogene2);
		root.setStyle("-fx-background-color: gray;");
	}
	
}
