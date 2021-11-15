package demos;

import java.util.List;

public class DataReaders {

	public static void main(String[] args) {

		//readCSV();
		readXLS();
	}
    
	//.CSV Reader class
	public static void readCSV() {
		String filename = "C:\\Sridevi\\Udemyclasses\\selenium\\UserAccounts.CSV";
		List<String[]> records = utilities.CSV.get(filename);

		// Iterating through the list
		for (String[] record : records) {
			for (String field : record) {
				System.out.println(field);
			}

		}

	}
	
	//.xls reader class
	public static void readXLS() {
		String filename = "C:\\Sridevi\\Udemyclasses\\selenium\\UserLogin.xls";
				String[][] data = utilities.Excel.get(filename);
				for(String[] record : data) {
					System.out.println("\nNEW RECORD");
					System.out.println(record[0]);
					System.out.println(record[1]);
					System.out.println(record[2]);
				}
		
	}

}
