import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by   : <B>MadukaJ</B>
 *
 * <p>Date      : 6/9/22<br>
 * Project      : <B>algoexpert </B><br>
 * Since        : version 1.0 <br></p>
 * Description  : This class {@link  TwoNumberSum} use for
 */
public class TwoNumberSum {
  public static void main(String[] args) {
    int[] array = {3, 5, -4, 8, 11, 1, -1, 6};
    int[] array2 = {4, 6};
    int targetSum = 10;
    System.out.println(Arrays.toString(twoNumberSum(array, targetSum)));
    System.out.println(Arrays.toString(twoNumberSum(array2, targetSum)));
  }

  public static int[] twoNumberSum(int[] array, int targetSum) {
    Set visited = new HashSet<>();
    for (int i : array) {
      if (visited.contains(targetSum - i)) return new int[] {targetSum - i, i};
      else visited.add(i);
    }
    return new int[0];
  }

  public static int[] twoNumberSumOld(int[] array, int targetSum) {
    for (int i = 0; i < array.length; i++) {
      for (int j = i + 1; j < array.length; j++) {
        if (array[i] + array[j] == targetSum) return new int[] {array[i], array[j]};
      }
    }
    return new int[0];
  }
}
