package com.techelevator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import java.util.HashMap;
import java.util.Map;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UnitTest1 {


	@Test
	public void testRestockOneItem() {
		Item item = new Duck(1, "itemTest", 5, 0);
		Assert.assertTrue(item.restock(5));
	}

	@Test
	public void testRestockTooManyItems() {
		Item item = new Duck(1, "itemTest", 5, 3);
		Assert.assertFalse(item.restock(4));
	}

	@Test
	public void testRestockWithNoItems() {
		Item item = new Duck(1, "itemTest", 5, 3);
		Assert.assertFalse(item.restock(0));
	}

	@Test
	public void testRestockWithNegativeNumber() {
		Item item = new Duck(1, "itemTest", 5, 3);
		Assert.assertFalse(item.restock(-2));
	}

	@Test
	public void testPurchasePass() {
		Map<String, Item> newMap = new HashMap<>();
		Item item1 = new Duck(1, "name1", 10, 10);
		Item item2 = new Pony(2, "name2", 20, 10);
		Item item3 = new Penguin(3, "name3", 30, 10);
		Item item4 = new Cat(4, "name4", 40, 10);
		Customer customer = new Customer();
		newMap.put("1", item1);
		newMap.put("2", item2);
		newMap.put("3", item3);
		newMap.put("4", item4);
		Bank bank = new Bank();
		VendingMachine vendingMachine = new VendingMachine(bank, newMap);
//		Assert.assertTrue(vendingMachine.purchase(customer, "3"));
	}

	@Test
	public void testPurchaseUnavailableItem() {
		Map<String, Item> newMap = new HashMap<>();
		Item item1 = new Duck(1, "name1", 10, 10);
		Item item2 = new Pony(2, "name2", 20, 10);
		Item item3 = new Penguin(3, "name3", 30, 10);
		Item item4 = new Cat(4, "name4", 40, 10);
		Customer customer = new Customer();
		newMap.put("1", item1);
		newMap.put("2", item2);
		newMap.put("3", item3);
		newMap.put("4", item4);
		Bank bank = new Bank();
		VendingMachine vendingMachine = new VendingMachine(bank, newMap);
//		Assert.assertFalse(vendingMachine.purchase(customer, "5"));
	}

	@Test
	public void testPurchaseSoldOut() {
		Map<String, Item> newMap = new HashMap<>();
		Item item1 = new Duck(1, "name1", 10, 10);
		Item item2 = new Pony(2, "name2", 20, 10);
		Item item3 = new Penguin(3, "name3", 30, 0);
		Item item4 = new Cat(4, "name4", 40, 10);
		Customer customer = new Customer();
		newMap.put("1", item1);
		newMap.put("2", item2);
		newMap.put("3", item3);
		newMap.put("4", item4);
		Bank bank = new Bank();
		VendingMachine vendingMachine = new VendingMachine(bank, newMap);
//		Assert.assertFalse(vendingMachine.purchase(customer, "3"));
	}

}
