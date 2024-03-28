package application;

import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class Ressource extends HBox {
	public HBox corps (String region) {
		Text texte = new Text("");
		if(region.equals("DAKAR")) {
			texte.setText("Region de  DAKAR \n la region de dakar possede des reserves de phosphate de grande quantite a toubab dialaw \nDes gisements de GYPSE sont presents dans la regions de Dakar");
		}
		if(region.equals("LOUGA")) {
			texte.setText("Region de LOUGA \n la region de louga abrite des gisements de fer de qualite");
		}
		if(region.equals("TAMBACOUNDA")) {
			texte.setText("Region de TAMBACOUNDA \n la region de tambacounda abrite des gisements auriferes,notamment a Makacolibantang");
		}
		if(region.equals("KAOLACK")) {
			texte.setText("Region de KAOLACK \n la region de kaolack est connue pour ses vastes gisement de sel");
		}
		if(region.equals("TAMBACOUNDA")) {
			texte.setText("Region de TAMBACOUNDA \n la region de tambacounda abrite des gisements auriferes,notamment a Makacolibantang");
		}
		if(region.equals("TAMBACOUNDA")) {
			texte.setText("Region de TAMBACOUNDA \n la region de tambacounda abrite des gisements auriferes,notamment a Makacolibantang");
		}
		HBox hbox = new HBox();
		hbox.getChildren().add(texte);
		return hbox;
		
	}

}
