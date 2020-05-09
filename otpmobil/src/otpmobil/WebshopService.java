package otpmobil;

import java.time.LocalDateTime;

public class WebshopService {
	
	private Webshop webshop;
	
	public Webshop getWebshop() {
		return webshop;
	}

	public void setWebshop(Webshop webshop) {
		this.webshop = webshop;
	}

	public User getCurrentuser() {
		return currentuser;
	}

	public void setCurrentuser(User currentuser) {
		this.currentuser = currentuser;
	}
	private User currentuser;
	
	public WebshopService(Webshop webshop) {
		this.webshop = webshop;
	}
	
	public void RegisterUser(String name, String email) {
		User user = new  User(name, email);
		ShoppingCart cart = new ShoppingCart();
		user.setCart(cart);
		user.setSum(100000);
		webshop.getUserReposiotry().Register(user);
		System.out.println(user.getName()+" has registered to the webshop.");
	}
	
	public void PayBasket() {
		double sum = currentuser.getCart().getPrice();
		if (currentuser.getSum() < sum) {
			System.out.println(currentuser.getName()+ " has not enough funds to buy the goods in your cart.");
		}else {
			currentuser.getCart().setDateOfPurchase(LocalDateTime.now());
			System.out.println(currentuser.getName()+ " has successfully purchased the goods in the cart for " + currentuser.getCart().getPrice()+" Ft.");
			currentuser.setSum(currentuser.getSum()-currentuser.getCart().getPrice());
			currentuser.getPreviousCarts().add(currentuser.getCart());
			currentuser.getCart().getItemReposiotry().clearItems();
		}		
	}	
	public void addItemToBasket(Item item) {
		if (currentuser != null){
			currentuser.getCart().getItemReposiotry().addItem(item);
			System.out.println(currentuser.getName()+ " added " + item.toString() + " to her/his cart.");
		}else {
			System.err.println("There's no user logged in, to access your cart, first you need to log in!");
		}
	}
	
	public void Login(User user) {
		this.currentuser = user;
	}
	public void deleteItem(Item item) {
		if (currentuser != null){
			if(currentuser.getCart().getItemReposiotry().deleteItem(item)) {
				System.out.println(currentuser.getName()+ " removed " + item.toString() + " from her/his cart.");
			}
		}else {
			System.err.println("There's no user logged in, to access your cart, first you need to log in!");
		}
	}
}
