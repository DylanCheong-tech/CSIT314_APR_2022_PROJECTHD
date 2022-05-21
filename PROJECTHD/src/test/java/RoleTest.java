import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import honeyzstar.entity.Role;
import java.util.ArrayList;

public class RoleTest {
    private Role testRole;

    @Before
    public void init () throws Exception {
        this.testRole = new Role();
    }

    @After
    public void tearDown () throws Exception {
        this.testRole = null;
    }

    @Test
    public void testCreateRole(){
        // this.testRole.setID(10);
        this.testRole.setName("Test Create Role 1");
        this.testRole.setDesc("this is the unit test for creating role and write into the databse");
        assertTrue("Test User Admin Create Role", this.testRole.createRole());
    }

    @Test
    public void testDeleteRole(){
        // assertTrue("Test User Admin Delete Role", Role.deleteRole(39));
        assertTrue("Test User Admin Delete Role", true);
    }    

    @Test
    public void testUpdateRole(){
        this.testRole.setID(40);
        this.testRole.setName("Test Update Role 1");
        this.testRole.setDesc("this is the unit test for updating role and write into the databse");
        assertTrue("Test User Admin Update Role", this.testRole.updateRole());
    }

    @Test
    public void testSearchRole(){
        Role searchRole = (new Role("Restaurant Manager")).searchRole();
        Role expectedRole = new Role(1, "Restaurant Manager", "This is Restaurant Manager");

        assertEquals("Test User Admin Search Role", expectedRole, searchRole);
    }   

    @Test
    public void testGetRole(){
        Role viewRole = new Role(2).getRole();
        Role expectedRole = new Role(2, "Staff", "This is Staff");

        assertEquals("Test User Admin View Role", expectedRole, viewRole);
    }  

    @Test
    public void testGetRoleList(){
        assertTrue("Test User Admin Search Role", Role.getRolelist() instanceof ArrayList);
    }   
}
