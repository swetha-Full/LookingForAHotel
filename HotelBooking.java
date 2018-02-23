package hotel;

import java.util.*;
import java.io.*;

public class HotelBooking {
	static List<Hotels> list = new LinkedList<Hotels>();
	public static double computeOffer(double discounts, double cost, int days) {
		double bill=cost*days;
		double offer=(discounts/100)*bill;
		double totalBill=bill-offer;
		return totalBill;
	}

	public static boolean foundAHotel(double bill, double money) {
		if (money >= bill)
			return true;

		else
			return false;

	}

	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		double SelectedHotelPrice = 0;
		LinkedList<Double> a = new LinkedList<Double>();
		// double[] cost = new double[10];
		int j = 0;
		String bookedHotelName = "";
		double amountPayableByUser = 0, discountPercentage = 0;
		boolean result = false;
		int discountDays = 0;
		
		Hotels h1 = new Hotels("The Park", 5, 90, 20, 2);
		Hotels h2 = new Hotels("Hotel Hyaat", 5, 82, 12, 3);
		Hotels h3 = new Hotels("Raddisson", 3, 60, 18, 3);
		Hotels h4 = new Hotels("RainTree", 3, 58, 15, 2);
		Hotels h5 = new Hotels(" Accord", 1, 41.55, 12, 3);
		Hotels h6 = new Hotels("Fortune", 1, 43, 15, 4);

		list.add(h1);
		list.add(h2);
		list.add(h3);
		list.add(h4);
		list.add(h5);
		list.add(h6);
		Collections.sort(list);
		for(Hotels b:list)
		{
			System.out.println(b.ratings+" "+b.name+" "+b.costPerDay);
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the user money:");
		double userMoney = Double.parseDouble(br.readLine());
		System.out.println("Enter the rating of hotel the user is looking for: ");
		int userRating = Integer.parseInt(br.readLine());
		if (userRating == 1 || userRating == 3 || userRating == 5) {
			System.out.println("Enter the number of the days the user wants the room for: ");
			int days = Integer.parseInt(br.readLine());
			for(Hotels h:list)
			{
				if(userRating==h.ratings)
				{if(days>=h.discountDays)
				{
					amountPayableByUser=computeOffer(h.discountPercentage,h.costPerDay,days);
				
				}
				else
				{
					amountPayableByUser=h.costPerDay*days;
				}
	a.add(amountPayableByUser);
	Collections.sort(a);
	
				}
				
		}
for(Hotels ht:list)
{
	if(userRating==ht.ratings)

{
		if(days>=ht.discountDays)

{
	amountPayableByUser=computeOffer(ht.discountPercentage,ht.costPerDay,days);

}
else
{
	amountPayableByUser=ht.costPerDay*days;
}
	if(a.get(0).equals(amountPayableByUser))
	{
		bookedHotelName=ht.name;
	}
}

	}
result=foundAHotel(amountPayableByUser,userMoney);
if(result==true)
	System.out.println("Hotel booked for "+days+" days in a "+userRating+" Hotel named "+bookedHotelName+" for the cost of "+a.get(0));
else
	System.out.println("Sorry! you dont have sufficient amount to book any hotel");
		
}
		else
	System.out.println("No hotel of such a star is available");
}
}