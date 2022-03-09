
import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;

public class TestGSMProvider {

	private GSMProvider gsmProvider;
	private SubscriptionPlan subPlan1;
	
	@Before
	public void setUp() throws Exception {
		gsmProvider = new GSMProvider("turkcell");
		subPlan1 = new SubscriptionPlan("subplan1");
	}

	
	@org.junit.Test
	public void testGetName() {
		String result = gsmProvider.getName();
		assertEquals("turkcell", result);
	}
	
	@org.junit.Test
	public void testAddSubscription() {
		gsmProvider.addSubscriptionPlan(subPlan1);
		LinkedList<SubscriptionPlan> result = gsmProvider.getSubscriptionPlans();
		for(SubscriptionPlan sub:result) {
			assertEquals(subPlan1, sub);
		}	
	}
	
	@org.junit.Test
	public void testFindSubscription() {
		gsmProvider.addSubscriptionPlan(subPlan1);
		SubscriptionPlan result = gsmProvider.findSubscriptionPlan(subPlan1.getName());
		assertEquals(subPlan1.getName(), result.getName());
	}
	
	@org.junit.Test
	public void testSetName() {
		gsmProvider.setName("Türk Telekom");
		String result = gsmProvider.getName();
		assertEquals("Türk Telekom", result);
	}

}
