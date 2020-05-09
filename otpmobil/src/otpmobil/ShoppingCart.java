package otpmobil;

import java.time.LocalDateTime;

public class ShoppingCart {
	
	private ItemRepository itemRepository;
	
	public ItemRepository getItemReposiotry() {
		if(itemRepository ==null) {
			itemRepository = new ItemRepository();
		}
		return itemRepository;
	}

	public void setItems(ItemRepository items) {
		this.itemRepository = items;
	}

	public LocalDateTime getDateOfPurchase() {
		return dateOfPurchase;
	}

	public void setDateOfPurchase(LocalDateTime dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}

	private LocalDateTime dateOfPurchase;
	
	public double getPrice() {
		double sum = 0;
		if (itemRepository != null) {
			for (Item item : itemRepository.getItems()) {
				sum += item.getPrice();
			}
		}
		return sum;
	}

}
