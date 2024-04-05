package April4;
import java.util.Scanner;
public class StringIsPalindromeOrNot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);//object of scanner class created

        System.out.println("Enter a string");
        String str = sc.nextLine();//input string
        int n = str.length();//size of string

        if(toCheckPalindrome(str, n)==true)//is true means it is palindrome
        System.out.println("Is Palindrome");
        else
            System.out.println("Not palindrome");//false

    }
    //method to check if the string entered is palindrome or not
    //is case sensitive
    public static boolean toCheckPalindrome(String str, int n) {
        int i = 0, j = n - 1;
        while (i < j) {
            //if characters compared not same means not palindrome
            if (str.charAt(i) != str.charAt(j))//to check characters at i and j
                return false;
            else{//if same then i and j both will be updated
                i++;
                j--;}
        }
        return true;//if all the characters compared are equal
    }
}
