import org.junit.Test;
import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }
    @Test
    public void testispalindrome(){
        assertFalse(palindrome.isPalindrome("cat"));
        assertFalse(palindrome.isPalindrome("rancor"));
        assertFalse(palindrome.isPalindrome("horse"));
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome("noon"));
        assertTrue(palindrome.isPalindrome("racecar"));
    }
    @Test
    public void testispalindrome2(){
        CharacterComparator cc = new OffByOne();
        assertFalse(palindrome.isPalindrome("cat",cc));
        assertFalse(palindrome.isPalindrome("rancor",cc));
        assertFalse(palindrome.isPalindrome("horse",cc));
        assertTrue(palindrome.isPalindrome("flake",cc));
//        assertTrue(palindrome.isPalindrome("noon",cc));
//        assertTrue(palindrome.isPalindrome("racecar",cc));
    }
}
