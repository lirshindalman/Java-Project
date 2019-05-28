import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class AddBass extends AddInstrumentGeneral {
	private static String NAME = "Bass";
	int numOfStrings = 0;

	public AddBass() {

	}

	public VBox getPane() {
		setcomboBoxText(NAME);
		VBox vbox=super.getPane();
		getTextBrand().setPromptText("Ex.Fender Jazz");
		getTextPrice().setPromptText("Ex.7500");

		CheckBox CheckBoxF=new CheckBox();
		TextField num=new TextField();
		getGridPane().add(new Label("Number Of Strings:"), 0, 2);
		getGridPane().add(num,1,2);
		
		
		getGridPane().add(new Label("Fretless:"), 0, 3);
		getGridPane().add(CheckBoxF,1,3);
		
		getAdd().setOnAction(e -> {
			if(num.getText()!=null && !num.getText().isEmpty()) {
				numOfStrings=Integer.parseInt(num.getText());
				if (numOfStrings<Bass.MIN_NUM_OF_STRINGS)
					AfekaInstruments.alert("Number of strings",
						"Number of strings cannot smoler then" + Bass.MIN_NUM_OF_STRINGS);
				if (numOfStrings > Bass.MAX_NUM_OF_STRINGS)
					AfekaInstruments.alert("Number of strings",
						"Number of strings cannot be biger then" + Bass.MAX_NUM_OF_STRINGS);
			}
			Bass newBass = new Bass(getresultBrand(), getresultPrice(), numOfStrings, CheckBoxF.isSelected());
			AfekaInstruments.getallInstruments().add(newBass);
		});

		return vbox;
	}

	public static void main(String[] args) {
		launch(args);

	}

}
