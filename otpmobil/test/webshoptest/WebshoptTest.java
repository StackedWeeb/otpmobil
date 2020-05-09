package webshoptest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import otpmobil.Book;
import otpmobil.Item;
import otpmobil.User;
import otpmobil.Webshop;
import otpmobil.WebshopService;

public class WebshoptTest {

	Webshop webshop;
	WebshopService service;
	Item item1, item2,item3,item4, item5;
	@Before
    public void init() {
		webshop = new Webshop();
		item1 = new Book(2849, "Emelkedés", "EURÓPA KÖNYVKIADÓ KFT.","Stephen King",2020,"Novella,elbeszélés", 1234, 264, 270);
		item2 = new Book(4749 , "Álom doktor", "EURÓPA KÖNYVKIADÓ KFT.","Stephen King",2019,"Krimi, bûnügyi, thriller", 12334, 564, 810);
		item3 = new Book(3199, "Érzéketlenül", "EURÓPA KÖNYVKIADÓ KFT.","Ed James",2020,"Krimi, bûnügyi, thriller", 123134, 420, 380);
		item4 = new Book(2849, "Kedvencek temetõje", "EURÓPA KÖNYVKIADÓ KFT.","Stephen King",2019,"Krimi, bûnügyi, thriller", 123594, 587, 406);
		item5 = new Book(3799, "Tortúra", "EURÓPA KÖNYVKIADÓ KFT.","Stephen King",2020,"Krimi, bûnügyi, thriller", 1234, 464, 322);
		
		webshop.getItemRepository().addItem(item1);
		webshop.getItemRepository().addItem(item2);
		webshop.getItemRepository().addItem(item3);
		webshop.getItemRepository().addItem(item4);
		webshop.getItemRepository().addItem(item5);
		service = new WebshopService(webshop);
		
		service.RegisterUser("Ács Milán", "acsmilan@example.com");
		service.RegisterUser("Álló Ella", "alloella@example.com");
		service.RegisterUser("Vicc Elek", "viccelek@example.com");
    }
	
	@Test
	public void RegisterTests() {
		assertEquals(webshop.getUserReposiotry().getUsers().size(), 3);
		assertEquals(webshop.getUserReposiotry().getUsers().get(0), service.getWebshop().getUserReposiotry().getUsers().get(0));
		assertEquals("Ács Milán",service.getWebshop().getUserReposiotry().getUsers().get(0).getName());
		assertEquals("Álló Ella",webshop.getUserReposiotry().getUsers().get(1).getName());
		assertEquals("Vicc Elek",service.getWebshop().getUserReposiotry().getUsers().get(2).getName());		
	}
	@Test
	public void PayCartTests() {
		//user1
		service.Login(webshop.getUserReposiotry().getUsers().get(0));
		
		assertEquals("Ács Milán", service.getCurrentuser().getName());
		assertEquals(0, service.getCurrentuser().getCart().getItemReposiotry().getItems().size());

		assertEquals(0.0, service.getCurrentuser().getCart().getPrice(), 0.001);
		
		service.addItemToBasket(webshop.getItemRepository().getItems().get(2));
		assertEquals(3199, service.getCurrentuser().getCart().getPrice(), 0.001);
		
		service.PayBasket();
		assertEquals(0, service.getCurrentuser().getCart().getItemReposiotry().getItems().size());
		assertEquals(0, service.getCurrentuser().getCart().getPrice(), 0.001);
		assertEquals(96801, service.getCurrentuser().getSum(), 0.001);
		
		
		//user2
		service.Login(webshop.getUserReposiotry().getUsers().get(1));
		
		assertEquals("Álló Ella", service.getCurrentuser().getName());
		assertEquals(0, service.getCurrentuser().getCart().getItemReposiotry().getItems().size());

		assertEquals(0.0, service.getCurrentuser().getCart().getPrice(), 0.001);
		
		service.addItemToBasket(webshop.getItemRepository().getItems().get(4));
		assertEquals(3799, service.getCurrentuser().getCart().getPrice(), 0.001);
		
		service.PayBasket();
		assertEquals(0, service.getCurrentuser().getCart().getItemReposiotry().getItems().size());
		assertEquals(0, service.getCurrentuser().getCart().getPrice(), 0.001);
		assertEquals(100000-3799, service.getCurrentuser().getSum(), 0.001);
		
		//user3
		service.Login(webshop.getUserReposiotry().getUsers().get(2));
		
		assertEquals("Vicc Elek", service.getCurrentuser().getName());
		assertEquals(0, service.getCurrentuser().getCart().getItemReposiotry().getItems().size());

		assertEquals(0.0, service.getCurrentuser().getCart().getPrice(), 0.001);
		
		service.addItemToBasket(webshop.getItemRepository().getItems().get(0));
		assertEquals(2849, service.getCurrentuser().getCart().getPrice(), 0.001);
		
		service.PayBasket();
		assertEquals(0, service.getCurrentuser().getCart().getItemReposiotry().getItems().size());
		assertEquals(0, service.getCurrentuser().getCart().getPrice(), 0.001);
		assertEquals(100000-2849, service.getCurrentuser().getSum(), 0.001);		
	}
	@Test
	public void AddItemToCart() {
		service.Login(webshop.getUserReposiotry().getUsers().get(2));
		
		
		service.addItemToBasket(webshop.getItemRepository().getItems().get(0));
		assertEquals(2849, service.getCurrentuser().getCart().getPrice(), 0.001);
		assertEquals(1, service.getCurrentuser().getCart().getItemReposiotry().getItems().size());
		assertEquals(2849, service.getCurrentuser().getCart().getPrice(), 0.001);
		service.addItemToBasket(webshop.getItemRepository().getItems().get(0));
		service.addItemToBasket(webshop.getItemRepository().getItems().get(3));
		assertEquals(3, service.getCurrentuser().getCart().getItemReposiotry().getItems().size());
		assertEquals(8547, service.getCurrentuser().getCart().getPrice(), 0.001);
		
	}
	@Test
	public void DeleteItemFromCart() {
		service.Login(webshop.getUserReposiotry().getUsers().get(2));
		
		//no exception
		service.deleteItem(webshop.getItemRepository().getItems().get(0));
		
		service.addItemToBasket(webshop.getItemRepository().getItems().get(0));
		assertEquals(2849, service.getCurrentuser().getCart().getPrice(), 0.001);
		assertEquals(1, service.getCurrentuser().getCart().getItemReposiotry().getItems().size());
		
		service.deleteItem(webshop.getItemRepository().getItems().get(2));
		//no change when the one we wish to delete is not in the cart
		assertEquals(2849, service.getCurrentuser().getCart().getPrice(), 0.001);
		assertEquals(1, service.getCurrentuser().getCart().getItemReposiotry().getItems().size());
		
		service.deleteItem(webshop.getItemRepository().getItems().get(0));		
		assertEquals(0.0, service.getCurrentuser().getCart().getPrice(), 0.001);
		assertEquals(0, service.getCurrentuser().getCart().getItemReposiotry().getItems().size());
				
	}

}
