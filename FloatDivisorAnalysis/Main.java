import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;
import java.math.BigDecimal;
import static java.math.BigDecimal.ZERO;

/**
 * Explores numbers which fail question #7 of
 * Barron's AP CSA, p83, ie imperfect cancellation
 * https://hal.science/hal-00128124/en
 *
 * Samples four classes of real number:
 * 1) Integer 2) Float tenths 3) Precise tenths 4) Float, random
 * 
 * Tyler C de Laguna <tyler@delaguna.org> 
 */
public class Main {
  public static void main(String[] args) {
    final int SAMPLE_SIZE = 4;
    Stream.of(
        // Whole numbers
        IntStream.iterate(1, n -> ++n).mapToDouble(Double::valueOf),

        // Floating-point tenths
        DoubleStream.iterate(0.1, n -> ++n),
      
         // True decimal tenths
        Stream.iterate(ZERO, x -> x.add(BigDecimal.valueOf(0.1))).mapToDouble(BigDecimal::doubleValue),
           
        // Floating-point, arbitrarily chosen
        new Random().doubles(0, 10)
      
    ).flatMapToDouble(s -> 
          s.parallel().filter(Main::hasError).limit(SAMPLE_SIZE))
     .forEach(System.out::println);
  }

  /* Checks if this number 'x' shows rounding error as divisor. */
  static boolean hasError(double x) {
    final double ORIGINAL = 3.0;
    return ORIGINAL != (ORIGINAL / x) * x;
  }
}
