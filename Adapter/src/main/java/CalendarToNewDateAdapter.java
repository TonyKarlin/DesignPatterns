import java.util.Calendar;

public class CalendarToNewDateAdapter implements NewDateInterface {
    Calendar calendar = Calendar.getInstance();

    @Override
    public void setDay(int day) {
        int month = calendar.get(Calendar.MONTH) + 1;
        if (day > 31) {
            System.out.println("Days cannot exceed 31");
            return;
        }
        calendar.set(Calendar.DATE, day);
    }

    @Override
    public void setMonth(int month) {
        if (month > 12) {
            System.out.println("Month cannot exceed 12");
            return;
        }
        calendar.set(Calendar.MONTH, month);
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
}
