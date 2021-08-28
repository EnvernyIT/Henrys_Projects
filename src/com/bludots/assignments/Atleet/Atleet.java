package com.bludots.assignments.Atleet;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Atleet {

	public enum Sport {
		BAANWIELRENNEN(true), ATLETIEK(true), ZWEMMEN(true), BOKSEN(true), ZEILEN(true), VOETBAL(false),
		BASKETBAL(false);

		private boolean individueel;

		private Sport(boolean individueel) {
			this.individueel = individueel;
		}

		boolean isIndividueel() {
			return individueel;
		}
	};

	private String voorNaam;
	private String achterNaam;
	private LocalDate geboorteDatum;
	private Sport sport;

	public Atleet(String voorNaam, String achterNaam, LocalDate geboorteDatum, Sport sport) {
		super();
		this.voorNaam = voorNaam;
		this.achterNaam = achterNaam;
		this.geboorteDatum = geboorteDatum;
		this.sport = sport;
	}

	public String getVoorNaam() {
		return voorNaam;
	}

	public void setVoorNaam(String voorNaam) {
		this.voorNaam = voorNaam;
	}

	public String getAchterNaam() {
		return achterNaam;
	}

	public void setAchterNaam(String achterNaam) {
		this.achterNaam = achterNaam;
	}

	public LocalDate getGeboorteDatum() {
		return geboorteDatum;
	}

	public void setGeboorteDatum(LocalDate geboorteDatum) {
		this.geboorteDatum = geboorteDatum;
	}

	public Sport getSport() {
		return sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}

	// Bepaal leeftijd
	public int getAge() {
		LocalDate now = LocalDate.now();
		LocalDate years = now.minusYears(geboorteDatum.getYear());
		return years.getYear();
	}

	public String displayAtleetFullNameAndSport() {
		return voorNaam + " " + achterNaam + " Sport: " + sport;
	}
	
	public String displayAtleetFullNameAndBirthMonth() {
		return voorNaam + " " + achterNaam + " Sport: " + geboorteDatum;
	}

	@Override
	public int hashCode() {
		return Objects.hash(sport);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atleet other = (Atleet) obj;
		return sport == other.sport;
	}

	@Override
	public String toString() {
		return "Atleet [voorNaam=" + voorNaam + ", achterNaam=" + achterNaam + ", geboorteDatum=" + geboorteDatum
				+ ", sport=" + sport + "]";
	}

	public void showAtleet() {
		System.out.println("Voornaam	: " + getVoorNaam());
		System.out.println("Achternaam	: " + getAchterNaam());
		System.out.println("Sport		: " + getSport());
		System.out.println("GeboorteDatum	: " + getGeboorteDatum());
		System.out.println("Individueel : " + getSport().isIndividueel());
		System.out.println();
	}

	public static void main(String arg[]) {
		Atleet atleet1 = new Atleet("Jair", "Tjon en Fa", LocalDate.of(1994, 4, 1), Sport.BAANWIELRENNEN);
		System.out.println("Atleet " + atleet1.getAchterNaam() + " Leeftijd: " + atleet1.getAge());

		Random random1 = new Random();
		long randomGetal = random1.nextLong();
		System.err.println("Willekeurig = " + randomGetal);

		long remain = randomGetal % 15;
		System.err.println("Remain =" + remain);
		System.out.println();
		System.out.println();

		// Dit voorbeeld is met een Array
		//
		// Assignment 1: Maak een lijst van 50 atleten.
		// Vul ze steeds met andere sporten, dus bijv een aantal boksers, voetballers
		// etc ec
		// Maak deze ook aan met een variabel geboortejaar (tussen 1990-2005))
		System.out.println("Array gebruikt");
		Atleet[] atletenArray = new Atleet[100];
		for (int i = 0; i < 50; i++) {
			// Zorgt voor verschillende voornamen
			Random randomArray = new Random();
			int naamNummerArray = randomArray.nextInt(4);
			String[] namesArray = { "Jair", "Anthony", "Letitia", "Jeremy" };

			// Zorgt voor verschillende achternamen
			int naamAchterNummerArray = randomArray.nextInt(4);
			String[] achterNamenArray = { "Tjon en Fa", "Nesty", "Vriesde", "Moore" };

			// Zorgt voor Verschillende sporten
			Sport nieuwSportArray = null;
			int ranGetal = randomArray.nextInt(6);
			if (ranGetal == 0) {
				nieuwSportArray = Sport.BAANWIELRENNEN;
			} else if (ranGetal == 1) {
				nieuwSportArray = Sport.ATLETIEK;
			} else if (ranGetal == 2) {
				nieuwSportArray = Sport.BOKSEN;
			} else if (ranGetal == 3) {
				nieuwSportArray = Sport.VOETBAL;
			} else if (ranGetal == 4) {
				nieuwSportArray = Sport.ZEILEN;
			} else if (ranGetal == 5) {
				nieuwSportArray = Sport.ZWEMMEN;
			}

			// houdt de verjaardagen variabel
			int dagArray = randomArray.nextInt(27) + 1;
			int maandArray = randomArray.nextInt(12) + 1;
			int jaarArray = randomArray.nextInt(2005 - 1990) + 1990;

			atletenArray[i] = new Atleet(namesArray[naamNummerArray], achterNamenArray[naamAchterNummerArray],
					LocalDate.of(jaarArray, maandArray, dagArray), nieuwSportArray);
			;
		}

		System.err.println("De atleten zijn: ");
		System.out.println(Arrays.toString(atletenArray));
		System.out.println();

		// - zoek naar alle atleten die zwemmen en druk deze dan af
//		System.err.println("De atleten die zwemmmen zijn:");
//		for(int i = 0; i < atletenArray.length; i++) {
//			if(atletenArray[i].getSport().equals(Sport.ZWEMMEN)) {
//				System.out.println(atletenArray[i].toString());
//			}
//		}

		// - zoek naar alle atleten die jair heten en zwemmen en druk deze dan af
//		System.err.println("De atleten die Jair heten en Zwemmen zijn:");
//		for(int i = 0; i < atletenArray.length; i++) {
//			if(atletenArray[i].getSport().equals(Sport.ZWEMMEN) && 
//					atletenArray[i].getVoorNaam().equals("Jair")) {
//				System.out.println(atletenArray[i].toString());
//			}
//		}
//		System.out.println();

		// vul de
		// (*) zoek naar alle atleten die jonger zijn dan 20 jaar
//		System.err.println("De atleten jonger dan 20 jaar:");
//		for(int i = 0; i < atletenArray.length; i++) {
//			if(atletenArray[i].getAge() < 20) {
//				atletenArray[i].toString();
//			}
//		}
		// -------------------------------------------------------------------------------------------------------------------------
		// -------------------------------------------------------------------------------------------------------------------------
		// -------------------------------------------------------------------------------------------------------------------------
		// -------------------------------------------------------------------------------------------------------------------------
		// Dit voorbeeld is in een ArrayList en houdt alles variable

		// Assignment 1: Maak een lijst van 50 atleten.
		// Vul ze steeds met andere sporten, dus bijv een aantal boksers, voetballers
		// etc ec
		// Maak deze ook aan met een variabel geboortejaar (tussen 1990-2005))
		System.out.println();
		System.out.println();
		System.out.println("ArrayList gebruikt");
		ArrayList<Atleet> atleten = new ArrayList<>();
		Atleet atleet2;
		int numberOfAtleten = 0;
		while (numberOfAtleten < 50) {
			// Zorgt voor verschillende voornamen
			Random random = new Random();
			int naamNummer = random.nextInt(4);

			String[] names = { "Jair", "Anthony", "Letitia", "Jeremy" };

			// Zorgt voor verschillende achternamen
			int naamAchterNummer = random.nextInt(4);
			String[] achterNamen = { "Tjon en Fa", "Nesty", "Vriesde", "Moore" };
			// Zorgt voor Verschillende sporten
			Sport nieuwSport = null;
			int ranGetal = random.nextInt(6);
			if (ranGetal == 0) {
				nieuwSport = Sport.BAANWIELRENNEN;
			} else if (ranGetal == 1) {
				nieuwSport = Sport.ATLETIEK;
			} else if (ranGetal == 2) {
				nieuwSport = Sport.BOKSEN;
			} else if (ranGetal == 3) {
				nieuwSport = Sport.VOETBAL;
			} else if (ranGetal == 4) {
				nieuwSport = Sport.ZEILEN;
			} else if (ranGetal == 5) {
				nieuwSport = Sport.ZWEMMEN;
			}

			// houdt de verjaardagen variabel
			int dag = random.nextInt(27) + 1;
			int maand = random.nextInt(12) + 1;
			int jaar = random.nextInt(2005 - 1990) + 1990;
			atleten.add(new Atleet(names[naamNummer], achterNamen[naamAchterNummer], LocalDate.of(jaar, maand, dag),
					nieuwSport));
			numberOfAtleten++;
		}
		System.err.println("De atleten zijn: ");
		System.out.println(atleten.toString());

		// - zoek naar alle atleten die zwemmen en druk deze dan af
		List<Atleet> zwemmers = new ArrayList<Atleet>();
		for (int i = 0; i <= atleten.size() - 1; i++) {
			Atleet atleet = atleten.get(i);
			if (atleet.getSport().equals(Sport.ZWEMMEN)) {
				zwemmers.add(atleet);
			}
		}
		System.err.println("De zwemmers zijn: ");
		System.out.println(zwemmers.toString());

		// - zoek naar alle atleten die jair heten en zwemmen en druk deze dan af
		List<Atleet> jair_zwemmers = new ArrayList<Atleet>();
		for (int i = 0; i <= atleten.size() - 1; i++) {
			Atleet atleet = atleten.get(i);
			if ((atleet.getSport().equals(Sport.ZWEMMEN)) && atleet.getVoorNaam().equals("Jair")) {
				jair_zwemmers.add(atleet);
			}
		}
		System.err.println("De zwemmers die Jair heten zijn: ");
		System.out.println(jair_zwemmers.toString());

		// (*) zoek naar alle atleten die jonger zijn dan 20 jaar
		List<Atleet> atleten_jonger_dan_20 = new ArrayList<Atleet>();
		for (int i = 0; i <= atleten.size() - 1; i++) {
			Atleet atleet = atleten.get(i);
			if (atleet.getAge() < 20) {
				atleten_jonger_dan_20.add(atleet);
			}
		}
		System.err.println("De atleten jonger dan 20 zijn: ");
		System.out.println(atleten_jonger_dan_20.toString());
	}

}
