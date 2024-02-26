package application;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
public class RSRG extends VBox {
	public VBox corps() {
		Label Texte= new Label("Veuillez cliquer sur une region pour voir ces ressources");
		String urlImage = "C:\\\\\\\\Users\\\\\\\\HP\\\\\\\\Pictures\\\\\\\\senegal-map.jpg";
		Image image = new Image(urlImage);
		ImageView imageView = new ImageView(image);
		imageView.setFitWidth(500);
		imageView.setFitHeight(350);
		VBox vbox1 = new VBox(imageView);
		VBox vbox2 = new VBox(Texte);
		VBox vboxPrincipal = new VBox(vbox1,vbox2);
		vboxPrincipal.setSpacing(10);
		imageView.setOnMouseClicked((MouseEvent event) -> {
			vbox2.getChildren().clear();
            double x = event.getX();
            double y = event.getY();
            System.out.println("x="+x+" y="+y);
            vbox2.getChildren().add(getRegionName(x, y));
        });
		return vboxPrincipal;
	}
	private Label getRegionName(double x, double y) {
		Label label= new Label();
        if (x >= 79 && x <= 217 && y >=73 && y <= 141) {
        	label.setText("LOUGA");
        }
        if (x >=9 && x <=36 && y >=151 && y <= 170) {
        	label.setText("DAKAR");
        }
        if (x >= 236 && x <= 377 && y >=78 && y <= 183) {
        	label.setText("MATAM");
        }
        if (x >= 99 && x <= 275 && y >=25 && y <= 68) {
        	label.setText("SAINT-LOUIS");
        }
        if (x >= 38 && x <= 75 && y >=130 && y <= 177) {
        	label.setText("THIES");
        }
        if (x >= 79 && x <= 141 && y >=141.1 && y <= 170) {
        	label.setText("DIOURBEL");
        }
        if (x >= 67 && x <= 104 && y >=175 && y <= 242) {
        	label.setText("FATICK");
        }
        if (x >= 105 && x <= 146 && y >=189 && y <= 242) {
        	label.setText("KAOLACK");
        }
        if (x >= 147 && x <= 228 && y >=170 && y <= 229) {
        	label.setText("KAFFRINE");
        }
        if (x >= 231 && x <= 423 && y >=190 && y <= 246) {
        	label.setText("TAMBACOUNDA");
        }
        
        return label;
    }
	
}

