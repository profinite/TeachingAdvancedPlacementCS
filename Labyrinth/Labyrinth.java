import java.util.*;
import java.util.stream.*;

/* Challenge #7.1
 * Escape a labyrinth by shifting a List backwards 
 * Reference Implementation 🔬
 */
public class Labyrinth {
  
    public static void main(String[] args) {
      String msg = "";
      
      for(int i = 0; i < indices.length; i++) {
        msg += rotate(rotations[i], indices[i]); 
      }
      System.out.println(msg);
    }
  
    /* Rotate the cipher by N turns to the left, 
     * then read element at 'index' 
     * 
     * "Rotation" can be achieved by successively removing and 
     * re-adding elements. (alternatives exist) */
    private static String rotate(int N, int index) {
      List<String> key = new ArrayList<String>(cipher);
      for(int i = 0; i < N; i++) {
        String first = key.remove(0);
        key.add(first);
      }
      return key.get(index % key.size());
    }

 
  private final static int[] indices = {80, 113, 95, 113, 35, 23};
  private final static int[] rotations = {33, 60, 80, 50, 9, 138};
  private final static List<String> cipher = List.of ("𐂀","𐂁","𐂂","𐂃","𐂄","𐂅","𐂆","𐂇","𐂈","𐂉","𐂊","	𐂋","	𐂌","	𐂍","	𐂎","	𐂏"," ","𐂐","	𐂑","","ǝdɐɔsǝ o⊥","𐂒","sʞɔolq ","	𐂓","","	𐂔","","	𐂕","","	𐂖","	𐂗","	𐂘"," ǝɥʇ dn", "east"," puɐ ʇɥɓıɹ ","	𐂙","	𐂚","	𐂛","	𐂜","	𐂝","	𐂞","crawl","	𐂟","𐂠","ǝʌıɟ oɓ '","	𐂡","	𐂢","	𐂣", "minotaur", "	𐂤","	𐂥","	𐂦","	𐂧","	𐂨","	𐂩","	𐂪","	𐂫","	𐂬","	𐂭","	𐂮","	𐂯","north","𐂰","	𐂱","	𐂲","	𐂳","	𐂴","	𐂵","	𐂶","	𐂷","	𐂸","	𐂹","	𐂺","	𐂻","	𐂼","	𐂽","	𐂾","	𐂿","𐃀","	𐃁","	𐃂","	𐃃","	𐃄","	𐃅","	𐃆","	𐃇","	𐃈","	𐃉","	𐃊","	𐃋","	𐃌","	𐃍","	𐃎","	𐃏","𐃐","	𐃑","	𐃒","	𐃓","	𐃔","	𐃕","	𐃖","	𐃗","	𐃘","	𐃙","	𐃚","	𐃛","	𐃜","	𐃝","ǝɥʇ","𐃞","	𐃟","𐃠","	𐃡","sɹıɐʇs","	𐃢","	𐃣","	𐃤","	𐃥","	𐃧","	𐃨","	𐃩","	𐃪","	𐃫","	𐃬","	𐃭","	𐃮","	𐃯","𐃰","	𐃱","	𐃲","	𐃳","	𐃴","	𐃵","	𐃶","	𐃷","	𐃸","	𐃹"," ","	𐃺","golden","daedalus");

   private void generate() {
    List<Integer> indices = List.of(113, 32, 34, 22, 44, 20);     
    List<Integer> rotations = new Random()
        .ints(indices.size(), 0, cipher.size()).boxed().toList();
     List<Integer> foo = IntStream.range(0, indices.size() - 1)
        .map(i -> indices.get(i) - rotations.get(i))
        .map(i -> { if(i < 0) return i + cipher.size(); else return i; })
        .boxed()
        .toList(); 
      System.out.println(foo);   
  }  
}

/* SAVE: original indices. 
//      String msg = cipher.get(113) + cipher.get(32) + cipher.get(34) + cipher.get(22) + cipher.get(44) + cipher.get(20);
    //  final int[] rotations =      {33, 60, 80, 50, 9};
*/
/* original author Tyler de L <tyler@delaguna.org> GPL3 2024 */
