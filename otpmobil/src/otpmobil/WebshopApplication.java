package otpmobil;

public class WebshopApplication {

	
	public static void main(String[] args) {
		
		Webshop webshop = new Webshop();
		Item item1 = new Book(2849, "Emelkedés", "EURÓPA KÖNYVKIADÓ KFT.","Stephen King",2020,"Novella,elbeszélés", 1234, 264, 270);
		Item item2 = new Book(4749 , "Álom doktor", "EURÓPA KÖNYVKIADÓ KFT.","Stephen King",2019,"Krimi, bûnügyi, thriller", 12334, 564, 810);
		Item item3 = new Book(3199, "Érzéketlenül", "EURÓPA KÖNYVKIADÓ KFT.","Ed James",2020,"Krimi, bûnügyi, thriller", 123134, 420, 380);
		Item item4 = new Book(2849, "Kedvencek temetõje", "EURÓPA KÖNYVKIADÓ KFT.","Stephen King",2019,"Krimi, bûnügyi, thriller", 123594, 587, 406);
		Item item5 = new Book(2849, "Tortúra", "EURÓPA KÖNYVKIADÓ KFT.","Stephen King",2020,"Krimi, bûnügyi, thriller", 1234, 464, 322);
		
		webshop.getItemRepository().addItem(item1);
		webshop.getItemRepository().addItem(item2);
		webshop.getItemRepository().addItem(item3);
		webshop.getItemRepository().addItem(item4);
		webshop.getItemRepository().addItem(item5);
		WebshopService service = new WebshopService(webshop);
		
		service.RegisterUser("Ács Milán", "acsmilan@example.com");
		service.RegisterUser("Álló Ella", "alloella@example.com");
		service.RegisterUser("Vicc Elek", "viccelek@example.com");
		
		service.Login(webshop.getUserReposiotry().getUsers().get(0));
		service.addItemToBasket(webshop.getItemRepository().getItems().get(0));
		service.addItemToBasket(webshop.getItemRepository().getItems().get(2));
		service.addItemToBasket(webshop.getItemRepository().getItems().get(4));
		service.deleteItem(webshop.getItemRepository().getItems().get(2));
		
		service.PayBasket();
				
	}
}
