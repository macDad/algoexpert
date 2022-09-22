import java.util.*;

/**
 * Created by : <B>MadukaJ</B>
 *
 * <p>Date : 22/9/22<br>
 * Project : <B>algoexpert </B><br>
 * Since : version 1.0 <br>
 * Description : This class {@link TournamentWinner} use for
 *
 * <p>There's an algorithms tournament taking place in which teams of programmers compete against
 * each other to solve algorithmic problems as fast as possible. Teams compete in a round robin,
 * where each team faces off against all other teams. Only two teams compete against each other at a
 * time, and for each competition, one team is designated the home team, while the other team is the
 * away team. In each competition there's always one winner and one loser; there are no ties. A team
 * receives 3 points if it wins and 0 points if it loses. The winner of the tournament is the team
 * that receives the most amount of points.
 *
 * <p>Given an array of pairs representing the teams that have competed against each other and an
 * array containing the results of each competition, write a function that returns the winner of the
 * tournament. The input arrays are named <span>competitions</span> and <span>results</span>,
 * respectively. The <span>competitions</span> array has elements in the form of <span>[homeTeam,
 * awayTeam]</span>, where each team is a string of at most 30 characters representing the name of
 * the team. The <span>results</span> array contains information about the winner of each
 * corresponding competition in the <span>competitions</span> array. Specifically,
 * <span>results[i]</span> denotes the winner of <span>competitions[i]</span>, where a
 * <span>1</span> in the <span>results</span> array means that the home team in the corresponding
 * competition won and a <span>0</span> means that the away team won.
 *
 * <p>It's guaranteed that exactly one team will win the tournament and that each team will compete
 * against all other teams exactly once. It's also guaranteed that the tournament will always have
 * at least two teams.
 *
 * <h3>Sample Input</h3>
 *
 * <pre><span class="CodeEditor-promptParameter">competitions</span> = [
 * ["HTML", "C#"],
 * ["C#", "Python"],
 * ["Python", "HTML"],
 * ]
 * <span class="CodeEditor-promptParameter">results</span> = [0, 0, 1]
 * </pre>
 *
 * <h3>Sample Output</h3>
 *
 * <pre>"Python"
 * <span class="CodeEditor-promptComment">// C# beats HTML, Python Beats C#, and Python Beats HTML.</span>
 * <span class="CodeEditor-promptComment">// HTML - 0 points </span>
 * <span class="CodeEditor-promptComment">// C# -  3 points</span>
 * <span class="CodeEditor-promptComment">// Python -  6 points</span>
 * </pre>
 */
public class TournamentWinner {
  public static void main(String[] args) {

    List<String> team1 = new ArrayList<>(List.of("HTML", "C#"));
    List<String> team2 = new ArrayList<>(List.of("C#", "Python"));
    List<String> team3 = new ArrayList<>(List.of("Python", "HTML"));
    ArrayList competitions = new ArrayList<>(List.of(team1, team2, team3));
    ArrayList<Integer> results = new ArrayList<>(List.of(0, 0, 1));
    System.out.println(tournamentWinner(competitions, results));
  }

  public static String tournamentWinner(
      ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
    int winning = 0;
    String team = "";
    Map<String, Integer> map = new HashMap();
    for (int i = 0; i < results.size(); i++) {
      int value = results.get(i);
      final var arrayList = competitions.get(i);
      final var winner = arrayList.get(Math.abs(value - 1));
      Integer count = map.getOrDefault(winner, 0) + 1;
      map.put(winner, count);
      if (count > winning) {
        winning = count;
        team = winner;
      }
    }
    return team;
  }

  public static String tournamentWinner2(
      ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
    Map<String, Integer> map = new HashMap();
    for (int i = 0; i < results.size(); i++) {
      int value = results.get(i);
      final var arrayList = competitions.get(i);
      map.merge(arrayList.get(Math.abs(value - 1)), 1, Integer::sum);
    }
    return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
  }
}
