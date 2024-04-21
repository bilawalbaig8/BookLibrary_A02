// Import necessary Java utility classes
import java.util.Scanner; // Used for user input
import java.util.ArrayList; // Used for ArrayList data structure

public class Main {
    public static void main(String[] args) {

        // Create ArrayList to hold book records
        ArrayList<ArrayList<String>> bookStock = new ArrayList<>();

        // Add book records
        ArrayList<String> book1 = new ArrayList<>(); // book1 records

        book1.add("Java Programming for Beginners"); //Book Title
        book1.add("Mark Lassoff"); // Author Name
        book1.add("4"); // Book Quantity
        bookStock.add(book1); // Adding to the library

        ArrayList<String> book2 = new ArrayList<>(); // book2 records

        book2.add("Java: A Beginner's Guide"); //Book Title
        book2.add("Herbert Schildt"); // Author Name
        book2.add("3"); // Book Quantity
        bookStock.add(book2); // Adding to the library

        ArrayList<String> book3 = new ArrayList<>(); // book3 records

        book3.add("Python Crash Course"); //Book Title
        book3.add("Eric Matthes"); // Author Name
        book3.add("2"); // Book Quantity
        bookStock.add(book3); // Adding to the library

        ArrayList<String> book4 = new ArrayList<>(); // book4 records

        book4.add("Python Programming for the Absolute Beginner"); //Book Title
        book4.add("Michael Dawson"); // Author Name
        book4.add("5"); // Book Quantity
        bookStock.add(book4); // Adding to the library

        ArrayList<String> book5 = new ArrayList<>(); // book5 records

        book5.add("C++ for Dummies"); //Book Title
        book5.add("Stephen R. Davis"); // Author Name
        book5.add("3"); // Book Quantity
        bookStock.add(book5); // Adding to the library



        // Scanner Object for keyboard input
        Scanner input = new Scanner(System.in);

        String userInput; // Variable to save user input

        boolean isValid = false; // boolean to check input validity


        // Loop to print main menu until valid input
        while (!isValid){

            // Main Menu
            System.out.println("""
                    
                    "**** Welcome to ABC Library ****"
                    
                    1, Display all the books
                    2. Add Books
                    3. Borrow Books
                    4. Return Books
                    5. Exit
                    """);

            System.out.println("Enter the number to choose");

            // Taking user input
            userInput = input.next();

            // Switch case for condition flow
            switch (userInput) {
                case "1" -> {

                    // Display book records
                    for (int i = 0; i < bookStock.size(); i++) {
                        ArrayList<String> bookRecord = bookStock.get(i);
                        System.out.println("\nBook " + (i+1));
                        System.out.println("\tTitle: " + bookRecord.get(0));
                        System.out.println("\tAuthor: " + bookRecord.get(1));
                        System.out.println("\tQuantity: " + bookRecord.get(2));

                    }

                    System.out.println("\n***** Search Completed *****");

                } // End of Main Menu Case 1

                case "2" -> {
                    // Variables to store user input and book information
                    String titleStored = "";
                    String titleNew = "";
                    String authorStored = "";
                    String authorNew = "";
                    String quantityStored = "0";
                    String quantityNew = "0";

                    // ArrayList to store book entry
                    ArrayList<Object> bookEntry = new ArrayList<>();

                    // Skip the newline character
                    userInput = input.nextLine();

                    // Read book title from user
                    System.out.println("\nEnter Book Title");
                    userInput = input.nextLine();
                    bookEntry.add(userInput);

                    // Read book author from user
                    System.out.println("\nEnter Book Author");
                    userInput = input.nextLine();
                    bookEntry.add(userInput);

                    // Loop until user enters a valid quantity
                    boolean isWholeNumber = false;
                    while (!isWholeNumber){
                        System.out.println("\nEnter Book Quantity in numbers");
                        userInput = input.next();

                        try {
                            // Attempt to parse user input to an integer
                            int number = Integer.parseInt(userInput);
                            isWholeNumber = true; // Exit loop if conversion succeeds

                        }
                        catch (Exception e){
                            // Notify user of invalid input and prompt for number
                            System.out.println("\nInvalid");
                            System.out.println("Please Enter Number");
                        }
                    }


                    bookEntry.add(userInput); // Add quantity as String to bookEntry ArrayList

                    /// Display book records entered by user
                    System.out.println("\tTitle: " + bookEntry.get(0));
                    System.out.println("\tAuthor: " + bookEntry.get(1));
                    System.out.println("\tQuantity: " + bookEntry.get(2));

                    // Check if the book entry already exists in the library
                    boolean isFound = false;


                    // Loop through each book record in the library
                    for (int i = 0; i < bookStock.size(); i++) {
                        ArrayList<String> bookRecord = bookStock.get(i);

                        // Extract title, author, and quantity from the book record
                        titleStored = (String) bookRecord.get(0);
                        titleNew = (String) bookEntry.get(0);
                        authorStored = (String) bookRecord.get(1);
                        authorNew = (String) bookEntry.get(1);
                        quantityStored = (String) bookRecord.get(2);
                        quantityNew = (String) bookEntry.get(2);

                        // Compare the title and author of the new book entry with existing records
                        if (titleStored.equals(titleNew) && authorStored.equals(authorNew)){

                            isFound = true;
                            System.out.println("Book is already exists. Quantity Updated!");

                            // Update the quantity of the existing book
                            int newQuantitynum =  Integer.parseInt(quantityStored) + Integer.parseInt(quantityNew);
                            String newQuantity = Integer.toString(newQuantitynum) ;

                            // Set the updated quantity in the bookStock ArrayList
                            bookRecord.set(2, newQuantity);


                            break; // Exit loop after updating the quantity
                        }

                    } //End of loop through bookStock

                    if(!isFound){
                        // Create a new ArrayList to hold the book records
                        ArrayList<String> newBookRecord = new ArrayList<>();

                        // Add book records
                        newBookRecord.add(titleNew);
                        newBookRecord.add(authorNew);
                        newBookRecord.add(quantityNew);

                        // Add the new book record ArrayList to the bookStock list
                        bookStock.add(newBookRecord);

                        System.out.println("New Book Saved");
                    }

                } // End of Main Manu case 2

                case "3" -> { // Borrow book
                    // Variables to store user input and book information
                    String titleStored = "";
                    String titleNew = "";
                    String authorStored = "";
                    String authorNew = "";
                    String quantityStored = "0";
                    String quantityNew = "0";

                    // ArrayList to store book entry
                    ArrayList<Object> bookEntry = new ArrayList<>();

                    // Skip the newline character
                    userInput = input.nextLine();

                    // Read book title from user
                    System.out.println("\nEnter Book Title");
                    userInput = input.nextLine();
                    bookEntry.add(userInput);

                    // Read book author from user
                    System.out.println("\nEnter Book Author");
                    userInput = input.nextLine();
                    bookEntry.add(userInput);

                    // Loop until user enters a valid quantity
                    Boolean isWholeNumber = false;
                    while (!isWholeNumber){
                        System.out.println("\nEnter Book Quantity in numbers");
                        userInput = input.next();

                        try {
                            // Attempt to parse user input to an integer
                            int number = Integer.parseInt(userInput);
                            isWholeNumber = true; // Exit loop if conversion succeeds

                        }
                        catch (Exception e){
                            // Notify user of invalid input and prompt for number
                            System.out.println("\nInvalid");
                            System.out.println("Please Enter Number");
                        }
                    }


                    bookEntry.add(userInput); // Add quantity as String to bookEntry ArrayList

                    /// Display book records entered by user
                    System.out.println("\tTitle: " + bookEntry.get(0));
                    System.out.println("\tAuthor: " + bookEntry.get(1));
                    System.out.println("\tQuantity: " + bookEntry.get(2));


                    // Check if the book entry already exists in the library
                    Boolean isFound = false;


                    // Loop through each book record in the library
                    for (int i = 0; i < bookStock.size(); i++) {
                        ArrayList<String> bookRecord = bookStock.get(i);

                        // Extract title, author, and quantity from the book record
                        titleStored = (String) bookRecord.get(0);
                        titleNew = (String) bookEntry.get(0);
                        authorStored = (String) bookRecord.get(1);
                        authorNew = (String) bookEntry.get(1);
                        quantityStored = (String) bookRecord.get(2);
                        quantityNew = (String) bookEntry.get(2);

                        // Compare the title and author of the new book entry with existing records
                        if (titleStored.equals(titleNew) && authorStored.equals(authorNew)){

                            // If the book is found in the library
                            isFound = true;

                            // Convert quantity strings to integers for comparison
                            int oldQuantitynum =  Integer.parseInt(quantityStored);
                            int newQuantitynum =  Integer.parseInt(quantityNew);

                            // Print available quantity
                            System.out.println("\nThe requested book is available");
                            System.out.printf("Total Quantity Available: %d \n", oldQuantitynum);

                            // Check if requested quantity is available
                            if(oldQuantitynum <= newQuantitynum){
                                System.out.println("\nyou have requested more than available quantity");

                            }
                            else {
                                // If requested quantity is available, assign it to the user
                                int updateduantity = oldQuantitynum - newQuantitynum;

                                String newQuantity = Integer.toString(updateduantity) ;

                                // Set the updated quantity in the bookStock ArrayList
                                bookRecord.set(2, newQuantity);

                                System.out.println("\n**** Assigned Successfully ****");
                            }

                        }

                    } //End of loop through bookStock

                    // If book is not found in the library
                    if(!isFound){
                        System.out.println("The requested book is not available");
                    }

                } // End of Main Manu case 3

                case "4" -> { // Book Return

                    // Variables to store user input and book information
                    String titleStored = "";
                    String titleNew = "";
                    String authorStored = "";
                    String authorNew = "";
                    String quantityStored = "0";
                    String quantityNew = "0";

                    // ArrayList to store book entry
                    ArrayList<Object> bookEntry = new ArrayList<>();

                    // Skip the newline character
                    userInput = input.nextLine();

                    // Read book title from user
                    System.out.println("\nEnter Book Title");
                    userInput = input.nextLine();
                    bookEntry.add(userInput);

                    // Read book author from user
                    System.out.println("\nEnter Book Author");
                    userInput = input.nextLine();
                    bookEntry.add(userInput);

                    // Loop until user enters a valid quantity
                    Boolean isWholeNumber = false;
                    while (!isWholeNumber){
                        System.out.println("\nEnter Book Quantity in numbers");
                        userInput = input.next();

                        try {
                            // Attempt to parse user input to an integer
                            int number = Integer.parseInt(userInput);
                            isWholeNumber = true; // Exit loop if conversion succeeds

                        }
                        catch (Exception e){
                            // Notify user of invalid input and prompt for number
                            System.out.println("\nInvalid");
                            System.out.println("Please Enter Number");
                        }
                    }


                    bookEntry.add(userInput); // Add quantity as String to bookEntry ArrayList

                    /// Display book records entered by user
                    System.out.println("\tTitle: " + bookEntry.get(0));
                    System.out.println("\tAuthor: " + bookEntry.get(1));
                    System.out.println("\tQuantity: " + bookEntry.get(2));


                    // Check if the book entry already exists in the library
                    Boolean isFound = false;


                    // Loop through each book record in the library
                    for (int i = 0; i < bookStock.size(); i++) {
                        ArrayList<String> bookRecord = bookStock.get(i);

                        // Extract title, author, and quantity from the book record
                        titleStored = (String) bookRecord.get(0);
                        titleNew = (String) bookEntry.get(0);
                        authorStored = (String) bookRecord.get(1);
                        authorNew = (String) bookEntry.get(1);
                        quantityStored = (String) bookRecord.get(2);
                        quantityNew = (String) bookEntry.get(2);

                        // Compare the title and author of the new book entry with existing records
                        if (titleStored.equals(titleNew) && authorStored.equals(authorNew)){

                            // If the book is found in the library
                            isFound = true;

                            // Convert quantity strings to integers for comparison
                            int oldQuantitynum =  Integer.parseInt(quantityStored);
                            int newQuantitynum =  Integer.parseInt(quantityNew);

                            // Print a message indicating the book is from the library
                            System.out.println("\nThis book is from our library");

                            // Calculate the updated quantity (add returned quantity to existing quantity)
                            int updateduantity = oldQuantitynum + newQuantitynum;

                            // Convert the updated quantity back to string
                            String newQuantity = Integer.toString(updateduantity) ;

                            // Set the updated quantity in the bookStock ArrayList
                            bookRecord.set(2, newQuantity);

                            // Print a success message
                            System.out.println("\n**** Returned Successfully ****");

                        }

                    } //End of loop through bookStock

                    // If book is not found in the library
                    if(!isFound){
                        System.out.println("\nThis book is not borrowed from our library");
                    }

                } // End of Main Manu case 4


                case "5" -> {
                    System.out.println("Exiting...");
                    isValid = true;
                }
                default -> System.out.println("Invalid input\n");
            }

            }
        }
    }