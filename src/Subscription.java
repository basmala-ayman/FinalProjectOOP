

public class Subscription {

    private int coachId;
    private int customerId;
    private MembershipPlan membershipPlan;

    public Subscription() {
//        this.coachId = 0;
//        this.customerId = 0;
//        this.membershipPlan = null;
    }

    public Subscription(int coachId, int customerId, MembershipPlan membershipPlan) {
        this.coachId = coachId;
        this.customerId = customerId;
        this.membershipPlan = membershipPlan;
    }

//    public void displaySubscriptionDetails() {
//        System.out.println("Subscription Details:");
//        System.out.println("Coach: " + coachId.getName());
//        System.out.println("Customer: " + customerId.getName());
//        System.out.print("Membership plan");
//        membershipPlan.displayInfo();
//    }


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

    public void subscriptionHistory(){
        System.out.println("Data\t\tMembership Plan"
                + "-----\t\t---------------");

    }

}


