package com.bludots.assignments.Atleet;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.bludots.assignments.Atleet.Atleet.Sport;


public class AtleetManager {
	
	public static ArrayList<Atleet> atletenList = new ArrayList<>();
	
	// zoek naar alle atleten die zwemmen en druk deze dan af
	public static void search(Sport searchSportType) {
		search("", searchSportType);
	}

	// zoek naar alle atleten die jair heten en zwemmen en druk deze dan af. Als firstName null is (negeer deze) 
	public static void search(String firstName, Sport searchSportType) {
		for (int i = 0; i < atletenList.size(); i++) {
			Atleet atleet = atletenList.get(i);
			if (atleet.getSport().equals(searchSportType)) {
				String voornaam = atleet.getVoorNaam();
				if (firstName.equals("") || firstName.equals(voornaam)) {	
					atleet.showAtleet();
				}
			}
		}
	}
	
	//zoek of individueel of team sporters
	//zoek gebaseerd op 1 voor niet individueel
	//zoek gebaseerd op 2 voor individueel
	public static void searchIndividualOrTeam(int j) {
		if(j == 1) {
			System.out.println("Team sporters");
			for(int i = 0; i < atletenList.size(); i++) {
				if(!atletenList.get(i).getSport().isIndividueel()) {
					System.out.println("Name: "+atletenList.get(i).getVoorNaam()+" "+atletenList.get(i).getAchterNaam()+ " Sport: "+atletenList.get(i).getSport().toString());
				} 
			}
		} else if (j == 2) {
			System.out.println("Individuele sporters");
			for(int i = 0; i < atletenList.size(); i++) {
				if(atletenList.get(i).getSport().isIndividueel()) {
					System.out.println("Name: "+atletenList.get(i).getVoorNaam()+" "+atletenList.get(i).getAchterNaam()+ " Sport: "+atletenList.get(i).getSport().toString());
				} 
			}			
		}
		
	}
	
	public static void search(int month) {
		for(int i = 0; i < atletenList.size(); i++) {
			if(atletenList.get(i).getGeboorteDatum().getMonthValue() == month) {
				System.out.println("Name: "+atletenList.get(i).getVoorNaam()+" "+atletenList.get(i).getAchterNaam()+ " Birthday: "+atletenList.get(i).getGeboorteDatum());
			} 
		}
	}
	
	public static void main(String arg[]) {
		
	Atleet atleet1 = new Atleet("Jair", "Tjon en Fa", LocalDate.of(1994, 4, 1), Sport.BAANWIELRENNEN);
	System.out.println("Atleet " + atleet1.getAchterNaam() + " Leeftijd: " + atleet1.getAge());

	
	//Dit voorbeeld is in een ArrayList en houdt alles variable
	AtletenServices atletenServices = new AtletenServices();

	// Assignment 1: Maak een lijst van 50 atleten.
	// Vul ze steeds met andere sporten, dus bijv een aantal boksers, voetballers etc ec
	// Maak deze ook aan met een variabel geboortejaar (tussen 1990-2005))

	fillAtletenArray();
	
//  - zoek naar alle atleten die zwemmen en druk deze dan af
	atletenServices.zwemmers(atletenList);
	
//  - zoek naar alle atleten die jair heten en zwemmen en druk deze dan af
	atletenServices.jairDieZwemmersZijn(atletenList) ;
	
//  (*) zoek naar alle atleten die jonger zijn dan 20 jaar 
	atletenServices.sportersOnder20(atletenList);
	
	System.out.println();

	 // 1) Zorg ervoor dat de geboortedatum willekeurig is tussen 2 data 
	 // bijv atleten moeten geboren zijn tussen 1990 - 2003
	
	atletenServices.sportersTussenData(atletenList, 1997, 2003);
	//--------------------------------------------------------------------
	//--------------------------------------------------------------------
	//--------------------------------------------------------------------
	System.out.println();
	//Het volgende is in een search mogelijk
	//--------------------------------------------------------------------
	 // 2) Zoek naar alle individuele sporters
	atletenServices.individueleSpelers(atletenList);
	
	// 3) Druk af hoeveel teamsporters er in de lijst zitten
	System.out.println();
	atletenServices.totalTeamSportsman(atletenList);
	
	//EASY MANIER VAN DEZE ZOEKEN: uncomment de volgende line en kiez 1 of 2
//	searchIndividualOrTeam(2);
	//--------------------------------------------------------------------
	//--------------------------------------------------------------------

	System.out.println();
	// 4) Druk af hoeveel sporters er zijn die jarig zijn in Maart
	atletenServices.sportmenBornInMarch(atletenList);
	// Het volgende line houdt in het zoeken met een vrijwillige maand
	//uncomment for use
	//search(1);
	
	System.out.println();
	 // 5) Druk af hoeveel sporters er zijn die geboren zijn in 2000-2002
	atletenServices.sportersTussen2000En2002(atletenList);
	
	 // 6) Druk de geboortedatum af in de Europese notatie  1 January 2002  (en niet de Amerikaanse 2002-01-01)
	System.out.println();
	atletenServices.europeseDatum(atletenList, "Jair");
	
	}

	public static void fillAtletenArray() {
		for (int i = 0; i < 50; i++) {
			Random random = new Random();

			String[] voornamen = { "Jair", "Lisa", "Roy", "Bob", "Jenny" };
			int chooseVoornaam = random.nextInt(voornamen.length);

			String[] achternamen = { "ling", "Ben", "Bro", "Lenny", "Rob" };
			int chooseAchternaam = random.nextInt(achternamen.length);

			int chooseSport = random.nextInt(Sport.values().length);

			int maandArray = random.nextInt(12) + 1;	
			int dagArray;
			if(maandArray == 2) {
				dagArray = random.nextInt(28) + 1;				
			} else if(maandArray == 1 || 
					maandArray == 3 ||
					maandArray == 5 || 
					maandArray == 7 || 
					maandArray == 8 || 
					maandArray == 10 || 
					maandArray == 12){
				dagArray = random.nextInt(31) + 1;								
			} else {
				dagArray = random.nextInt(30) + 1;												
			}
			int jaarArray = random.nextInt(2005 - 1990) + 1990;


			Atleet atleet = new Atleet(voornamen[chooseVoornaam], achternamen[chooseAchternaam], 
					LocalDate.of(jaarArray, maandArray, dagArray), Sport.values()[chooseSport]);

			atletenList.add(atleet);

		}
	
	}
	





}
