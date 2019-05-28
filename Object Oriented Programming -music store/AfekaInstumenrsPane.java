import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.layout.HBox;

public class AfekaInstumenrsPane extends Application {
	private static Button buttonR, buttonL, buttonGo, buttonA, buttonD, buttonC;
	private static int cunter;
	private static TextField tayp, brand, price;
	final int SPACE=15;
	
	public static void main(String[] args) {
		launch(args);

	}

	public void show() {
		Stage primaryStage = new Stage();
		primaryStage.setTitle("Afeka Instruments Music Store");
		ArrayList<MusicalInstrument> showArray=new ArrayList<MusicalInstrument>();
		showArray.addAll(AfekaInstruments.getallInstruments());

		//////////////////// המוצרים
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setPadding(new Insets(SPACE, SPACE, SPACE, SPACE));
		gridPane.setHgap(5.5);
		gridPane.setVgap(5.5);
		// Place nodes in the pane
		tayp = new TextField();
		gridPane.add(new Label("Type:"), 0, 0);
		gridPane.add(tayp, 1, 0);
	
		brand = new TextField();
		gridPane.add(new Label("Brand:"), 0, 1);
		gridPane.add(brand, 1, 1);
		
		price = new TextField();
		gridPane.add(new Label("Price:"), 0, 2);
		gridPane.add(price, 1, 2);

		showInsrtumrns(cunter);

		//////////////////// חצים
		cunter = 0;
		VBox vboxR = new VBox();
		buttonR = new Button(">");
		vboxR.getChildren().add(buttonR);
		vboxR.setAlignment(Pos.CENTER);
		vboxR.setPadding(new Insets(SPACE, SPACE, SPACE, SPACE));
		VBox vboxL = new VBox();
		buttonL = new Button("<");
		vboxL.getChildren().add(buttonL);
		vboxL.setAlignment(Pos.CENTER_LEFT);
		vboxL.setPadding(new Insets(SPACE, SPACE, SPACE, SPACE));
		
		buttonR.setOnAction(e -> {
			if (cunter == AfekaInstruments.getallInstruments().size()-1)
				cunter = 0;
			else
				cunter++;
			showInsrtumrns(cunter);
		});
		buttonL.setOnAction(e -> {
			if (cunter == 0)
				cunter = AfekaInstruments.getallInstruments().size()-1;
			else
				cunter--;
			showInsrtumrns(cunter);
		});


		///////////////// שורת חיפוש
		HBox hbox1 = new HBox(5);
		TextField search = new TextField();
		search.setPromptText("Search...");
		search.setPrefWidth(800);
		buttonGo = new Button("Go!");
		hbox1.setPadding(new Insets(SPACE, SPACE, SPACE, SPACE));
		hbox1.getChildren().addAll(search, buttonGo);
		buttonGo.setOnAction(e -> {
			cunter=0;
			if(search.getText()!=null)
			{
				search(search.getText());
				showInsrtumrns(cunter);
			}
		});
	
		
		
		
		///////////////// כפתורים
		HBox hbox2 = new HBox(10);
		buttonA = new Button("Add");
		AddInstrumentPane addInstrumentPane = new AddInstrumentPane();
		buttonA.setOnAction(e -> addInstrumentPane.getPane());
		
		buttonD = new Button("Delete");
		buttonD.setOnAction(e -> {
			AfekaInstruments.getallInstruments().remove(cunter);
			if(cunter==0)
				showInsrtumrns(cunter);
			else
				showInsrtumrns(cunter-1);
		});
		buttonC = new Button("Clear");
		buttonC.setOnAction(e -> {
			AfekaInstruments.getallInstruments().clear();
			showInsrtumrns(cunter);
		});
		hbox2.setPadding(new Insets(15, 15, 15, 15));
		hbox2.getChildren().addAll(buttonA, buttonD, buttonC);
		hbox2.setAlignment(Pos.CENTER);
		hbox2.setSpacing(30);

		/////////// שורה זזה
		Line line =new Line(250,0,500,0);
		Text text= new Text();
		Timeline clock=new Timeline();
		DateFormat dateFormat= new SimpleDateFormat("yyy-MM-dd");
		Date date=new Date();
		clock.getKeyFrames().add(new KeyFrame(Duration.seconds(1),e-> {
			text.setText(dateFormat.format(date)+" "+ LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"))
					+"Afeka Instruments Musical Store $$$ NO SALE!!! $$$ Guitars, Basses ,Flutes,Saxophones, and more!");
		}));
		clock.setCycleCount(Animation.INDEFINITE);
		clock.play();
		text.setFill(Color.RED);
		text.setFont(Font.font("Times New Roman",FontWeight.BOLD,FontPosture.REGULAR,15));
		PathTransition pathTransition= new PathTransition(Duration.seconds(10),line);
		pathTransition.setCycleCount(Animation.INDEFINITE);
		pathTransition.setAutoReverse(true);
		pathTransition.setNode(text);
		VBox lowPane=new VBox();
		lowPane.getChildren().addAll(hbox2,text);
		lowPane.setPadding(new Insets(SPACE,SPACE,SPACE,SPACE));
		lowPane.setSpacing(10);
		
		pathTransition.play();
		text.setOnMouseEntered(e-> pathTransition.pause());
		text.setOnMouseExited(e-> pathTransition.play());
		
		BorderPane pane = new BorderPane();
		pane.setRight(vboxR);
		pane.setLeft(vboxL);
		pane.setCenter(gridPane);
		pane.setTop(hbox1);
		pane.setBottom(lowPane);
	
		
		Scene scene = new Scene(pane);
		
		scene.setOnKeyPressed(e -> {
		    if (e.getCode() == KeyCode.A) {
		    	addInstrumentPane.getPane();
		    }
		    if (e.getCode() == KeyCode.D) {
		    	AfekaInstruments.getallInstruments().remove(cunter);
		    	if(cunter==0)
					showInsrtumrns(cunter);
				else
					showInsrtumrns(cunter-1);
		    }
		    if (e.getCode() == KeyCode.C) {
		    	AfekaInstruments.getallInstruments().clear();
				showInsrtumrns(cunter);
		    }
		    if (e.getCode() == KeyCode.ENTER) {
		    	cunter=0;
				//if(search.getText()!=null)
				//{
					search(search.getText());
					showInsrtumrns(cunter);
				//}
		    }
		});
		
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

	}

	public static void showInsrtumrns(int index) {
		if (AfekaInstruments.getallInstruments().size() > 0) {
			tayp.setText(AfekaInstruments.getallInstruments().get(index).getClass().getCanonicalName());
			brand.setText(AfekaInstruments.getallInstruments().get(index).getBrand());
			price.setText(AfekaInstruments.getallInstruments().get(index).getPrice().toString());
		}
		if(AfekaInstruments.getallInstruments().size()==0) {
			tayp.setText("No Items");
			brand.setText("No Items");
			price.setText("No Items");
		}
	}
	

	public static void search( String search){
		
		ArrayList<MusicalInstrument> searchArray=new ArrayList<MusicalInstrument>();
		searchArray.addAll(AfekaInstruments.getallInstruments());
		AfekaInstruments.getallInstruments().clear();
		for(int i=0 ; i<searchArray.size();i++) {
				if(searchArray.get(i).toString().contains(search))
					AfekaInstruments.getallInstruments().add(searchArray.get(i));	
			}
		}
			
	
	
	
}
