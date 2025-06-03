/*
Welcome to Rental Car Company Updated, 
Thursday 26th of November 2020
 */

package WelcometoRentalCarCompanyAssig4;
import java.util.Scanner;
public class BCRP4 {

    /*
     * DO NOT MODIFY THIS METHOD
     */
    public static int mainMenu() {
        Scanner input = new Scanner(System.in);

        printHeader("The Rental Car Company");
        
        System.out.print(" 1 : Rent a car\n"
                + " 2 : Return a car (not implemented yet)\n"
                + " 3 : Print customer details (not implemented yet)\n"
                + " 4 : Print car details (not implemented yet) \n"
                + " 5 : Print report\n\n"
                + " Any other key to quit\n"
                + " --------------------------------------------------------------------------------\n"
                + " > Please enter your choice: ");
        int choice = input.nextInt();
        return choice;
    }

    /*
     * DO NOT MODIFY THIS METHOD
     */
    public static int carMenu() {
	Scanner input = new Scanner(System.in);

	int carChoice;
        do {
            System.out.print("\n      CarType          \tPrice (in SAR)\n"
                    + "-------------------------------------------------\n"
                    + " | 1 : Small Car         100\n"
                    + " | 2 : Medium Car        150\n"
                    + " | 3 : Large Car         200\n"
                    + " ----------------------------------------------- \n"
                    + " > Please enter your choice of car: ");

            carChoice = input.nextInt();
        } while (carChoice < 1 || carChoice > 3);

	int carCost = 0;
	switch (carChoice) {
	case 1: carCost = 100; break;
	case 2: carCost = 150; break;
	case 3: carCost = 200; break;
	}

	return carCost;
    }

    /*
     * DO NOT MODIFY THIS METHOD
     */
    public static String getCustomerName() {
	Scanner input = new Scanner(System.in);
	System.out.print(" > Enter your name (first and last): ");
	String name = input.nextLine();

	return name;
    }		

    /*
     * DO NOT MODIFY THIS METHOD
     */
    public static String getPhoneNumber() {
	Scanner input = new Scanner(System.in);
	String phoneNumber;
	do {
	    System.out.print(" > Enter 10 digit for phone number starting with 0: ");
	    phoneNumber = input.next();
	} while (phoneNumber.charAt(0) != '0' || phoneNumber.length()!=10);

	return phoneNumber;
    }

    /*
     * DO NOT MODIFY THIS METHOD
     */
    public static void printHeader(String title) {
	System.out.println();
	System.out.println("-----------------------------------------------------------------------------------");
	System.out.println(" \t\t\t\t" + title);
	System.out.println(" ----------------------------------------------------------------------------------");
    }

    /*
     * DO NOT MODIFY THIS METHOD
     */
    public static void printReceipt(String name, String phoneNumber, int numOfRentDay, double carCost) {       
	printHeader("Booking details");

	System.out.println();
	System.out.println("\tName: \t\t\t" + name);
	System.out.println("\tPhone: \t\t\t" + phoneNumber);

	double totalCost = (carCost + carCost*0.15);

	System.out.println();
	System.out.printf("\tCar Cost (per day): \t\t%15.2f SAR\n", carCost);
	System.out.printf("\tInsurance Cost (per day): \t%15.2f SAR\n", carCost*0.15);
	System.out.printf("\tTotal Cost (per day): \t\t%15.2f SAR\n", totalCost);

	System.out.println();
	System.out.printf("\tTotal Cost (for %d days): \t%15.2f SAR\n\n", numOfRentDay, totalCost * numOfRentDay);

	System.out.println("\n\n");
    }

    /*
     * Modify this method to take appropriate input parameters, and then add the 
     * new entry details into the corresponding arrays.
     */
    public static void rentCar(double [] carCost, String [] custName, String [] phoneNum, int [] numOfdays, int totalOrders) {
	Scanner input = new Scanner(System.in);

	// Obtain the car cost and store it into an array
	carCost[totalOrders] = carMenu();

	// obtain customer details and store it into an array
	custName[totalOrders] = getCustomerName();
	phoneNum[totalOrders] = getPhoneNumber();

	// read days and store it into an array
	System.out.print(" > Enter the number of days that you would like to rent the car : ");
	numOfdays[totalOrders] = input.nextInt();

	printReceipt(custName[totalOrders], phoneNum[totalOrders], numOfdays[totalOrders], carCost[totalOrders]); 
    }

    /*
     * Modify this method to add the appropriate functionality as given
     * in the assignment description and sample output
     */
    public static void printReport(double [] carCost, String [] custName, String [] phoneNum, int [] numOfdays, int totalOrders) {
        for (int i = 0; i < totalOrders; i++){
            printReceipt(custName[i], phoneNum[i], numOfdays[i], carCost[i]);  
        }

    }
		
    public static void main(String[] args) {
	Scanner input = new Scanner(System.in);

			
	final int MAX = 1000;
			
	// declare all your arrays here and then pass them as reference to the 
	// relevant methods where needed
        double [] carCost = new double [MAX];
        String [] custName = new String [MAX];
        String [] phoneNum = new String [MAX];
        int [] numOfdays = new int [MAX];
			
	// use this variable to keep track of the number of orders
	// Hint : This will serve as the array index to the new order
	int totalOrders = 0;
			
	int choice;
	do {
	    choice = mainMenu();

	    switch (choice) {
		case 1: 
		    // modify based on your method
		    rentCar(carCost, custName, phoneNum, numOfdays, totalOrders++);
		    break;
		case 2:
		    break;
		case 3:
		    break;
		case 4:
		    break;
		case 5:
		    // modify based on your method
                    System.out.println("\n-----------------------------------------------------------------------------------\n"
                        + " 		\t\tComprehensive Report\n"
                        + " ----------------------------------------------------------------------------------");
		    printReport(carCost, custName, phoneNum, numOfdays, totalOrders++);
		    break;
	    }
	} while (choice >= 1 && choice <= 5);

	System.out.println("\n\n *********** Thank you for using the system *************\n\n");
    }
}
