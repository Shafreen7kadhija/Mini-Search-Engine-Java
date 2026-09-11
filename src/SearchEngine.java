import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class SearchEngine {

    private ArrayList<Document> documents;
    private HashMap<String, HashSet<Integer>> keywordIndex;

    public SearchEngine() {

        documents = new ArrayList<>();
        keywordIndex = new HashMap<>();
    }

    public void addDocument(Document document) {

        documents.add(document);

        String text = document.getTitle() + " " + document.getContent();

        String[] words = text.toLowerCase().split("\\W+");

        for (String word : words) {

            if (word.isEmpty()) {
                continue;
            }

            keywordIndex
                    .computeIfAbsent(word, k -> new HashSet<>())
                    .add(document.getId());
        }
    }

    public void search(String keyword) {

        keyword = keyword.toLowerCase().trim();

        HashSet<Integer> matchingDocuments = keywordIndex.get(keyword);

        if (matchingDocuments == null || matchingDocuments.isEmpty()) {

            System.out.println("\nNo documents found.");
            return;
        }

        System.out.println("\n========== SEARCH RESULTS ==========");

        for (Integer id : matchingDocuments) {

            for (Document document : documents) {

                if (document.getId() == id) {

                    System.out.println("\nDocument Found!");
                    System.out.println("ID: " + document.getId());
                    System.out.println("Title: " + document.getTitle());
                    System.out.println("Content: " + document.getContent());

                    break;
                }
            }
        }
    }
}