import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.HashMap;

import honeyzstar.entity.*;

public class OrderTest {
	private Order testOrder;

    @Before 
    public void init () throws Exception {
        this.testOrder = new Order();
    }

    @After 
    public void tearDown () throws Exception {
        this.testOrder = null;
    }

    @Test
    public void testCreateOrder(){
    	Account acc = new Account();
    	acc.setID(4);
    	this.testOrder.setStatus(OrderStatus.Ongoing);
		this.testOrder.setTotalAmount(43.4);
		this.testOrder.setTableNum(4);
		this.testOrder.setCreatedBy(acc);
    	
    	assertTrue("Test Staff Create Order", this.testOrder.createOrder());
    }
	
	@Test
    public void testDeleteOrder (){
		this.testOrder.setOrderID(4);
    	this.testOrder.setStatus(OrderStatus.Created);
		this.testOrder.setTotalAmount(43.4);
		this.testOrder.setTableNum(4);
    	
        assertTrue("Test Staff Delete Order", this.testOrder.deleteOrder());
    }
	
	@Test
    public void testUpdateOrder() {
		Account acc = new Account();
    	acc.setID(4);
		
		this.testOrder.setOrderID(45);
    	this.testOrder.setStatus(OrderStatus.Paid);
		this.testOrder.setTotalAmount(43.4);
		this.testOrder.setTableNum(4);
		this.testOrder.setCreatedBy(acc);

    	
    	assertTrue("Test Staff Update Order", this.testOrder.updateOrder());
    }
	
	@Test 
    public void testSearchMenuItem (){
		Account acc = new Account();
    	acc.setID(4);
		
		this.testOrder.setOrderID(45);
    	this.testOrder.setStatus(OrderStatus.Ongoing);
		this.testOrder.setTotalAmount(44.3);
		this.testOrder.setTableNum(4);
		this.testOrder.setCreatedBy(acc);

		Order expectedOrder = new Order(4, "2022-05-05 18:27:00", null, OrderStatus.Ongoing, 48.4, 4,acc);

        assertEquals("Test Staff Search Order", expectedOrder, this.testOrder.searchOrder());
    }
	
	@Test 
    public void testGetMenuItem (){
		Account acc = new Account();
    	acc.setID(4);
		
		this.testOrder.setOrderID(45);
    	this.testOrder.setStatus(OrderStatus.Paid);
		this.testOrder.setTotalAmount(44.3);
		this.testOrder.setTableNum(4);
		this.testOrder.setCreatedBy(acc);


		Order expectedOrder = new Order(4, "2022-05-05 18:27:00", null, OrderStatus.Paid, 48.4, 4, acc);

        assertEquals("Test Staff View Order", expectedOrder, this.testOrder.getOrder());
    }
	
	@Test 
    public void testGetOrderList() {
        assertTrue("Test Staff Get Order List", Order.getOrderList() instanceof ArrayList);
    }
	
	@Test 
    public void testGetOrderMenuItemList() {
        assertTrue("Test Staff Get Order Menu Item List", Order.getOrderMenuItemList() instanceof HashMap);
    }
}