package hotel;
import java.util.*;

import various.collections.Books;

import java.io.*;
public class HotelBooking {
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
				min = c; 

		}
		return min;
	}

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		double SelectedHotelPrice=0;
		double [] cost=new double[10];
		int j=0;
		String bookedHotelName="";
		double amountPayableByUser=0,discountPercentage=0;
		boolean result=false;
		int discountDays=0;
		List<Hotels> list=new LinkedList<Hotels>();
		Hotels h1=new Hotels("The Park",5,90,20,2);
		Hotels h2=new Hotels("Hotel Hyaat",5,82,12,3);
		Hotels h3=new Hotels("Raddisson",3,60,18,3);
		Hotels h4=new Hotels("RainTree",3,58,15,2);
		Hotels h5=new Hotels(" Accord",1,41.55,12,3);
		Hotels h6=new Hotels("Fortune",1,43,15,4);	
		
		list.add(h1);  
	    list.add(h2);  
	    list.add(h3); 
	    list.add(h4);  
	    list.add(h5);  
	    list.add(h6);
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    System.out.println("Enter the user money:");
		double userMoney = Double.parseDouble(br.readLine());
		System.out.println("Enter the rating of hotel the user is looking for: ");
		int userRating = Integer.parseInt(br.readLine());
		if(userRating!=1||userRating!=3||userRating!=5)
		{
			System.out.println("No hotel found of "+userRating+" stars");
		}else
		{
		System.out.println("Enter the number of the days the user wants the room for: ");
		int days = Integer.parseInt(br.readLine());
		
		 for(Hotels h:list){
			 if (userRating == h.ratings) 
			 {
				 if (days >= discountDays)
					{

							amountPayableByUser = computeOffer(discountPercentage,h.costPerDay, days);
							
						}
						else {

							amountPayableByUser = days * h.costPerDay;
											}
			break;		
				
		 }
			 cost[j++]=amountPayableByUser;
			 
		 }
			 SelectedHotelPrice = HotelBooking.MinCost(cost);
			
		 
		
		for (Hotels hs:list)
		{
			if(userRating==hs.ratings || SelectedHotelPrice==hs.costPerDay)
			{
				bookedHotelName=hs.name;
				discountDays=hs.discountDays;
				discountPercentage=hs.discountPercentage;
				
				break;
			}
		}
			
		
	
		
		
				result = foundAHotel(amountPayableByUser, userMoney);
				if (result == true)

					System.out.println("Hotel Booked for " + days + "days in " + userRating + "star hotel " + bookedHotelName
							+ " for the cost of " + amountPayableByUser);

				else
					System.out.println("Sorry! you dont have sufficient amount to book any hotel");
		}
		
	}

}
