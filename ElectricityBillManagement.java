import java.util.*;
import java.io.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

class BillManagement {

	BillManagement()
	{
		System.out.print("\t\t\t\t\t ___________________________________________________________________________________________\n");
		System.out.print("\t\t\t\t\t|                                           		                                    |\n");
		System.out.print("\t\t\t\t\t|                                           		                                    |\n");
		System.out.print("\t\t\t\t\t|                                           		                                    |\n");
		System.out.print("\t\t\t\t\t|                                           		                                    |\n");
		System.out.print("\t\t\t\t\t|                                           		                                    |\n");
		System.out.print("\t\t\t\t\t|                                           		                                    |\n");
		System.out.print("\t\t\t\t\t|                            WELCOME TO ELECTRICITY BILL MANAGEMENT SYSTEM                     |\n");
		System.out.print("\t\t\t\t\t|                                                                                           |\n");
		System.out.print("\t\t\t\t\t|                                                                                           |\n");
		System.out.print("\t\t\t\t\t|                                                                                           |\n");
		System.out.print("\t\t\t\t\t|                                                                                           |\n");
		System.out.print("\t\t\t\t\t|                                                                                           |\n");
		System.out.print("\t\t\t\t\t|                                                                                           |\n");
		System.out.print("\t\t\t\t\t|                                                                                           |\n");
		System.out.print("\t\t\t\t\t|                                                                                           |\n");
		System.out.print("\t\t\t\t\t|___________________________________________________________________________________________|\n");
	}
    Scanner scan = new Scanner(System.in);
    String name;
    String address;
    long contact;
    int units;
    double totalBill;
    String paymentStatus;
    String id;
    String billingDate;

    private void pressAnyKeyToContinue() {
        System.out.println("Press Enter key to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
            System.out.println("Press 'Enter' key to continue!");
        }
    }

    String readString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

	//Log in Module
void login()
{
   int a;
   String pass;
   System.out.print("\t\t\t\t\t\t\t\t _______________________________ \n");
   System.out.print("\n\t\t\t\t\t\t\t\t E-HEALTH CARE MANAGEMENT SYSTEM \n");
   System.out.print("\t\t\t\t\t\t\t\t _______________________________ \n");
   System.out.println("\n\n\t\t\t\t\t\t\t\t------------------------------");
   System.out.print("\n\t\t\t\t\t\t\t\t\t     LOGIN \n");	
   System.out.print("\t\t\t\t\t\t\t\t------------------------------\n\n");	
   System.out.print("\t\t\t\t\t\t\t\tEnter the Password: ");
   pass=scan.next();
   if(pass.equals("shiv"))
	{
      System.out.print("\n\n\t\t\t\t\t\t\t\tAccess Granted!\n");
      pressAnyKeyToContinue();
  	}
    else
	{
      System.out.print( "\n\n\t\t\t\t\t\t\t\tAccess Aborted...\n\t\t\t\t\t\t\t\t1.Try Again\n\n\t\t\t\t\t\t\t\t2.Exit");
      System.out.print("\n\n\t\t\t\t\t\t\tEnter the option: ");
      try{ 
	a=scan.nextInt(); 
      if(a==1)
          login();
      else if(a==2)
          System.exit(0);
      else
        {
         System.out.print("\n\n\t\t\t\t\t\tInvalid Choice\n");
        }
	}
	catch(InputMismatchException e){
	System.out.println("\n\n\t\t\t\t\t\t\t*Enter the correct option!*\n\n");
	login();
	}
        }
}

    // Method to get the current date and time
    public void getCurrentTimeUsingDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        billingDate = dtf.format(now);
    }

    void menu()
	{
		char k;
	//giving option to the user for their choice
	System.out.print("\t\t\t\t\t\t\t\t ________________________________ \n");
	System.out.print("\n\n\t\t\t\t\t\t\t\t  ELECTRICITY BILL MANAGEMENT SYSTEM \n\n");	
	System.out.print("\t\t\t\t\t\t\t\t ________________________________ \n");
	System.out.print("\n\n\t\t\t\t\t\tPlease, Choose from the following Options: \n\n");
	System.out.print("\t\t\t\t\t\t __________________________________________________________________\n");
	System.out.print("\t\t\t\t\t\t|                                           	                  |\n");
	System.out.print("\t\t\t\t\t\t|             1  >> Add New Customer Record                       |\n");
	System.out.print("\t\t\t\t\t\t|             2  >> View Bill Information                     	  |\n");
	System.out.print("\t\t\t\t\t\t|             3  >> Mark Bill As Paid                        	  |\n");
	System.out.print("\t\t\t\t\t\t|             4  >> History of the Customer                  	  |\n");
	System.out.print("\t\t\t\t\t\t|             5  >> Delete Bill of customer    			  |\n");
	System.out.print("\t\t\t\t\t\t|             6  >> Edit Bill 		                          |\n");
	System.out.print("\t\t\t\t\t\t|             7  >> Help                                          |\n");
	System.out.print("\t\t\t\t\t\t|             8  >> Exit	                                  |\n");
	System.out.print("\t\t\t\t\t\t|_________________________________________________________________|\n\n");
	System.out.print("\t\t\t\t\t\tEnter your choice: ");
		k=scan.next().charAt(0);
	//if inputed choice is other than given choice
	switch(k)
	{
		case '1': addBill();
		break;
		case '2': viewBill();
		break;
		case '3': markBillAsPaid();
		break;
		case '4': Chistory();
		break;
		case '5': delete();
		break;
		case '6': editBill();
		break;
		case '7': info();
		break;
		case '8': exit();
		break;
		default: 
	  		System.out.print("\n\n\t\t\t\t\t\tInvalid Choice\n");
  			System.out.print("\t\t\t\t\t\tTry again...........\n\n");
  			menu();
			}
				menu();
	}

	// Method to add a new bill
    void addBill() {
        System.out.print("Enter the customer's ID: ");
        id = scan.next();
        getCurrentTimeUsingDate();

        try {
            // Assume default encoding.
            FileWriter fileWriter = new FileWriter(id + ".txt");

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            System.out.print("\n************************\n");
            bufferedWriter.write("Billing Date: " + billingDate);
            bufferedWriter.newLine();
            System.out.print("\nCustomer Name: ");
            name = readString();
            bufferedWriter.write("Customer Name: " + name);
            bufferedWriter.newLine();
            System.out.print("\nCustomer Address: ");
            address = readString();
            bufferedWriter.write("Customer Address: " + address);
            bufferedWriter.newLine();
            System.out.print("\nContact Number: ");
            contact = scan.nextLong();
            bufferedWriter.write("Contact Number: " + contact);
            bufferedWriter.newLine();
            System.out.print("\nConsumed Units: ");
            units = scan.nextInt();
            bufferedWriter.write("Consumed Units: " + units);
            bufferedWriter.newLine();

            // Calculate total bill
            totalBill = units * 7.5; // Assuming a rate of 7.5 per unit
            bufferedWriter.write("Total Bill: " + totalBill);
            bufferedWriter.newLine();

            System.out.print("\nPayment Status (Paid/Unpaid): ");
            paymentStatus = readString();
            bufferedWriter.write("Payment Status: " + paymentStatus);
            bufferedWriter.newLine();
            bufferedWriter.write("\n************************\n\n");
            bufferedWriter.newLine();
            System.out.print("\nInformation Saved Successfully\n");

            bufferedWriter.close();
        } catch (IOException ex) {
            System.out.println("Error writing to file '" + id + ".txt'");
        }
        pressAnyKeyToContinue();
    }

    // Method to view bill
    void viewBill() {
        System.out.print("Enter the customer's ID to view the bill: ");
        id = scan.next();

        String line = null;
        try {
            FileReader fileReader = new FileReader(id + ".txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            System.out.print("\n\n\n\n\t\t\t\t........................................ Bill Information of '" + id + "' ........................................\n\n\n\n");
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            pressAnyKeyToContinue();
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("No bill information found for customer with ID: '" + id + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + id + "'");
        }
    }

    // Method to delete a bill
    void delete() {
        System.out.print("Enter the customer's ID to delete the bill: ");
        id = scan.next();

        File billFile = new File(id + ".txt");
        if (billFile.delete())
            System.out.print("\nBill Deleted Successfully\n");
        else
            System.out.print("\nFailed to Delete Bill\n");

        pressAnyKeyToContinue();
    }

    // Method to display the history of a customer
	void Chistory() {
    System.out.print("\n\nEnter the customer's file name to be opened: ");
    String fileName = scan.next();

    String line = null;
    try {
        FileReader fileReader = new FileReader(fileName + ".txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        System.out.print("\n\n\n\n\t\t\t\t........................................ History of Customer '" + fileName + "' ........................................\n\n\n\n");
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        pressAnyKeyToContinue();
        bufferedReader.close();
    } catch (FileNotFoundException ex) {
        System.out.println("No history information found for customer with file name: '" + fileName + "'");
    } catch (IOException ex) {
        System.out.println("Error reading file '" + fileName + "'");
    }
}




    // Method to mark a bill as paid
    void markBillAsPaid() {
        System.out.print("Enter the customer's ID to mark the bill as paid: ");
        id = scan.next();

        File billFile = new File(id + ".txt");
        if (billFile.exists()) {
            try {
                // Load the bill file
                FileReader fileReader = new FileReader(billFile);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                List<String> lines = new ArrayList<>();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    lines.add(line);
                }
                bufferedReader.close();

                // Find the payment status line and update it
                for (int i = 0; i < lines.size(); i++) {
                    if (lines.get(i).startsWith("Payment Status:")) {
                        lines.set(i, "Payment Status: Paid");
                        break;
                    }
                }

                // Write the updated lines back to the file
                FileWriter fileWriter = new FileWriter(billFile);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                for (String updatedLine : lines) {
                    bufferedWriter.write(updatedLine);
                    bufferedWriter.newLine();
                }
                bufferedWriter.close();

                System.out.print("\nBill Marked as Paid Successfully\n");
            } catch (IOException ex) {
                System.out.println("Error updating payment status for customer with ID: '" + id + "'");
            }
        } else {
            System.out.print("\nNo bill information found for customer with ID: '" + id + "'\n");
        }

        pressAnyKeyToContinue();
    }

    // Method to edit a bill
     void editBill() {
        System.out.print("Enter the customer's ID to edit the bill: ");
        id = scan.next();

        // Load the bill file
        File billFile = new File(id + ".txt");

        if (billFile.exists()) {
            try {
                // Read the bill file
                List<String> lines = new ArrayList<>();
                FileReader fileReader = new FileReader(billFile);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    lines.add(line);
                }
                bufferedReader.close();

                // Display the existing bill data
                System.out.println("\nCurrent Bill Data:");
                for (String billLine : lines) {
                    System.out.println(billLine);
                }

                // Prompt for the new data to edit
                System.out.print("\nEnter new customer name: ");
                String newName = readString();
                System.out.print("Enter new customer address: ");
                String newAddress = readString();
                System.out.print("Enter new contact number: ");
                long newContact = scan.nextLong();
                System.out.print("Enter new consumed units: ");
                int newUnits = scan.nextInt();

                // Calculate the new total bill
                double newTotalBill = newUnits * 7.5; // Assuming a rate of 7.5 per unit

                // Update the bill data in the list
                for (int i = 0; i < lines.size(); i++) {
                    if (lines.get(i).startsWith("Customer Name:")) {
                        lines.set(i, "Customer Name: " + newName);
                    } else if (lines.get(i).startsWith("Customer Address:")) {
                        lines.set(i, "Customer Address: " + newAddress);
                    } else if (lines.get(i).startsWith("Contact Number:")) {
                        lines.set(i, "Contact Number: " + newContact);
                    } else if (lines.get(i).startsWith("Consumed Units:")) {
                        lines.set(i, "Consumed Units: " + newUnits);
                    } else if (lines.get(i).startsWith("Total Bill:")) {
                        lines.set(i, "Total Bill: " + newTotalBill);
                    }
                }

                // Write the updated bill data back to the file
                FileWriter fileWriter = new FileWriter(billFile);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                for (String updatedLine : lines) {
                    bufferedWriter.write(updatedLine);
                    bufferedWriter.newLine();
                }
                bufferedWriter.close();

                System.out.print("\nBill Updated Successfully\n");
            } catch (IOException ex) {
                System.out.println("Error updating the bill for customer with ID: '" + id + "'");
            }
        } else {
            System.out.print("\nNo bill information found for customer with ID: '" + id + "'\n");
        }

        pressAnyKeyToContinue();
    }

	void info()
	{
        System.out.println("\n\nElectricity Bill management system is command-driven application that helps to manage the record of the Customer's as well as generate their bills.");
        System.out.print("\t\t\t\t____________________________________________________________________________________________________\n");
        System.out.print("\t\t\t\t\tOptions                       | Description\n");
        System.out.print("\t\t\t\t____________________________________________________________________________________________________\n");
        System.out.println("\t\t\t\t 1 >> Add New Customer Record     | A new customer's file can be created by using this module.");
        System.out.println("\t\t\t\t 2 >> View Bill Information       | Check previous or existing details of particular patient using their file");        System.out.println("\t\t\t\t 3 >> Mark Bill As Paid           | Check previous or existing details of particular patient using their file");        System.out.println("\t\t\t\t 4 >> History of the Customer     | History of the records are here ");
        System.out.println("\t\t\t\t 5 >> Delete Bill of Customer's   | Delete bills of the existing records");
        System.out.println("\t\t\t\t 6 >> Edit Bill                       | To make changes in the bill");
        System.out.println("\t\t\t\t 7 >> Help                        | Provide the help documentation.");
        System.out.println("\t\t\t\t 8 >> Exit                        | Exits the application.");

    pressAnyKeyToContinue();
	}

    void exit()
	{
		System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\t\t\t\t\t\n");
		System.out.print("\t\t\t\t\t _______________________________________________________________________________________ \n");
		System.out.print("\t\t\t\t\t|                                           		                                |\n");
		System.out.print("\t\t\t\t\t|                                           		                                |\n");
		System.out.print("\t\t\t\t\t|                                           		                                |\n");
		System.out.print("\t\t\t\t\t|                                           		                                |\n");
		System.out.print("\t\t\t\t\t|                                           		                                |\n");
		System.out.print("\t\t\t\t\t|                               THANK YOU FOR USING                                     |\n");
		System.out.print("\t\t\t\t\t|                                                                                       |\n");
		System.out.print("\t\t\t\t\t|                            ELECTRICITY BILL MANAGEMENT SYSTEM                         |\n");
		System.out.print("\t\t\t\t\t|                                                                                       |\n");
		System.out.print("\t\t\t\t\t|                                                                                       |\n");
		System.out.print("\t\t\t\t\t|                                                                                       |\n");
		System.out.print("\t\t\t\t\t|                                                                                       |\n");
		System.out.print("\t\t\t\t\t|                                                                                       |\n");
		System.out.print("\t\t\t\t\t|                                                                                       |\n");
		System.out.print("\t\t\t\t\t|_______________________________________________________________________________________|\n");
		System.out.print("\t\t\t\t\t\n\n\n\n\t\t\t\t\t");
		System.exit(0);
	}
}

 
 class ElectricityBillManagement {
    public static void main(String[] args) {
        BillManagement billManagement = new BillManagement();
        billManagement.login();
        billManagement.menu();
    }
}
