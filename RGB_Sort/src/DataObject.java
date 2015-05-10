/* Author SoMi Choi
*  Research ME497
*  Date 4/15/2015
*  QuickSort
*/

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class DataObject {
		private Location place;
		private String date;	//formatted as yyyy-MM-dd
		private String time;	//formatted as HH:mm:ss
		private String RGB;		//formatted as R:G:B:H:S:V 
		private int R,G,B,H,S,V;
		public static String flag_RGB = "B";		//R or G or B or H or S or V
		private static String flag_order = "desc";	//desc or asce
		
		public DataObject(Location place, Date date, Date time, String RGB){
			DateFormat date_format, time_format; //exists for formatting date
			String[]parts;			//exists for splitting string RGB value
			this.place = place;
			
			date_format = new SimpleDateFormat("yyyy-MM-dd");
	    	time_format = new SimpleDateFormat("HH:mm:ss");
			this.date = date_format.format(date);
			this.time = time_format.format(time);
			
			this.RGB = RGB;
			
	    	
			parts = RGB.split(":");
			R = Integer.parseInt(parts[0]);
			G = Integer.parseInt(parts[1]);
			B = Integer.parseInt(parts[2]);
			H = Integer.parseInt(parts[3]);
			S = Integer.parseInt(parts[4]);
			V = Integer.parseInt(parts[5]);
			
		}
	public String toString(){
		return "Place: "+place.getName() + " Time:" + "( " + getDate() + " " + getTime() + " )" 
	+ "R:"+R +" "+ "G:"+G +" "+ "B:"+ B +" "+ "H:"+ H +" "+ "S:"+ S +" "+ "V:"+ V+ "\n" ;
	}
	public String getDate() {
			return date;
		}
	public String getTime() {
			return time;
	}
	public Location getPlace(){
			return place;
	}
	public String getRGB(){
		return RGB;
	}
	public int getR(){
		return R;
	}
	public int getG(){
		return G;
	}
	public int getB(){
		return B;
	}
	public int getH(){
		return H;
	}
	public int getS(){
		return S;
	}
	public int getV(){
		return V;
	}
	// test client

	
	//method 2 commented out
/*
	public static Comparator<DataObject> placeNameComparator = new Comparator <DataObject>(){

		public int compare(DataObject obj1, DataObject obj2) {
			String name1 = obj1.getPlace().getName().toUpperCase();
			String name2 = obj2.getPlace().getName().toUpperCase();

			//ascending order
			return name1.compareTo(name2);

			//descending order
			//return StudentName2.compareTo(StudentName1);
		}
	};


	public static Comparator<DataObject> dateComparator = new Comparator <DataObject>(){

		public int compare(DataObject obj1, DataObject obj2) {
			String[]parts1;
			String[]parts2;
			String name1 = "2016-05-19"; //exist temporary 
			String name2 = "2016-05-31";
			int year1,month1,date1;
			int year2,month2,date2;
			int ret; 			//value storing for return

			//parsing operation

			parts1 = name1.split("-");
			parts2 = name2.split("-");

			year1 = Integer.parseInt(parts1[0]);
			month1 = Integer.parseInt(parts1[1]);
			date1 = Integer.parseInt(parts1[2]);

			year2 = Integer.parseInt(parts2[0]);
			month2 = Integer.parseInt(parts2[1]);
			date2 = Integer.parseInt(parts2[2]);

			if(year1 == year2){
				if(month1 == month2){
					if(date1 == date2){
						return 0;
					}else{
						ret = date1 - date2;
					}
				}else{
					ret = month1 - month2;
				}
			}else{
				ret = year1 - year2;	
			}
			
			if(flag_order.equals("asce")){
				return ret;			//recent to older
			}else{ 				//if(flag_order.equals("desc")){
				return -ret;		//older to recent
			}
		}
	};

	public static Comparator<DataObject> timeComparator = new Comparator <DataObject>(){

		public int compare(DataObject obj1, DataObject obj2) {
			String[]parts1;
			String[]parts2;
			String name1 = "04:06:47"; //exist temporary 
			String name2 = "04:06:49";
			int hour1,minute1,second1;
			int hour2,minute2,second2;
			int ret;
			//parsing operation

			parts1 = name1.split(":");
			parts2 = name2.split(":");

			hour1 = Integer.parseInt(parts1[0]);
			minute1 = Integer.parseInt(parts1[1]);
			second1 = Integer.parseInt(parts1[2]);

			hour2 = Integer.parseInt(parts2[0]);
			minute2 = Integer.parseInt(parts2[1]);
			second2 = Integer.parseInt(parts2[2]);

			if(hour1 == hour2){
				if(minute1 == minute2){
					if(second1 == second2){
						ret = 0;
					}else{
						ret = second1 - second2;
					}
				}else{
					ret = minute1 - minute2;
				}
			}else{
				ret = hour1 - hour2;	
			}
			
			if(flag_order.equals("asce")){
				return ret;			//late time (night) to earlier time
			}else{ 				//if(flag_order.equals("desc")){
				return -ret;		//earlier time to late time (night)
			}
		}
	};

	public static Comparator<DataObject> RGBComparator = new Comparator <DataObject>(){
		
		public int compare(DataObject obj1, DataObject obj2) {
			int value1, value2;

			switch(flag_RGB){
			case "R":
				value1 = obj1.getR();
				value2 = obj2.getR();
				break;
			case "G":
				value1 = obj1.getG();
				value2 = obj2.getG();
				break;
			case "B":
				value1 = obj1.getB();
				value2 = obj2.getB();
				break;
			case "H":
				value1 = obj1.getH();
				value2 = obj2.getH();
				break;
			case "S":
				value1 = obj1.getS();
				value2 = obj2.getS();
				break;
			case "V":
				value1 = obj1.getV();
				value2 = obj2.getV();
				break;
			default:
				value1 = 0;			//will handle exception later
				value2 = 0;
				break;
			}
			
			if(flag_order.equals("asce")){
				return Integer.valueOf(value1).compareTo(Integer.valueOf(value2));
			}else{ 				//if(flag_order.equals("desc")){
				return Integer.valueOf(value2).compareTo(Integer.valueOf(value1));
			}
			//descending order
			//return StudentName2.compareTo(StudentName1);
		}
	};
*/
}
