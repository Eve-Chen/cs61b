public class Palindrome{
    public static Deque<Character> wordToDeque(String word){
        Deque<Character> deque = new ArrayDeque<Character>();

        for (int i = 0; i<word.length();i++){
            deque.addLast(word.charAt(i));
         }
         return deque;
    }

    public static boolean isPalindrome(String word) {
        Deque<Character> deque = wordToDeque(word);
        return isPalindrome(deque);
    }
    public static boolean isPalindrome(Deque<Character> deque) {
        if (deque.size() <= 1) {
            return true;
        }
        if (deque.removeFirst() == deque.removeLast()) {
            return isPalindrome(deque);
        }
        return false;
    }

    public static boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> deque = wordToDeque(word);
        return isPalindrome(deque, cc);
    }
    public static boolean isPalindrome(Deque<Character> characters, CharacterComparator cc) {
        if (characters.size() <= 1) {
            return true;
        }
        if (cc.equalChars(characters.removeFirst(), characters.removeLast())) {
            return isPalindrome(characters, cc);
        }
        return false;
    }
}
