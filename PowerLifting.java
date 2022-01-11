//Author: Grant Stevens
//Last Updated: Dec 12,2021
//Methods:+createSession, +buildChestBench, +buildShoulderBench, +buildTricepBench,
//+buildBackBench, +buildBicepBench, +buildHamstringDeadlift, +buildGluteDeadlift, +buildCalfSquat, +buildQuadSquat, 
//+calculateRest, +exerciseTimeFrame
//Attributes:-currentExercise, -currentExercisel
//
//Purpose:Builds an Powerlifting object using an Upper/Lower as a base and accounts for a Powerlifting type workout decision. 
//
import java.util.ArrayList;

public class PowerLifting extends GenericWorkout{
private Upper currentExercise = new Upper();
private Lower currentExercisel = new Lower();
PowerLifting(){}


PowerLifting(int reps, int set, int repWeight, int setRest, Upper arm){
	super(reps,set,repWeight,setRest,arm);
}

PowerLifting(int reps, int set, int repWeight, int setRest, Lower leg){
	super(reps,set,repWeight,setRest,leg);
}

public ArrayList<PowerLifting> createSession(int squat, int bench, int deadlift, int sessionTime, String dayType) {
//reps, int set, int repWeight, int setRest, Upper arm){
	int numExercise = exerciseTimeFrame(sessionTime);
	ArrayList<PowerLifting> session = new ArrayList<PowerLifting>();
	if(dayType == "bench") {
		
			session.add(buildChestBench(bench));
			session.add(buildTricepBench(bench));
		if(numExercise > 2) {
			session.add(buildShoulderBench(bench));
		}
		if(numExercise > 3) {
			session.add(buildChestBench(bench));
			session.add(buildTricepBench(bench));
			session.add(buildShoulderBench(bench));
		}
	}
	else if (dayType == "squat") {
			session.add(buildQuadSquat(squat));
			session.add(buildCalfSquat(squat));
		if(numExercise > 2) {
			session.add(buildQuadSquat(squat));
		}
		if(numExercise > 3) {
			session.add(buildCalfSquat(squat));
		}
		
	}
	else if(dayType == "deadlift") {
			session.add(buildHamstringDeadlift(deadlift));
			session.add(buildGluteDeadlift(deadlift));
		if(numExercise > 2) {
			session.add(buildHamstringDeadlift(deadlift));
		}
		if(numExercise > 3) {
			session.add(buildGluteDeadlift(deadlift));
		}
	}
	else if(dayType == "benchBack") {
		session.add(buildBackBench(bench));
		session.add(buildBackBench(bench));
		if(numExercise > 2) {
			session.add(buildBicepBench(bench));
		}
		if(numExercise > 3) {
		session.add(buildBicepBench(bench));
		session.add(buildBicepBench(bench));
		}
		
	}
	else {
		System.out.println("Invalid dayType in powerlift creation");
	}
	return session;
		
}

public PowerLifting buildChestBench(int bench) {
	WorkoutController methods = new WorkoutController();
	PowerLifting exercise = new PowerLifting(777,methods.randomNum(2,3),777,methods.randomNum(60,120),currentExercise.getRandomChestExercise());
	int newWeight = (int)(((exercise.getArms().getWeight() * bench)) + .05 * bench);
	exercise.setWeight(newWeight);
	//System.out.println(exercise1.getCurrentExercise().getName());
	int newReps = 0;
	if(exercise.getArms().getWeight() >.59) {
		newReps = 5;
	}
	else if(exercise.getArms().getWeight() >.9) {
		newReps = 3;
	}
	else {
		newReps = 7;
	}
	exercise.setRepetitions(newReps);
	exercise.setRest(calculateRest(exercise.getWeight()));
	return exercise;
}

public PowerLifting buildTricepBench(int bench) {
	WorkoutController methods = new WorkoutController();
	PowerLifting exercise = new PowerLifting(777,methods.randomNum(2,3),777,methods.randomNum(60,120),currentExercise.getRandomTricepExercise());
	int newWeight = (int)(((exercise.getArms().getWeight() * bench)) + .05 * bench);
	exercise.setWeight(newWeight);
	//System.out.println(exercise1.getCurrentExercise().getName());
	int newReps = 0;
	if(exercise.getArms().getWeight() >.59) {
		newReps = 8;
	}
	else if(exercise.getArms().getWeight() >.9) {
		newReps = 3;
	}
	else {
		newReps = 10;
	}
	exercise.setRepetitions(newReps);
	exercise.setRest(calculateRest(exercise.getWeight()));
	return exercise;
}

public PowerLifting buildShoulderBench(int bench) {
	WorkoutController methods = new WorkoutController();
	PowerLifting exercise = new PowerLifting(777,methods.randomNum(2,3),777,methods.randomNum(60,120),currentExercise.getRandomShoulderExercise());
	int newWeight = (int)(((exercise.getArms().getWeight() * bench)) + .05 * bench);
	exercise.setWeight(newWeight);
	//System.out.println(exercise1.getCurrentExercise().getName());
	int newReps = 0;
	if(exercise.getArms().getWeight() >.59) {
		newReps = 8;
	}
	else if(exercise.getArms().getWeight() >.9) {
		newReps = 3;
	}
	else {
		newReps = 10;
	}
	exercise.setRepetitions(newReps);
	exercise.setRest(calculateRest(exercise.getWeight()));
	return exercise;
}

public PowerLifting buildBackBench(int bench) {
	WorkoutController methods = new WorkoutController();
	PowerLifting exercise = new PowerLifting(777,methods.randomNum(2,3),777,methods.randomNum(60,120),currentExercise.getRandomBackExercise());
	int newWeight = (int)(((exercise.getArms().getWeight() * bench)) + .05 * bench);
	exercise.setWeight(newWeight);
	//System.out.println(exercise1.getCurrentExercise().getName());
	int newReps = 0;
	if(exercise.getArms().getWeight() >.59) {
		newReps = 8;
	}
	else if(exercise.getArms().getWeight() >.9) {
		newReps = 3;
	}
	else {
		newReps = 10;
	}
	exercise.setRepetitions(newReps);
	exercise.setRest(calculateRest(exercise.getWeight()));
	return exercise;
}

public PowerLifting buildBicepBench(int bench) {
	WorkoutController methods = new WorkoutController();
	PowerLifting exercise = new PowerLifting(777,methods.randomNum(2,3),777,methods.randomNum(60,120),currentExercise.getRandomBicepExercise());
	int newWeight = (int)(((exercise.getArms().getWeight() * bench)) + .05 * bench);
	exercise.setWeight(newWeight);
	//System.out.println(exercise1.getCurrentExercise().getName());
	int newReps = 0;
	if(exercise.getArms().getWeight() >.59) {
		newReps = 8;
	}
	else if(exercise.getArms().getWeight() >.9) {
		newReps = 3;
	}
	else {
		newReps = 10;
	}
	exercise.setRepetitions(newReps);
	exercise.setRest(calculateRest(exercise.getWeight()));
	return exercise;
}

public PowerLifting buildHamstringDeadlift(int deadlift) {
	WorkoutController methods = new WorkoutController();
	PowerLifting exercise = new PowerLifting(777,methods.randomNum(2,3),777,methods.randomNum(60,120),currentExercisel.getRandomHamstringExercise());
	int newWeight = (int)(((exercise.getLegs().getWeight() * deadlift)) + .05 * deadlift);
	exercise.setWeight(newWeight);
	//System.out.println(exercise1.getCurrentExercise().getName());
	int newReps = 0;
	if(exercise.getLegs().getWeight() >.59) {
		newReps = 8;
	}
	else if(exercise.getLegs().getWeight() >.9) {
		newReps = 3;
	}
	else {
		newReps = 10;
	}
	exercise.setRepetitions(newReps);
	exercise.setRest(calculateRest(exercise.getWeight()));
	return exercise;
}

public PowerLifting buildGluteDeadlift(int deadlift) {
	WorkoutController methods = new WorkoutController();
	PowerLifting exercise = new PowerLifting(777,methods.randomNum(2,3),777,methods.randomNum(60,120),currentExercisel.getRandomGluteExercise());
	int newWeight = (int)(((exercise.getLegs().getWeight() * deadlift)) + .05 * deadlift);
	exercise.setWeight(newWeight);
	//System.out.println(exercise1.getCurrentExercise().getName());
	int newReps = 0;
	if(exercise.getLegs().getWeight() >.59) {
		newReps = 8;
	}
	else if(exercise.getLegs().getWeight() >.9) {
		newReps = 3;
	}
	else {
		newReps = 10;
	}
	exercise.setRepetitions(newReps);
	exercise.setRest(calculateRest(exercise.getWeight()));
	return exercise;
}

public PowerLifting buildQuadSquat(int squat) {
	WorkoutController methods = new WorkoutController();
	PowerLifting exercise = new PowerLifting(777,methods.randomNum(2,3),777,methods.randomNum(60,120),currentExercisel.getRandomQuadExercise());
	int newWeight = (int)(((exercise.getLegs().getWeight() * squat)) + .05 * squat);
	exercise.setWeight(newWeight);
	//System.out.println(exercise1.getCurrentExercise().getName());
	int newReps = 0;
	if(exercise.getLegs().getWeight() >.59) {
		newReps = 8;
	}
	else if(exercise.getLegs().getWeight() >.9) {
		newReps = 3;
	}
	else {
		newReps = 10;
	}
	exercise.setRepetitions(newReps);
	exercise.setRest(calculateRest(exercise.getWeight()));
	return exercise;
}

public PowerLifting buildCalfSquat(int squat) {
	WorkoutController methods = new WorkoutController();
	PowerLifting exercise = new PowerLifting(777,methods.randomNum(2,3),777,methods.randomNum(60,120),currentExercisel.getRandomCalfExercise());
	int newWeight = (int)(((exercise.getLegs().getWeight() * squat)) + .05 * squat);
	exercise.setWeight(newWeight);
	//System.out.println(exercise1.getCurrentExercise().getName());
	int newReps = 0;
	if(exercise.getLegs().getWeight() >.59) {
		newReps = 8;
	}
	else if(exercise.getLegs().getWeight() >.9) {
		newReps = 3;
	}
	else {
		newReps = 10;
	}
	exercise.setRepetitions(newReps);
	exercise.setRest(calculateRest(exercise.getWeight()));
	return exercise;
}


public int calculateRest(double weight) {//calculate rest
	int restTime = 0;
	if(weight > .0) {
		restTime = 60;
	}
	else if(weight > .5) {
		restTime = 90;
	}
	else if (weight > .9) {
		restTime = 120;
	}
	else if(weight > 1.2) {
		restTime = 180;
	}
	//System.out.println(restTime);
	return restTime;
}

public int exerciseTimeFrame(int minutes) {
	int numExercises = minutes % 12;
	return numExercises;
}


}