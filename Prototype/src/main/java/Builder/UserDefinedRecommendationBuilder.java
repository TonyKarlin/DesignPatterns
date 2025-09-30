package Builder;

import Library.Book;
import Library.Recommendation;

public class UserDefinedRecommendationBuilder {
    private Recommendation recommendation;

    public UserDefinedRecommendationBuilder() {
        reset();
    }

    private void reset() {
        recommendation = new Recommendation();
    }

    public void setTargetAudience(String targetAudience) {
        recommendation.setTargetAudience(targetAudience);
    }

    public void addBook(Book book) {
        recommendation.addBookToRecommendations(book);
    }

    public Recommendation getResult() {
        Recommendation builtCollection = recommendation;
        reset();
        return builtCollection;
    }
}
