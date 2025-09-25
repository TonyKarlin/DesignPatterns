import java.util.Calendar;

public class CalendarToNewDateAdapter implements NewDateInterface {
    Calendar calendar = Calendar.getInstance();

    @Override
    public void setDay(int day) {
        int month = calendar.get(Calendar.MONTH) + 1;
        int year = calendar.get(Calendar.YEAR);
        int maxDays = getMaxDaysInMonth(month, year);

        if (day < 1 || day > maxDays) {
            System.out.println("Invalid day. Must be between 1 and " + maxDays + " for the current month and year.");
            return;
        }
        calendar.set(Calendar.DATE, day);
    }

    @Override
    public void setMonth(int month) {
        if (month < 1 || month > 12) {
            System.out.println("Invalid month. Must be between 1 and 12.");
            return;
        }
        calendar.set(Calendar.MONTH, month - 1);
    }

    @Override
    public void setYear(int year) {
        calendar.set(Calendar.YEAR, year);
    }

    @Override
    public int getDay() {
        return calendar.get(Calendar.DATE);
    }

    @Override
    public int getMonth() {
        return calendar.get(Calendar.MONTH) + 1; // Month returns January as 0 so we add 1 to current Month.
    }

    @Override
    public int getYear() {
        return calendar.get(Calendar.YEAR);
    }

    @Override
    public void advanceDays(int days) {
        calendar.add(Calendar.DATE, days);
    }

    @Override
    public String getDate() {
        return "Date: " + getDay() + "/" + getMonth() + "/" + getYear();
    }

    private int getMaxDaysInMonth(int month, int year) {
        Calendar tempCalendar = Calendar.getInstance();
        tempCalendar.set(Calendar.YEAR, year);
        tempCalendar.set(Calendar.MONTH, month - 1); // Calendar months are 0-based
        return tempCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
}
