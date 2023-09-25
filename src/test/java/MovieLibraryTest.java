import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class MovieLibraryTest {

    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    void shouldHaveOscar() {
        // when
        MovieLibrary.main(new String[]{});

        // then
        assertThat(outContent.toString()).doesNotContain("Czy otrzymał Oskara: false");
    }

    @BeforeEach
    void init() {
        System.setOut(new PrintStream(outContent));
    }


    @AfterEach
    void cleanup() {
        System.setOut(originalOut);
    }

}
