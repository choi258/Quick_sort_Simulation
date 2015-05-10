/* Author SoMi Choi
*  Research ME497
*  Date 4/15/2015
*  QuickSort
*/


import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/*
 * ascending = Name: alphabetical Date: old to recent 
 * descending = Name: reversed alphabetical Date: recent to old 
 * 
 */

public class Sort {
	static List<DataObject> list = new ArrayList<DataObject>(); // list for
																// simulation
																// testing

	public void sortList(List<DataObject> list, String sort_type,
			String order_by) {

		String ig_sort_type; // ignore lower, upper case

		ig_sort_type = sort_type.toUpperCase();

		switch (ig_sort_type) {
		case "NAME":
			if (order_by.equalsIgnoreCase("asce")) {
				Collections.sort(list, sortNameAsce);
			} else {
				Collections.sort(list, sortNameDesc);
			}
			break;
		case "TIME": // sort by time
			if (order_by.equalsIgnoreCase("asce")) {
				Collections.sort(list, sortTimeAsce);
			} else {
				Collections.sort(list, sortTimeDesc);
			}
			break;
		case "R":

			if (order_by.equalsIgnoreCase("asce")) {
				Collections.sort(list, sortRAsce);
			} else {
				Collections.sort(list, sortRDesc);
			}
			break;
		case "G":

			if (order_by.equalsIgnoreCase("asce")) {
				Collections.sort(list, sortGAsce);
			} else {
				Collections.sort(list, sortGDesc);
			}
			break;
		case "B":
			if (order_by.equalsIgnoreCase("asce")) {
				Collections.sort(list, sortBAsce);
			} else {
				Collections.sort(list, sortBDesc);
			}
			break;
		default:
			throw new IllegalArgumentException("Invalid sort type");
		}
	}

	public static Comparator<DataObject> sortNameAsce = new Comparator<DataObject>() {

		public int compare(DataObject d1, DataObject d2) {
			String Name1 = d1.getPlace().getName();
			String Name2 = d2.getPlace().getName();

			return Name1.compareTo(Name2);

		}
	};
	public static Comparator<DataObject> sortNameDesc = new Comparator<DataObject>() {

		public int compare(DataObject d1, DataObject d2) {
			String Name1 = d1.getPlace().getName();
			String Name2 = d2.getPlace().getName();

			return Name2.compareTo(Name1);

		}
	};

	public static Comparator<DataObject> sortTimeAsce = new Comparator<DataObject>() {

		public int compare(DataObject d1, DataObject d2) {
			String date_val1 = d1.getDate();
			String date_val2 = d2.getDate();
			String time_val1 = d1.getTime();
			String time_val2 = d2.getTime();
			int val;
			if ((timeCompare(date_val1, date_val2, "date") == 1)
					|| ((timeCompare(date_val1, date_val2, "date") == 0) && (timeCompare(
							time_val1, time_val2, "time") == 1))) {
				val = 1;
			} else {
				val = -1;
			}
			return val;

		}
	};
	public static Comparator<DataObject> sortTimeDesc = new Comparator<DataObject>() {

		public int compare(DataObject d1, DataObject d2) {
			String date_val1 = d1.getDate();
			String date_val2 = d2.getDate();
			String time_val1 = d1.getTime();
			String time_val2 = d2.getTime();
			int val;
			if ((timeCompare(date_val2, date_val1, "date") == 1)
					|| ((timeCompare(date_val2, date_val1, "date") == 0) && (timeCompare(
							time_val2, time_val1, "time") == 1))) {
				val = 1;
			} else {
				val = -1;
			}
			return val;

		}
	};

	public static Comparator<DataObject> sortRAsce = new Comparator<DataObject>() {

		public int compare(DataObject d1, DataObject d2) {
			int val1, val2;
			val1 = d1.getR();
			val2 = d2.getR();
			return val1 - val2;
		}
	};

	public static Comparator<DataObject> sortRDesc = new Comparator<DataObject>() {

		public int compare(DataObject d1, DataObject d2) {
			int val1, val2;
			val1 = d1.getR();
			val2 = d2.getR();
			return val2 - val1;
		}
	};
	public static Comparator<DataObject> sortGAsce = new Comparator<DataObject>() {

		public int compare(DataObject d1, DataObject d2) {
			int val1, val2;
			val1 = d1.getG();
			val2 = d2.getG();
			return val1 - val2;
		}
	};

	public static Comparator<DataObject> sortGDesc = new Comparator<DataObject>() {

		public int compare(DataObject d1, DataObject d2) {
			int val1, val2;
			val1 = d1.getG();
			val2 = d2.getG();
			return val2 - val1;
		}
	};
	public static Comparator<DataObject> sortBAsce = new Comparator<DataObject>() {

		public int compare(DataObject d1, DataObject d2) {
			int val1, val2;
			val1 = d1.getB();
			val2 = d2.getB();
			return val1 - val2;
		}
	};

	public static Comparator<DataObject> sortBDesc = new Comparator<DataObject>() {

		public int compare(DataObject d1, DataObject d2) {
			int val1, val2;
			val1 = d1.getB();
			val2 = d2.getB();
			return val2 - val1;
		}
	};

	public static int timeCompare(String val1, String val2, String type) {
		String[] parts1;
		String[] parts2;
		int year1, month1, date1; // hour minute second
		int year2, month2, date2;
		int helper;

		if (type.equalsIgnoreCase("date")) {
			parts1 = val1.split("-");
			parts2 = val2.split("-");
		} else if (type.equalsIgnoreCase("time")) {
			parts1 = val1.split(":");
			parts2 = val2.split(":");
		} else {
			throw new IllegalArgumentException("Invalid time type");
		}

		year1 = Integer.parseInt(parts1[0]);
		month1 = Integer.parseInt(parts1[1]);
		date1 = Integer.parseInt(parts1[2]);
		year2 = Integer.parseInt(parts2[0]);
		month2 = Integer.parseInt(parts2[1]);
		date2 = Integer.parseInt(parts2[2]);

		if (year1 == year2) {
			if (month1 == month2) {
				if (date1 == date2) {
					helper = 0;
				} else {
					helper = date1 - date2;
				}
			} else {
				helper = month1 - month2;
			}
		} else {
			helper = year1 - year2;
		}

		if (helper > 0) {
			return 1;
		} else if (helper == 0) {
			return 0;
		} else {
			return -1;
		}

	}

	public static void main(String[] args) throws ParseException {
		long startTime, stopTime;
		int size = 10;
		Location loc[] = new Location[size];

		for (int i = 0; i < size; i++) {
			loc[i] = new Location("A", 42.443087, 76.488707);
		}
		Date to_date[] = new Date[size];
		Date to_time[] = new Date[size];
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");

		for (int i = 0; i < size; i++) {
			Integer.toString(1500 + i);
		}
		for (int i = 0; i < size; i++) {

		}

		Random t = new Random();

		// random integers in [0, 100]
		String rgb_test[] = new String[size];
		for (int i = 0; i < size; i++) {
			to_date[i] = date.parse(t.nextInt(2020) + "-" + t.nextInt(12) + "-"
					+ t.nextInt(31));
			to_time[i] = time.parse(t.nextInt(24) + ":" + t.nextInt(60) + ":"
					+ t.nextInt(60));
		}

		for (int i = 0; i < size; i++) {
			rgb_test[i] = t.nextInt(100) + ":" + t.nextInt(100) + ":"
					+ t.nextInt(100) + ":" + t.nextInt(100) + ":"
					+ t.nextInt(100) + ":" + t.nextInt(100);

		}

		DataObject obj[] = new DataObject[size];
		for (int i = 0; i < size; i++) {
			obj[i] = new DataObject(loc[i], to_date[i], to_time[i], rgb_test[i]);
		}

		for (int i = 0; i < size; i++) {
			list.add(obj[i]);
		}

		Sort sort = new Sort();

		System.out
				.println("====================[Before Sorting]========================================");
		System.out.println(list.toString());
		System.out
				.println("====================[Sort Name]========================================");
		System.out.println("--------------------ascending--------------------");
		startTime = System.nanoTime();
		sort.sortList(list, "name", "asce");
		stopTime = System.nanoTime();
		System.out.println("time:" + (stopTime - startTime));
		System.out.println(list.toString());
		System.out
				.println("--------------------descending--------------------");
		startTime = System.nanoTime();
		sort.sortList(list, "name", "desc");
		stopTime = System.nanoTime();
		System.out.println("time:" + (stopTime - startTime));
		System.out.println(list.toString());

		System.out
				.println("====================[Sort Time]========================================");
		System.out
				.println("--------------------ascending(old->recent)--------------------");
		startTime = System.nanoTime();
		sort.sortList(list, "time", "asce");
		stopTime = System.nanoTime();
		System.out.println("time:" + (stopTime - startTime));
		System.out.println(list.toString());
		System.out
				.println("--------------------descending(recent->old)--------------------");
		startTime = System.nanoTime();
		sort.sortList(list, "time", "desc");
		stopTime = System.nanoTime();
		System.out.println("time:" + (stopTime - startTime));
		System.out.println(list.toString());
		System.out
				.println("====================[Sort RGB]========================================");
		System.out.println("--------------------R--------------------");
		startTime = System.nanoTime();
		sort.sortList(list, "R", "asce");
		stopTime = System.nanoTime();
		System.out.println(list.toString());
		System.out.println("time:" + (stopTime - startTime));
		System.out.println("--------------------G(desc)--------------------");
		startTime = System.nanoTime();
		sort.sortList(list, "G", "desc");
		stopTime = System.nanoTime();
		System.out.println(list.toString());
		System.out.println("time:" + (stopTime - startTime));
		System.out.println("--------------------B--------------------");
		startTime = System.nanoTime();
		sort.sortList(list, "B", "asce");
		stopTime = System.nanoTime();
		System.out.println("time:" + (stopTime - startTime));
		System.out.println(list.toString());

	}

}
