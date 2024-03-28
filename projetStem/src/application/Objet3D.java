package application;

import com.interactivemesh.jfx.importer.obj.ObjModelImporter;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Objet3D extends Application{
	String nom="";
	public Objet3D(String nom) {
		this.nom= nom;
	}

	@Override
	public void start(Stage arg0) throws Exception {
		VBox vbox = new VBox();
		Group root = new Group();
		Camera camera;
		Translate pivot;
		ObjModelImporter obj3d = new ObjModelImporter();
		try {
			String modelUrl = "C:\\Users\\HP\\Pictures\\3D\\obj\\" + nom + "3D.obj";
			obj3d.read(modelUrl);
			MeshView[] mesh = obj3d.getImport();
			pivot = new Translate();
			camera = new PerspectiveCamera(true);

			Rotate rotY = new Rotate(-20, Rotate.Y_AXIS);
			Rotate rotX = new Rotate(-20, Rotate.X_AXIS);
			camera.getTransforms().addAll(pivot, rotX, new Rotate(-20, Rotate.X_AXIS), new Translate(0, 0, 0));

			camera.getTransforms().addAll(pivot, rotY, new Rotate(-20, Rotate.X_AXIS), new Translate(0, 0, -28));
			obj3d.setCreaseAngle(40);
			Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(20), new KeyValue(rotY.angleProperty(), 10)),
					new KeyFrame(Duration.seconds(1), new KeyValue(rotY.angleProperty(), 360)));
			timeline.play();

			Timeline time = new Timeline();
			timeline.setCycleCount(2);
			timeline.setAutoReverse(true);
			timeline.getKeyFrames().add(new KeyFrame(Duration.millis(5000), new KeyValue(rotY.angleProperty(), 25)));
			time.play();

			root.getChildren().addAll(mesh);
			root.getTransforms().add(new javafx.scene.transform.Scale(3.0, 3.0, 3.0));
			root.getChildren().stream();

			SubScene scene1 = new SubScene(root, 500, 400, true, SceneAntialiasing.BALANCED);

			scene1.setCamera(camera);
			scene1.setFill(Color.TRANSPARENT);
			StackPane pane = new StackPane();
			pane.getChildren().addAll(scene1);
			Label nomObj = new Label("");
			nomObj.setText(nom);
			HBox hboxNom = new HBox(nomObj);
			vbox.getChildren().addAll(pane, hboxNom);
			hboxNom.setPadding(new Insets(0, 0, 0, 150));
		} catch (Exception e) {
			e.printStackTrace();

		}
		Scene scene = new Scene(vbox,500,600);
		arg0.setScene(scene);
		arg0.show();
		
	}
	public static void main(String[] args) {
		launch(args);
	}

}
