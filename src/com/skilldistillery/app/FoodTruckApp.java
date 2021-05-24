package com.skilldistillery.app;

import java.util.Scanner;

public class FoodTruckApp {

	static Scanner sc = new Scanner(System.in);
	FoodTruck[] truckArray = new FoodTruck[5];

	public static void main(String[] args) {
		FoodTruckApp foodTrucks = new FoodTruckApp(); // create an instance from this class

		foodTrucks.runApp(sc);

	}

	public void runApp(Scanner sc) {

		System.out.println("Welcome to our Food Truck App!");

		for (int i = 0; i < 5; i++) {

			System.out.print("Please enter the food truck's name (or quit to stop): ");
			String name = sc.nextLine();
			if (name.equalsIgnoreCase("quit")) {
				break;
			}
			System.out.print("Please enter the truck's type of food: ");
			String foodType = sc.nextLine();
			System.out.print("Please enter the food truck's rating (1 (lowest) - 5 (highest)): ");
			int rating = sc.nextInt();
			sc.nextLine();

			truckArray[i] = new FoodTruck(name, foodType, rating); // calls line 17 on class
		}

		boolean keepGoing = true;

		while (keepGoing) {
			printMenu();
			int option = sc.nextInt();

			switch (option) {
			case 1:
				listAllTrucks();
				break;
			case 2:
				System.out.printf("Average rating of all trucks: %.2f, ", averageTruckRating());
				System.out.println(); // used printf %.2f to round all decimals to 2 decimal places 
				break;
			case 3:
				highestRatedTruck();
				break;
			case 4:
				keepGoing = false;
				System.out.println("Thanks for rating trucks in our Food Truck App! Goodbye.");
				break;
			default:
				System.err.println("Invalid entry! Select option 1 - 4");
			}

		}
	}

	public void listAllTrucks() {
		for (int i = 0; i < truckArray.length; i++) {
			if (truckArray[i] != null) { // we can't invoke null bc its got no data
				System.out.println(truckArray[i].toString());
			}
		}

	}

	public void printMenu() {
		System.out.println("---------------Menu---------------");
		System.out.println("1) List of all Food Trucks");
		System.out.println("2) Show average Rating of Food Trucks");
		System.out.println("3) Display highest-rated Food Truck");
		System.out.println("4) Quit the application");
		System.out.println("----------------------------------");
		System.out.print("Please select a Menu option: ");
	}

	public double averageTruckRating() {
		int individualTruck = 1;
		int individualRating = 1;
		double rating = 0.0;
		for (int i = 0; i < 5; i++) {
			if (truckArray[i] != null) {
				individualRating = truckArray[i].getRating(); 
				rating += individualRating;
				individualTruck = truckArray[i].getTruckId(); 
			}
		}
		double averageRating = rating / individualTruck;
		return averageRating;
	}

	public void highestRatedTruck() {
		int highestRating = 1;
		int max = 0; // initialize a local variable max for our truck with the highest rating
		for (int i = 0; i < 5; i++) {
			if (truckArray[i] != null) {
				// if our highest rating is less than the rating at our index i that we're
				// iterating, then we will replace our highest rating with that indexes rating
				if (highestRating < truckArray[i].getRating()) {
					highestRating = truckArray[i].getRating();
					max = i; // set our local variable equal to the index (position) where the highest rating
								// lives
				}
			}
		}
		System.out.println("The highest rated Truck is: " + truckArray[max]);
	}

}
