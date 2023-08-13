import java.util.*;
//import java.lang.String;
import java.io.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;



class BillManagement {
	
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

    
    void login() {
        int a;
        String pass;
        System.out.print("\t\t\t\t\t __________________________________________________________________________ \n");
        System.out.print("\n\t\t\t\t\t\t\t\tELECTRICITY BILL MANAGEMENT SYSTEM \n");
        System.out.print("\t\t\t\t\t __________________________________________________________________________ \n");
        System.out.println("\n\n\t\t\t\t\t\t\t\t--------------------------------");
        System.out.print("\n\t\t\t\t\t\t\t\t\t     LOGIN \n");
        System.out.print("\t\t\t\t\t\t\t\t---------------------------------\n\n");
        System.out.print("\t\t\t\t\t\t\t\tEnter the Password: ");
        pass = scan.next();
        if (pass.equals("2001")) {
            System.out.print("\n\n\t\t\t\t\t\t\t\tAccess Granted!\n");
            pressAnyKeyToContinue();
        } else {
            System.out.print("\n\n\t\t\t\t\t\t\t\tAccess Aborted...\n\t\t\t\t\t\t\t\t1.Try Again\n\n\t\t\t\t\t\t\t\t2.Exit");
            System.out.print("\n\n\t\t\t\t\t\t\tEnter the option: ");
            try {
                a = scan.nextInt();
                if (a == 1)
                    login();
                else if (a == 2)
                    System.exit(0);
                else {
                    System.out.print("\n\n\t\t\t\t\t\tInvalid Choice\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("\n\n\t\t\t\t\t\t\t*Enter the correct option!*\n\n");
                login();
            }
        }
    }

    }

    void menu() {
        char k;
        System.out.print("1 Add New Bill Record \n");
        System.out.print("2View Bill Information \n");
	System.out.print("3 delete Bill Information \n");
	System.out.print("4 History of customers\n");
	System.out.print(" 5 Mark Bill as paid \n");
        System.out.print("6 edit bill \n");
        System.out.print("Enter your choice: ");
        k = scan.next().charAt(5);
        switch (k) {
            case '1':
                addBill();
                break;
            case '2':
                viewBill();
                break;
	case '3':
                delete();
                break;
	case '4':
                history();
                break;
	case '5':
                markBillAsPaid();
                break;
	 case '6':
                editBill();
                break;
	case '7':
		exit();
            default:
                System.out.print("\n\n\t\t\t\t\t\tInvalid Choice\n");
                System.out.print("\t\t\t\t\t\tTry again...........\n\n");
                menu();
        }
        menu();
    }

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
            System.out.print("\nTotal Bill: ");
            totalBill = scan.nextDouble();
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

            // Edit bill details
            for (int i = 0; i < lines.size(); i++) {
                if (lines.get(i).startsWith("Customer Name:")) {
                    System.out.print("Enter the new Customer Name: ");
                    scan.nextLine(); // Consume the newline character
                    String newName = readString();
                    lines.set(i, "Customer Name: " + newName);
                } else if (lines.get(i).startsWith("Customer Address:")) {
                    System.out.print("Enter the new Customer Address: ");
                    scan.nextLine(); // Consume the newline character
                    String newAddress = readString();
                    lines.set(i, "Customer Address: " + newAddress);
        
                } else if (lines.get(i).startsWith("Consumed Units:")) {
                    System.out.print("Enter the new Consumed Units: ");
                    int newUnits = scan.nextInt();
                    lines.set(i, "Consumed Units: " + newUnits);
                }
            }

            FileWriter fileWriter = new FileWriter(billFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (String updatedLine : lines) {
                bufferedWriter.write(updatedLine);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();

            System.out.print("\nBill Details Updated Successfully\n");
        } catch (IOException ex) {
            System.out.println("Error updating bill details for customer with ID: '" + id + "'");
        }
    } else {
        System.out.print("\nNo bill information found for customer with ID: '" + id + "'\n");
    }

    pressAnyKeyToContinue();
}

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

    void history()
   {
           System.out.print("\n\nEnter the patient's file name to be opened : ");
    String fileName=scan.next();
           
    String line = null;
    try {
       
            FileReader fileReader = new FileReader(fileName+".txt");

          
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            System.out.print("\n\n\n\n\t\t\t\t........................................ History of Customer '"+fileName+"' ........................................\n\n\n\n");
            while((line = bufferedReader.readLine()) != null)
            {
                System.out.println(line);
            }
           pressAnyKeyToContinue();
          
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" + fileName + "'");
        }
    }

    void markBillAsPaid() {
    System.out.print("Enter the customer's ID to mark the bill as paid: ");
    id = scan.next();

   
    File billFile = new File(id + ".txt");

    if (billFile.exists()) {
        try {
     
            List<String> lines = new ArrayList<>();
            FileReader fileReader = new FileReader(billFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
            bufferedReader.close();


            
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


    void searchBillRecord() {
        System.out.print("Enter the customer's ID to search for the bill record: ");
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
            // Always close files.
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("No bill information found for customer with ID: '" + id + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + id + "'");
        }
    }

    

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
   
}
    class ElectricityBillManagement {
    public static void main(String args[]) {
        BillManagement billManagement = new BillManagement();
        billManagement.login();
        billManagement.menu();
    }
}

