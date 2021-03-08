package zorgapp;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu
{
	private PatientList	profileList	= new PatientList();
	private Patient		patient		= new Patient();
	private Scanner		scanner		= new Scanner(System.in);

	Menu()
	{

	}

	public void homeMenu()
	{
		int choice = 1;
		try
		{
			System.out.println("MAKE A CHOICE");
			System.out.println("1: Zorgverlener  2: Patient   3: Sluit het programma");

			choice = scanner.nextInt();
			while (choice != 3)
			{
				if (choice == 1)
				{
					staffMenu();
				} else if (choice == 2)
				{
					verified();
				} else if (choice == 3)
				{
					System.out.println("Goodbye");
				}
			}
		} catch (InputMismatchException e)
		{
			System.out.println(
					"HERE IS WHAT MIGHT HAVE GONE WRONG: \n You may have entered something other than a number. \n Please change this.");
			scanner.nextLine();
			homeMenu();
		}

	}

	private void staffMenu()
	{
		try
		{
			System.out.println("WAT WIL JE DOEN?");
			System.out.println("1:Data bekijken  2:Nieuw  3:Ga terug ");

			int zorgChoice = scanner.nextInt();
			scanner.nextLine();
			switch (zorgChoice)
			{
			case 1:
				System.out.println("Data bekijken");
				if (profileList.sizeOf() > 0)
				{
					profileList.getAllProfiles();
					System.out.println("PLEASE CHOOSE WHICH PATIENT YOU WANT TO SEE");
					System.out.println("Type the number in front of the patients info");
					int patientChoice = scanner.nextInt();
					choosePatient(patientChoice);
					System.out.println("WAT WIL JE DOEN?");
					System.out.println("1:Data wijzigen  2:Ga terug ");
					int secondChoice = scanner.nextInt();
					if (secondChoice == 1)
					{
						System.out.println("WELKE DATA WIL JE WIJZIGEN?");
						System.out.println("1:Voornaam  2:Achternaam  3:Leeftijd  4:Lengte  5:Gewicht ");
						int testing = scanner.nextInt();
						switch (testing)
						{

						case 1:
							System.out.println("Enter first name here: ");
							String voornaam = scanner.next();
							scanner.nextLine();

							patient.setVoornaam(voornaam);

							System.out.println("First name has been changed to " + voornaam);

							profileList.patientEdit(0, voornaam);
							break;
						case 2:
							System.out.println("Enter last name here: ");
							String achternaam = scanner.next();
							scanner.nextLine();

							patient.setAchternaam(achternaam);

							System.out.println("Last name has been changed to " + achternaam);

							profileList.editLastname(0, achternaam);
							break;
						case 3:
							System.out.println("Enter age here: ");
							int age = scanner.nextInt();
							patient.setLeeftijd(age);
							System.out.println("age has been changed to " + age);
							profileList.editAge(0, age);
							break;
						case 4:
							System.out.println("Enter length here: ");
							double length = scanner.nextDouble();
							patient.setLengte(length);
							System.out.println("Length has been changed to " + length);
							profileList.editLength(0, length);
							break;
						case 5:
							System.out.println("Enter weigth here: ");
							double weigth = scanner.nextDouble();
							patient.setGewicht(weigth);
							System.out.println("Weigth has been changed to " + weigth);
							profileList.editWeight(0, weigth);
							break;
						default:
							break;
						}
					} else if (secondChoice == 2)
					{
						staffMenu();
					}

				} else
				{
					System.out.println("There are currently no patients in the system.");
				}
				staffMenu();
				break;
			case 2:
				try
				{
					System.out.println("YOU HAVE CHOSEN TO ADD A NEW PATIENT");

					System.out.println("Enter first name here: ");
					String firstname = scanner.nextLine();
					patient.setVoornaam(firstname);
					System.out.println("First name has been changed to " + firstname);

					System.out.println("Enter last name here: ");
					String lastname = scanner.nextLine();
					patient.setAchternaam(lastname);
					System.out.println("Last name has been changed to " + lastname);

					System.out.println("Enter age here: ");
					int age = scanner.nextInt();
					patient.setLeeftijd(age);
					System.out.println("Age has been changed to " + age);

					System.out.println("Enter length here: ");
					double length = scanner.nextDouble();
					patient.setLengte(length);
					System.out.println("Length has been changed to " + length);

					System.out.println("Enter weigth here: ");
					double weight = scanner.nextDouble();
					patient.setGewicht(weight);
					System.out.println("Weight has been changed to " + weight);
					scanner.nextLine();

					profileList.add(patient);
					homeMenu();
					break;
				} catch (InputMismatchException e)
				{
					System.out.println(
							"HERE IS WHAT MIGHT HAVE GONE WRONG: \n You may have entered something other than what was asked. \n Please try again.");
					scanner.nextLine();
				}
			case 3:
				homeMenu();
				break;

			default:
				System.out.println("NOTHING HAS BEEN SELECTED");
				homeMenu();
				break;
			}
		} catch (

		InputMismatchException e)
		{
			System.out.println(
					"HERE IS WHAT MIGHT HAVE GONE WRONG: \n You may have entered something other than a number. \\n Please change this.");
			scanner.nextLine();
			staffMenu();
		}
	}

	public void patientMenu()
	{
		System.out.println("WHAT DO YOU WANT TO DO?");
		System.out.println("1:Data bekijken   2:Data bewerken   3: Terug ");

		int patChoice = scanner.nextInt();
		scanner.nextLine();
		switch (patChoice)
		{
		case 1:

			System.out.println("Dit zijn je gegevens \n");
			profileList.get(0);
			homeMenu();
			break;
		case 2:
			System.out.println("Enter first name here: ");
			String firstname = scanner.nextLine();
			patient.setVoornaam(firstname);
			System.out.println("First name has been changed to " + firstname);

			profileList.patientEdit(0, firstname);
			break;

		case 3:
			homeMenu();
			break;
		default:
			System.out.println("NOTHING HAS BEEN SELECTED");
			patientMenu();
			break;
		}

	}

	public void verified()
	{
		System.out.println("Enter first name to get your data ");
		String name = scanner.nextLine();
		profileList.verify(name);

		if (profileList.checked == true)
		{
			patientMenu();
		} else
		{
			System.out.println("Invoer was niet goed. Probeer opnieuw.");
		}
	}

	public void choosePatient(int patientChoice)
	{
		try
		{

			profileList.get(patientChoice);

		} catch (InputMismatchException e)
		{
			System.out.println(
					"HERE IS WHAT MIGHT HAVE GONE WRONG: \n You may have entered something other than a number. \\n Please change this.");
			scanner.nextLine();
			homeMenu();
		}

	}
}
