import static org.junit.Assert.assertThrows;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;

public class PathTest {
    Path path;

    //Boundary Value tests

    //empty string
    @Test
    void testMatches1() throws URISyntaxException {
        this.path = new Path("");
        assert path.matches(new URI(""),Method.ALL);
    }

    //1 character
    @Test
    void testMatches2() throws URISyntaxException {
        this.path = new Path("a");
        assert path.matches(new URI("a"),Method.ALL);
    }

    //string with over 255 characters
    @Test
    void testMatches3() throws URISyntaxException {
        this.path = new Path("http://JZ7K9I9JWJDP4BVN6ZSAELTRTIL39D3XKP0E9W3SY8SGKIE6PQGLBCOUC99KCC2IVZLPLMUJD695L62Z9CCKR98BGVYYG5W31T054CJSPFM3FW7VU8L8LYTLPC750PKJKA9T4DW1UD50HLYKU3NO9G0QR5Z4WFERC38SOBD5TYQMY70RXVYLSAWVPI9IQ9569OTUOOB8MLSSJ73X0RQW2VWQVPEXZF8P5HF6ML5VFFLTR06JLUS8TASUSC0DRY19");
        assert path.matches(new URI("http://JZ7K9I9JWJDP4BVN6ZSAELTRTIL39D3XKP0E9W3SY8SGKIE6PQGLBCOUC99KCC2IVZLPLMUJD695L62Z9CCKR98BGVYYG5W31T054CJSPFM3FW7VU8L8LYTLPC750PKJKA9T4DW1UD50HLYKU3NO9G0QR5Z4WFERC38SOBD5TYQMY70RXVYLSAWVPI9IQ9569OTUOOB8MLSSJ73X0RQW2VWQVPEXZF8P5HF6ML5VFFLTR06JLUS8TASUSC0DRY19"),Method.ALL);
    }


    //Class Partitioning tests

    //correct link
    @Test
    void testMatches4() throws URISyntaxException {
        this.path = new Path("http://localhost",Method.ALL);
        assert path.matches(new URI("http://localhost"),Method.ALL);
    }

    //correct link with port
    @Test
    void testMatches5() throws URISyntaxException {
        this.path = new Path("http://localhost:8080",Method.ALL);
        assert path.matches(new URI("http://localhost:8080"),Method.ALL);
    }

    //starting with symbol
    @Test
    void testMatches6() throws URISyntaxException {
        this.path = new Path("@localhost:8080");
        assertThrows(URISyntaxException.class, () -> {
            path.matches(new URI("@localhost:8080"),Method.ALL);
        } );    }

    //include forbidden characters
    @Test
    void testMatches7() throws URISyntaxException {
        this.path = new Path("incorrect link");
        assertThrows(URISyntaxException.class, () -> {
            path.matches(new URI("incorrect link"),Method.ALL);
        } );
    }
}
