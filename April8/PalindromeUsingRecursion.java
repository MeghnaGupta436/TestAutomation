package April8;

public class PalindromeUsingRecursion {
        public static void main(String[] args) {
            String str1 = "madam";
            String str2 = "hello";

            System.out.println(str1 + " is a palindrome: " + isPalindrome(str1));
            System.out.println(str2 + " is a palindrome: " + isPalindrome(str2));
        }

        // Recursive method to check if a string is palindrome
        public static boolean isPalindrome(String str) {
            // Base case: if the length of the string is 0 or 1, it's a palindrome
            if (str.length() == 0 || str.length() == 1) {
                return true;
            }

            // Check if the first and last characters are equal
            if (str.charAt(0) == str.charAt(str.length() - 1)) {
                // If the first and last characters are equal,
                // recursively check the substring excluding the first and last characters
                return isPalindrome(str.substring(1, str.length() - 1));
            }

            // If the first and last characters are not equal, the string is not a palindrome
            return false;
        }
}
