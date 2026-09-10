import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        SearchEngine searchEngine = new SearchEngine();

        // Sample documents
        searchEngine.addDocument(new Document(
                1,
                "Java Programming",
                "Java is a popular programming language."
        ));

        searchEngine.addDocument(new Document(
                2,
                "Data Structures",
                "Data structures help organize and store data efficiently."
        ));

        searchEngine.addDocument(new Document(
                3,
                "Object Oriented Programming",
                "Java supports object oriented programming concepts."
        ));

        while (true) {

            System.out.println("\n========================================");
            System.out.println("          MINI SEARCH ENGINE");
            System.out.println("========================================");

            System.out.println("1. Search");
            System.out.println("2. View Documents");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("\nEnter keyword to search: ");
                    String keyword = scanner.nextLine();

                    searchEngine.search(keyword);

                    break;

                case 2:

                    System.out.println("\n========== DOCUMENTS ==========");

                    System.out.println("1. Java Programming");
                    System.out.println("2. Data Structures");
                    System.out.println("3. Object Oriented Programming");

                    break;

                case 3:

                    System.out.println("\nThank you for using Mini Search Engine!");
                    scanner.close();
                    return;

                default:

                    System.out.println("\nInvalid choice. Please try again.");
            }
        }
    }
}