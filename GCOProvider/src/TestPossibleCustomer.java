
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestPossibleCustomer {

	private PossibleCustomer customer1;

	
	@Before
	public void setUp() throws Exception {
		customer1 = new PossibleCustomer("123456789");
	}

	
	@Test
	public void testGetCitizenshipNr() {
		String result = customer1.getCitizenshipNr();
		assertEquals("123456789",result);
	}
	
	@Test
	public void testSetCitizenshipNr() {
		customer1.setCitizenshipNr("098765432");
		String result = customer1.getCitizenshipNr();
		assertEquals("098765432",result);
	}
	
	@Test
	public void testSetAndGetName() {
		customer1.setName("customer1");
		String result = customer1.getName();
		assertEquals("customer1",result);
	}
	
	@Test
	public void testSetAndGetMail() {
		customer1.setMail("HelloWorld@gmail.com");
		String result = customer1.getMail();
		assertEquals("HelloWorld@gmail.com",result);
	}
	
	@Test
	public void testSetAndGetTel() {
		customer1.setTel("05078346752");
		String result = customer1.getTel();
		assertEquals("05078346752",result);
	}

}
