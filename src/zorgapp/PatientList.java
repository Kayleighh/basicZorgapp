package zorgapp;

import java.util.ArrayList;

public class PatientList
{
	private ArrayList<Patient>	profile	= new ArrayList<>();
	// private Patient patient = new Patient();
	public boolean				checked;

	PatientList()
	{

	}

	public void add(Patient patient)
	{
		Patient newPatient = new Patient(patient.getVoornaam(), patient.getAchternaam(), patient.getLeeftijd(),
				patient.getLengte(), patient.getGewicht());
		profile.add(newPatient);
	}

	public void get(int index)
	{
		for (int i = 0; i < sizeOf(); i++)
		{
			if (i == index)
				System.out.println(profile.get(i).toString());
		}
	}

	public void getAllProfiles()
	{
		for (Patient test : profile)
		{
			int index = profile.indexOf(test);
			System.out.println(index + " " + test.getVoornaam() + " " + test.getAchternaam());
		}
	}

	public void remove(int index)
	{
		profile.remove(index);
	}

	public int sizeOf()
	{
		int size = profile.size();
		return size;
	}

	public void verify(String name)
	{

		for (Patient verified : profile)
		{
			if (verified.getVoornaam().equals(name))
			{
				checked = true;
			} else
			{
				checked = false;
			}
		}
	}

	public void patientEdit(int index, String name)
	{
		for (int i = 0; i < sizeOf(); i++)
		{
			if (i == index)
				profile.get(i);
			Patient newPatient = new Patient(name, profile.get(i).getAchternaam(), profile.get(i).getLeeftijd(),
					profile.get(i).getLengte(), profile.get(i).getGewicht());
			profile.set(i, newPatient);

		}

	}

	public void editFirstname(int index, String voornaam)
	{
		for (int i = 0; i < sizeOf(); i++)
		{
			if (i == index)
			{
				System.out.println("yee");
				profile.get(i);
				Patient newPatient = new Patient(voornaam, profile.get(i).getAchternaam(), profile.get(i).getLeeftijd(),
						profile.get(i).getLengte(), profile.get(i).getGewicht());
				profile.set(0, newPatient);
			} else
			{
				System.out.println("nope");
			}
		}

	}

	public void editLastname(int index, String achternaam)
	{
		for (int i = 0; i < sizeOf(); i++)
		{
			if (i == index)
				profile.get(i);
			Patient newPatient = new Patient(profile.get(i).getVoornaam(), achternaam, profile.get(i).getLeeftijd(),
					profile.get(i).getLengte(), profile.get(i).getGewicht());
			profile.set(i, newPatient);

		}

	}

	public void editAge(int index, int leeftijd)
	{
		for (int i = 0; i < sizeOf(); i++)
		{
			if (i == index)
				profile.get(i);
			Patient newPatient = new Patient(profile.get(i).getVoornaam(), profile.get(i).getAchternaam(), leeftijd,
					profile.get(i).getLengte(), profile.get(i).getGewicht());
			profile.set(i, newPatient);

		}
	}

	public void editLength(int index, double lengte)
	{
		for (int i = 0; i < sizeOf(); i++)
		{
			if (i == index)
				profile.get(i);
			Patient newPatient = new Patient(profile.get(i).getVoornaam(), profile.get(i).getAchternaam(),
					profile.get(i).getLeeftijd(), lengte, profile.get(i).getGewicht());
			profile.set(i, newPatient);

		}
	}

	public void editWeight(int index, double gewicht)
	{
		for (int i = 0; i < sizeOf(); i++)
		{
			if (i == index)
				profile.get(i);
			Patient newPatient = new Patient(profile.get(i).getVoornaam(), profile.get(i).getAchternaam(),
					profile.get(i).getLeeftijd(), profile.get(i).getLengte(), gewicht);
			profile.set(i, newPatient);

		}
	}
}
