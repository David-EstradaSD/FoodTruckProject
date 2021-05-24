package com.skilldistillery.app;

public class FoodTruck {
	static private int uniqueId = 1;
	private int truckId; 
	private String name;
	private String foodType;
	private int rating; 
	
	
	public FoodTruck() {
		truckId = FoodTruck.uniqueId; 
		FoodTruck.uniqueId++;
	}

	public FoodTruck(String name, String foodType, int rating) {
		this(); // we're using this() method to call our other constructor (must always be the 1st statement)
		this.rating = rating;
		this.name = name;
		this.foodType = foodType;
	}


	public int getTruckId() {
		return truckId;
	}

	public void setTruckId(int truckId) {
		this.truckId = truckId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	
	public String toString() {
		String output = "Truck ID: " + truckId + ", Name: " + name
					 + ", Food Type: " + foodType  + ", Rating: " + rating;
		 return output;
	}
	
	public void displayTruck() {
		String truckData = this.toString();
		System.out.println(truckData);
	}
	
	
}











