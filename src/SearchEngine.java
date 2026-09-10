import java.util.ArrayList;

public class SearchEngine {

    private ArrayList<Document> documents;

    public SearchEngine() {
        documents = new ArrayList<>();
    }

    public void addDocument(Document document) {
        documents.add(document);
    }

    public void search(String keyword) {

        boolean found = false;

        for (Document document : documents) {

            if (document.getTitle().toLowerCase().contains(keyword.toLowerCase())
                    || document.getContent().toLowerCase().contains(keyword.toLowerCase())) {

                System.out.println("\nDocument Found!");
                System.out.println("ID: " + document.getId());
                System.out.println("Title: " + document.getTitle());
                System.out.println("Content: " + document.getContent());

                found = true;
            }
        }

        if (!found) {
            System.out.println("\nNo documents found.");
        }
    }
}