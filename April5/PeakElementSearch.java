package April5;
import java.util.Scanner;

/*to search for the peak element which is greater than its neighbour elements
as well as from other elements in the array*/
public class PeakElementSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of array");
        int size = sc.nextInt();//input size

        int[] arr = new int[size];//declaring array
        System.out.println("Enter the elements of array");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();//input element in array
        }

        int peak,maxPeak=0;
        for(int i=1;i<size-1;i++){
            if(arr[i]>arr[i-1] && arr[i]>arr[i+1]){
                peak=arr[i];//peak element is stored
                if(peak>maxPeak)
                    maxPeak=peak;//storing maximum peak element
            }
        }
        System.out.println("Peak element is: "+maxPeak);//displaying the maximum peak value
    }
}
