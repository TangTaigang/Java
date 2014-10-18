package com.dominhquan.service;

import com.dominhquan.model.Item;

public interface ItemService {
	void createItem(Item item);
	Item getItem(int id);
	void removeItem(int id);
	void updateItem();
}
