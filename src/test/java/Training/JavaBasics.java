package Training;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JavaBasics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date=new Date();
		//System.out.println(date.toString());
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String actDate = sdf.format(date);
		System.out.println(actDate);
		
		
		Calendar cal = sdf.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, 30);
		String dateRequires = sdf.format(cal.getTime());
		System.out.println(dateRequires);
		
		

	}

}
