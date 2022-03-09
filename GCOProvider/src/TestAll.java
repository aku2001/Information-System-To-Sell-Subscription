
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestCableProvider.class, TestExistingCustomer.class, TestGSMProvider.class, TestPossibleCustomer.class,
		TestSubscription.class, TestSubscriptionPlan.class })
public class TestAll {

}
