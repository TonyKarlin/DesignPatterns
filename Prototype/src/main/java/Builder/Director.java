package Builder;

import Library.Book;
import Library.Genre;

import java.util.Objects;
import java.util.Scanner;

public class Director {
    private static final Scanner sc = new Scanner(System.in);

    public void buildACollectionOfRecommendations(UserDefinedRecommendationBuilder builder) {
        System.out.println("\nWhat would you want your targeted audience to be?");
        System.out.print("Enter: ");
        builder.setTargetAudience(sc.nextLine());

        buildBooks(builder);
    }

    // Wanted to make the building of a Recommendation Collection with a terminal-based UX
    private void buildBooks(UserDefinedRecommendationBuilder builder) {
        System.out.println("Add books to your collection. \nType 'q' to exit building mode.");

        while (true) {
            System.out.print("Title: ");
            String title = sc.nextLine();
            if (title.equalsIgnoreCase("q")) {
                break;
            }

            System.out.print("Author: ");
            String author = sc.nextLine();

            displayGenres();
            Genre genre = enterAGenre();


            Book newBook = new Book(title, author, genre);
            builder.addBook(newBook);
            System.out.println("\nType 'q' to finish your collection!\n");
        }
    }

    private void displayGenres() {
        System.out.print("Genre (");
        for (int i = 0; i < Genre.values().length; i++) {
            System.out.print(Genre.values()[i]);
            if (i < Genre.values().length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print(")");
    }

    private Genre enterAGenre() {
        while (true) {
            System.out.print("\nEnter genre: ");
            String input = sc.nextLine();
            try {
                return Genre.valueOf(input.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid genre. Please try again.");
            }
        }
    }
}
