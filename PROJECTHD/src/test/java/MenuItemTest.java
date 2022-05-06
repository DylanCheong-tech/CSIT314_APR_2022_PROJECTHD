import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

import honeyzstar.entity.*;

public class MenuItemTest {
	private MenuItem testMenuItem;

    @Before 
    public void init () throws Exception {
        this.testMenuItem = new MenuItem();
    }

    @After 
    public void tearDown () throws Exception {
        this.testMenuItem = null;
    }

    @Test
    public void testCreateMenuItem(){
    	this.testMenuItem.setName("name1");
    	this.testMenuItem.setType(MenuItemType.Beverage);
    	this.testMenuItem.setPrice(5.4);
    	this.testMenuItem.setStatus(MenuItemStatus.Available);
    	this.testMenuItem.setDescriptions("this is a menu item");
    	
    	assertTrue("Test Restaurant Manager Create Menu Item", this.testMenuItem.createMenuItem());
    }
    
    @Test
    public void testDeleteMenuItem (){
    	this.testMenuItem.setMenuItemID(99);
    	this.testMenuItem.setName("testname1");
    	this.testMenuItem.setType(MenuItemType.MainCourse);
    	this.testMenuItem.setPrice(5.3);
    	this.testMenuItem.setStatus(MenuItemStatus.Available);
    	this.testMenuItem.setDescriptions("this is a test menu item");
    	
        assertTrue("Test Restaurant Manager Delete Menu Item", this.testMenuItem.deleteMenuItem());
    }
    
    @Test
    public void testUpdateMenuItem() {
    	this.testMenuItem.setMenuItemID(100);
    	this.testMenuItem.setName("testname1");
    	this.testMenuItem.setType(MenuItemType.MainCourse);
    	this.testMenuItem.setPrice(5.3);
    	this.testMenuItem.setStatus(MenuItemStatus.Available);
    	this.testMenuItem.setDescriptions("this is a test menu item");
    	
    	assertTrue("Test Restaurant Manager Update Menu Item", this.testMenuItem.updateMenuItem());
    }
    
    @Test 
    public void testSearchMenuItem (){
    	this.testMenuItem.setMenuItemID(109);
    	this.testMenuItem.setName("testname3");
    	this.testMenuItem.setType(MenuItemType.SideDish);
    	this.testMenuItem.setPrice(8.0);
    	this.testMenuItem.setStatus(MenuItemStatus.Unavailable);
    	this.testMenuItem.setDescriptions("this is a test menu item");

		MenuItem expectedMenuItem = new MenuItem(103, "testname4", MenuItemType.Beverage, 11.4, "this is a test menu item", MenuItemStatus.Available , "", "", "");

        assertEquals("Test User Admin Search Menu Item", expectedMenuItem, this.testMenuItem.searchMenuItem());
    }
    
    @Test 
    public void testGetMenuItem (){
    	this.testMenuItem.setMenuItemID(103);
    	this.testMenuItem.setName("testname4");
    	this.testMenuItem.setType(MenuItemType.Beverage);
    	this.testMenuItem.setPrice(11.4);
    	this.testMenuItem.setStatus(MenuItemStatus.Available);
    	this.testMenuItem.setDescriptions("this is a test menu item");

		MenuItem expectedMenuItem = new MenuItem(103, "testname4", MenuItemType.Beverage, 11.4, "this is a test menu item", MenuItemStatus.Available , "", "", "");

        assertEquals("Test User Admin View Menu Item", expectedMenuItem, this.testMenuItem.getMenuItem());
    }
    
    @Test 
    public void testGetMenuItemList() {
        assertTrue("Test Restaurant Manager Get Menu Item List", MenuItem.getMenuItemList() instanceof ArrayList);
    }
}
