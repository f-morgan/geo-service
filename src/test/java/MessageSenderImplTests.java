import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSender;
import ru.netology.sender.MessageSenderImpl;

import java.util.Map;
import java.util.stream.Stream;

public class MessageSenderImplTests {
    MessageSender sut;

    @BeforeEach
    public void init() {
        System.out.println("Test started");
        sut = Mockito.spy(new MessageSenderImpl(new GeoServiceImpl(), new LocalizationServiceImpl()));
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

    @ParameterizedTest
    @MethodSource("source")
    public void testMessageSender(Map<String, String> test, String expected) {
        Assertions.assertEquals(expected, sut.send(test));
    }

    private static Stream<Arguments> source() {
        return Stream.of(
                Arguments.of(Map.of("x-real-ip", "172.0.32.11"), "Добро пожаловать"),
                Arguments.of(Map.of("x-real-ip", "96.0.32.11"), "Welcome")
        );
    }

    @Test
    public void testMessageSenderArgumentCaptor() {
        //arrange
        Map<String, String> headers = Map.of("x-real-ip", "172.14.25.22");
        ArgumentCaptor<Map<String, String>> argumentCaptor = ArgumentCaptor.forClass(Map.class);

        //act
        sut.send(headers);

        //assert
        Mockito.verify(sut).send(argumentCaptor.capture());
        Assertions.assertEquals(headers, argumentCaptor.getValue());
    }
}
