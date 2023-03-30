public class PriorityComparator implements Comparator {
    public boolean isEqualTo(Object item1, Object item2) {
        return ((FoodOrder) item1).getPriority() == ((FoodOrder) item2).getPriority();
    }
    public boolean isLessThan(Object item1, Object item2) {
        return ((FoodOrder) item1).getPriority() < ((FoodOrder) item2).getPriority();
    }
    public boolean isLessThanOrEqualTo(Object item1, Object item2) {
        return ((FoodOrder) item1).getPriority() <= ((FoodOrder) item2).getPriority();
    }
    public boolean isGreaterThan(Object item1, Object item2) {
        return ((FoodOrder) item1).getPriority() > ((FoodOrder) item2).getPriority();
    }
    public boolean isGreaterThanOrEqualTo(Object item1, Object item2) {
        return ((FoodOrder) item1).getPriority() >= ((FoodOrder) item2).getPriority();
    }
}