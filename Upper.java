//Author: Grant Stevens
//Last Updated: Dec 12,2021
//Methods:+buildChest, +buildShoulders, +buildTriceps, +buildBack, +buildBiceps, +getRandomChestExercise, 
//+getRandomTricepExercise, +getRandomShoulderExercise, +getRandomBackExercise, +getRandomBicepExericse
//Attributes:
//
//Purpose:Contains Arraylist of common upper body muscles worked and their weight compared to the athletes max. Also returns
//a random exercise from any list.
//
import java.util.ArrayList;
public class Upper {
private ArrayList<Upper> chest = new ArrayList<Upper>();
private ArrayList<Upper> shoulders = new ArrayList<Upper>();
private ArrayList<Upper> triceps = new ArrayList<Upper>();
private ArrayList<Upper> back = new ArrayList<Upper>();
private ArrayList<Upper> biceps = new ArrayList<Upper>();
private String exerciseName = "";
private double weightScale = 0;


Upper(String name, double weightMultiplyer){
	exerciseName = name; 
	weightScale = weightMultiplyer; // for 10 reps 
}

Upper(){
	//this is intentionally left empty
}
public void buildChest() {
	Upper cableflys = new Upper("Cable Flys", 0.2);
	Upper landmine = new Upper("Landmine Press", 0.6);
	Upper chestpress = new Upper("Chest Press", 0.53);
	Upper incline = new Upper("Incline Bench", 0.63);
	Upper dumbellpress = new Upper("Dumbell Press", 0.67);
	chest.add(cableflys);
	chest.add(landmine);
	chest.add(chestpress);
	chest.add(incline);
	chest.add(dumbellpress);
	
}//change return type

public void buildShoulders() {
	Upper arnold = new Upper("Arnold Press", 0.4);
	Upper shoulderpress = new Upper("Shoudler Press", 0.46);
	Upper frontr = new Upper("Front Raise", 0.3);
	Upper pushpress = new Upper("Push Press", 0.67);
	shoulders.add(arnold);
	shoulders.add(shoulderpress);
	shoulders.add(frontr);
	shoulders.add(pushpress);
	
}

public void buildTriceps() {
	Upper singledumbellextension = new Upper("Single Hand Dumbell Extension", 0.1);
	Upper pulldown = new Upper("Cable Tricep Pulldown", 0.30);
	Upper cableextension = new Upper("Cable Tricep Extension", 0.20);
	Upper dips = new Upper("Dips", 1);
	Upper dumbellxtension = new Upper("Dumbell Extension", 0.20);
	Upper closebench = new Upper("Close grip Bench", 0.67);
	triceps.add(singledumbellextension);
	triceps.add(pulldown);
	triceps.add(cableextension);
	triceps.add(dips);
	triceps.add(dumbellxtension);
	triceps.add(closebench);
	
}

public void buildBack() {
	Upper uprightrow = new Upper("Upright Row", .51);
	Upper frontlatraise = new Upper("Front Lateral Raise", .26);
	Upper sidelatraise = new Upper("Side Lateral Raise", .1);
	Upper bentoverrow = new Upper("Bent Over Row", .6);
	Upper landminerow = new Upper("Landmine Row", .4);
	Upper pullups = new Upper("Pull-Ups", 1);
	Upper latpulldown = new Upper("Lat Pulldown", .8);
	Upper dumbellrow = new Upper("Dumbell Row", .4);
	back.add(uprightrow);
	back.add(frontlatraise);
	back.add(sidelatraise);
	back.add(bentoverrow);
	back.add(landminerow);
	back.add(pullups);
	back.add(latpulldown);
	back.add(dumbellrow);
	
}

public void buildBiceps() {
	Upper supcurl = new Upper("Supinated Curls",.4);
	Upper hammercurl = new Upper("Hammer Curls",.3);
	Upper preachcuel = new Upper("Preacher Curls", .3);
	Upper barbcurl = new Upper("Barbell Curls",.43);
	biceps.add(supcurl);
	biceps.add(hammercurl);
	biceps.add(preachcuel);
	biceps.add(barbcurl);
	
}

public String getName() {
	return exerciseName;
}
public double getWeight() {
	return weightScale;
}

public void setWeight(double x) {
	weightScale = x;
}
/*
public void convert() {
	double conversionFactor = 2.205;
	for(int i = 0; i < chest.size(); i++) {
		chest.get(i).setWeight(chest.get(i).getWeight() / conversionFactor);
		System.out.println("CALLED" + chest.get(i));
	}
	for(int i = 0; i < shoulders.size(); i++) {
		shoulders.get(i).setWeight(shoulders.get(i).getWeight() / conversionFactor);
	}
	for(int i = 0; i < triceps.size(); i++) {
		triceps.get(i).setWeight(triceps.get(i).getWeight() / conversionFactor);
	}
	for(int i = 0; i < back.size(); i++) {
		back.get(i).setWeight(back.get(i).getWeight() / conversionFactor);
	}
	for(int i = 0; i < biceps.size(); i++) {
		biceps.get(i).setWeight(biceps.get(i).getWeight() / conversionFactor);
	}
	
}
*/
public Upper getRandomChestExercise() {
	WorkoutController randomMethod = new WorkoutController();

	buildChest();
	int x = randomMethod.randomNum(0,4);
	return chest.get(x);
}
public Upper getRandomTricepExercise() {
	WorkoutController randomMethod = new WorkoutController();

	buildTriceps();
	int x = randomMethod.randomNum(0,5);
	return triceps.get(x);
}
public Upper getRandomShoulderExercise() {
	WorkoutController randomMethod = new WorkoutController();

	buildShoulders();
	int x = randomMethod.randomNum(0,3);
	return shoulders.get(x);
}
public Upper getRandomBackExercise() {
	WorkoutController randomMethod = new WorkoutController();

	buildBack();
	int x = randomMethod.randomNum(0,5);
	return back.get(x);
}
public Upper getRandomBicepExercise() {
	WorkoutController randomMethod = new WorkoutController();

	buildBiceps();
	int x = randomMethod.randomNum(0,3);
	return biceps.get(x);
}
}
