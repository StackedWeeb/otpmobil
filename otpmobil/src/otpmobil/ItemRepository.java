package otpmobil;

import java.util.ArrayList;
import java.util.List;

public class ItemRepository {
	
	private List<Item> items;
	
	public List<Item> getItems() {
		if (items == null) {
			items = new ArrayList<Item>();
		}
		return items;
	}

	public void setBooks(List<Item> items) {
		this.items = items;
	}

	public void addItem(Item item) {
		if (items == null) {
			items = new ArrayList<>();
		}
		items.add(item);
	}
	
	public void clearItems() {
		items.clear();
	}
	public boolean deleteItem(Item item) {
		if (items == null || items.size() ==0) {
			System.out.println("There's no item to delete.");
			return false;
		}else if(!items.contains(item)) {
			System.out.println("The item has already been removed or was not added at all.");
			return false;
		}
		else {			
			items.remove(item);
			return true;
		}
	}

}
