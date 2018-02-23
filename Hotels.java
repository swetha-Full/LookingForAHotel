package hotel;
import java.io.IOException;
import java.util.*;
import java.util.*;
public class Hotels implements Comparable<Hotels> {
	String name;
	int ratings;
	double costPerDay;
	int discountPercentage;
	int discountDays;
	public Hotels(String hotelName, int rating, double cost, int offer, int validOffer) throws IOException {
		this.name = hotelName;
		this.ratings = rating;
		this.costPerDay = cost;
		this.discountPercentage = offer;
		this.discountDays = validOffer;
	}

	public int compareTo(Hotels h) {
		// TODO Auto-generated method stub
		if(costPerDay==h.costPerDay)
			return 0;
		else if(costPerDay>h.costPerDay)
			return 1;
		else
			return -1;
	}
}
