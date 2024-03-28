package application;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
public class RSRG extends VBox {
	public VBox corps() {
		Text texte = new Text("Le senegal contient different ressources geologique ");
		Label Texte= new Label("Veuillez cliquer sur une region pour voir ces ressources");
		String urlImage = "C:\\\\\\\\Users\\\\\\\\HP\\\\\\\\Pictures\\\\\\\\senegal-map.jpg";
		Image image = new Image(urlImage);
		ImageView imageView = new ImageView(image);
		imageView.setFitWidth(500);
		imageView.setFitHeight(350);
		HBox hbox = new HBox(imageView,texte);
		hbox.setSpacing(5);
		VBox vbox1 = new VBox(hbox);
		VBox vbox2 = new VBox(Texte);
		ScrollPane scrollPane = new ScrollPane(vbox2);
		VBox vbox= new VBox(scrollPane);
		VBox vboxPrincipal = new VBox(vbox1,vbox);
		vboxPrincipal.setSpacing(10);
		Ressource ressource = new Ressource();
		imageView.setOnMouseClicked((MouseEvent event) -> {
			vbox2.getChildren().clear();
            double x = event.getX();
            double y = event.getY();
            vbox2.getChildren().add(ressource.corps(getRegionName(x, y)));
        });
		return vboxPrincipal;
	}
	private String getRegionName(double x, double y) {
		String label= "";
        if (x >= 79 && x <= 217 && y >=73 && y <= 141) {
        	label ="LOUGA";
        }
        if (x >= 64 && x <= 124 && y >=275 && y <= 332) {
        	label ="ZIGUINCHOR";
        }
        if (x >= 127 && x <= 185 && y >=263 && y <= 326) {
        	label ="SEDIOU";
        }
        if (x >= 192 && x <= 311 && y >=264 && y <= 309) {
        	label ="KOLDA";
        }
        if (x >= 344 && x <= 469 && y >=274 && y <= 333) {
        	label ="KEDOUGOU";
        }
        if (x >=9 && x <=36 && y >=151 && y <= 170) {
        	label ="DAKAR";
        }
        if (x >= 236 && x <= 377 && y >=78 && y <= 183) {
        	label ="MATAM";
        }
        if (x >= 99 && x <= 275 && y >=25 && y <= 68) {
        	label ="SAINT-LOUIS";
        }
        if (x >= 38 && x <= 75 && y >=130 && y <= 177) {
        	label ="THIES";
        }
        if (x >= 79 && x <= 141 && y >=141.1 && y <= 170) {
        	label ="DIOURBEL";
        }
        if (x >= 67 && x <= 104 && y >=175 && y <= 242) {
        	label ="FATICK";
        }
        if (x >= 105 && x <= 146 && y >=189 && y <= 242) {
        	label ="KAOLACK";
        }
        if (x >= 147 && x <= 228 && y >=170 && y <= 229) {
        	label ="KAFFRINE";
        }
        if (x >= 231 && x <= 423 && y >=190 && y <= 246) {
        	label ="TAMBACOUNDA";
        }
        
        return label;
    }
	
}

