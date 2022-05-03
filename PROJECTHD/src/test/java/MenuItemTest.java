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
    	this.testMenuItem.setType(Type.Beverage);
    	this.testMenuItem.setPrice(5.4);
    	this.testMenuItem.setStatus(Status.Available);
    	this.testMenuItem.setDescriptions("this is a menu item");
    	
    	assertTrue("Test Restaurant Manager Create Menu Item", this.testMenuItem.createMenuItem());
    }
    
    @Test
    public void testDeleteMenuItem (){
    	this.testMenuItem.setMenuItemID(99);
    	this.testMenuItem.setName("testname1");
    	this.testMenuItem.setType(Type.MainCourse);
    	this.testMenuItem.setPrice(5.3);
    	this.testMenuItem.setStatus(Status.Available);
    	this.testMenuItem.setDescriptions("this is a test menu item");
    	
        assertTrue("Test Restaurant Manager Delete Menu Item", this.testMenuItem.deleteMenuItem());
    }
    
    @Test
    public void testUpdateMenuItem() {
    	this.testMenuItem.setMenuItemID(100);
    	this.testMenuItem.setName("testname1");
    	this.testMenuItem.setType(Type.MainCourse);
    	this.testMenuItem.setPrice(5.3);
    	this.testMenuItem.setStatus(Status.Available);
    	this.testMenuItem.setDescriptions("this is a test menu item");
    	
    	assertTrue("Test Restaurant Manager Update Menu Item", this.testMenuItem.updateMenuItem());
    }
}
