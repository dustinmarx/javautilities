package dustin.utilities.system;

import static java.lang.System.out;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * This class provides a very simple example of using the java.net.InetAddress
 * class.  It demonstrates methods on the java.net.InetAddress class such as
 * getLocalHost(), getHostName(), getHostAddress(), and getAddress().
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
    * @param arguments The command line arguments; none expected.
    */
   public static void main(final String[] arguments)
   {
      try
      {
         final InetAddress localhost = InetAddress.getLocalHost();
         out.println( "InetAddress: " + localhost );
         out.println( "\ttoString: " + localhost.toString() );
         out.println(  "\tCanonicalHostName: "
            + localhost.getCanonicalHostName() );
         out.println( "\tHost Name: " + localhost.getHostName() );
         out.println( "\tHost Address: " + localhost.getHostAddress() );
         out.println( "\tHost Bytes: " + localhost.getAddress() );
         out.println( "\tHash Code: " + localhost.hashCode() );
      }
      catch (UnknownHostException unknownHostException)
      {
         System.err.println(  "D'oh!! Unknown Host ("
            + unknownHostException.getClass().toString()
            + "): " + unknownHostException.getMessage() );
      }
   }
}
