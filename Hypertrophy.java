//Author: Grant Stevens
//Last Updated: Dec 12,2021
//Methods:+createSession, +buildChestUpper, +buildShoulderUpper, +buildTricepUpper,
//+buildBackUpper, +buildBicepUpper, +buildHamstringLower, +buildGluteLower, +buildCalfLower, +buildQuadLower, 
//+calculateRest, -exerciseTimeFrame
//Attributes: -currentExercise, -currentExercisel
//
//Purpose:Builds an Hypertrophy object using an Upper/Lower as a base and accounts for a Hypertrophy type workout decision. 
//
import java.util.ArrayList;

public class Hypertrophy extends GenericWorkout {
private Upper currentExercise = new Upper();
private Lower currentExercisel = new Lower();

Hypertrophy(){
	//empty
}

Hypertrophy(int reps, int set, int repWeight, int setRest, Upper arm){
	super(reps,set,repWeight,setRest,arm);
}

Hypertrophy(int reps, int set, int repWeight, int setRest, Lower leg){
	super(reps,set,repWeight,setRest,leg);
}

public ArrayList<Hypertrophy> createSession(int squat, int bench, int deadlift, int sessionTime, String dayType) {
	//reps, int set, int repWeight, int setRest, Upper arm){
	int numExercise = exerciseTimeFrame(sessionTime);	
	ArrayList<Hypertrophy> session = new ArrayList<Hypertrophy>();
		//dayType = "upper";
		if(dayType == "upper") {
				session.add(buildChestUpper(bench));
				session.add(buildShoulderUpper(bench));
			if(numExercise > 2) {
				session.add(buildTricepUpper(bench));
			}
			if(numExercise > 3) {
				session.add(buildChestUpper(bench));
				session.add(buildTricepUpper(bench));
			}
			if(numExercise > 5) {
				session.add(buildShoulderUpper(bench));
			}
		}
		else if (dayType == "lower") {
				session.add(buildQuadLower(squat));
				session.add(buildCalfLower(squat));
			if(numExercise > 2) {
				session.add(buildHamstringLower(deadlift));
			}
			if(numExercise > 3) {
				session.add(buildGluteLower(deadlift));
			}
		}
		else if(dayType == "full") {
				session.add(buildChestUpper(bench));
				session.add(buildShoulderUpper(bench));
			if(numExercise > 2) {
				session.add(buildTricepUpper(bench));
			}
				session.add(buildQuadLower(squat));
			if(numExercise > 4) {
				session.add(buildHamstringLower(deadlift));
			}
		}
		else {
			System.out.println("Invalid dayType in hypertrophy creation");
		}
		return session;
			
	}

public Hypertrophy buildChestUpper(int bench) {
	WorkoutController methods = new WorkoutController();
	Hypertrophy exercise = new Hypertrophy(777,methods.randomNum(2,3),777,methods.randomNum(60,120),currentExercise.getRandomChestExercise());
	int newWeight = (int)((exercise.getArms().getWeight() * bench));
	exercise.setWeight(newWeight);
	//System.out.println(exercise1.getCurrentExercise().getName());
	int newReps = 0;
	if(exercise.getArms().getWeight() >.55) {
		newReps = 6;
	}
	else if(exercise.getArms().getWeight() >.8) {
		newReps = 4;
	}
	else {
		newReps = 8;
	}
	exercise.setRepetitions(newReps);
	exercise.setRest(calculateRest(exercise.getWeight()));
	return exercise;
}

public Hypertrophy buildTricepUpper(int bench) {
	WorkoutController methods = new WorkoutController();
	Hypertrophy exercise = new Hypertrophy(777,methods.randomNum(2,3),777,methods.randomNum(60,120),currentExercise.getRandomTricepExercise());
	int newWeight = (int)((exercise.getArms().getWeight() * bench)) ;
	exercise.setWeight(newWeight);
	//System.out.println(exercise1.getCurrentExercise().getName());
	int newReps = 0;
	if(exercise.getArms().getWeight() >.55) {
		newReps = 10;
	}
	else if(exercise.getArms().getWeight() >.8) {
		newReps = 5;
	}
	else {
		newReps = 12;
	}
	exercise.setRepetitions(newReps);
	exercise.setRest(calculateRest(exercise.getWeight()));
	return exercise;
}

public Hypertrophy buildShoulderUpper(int bench) {
	WorkoutController methods = new WorkoutController();
	Hypertrophy exercise = new Hypertrophy(777,methods.randomNum(2,3),777,methods.randomNum(60,120),currentExercise.getRandomShoulderExercise());
	int newWeight = (int)((exercise.getArms().getWeight() * bench));
	exercise.setWeight(newWeight);
	//System.out.println(exercise1.getCurrentExercise().getName());
	int newReps = 0;
	if(exercise.getArms().getWeight() >.55) {
		newReps = 10;
	}
	else if(exercise.getArms().getWeight() >.8) {
		newReps = 5;
	}
	else {
		newReps = 12;
	}
	exercise.setRepetitions(newReps);
	exercise.setRest(calculateRest(exercise.getWeight()));
	return exercise;
}

public Hypertrophy buildHamstringLower(int deadlift) {
	WorkoutController methods = new WorkoutController();
	Hypertrophy exercise = new Hypertrophy(777,methods.randomNum(2,3),777,methods.randomNum(60,120),currentExercisel.getRandomHamstringExercise());
	int newWeight = (int)((exercise.getLegs().getWeight() * deadlift));
	exercise.setWeight(newWeight);
	//System.out.println(exercise1.getCurrentExercise().getName());
	int newReps = 0;
	if(exercise.getLegs().getWeight() >.55) {
		newReps = 10;
	}
	else if(exercise.getLegs().getWeight() >.8) {
		newReps = 5;
	}
	else {
		newReps = 12;
	}
	exercise.setRepetitions(newReps);
	exercise.setRest(calculateRest(exercise.getWeight()));
	return exercise;
}

public Hypertrophy buildGluteLower(int deadlift) {
	WorkoutController methods = new WorkoutController();
	Hypertrophy exercise = new Hypertrophy(777,methods.randomNum(2,3),777,methods.randomNum(60,120),currentExercisel.getRandomGluteExercise());
	int newWeight = (int)((exercise.getLegs().getWeight() * deadlift));
	exercise.setWeight(newWeight);
	//System.out.println(exercise1.getCurrentExercise().getName());
	int newReps = 0;
	if(exercise.getLegs().getWeight() >.55) {
		newReps = 10;
	}
	else if(exercise.getLegs().getWeight() >.8) {
		newReps = 5;
	}
	else {
		newReps = 12;
	}
	exercise.setRepetitions(newReps);
	exercise.setRest(calculateRest(exercise.getWeight()));
	return exercise;
}

public Hypertrophy buildQuadLower(int squat) {
	WorkoutController methods = new WorkoutController();
	Hypertrophy exercise = new Hypertrophy(777,methods.randomNum(2,3),777,methods.randomNum(60,120),currentExercisel.getRandomQuadExercise());
	int newWeight = (int)((exercise.getLegs().getWeight() * squat)) ;
	exercise.setWeight(newWeight);
	//System.out.println(exercise1.getCurrentExercise().getName());
	int newReps = 0;
	if(exercise.getLegs().getWeight() >.55) {
		newReps = 10;
	}
	else if(exercise.getLegs().getWeight() >.8) {
		newReps = 5;
	}
	else {
		newReps = 12;
	}
	exercise.setRepetitions(newReps);
	exercise.setRest(calculateRest(exercise.getWeight()));
	return exercise;
}

public Hypertrophy buildCalfLower(int squat) {
	WorkoutController methods = new WorkoutController();
	Hypertrophy exercise = new Hypertrophy(777,methods.randomNum(2,3),777,methods.randomNum(60,120),currentExercisel.getRandomCalfExercise());
	int newWeight = (int)((exercise.getLegs().getWeight() * squat)) ;
	exercise.setWeight(newWeight);
	//System.out.println(exercise1.getCurrentExercise().getName());
	int newReps = 0;
	if(exercise.getLegs().getWeight() >.55) {
		newReps = 10;
	}
	else if(exercise.getLegs().getWeight() >.8) {
		newReps = 5;
	}
	else {
		newReps = 12;
	}
	exercise.setRepetitions(newReps);
	exercise.setRest(calculateRest(exercise.getWeight()));
	return exercise;
}

public int calculateRest(double weight) {
	int restTime = 0;
	if(weight > .0) {
		restTime = 50;
	}
	else if(weight > .5) {
		restTime = 80;
	}
	else if (weight > .9) {
		restTime = 100;
	}
	else if(weight > 1.2) {
		restTime = 120;
	}
	//System.out.println(restTime);
	return restTime;
}

public int exerciseTimeFrame(int minutes) {
	int numExercises = minutes % 8;
	return numExercises;
}
}
