package dustin.utilities.io;

import java.util.Locale;

import static java.lang.System.out;

/**
 * Process Java serialized file header strings.
 */
public class StreamHeaderAnalyzer
{
   /**
    * Convert provided hex string input to a string representation of
    * the corresponding "ASCII" text and corresponding decimal integer
    * values. This method assumes that the provided hexadecimal string
    * has an even number of characters, with each pair of hexadecimal
    * characters (single hex character represents one byte [8 bits] and
    * pair of hexadecimal characters represents two bytes [16 bits],
    * which is what represents a single Java character) potentially
    * representing a single "ASCII" character.
    *
    * For additional background details, see
    * https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
    * and
    * http://www.asciitable.com/
    *
    * @param hexInput Hexadecimal String representation (even number of
    *    hexadecimal characters should be provided and should not be
    *    {@code null} or empty).
    * @return "ASCII" characters and decimal integers corresponding to the
    *    provided hexadecimal in format
    *    "{@code XXXXXXXX ==> nnn nnn nnn nnn ==> xxxx}"
    *    where "{@code XXXXXXXX}" represents the provided hexadecimal
    *    characters, "{@code nnn}" represents the three-digit decimal
    *    integer corresponding to each pair of hexadecimal characters,
    *    and "{@code x}" represents an "ASCII" character corresponding to
    *    each hexadecimal character. The example provided here assumes 8
    *    hexadecimal characters provided, but any even number of hexadecimal
    *    characters will be processed with the returned string having half
    *    that number of "ASCII" characters and half that number of
    *    three-digit decimal integers. Note that non-ASCII characters will
    *    be returned, but may not be presented in a meaningful way if
    *    outside of the range of 0x20 (decimal integer 32) through 0x7E
    *    (decimal integer 126).
    */
   private static String hexToAscii(final String hexInput)
   {
      final int length = hexInput.length();
      final StringBuilder ascii = new StringBuilder();
      final StringBuilder integers = new StringBuilder();
      for (int i = 0; i < length; i+=2)
      {
         final String twoDigitHex = hexInput.substring(i, i+2);
         final int integer = Integer.parseInt(twoDigitHex, 16);
         ascii.append((char)integer);
         integers.append(String.format(Locale.US, "%03d", integer)).append(" ");
      }
      return hexInput + " ==> " + integers.deleteCharAt(integers.length()-1).toString() + " ==> " + ascii.toString();
   }

   /**
    * Executable function that accepts a single hexadecimal string
    * and writes the ASCII equivalent of that hexadecimal string
    * and integer decimal equivalent of that hexadecimal string to
    * standard output.
    *
    * @param arguments Command-line arguments: single hexadecimal
    *    string is expected.
    */
   public static void main(String[] arguments)
   {
      if (arguments.length < 1)
      {
         out.println("\nERROR: Specify 'invalid header' hexadecimal string as argument.\n");
         System.exit(-1);
      }

      final String hexInput = arguments[0];
      out.println(hexToAscii(hexInput));
   }
}
