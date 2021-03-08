package zorgapp;

public class Patient
{
	private String voornaam;
	private String achternaam;
	private int leeftijd;
	private double lengte;
	private double gewicht;
	Patient()
	{
		
	}
	Patient(String voornaam, String achternaam, int leeftijd, double lengte, double gewicht)
	{
		this.voornaam = voornaam;
		this.achternaam = achternaam;
		this.leeftijd = leeftijd;
		this.lengte = lengte;
		this.gewicht = gewicht;

	}

	public void setVoornaam(String voornaam)
	{
		this.voornaam = voornaam;
	}
	
	public String getVoornaam()
	{
		return voornaam;
	}
	
	public void setAchternaam(String achternaam)
	{
		this.achternaam = achternaam;
	}
	
	public String getAchternaam()
	{
		return achternaam;
	}
	
	public void setLeeftijd(int leeftijd)
	{
		this.leeftijd = leeftijd;
	}
	
	public int getLeeftijd()
	{
		return leeftijd;
	}
	
	public void setLengte(double lengte)
	{
		this.lengte = lengte;
	}
	
	public double getLengte()
	{
		return lengte;
	}
	
	public void setGewicht(double gewicht)
	{
		this.gewicht = gewicht;
	}
	
	public double getGewicht()
	{
		return gewicht;
	}
	
	public double getBmi()
	{
		double bmi = gewicht / (lengte * lengte);
		return bmi;
	}
	
	public String toString()
	{

		return "Name:" + voornaam + " " + achternaam + " " + "\nAge: " + leeftijd + "\nlength: " + lengte + "\nWeight: "
				+ gewicht + "\nBmi:" + getBmi();
	}
}
