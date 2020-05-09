package otpmobil;

import java.util.ArrayList;
import java.util.List;

public class User {

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ShoppingCart getCart() {
		return cart;
	}

	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}
	
	private double sum;

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public List<ShoppingCart> getPreviousCarts() {
		if (previousCarts ==null) {
			previousCarts = new ArrayList<ShoppingCart>();
		}
		return previousCarts;
	}

	public void setPreviousCarts(List<ShoppingCart> previousCarts) {
		this.previousCarts = previousCarts;
	}

	private String name;
	
	private String email;
	
	private String address;
	
	private ShoppingCart cart;
	
	private List<ShoppingCart> previousCarts;
	
	public User(String name, String email) {
		this.name = name;
		this.email = email;
	}
	
}
