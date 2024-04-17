import java.util.*;

/* -----------
 * Challenge #7.1
 * Escape a labyrinth 🔦 by rotating a list by N turns
 * (Reset the list after each turn)
 * -----------
 */
public class LabyrinthEscape {
  
    public static void main(String[] args) {
      String mesg = "";

      // iterate through the arrays
      for(int i = 0; i < positions.length; i++) {
        int position = positions[i];
        int shifts = rotations[i];
        // call rotate() on them
      }
      
      System.out.println(mesg);
    }
  
    /* Rotate the cipher by N turns to the left, 
     * then read element at 'index' after each step */
    private static String rotate(int N, int index) {
      List<String> copy = new ArrayList<>(cipher);
        // 1) Remove, then append elements to copy to "rotate"
        // 2) Now read the key at the given "index" */
      return "";
    }

  /* Your secret key 🗝️ to the cipher. */
  private final static int[] positions = {80, 113, 95, 113, 35, 23};
  private final static int[] rotations = {33, 60, 80, 50, 9, 138};


  /* Cipher to decode */
  private final static List<String> cipher = List.of ("𐂀","𐂁","𐂂","𐂃","𐂄","𐂅","𐂆","𐂇","𐂈","𐂉","𐂊","	𐂋","	𐂌","	𐂍","	𐂎","	𐂏"," ","𐂐","	𐂑","","ǝdɐɔsǝ o⊥","𐂒","sʞɔolq ","	𐂓","","	𐂔","","	𐂕","","	𐂖","	𐂗","	𐂘"," ǝɥʇ dn", "east"," puɐ ʇɥɓıɹ ","	𐂙","	𐂚","	𐂛","	𐂜","	𐂝","	𐂞","crawl","	𐂟","𐂠","ǝʌıɟ oɓ '","	𐂡","	𐂢","	𐂣", "minotaur", "	𐂤","	𐂥","	𐂦","	𐂧","	𐂨","	𐂩","	𐂪","	𐂫","	𐂬","	𐂭","	𐂮","	𐂯","north","𐂰","	𐂱","	𐂲","	𐂳","	𐂴","	𐂵","	𐂶","	𐂷","	𐂸","	𐂹","	𐂺","	𐂻","	𐂼","	𐂽","	𐂾","	𐂿","𐃀","	𐃁","	𐃂","	𐃃","	𐃄","	𐃅","	𐃆","	𐃇","	𐃈","	𐃉","	𐃊","	𐃋","	𐃌","	𐃍","	𐃎","	𐃏","𐃐","	𐃑","	𐃒","	𐃓","	𐃔","	𐃕","	𐃖","	𐃗","	𐃘","	𐃙","	𐃚","	𐃛","	𐃜","	𐃝","ǝɥʇ","𐃞","	𐃟","𐃠","	𐃡","sɹıɐʇs","	𐃢","	𐃣","	𐃤","	𐃥","	𐃧","	𐃨","	𐃩","	𐃪","	𐃫","	𐃬","	𐃭","	𐃮","	𐃯","𐃰","	𐃱","	𐃲","	𐃳","	𐃴","	𐃵","	𐃶","	𐃷","	𐃸","	𐃹"," ","	𐃺","golden","daedalus");
  
}

/* original author: TCD <tyler@delaguna.org> GPL v3 2024 */
