import javafx.scene.layout.VBox;


public class AddSaxophone extends AddInstrumentGeneral{
	private static String NAME="Saxophone";
	
	public AddSaxophone() {
		
	}
	
	@Override
	public VBox getPane() {
		setcomboBoxText(NAME);
		VBox vbox=super.getPane();
		
		getAdd().setOnAction(e -> {
			Saxophone newSaxophone= new Saxophone(getresultBrand(), getresultPrice());
			AfekaInstruments.getallInstruments().add(newSaxophone);
		});
		
		return vbox;
		
	}
	
	public static void main(String[] args) {
		launch(args);
	
	}
	
	

}
