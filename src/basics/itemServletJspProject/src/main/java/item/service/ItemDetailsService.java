package item.service;

import item.model.Item;
import item.model.ItemDetails;

public interface ItemDetailsService {
	Boolean removeItemDetails(Long id);
	Boolean createItemDetails(ItemDetails details);
}

