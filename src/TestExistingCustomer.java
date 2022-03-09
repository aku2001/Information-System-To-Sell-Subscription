
import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class TestExistingCustomer {
	private ExistingCustomer customer1,customer2;
	private Subscription subscription;
	private SubscriptionPlan subplan;
	@Before
	public void setUp() throws Exception {
		subplan = new SubscriptionPlan("subplan1");
		subscription = new Subscription(new Date(), subplan);
		customer1 = new ExistingCustomer("123456789");
		customer2 = new ExistingCustomer("987654321",subscription);
	}

	@Test
	public void testGetSubscription() {
		Subscription result1 = customer2.getSubscription();
		Subscription result2 = customer1.getSubscription();
		assertEquals(subscription, result1);
		assertEquals(null, result2);
	}
	
	@Test
	public void testSetSubscription() {
		customer1.setSubscription(subscription);
		Subscription result = customer1.getSubscription();
		assertEquals(subscription, result);
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

}
