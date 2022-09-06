
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by : <B>MadukaJ</B>
 *
 * <p>Date : 25/8/22<br>
 * Project : <B>algoexpert </B><br>
 * Since : version 1.0 <br>
 * Description : This class {@link DiskStacking} use for
 */
public class DiskStacking {
  public static void main(String[] args) {
    List<Integer[]> disks =
        twoDArrayToList(
            new Integer[][] {
              {2, 1, 2}, {3, 2, 3}, {2, 2, 8}, {2, 3, 4}, {1, 2, 1}, {4, 4, 5}, {1, 1, 4}
            });
    // new Integer[][] {{2, 1, 2}, {3, 2, 5}, {2, 2, 8}, {2, 3, 4}, {2, 2, 1}, {4, 4, 5}});
    final var integers = diskStacking(disks);
    System.out.println(Arrays.deepToString(integers.toArray()));
  }

  public static <T> List<Integer[]> twoDArrayToList(Integer[][] twoDArray) {
    List<Integer[]> list = new ArrayList<>();
    list.addAll(Arrays.asList(twoDArray));
    return list;
  }

  public static List<Integer[]> diskStacking(List<Integer[]> disks) {
    disks.sort(Comparator.comparing(disk -> disk[0]));
    Integer[] top = null;
    Integer[] bottom = null;
    List<Integer[]> finalList = null;
    List<Integer[]> tempList = new ArrayList<>();
    int height = 0;
    int tempHeight = 0;

    for (int i = 0; i < disks.size(); i++) {
      for (int j = i; j < disks.size(); j++) {
        Integer[] disk = disks.get(j);
        if (top == null) top = disk;
        if (bottom == null) bottom = disk;
        if (disk[0] > top[0] && disk[1] > top[1] && disk[2] > top[2]) {
          tempList.add(top);
          tempHeight += top[2];
          top = disk;
        } else if (disk[0] < bottom[0] && disk[1] < bottom[1] && disk[2] < bottom[2]) {
          tempList.add(bottom);
          tempHeight += bottom[2];
          bottom = disk;
        }
      }
      tempHeight += top[2];
      tempList.add(top);
      if (height < tempHeight) {
        finalList = tempList;
        height = tempHeight;
      }
      tempHeight = 0;
      top = null;
      bottom = null;
      tempList = new ArrayList<>();
    }
    return finalList;
  }
}
