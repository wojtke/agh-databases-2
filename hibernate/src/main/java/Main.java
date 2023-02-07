import java.util.Arrays;
import java.util.List;

/**
 * Defines the entry point of the Java application.
 */
public class Main {

    private static final JPAService jpaService = JPAService.getInstance();

    public static void main(String[] args) {
        try {

        } finally {
            jpaService.shutdown();
        }
    }

}