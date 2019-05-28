import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AddressBookJavaFx extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		for (int i = 0; i <= AddressBookPane.MAX_PANES; i++) 
		{
			AddressBP pane =AddressBookPane.getInstance();
			if (pane != null) 
			{
				Pane p = pane.getPane();
				Scene scene = new Scene(p);
				scene.getStylesheets().add("styles.css");
				primaryStage.setTitle("AddressBook");
				primaryStage.setScene(scene);
				primaryStage.show();
				primaryStage.setAlwaysOnTop(true);
				primaryStage = new Stage();
			}
			else System.out.println("Singelton Violation. Only 3 panse were created");
		}

	}
}
