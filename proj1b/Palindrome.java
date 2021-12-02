import static org.junit.Assert.assertFalse;

public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque a = new LinkedListDeque();
        for (int i = 0; i < word.length(); i += 1) {
            char b = word.charAt(i);
            a.addLast(b);
        }
        return a;
    }

    public boolean isPalindrome(String word) {
        if (word.length() <= 1) {
            return true;
        }
        Deque<Character> q = wordToDeque(word);
        return helper(q);
    }

    public boolean helper(Deque q) {
        Object a = q.removeFirst();
        Object b = q.removeLast();
        if (a != b) {
            return false;
        }
        if (q.size() <= 1) {
            return true;
        }
        return helper(q);

    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> q = wordToDeque(word);
        if (q.size() <= 1) {
            return true;
        }
        if (!cc.equalChars(q.removeFirst(), q.removeLast())) {
            return false;
        }
        else {return true;}
    }

}
