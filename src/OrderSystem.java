import java.util.InputMismatchException;
import java.util.Scanner;

// Class representing the order system
public class OrderSystem {
    // Scanner for user input
    private static Scanner sc = new Scanner(System.in);
    // Comparator for sorting orders
    private static Comparator comparator = new PriorityComparator();
    // LinkedList for storing orders
    private static LinkedList orders = new LinkedList(comparator);
    // Guest ID counter
    private static int nextGuestID = 9000;

    // Main method for the order system
    public static void main(String[] args) {
        while (true) {
            try {
                // Prompt user for member ID
                System.out.print("Please input your member ID [input 0 for guest]: ");
                int memberID = sc.nextInt();
                // If user enters -1, exit the program
                if (memberID == -1) {
                    System.out.println("Have a nice day!!!");
                    break;
                } else if (memberID == 0) {
                    // Input order as a guest
                    inputOrder(nextGuestID);
                } else if (memberID == 9999) {
                    // Access admin functions
                    adminFunc();
                } else if (memberID <= 8000 || memberID >= 9000) {
                    // Throw exception for invalid member ID
                    throw new InvalidInputException();
                } else {
                    // Input order as a member
                    inputOrder(memberID);
                }
            } catch (EmptyListException | InvalidInputException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                throw new InvalidRangeInputException();
            }
        }
    }

    // Method for inputting an order
    public static void inputOrder(int memberID) throws InvalidInputException {
        // Display food menu
        System.out.println("----------------- Food Menu ----------------");
        System.out.println("Set A : Chicken Salad");
        System.out.println("Set B : Grilled Ribeye Steak");
        System.out.println("Set C : Angel Hair Pasta with Shrimp");
        System.out.println("Set D : Grilled Fish and Potatoes");
        System.out.println("--------------------------------------------");
        System.out.print("Select food: ");
        String foodOrder = sc.next().toUpperCase();
        // Validate food order and add to the order list
        if (foodOrder.equals("A") || foodOrder.equals("B") || foodOrder.equals("C") || foodOrder.equals("D")){
            orders.add(new FoodOrder(memberID, foodOrder));
            // Increment guest ID if it's a guest order
            if (memberID == nextGuestID) {
                nextGuestID++;
            }
        } else {
            // Throw exception for invalid food order
            throw new InvalidInputException();
        }
    }

    // Method for admin functions
    public static void adminFunc() throws InvalidInputException {
        // Display admin menu
        System.out.println("----------------- Admin Function ----------------");
        System.out.println("1 : Print order list");
        System.out.println("2 : Remove order");
        System.out.print(">");
        int chooseFunction = sc.nextInt();
        // Perform the chosen admin function
        if (chooseFunction == 1) {
            // Print the order list and total outstanding orders
            System.out.println(orders);
            System.out.println("Total outstanding order:" + orders.count());
        } else if (chooseFunction == 2) {
            // Remove an order by member ID
            System.out.print("Enter Member ID: ");
            int MemberID = sc.nextInt();
            orders.remove(MemberID);
        } else {
            // Throw exception for invalid admin function choice
            throw new InvalidInputException();
        }
    }
}