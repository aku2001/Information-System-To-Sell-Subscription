
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestSubscriptionPlan {
	private SubscriptionPlan subplanWithoutProvider;
	private SubscriptionPlan subplanWithProvider;
	private GSMProvider gsmProvider;

	@Before
	public void setUp() throws Exception {
		gsmProvider = new GSMProvider("Türk Telekom");
		subplanWithoutProvider = new SubscriptionPlan("subplanWithoutProvider");
		subplanWithProvider = new SubscriptionPlan("subplanWithProvider",gsmProvider);
	}

	@Test
	public void testGetName() {
		String result = subplanWithoutProvider.getName();
		assertEquals("subplanWithoutProvider", result);

	}
	
	@Test
	public void testSetName() {
		subplanWithoutProvider.setName("subplan1");
		assertEquals("subplan1", subplanWithoutProvider.getName());
	}
	
	@Test
	public void testGetServiceProvider(){
		GSMProvider result = (GSMProvider) subplanWithProvider.getServiceProvider();
		assertEquals(gsmProvider, result);
	}
	
	@Test
	public void testSetServiceProvider(){
		subplanWithoutProvider.setServiceProvider(gsmProvider);
		assertEquals(gsmProvider, subplanWithoutProvider.getServiceProvider());
	}

}
