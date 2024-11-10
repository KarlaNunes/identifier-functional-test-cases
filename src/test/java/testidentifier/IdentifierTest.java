package testidentifier;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IdentifierTest {
    private final Identifier identifier = new Identifier();

    @Test
    void shouldReturnValidWhenStartsWithALetter() {
        String validId = "caso1";
        assertTrue(identifier.validateIdentifier(validId));
    }

    @Test
    void shouldReturnFalseWhenStartsWithNumber() {
        String invalidId = "2caso";
        assertFalse(identifier.validateIdentifier(invalidId));
    }

    @Test
    void shouldReturnFalseWhenStartsWithSpecialCharacter() {
        String invalidId = "&Caso";
        assertFalse(identifier.validateIdentifier(invalidId));
    }

    @Test
    void shouldReturnTrueWhenOnlyHasLetters() {
        String validId = "casot";
        assertTrue(identifier.validateIdentifier(validId));
    }

    @Test
    void shouldReturnFalseWhenHasLettersAndSpecialCharacters() {
        String invalidId = "caso&";
        assertFalse(identifier.validateIdentifier(invalidId));
    }

    @Test
    void shouldReturnTrueWhenHasLettersAndAtLeastANumber() {
        String validId = "teste5";
        assertTrue(identifier.validateIdentifier(validId));
    }

    @Test
    void shouldReturnFalseWhenOnlyHasSpecialCharacters() {
        String invalidId = "-_*/…";
        assertFalse(identifier.validateIdentifier(invalidId));
    }

    @Test
    void shouldReturnFalseWhenValueIsEmpty() {
        String invalidId = "";
        assertFalse(identifier.validateIdentifier(invalidId));
    }

    @Test
    void shouldReturnFalseWhenHasSevenCharacters() {
        String invalidId = "Testec6";
        assertFalse(identifier.validateIdentifier(invalidId));
    }

    @Test
    void shouldReturnTrueWhenHasOneCharacter() {
        String validId = "t";
        assertTrue(identifier.validateIdentifier(validId));
    }

    @Test
    void shouldReturnTrueWhenHasSixCharacters() {
        String validId = "testes";
        assertTrue(identifier.validateIdentifier(validId));
    }


}