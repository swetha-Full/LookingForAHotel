package hotel;
import java.io.IOException;
import java.util.*;
public class Hotels {
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
}
