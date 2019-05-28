import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddInstrumentGeneral extends Application {
	
	private GridPane gridPane=  new GridPane();
	private Button add=new Button("Add");
	private TextField TextBrand=new TextField();
	private TextField TextPrice=new TextField();
	private String comboBoxText="";
	private String resultBrand;
	private Double resultPrice=0.0;
	
	public AddInstrumentGeneral() {
		
	}
	public String getresultBrand() {
		resultBrand=TextBrand.getText();
		return resultBrand;
	}
	
	public Double getresultPrice() {
		if(TextPrice.getText()!=null&& !TextPrice.getText().isEmpty())
			resultPrice=Double.parseDouble(TextPrice.getText());
		if(resultPrice<=0)
			AfekaInstruments.alert("Price","Price must be a positiv number!");
		
		return resultPrice;
	}
	
	public String getcomboBoxText() {
		return comboBoxText;
	}
	
	public void setcomboBoxText(String comboBoxText ) {
		this.comboBoxText=comboBoxText;
	}
	

	public TextField getTextBrand() {
		return TextBrand;
	}

	public void setTextBrand(TextField brand) {
		this.TextBrand = brand;
	}

	public TextField getTextPrice() {
		return TextPrice;
	}

	public void setTextPrice(TextField price) {
		this.TextPrice = price;
	}

	public GridPane getGridPane() {
		return gridPane;
	}

	public void setGridPane(GridPane gridPane) {
		this.gridPane = gridPane;
	}

	public Button getAdd() {
		return add;
	}

	public void setAdd(Button add) {
		this.add = add;
	}


	public VBox getPane() {
		ComboBox<String> comboBox=new ComboBox<>();
		comboBox.setPromptText(getcomboBoxText());
		comboBox.getItems().addAll();
		comboBox.setPrefWidth(500);
		
		
		gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setPadding(new Insets(15, 15, 15, 15));
		gridPane.setHgap(6);
		gridPane.setVgap(6);
		
		gridPane.add(new Label("Brand:"), 0, 0);
		gridPane.add(TextBrand, 1, 0);
		TextBrand.setPromptText("Ex.");
		
		
		
		gridPane.add(new Label("Price:"),0, 1);
		gridPane.add(TextPrice, 1, 1);
		
		
			
		
		VBox vbox=new VBox();
		vbox.getChildren().addAll(comboBox,gridPane,add);
		vbox.setAlignment(Pos.CENTER);
		vbox.setPadding(new Insets(15, 15,15, 15));
		
		return vbox;
		
	}
	
	
	

	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
