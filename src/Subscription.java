public class Subscription {

    private int coachId;
    private int customerId;
    private MembershipPlan membershipPlan;

    public Subscription(){

    }

    public Subscription(int coachId, int customerId, MembershipPlan membershipPlan) {
        this.coachId = coachId;
        this.customerId = customerId;
        this.membershipPlan = membershipPlan;
    }

    public void setCoachId(int coachId) {
        this.coachId = coachId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setMembershipPlan(MembershipPlan membershipPlan) {
        this.membershipPlan = membershipPlan;
    }

    public int getCoachId() {
        return coachId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public MembershipPlan getMembershipPlan() {
        return membershipPlan;
    }

    public void displaySubscriptionDetails() {
        System.out.println("Coach ID: " + coachId);
        membershipPlan.displayInfo();
    }
}


