import org.junit.Test;
import static org.junit.Assert.*;

public class testn {
    @Test
    public void testequalChars () {
    OffByN offBy5 = new OffByN(5);
    assertFalse(offBy5.equalChars('f', 'h'));
    assertTrue(offBy5.equalChars('f', 'a'));
    assertTrue(offBy5.equalChars('a', 'f'));
    }
}
