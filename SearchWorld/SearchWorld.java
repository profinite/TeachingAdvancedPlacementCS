/* -----------------------
 * Challenge Set 7 
 * Perform search chores in Java for AP CS A 
 * 
 * Begin by creating a randomized list of integers
 * and then sort it.
 * 
 * Next, compare two search algorithms to find a "goal" integer.
/* -----------------------
 * @author Tyler C de Laguna <tyler@delaguna.org> (c)2024 GPL3
 */
import java.util.*;
import static java.util.stream.Collectors.toList;

public class SearchWorld {
  public static void main(String[] args) {
      System.out.println("Welcome to Sort-A-Thon 🔢👟🏁");
      new SearchWorld().sortAndSearch();
  }
  private void sortAndSearch() {
      final int GOAL = 600_000;
      List<Integer> list = getRandomList();
      list.add(GOAL);

      sortBySelect(list);

      if(verifySorted(list)) { // verify our sort worked
          System.out.println("Sort succeeded, congrats! 🎖️");
      } else {
        System.out.println("Sort failed, try again!"); 
        return;
      }
      System.out.println("Now let's search...");
      bruteSearch(list, GOAL);
      int stack = binarySearch(list, GOAL);
      System.out.println(" after only [" + stack + "] attempts.");
  }
  
  /* Do a binary search via recursion. 𝚯(log n) runtime 
   * ---------
   * @param list   the list to search
   * @param goal  the integer to search for
   * @return      search attempts */
  public static int binarySearch(List<Integer> list, int goal) {
      final int length = list.size();
      final int midpoint = length / 2;
      final int middle = list.get(midpoint);
    
      if(middle == goal) { // base case
          System.out.print("Found it via binary! " + goal + " ");
          return 1;
      } else if (length == 1) {
          System.out.print("Search unsuccessful... ");
          return 1;
      }
      
      if (middle < goal)
          return 1 + binarySearch(list.subList(midpoint, length), goal);
      return 1 + binarySearch(list.subList(0, midpoint), goal);
  }
  
  /* Do a sequential, brute-force search. 𝚯(n) runtime 
   * ---------
   * @param list   the list to search
   * @param goal  the integer to search for */
  public static void bruteSearch(List<Integer> list, int goal) {
      for(int i = 0; i < list.size(); i++) {
          if(list.get(i) == goal) {
              System.out.println("Found it sequentially after [" + i + "] attempts: " + goal);
              return;
          }
      }
      System.out.println("Sequential search failed");
  }
  
  /* Sort by Selection. 𝚯(n²) runtime 
   * ---------
   * @param list   the list to sort (destructive) */
  void sortBySelect(List<Integer> list) {
      final int penultimate = list.size() - 1;
      for(int i = 0; i < penultimate; i++) {
          int lowest = selectLowest(list, i);
          swap(list, i, lowest);
      }
  }
  
  /* Helper function to swap elements */
  private void swap(List<Integer> list, int i, int j) { 
      int temp = list.get(i);
      list.set(i, list.get(j));
      list.set(j, temp);
  } 
  
  /* Select the lowest element in the remaining sublist */
  private int selectLowest(List<Integer> list, int k) {
      int lowest = k;
      for(int i = k; i < list.size(); i++) {
          if(list.get(i) < list.get(lowest))
              lowest = i;
      }
      return lowest;
  }
  /* Create a mutable random list of size "N". */
  private List<Integer> getRandomList() {
      final int N = 10_000;
      final int BOUND = 1_000_000;
    // new Random().ints(N, 0, BOUND)
      return new Random().ints(N, 0, BOUND).boxed().collect(toList());     
  }
  /* Confirm the list is sorted. */
  private boolean verifySorted(List<Integer> list) {
      List<Integer> backup = new ArrayList<>(list);
      Collections.shuffle(backup);
      Collections.sort(backup);
      return backup.equals(list);
  }
}
