//Author: Grant Stevens
//Last Updated: Dec 12,2021
//Methods: +dayPlanPl, +dayPlanHy, + exportToWorkoutController
//Attributes: -wrkCont, -hypertrophy, -powerlifting
//
//Purpose: This class contains the arraylists of each sessions per day as merges all workout information to one
//arraylist.
//
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class WorkoutPlan {
	private ArrayList<ArrayList<Hypertrophy>> hypertrophy = new ArrayList<ArrayList<Hypertrophy>>();
	private ArrayList<ArrayList<PowerLifting>> powerlifting = new ArrayList<ArrayList<PowerLifting>>();
	private WorkoutController wrkCont = new WorkoutController();
	

public void dayPlanPl(ArrayList<PowerLifting> session, String str) throws IOException {
	
	//powerlifting.add(session);
	//making file input/ output in controller
	if(str.equals("A")) {
	if((session.get(0).getCurrentExercise().getClass()).equals(Upper.class)) {
		for(int i = 0; i < session.size(); i++) {
			System.out.println(session.get(i).getCurrentExercise().getName() + " " + session.get(i).getWeight() + " " + session.get(i).getRepetitions());
			
		}
		powerlifting.add(session);

		}
	}
	else if(str.equals("L")) {
		for(int i = 0; i < session.size(); i++) {
			System.out.println(session.get(i).getCurrentExercisel().getName() + " " + session.get(i).getWeight() + " " + session.get(i).getRepetitions());
			
		}
		powerlifting.add(session);

	}
	
//System.out.println(powerlifting.size());
}

public void exportToWorkoutController(String type) throws IOException {
	//System.out.println("exporttocontroller called");
	if(type.equalsIgnoreCase("pl")) {
	int days = powerlifting.size();
	wrkCont.setRoutine(wrkCont.findRoutine(days));
	wrkCont.exportPowerLiftingWorkout(powerlifting);
	}
	else if(type.equalsIgnoreCase("hy")) {
		int days = hypertrophy.size();
		wrkCont.setRoutine(wrkCont.findRoutine(days));
		wrkCont.exportHypertrophyWorkout(hypertrophy);
	}
	//System.out.println(powerlifting.get(1).get(0).getCurrentExercisel().getName());
}


public void dayPlanHy(ArrayList<Hypertrophy> session, String str) throws IOException {
	
	if(str.equals("A")) {
		if((session.get(0).getCurrentExercise().getClass()).equals(Upper.class)) {
			for(int i = 0; i < session.size(); i++) {
				System.out.println(session.get(i).getCurrentExercise().getName() + " " + session.get(i).getWeight() + " " + session.get(i).getRepetitions());
				
			}
			hypertrophy.add(session);

			}
		}
	else if(str.equals("L")) {
			for(int j = 0; j < session.size(); j++) {
				System.out.println(session.get(j).getCurrentExercisel().getName() + " " + session.get(j).getWeight() + " " + session.get(j).getRepetitions());
				//System.out.println("Echo");
			}
			hypertrophy.add(session);

		}
}

}

