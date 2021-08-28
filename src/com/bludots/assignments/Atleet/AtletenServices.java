package com.bludots.assignments.Atleet;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import com.bludots.assignments.Atleet.Atleet.Sport;

public class AtletenServices {
	
	public void displayZwemmers(ArrayList<Atleet> sporters) {
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
		for(Atleet atleet: sporters) {
			if((atleet.getSport().equals(Sport.ZWEMMEN)) && atleet.getVoorNaam().equals("Jair")) {
				jair_zwemmers.add(atleet);
			}
		}
		System.err.println("De zwemmers die Jair heten zijn: ");
		System.out.println(jair_zwemmers.toString());
	}
	
	public void sportersOnder20(ArrayList<Atleet> sporters) {
		List<Atleet> atleten_jonger_dan_20 = new ArrayList<Atleet>();
		for(Atleet atleet:sporters) {
			if(atleet.getAge() < 20) {
				atleten_jonger_dan_20.add(atleet);
			}
		}
		System.err.println("De atleten jonger dan 20 zijn: ");
		System.out.println(atleten_jonger_dan_20.toString());
	}
	
	public void sportersTussenData(ArrayList<Atleet> sporters, int beginYear, int endYear) {
		System.out.println("Sporters tussen "+beginYear+" & "+endYear+" zijn:");
		for(Atleet atleet: sporters) {
			if(atleet.getGeboorteDatum().getYear() >= beginYear &&
					atleet.getGeboorteDatum().getYear() <= endYear){
				System.out.println("Naam: "+atleet.getVoorNaam()+" "+atleet.getAchterNaam()+" geboren in: "+atleet.getGeboorteDatum());
			}
		}
	}
	
	public void individueleSpelers(ArrayList<Atleet> sporters) {
		System.out.println("Individuele sporters zijn:");
		for(Atleet atleet: sporters) {
			if(atleet.getSport().isIndividueel()) {
				System.out.println("Name: "+atleet.getVoorNaam()+" "+atleet.getAchterNaam()+ " Sport: "+atleet.getSport().toString());
			}
		}
	}
	
	public void totalTeamSportsman(ArrayList<Atleet> sporters) {
		int aantalTeamSporters = 0;
		for(Atleet atleet: sporters) {
			if(!atleet.getSport().isIndividueel()) {
				aantalTeamSporters++;
			}
		}
		System.out.println("Aantal sporters die team verband zijn: " + aantalTeamSporters + " spelers.");
	}
	
	public void sportmenBornInMarch(ArrayList<Atleet> sporters) {
		int marchBornPlayers = 0;
		for(Atleet atleet: sporters) {
			if(atleet.getGeboorteDatum().getMonth().equals(Month.MARCH)) {
				marchBornPlayers++;
			}
		}
		sporters.forEach(atleet -> {
			if (atleet.getGeboorteDatum().getMonth().equals(Month.MARCH)) {
				System.out.println("Atleet: " + atleet.getVoorNaam());
			}
		});
		System.out.println("Aantal spelers geboren in maart: " + marchBornPlayers);
	}
	
	public void sportersTussen2000En2002(ArrayList<Atleet> sporters) {
		int playersBetween2000En2002 = 0;
		for(Atleet atleet: sporters) {
			if(atleet.getGeboorteDatum().getYear() >= 2000 &&
					atleet.getGeboorteDatum().getYear() <= 2002) {
				playersBetween2000En2002++;
			}
		}
		System.out.println("Aantal spelers geboren tussen 2000 en 2002: " + playersBetween2000En2002);
	}
	
	public void europeseDatum(ArrayList<Atleet> sporters, String naam) {
		for(Atleet atleet: sporters) {
			int year = 0;
			String month = null;
			int day = 0;
			if(atleet.getVoorNaam().equals(naam)) {
				year = atleet.getGeboorteDatum().getYear();
				month = atleet.getGeboorteDatum().getMonth().toString();
			    day = atleet.getGeboorteDatum().getDayOfMonth();
			    System.out.println("Name: " +atleet.getVoorNaam()+" "+atleet.getAchterNaam()+" birthday: " +day+" "+month+" "+year);
			}
		}
	}
	

}
	

