import java.util.Scanner;

public class OrderSystem {
	private static Scanner sc = new Scanner(System.in);
    private static Comparator comparator = new PriorityComparator();
	private static LinkedList orders = new LinkedList(comparator);
	private static int nextGuestID = 9000;

    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println("Please input your member ID [input 0 for guest]:");
                int memberID = sc.nextInt();
                if (memberID == -1) {
                    System.out.println("Have a nice day!!!");
                    break;
                } else if (memberID == 0) {
                    inputOrder(nextGuestID);
                    nextGuestID++;
                } else if (memberID == 9999) {
                    adminFunc();
                } else if (memberID <= 8000 || memberID >= 9000) {
                    System.out.println("Invalid input! Please input again.");
                } else {
                    inputOrder(memberID);
                }
            } catch (Exception e) {
                throw new InvalidRangeInputException();
            }
        }
    }

    public static void inputOrder(int memberID) throws InvalidRangeInputException {
        System.out.println("----------------- Food Menu ----------------");
        System.out.println("Set A : Chicken Salad");
        System.out.println("Set B : Grilled Ribeye Steak");
        System.out.println("Set C : Angel Hair Pasta with Shrimp");
        System.out.println("Set D : Grilled Fish and Potatoes");
        System.out.println("--------------------------------------------");
        System.out.println("Select food:");
        String foodOrder = sc.next().toUpperCase();
        try {
            if (foodOrder.equals("A") || foodOrder.equals("B") || foodOrder.equals("C") || foodOrder.equals("D")){
                orders.add(new FoodOrder(memberID, foodOrder));
            } else {
                System.out.println("Invalid input! Please input again.");
            }
        } catch (Exception e) {
            throw new InvalidRangeInputException();
        }
    }

    public static void adminFunc() throws InvalidRangeInputException {
        System.out.println("----------------- Admin Function ----------------");
    }
}