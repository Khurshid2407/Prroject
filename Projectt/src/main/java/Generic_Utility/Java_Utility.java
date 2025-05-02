package Generic_Utility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Java_Utility {
	
	public int getRandomNumber()
	{
		Random ran=new Random();
		int ranNo = ran.nextInt(2000);
		return ranNo;
	}
	
	public String getSystemDateYYYYMMDD()
	{
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
		String date = sdf.format(d);
		return date;	
	}
	
	public String getRequiredDateYYYYMMDD(int days)
	{
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
		sdf.format(d);
		Calendar cal = sdf.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,days);
		String reqDate = sdf.format(cal.getTime());
		return reqDate;
		
	}
	
	public String getCalendarDetails(String pattern) 
	{
		Calendar cal = Calendar.getInstance();
		Date d  = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String value = sdf.format(d);
		return value;
	}
	

}
