import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarAdapter {
	private Calendar calendar = new GregorianCalendar();
	
	public CalendarAdapter() {
	
	}

	public int getHour() {
		return calendar.get(Calendar.HOUR_OF_DAY);
	}

	public int getMinute() {
		return calendar.get(Calendar.MINUTE);
	}

	public int getSecond() {
		return calendar.get(Calendar.SECOND);
	}

}
