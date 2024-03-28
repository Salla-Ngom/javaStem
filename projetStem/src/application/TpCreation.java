package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TpCreation extends Application {
	Button home = new Button();
	Button retour = new Button();
	Button PositionInitiale = new Button();
	HBox piedDePage = new HBox(home,retour);
	Label ajout = new Label("AJOUTER");
	int i1 = 0;
	int i2 = 0;
	int i3 = 0;
	int i4 = 0;
	BorderPane root = new BorderPane();
	Scene scene = new Scene(root, 1354, 700);
	int nbCarbonne = 0;
	int nbHydrogene = 0;
	int nbOxygene = 0;
	Button bouton3D = new Button("3D");
	HBox affichage = new HBox(ajout, bouton3D);

	private void updateAtomCounts() {
		if (nbCarbonne == 1 && nbHydrogene == 4 && nbOxygene == 0) {
			ajout.setText("methane");
			bouton3D.setVisible(true);
		} else {
			if (nbCarbonne == 2 && nbHydrogene == 6 && nbOxygene == 0) {
				ajout.setText("ethane");
				bouton3D.setVisible(true);
			} else {
				if (nbCarbonne == 3 && nbHydrogene == 8 && nbOxygene == 0) {
					ajout.setText("Propane");
					bouton3D.setVisible(true);
				} else {
					if (nbCarbonne == 4 && nbHydrogene == 10 && nbOxygene == 0) {
						ajout.setText("Butane");
						bouton3D.setVisible(true);
					} else {
						if (nbCarbonne == 1 && nbHydrogene == 4 && nbOxygene == 1) {
							ajout.setText("Methanol");
							bouton3D.setVisible(true);
						} else {
							if (nbCarbonne == 2 && nbHydrogene == 6 && nbOxygene == 1) {
								ajout.setText("Ethanol");
								bouton3D.setVisible(true);
							} else {
								if (nbCarbonne == 3 && nbHydrogene == 8 && nbOxygene == 1) {
									ajout.setText("Propanol");
									bouton3D.setVisible(true);
								} else {
									if (nbCarbonne == 4 && nbHydrogene == 10 && nbOxygene == 1) {
										ajout.setText("Methanol");
										bouton3D.setVisible(true);
									} else {
										ajout.setText("");
										bouton3D.setVisible(false);
									}
								}
							}
						}
					}
				}
			}
		}
	}

	public Group Bole() {
		Group element = new Group();
		Box base1 = new Box(250, 10, 0);
		base1.setMaterial(new javafx.scene.paint.PhongMaterial(Color.BROWN));
		base1.setTranslateY(97);
		Line barreGauche1 = new Line(-150, 0, -125, 100);
		barreGauche1.setStroke(Color.BROWN);
		barreGauche1.setStrokeWidth(4);
		Line barreDroite1 = new Line(153, 0, 125, 100);
		barreDroite1.setStroke(Color.BROWN);
		barreDroite1.setStrokeWidth(4);
		Group bole = new Group(barreGauche1, base1, barreDroite1);
		element.getChildren().addAll(bole);
		return element;

	}

	public Group Carbone(int rayon) {
		Group element = new Group();
		Circle Circlecarbone = new Circle(rayon, Color.GRAY);
		Text text = new Text("C");
		text.setFont(Font.font(30));
		text.setFill(Color.BLACK);
		text.setTranslateX(-13);
		text.setTranslateY(9);
		element.getChildren().addAll(Circlecarbone, text);
		return element;

	}

	public Group Oxygene(int rayon) {
		Group element = new Group();
		Circle Circleoxygene = new Circle(rayon, Color.RED);
		Text text = new Text("O");
		text.setFont(Font.font(30));
		text.setFill(Color.BLACK);
		text.setTranslateX(-13);
		text.setTranslateY(9);
		element.getChildren().addAll(Circleoxygene, text);
		element.setOnMousePressed(event -> {
			element.setUserData(new double[] { event.getSceneX(), event.getSceneY() });
			updateAtomCounts();
		});
		element.setOnMouseDragged(event -> {
			double[] UserData = (double[]) element.getUserData();
			double deltaX = event.getSceneX() - UserData[0];
			double deltaY = event.getSceneY() - UserData[1];

			element.setTranslateX(element.getTranslateX() + deltaX);
			element.setTranslateY(element.getTranslateY() + deltaY);

			element.setUserData(new double[] { event.getSceneX(), event.getSceneY() });
			updateAtomCounts();

		});
		element.setOnMouseReleased(event -> {
			if ((event.getSceneX() >= 461.0) && (event.getSceneX() <= 748.0) && (event.getSceneY() >= 125.0)
					&& (event.getSceneY() <= 210.0)) {
				nbOxygene++;
			} else {
				nbOxygene--;
			}
			updateAtomCounts();
		});
		return element;
	}

	public Group hydrogene(int rayon) {
		Group element = new Group();
		Circle Circlehydrogene = new Circle(rayon, Color.WHITESMOKE);
		Text text = new Text("H");
		text.setFont(Font.font(10));
		text.setFill(Color.BLACK);
		text.setTranslateX(-4);
		text.setTranslateY(4);
		element.getChildren().addAll(Circlehydrogene, text);
		element.setOnMousePressed(event -> {
			element.setUserData(new double[] { event.getSceneX(), event.getSceneY() });
			updateAtomCounts();
		});
		element.setOnMouseDragged(event -> {
			double[] UserData = (double[]) element.getUserData();
			double deltaX = event.getSceneX() - UserData[0];
			double deltaY = event.getSceneY() - UserData[1];

			element.setTranslateX(element.getTranslateX() + deltaX);
			element.setTranslateY(element.getTranslateY() + deltaY);

			element.setUserData(new double[] { event.getSceneX(), event.getSceneY() });
			updateAtomCounts();
		});
		element.setOnMouseReleased(event -> {
			if ((event.getSceneX() >= 461.0) && (event.getSceneX() <= 748.0) && (event.getSceneY() >= 125.0)
					&& (event.getSceneY() <= 210.0)) {
				nbHydrogene++;
				updateAtomCounts();
			} else {
				nbHydrogene--;
				updateAtomCounts();
			}
			updateAtomCounts();
		});

		return element;
	}

	@Override
	public void start(Stage arg0) {
		bouton3D.setOnAction(e->{
			String nom= ajout.getText();
			Objet3D ob = new Objet3D(nom);
			Stage stage = new Stage(); 
			try {
				ob.start(stage);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
		});
		retour.setGraphic(imageView("pngtree-return-icon-image_1344469-removebg-preview", 50, 50));
		piedDePage.setSpacing(75);
		home.setGraphic(imageView("retour", 50, 50));
		bouton3D.setStyle("-fx-base: green");
		arg0.setTitle("Creation Molecule");
		arg0.setScene(scene);
		arg0.show();
		Group bole1 = Bole();
		root.setCenter(bole1);
		bole1.setTranslateX(170);
		bole1.setTranslateY(56);
		Group oxygene1 = Oxygene(20);
		oxygene1.setTranslateX(905);
		oxygene1.setTranslateY(420);
		root.getChildren().addAll(oxygene1);

		Group oxygene2 = Oxygene(20);
		oxygene2.setTranslateX(945);
		oxygene2.setTranslateY(420);
		root.getChildren().addAll(oxygene2);

		Group bole2 = Bole();
		root.setLeft(bole2);
		bole2.setTranslateX(70);
		bole2.setTranslateY(310);
		root.setStyle("-fx-background-color: BLACK;");
		Group hydrogene1 = hydrogene(10);
		hydrogene1.setTranslateX(125);
		hydrogene1.setTranslateY(431);
		root.getChildren().addAll(hydrogene1);

		Group hydrogene2 = hydrogene(10);
		hydrogene2.setTranslateX(145);
		hydrogene2.setTranslateY(431);
		root.getChildren().addAll(hydrogene2);

		Group hydrogene3 = hydrogene(10);
		hydrogene3.setTranslateX(165);
		hydrogene3.setTranslateY(431);
		root.getChildren().addAll(hydrogene3);

		Group hydrogene4 = hydrogene(10);
		hydrogene4.setTranslateX(185);
		hydrogene4.setTranslateY(431);
		root.getChildren().addAll(hydrogene4);

		Group hydrogene5 = hydrogene(10);
		hydrogene5.setTranslateX(205);
		hydrogene5.setTranslateY(431);
		root.getChildren().addAll(hydrogene5);

		Group hydrogene6 = hydrogene(10);
		hydrogene6.setTranslateX(225);
		hydrogene6.setTranslateY(431);
		root.getChildren().addAll(hydrogene6);

		Group hydrogene7 = hydrogene(10);
		hydrogene7.setTranslateX(245);
		hydrogene7.setTranslateY(431);
		root.getChildren().addAll(hydrogene7);

		Group hydrogene8 = hydrogene(10);
		hydrogene8.setTranslateX(265);
		hydrogene8.setTranslateY(431);
		root.getChildren().addAll(hydrogene8);

		Group hydrogene9 = hydrogene(10);
		hydrogene9.setTranslateX(285);
		hydrogene9.setTranslateY(431);
		root.getChildren().addAll(hydrogene9);

		Group hydrogene10 = hydrogene(10);
		hydrogene10.setTranslateX(305);
		hydrogene10.setTranslateY(431);
		root.getChildren().addAll(hydrogene10);

		Group bole3 = Bole();
		root.getChildren().add(bole3);
		bole3.setTranslateX(600);
		bole3.setTranslateY(350);
		Group carbone1 = Carbone(20);
		carbone1.setTranslateX(505);
		carbone1.setTranslateY(420);
		carbone1.setOnMouseClicked(event -> {
			i1++;
			if (i1 % 2 != 0) {
				nbCarbonne++;
				carbone1.setTranslateY(carbone1.getTranslateY() - 250);
				
			} else {
				nbCarbonne--;
				carbone1.setTranslateY(carbone1.getTranslateY() + 250);
				
			}
			updateAtomCounts();
		});
		root.getChildren().add(carbone1);

		Group carbone2 = Carbone(20);
		carbone2.setTranslateX(545);
		carbone2.setTranslateY(420);
		root.getChildren().addAll(carbone2);
		carbone2.setOnMouseClicked(event -> {
			i2++;
			if (i2 % 2 != 0) {
				nbCarbonne++;
				carbone2.setTranslateY(carbone2.getTranslateY() - 250);
				
			} else {
				nbCarbonne--;
				carbone2.setTranslateY(carbone2.getTranslateY() + 250);
				
			}
			updateAtomCounts();
		});
		Group carbone3 = Carbone(20);
		carbone3.setTranslateX(585);
		carbone3.setTranslateY(420);
		root.getChildren().addAll(carbone3);
		carbone3.setOnMouseClicked(event -> {
			i3++;
			if (i3 % 2 != 0) {
				nbCarbonne++;
				carbone3.setTranslateY(carbone3.getTranslateY() - 250);
				
			} else {
				nbCarbonne--;
				carbone3.setTranslateY(carbone3.getTranslateY() + 250);
				
			}
			updateAtomCounts();
		});

		Group carbone4 = Carbone(20);
		carbone4.setTranslateX(625);
		carbone4.setTranslateY(420);
		root.getChildren().addAll(carbone4);
		carbone4.setOnMouseClicked(event -> {
			i4++;
			if (i4 % 2 != 0) {
				nbCarbonne++;
				carbone4.setTranslateY(carbone4.getTranslateY() - 250);
				
			} else {
				nbCarbonne--;
				carbone4.setTranslateY(carbone4.getTranslateY() + 250);
				
			}
			updateAtomCounts();
		});
		root.setTop(affichage);
		root.setBottom(piedDePage);
		BorderPane.setMargin(piedDePage, new Insets(0, 0, 0, 500));
		ajout.setTranslateY(0);
		ajout.setPadding(new Insets(0, 0, 0, 400));
		ajout.setTextFill(Color.RED);
		ajout.setStyle("-fx-font-size: 25;");
		updateAtomCounts();
		home.setOnAction(e->{
			Stage stage1 = (Stage) home.getScene().getWindow();
			TpUIAccueil itp = new TpUIAccueil(nom);
			Stage stage = new Stage();
			try {
				itp.start(stage);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			stage1.close();
		});
		retour.setOnAction(e->{
			carbone1.setTranslateX(505);
			carbone1.setTranslateY(420);
			carbone2.setTranslateX(545);
			carbone2.setTranslateY(420);
			carbone3.setTranslateX(585);
			carbone3.setTranslateY(420);
			carbone4.setTranslateX(625);
			carbone4.setTranslateY(420);
			i1=0;i2=0;i3=0;i4=0;
			oxygene1.setTranslateX(905);
			oxygene1.setTranslateY(420);
			oxygene2.setTranslateX(945);
			oxygene2.setTranslateY(420);
			hydrogene1.setTranslateX(125);
			hydrogene1.setTranslateY(431);
			hydrogene2.setTranslateX(145);
			hydrogene2.setTranslateY(431);
			hydrogene3.setTranslateX(165);
			hydrogene3.setTranslateY(431);
			hydrogene4.setTranslateX(185);
			hydrogene4.setTranslateY(431);
			hydrogene5.setTranslateX(205);
			hydrogene5.setTranslateY(431);
			hydrogene6.setTranslateX(225);
			hydrogene6.setTranslateY(431);
			hydrogene7.setTranslateX(245);
			hydrogene7.setTranslateY(431);
			hydrogene8.setTranslateX(265);
			hydrogene8.setTranslateY(431);
			hydrogene9.setTranslateX(285);
			hydrogene9.setTranslateY(431);
			hydrogene10.setTranslateX(305);
			hydrogene10.setTranslateY(431);
			
		});

	}
	public ImageView imageView(String nom,int l,int L) {
		String path = "D:\\eclipse\\avatars\\"+nom+".png";
		Image image = new Image(path);
		ImageView imageView = new ImageView(image);
		imageView.setFitWidth(l);
		imageView.setFitHeight(L);
		imageView.setPreserveRatio(true);
		return imageView;
	}
	String nom;
	public TpCreation(String nom) {
		this.nom= nom;
	}
}
