package com.bludots.assignments.Atleet;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
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
		return voorNaam + " " + achterNaam + " Geboortedatum: " + geboorteDatum;
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
	
	public String getEuroDate() {
		String s;
		DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendPattern("dd-MMMM-yyyy HH:mm").toFormatter();
		s = formatter.format(geboorteDatum);
		return s;
	}
	
	public void showAtleetWithAge() {
		System.out.println(voorNaam + " " + achterNaam + " Geboortedatum: " + geboorteDatum + " Age: " + getAge() + " Sport: " + sport);

	}

	public void showAtleet() {
		System.out.println("Voornaam	: " + getVoorNaam());
		System.out.println("Achternaam	: " + getAchterNaam());
		System.out.println("Sport		: " + getSport());
		System.out.println("GeboorteDatum	: " + getGeboorteDatum());
		System.out.println("Individueel : " + getSport().isIndividueel());
		System.out.println();
	}


}
