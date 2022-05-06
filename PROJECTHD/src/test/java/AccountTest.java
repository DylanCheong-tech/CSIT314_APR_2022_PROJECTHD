import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

import honeyzstar.entity.Account;
import honeyzstar.entity.Role;

public class AccountTest {
    private Account testAccount;

    @Before 
    public void init () throws Exception {
        this.testAccount = new Account();
    }

    @After 
    public void tearDown () throws Exception {
        this.testAccount = null;
    }

    @Test
    public void testCreateAccount (){
        // this.testAccount.setID(1);
        this.testAccount.setName("Test Create Account");
        this.testAccount.setUsername("testcreateusername");
        this.testAccount.setPassword("testcreatepassword");
        this.testAccount.setRole(new Role(2));

        assertTrue("Test User Admin Create Account", this.testAccount.createAccount());
    }

    @Test
    public void testSuspendAccount (){
        assertTrue("Test User Admin Suspend Account", Account.suspendAccount(30));
    }

    @Test 
    public void testUpdateAccount (){
        this.testAccount.setID(20);
        this.testAccount.setName("Test Update Account");
        this.testAccount.setUsername("testupdateusername");
        this.testAccount.setPassword("testupdatepassword");
        this.testAccount.setRole(new Role(3));

        assertTrue("Test User Admin Update Account", this.testAccount.updateAccount());
    }

    @Test
    public void testSearchAccount (){
        Account searchAccount = Account.searchAccount("Test Update Account");
        Account expectedAccount = new Account(20, "testupdateusername", "testupdatepassword", "Test Update Account", new Role(3, "Restaurant Owner", "This is Restaurant Owner"), "2022-04-30 20:44:56", "Suspended");

        assertEquals("Test User Admin Search Account", expectedAccount, searchAccount);
    }

    @Test 
    public void testGetAccount (){
        Account viewAccount = Account.getAccount(20);
        Account expectedAccount = new Account(20, "testupdateusername", "testupdatepassword", "Test Update Account", new Role(3, "Restaurant Owner", "This is Restaurant Owner"), "2022-04-30 20:44:56", "Suspended");

        assertEquals("Test User Admin View Account", expectedAccount, viewAccount);
    }

    @Test 
    public void testGetAccountList() {
        assertTrue("Test User Admin Get Account List", Account.getAccountList() instanceof ArrayList);
    }
}
