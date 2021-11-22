import org.junit.jupiter.api.*;
import ru.netology.entity.Country;
import ru.netology.geo.GeoServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeoServiceImplTests {
    GeoServiceImpl sut;

    @BeforeEach
    public void init() {
        System.out.println("Test started");
        sut = new GeoServiceImpl();
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
    public void testGeoService() {
        //arrange
        String test = "96.78.25.45";
        Country expected = Country.USA;

        //act
        Country result = sut.byIp(test).getCountry();

        //assert
        assertEquals(expected, result);
    }
}
