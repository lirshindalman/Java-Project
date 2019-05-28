import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddInstrumentPane extends Application  {
	
	

	public void getPane() {
		Stage primaryStage=new Stage();
		primaryStage.setTitle("Afeka Instruments- Add new");
		
		ComboBox<String> comboBox=new ComboBox<>();
		comboBox.setPromptText("Choose Instrument Type Here");
		comboBox.getItems().addAll("Guitar","Bass","Flute","Saxophone");
		comboBox.setPrefWidth(500);
		VBox vbox=new VBox();
		vbox.getChildren().add(comboBox);
		vbox.setAlignment(Pos.CENTER);
		vbox.setPadding(new Insets(15, 15,15, 15));
		Scene scene = new Scene(vbox,350,300);
		primaryStage.setScene(scene);
		
		comboBox.setOnAction(e->{
			if(comboBox.getValue().equals("Guitar")) {
				AddGuitar addGuitar=new AddGuitar();
				Scene scene2 = new Scene(addGuitar.getPane(),350,300);
				primaryStage.setScene(scene2); 
			}
			if(comboBox.getValue().equals("Bass")) {
				AddBass addBass=new AddBass();
				Scene scene2 = new Scene(addBass.getPane(),350,300);
				primaryStage.setScene(scene2);
			}
			if(comboBox.getValue().equals("Flute")) {
				AddFlute addFlute=new AddFlute();
				Scene scene2 = new Scene(addFlute.getPane(),350,300);
				primaryStage.setScene(scene2);
			}
			if(comboBox.getValue().equals("Saxophone")) {
				AddSaxophone addSaxophone=new AddSaxophone();
				Scene scene2 = new Scene(addSaxophone.getPane(),350,300);
				primaryStage.setScene(scene2);
			}
			
		});
		
		primaryStage.showAndWait();
		primaryStage.close();
	}

	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		getPane();
		
	}

}
