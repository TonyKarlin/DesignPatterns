package Library;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Recommendation implements Cloneable {
    private String targetAudience;
    private List<Book> recommendations;
    private boolean audienceSet = false;

    public Recommendation() {
        this.targetAudience = null;
        this.recommendations = new ArrayList<>();
    }

    public void addBookToRecommendations(Book book) {
        System.out.println("\nBook added to collection:\n");
        System.out.println(book);
        this.recommendations.add(book);
    }

    // I don't want the target audience to change if a collection is already defined
    public void setTargetAudience(String targetAudience) {
        if (!audienceSet) {
            this.targetAudience = targetAudience;
            this.audienceSet = true;
        } else {
            System.out.println("The collection is already targeting an audience.\n" +
                    "Consider making your own collection or copying the existing one," +
                    " if you disagree with the already targeted audience.");
        }
    }

    public void removeBookFromRecommendations(Book book) {
        // Ran into ConcurrentModificationException with forEach, so switched to removeIf();
        boolean removed = this.recommendations.removeIf(
                recommendation -> recommendation.getTitle().equals(book.getTitle())
        );

        if (removed) {
            System.out.println(book);
            System.out.println("\nRemoved from the collection.");
        }
    }

    public Book getBookByName(String name) {
        String title;
        for (Book recommendation : this.recommendations) {
            title = recommendation.getTitle();
            if (title.equalsIgnoreCase(name)) {
                return recommendation;
            }
        }
        return null;
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public List<Book> getRecommendations() {
        return recommendations;
    }

    @Override
    public Recommendation clone() { // Logic for creating a Prototype deep copy
        try {
            Recommendation clone = (Recommendation) super.clone();
            clone.recommendations = new ArrayList<>(); // To avoid ConcurrentModificationException in deep copy

            clone.audienceSet = false;
            clone.setTargetAudience(targetAudience);

            for (Book book : this.recommendations) {
                clone.addBookToRecommendations(book.clone()); // Clones the Books
            }

            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "\nAudience: " + this.targetAudience + "\n" +
                recommendations.stream()
                        .map(Book::toString);
    }
}
