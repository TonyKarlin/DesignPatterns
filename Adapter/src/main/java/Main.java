public class Main {
    public static void main(String[] args) {
        NewDateInterface date = new CalendarToNewDateAdapter();
        System.out.println("Year: " + date.getYear());
        System.out.print("Current month: " + date.getMonth() + ", ");
        System.out.println("Day: " + date.getDay());
        date.advanceDays(15);
        System.out.print("Current month: " + date.getMonth() + ", ");
        System.out.println("Day: " + date.getDay());
    }
}
