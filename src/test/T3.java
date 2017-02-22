package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class T3 {
	
	public static SimpleDateFormat yyyyMMddHHmmss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static String dhm = "ddHHmm";
	
	public static void main(String[] args) {
		T3 t3 = new T3();
		t3.go();
	}
	
	public void go() {
		String time = "";
		String nowTime = setTime();
		if(nowTime!=null)
		{
			System.out.println("nowTime:"+nowTime);
		SimpleDateFormat dateTrans=new SimpleDateFormat(dhm);
		Date dateTime = null;
		try {
			dateTime = yyyyMMddHHmmss.parse(nowTime);
			System.out.println("dateTime:"+dateTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		time = dateTrans.format(dateTime.getTime());
		}
		System.out.println("time :"+time);

	}
	
	public String setTime() {
		return getCurrentTime();
	}
	
	public  String getCurrentTime() {
		return yyyyMMddHHmmss.format(new Date());
	}

}
