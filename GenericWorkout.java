//Author: Grant Stevens
//Last Updated: Nov 19,2021
//Methods:+createSession, +createHarderSession, +calculateRest
//Attributes:-currentExercise, -currentExercise, -currentExercisel, -repetitions, -sets, -weight, -rest
//
//Purpose:This is a generic workout meant to be extended by PowerLifting or Hypertrophy. It contains commenly used 
//methods and attributes to create a generic workout.
//
import java.util.ArrayList;
public class GenericWorkout {
private Upper currentExercise = new Upper();
private Lower currentExercisel = new Lower();
private int repetitions = 0;
private int sets = 0;
private int weight = 0;
private int rest = 0;
//public GenericWorkout workoutData = null;

GenericWorkout(){
	//this is intentinally left blank
}

GenericWorkout(int reps, int set, int setRest, int repWeight, Upper arm) {
	repetitions = reps;
	sets = set;
	weight = repWeight;
	rest = setRest;
	currentExercise = arm;
}

GenericWorkout(int reps, int set, int setRest, int repWeight, Lower leg) {
	repetitions = reps;
	sets = set;
	weight = repWeight;
	rest = setRest;
	currentExercisel = leg;
}

public ArrayList<GenericWorkout> createSession() {
	return null;
}

public ArrayList<GenericWorkout> createHarderSession(){
	return null;
}

public int calculateRest() {
	return 0;
}


public Upper getCurrentExercise() {
	return currentExercise;
}

public void setCurrentExercise(Upper currentExercise) {
	this.currentExercise = currentExercise;
}

public Lower getCurrentExercisel() {
	return currentExercisel;
}

public void setCurrentExercisel(Lower currentExercisel) {
	this.currentExercisel = currentExercisel;
}

public int getRepetitions() {
	return repetitions;
}

public void setRepetitions(int repetitions) {
	this.repetitions = repetitions;
}

public int getSets() {
	return sets;
}

public void setSets(int sets) {
	this.sets = sets;
}

public int getWeight() {
	return weight;
}

public void setWeight(int weight) {
	this.weight = weight;
}

public int getRest() {
	return rest;
}

public void setRest(int rest) {
	this.rest = rest;
}
public Upper getArms() {
	return currentExercise;
}

public Lower getLegs() {
	return currentExercisel;
}
}
