
import java.util.LinkedList;

public class CableProvider implements ServiceProvider{

	private String name;
	private LinkedList<SubscriptionPlan> subscriptionPlans = new LinkedList<>();
	
	public CableProvider(String name) {
		this.name = name;
	}

	
	@Override
	public boolean removeSubscriptionPlan(String subscriptionPlanName) {
		for(SubscriptionPlan subPlan:subscriptionPlans) {
			if(subPlan.getName().equalsIgnoreCase(subscriptionPlanName)) {
				subscriptionPlans.remove(subPlan);
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void addSubscriptionPlan(SubscriptionPlan subscriptionPlan) {
		subscriptionPlan.setServiceProvider(this);
		subscriptionPlans.add(subscriptionPlan);

	}

	@Override
	public SubscriptionPlan findSubscriptionPlan(String planName) {
		for(SubscriptionPlan sub:subscriptionPlans) {
			System.out.printf("Asked Plan: %s: Checked Plan: %s\n",planName,sub.getName());
			if(sub.getName().equalsIgnoreCase(planName)) {
				return sub;
			}
		}
		return null;
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
		// TODO Auto-generated method stub
		
	}

	public LinkedList<SubscriptionPlan> getSubscriptionPlans() {
		return subscriptionPlans;
	}	
}
