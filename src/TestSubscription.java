
import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class TestSubscription {
	private Subscription subscription;
	private SubscriptionPlan subplan;
	Date date;
	
	@Before
	public void setUp() throws Exception {
		subplan = new SubscriptionPlan("subplan1");
		date = new SimpleDateFormat("dd/MM/yyyy").parse("2021/06/06");
		subscription = new Subscription(date, subplan);
	}

	@Test
	public void testGetSubscriptionPlan() {
		SubscriptionPlan result = subscription.getSubscriptionPlan();
		assertEquals(subplan, result);
	}
	
	@Test
	public void testSetSubscriptionPlan() {
		SubscriptionPlan subplan2 = new SubscriptionPlan("subplan2");
		subscription.setSubscriptionPlan(subplan2);
		assertEquals(subplan2,subscription.getSubscriptionPlan());
	}
	
	@Test 
	public void testGetSubscriptionStartDate() {
		Date result = subscription.getSubscriptionStartDate();
		assertEquals(date, result);
		
	}
	@Test 
	
	public void testSetSubscriptionStartDate() throws ParseException {
		Date startDate = new SimpleDateFormat("dd/MM/yyyy").parse("2020/10/30");
		subscription.setSubscriptionStartDate(startDate);
		assertEquals(startDate, subscription.getSubscriptionStartDate());
		
	}

}
