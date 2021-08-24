package com.bludots.assignments.Atleet;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.bludots.assignments.Atleet.Atleet.Sport;

public class AtletenServices {
	
	public void zwemmers(ArrayList<Atleet> sporters) {
		List<Atleet> zwemmers = new ArrayList<Atleet>();
		for(int i = 0; i <= sporters.size()-1; i++) {
			Atleet atleet = sporters.get(i);
			if(atleet.getSport().equals(Sport.ZWEMMEN)) {
				zwemmers.add(atleet);
			}
		}
		System.err.println("De zwemmers zijn: ");
		System.out.println(zwemmers.toString());
	}
	
	public void jairDieZwemmersZijn(ArrayList<Atleet> sporters) {
		List<Atleet> jair_zwemmers = new ArrayList<Atleet>();
		for(int i = 0; i <= sporters.size()-1; i++) {
			Atleet atleet = sporters.get(i);
			if((atleet.getSport().equals(Sport.ZWEMMEN)) && atleet.getVoorNaam().equals("Jair")) {
				jair_zwemmers.add(atleet);
			}
		}
		System.err.println("De zwemmers die Jair heten zijn: ");
		System.out.println(jair_zwemmers.toString());
	}
	
	public void sportersOnder20(ArrayList<Atleet> sporters) {
		List<Atleet> atleten_jonger_dan_20 = new ArrayList<Atleet>();
		for(int i = 0; i <= sporters.size()-1; i++) {
			Atleet atleet = sporters.get(i);
			if(atleet.getAge() < 20) {
				atleten_jonger_dan_20.add(atleet);
			}
		}
		System.err.println("De atleten jonger dan 20 zijn: ");
		System.out.println(atleten_jonger_dan_20.toString());
	}
	
	public void sportersTussenData(ArrayList<Atleet> sporters, int beginYear, int endYear) {
		System.out.println("Sporters tussen "+beginYear+" & "+endYear+" zijn:");
		for(int i = 0; i < sporters.size(); i++) {
			if(sporters.get(i).getGeboorteDatum().getYear() >= beginYear &&
					sporters.get(i).getGeboorteDatum().getYear() <= endYear){
				System.out.println("Naam: "+sporters.get(i).getVoorNaam()+" "+sporters.get(i).getAchterNaam()+" geboren in: "+sporters.get(i).getGeboorteDatum());
			}
		}
	}
	
	public void individueleSpelers(ArrayList<Atleet> sporters) {
		System.out.println("Individuele sporters zijn:");
		for(int i = 0; i < sporters.size(); i++) {
			if(sporters.get(i).getSport().isIndividueel()) {
				System.out.println("Name: "+sporters.get(i).getVoorNaam()+" "+sporters.get(i).getAchterNaam()+ " Sport: "+sporters.get(i).getSport().toString());
			}
		}
	}
	
	public void totalTeamSportsman(ArrayList<Atleet> sporters) {
		int aantalTeamSporters = 0;
		for(int i = 0; i < sporters.size(); i++) {
			if(!sporters.get(i).getSport().isIndividueel()) {
				aantalTeamSporters++;
			}
		}
		System.out.println("Aantal sporters die team verband zijn: " + aantalTeamSporters + " spelers.");
	}
	
	public void sportmenBornInMarch(ArrayList<Atleet> sporters) {
		int marchBornPlayers = 0;
		for(int i = 0; i < sporters.size(); i++) {
			if(sporters.get(i).getGeboorteDatum().getMonthValue() == 3) {
				marchBornPlayers++;
			}
		}
		System.out.println("Aantal spelers geboren in maart: " + marchBornPlayers);
	}
	
	public void sportersTussen2000En2002(ArrayList<Atleet> sporters) {
		int playersBetween2000En2002 = 0;
		for(int i = 0; i < sporters.size(); i++) {
			if(sporters.get(i).getGeboorteDatum().getYear() >= 2000 &&
					sporters.get(i).getGeboorteDatum().getYear() <= 2002) {
				playersBetween2000En2002++;
			}
		}
		System.out.println("Aantal spelers geboren tussen 2000 en 2002: " + playersBetween2000En2002);
	}
	
	public void europeseDatum(ArrayList<Atleet> sporters, String naam) {
		for(int i = 0; i < sporters.size(); i++) {
			int year = 0;
			String month = null;
			int day = 0;
			if(sporters.get(i).getVoorNaam().equals(naam)) {
				year = sporters.get(i).getGeboorteDatum().getYear();
				month = sporters.get(i).getGeboorteDatum().getMonth().toString();
			    day = sporters.get(i).getGeboorteDatum().getDayOfMonth();
			    System.out.println("Name: " +sporters.get(i).getVoorNaam()+" "+sporters.get(i).getAchterNaam()+" birthday: " +day+" "+month+" "+year);
			}
		}
	}
}
	

