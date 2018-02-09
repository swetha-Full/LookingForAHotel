package My_Task.hotel;

import java.io.IOException;

import hotel.hotelBooking;

public class Hotel {
	String name;
	int ratings;
	double costPerDay;
	int discountPercentage;
	int discountDays;
	public Hotel(String hotelName, int rating, double cost, int offer,int validOffer)throws IOException {
		this.name = hotelName;
		this.ratings = rating;
		this.costPerDay= cost;
		this.discountPercentage=offer;
		this.discountDays=validOffer;
		public static String hotelBooking()
		{
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hotel hotels[] = new Hotel[numberOfHotels];
	}

}
