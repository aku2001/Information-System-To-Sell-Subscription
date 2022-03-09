
import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

public class TestCableProvider {
	
	private CableProvider cableProvider;
	private SubscriptionPlan subPlan1;

	@Before
	public void setUp() throws Exception {
		cableProvider = new CableProvider("turkcell");
		subPlan1 = new SubscriptionPlan("subplan1");
	}

	
	@Test
	public void testGetName() {
		String result = cableProvider.getName();
		assertEquals("turkcell", result);
	}
	
	@Test
	public void testAddSubscription() {
		cableProvider.addSubscriptionPlan(subPlan1);
		LinkedList<SubscriptionPlan> result = cableProvider.getSubscriptionPlans();
		for(SubscriptionPlan sub:result) {
			assertEquals(subPlan1, sub);
		}	
	}
	
	@Test
	public void testFindSubscription() {
		cableProvider.addSubscriptionPlan(subPlan1);
		SubscriptionPlan result = cableProvider.findSubscriptionPlan(subPlan1.getName());
		assertEquals(subPlan1.getName(), result.getName());
	}
	
	@Test
	public void testSetName() {
		cableProvider.setName("Türk Telekom");
		String result = cableProvider.getName();
		assertEquals("Türk Telekom", result);
	}

}
