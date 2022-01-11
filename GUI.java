//Author: Grant Stevens
//Last Updated: Dec 12,2021
//Methods:+main, +star3t 
//Attributes:None
//
//Purpose: This class is responsible for the GUI of the Scheduler.
//
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import java.util.InputMismatchException;

//Author: Grant Stevens
//Last Updated: Nov 19,2021
//Methods:main, star3t
//Attributes:None
//
//Purpose:Will later contain the graphical elements for the scheduler
//
public class GUI extends Application{

	public static void main(String[] args) throws IOException {
		
		Application.launch(args);
		//star3t();
		
		
	}
	public void start(Stage primaryStage) throws IOException {
	GridPane gridPane = new GridPane();
	gridPane.setMinSize(600,400);
	gridPane.setVgap(5);
	gridPane.setHgap(5);
	gridPane.setAlignment(Pos.CENTER);
	gridPane.gridLinesVisibleProperty();
	
	Text maxLabel = new Text("Please enter your 1 rep maxes for the following");
	Text restOfInfo = new Text("Please finish filling out all the required information");
	Text userGuide = new Text("Workout creation boundaries- Days[2-6], Minutes[ > 30]");
	
	TextField workoutName = new TextField("Workout title");
	TextField squatMax = new TextField("Squat [Int]");
	TextField deadliftMax = new TextField("Deadlift [Int]");
	TextField benchMax = new TextField("Bench [Int]");
	TextField workoutType = new TextField("Hypertrophy/Powerlifting");
	TextField bodyWeight = new TextField("Current bodyweight [Int]");
	TextField timeDay = new TextField("Avalibility days per week [Int]");
	TextField timeMinutes = new TextField("Avalibility min per session [Int]");
	
	Button submitData = new Button("Save and create workout");
	Button bodyweightTrack = new Button("View bodyweight progress");
	
	WorkoutController test = new WorkoutController();
	submitData.setOnAction(e ->{ 
		
		try {
			String type = workoutType.getText();
			int sq = Integer.parseInt(squatMax.getText());
			int dl = Integer.parseInt(deadliftMax.getText());
			int bn = Integer.parseInt(benchMax.getText());
			String name = workoutName.getText();
			int bdyweight = Integer.parseInt(bodyWeight.getText());
			int days = Integer.parseInt(timeDay.getText());
			int minutes = Integer.parseInt((timeMinutes.getText()));
			test.sendData(bn, sq, dl, days, minutes, type, name, bdyweight);
			test.WorkoutController4();
			test.writebodyWeight();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InputMismatchException e2) {
			System.out.println("Please verify that you have entered in the correct info");
		} catch (NumberFormatException e3) {
			System.out.println("Please verify that you have entered in the correct info");
		}
	});
	
	bodyweightTrack.setOnAction(e -> {
		test.loadBodyWeight();
		test.viewBodyWeight();
	});
	
	//gridPane.getChildren().addAll(button,workoutType);
	//gridPane.add(workoutType, 2, 1);
	gridPane.add(workoutName, 0, 0);
	gridPane.add(userGuide, 1, 0);
	gridPane.add(maxLabel, 0,1);
	gridPane.add(restOfInfo, 0, 2);
	gridPane.add(timeMinutes, 1, 3);
	gridPane.add(submitData, 1, 4);
	gridPane.add(bodyweightTrack, 0, 4);
	gridPane.add(timeDay, 3, 2);
	gridPane.add(squatMax, 1, 1);
	gridPane.add(benchMax, 2, 1);
	gridPane.add(deadliftMax, 3, 1);
	gridPane.add(bodyWeight, 1, 2);
	gridPane.add(workoutType, 2, 2);
	
	Scene scene = new Scene(gridPane);
	primaryStage.setScene(scene);
	primaryStage.show();
	
	
		
	}
}
