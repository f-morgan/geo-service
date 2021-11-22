import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationServiceImpl;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocalizationServiceImplTests {
    LocalizationServiceImpl sut;

    @BeforeEach
    public void init() {
        System.out.println("Test started");
        sut = new LocalizationServiceImpl();
    }

    @BeforeAll
    public static void started() {
        System.out.println("Tests started");
    }

    @AfterEach
    public void finished() {
        System.out.println("Test finished");
    }

    @AfterAll
    public static void finshedAll() {
        System.out.println("Tests completed");
    }

    @Test
    public void testLocalisation() {
        //arrange
        Country test = Country.RUSSIA; String expected = "Добро пожаловать";

        //act
        String result = sut.locale(test);

        //assert
        assertEquals(expected, result);
    }

}
