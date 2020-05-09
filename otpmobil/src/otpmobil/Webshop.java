package otpmobil;

public class Webshop {
	
	private UserRepository userRepository;
	
	private ItemRepository itemRepository;
	
	public UserRepository getUserReposiotry() {
		if(userRepository ==null) {
			userRepository = new UserRepository();
		}
		
		return userRepository;
	}
	public void setUserRepositorys(UserRepository users) {
		this.userRepository = users;
	}
	public ItemRepository getItemRepository() {
		if(itemRepository ==null) {
			itemRepository = new ItemRepository();
		}
		return itemRepository;
	}
	public void setItemRepository(ItemRepository items) {
		this.itemRepository = items;
	}
	
	

}
