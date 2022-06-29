import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Runner {
    public static <E> void main(String[] args) {
        // your code here
        // the loop logic to gather the book information from the user

        System.out.println("Running...");

        boolean runProgram = true;
        Book newBook = new Book();
        Library myLibrary = new Library();

        while (runProgram) {
            System.out.println(
                    "Welcome! You can either: (A) Look up an existing book, (B) Add a new book to the library, or (C) Check to see if we carry a specific genre. Please type 'A', 'B', 'C' or 'Exit' to leave.");
            String userAddOrLookup = getUserInput();

            if (userAddOrLookup.equals("A")) {
                // start new book looking-up process
                System.out.println("What is the title of the book you're looking for?");
                String bookLookupTitle = getUserInput();

                if (myLibrary != null) {
                    myLibrary.grabBookFromLibrary(bookLookupTitle);
                }

                continue;

            } else if (userAddOrLookup.equals("B")) {
                // start new book adding process
                System.out.println("Which book title would you like to add to the library?");
                String bookTitle = getUserInput();

                List<String> answers = new ArrayList<String>();

                answers.add(bookTitle);

                System.out.println("By the way, what genre is " + bookTitle + "?");
                String bookGenre = getUserInput();

                answers.add(bookGenre);

                System.out.println("By the way, how many pages are in " + bookTitle + "?");
                String bookNumOfPages = getUserInput();

                answers.add(bookNumOfPages);

                // Set my book with given attributes
                newBook.title = answers.get(0);
                newBook.genre = answers.get(1);
                newBook.numOfpages = answers.get(2);

                // Add new book to my library
                myLibrary.addBookToLibrary(newBook);

                // Add the book's genre to your library's set of genres
                myLibrary.addToListOfGenre(newBook.genre);

                // Ask user to continue
                System.out.println("Would you like to add another book? Type 'Yes' or 'No'");
                String userContinue = getUserInput();
                System.out.println("You said " + userContinue);
                if (userContinue.equals("No")) {
                    runProgram = false;
                } else {
                    continue;
                }
            } else if (userAddOrLookup.equals("C")) {
                System.out.println("Great. Let's see if we have what you need.");
                System.out.println("What genre would you like to check for?");

                String bookGenre = getUserInput();

                myLibrary.checkSetOfGenres(bookGenre);

            } else if (userAddOrLookup.equals("Exit")) {
                System.out.println("Goodbye. Come again!");
                runProgram = false;
            } else {
                System.out.println("Something went wrong.");
                runProgram = false;
            }

        }

    }

    private static <E> E getUserInput() {
        try {
            Scanner newScanner = new Scanner(System.in);
            String userInput = newScanner.nextLine();
            return (E) userInput;
        } catch (InputMismatchException e) {
            return null;
        }
    }

}
