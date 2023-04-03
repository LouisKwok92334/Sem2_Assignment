import java.util.InputMismatchException;
import java.util.Scanner;

public class OrderSystem {
    private static Scanner sc = new Scanner(System.in);
    private static Comparator comparator = new PriorityComparator();
    private static LinkedList orders = new LinkedList(comparator);
    private static int nextGuestID = 9000;

    public static void main(String[] args) {
        while (true) {
            try {
                System.out.print("Please input your member ID [input 0 for guest]: ");
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
                    throw new InvalidInputException();
                } else {
                    inputOrder(memberID);
                }
            } catch (EmptyListException e) {
                System.out.println(e.getMessage());
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            } catch (InvalidRangeInputException e) {
                System.out.println(e.getMessage());
                break;
            } catch (Exception e) {
                throw new InvalidRangeInputException();
                break;
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
        if (memberID == 0) {
            inputOrder(nextGuestID);
            nextGuestID++;
        }
        try {
            System.out.print("Select food: ");
            String foodOrder = sc.next().toUpperCase();
            if (foodOrder.equals("A") || foodOrder.equals("B") || foodOrder.equals("C") || foodOrder.equals("D")){
                orders.add(new FoodOrder(memberID, foodOrder));
            } else {
                System.out.println("Invalid input! Please input again.");
            }
        } catch (Exception e) {
            throw new InvalidRangeInputException();
        }
    }

    public static void adminFunc() throws EmptyListException {
        System.out.println("----------------- Admin Function ----------------");
        System.out.println("1 : Print order list");
        System.out.println("2 : Remove order");
        System.out.print(">");
        try {
            int chooseFunction = sc.nextInt();
            if (chooseFunction == 1) {
                System.out.println(orders);
                System.out.println("Total outstanding order:" + orders.count());
            } else if (chooseFunction == 2) {
                System.out.print("Enter Member ID: ");
                int MemberID = sc.nextInt();
                orders.remove(MemberID);
            } else {
                System.out.println("Invalid input! Please input again.");
            }
        } catch (Exception e) {
            throw new EmptyListException();
        }
    }
}