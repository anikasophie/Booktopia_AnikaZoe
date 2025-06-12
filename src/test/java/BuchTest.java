import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BuchTest {

    @Test
    void ToStringTest() {
        Buch buch = new Buch("Harry Potter", "J.K. Rowling", true, "Fantasy", 5);
        String expected = "Harry Potter | J.K. Rowling | Genre: Fantasy | Fortsetzung: Ja | Bewertung: 5★\n";
        assertEquals(expected, buch.toString());
    }
}