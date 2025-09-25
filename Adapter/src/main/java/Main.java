public class Main {
    public static void main(String[] args) {
        NewDateInterface date = new CalendarToNewDateAdapter();

        System.out.println("Initial Date:");
        System.out.println(date.getDate());

        System.out.println("\nSetting month to 2 (February) and day to 30 (invalid)...");
        date.setYear(2026);
        date.setMonth(2);
        date.setDay(30); // Displays error message for setting invalid day for February
        System.out.println(date.getDate());

        System.out.println("\nAdvancing the date by 15 days...");
        date.advanceDays(15);

        System.out.println("Updated Date:");
        System.out.println(date.getDate());
    }
}
