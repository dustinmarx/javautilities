package dustin.utilities.system;

import java.net.InetAddress;
//import java.net.UnknownHostException;
/**
 * This class provides a very simple example of using the java.net.InetAddress
 * class.  It demonstrates methods on the java.net.InetAddress class such as
 * getLocalHost(), getHostName(), getHostAddress(), and getAddress().
 *
 * In addition this class demonstrates the need to catch the checked exception
 * java.net.UnknownHostException (or an exception above it such as Exception).
 *
 * Originally included with "Inspired by Actual Events" blog post "InetAddress Example"
 * (http://marxsoftware.blogspot.com/2008/01/inetaddress-example.html) and again with
 * "Groovy: JVM-based Scripting with Less Ceremony"
 * (http://marxsoftware.blogspot.com/2009/04/groovy-jvm-based-scripting-with-less.html).
 */
public class LocalHostInfo
{
   /**
    * Run simple demonstration of the usefulness of the java.net.InetAddress
    * class.
    *
    * @param aArgs The command line arguments; none expected.
    */
   public static void main(final String[] aArgs)
   {
      InetAddress localhost = null;
      try
      {
         localhost = InetAddress.getLocalHost();
         System.out.println( "InetAddress: " + localhost );
         System.out.println( "\ttoString: " + localhost.toString() );
         System.out.println(  "\tCanonicalHostName: "
            + localhost.getCanonicalHostName() );
         System.out.println( "\tHost Name: " + localhost.getHostName() );
         System.out.println( "\tHost Address: " + localhost.getHostAddress() );
         System.out.println( "\tHost Bytes: " + localhost.getAddress() );
         System.out.println( "\tHash Code: " + localhost.hashCode() );

         // We will now force an UnknownHostException to be thrown.
         InetAddress nonExistent = InetAddress.getByName("nada");
         System.out.println( "Host is: " + nonExistent );  // won't get here!
      }
      catch (/*UnknownHost*/Exception unknownHostException) // checked exception
      {
         System.err.println(  "D'oh!! Unknown Host ("
            + unknownHostException.getClass().toString()
            + "): " + unknownHostException.getMessage() );
      }
   }
}
