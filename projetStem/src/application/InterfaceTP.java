package application;

import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Box;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class InterfaceTP extends Application {
	Boolean finirVersement = false;
	private int iBecher = 0;
    Group tube1Group = new Group();
	Group tube2Group = new Group();
	Group becher1Group = new Group();
	Group GazGroup = new Group();
	Group GazGroupComplet = new Group();
    private final Button sortir = new Button();
    private final HBox hboxBar = new HBox();
    private final Label titre = new Label("COURS");
    private final BorderPane bp = new BorderPane();
    private final Scene scene = new Scene(bp, 1354, 750);
    VBox vboxEcrit = new VBox();
    Label Equation = new Label();
    Button Equilibrer = new Button("EQUILIBRER");
    private int i = 0;
    private int iGaz = 0;
//    private int i1 = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        setupUI(primaryStage);
        
    }

	private void setupUI(Stage stage) {
		
		boolean iIons = false;
		Line barreBecherGauche = new Line(-25, 50, -25, 160);
		barreBecherGauche.setStroke(Color.BLACK);
		barreBecherGauche.setStrokeWidth(2);
		Line barreBecherDroite = new Line(67, 50, 67, 160);
		barreBecherDroite.setStroke(Color.BLACK);
		barreBecherDroite.setStrokeWidth(2);
		Box baseBecher = new Box(95, 5, 0);
		baseBecher.setTranslateX(21);
		baseBecher.setTranslateY(160);
		baseBecher.setMaterial(new javafx.scene.paint.PhongMaterial(Color.BLACK));
		Rectangle rectangleVersement = new Rectangle(15, 170);
		rectangleVersement.setFill(Color.SKYBLUE);
		Rectangle liquideEau = new Rectangle(58, 140);
		liquideEau.setTranslateX(70.5);
		liquideEau.setTranslateY(260);
		liquideEau.setFill(Color.SKYBLUE);
		Circle cercle = new Circle(20, Color.RED);
		Text texte = new Text("ceci est un test");
		cercle.setTranslateY(25);
		hboxBar.getChildren().addAll(sortir, titre);
		Box piedGaz = new Box(50, 5, 0);
		Box hautGaz = new Box(50, 5, 0);
		Box becGaz = new Box(15, 5, 0);
		piedGaz.setMaterial(new javafx.scene.paint.PhongMaterial(Color.BLACK));
		hautGaz.setMaterial(new javafx.scene.paint.PhongMaterial(Color.BLACK));
		becGaz.setMaterial(new javafx.scene.paint.PhongMaterial(Color.BLACK));
		piedGaz.setTranslateY(60);
		becGaz.setTranslateY(-15);
		Line barreDroiteGaz = new Line(0, -15, 0, 0);
		barreDroiteGaz.setStroke(Color.BLACK);
		barreDroiteGaz.setStrokeWidth(2);
		Line barreHautGaz = new Line(-25, 0, -25, 60);
		barreHautGaz.setStroke(Color.BLACK);
		barreHautGaz.setStrokeWidth(2);
		Line barreGaucheGaz = new Line(25, 0, 25, 60);
		barreGaucheGaz.setStroke(Color.BLACK);
		barreGaucheGaz.setStrokeWidth(2);
		GazGroupComplet.getChildren().addAll(GazGroup, cercle);
		GazGroup.getChildren().addAll(piedGaz, barreGaucheGaz, barreDroiteGaz, hautGaz, barreHautGaz, becGaz);
		Box table = new Box(1000, 10, 0);
		table.setTranslateY(500);
		table.setMaterial(new javafx.scene.paint.PhongMaterial(Color.BROWN));
		Rectangle becher = new Rectangle(50, 100);
		becher.setStyle("-fx-stroke: black; -fx-stroke-width: 2;");
//        becher.setTranslateX(200);
		becher.setTranslateY(30);
		Rectangle becherContenu = new Rectangle(88, 110);
        becherContenu.setTranslateX(-22);
		becherContenu.setTranslateY(50);
		becherContenu.setFill(Color.WHITE);
		Rectangle becherContenuVolume = new Rectangle(89.5, 5);
		becherContenuVolume.setFill(Color.TRANSPARENT);
		becherContenuVolume.setTranslateY(153);
		becherContenuVolume.setTranslateX(-23.5);
		StackPane root = new StackPane();
		HBox hbox = new HBox(root, vboxEcrit);
		bp.setTop(hbox);
		stage.setScene(scene);
		stage.setTitle("INTERFACE TP");
		stage.show();
		hboxBar.setStyle("-fx-background-color: blue;");
		hboxBar.setPadding(new Insets(10, 0, 0, 0));
		double widthBar = 1300;
		double heightBar = 40;
		hboxBar.setSpacing(700);
		hboxBar.setPrefSize(widthBar, heightBar);
		Arc baseTubel = new Arc(100, 400, 30, 30, 0, -180);
		baseTubel.setType(ArcType.OPEN);
		baseTubel.setFill(Color.SKYBLUE);
		baseTubel.setStroke(Color.BLACK);
		baseTubel.setStrokeWidth(2);

		Line barreGauche1 = new Line(70, 400, 70, 250);
		barreGauche1.setStroke(Color.BLACK);
		barreGauche1.setStrokeWidth(2);

		Line barreDroite1 = new Line(130, 400, 130, 250);
		barreDroite1.setStroke(Color.BLACK);
		barreDroite1.setStrokeWidth(2);

		Arc baseTube2 = new Arc(100, 400, 30, 30, 0, -180);
		baseTube2.setType(ArcType.OPEN);
		baseTube2.setFill(Color.TRANSPARENT);
		baseTube2.setStroke(Color.BLACK);
		baseTube2.setStrokeWidth(2);

		Line barreGauche2 = new Line(70, 400, 70, 250);
		barreGauche2.setStroke(Color.BLACK);
		barreGauche2.setStrokeWidth(2);

		Line barreDroite2 = new Line(130, 400, 130, 250);
		barreDroite2.setStroke(Color.BLACK);
		barreDroite2.setStrokeWidth(2);

		// Ajouter les arcs et les lignes associées aux groupes
		tube1Group.getChildren().addAll(baseTubel, barreGauche1, barreDroite1,liquideEau);
		tube2Group.getChildren().addAll(baseTube2, barreGauche2, barreDroite2);
		becher1Group.getChildren().addAll(barreBecherDroite,barreBecherGauche,baseBecher, becherContenu, becherContenuVolume);

		// Ajouter les groupes au nœud racine
		root.getChildren().addAll(GazGroupComplet, tube1Group, tube2Group, becher1Group, table);

		// Déplacer les groupes
		tube1Group.setTranslateX(100);
		tube1Group.setTranslateX(100);
		becher1Group.setTranslateX(200);
		GazGroupComplet.setTranslateX(-80);
		root.setPadding(new Insets(20, 0, 0, 0));
		GazGroup.setOnMouseClicked(e -> {
			iGaz++;
			if (iGaz % 2 != 0) {
				TranslateTransition translateTransitionGaz = new TranslateTransition(Duration.seconds(2),
						GazGroupComplet);
				translateTransitionGaz.setToY(455);
				SequentialTransition stG = new SequentialTransition(translateTransitionGaz);
				stG.play();
			} else {
				TranslateTransition translateTransitionGaz1 = new TranslateTransition(Duration.seconds(2),
						GazGroupComplet);
				translateTransitionGaz1.setToY(0);
				SequentialTransition stG1 = new SequentialTransition(translateTransitionGaz1);
				stG1.play();
			}
		});
		tube1Group.setOnMouseClicked(event -> {
			i++;
			if (i % 2 != 0) {
				if (i != 3) {
					TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(1), tube1Group);
					translateTransition.setToY(378);
					translateTransition.play();
				} else {
					i = 0;
					TranslateTransition translateTransitionRetourYTG1 = new TranslateTransition(Duration.seconds(2),
							tube1Group);
					translateTransitionRetourYTG1.setToY(0);
					TranslateTransition translateTransitionRetourITG1 = new TranslateTransition(Duration.seconds(2),
							tube1Group);
					translateTransitionRetourITG1.setToY(250);
					TranslateTransition translateTransitionRetourXTG1 = new TranslateTransition(Duration.seconds(2),
							tube1Group);
					translateTransitionRetourXTG1.setToX(90);
					SequentialTransition st1r = new SequentialTransition(translateTransitionRetourITG1,
							translateTransitionRetourXTG1, translateTransitionRetourYTG1);
					st1r.play();
				}
			} else {
				TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(2), tube1Group);
				translateTransition1.setToY(300);
				TranslateTransition translateTransition3 = new TranslateTransition(Duration.seconds(2), tube1Group);
				translateTransition3.setToX(110);
				RotateTransition rotateTransition = new RotateTransition(Duration.seconds(3), tube1Group);
				rotateTransition.setByAngle(100);
				TranslateTransition translateTransition2 = new TranslateTransition(Duration.seconds(5), tube1Group);
				translateTransition2.setToY(324);
				RotateTransition rotateTransition1 = new RotateTransition(Duration.seconds(1), tube1Group);
				rotateTransition1.setByAngle(-100);
				TranslateTransition translateTransition31 = new TranslateTransition(Duration.seconds(2), tube1Group);
				translateTransition31.setToX(-10);
				TranslateTransition translateTransition11 = new TranslateTransition(Duration.seconds(2), tube1Group);
				translateTransition11.setToY(378);
				SequentialTransition st = new SequentialTransition(translateTransition1, translateTransition3,
						rotateTransition, translateTransition2);
				st.play();
				st.setOnFinished(ef->{
					finirVersement = true;
				});
				if (i == 2 && (finirVersement)) {
				    becherContenuVolume.setFill(Color.SKYBLUE);

				    // Démarrez la transition de remplissage en même temps que la première rotation

				    // Ajoutez la transition de remplissage
				    ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(5), becherContenuVolume);
				    scaleTransition.setFromX(1);
				    scaleTransition.setToX(1.02);
				    scaleTransition.setCycleCount(Transition.INDEFINITE);
				    scaleTransition.setAutoReverse(true);

				    // Démarrez les transitions
				    scaleTransition.play();
				}
				translateTransition2.setOnFinished(e -> {
					SequentialTransition st2 = new SequentialTransition(rotateTransition1, translateTransition31,
							translateTransition11);
					st2.play();
				});
				rotateTransition.setOnFinished(e2->{
					
					root.getChildren().add(rectangleVersement);
					rectangleVersement.setTranslateY(400);
					rectangleVersement.setTranslateX(190);
					becherContenuVolume.setFill(Color.SKYBLUE);
				});
				rotateTransition1.setOnFinished(e2->{
					root.getChildren().remove(rectangleVersement);
					becherContenuVolume.setFill(Color.BLUE);
				});
			}
		});
		
		becher1Group.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e1) -> {
			iBecher++;
			if (iBecher % 2 != 0) {
				TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(1), becher1Group);
				translateTransition.setToY(435);
				translateTransition.play();
			} else {
				
				TranslateTransition translateTransition11tr = new TranslateTransition(Duration.seconds(2),
						becher1Group);
				translateTransition11tr.setToY(30);
				SequentialTransition st1l = new SequentialTransition(translateTransition11tr);
				st1l.play();
				st1l.setOnFinished(est1l->{
					becherContenuVolume.setFill(Color.TRANSPARENT);
				});	
			}
		});
		cercle.setOnMouseClicked(event -> {
			// Changez la couleur du cercle en fonction de la couleur actuelle
			if (cercle.getFill() == Color.RED) {
				cercle.setFill(Color.GREEN);
				becGaz.setMaterial(new javafx.scene.paint.PhongMaterial(Color.RED));
			} else {
				cercle.setFill(Color.RED);
				becGaz.setMaterial(new javafx.scene.paint.PhongMaterial(Color.BLACK));
			}
		});
		if((becherContenuVolume.getFill()==Color.SKYBLUE ) && (iIons)) {
			texte.setText("Solution Alcool avec ion X");
			
		}
		vboxEcrit.getChildren().addAll(texte,Equation,Equilibrer);
	}
}
