import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class AddFlute extends AddInstrumentGeneral{
	private static String NAME="Flute";
	
	public AddFlute(){
		
	}
	
	public VBox getPane() {
		setcomboBoxText(NAME);		
		VBox vbox=super.getPane();
		getTextBrand().setPromptText("Ex.Levit");
		getTextPrice().setPromptText("Ex.300");
		
		ComboBox <String> comboBoxM=new ComboBox<>();
		comboBoxM.setPromptText("Material");
		comboBoxM.getItems().addAll("Wood","Metal","Plastic");
		ComboBox <String> comboBoxType=new ComboBox<>();
		comboBoxType.setPromptText("Type");
		comboBoxType.getItems().addAll("Flute","Rocorder","Bass");
		
		getGridPane().add(new Label("Material:"), 0, 2);
		getGridPane().add(comboBoxM, 1, 2);
		
		getGridPane().add(new Label("Type:"),0, 3);
		getGridPane().add(comboBoxType, 1, 3);
		
		getAdd().setOnAction(e -> {
			Flute newFlute = new Flute(getresultBrand(), getresultPrice(),comboBoxM.getValue(), comboBoxType.getValue());
			AfekaInstruments.getallInstruments().add(newFlute);
		});
	
		
		return vbox;
	}
	
	public static void main(String[] args) {
		launch(args);
	
	}

}
