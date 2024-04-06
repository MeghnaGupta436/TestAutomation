package April5;
import java.util.Arrays;
import java.util.Scanner;
public class ReverseArray {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the size of array");
        int size= sc.nextInt();//input size

        int[] arr=new int[size];//declaring array
        System.out.println("Enter the elements of array");
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();//input elements of array
        }

        //reversing array elements
        int i=0,j=size-1;
        while(i<j){
            int temp=0;
            temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
        //instead of applying loop toString() method can be used
        System.out.println(Arrays.toString(arr));
    }
}
