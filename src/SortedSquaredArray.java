import java.util.Arrays;

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
    int[] array = {1, 2, 3, 5, 6, 8, 9};
    int[] array2 = {-2,-1};
    System.out.println(Arrays.toString(sortedSquaredArray(array)));
    System.out.println(Arrays.toString(sortedSquaredArray(array2)));
  }

  public static int[] sortedSquaredArray(int[] array) {
    for (int i = 0; i < array.length; i++) {
      array[i] = array[i] * array[i];
    }
    return array;
  }
}
