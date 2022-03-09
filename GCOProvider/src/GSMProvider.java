
import java.util.LinkedList;

public class GSMProvider implements ServiceProvider{

	private String name;
	private LinkedList<SubscriptionPlan> subscriptionPlans = new LinkedList<>();
	
	public GSMProvider(String name) {
		this.name = name;
	}
	
	@Override
	//USED TO REMOVE SUBSCRIPTION PLANS FROM THE LIST (EXTRA)
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
	//USED TO ADD SUBSCRIPTION PLANS
	public void addSubscriptionPlan(SubscriptionPlan subscriptionPlan) {
		subscriptionPlan.setServiceProvider(this);
		subscriptionPlans.add(subscriptionPlan);

	}

	@Override
	public SubscriptionPlan findSubscriptionPlan(String planName) {
		for(SubscriptionPlan sub:subscriptionPlans) {
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
