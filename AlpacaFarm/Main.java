import java.util.List;
import java.util.Scanner;
import java.util.Random;

/* ---------------------------
/* Tyler: Adaptation from student for AP CS assignment, 2/2024 */
/* ---------------------------*/
public class Main {
  private static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    farm();
  }

  /* Runs a farm with two (or more!) alpacas.
   * Lets the user input, through the console, 
   * how they want to care for the alpacas. */
  public static void farm() {
    List<Alpaca> stable = List.of(new Alpaca("Al Pacino"), new Alpaca("Lily", 1, 7, 9));
    while (stable.stream().noneMatch(Alpaca::isDead)) {
      stable.forEach(System.out::println);
      Alpaca selected = selectAnimal(stable);
      careForAnimal(selected);
      stable.stream().filter(i -> !i.equals(selected)).forEach(Alpaca::doNothing);
    }
  }

  private static void careForAnimal(Alpaca selected) {
    System.out.println("Feed them (1), play with them (2), lull to sleep (3), or hum (4)");
    switch (sc.nextInt()) {
      case 1 -> selected.feed();
      case 2 -> selected.play();
      case 3 -> selected.sleep();
      case 4 -> selected.hum();
      default -> {
        System.out.println("Invalid input, defaulting to hum.");
        selected.hum();
      }
    }
  }

  private static Alpaca selectAnimal(List<Alpaca> stable) {
      System.out.println("Select " + stable.get(0).getName() + " (type '1') or " + stable.get(1).getName() + " (type '2') or Quit (type '3')...");
      return switch (sc.nextInt()) {
          case 1 -> stable.get(0);
          case 2 -> stable.get(1);
          case 3 -> {
              System.out.println("Quitting...\n\n\n");
              System.out.flush();
              System.exit(0);
              yield stable.get(0);
          }
          default -> {
              System.out.println("Invalid input, defaulting to: " + stable.get(0));
              yield stable.get(0);
          }
      };
  }
}

class Alpaca {
    private String name;
    private int hunger, energy, happiness;

    /**
     * Creates an alpaca with the given parameters
     * @param name The name of the alpaca
     * @param hunger The hunger level of the alpaca (low is better)
     * @param energy The energy level of the alpaca (high is better)
     * @param happiness The happiness level of the alpaca (high is better)
     */
    public Alpaca (String name, int hunger, int energy, int happiness) {
        this.name = name;
        this.hunger = hunger;
        this.energy = energy;
        this.happiness = happiness;
    }

    /**
     * Creates an alpaca with a specified name and random
     * levels for hunger, energy, and happiness
     * @param name The name of the alpaca
     */
    public Alpaca(String name) {
        this.name = name;
        hunger = random(1, 5); // added the random method in order to make code easier to read
        energy = random(5, 10); // (not in hand written)
        happiness = random(5, 10);
    }


    /**
     * Decreases the alpaca's hunger level by 2,
     * decreases the alpaca's energy level by 1,
     * and decreases the alpaca's happiness level by 1
     */
    public void feed() {
        hunger -= 2;
        energy -= 1;
        happiness -= 1;
    }

    /**
     * Increases the alpaca's hunger level by 1,
     * increases the alpaca's energy level by 4,
     * and decreases the alpaca's happiness level by 1
     */
    public void sleep() {
        hunger += 1;
        energy += 4;
        happiness -= 1;
    }

    /**
     * Increases the alpaca's hunger level by 1,
     * decreases the alpaca's energy level by 1,
     * and increases the alpaca's happiness level by 3
     */
    public void play() {
        hunger += 1;
        energy -= 1;
        happiness += 3;
    }

    /**
     * Prints out "yeaeh" if happiness > 6, "hmmhm"
     * if 6 > happiness >= 4, and "aaahgh" if 4 > happiness >= 1,
     * and otherwise nothing is printed
     */
    public void hum() {
        if (happiness > 6)
            System.out.println("yeaeh");
        else if (happiness >= 4)
            System.out.println ("hmmhm");
        else if (happiness >= 1)
            System.out.println("aaahgh");
    }

    /**
     * Increases the alpaca's hunger level by 1,
     * decreases the alpaca's energy level by 1,
     * and decreases the alpaca's happiness level by 1
     */
    public void doNothing() {
        hunger += 1;
        energy -= 1;
        happiness -= 1;
    }
    /**
     * @return true if the alpaca is dead,
     * false if it is alive based on these thresholds.
     */
    public boolean isDead() {
      final int STARVATION_THRESHOLD = 10;
      return hunger >= STARVATION_THRESHOLD || energy <= 0 || happiness <= 0;
    }
    /**
     * Updates the name of the alpaca
     * @param name the new name for the alpaca
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Updates the name of the alpaca
     * @param name the new name for the alpaca
     */
    public String getName() {
        return name;
    }

    /**
     * @Override
     * @return A string containing the alpaca's name, hunger, and energy
     */
    public String toString() {
        return "<<" + name + " has a hunger level of " + hunger + " and an energy level of " + energy + ">>";
    }

    /**
     * @param min the minimum random int value (inclusive)
     * @param max the maximum random int value (inclusive)
     * @return random int from min to max (inclusive)
     */
    private static int random(int min, int max) {
        return new Random().ints(1, min, max + 1).findFirst().orElse(min);
    }
}
