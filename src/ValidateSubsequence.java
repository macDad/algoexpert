
import java.util.Arrays;
import java.util.List;

/**
 * Created by : <B>MadukaJ</B>
 *
 * <p>Date : 6/9/22<br>
 * Project : <B>algoexpert </B><br>
 * Since : version 1.0 <br>
 * Description : This class {@link ValidateSubsequence} use for
 */
public class ValidateSubsequence {
  public static void main(String[] args) {
    List<Integer> array = Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10);
    List<Integer> sequence = Arrays.asList(1, 6, -1, 10);
    System.out.println(isValidSubsequence(array, sequence));
    System.out.println(isValidSubsequence(array, sequence));
  }

  public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
      int content = 0;
      for (int i = 0; i < array.size(); i++){
        if(array.get(i)==sequence.get(content))++content;
        if(sequence.size() == content)return true;
    }

      return false;
  }
}
