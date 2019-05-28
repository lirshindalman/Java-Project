import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class AddGuitar extends AddInstrumentGeneral {
	private static String NAME = "Guitar";
	int numOfStrings=0;
	
	public AddGuitar() {

	}

	public VBox getPane() {
		
		setcomboBoxText(NAME);
		VBox vbox = super.getPane();
		getTextBrand().setPromptText("Ex.Gibson");
		getTextPrice().setPromptText("Ex.7500");
		ComboBox<String> comboBoxType = new ComboBox<>();
		comboBoxType.setPromptText("Type");
		comboBoxType.getItems().addAll("Classic", "Acoustic", "Electric");
		
		TextField num = new TextField();
		num.setPromptText("Ex.6");
		getGridPane().add(new Label("Number Of Strings:"), 0, 2);
		getGridPane().add(num, 1, 2);
		
		
		getGridPane().add(new Label("Guitar Type:"), 0, 3);
		getGridPane().add(comboBoxType, 1, 3);
		
		getAdd().setOnAction(e -> {
			if(num.getText()!=null && !num.getText().isEmpty())
			{
				
				numOfStrings = Integer.parseInt(num.getText());
				if (numOfStrings< Guitar.ELEC_MIN_NUM_OF_STRINGS)
					AfekaInstruments.alert("Number of strings",
							"Number of strings cannot smoler then" + Guitar.ELEC_MIN_NUM_OF_STRINGS);
				if (numOfStrings > Guitar.ELEC_MAX_NUM_OF_STRINGS)
					AfekaInstruments.alert("Number of strings",
							"Number of strings cannot be biger then" + Guitar.ELEC_MAX_NUM_OF_STRINGS);
			}

			Guitar newGuitar = new Guitar(getresultBrand(), getresultPrice(), numOfStrings, comboBoxType.getValue());
			AfekaInstruments.getallInstruments().add(newGuitar);
			
		});
		
		return vbox;
	}

	public static void main(String[] args) {
		launch(args);

	}

}
