package com.bludots.assignments.Atleet;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Random;

import com.bludots.assignments.Atleet.Atleet.Sport;

/* 
 *  * Wat verwachten wij van u?
 * - gebruik overall for loops zonder int i = 0; i<x; i++, gebruik nieuwe constructies
 * - gebruik LocalDateTime formatter
 * - minimaliseer het aantal regels code (geen duplicaat code)
 * - gebruik logische functie namen
 * - probeer in 1 functie dingen te combineren, dus als je een 
 *  functie A en B die ongeveer hetzelfde doen, kun je dan een functie C maken
 * - probeer logische taken te isoleren in aparte functie
 * - probeer waar mogelijk a?b:c
 * - probeer zoveel constanten/enumeraties te gebruiken dus
 *   liever Month.MARCH dan 3 of liever VOLWASSSEN dan 18
 */

public class AtleetManager {

	public static ArrayList<Atleet> atletenList = new ArrayList<>();

	// zoek naar alle atleten die zwemmen en druk deze dan af
	public static void search(Sport searchSportType) {
		search("", searchSportType);
	}

	// zoek naar alle atleten die jair heten en zwemmen en druk deze dan af. Als
	// firstName null is (negeer deze)
	public static void search(String firstName, Sport searchSportType) {
		System.out.println("Sporters van " + searchSportType + " die " + firstName + " heten");
		for (Atleet atleet : atletenList) {
			if (atleet.getSport().equals(searchSportType)) {
				String voornaam = atleet.getVoorNaam();
				if (firstName.equals("") || firstName.equals(voornaam)) {
					atleet.showAtleet();
				}
			}
		}
	}

	// zoek of individueel of team sporters
	// zoek gebaseerd op 1 voor niet individueel
	// zoek gebaseerd op 2 voor individueel
	// int leeftijd = 18;
	// String soort = (leeftijd<18) ?"Kind:"Volwassen";
	// String soort = (leeftijd < 18) ? "Kind": leeftijd > 60?"Senior":"volwassen";
	public static void searchIndividualPlayerOrTeamPlayer(boolean zoekIndividueel) {
		String title = zoekIndividueel ? "Individuele sporters" : "Team sporters";
		System.out.println(title);
		int total = 0;
		for (Atleet atleet : atletenList) {
			boolean sportIndividueel = atleet.getSport().isIndividueel();
			if (zoekIndividueel == sportIndividueel) {
				atleet.displayAtleetFullNameAndSport();
				total++;
			}
		}
	}

	public static void searchTotalIndividualPlayersOrTeamPlayers(boolean zoekIndividueel) {
		String title = zoekIndividueel ? "Individuele sporters" : "Team sporters";
		int total = 0;
		for (Atleet atleet : atletenList) {
			boolean sportIndividueel = atleet.getSport().isIndividueel();
			if (zoekIndividueel == sportIndividueel) {
				total++;
			}
		}
		System.out.println(title + " " + total);
	}

	// Sporter zoeken gebaseerd op leeftijd
	public static void searchAtletenByAge(int leeftijd) {
		System.out.println("Atleten met de leeftijd " + leeftijd);
		for (Atleet atleet : atletenList) {
			if (atleet.getAge() == leeftijd) {
				atleet.showAtleetWithAge();
			}
		}
	}

	public static void searchPlayerBirthMonth(Month month) {
		for (Atleet atleet : atletenList) {
			if (atleet.getGeboorteDatum().getMonth() == month) {
				atleet.displayAtleetFullNameAndBirthMonth();
			}
		}
	}

	public String getEuroDate(LocalDate date) {
		String s;
		DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendPattern("dd-MMMM-yyyy HH:mm").toFormatter();
		s = formatter.format(date);
		return s;
	}

	public static void sportersTussenData(int beginYear, int endYear) {
		System.out.println("Sporters tussen " + beginYear + " & " + endYear + " zijn:");
		for (Atleet atleet : atletenList) {
			if (atleet.getGeboorteDatum().getYear() >= beginYear && atleet.getGeboorteDatum().getYear() <= endYear) {
				atleet.displayAtleetFullNameAndBirthMonth();
			}
		}
	}

	public static void main(String arg[]) {
		// Dit voorbeeld is in een ArrayList en houdt alles variable
		AtletenServices atletenServices = new AtletenServices();

		// Assignment 1: Maak een lijst van 50 atleten.
		// Vul ze steeds met andere sporten, dus bijv een aantal boksers, voetballers
		// etc ec
		// Maak deze ook aan met een variabel geboortejaar (tussen 1990-2005))

		fillAtletenArray();

//  - zoek naar alle atleten die zwemmen en druk deze dan af
		search(Sport.ZWEMMEN);

//  - zoek naar alle atleten die jair heten en zwemmen en druk deze dan af
		search("Jair", Sport.ZWEMMEN);

//  (*) zoek naar alle atleten die jonger zijn dan 20 jaar 
		atletenServices.sportersOnder20(atletenList);

		System.out.println();

		// 1) Zorg ervoor dat de geboortedatum willekeurig is tussen 2 data
		// bijv atleten moeten geboren zijn tussen 1990 - 2003

		sportersTussenData(1997, 2003);
		// --------------------------------------------------------------------
		// --------------------------------------------------------------------
		// --------------------------------------------------------------------
		System.out.println();
		// Het volgende is in een search mogelijk
		// --------------------------------------------------------------------
		// 2) Zoek naar alle individuele sporters
		// 3) Druk af hoeveel teamsporters er in de lijst zitten
		searchTotalIndividualPlayersOrTeamPlayers(false);

		searchIndividualPlayerOrTeamPlayer(true);
		// --------------------------------------------------------------------
		// --------------------------------------------------------------------

		System.out.println();
		// 4) Druk af hoeveel sporters er zijn die jarig zijn in Maart
		searchPlayerBirthMonth(Month.APRIL);

		System.out.println();
		// 5) Druk af hoeveel sporters er zijn die geboren zijn in 2000-2002
		searchAtletenByAge(20);
		System.out.println();
		atletenServices.sportersTussenData(atletenList, 1997, 2003);

		// 6) Druk de geboortedatum af in de Europese notatie 1 January 2002 (en niet de
		// Amerikaanse 2002-01-01)
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
			if (maandArray == 2) {
				dagArray = random.nextInt(28) + 1;
			} else if (maandArray == 1 || maandArray == 3 || maandArray == 5 || maandArray == 7 || maandArray == 8
					|| maandArray == 10 || maandArray == 12) {
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
