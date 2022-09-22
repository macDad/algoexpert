import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by : <B>MadukaJ</B>
 *
 * <p>Date : 6/9/22<br>
 * Project : <B>algoexpert </B><br>
 * Since : version 1.0 <br>
 * Description : This class {@link SortedSquaredArray} use for
 */
public class SortedSquaredArray {
  public static void main(String[] args) {
    int[] array = {-2,-1,0,1, 2, 3, 5, 6, 8, 9};
    int[] array2 = {-2,-1};
    int[] array3 = {-5,-4,-3,-2,-1};
    System.out.println(Arrays.toString(sortedSquaredArray(array)));
    System.out.println(Arrays.toString(sortedSquaredArray(array2)));
    System.out.println(Arrays.toString(sortedSquaredArray(array3)));
  }

  public static int[] sortedSquaredArray(int[] array) {
   int counter = array.length - 1;
   int firstIndex = 0;
   int lastIndex = array.length - 1;
   int[] result = new int[array.length];

    for (int i = 0; i < array.length; i++) {
      if((Math.abs(array[firstIndex])) > Math.abs(array[lastIndex])){
        result[counter - i] = array[firstIndex] * array[firstIndex];
        firstIndex++;
      }else {
        result[counter - i] = array[lastIndex] * array[lastIndex];
        lastIndex--;
      }
    }

   return result;
  }
}
