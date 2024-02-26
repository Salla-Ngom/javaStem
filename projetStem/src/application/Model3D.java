package application;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
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
import javafx.util.Duration;
import com.interactivemesh.jfx.importer.obj.ObjModelImporter;

public class Model3D extends HBox {
	public VBox object(String nom) {
		VBox vbox = new VBox();
		Group root = new Group();
		Camera camera;
		Translate pivot;
		ObjModelImporter obj3d = new ObjModelImporter();
		try {
			String modelUrl = "C:\\Users\\HP\\Desktop\\" + nom + ".obj";
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
			hboxNom.setPadding(new Insets(-130, 0, 0, 150));
		} catch (Exception e) {
			e.printStackTrace();

		}
		return vbox;
	}

	public HBox CreationModel3D() {
		HBox hbox = new HBox();
		VBox vboxGranite = object("Granite");
		VBox vboxBasalte = object("Basalte");
		hbox.getChildren().addAll(vboxGranite,vboxBasalte);
		hbox.setSpacing(50);
		return hbox;

	}
}