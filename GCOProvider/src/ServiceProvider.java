

public interface ServiceProvider {
	
	public void addSubscriptionPlan(SubscriptionPlan subscriptionPlan);
	public SubscriptionPlan findSubscriptionPlan(String planName);
	public String getName();
	public void setName(String name);
	boolean removeSubscriptionPlan(String subscriptionPlanName);
	
}
