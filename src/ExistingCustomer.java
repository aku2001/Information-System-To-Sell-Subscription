

public class ExistingCustomer extends Customer {

	private Subscription subscription;
	
	public ExistingCustomer(String citizenshipNr) {
		super(citizenshipNr);
	}

	public ExistingCustomer(String citizenshipNr, Subscription subscription) {
		super(citizenshipNr);
		this.subscription = subscription;
	}

	public Subscription getSubscription() {
			return subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}

	@Override
	public String toString() {
		return ("CUSTOMER CITIZENSHIP NUMBER = "+ super.getCitizenshipNr()+
				"\nCUSTOMER NAME = "+super.getName()+"\nSERVICE PROVIDER: "+
				subscription.getSubscriptionPlan().getServiceProvider()+
				"\nSUBSCRIPTION START DATE: "+subscription.getSubscriptionStartDate()+
				"\nSUBSCRIPTION PLAN NAME: "+ subscription.getSubscriptionPlan().getName());
	}
	
	
	
	
}
