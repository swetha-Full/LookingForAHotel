package hotel;

import java.io.*;
import java.util.Arrays;

public class HotelBooking {
	String name;
	int ratings;
	double costPerDay;
	int discountPercentage;
	int discountDays;

	public HotelBooking(String hotelName, int rating, double cost, int offer, int validOffer) throws IOException {
		this.name = hotelName;
		this.ratings = rating;
		this.costPerDay = cost;
		this.discountPercentage = offer;
		this.discountDays = validOffer;
	}

	public HotelBooking(String hotelName, double cost, int offer, int validOffer) throws IOException {
		this.name = hotelName;
		this.costPerDay = cost;
		this.discountPercentage = offer;
		this.discountDays = validOffer;
	}

	public static double computeOffer(double discounts, double cost, int days) {
		double offer = (discounts / 100) * cost;
		double bill = cost * days - offer;
		return bill;
	}

	public static boolean foundAHotel(double bill, double money) {
		if (money >= bill)
			return true;

		else
			return false;

	}

	public static double MinCost(double[] cost) {
		double min = cost[0];
		for (double c : cost) {
			if (c < min)
				min = c; // james was here

		}
		return min;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		double amountPayableByUser = 0;
		int countOfHotels = 0;
		boolean result = false;
		double offer, SelectedHotelPrice = 0;
		int j = 0, pos = 0;
		String bookedHotelName = "";

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of hotels:");
		int numberOfHotels = Integer.parseInt(br.readLine());
		HotelBooking hotels[] = new HotelBooking[numberOfHotels];
		double[] cost = new double[numberOfHotels];
		for (int i = 0; i < numberOfHotels; i++) {
			System.out.println("Enter the hotel name:");
			String name = br.readLine();
			System.out.println("Enter the hotel rating:");
			int rating = Integer.parseInt(br.readLine());
			System.out.println("Enter the hotel cost per day:");
			double price = Double.parseDouble(br.readLine());
			System.out.println("Enter the discount % provided by the hotel: ");
			int discounts = Integer.parseInt(br.readLine());
			System.out.println("Enter the Number of days after which discount  % can be applied: ");
			int discountsDays = Integer.parseInt(br.readLine());
			hotels[i] = new HotelBooking(name, rating, price, discounts, discountsDays);
		}
		System.out.println("Enter the user money:");
		double userMoney = Double.parseDouble(br.readLine());
		System.out.println("Enter the rating of hotel the user is looking for: ");
		int userRating = Integer.parseInt(br.readLine());
		System.out.println("Enter the number of the days the user wants the room for: ");
		int days = Integer.parseInt(br.readLine());
		for (int k = 0; k < numberOfHotels; k++) {

			if (userRating == hotels[k].ratings) {
				cost[j] = hotels[k].costPerDay;
				j++;
				break;
			}
		}
		
		//System.out.println("There are " + j + " hotels the user can be booked in:");
		SelectedHotelPrice = HotelBooking.MinCost(cost);
		for (int m = 0; m < numberOfHotels; m++) {
			if (SelectedHotelPrice == hotels[m].costPerDay || userRating==hotels[m].ratings) {
				pos = m;
				bookedHotelName = hotels[m].name;
				break;
			}
		}
		if (days >= hotels[pos].discountDays) {

			amountPayableByUser = computeOffer(hotels[pos].discountPercentage, hotels[pos].costPerDay, days);
		} else {

			amountPayableByUser = days * hotels[pos].costPerDay;
		}

		result = foundAHotel(amountPayableByUser, userMoney);

		if (result == true)

			System.out.println("Hotel Booked for " + days + "days in " + userRating + "star hotel " + bookedHotelName
					+ " for the cost of " + amountPayableByUser);

		else
			System.out.println("Sorry! you dont have sufficient amount to book any hotel");

	}
}