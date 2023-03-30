public class FoodOrder {
	private int memberID;
	private String foodOrder; // A, B, C, or D
	private int priority;

    //constructor	
    public FoodOrder(int memberID, String foodOrder) {
        this.memberID = memberID;
        this.foodOrder = foodOrder;
        if (memberID > 8000 && memberID < 8200) {
            priority = 1;
        } else if (memberID >= 8200 && memberID < 9000) {
            priority = 2;
        } else if (memberID >= 9000){
            priority = 3;
        }
    }

    public int getMemberID() {
        return memberID;
    }

    public String getFoodOrder() {
        return foodOrder;
    }

    public int getPriority() {
        return priority;
    }

    public void setFoodOrder(String foodOrder) {
        this.foodOrder = foodOrder;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String toString() {
        return "[ MemberID: " + memberID + " ordered Set " + foodOrder + " with priority " + priority + " ]";
    }
}