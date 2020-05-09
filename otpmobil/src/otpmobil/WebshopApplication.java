package otpmobil;

public class WebshopApplication {

	
	public static void main(String[] args) {
		
		Webshop webshop = new Webshop();
		Item item1 = new Book(2849, "Emelked�s", "EUR�PA K�NYVKIAD� KFT.","Stephen King",2020,"Novella,elbesz�l�s", 1234, 264, 270);
		Item item2 = new Book(4749 , "�lom doktor", "EUR�PA K�NYVKIAD� KFT.","Stephen King",2019,"Krimi, b�n�gyi, thriller", 12334, 564, 810);
		Item item3 = new Book(3199, "�rz�ketlen�l", "EUR�PA K�NYVKIAD� KFT.","Ed James",2020,"Krimi, b�n�gyi, thriller", 123134, 420, 380);
		Item item4 = new Book(2849, "Kedvencek temet�je", "EUR�PA K�NYVKIAD� KFT.","Stephen King",2019,"Krimi, b�n�gyi, thriller", 123594, 587, 406);
		Item item5 = new Book(2849, "Tort�ra", "EUR�PA K�NYVKIAD� KFT.","Stephen King",2020,"Krimi, b�n�gyi, thriller", 1234, 464, 322);
		
		webshop.getItemRepository().addItem(item1);
		webshop.getItemRepository().addItem(item2);
		webshop.getItemRepository().addItem(item3);
		webshop.getItemRepository().addItem(item4);
		webshop.getItemRepository().addItem(item5);
		WebshopService service = new WebshopService(webshop);
		
		service.RegisterUser("�cs Mil�n", "acsmilan@example.com");
		service.RegisterUser("�ll� Ella", "alloella@example.com");
		service.RegisterUser("Vicc Elek", "viccelek@example.com");
		
		//user1
		service.Login(webshop.getUserReposiotry().getUsers().get(0));
		service.addItemToBasket(webshop.getItemRepository().getItems().get(0));
		service.addItemToBasket(webshop.getItemRepository().getItems().get(2));
		service.addItemToBasket(webshop.getItemRepository().getItems().get(4));
		service.deleteItem(webshop.getItemRepository().getItems().get(2));	
		service.PayBasket();
		
		//user2		
		service.Login(webshop.getUserReposiotry().getUsers().get(1));
		service.addItemToBasket(webshop.getItemRepository().getItems().get(1));
		service.addItemToBasket(webshop.getItemRepository().getItems().get(2));
		service.addItemToBasket(webshop.getItemRepository().getItems().get(3));		
		service.PayBasket();
				
	}
}
