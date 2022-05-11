import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.sql.*;

import honeyzstar.entity.Order;
import honeyzstar.entity.OrderStatus;
import honeyzstar.entity.Account;
import honeyzstar.entity.MenuItem;

import java.io.*;
import java.util.Scanner;

public class OrderTestDataGenerator {
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {

			Random rn = new Random();
			int randomQuantity = rn.nextInt(10) + 1 ;
			int randomMenuItemID = rn.nextInt(100) + 1 ;
			int randomNumberOfItems = rn.nextInt(14) + 2 ;
			int randomStaff = rn.nextInt(20) + 1 ;
			int randomTableNum = rn.nextInt(50) + 1 ;
			
			Account acc = new Account();
	    	acc.setID(randomStaff);
			
			Order order = new Order();
			order.setTableNum(randomTableNum);
			order.setCreatedBy(acc);
			
			HashMap<Integer, Integer> menuItems = new HashMap<Integer, Integer>();
			for(int j = 0; j < randomNumberOfItems; j++) {
				menuItems.put(randomMenuItemID, randomQuantity);
			}
			
			order.setOrderItems(menuItems);
			
			order.createOrder();
		}
	}
}
