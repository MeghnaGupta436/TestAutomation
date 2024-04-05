package April4;
import java.util.Scanner;
public class CalculateConsonantsAndVowels {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);//Scanner class object created

        System.out.println("Enter a string");
        String str=sc.nextLine();//String input
        int n=str.length();
        int countVowel=0,countConsonant=0;//count variables

        for(int i=0;i<n;i++) {
            char ch = str.charAt(i);
            switch (ch) {
                //case for vowels
                case 'a','A', 'e','E', 'i','I', 'o','O', 'u','U':
                    countVowel++;
                    break;
                default://case for consonants
                    countConsonant++;
            }
        }
        //displaying the vowels and consonants
        System.out.println("No. of vowels: "+countVowel);
        System.out.println("No. of consonants: "+countConsonant);
    }
}
