import Builder.Director;
import Builder.UserDefinedRecommendationBuilder;
import Library.Book;
import Library.Recommendation;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Recommendation> registry = new HashMap<>();

        Director director = new Director();
        UserDefinedRecommendationBuilder builder = new UserDefinedRecommendationBuilder();
        director.buildACollectionOfRecommendations(builder);
        Recommendation recommendation = builder.getResult();

        Recommendation clone = recommendation.clone();
        registry.put("Comp Science books", clone);

        // Checks to see if the copying works
        System.out.println("Number of cloned collections: " + registry.size());
        System.out.println("Number of books in the cloned collection: " + clone.getRecommendations().size());
        System.out.println(clone);

        Book toBeRemoved = clone.getBookByName("Pragmatic Programmer");

        clone.removeBookFromRecommendations(toBeRemoved);

        System.out.println("Number of books in the original collection: " + recommendation.getRecommendations().size());
        System.out.println("Number of books in the cloned collection: " + clone.getRecommendations().size());

        // Check to see if the Builder pattern works
        director.buildACollectionOfRecommendations(builder);
        Recommendation recommendation2 = builder.getResult();
        Recommendation clone2 = recommendation2.clone();

        registry.put("Fantasy books", clone2);

        System.out.println("Number of clones in the registry: " + registry.size());


    }
}
