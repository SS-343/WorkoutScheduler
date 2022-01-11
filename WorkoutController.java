//Author: Grant Stevens
//Last Updated: Dec 12,2021
//Methods:+workoutController4, +randomNum, +createWorkoutPl, +createWorkoutHy, +sendData, +viewBodyWeight, +loadBodyWeight, 
//Methods continued: +exportPowerLiftingWorkout, +exportHypertrophyworkout, +findRoutine, 
//Attributes: -workoutName, -squatMax, -deadliftMax, -benchMax, -goal, -availableDays, -avaliableMinutes, -weightType, -pl, -hy, -routine, -bodyweight
//
//Purpose:this class is responsible for communicating with the user and building a workout based on user preferences.
//This class also interacts with the GUI and prints the workout to files.
//
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WorkoutController {
	private String workoutName = "";
	private int squatMax = 0;
	private int benchMax = 0;
	private int deadliftMax = 0;
	private String goal = "";
	private int avaliableDays = 0;
	private int avaliableMinutes = 0;
	private ArrayList<Integer> bodyweight = new ArrayList<Integer>();
	private PowerLifting pl = new PowerLifting();
	private Hypertrophy ht = new Hypertrophy();
	private String routine ="--";
	
	
	
	
	//make wrkoutcont constucter
	public void WorkoutController4() throws IOException {

		if(goal.equalsIgnoreCase("powerlifting")) {
			//System.out.println("createWorkout called");
			createWorkoutPl(goal, squatMax, benchMax, deadliftMax, avaliableMinutes, findRoutine(avaliableDays));
		}
		else if(goal.equalsIgnoreCase("hypertrophy")) {
			createWorkoutHy(goal, squatMax, benchMax, deadliftMax, avaliableMinutes, findRoutine(avaliableDays));
		
		}
	}
	
	public void sendData(int bench, int squat, int deadlift, int days, int minutes, String method, String title, int bodyweightNum) {
	benchMax = bench;
	squatMax = squat;
	deadliftMax = deadlift;
	avaliableMinutes = minutes;
	avaliableDays = days;
	workoutName = title;
	goal = method;
	bodyweight.add(bodyweightNum);
	}


	public void viewBodyWeight() {
		//System.out.println(bodyweight.size());
		for(int i = 0; i <bodyweight.size(); i++) {
			System.out.println( (i+1) + " : " + bodyweight.get(i));
			//System.out.println("echo");
		}
	}
	
	public void loadBodyWeight() {
		
		try {
			File input = new File("Bodyweight Logs.txt");
			Scanner in = new Scanner(input);
			while(in.hasNextLine()){
			int weight = Integer.parseInt(in.nextLine());
			bodyweight.add(weight);
			}
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("The bodyweight information could not be found");
		}
	}
	
	public void writebodyWeight() {
		File bodyweightInfo = new File("Bodyweight Logs.txt");
		PrintWriter writeBody;
		try {
			writeBody = new PrintWriter("Bodyweight Logs.txt");
			for(int k =0; k < bodyweight.size(); k++) {
				writeBody.println(bodyweight.get(k));
			}
			writeBody.close();	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	
	
	public void exportPowerLiftingWorkout(ArrayList<ArrayList<PowerLifting>> input) throws IOException{
		File workout = new File("PowerLiftingWorkout.txt");
		FileWriter write = new FileWriter("PowerLiftingWorkout.txt");
		PrintWriter writep = new PrintWriter("PowerLiftingWorkout.txt");
		//System.out.println("Echo");
		
		
		int rest = 0;
		int setCount =0;
		writep.print("Powerlifting Workout");
		writep.println("");
		System.out.println(routine);
		if(routine.equals("Ul1")){
			writep.println("_________");
			writep.println("| Upper |");
			writep.println("________________________________________________________________________________");
			writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n", "Exercise: ", " | ", "Weight", " | ","Set", " | ", "Rep", " | ", "Rest (Minutes)");
				int i =0;
				for(int j = 0; j < input.get(i).size(); j++) {
				rest = randomNum(2,4);
				setCount = randomNum(2,4);
				writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n",  input.get(i).get(j).getCurrentExercise().getName(), " | ",input.get(i).get(j).getWeight(), " | ", setCount," | ",input.get(i).get(j).getRepetitions(), " | ", rest );
				}
				i++;
			writep.println("________________________________________________________________________________");
			writep.write("| Lower |");
			writep.println(" ");
			writep.println("________________________________________________________________________________");
			writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n", "Exercise: ", " | ", "Weight", " | ","Set", " | ", "Rep", " | ", "Rest (Minutes)");
				i =1;
	
				for(int j = 0; j < input.get(i).size(); j++) {
				rest = randomNum(2,4);
				setCount = randomNum(2,4);
				writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n",  input.get(i).get(j).getCurrentExercisel().getName(), " | ",input.get(i).get(j).getWeight(), " | ", setCount," | ",input.get(i).get(j).getRepetitions(), " | ", rest );
				
				}
			writep.println("________________________________________________________________________________");
		}
		else if(routine.equals("PPL")) {
			writep.println("_________");
			writep.println("| Push |");
			writep.println("________________________________________________________________________________");
			writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n", "Exercise: ", " | ", "Weight", " | ","Set", " | ", "Rep", " | ", "Rest (Minutes)");
			//for(int i = 0; i < 1; i++) {
				int i =0;
				for(int j = 0; j < input.get(i).size(); j++) {
				rest = randomNum(2,4);
				setCount = randomNum(2,4);
				writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n",  input.get(i).get(j).getCurrentExercise().getName(), " | ",input.get(i).get(j).getWeight(), " | ", setCount," | ",input.get(i).get(j).getRepetitions(), " | ", rest );
				}
				i++;
			writep.println("________________________________________________________________________________");
			writep.write("| Pull |");
			writep.println(" ");
			writep.println("________________________________________________________________________________");
			writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n", "Exercise: ", " | ", "Weight", " | ","Set", " | ", "Rep", " | ", "Rest (Minutes)");
			
				for(int j = 0; j < input.get(i).size(); j++) {
				rest = randomNum(2,4);
				setCount = randomNum(2,4);
				writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n",  input.get(i).get(j).getCurrentExercise().getName(), " | ",input.get(i).get(j).getWeight(), " | ", setCount," | ",input.get(i).get(j).getRepetitions(), " | ", rest );
				}
				i++;
			writep.println("________________________________________________________________________________");
			writep.write("| Legs |");
			writep.println(" ");
			writep.println("________________________________________________________________________________");
			writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n", "Exercise: ", " | ", "Weight", " | ","Set", " | ", "Rep", " | ", "Rest (Minutes)");
				for(int j = 0; j < input.get(i).size(); j++) {
				rest = randomNum(2,4);
				setCount = randomNum(2,4);
				writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n",  input.get(i).get(j).getCurrentExercisel().getName(), " | ",input.get(i).get(j).getWeight(), " | ", setCount," | ",input.get(i).get(j).getRepetitions(), " | ", rest );
				}
		}
		else if(routine.equals("UL2")) {
			writep.println("_________");
			writep.println("| Upper |");
			writep.println("________________________________________________________________________________");
			writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n", "Exercise: ", " | ", "Weight", " | ","Set", " | ", "Rep", " | ", "Rest (Minutes)");
				int i =0;
				for(int j = 0; j < input.get(i).size(); j++) {
				rest = randomNum(2,4);
				setCount = randomNum(2,4);
				writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n",  input.get(i).get(j).getCurrentExercise().getName(), " | ",input.get(i).get(j).getWeight(), " | ", setCount," | ",input.get(i).get(j).getRepetitions(), " | ", rest );
				}
				i++;
			writep.println("________________________________________________________________________________");
			writep.write("| Lower |");
			writep.println(" ");
			writep.println("________________________________________________________________________________");
			writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n", "Exercise: ", " | ", "Weight", " | ","Set", " | ", "Rep", " | ", "Rest (Minutes)");
	
				for(int j = 0; j < input.get(i).size(); j++) {
				rest = randomNum(2,4);
				setCount = randomNum(2,4);
				writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n",  input.get(i).get(j).getCurrentExercisel().getName(), " | ",input.get(i).get(j).getWeight(), " | ", setCount," | ",input.get(i).get(j).getRepetitions(), " | ", rest );
				
				}
				i++;
			writep.println("________________________________________________________________________________");
			writep.println("_________");
			writep.println("| Upper |");
			writep.println("________________________________________________________________________________");
			writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n", "Exercise: ", " | ", "Weight", " | ","Set", " | ", "Rep", " | ", "Rest (Minutes)");
				for(int j = 0; j < input.get(i).size(); j++) {
				rest = randomNum(2,4);
				setCount = randomNum(2,4);
				writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n",  input.get(i).get(j).getCurrentExercise().getName(), " | ",input.get(i).get(j).getWeight(), " | ", setCount," | ",input.get(i).get(j).getRepetitions(), " | ", rest );
				}
				i++;
			writep.println("________________________________________________________________________________");
			writep.write("| Lower |");
			writep.println(" ");
			writep.println("________________________________________________________________________________");
			writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n", "Exercise: ", " | ", "Weight", " | ","Set", " | ", "Rep", " | ", "Rest (Minutes)");
				
				for(int j = 0; j < input.get(i).size(); j++) {
				rest = randomNum(2,4);
				setCount = randomNum(2,4);
				writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n",  input.get(i).get(j).getCurrentExercisel().getName(), " | ",input.get(i).get(j).getWeight(), " | ", setCount," | ",input.get(i).get(j).getRepetitions(), " | ", rest );
				
				}
			writep.println("________________________________________________________________________________");
		}
		else if(routine.equals("alt")) {
			writep.println("_________");
			writep.println("| Upper |");
			writep.println("________________________________________________________________________________");
			writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n", "Exercise: ", " | ", "Weight", " | ","Set", " | ", "Rep", " | ", "Rest (Minutes)");
				int i =0;
				for(int j = 0; j < input.get(i).size(); j++) {
				rest = randomNum(2,4);
				setCount = randomNum(2,4);
				writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n",  input.get(i).get(j).getCurrentExercise().getName(), " | ",input.get(i).get(j).getWeight(), " | ", setCount," | ",input.get(i).get(j).getRepetitions(), " | ", rest );
				}
				i++;
			writep.println("________________________________________________________________________________");
			writep.write("| Lower |");
			writep.println(" ");
			writep.println("________________________________________________________________________________");
			writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n", "Exercise: ", " | ", "Weight", " | ","Set", " | ", "Rep", " | ", "Rest (Minutes)");
	
				for(int j = 0; j < input.get(i).size(); j++) {
				rest = randomNum(2,4);
				setCount = randomNum(2,4);
				writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n",  input.get(i).get(j).getCurrentExercisel().getName(), " | ",input.get(i).get(j).getWeight(), " | ", setCount," | ",input.get(i).get(j).getRepetitions(), " | ", rest );
				
				}
				i++;
			writep.println("________________________________________________________________________________");
			writep.println("_________");
			writep.println("| Pull |");
			writep.println("________________________________________________________________________________");
			writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n", "Exercise: ", " | ", "Weight", " | ","Set", " | ", "Rep", " | ", "Rest (Minutes)");
				for(int j = 0; j < input.get(i).size(); j++) {
				rest = randomNum(2,4);
				setCount = randomNum(2,4);
				writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n",  input.get(i).get(j).getCurrentExercise().getName(), " | ",input.get(i).get(j).getWeight(), " | ", setCount," | ",input.get(i).get(j).getRepetitions(), " | ", rest );
				}
				i++;
			writep.println("________________________________________________________________________________");
			writep.write("| Lower |");
			writep.println(" ");
			writep.println("________________________________________________________________________________");
			writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n", "Exercise: ", " | ", "Weight", " | ","Set", " | ", "Rep", " | ", "Rest (Minutes)");
				
				for(int j = 0; j < input.get(i).size(); j++) {
				rest = randomNum(2,4);
				setCount = randomNum(2,4);
				writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n",  input.get(i).get(j).getCurrentExercisel().getName(), " | ",input.get(i).get(j).getWeight(), " | ", setCount," | ",input.get(i).get(j).getRepetitions(), " | ", rest );
				
				}
				i++;
			writep.println("________________________________________________________________________________");
			writep.println("_________");
			writep.println("| Upper |");
			writep.println("________________________________________________________________________________");
			writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n", "Exercise: ", " | ", "Weight", " | ","Set", " | ", "Rep", " | ", "Rest (Minutes)");
	
				for(int j = 0; j < input.get(i).size(); j++) {
				rest = randomNum(2,4);
				setCount = randomNum(2,4);
				writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n",  input.get(i).get(j).getCurrentExercise().getName(), " | ",input.get(i).get(j).getWeight(), " | ", setCount," | ",input.get(i).get(j).getRepetitions(), " | ", rest );
				}
		}
		else if(routine == "PPL2") {
			writep.println("_________");
			writep.println("| Push |");
			writep.println("________________________________________________________________________________");
			writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n", "Exercise: ", " | ", "Weight", " | ","Set", " | ", "Rep", " | ", "Rest (Minutes)");
			//for(int i = 0; i < 1; i++) {
				int i =0;
				for(int j = 0; j < input.get(i).size(); j++) {
				rest = randomNum(2,4);
				setCount = randomNum(2,4);
				writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n",  input.get(i).get(j).getCurrentExercise().getName(), " | ",input.get(i).get(j).getWeight(), " | ", setCount," | ",input.get(i).get(j).getRepetitions(), " | ", rest );
				}
				i++;
			writep.println("________________________________________________________________________________");
			writep.write("| Pull |");
			writep.println(" ");
			writep.println("________________________________________________________________________________");
			writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n", "Exercise: ", " | ", "Weight", " | ","Set", " | ", "Rep", " | ", "Rest (Minutes)");
			
				for(int j = 0; j < input.get(i).size(); j++) {
				rest = randomNum(2,4);
				setCount = randomNum(2,4);
				writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n",  input.get(i).get(j).getCurrentExercise().getName(), " | ",input.get(i).get(j).getWeight(), " | ", setCount," | ",input.get(i).get(j).getRepetitions(), " | ", rest );
				}
				i++;
			writep.println("________________________________________________________________________________");
			writep.write("| Legs |");
			writep.println(" ");
			writep.println("________________________________________________________________________________");
			writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n", "Exercise: ", " | ", "Weight", " | ","Set", " | ", "Rep", " | ", "Rest (Minutes)");
				for(int j = 0; j < input.get(i).size(); j++) {
				rest = randomNum(2,4);
				setCount = randomNum(2,4);
				writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n",  input.get(i).get(j).getCurrentExercisel().getName(), " | ",input.get(i).get(j).getWeight(), " | ", setCount," | ",input.get(i).get(j).getRepetitions(), " | ", rest );
				}
				writep.println("_________");
				writep.println("| Push |");
				writep.println("________________________________________________________________________________");
				writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n", "Exercise: ", " | ", "Weight", " | ","Set", " | ", "Rep", " | ", "Rest (Minutes)");
				//for(int i = 0; i < 1; i++) {
					i++;
					for(int j = 0; j < input.get(i).size(); j++) {
					rest = randomNum(2,4);
					setCount = randomNum(2,4);
					writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n",  input.get(i).get(j).getCurrentExercise().getName(), " | ",input.get(i).get(j).getWeight(), " | ", setCount," | ",input.get(i).get(j).getRepetitions(), " | ", rest );
					}
					i++;
				writep.println("________________________________________________________________________________");
				writep.write("| Pull |");
				writep.println(" ");
				writep.println("________________________________________________________________________________");
				writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n", "Exercise: ", " | ", "Weight", " | ","Set", " | ", "Rep", " | ", "Rest (Minutes)");
				
					for(int j = 0; j < input.get(i).size(); j++) {
					rest = randomNum(2,4);
					setCount = randomNum(2,4);
					writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n",  input.get(i).get(j).getCurrentExercise().getName(), " | ",input.get(i).get(j).getWeight(), " | ", setCount," | ",input.get(i).get(j).getRepetitions(), " | ", rest );
					}
					i++;
				writep.println("________________________________________________________________________________");
				writep.write("| Legs |");
				writep.println(" ");
				writep.println("________________________________________________________________________________");
				writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n", "Exercise: ", " | ", "Weight", " | ","Set", " | ", "Rep", " | ", "Rest (Minutes)");
					for(int j = 0; j < input.get(i).size(); j++) {
					rest = randomNum(2,4);
					setCount = randomNum(2,4);
					writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n",  input.get(i).get(j).getCurrentExercisel().getName(), " | ",input.get(i).get(j).getWeight(), " | ", setCount," | ",input.get(i).get(j).getRepetitions(), " | ", rest );
					}
		}
		write.close();
		writep.close();
		
	}
	
	public void exportHypertrophyWorkout(ArrayList<ArrayList<Hypertrophy>> input) throws IOException{
		File workout = new File("HypertrophyWorkout.txt");
		FileWriter write = new FileWriter("HypertrophyWorkout.txt");
		PrintWriter writep = new PrintWriter("HypertrophyWorkout.txt");
		int rest = 0;
		int setCount =0;
		writep.print("Powerlifting Workout");
		writep.println("");
		System.out.println(routine);
		if(routine.equals("Ul1")){
			writep.println("_________");
			writep.println("| Upper |");
			writep.println("________________________________________________________________________________");
			writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n", "Exercise: ", " | ", "Weight", " | ","Set", " | ", "Rep", " | ", "Rest (Minutes)");
				int i =0;
				for(int j = 0; j < input.get(i).size(); j++) {
				rest = randomNum(1,3);
				setCount = randomNum(3,5);
				writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n",  input.get(i).get(j).getCurrentExercise().getName(), " | ",input.get(i).get(j).getWeight(), " | ", setCount," | ",input.get(i).get(j).getRepetitions(), " | ", rest );
				}
				i++;
			writep.println("________________________________________________________________________________");
			writep.write("| Lower |");
			writep.println(" ");
			writep.println("________________________________________________________________________________");
			writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n", "Exercise: ", " | ", "Weight", " | ","Set", " | ", "Rep", " | ", "Rest (Minutes)");
				i =1;
	
				for(int j = 0; j < input.get(i).size(); j++) {
				rest = randomNum(1,3);
				setCount = randomNum(3,5);
				writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n",  input.get(i).get(j).getCurrentExercisel().getName(), " | ",input.get(i).get(j).getWeight(), " | ", setCount," | ",input.get(i).get(j).getRepetitions(), " | ", rest );
				
				}
			writep.println("________________________________________________________________________________");
		}
		else if(routine.equals("PPL")) {
			writep.println("_________");
			writep.println("| Push |");
			writep.println("________________________________________________________________________________");
			writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n", "Exercise: ", " | ", "Weight", " | ","Set", " | ", "Rep", " | ", "Rest (Minutes)");
			//for(int i = 0; i < 1; i++) {
				int i =0;
				for(int j = 0; j < input.get(i).size(); j++) {
				rest = randomNum(1,3);
				setCount = randomNum(3,5);
				writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n",  input.get(i).get(j).getCurrentExercise().getName(), " | ",input.get(i).get(j).getWeight(), " | ", setCount," | ",input.get(i).get(j).getRepetitions(), " | ", rest );
				}
				i++;
			writep.println("________________________________________________________________________________");
			writep.write("| Pull |");
			writep.println(" ");
			writep.println("________________________________________________________________________________");
			writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n", "Exercise: ", " | ", "Weight", " | ","Set", " | ", "Rep", " | ", "Rest (Minutes)");
			
				for(int j = 0; j < input.get(i).size(); j++) {
				rest = randomNum(1,3);
				setCount = randomNum(3,5);
				writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n",  input.get(i).get(j).getCurrentExercise().getName(), " | ",input.get(i).get(j).getWeight(), " | ", setCount," | ",input.get(i).get(j).getRepetitions(), " | ", rest );
				}
				i++;
			writep.println("________________________________________________________________________________");
			writep.write("| Legs |");
			writep.println(" ");
			writep.println("________________________________________________________________________________");
			writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n", "Exercise: ", " | ", "Weight", " | ","Set", " | ", "Rep", " | ", "Rest (Minutes)");
				for(int j = 0; j < input.get(i).size(); j++) {
				rest = randomNum(1,3);
				setCount = randomNum(3,5);
				writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n",  input.get(i).get(j).getCurrentExercisel().getName(), " | ",input.get(i).get(j).getWeight(), " | ", setCount," | ",input.get(i).get(j).getRepetitions(), " | ", rest );
				}
		}
		else if(routine.equals("UL2")) {
			writep.println("_________");
			writep.println("| Upper |");
			writep.println("________________________________________________________________________________");
			writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n", "Exercise: ", " | ", "Weight", " | ","Set", " | ", "Rep", " | ", "Rest (Minutes)");
				int i =0;
				for(int j = 0; j < input.get(i).size(); j++) {
				rest = randomNum(1,3);
				setCount = randomNum(3,5);
				writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n",  input.get(i).get(j).getCurrentExercise().getName(), " | ",input.get(i).get(j).getWeight(), " | ", setCount," | ",input.get(i).get(j).getRepetitions(), " | ", rest );
				}
				i++;
			writep.println("________________________________________________________________________________");
			writep.write("| Lower |");
			writep.println(" ");
			writep.println("________________________________________________________________________________");
			writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n", "Exercise: ", " | ", "Weight", " | ","Set", " | ", "Rep", " | ", "Rest (Minutes)");
	
				for(int j = 0; j < input.get(i).size(); j++) {
				rest = randomNum(1,3);
				setCount = randomNum(3,5);
				writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n",  input.get(i).get(j).getCurrentExercisel().getName(), " | ",input.get(i).get(j).getWeight(), " | ", setCount," | ",input.get(i).get(j).getRepetitions(), " | ", rest );
				
				}
				i++;
			writep.println("________________________________________________________________________________");
			writep.println("_________");
			writep.println("| Upper |");
			writep.println("________________________________________________________________________________");
			writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n", "Exercise: ", " | ", "Weight", " | ","Set", " | ", "Rep", " | ", "Rest (Minutes)");
				for(int j = 0; j < input.get(i).size(); j++) {
				rest = randomNum(1,3);
				setCount = randomNum(3,5);
				writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n",  input.get(i).get(j).getCurrentExercise().getName(), " | ",input.get(i).get(j).getWeight(), " | ", setCount," | ",input.get(i).get(j).getRepetitions(), " | ", rest );
				}
				i++;
			writep.println("________________________________________________________________________________");
			writep.write("| Lower |");
			writep.println(" ");
			writep.println("________________________________________________________________________________");
			writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n", "Exercise: ", " | ", "Weight", " | ","Set", " | ", "Rep", " | ", "Rest (Minutes)");
				
				for(int j = 0; j < input.get(i).size(); j++) {
				rest = randomNum(1,3);
				setCount = randomNum(3,5);
				writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n",  input.get(i).get(j).getCurrentExercisel().getName(), " | ",input.get(i).get(j).getWeight(), " | ", setCount," | ",input.get(i).get(j).getRepetitions(), " | ", rest );
				
				}
			writep.println("________________________________________________________________________________");
		}
		else if(routine.equals("alt")) {
			writep.println("_________");
			writep.println("| Upper |");
			writep.println("________________________________________________________________________________");
			writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n", "Exercise: ", " | ", "Weight", " | ","Set", " | ", "Rep", " | ", "Rest (Minutes)");
				int i =0;
				for(int j = 0; j < input.get(i).size(); j++) {
				rest = randomNum(1,3);
				setCount = randomNum(3,5);
				writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n",  input.get(i).get(j).getCurrentExercise().getName(), " | ",input.get(i).get(j).getWeight(), " | ", setCount," | ",input.get(i).get(j).getRepetitions(), " | ", rest );
				}
				i++;
			writep.println("________________________________________________________________________________");
			writep.write("| Lower |");
			writep.println(" ");
			writep.println("________________________________________________________________________________");
			writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n", "Exercise: ", " | ", "Weight", " | ","Set", " | ", "Rep", " | ", "Rest (Minutes)");
	
				for(int j = 0; j < input.get(i).size(); j++) {
				rest = randomNum(1,3);
				setCount = randomNum(3,5);
				writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n",  input.get(i).get(j).getCurrentExercisel().getName(), " | ",input.get(i).get(j).getWeight(), " | ", setCount," | ",input.get(i).get(j).getRepetitions(), " | ", rest );
				
				}
				i++;
			writep.println("________________________________________________________________________________");
			writep.println("_________");
			writep.println("| Pull |");
			writep.println("________________________________________________________________________________");
			writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n", "Exercise: ", " | ", "Weight", " | ","Set", " | ", "Rep", " | ", "Rest (Minutes)");
				for(int j = 0; j < input.get(i).size(); j++) {
				rest = randomNum(1,3);
				setCount = randomNum(3,5);
				writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n",  input.get(i).get(j).getCurrentExercise().getName(), " | ",input.get(i).get(j).getWeight(), " | ", setCount," | ",input.get(i).get(j).getRepetitions(), " | ", rest );
				}
				i++;
			writep.println("________________________________________________________________________________");
			writep.write("| Lower |");
			writep.println(" ");
			writep.println("________________________________________________________________________________");
			writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n", "Exercise: ", " | ", "Weight", " | ","Set", " | ", "Rep", " | ", "Rest (Minutes)");
				
				for(int j = 0; j < input.get(i).size(); j++) {
				rest = randomNum(1,3);
				setCount = randomNum(3,5);
				writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n",  input.get(i).get(j).getCurrentExercisel().getName(), " | ",input.get(i).get(j).getWeight(), " | ", setCount," | ",input.get(i).get(j).getRepetitions(), " | ", rest );
				
				}
				i++;
			writep.println("________________________________________________________________________________");
			writep.println("_________");
			writep.println("| Upper |");
			writep.println("________________________________________________________________________________");
			writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n", "Exercise: ", " | ", "Weight", " | ","Set", " | ", "Rep", " | ", "Rest (Minutes)");
	
				for(int j = 0; j < input.get(i).size(); j++) {
				rest = randomNum(1,3);
				setCount = randomNum(3,5);
				writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n",  input.get(i).get(j).getCurrentExercise().getName(), " | ",input.get(i).get(j).getWeight(), " | ", setCount," | ",input.get(i).get(j).getRepetitions(), " | ", rest );
				}
		}
		else if(routine == "PPL2") {
			writep.println("_________");
			writep.println("| Push |");
			writep.println("________________________________________________________________________________");
			writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n", "Exercise: ", " | ", "Weight", " | ","Set", " | ", "Rep", " | ", "Rest (Minutes)");
			//for(int i = 0; i < 1; i++) {
				int i =0;
				for(int j = 0; j < input.get(i).size(); j++) {
				rest = randomNum(1,3);
				setCount = randomNum(3,5);
				writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n",  input.get(i).get(j).getCurrentExercise().getName(), " | ",input.get(i).get(j).getWeight(), " | ", setCount," | ",input.get(i).get(j).getRepetitions(), " | ", rest );
				}
				i++;
			writep.println("________________________________________________________________________________");
			writep.write("| Pull |");
			writep.println(" ");
			writep.println("________________________________________________________________________________");
			writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n", "Exercise: ", " | ", "Weight", " | ","Set", " | ", "Rep", " | ", "Rest (Minutes)");
			
				for(int j = 0; j < input.get(i).size(); j++) {
				rest = randomNum(1,3);
				setCount = randomNum(3,5);
				writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n",  input.get(i).get(j).getCurrentExercise().getName(), " | ",input.get(i).get(j).getWeight(), " | ", setCount," | ",input.get(i).get(j).getRepetitions(), " | ", rest );
				}
				i++;
			writep.println("________________________________________________________________________________");
			writep.write("| Legs |");
			writep.println(" ");
			writep.println("________________________________________________________________________________");
			writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n", "Exercise: ", " | ", "Weight", " | ","Set", " | ", "Rep", " | ", "Rest (Minutes)");
				for(int j = 0; j < input.get(i).size(); j++) {
				rest = randomNum(1,3);
				setCount = randomNum(3,5);
				writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n",  input.get(i).get(j).getCurrentExercisel().getName(), " | ",input.get(i).get(j).getWeight(), " | ", setCount," | ",input.get(i).get(j).getRepetitions(), " | ", rest );
				}
				writep.println("_________");
				writep.println("| Push |");
				writep.println("________________________________________________________________________________");
				writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n", "Exercise: ", " | ", "Weight", " | ","Set", " | ", "Rep", " | ", "Rest (Minutes)");
				//for(int i = 0; i < 1; i++) {
					i++;
					for(int j = 0; j < input.get(i).size(); j++) {
						rest = randomNum(1,3);
						setCount = randomNum(3,5);
					writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n",  input.get(i).get(j).getCurrentExercise().getName(), " | ",input.get(i).get(j).getWeight(), " | ", setCount," | ",input.get(i).get(j).getRepetitions(), " | ", rest );
					}
					i++;
				writep.println("________________________________________________________________________________");
				writep.write("| Pull |");
				writep.println(" ");
				writep.println("________________________________________________________________________________");
				writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n", "Exercise: ", " | ", "Weight", " | ","Set", " | ", "Rep", " | ", "Rest (Minutes)");
				
					for(int j = 0; j < input.get(i).size(); j++) {
						rest = randomNum(1,3);
						setCount = randomNum(3,5);
					writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n",  input.get(i).get(j).getCurrentExercise().getName(), " | ",input.get(i).get(j).getWeight(), " | ", setCount," | ",input.get(i).get(j).getRepetitions(), " | ", rest );
					}
					i++;
				writep.println("________________________________________________________________________________");
				writep.write("| Legs |");
				writep.println(" ");
				writep.println("________________________________________________________________________________");
				writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n", "Exercise: ", " | ", "Weight", " | ","Set", " | ", "Rep", " | ", "Rest (Minutes)");
					for(int j = 0; j < input.get(i).size(); j++) {
						rest = randomNum(1,3);
						setCount = randomNum(3,5);
					writep.printf("%-30s %-2s %-7s %-2s %-4s %-2s %-4s %-2s %-4s %n",  input.get(i).get(j).getCurrentExercisel().getName(), " | ",input.get(i).get(j).getWeight(), " | ", setCount," | ",input.get(i).get(j).getRepetitions(), " | ", rest );
					}
		}
		write.close();
		writep.close();
	}
	
	public int randomNum(int low, int high) {
		int number = 0;
		number = (int) (Math.random() * (high - low) + low);

		return number;
	}

	public void createWorkoutHy(String methodology, int squatMax, int benchMax, int deadliftMax, int minutes, String routine) throws IOException {
		WorkoutPlan newWorkout = new WorkoutPlan();
		if(routine == "Ul1") {
			System.out.println("createWorkout called");
			newWorkout.dayPlanHy(ht.createSession(squatMax, benchMax, deadliftMax, minutes, "upper"), "A");
			newWorkout.dayPlanHy(ht.createSession(squatMax, benchMax, deadliftMax, minutes, "lower"), "L");
			newWorkout.exportToWorkoutController("hy");
		}
		else if(routine == "PPL") {
			newWorkout.dayPlanHy(ht.createSession(squatMax, benchMax, deadliftMax, minutes, "upper"), "A");
			newWorkout.dayPlanHy(ht.createSession(squatMax, benchMax, deadliftMax, minutes, "upper"), "A");
			newWorkout.dayPlanHy(ht.createSession(squatMax, benchMax, deadliftMax, minutes, "lower"), "L");
			newWorkout.exportToWorkoutController("hy");
		}
		else if(routine == "UL2") {
			newWorkout.dayPlanHy(ht.createSession(squatMax, benchMax, deadliftMax, minutes, "upper"), "A");
			newWorkout.dayPlanHy(ht.createSession(squatMax, benchMax, deadliftMax, minutes, "lower"), "L");
			newWorkout.dayPlanHy(ht.createSession(squatMax, benchMax, deadliftMax, minutes, "upper"), "A");
			newWorkout.dayPlanHy(ht.createSession(squatMax, benchMax, deadliftMax, minutes, "lower"), "L");
			newWorkout.exportToWorkoutController("hy");
		}
		else if(routine == "alt") {
			newWorkout.dayPlanHy(ht.createSession(squatMax, benchMax, deadliftMax, minutes, "upper"), "A");
			newWorkout.dayPlanHy(ht.createSession(squatMax, benchMax, deadliftMax, minutes, "lower"), "L");
			newWorkout.dayPlanHy(ht.createSession(squatMax, benchMax, deadliftMax, minutes, "upper"), "A");
			newWorkout.dayPlanHy(ht.createSession(squatMax, benchMax, deadliftMax, minutes, "lower"), "L");
			newWorkout.dayPlanHy(ht.createSession(squatMax, benchMax, deadliftMax, minutes, "upper"), "A");
			newWorkout.exportToWorkoutController("hy");
		}
		else if(routine == "PPL2") {
			newWorkout.dayPlanHy(ht.createSession(squatMax, benchMax, deadliftMax, minutes, "upper"), "A");
			newWorkout.dayPlanHy(ht.createSession(squatMax, benchMax, deadliftMax, minutes, "upper"), "A");
			newWorkout.dayPlanHy(ht.createSession(squatMax, benchMax, deadliftMax, minutes, "lower"), "L");
			newWorkout.dayPlanHy(ht.createSession(squatMax, benchMax, deadliftMax, minutes, "upper"), "A");
			newWorkout.dayPlanHy(ht.createSession(squatMax, benchMax, deadliftMax, minutes, "upper"), "A");
			newWorkout.dayPlanHy(ht.createSession(squatMax, benchMax, deadliftMax, minutes, "lower"), "L");
			newWorkout.exportToWorkoutController("hy");
		}
	}
		
		public void createWorkoutPl(String methodology, int squatMax, int benchMax, int deadliftMax, int minutes, String routine) throws IOException {
			WorkoutPlan newWorkout = new WorkoutPlan();
			//newWorkout.dayPlanPl(pl.createSession(squatMax, benchMax, deadliftMax,minutes,"fake text"));
			if(routine == "Ul1") {
				System.out.println("createWorkout called");
				newWorkout.dayPlanPl(pl.createSession(squatMax, benchMax, deadliftMax, minutes, "bench"),"A");
				newWorkout.dayPlanPl(pl.createSession(squatMax, benchMax, deadliftMax, minutes, "squat"), "L");
				newWorkout.exportToWorkoutController("pl");
			}
			
			else if(routine == "PPL") {
				newWorkout.dayPlanPl(pl.createSession(squatMax, benchMax, deadliftMax, minutes, "bench"), "A");
				newWorkout.dayPlanPl(pl.createSession(squatMax, benchMax, deadliftMax, minutes, "benchBack"), "A");
				newWorkout.dayPlanPl(pl.createSession(squatMax, benchMax, deadliftMax, minutes, "squat"), "L");
				newWorkout.exportToWorkoutController("pl");
			}
			else if(routine == "UL2") {
				newWorkout.dayPlanPl(pl.createSession(squatMax, benchMax, deadliftMax, minutes, "bench"), "A");
				newWorkout.dayPlanPl(pl.createSession(squatMax, benchMax, deadliftMax, minutes, "squat"), "L");
				newWorkout.dayPlanPl(pl.createSession(squatMax, benchMax, deadliftMax, minutes, "bench"), "A");
				newWorkout.dayPlanPl(pl.createSession(squatMax, benchMax, deadliftMax, minutes, "deadlift"), "L");
				newWorkout.exportToWorkoutController("pl");
			}
			else if(routine == "alt") {
				newWorkout.dayPlanPl(pl.createSession(squatMax, benchMax, deadliftMax, minutes, "bench"), "A");
				newWorkout.dayPlanPl(pl.createSession(squatMax, benchMax, deadliftMax, minutes, "squat"), "L");
				newWorkout.dayPlanPl(pl.createSession(squatMax, benchMax, deadliftMax, minutes, "benchBack"), "A");
				newWorkout.dayPlanPl(pl.createSession(squatMax, benchMax, deadliftMax, minutes, "squat"), "L");
				newWorkout.dayPlanPl(pl.createSession(squatMax, benchMax, deadliftMax, minutes, "bench"), "A");
				newWorkout.exportToWorkoutController("pl");
			}
			else if(routine == "PPL2") {
				newWorkout.dayPlanPl(pl.createSession(squatMax, benchMax, deadliftMax, minutes, "bench"), "A");
				newWorkout.dayPlanPl(pl.createSession(squatMax, benchMax, deadliftMax, minutes, "benchBack"), "A");
				newWorkout.dayPlanPl(pl.createSession(squatMax, benchMax, deadliftMax, minutes, "squat"), "L");
				newWorkout.dayPlanPl(pl.createSession(squatMax, benchMax, deadliftMax, minutes, "bench"), "A");
				newWorkout.dayPlanPl(pl.createSession(squatMax, benchMax, deadliftMax, minutes, "benchBack"), "A");
				newWorkout.dayPlanPl(pl.createSession(squatMax, benchMax, deadliftMax, minutes, "deadlift"), "L");
				newWorkout.exportToWorkoutController("pl");
			}
			
		//return null;
	}
		
	public void setRoutine(String x) {
		routine = x;
	}

	
	public String findRoutine(int freeDays) {
		if (freeDays == 2) {
			routine = "Ul1";
			return "Ul1";
		} else if (freeDays == 3) {
			return "PPL";
		} else if (freeDays == 4) {
			return "UL2";
		} else if (freeDays == 5) {
			return "alt";
		} else if (freeDays == 6) {
			return "PPL2";
		} else {
			System.out.println("There was an error determining the routine");
			return "";
		}
	}

}
