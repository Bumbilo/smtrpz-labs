package Lab2;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonTest {

    @Test
    void equals_EqualsMethodCorrect_ReturnsTrue() {
        EqualsVerifier.forClass(Person.class).verify();
    }

    @Test
    void shouldBeEqualsAfterSerializationAndDeserialization() {
        Person person = new Person(45, 180, 80, "Evgeniy");

        Person deserializedPerson = person.fromJson(person.toJson());
        assertTrue(deserializedPerson.equals(person));
    }

    @Test
    public void shouldSerializePerson() {
        Person person = new Person(45, 180, 80, "Evgeniy");
        assertEquals("{\n" +
                "  \"age\": 45,\n" +
                "  \"height\": 180,\n" +
                "  \"weight\": 80,\n" +
                "  \"name\": \"Evgeniy\"\n" +
                "}", person.toJson());
    }

    @Test
    public void shouldDeserializePerson() {
        String json = "{\n" +
                "  \"age\": 45,\n" +
                "  \"height\": 180,\n" +
                "  \"weight\": 80,\n" +
                "  \"name\": \"Evgeniy\"\n" +
                "}";
        Person person = new Person(45, 180, 80, "Evgeniy");
        Person deserializedPerson = person.fromJson(json);
        assertEquals(person, deserializedPerson);
    }
}
