import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;

public class EmployerListTest {
    private EmployerList employers = EmployerList.getInstance();
    private ArrayList<Employer> employerList = employers.getEmployers();

    @Before
    public void setup() {
        employerList.clear();
        employerList.add(new Employer("anaboca", "1234567"));
        employerList.add(new Employer("asteger", "codykolover"));
        DataWriter.saveEmployers();
    }

    @After
    public void tearDown() {
        EmployerList.getInstance().getEmployers().clear();
        DataWriter.saveEmployers();
    }

    @Test
    public void testHaveEmployerValidFirstItem() {
        boolean hasAna = employers.haveEmployer("anaboca");
        assertTrue(hasAna);
    }

    @Test
    public void testHaveEmployerValidLastItem() {
        boolean hasAdam = employers.haveEmployer("asteger");
        assertTrue(hasAdam);
    }

    @Test
	public void testHaveEmployerInValid() {
		boolean hasJoe = employers.haveEmployer("jsmith");
		assertFalse(hasJoe);
	}
	
	@Test
	public void testHaveEmployerEmpty() {
		boolean hasEmpty = employers.haveEmployer("");
		assertFalse(hasEmpty);
	}
	
	@Test
	public void testHaveEmployerNull() {
		boolean hasNull = employers.haveEmployer(null);
		assertFalse(hasNull);
	}

    // @Test
    // public void testGetAdminByUUID() {
        
    // }

    // TODO test get admin by title
    // TODO test get admin by user
    // TODO test get admin by id
    // TODO test add employer
}
