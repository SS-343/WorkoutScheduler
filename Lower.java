//Author: Grant Stevens
//Last Updated: Dec 3,2021
//Methods:
//Attributes:+buildHamstrings, +buildCalves, +buildQuads, +buildGlutes, +getRandomHamstringExercise, +getRandomCalfExercise,
//+getRandomQuadExercise, +getRandomGluteExercise
//
//Purpose: Contains Arraylist of common leg muscles worked and their weight compared to the athletes max. Also returns
//a random exercise from any list.
//
import java.util.ArrayList;
public class Lower {
	private ArrayList<Lower> hamstrings = new ArrayList<Lower>();
	private ArrayList<Lower> glutes = new ArrayList<Lower>();
	private ArrayList<Lower> quads = new ArrayList<Lower>();
	private ArrayList<Lower> calves = new ArrayList<Lower>();
	private String exerciseName = "";
	private double weightScale = 0;
	
	Lower(){
		//this is intentionally left blank
	}


	Lower(String name, double weightMultiplyer){
		exerciseName = name; 
		weightScale = weightMultiplyer; // for 10 reps 
	}
public void buildHamstrings() {//based off deadlifts
	Lower roamandead = new Lower("Romanian Deadlifts", .55);
	Lower goodmorning = new Lower("Good Mornings", .32);
	Lower lyinglegcurl = new Lower("Lying Leg Curls", .51);
	Lower sittinglegcurl = new Lower("Sitting Leg Curls", .51);
	Lower singlelegcurl = new Lower("Single Leg Curl", .25);
	hamstrings.add(roamandead);
	hamstrings.add(goodmorning);
	hamstrings.add(lyinglegcurl);
	hamstrings.add(sittinglegcurl);
	hamstrings.add(singlelegcurl);
	
}

public void buildGlutes() {//based off deadlifts
	Lower glutehamraise = new Lower("Glute-Ham Raise", .5);
	Lower hipthrust = new Lower("Hip Thrust", 1);
	Lower hipabd = new Lower("Hip Abduction", .32);
	Lower hipadd = new Lower("Hip Adduction", .32);
	glutes.add(glutehamraise);
	glutes.add(hipthrust);
	glutes.add(hipabd);
	glutes.add(hipadd);
	
}

public void buildQuads() {//based off squats
	Lower frontsquat = new Lower("Front Squat", .6);
	Lower weightedlunge = new Lower("Weighted Lunge", .26);
	Lower hacksquat = new Lower("Hack Squat", .7);
	Lower stepups = new Lower("Step-Ups", .6);
	Lower splitsquat = new Lower("Bulgerian Split Squats", .26);
	Lower legpress = new Lower("Leg Press", 1.2);
	Lower gobletsquat = new Lower("Goblet Squat", .31);
	quads.add(frontsquat);
	quads.add(weightedlunge);
	quads.add(hacksquat);
	quads.add(stepups);
	quads.add(splitsquat);
	quads.add(legpress);
	quads.add(gobletsquat);
	
}

public void buildCalves() {//based off squats
	Lower machcalfraise = new Lower("Machine Calf Raise", .24);
	Lower barbcalfraise = new Lower("Barbell Calf Raise", .6);
	calves.add(barbcalfraise);
	calves.add(machcalfraise);
	
}

public Lower getRandomHamstringExercise() {
	WorkoutController randomMethod = new WorkoutController();

	buildHamstrings();
	int x = randomMethod.randomNum(0,4);
	return hamstrings.get(x);
}

public Lower getRandomQuadExercise() {
	WorkoutController randomMethod = new WorkoutController();

	buildQuads();
	int x = randomMethod.randomNum(0,6);
	return quads.get(x);
}

public Lower getRandomGluteExercise() {
	WorkoutController randomMethod = new WorkoutController();

	buildGlutes();
	int x = randomMethod.randomNum(0,3);
	return glutes.get(x);
}

public Lower getRandomCalfExercise() {
	WorkoutController randomMethod = new WorkoutController();

	buildCalves();
	int x = randomMethod.randomNum(0,1);
	return calves.get(x);
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

public void convert() {
	System.out.println("Convert Called");//fix converison
	double conversionFactor = 2.205;
	for(int i = 0; i < quads.size(); i++) {
		quads.get(i).setWeight(quads.get(i).getWeight() / conversionFactor);
	}
	for(int i = 0; i < hamstrings.size(); i++) {
		hamstrings.get(i).setWeight(hamstrings.get(i).getWeight() / conversionFactor);
	}
	for(int i = 0; i < calves.size(); i++) {
		calves.get(i).setWeight(calves.get(i).getWeight() / conversionFactor);
	}
	for(int i = 0; i < glutes.size(); i++) {
		glutes.get(i).setWeight(glutes.get(i).getWeight() / conversionFactor);
	}
	
}
}
