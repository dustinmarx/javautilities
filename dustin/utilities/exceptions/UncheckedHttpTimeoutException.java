package dustin.utilities.exceptions;

import java.net.http.HttpTimeoutException;

/**
 * Unchecked version of {@link java.net.http.HttpTimeoutException}.
 *
 * Thrown when a response is not received within a specified time period.
 */
public class UncheckedHttpTimeoutException extends RuntimeException
{
   /**
    * Constructor accepting a message for the unchecked HTTP timeout exception.
    *
    * @param newMessage Message for the unchecked HTTP timeout exception.
    */
   public UncheckedHttpTimeoutException(final String newMessage)
   {
      super(newMessage);
   }

   /**
    * Construtor accepting new message and causal for unchecked HTTP timeout exception.
    *
    * @param newMessage Message for the unchecked HTTP timeout exception.
    * @param newCausal New causal for this unchecked HTTP timeout exception
    *    (likely to be an instance of {@link HttpTimeoutException}).
    */
   public UncheckedHttpTimeoutException(final String newMessage, final Throwable newCausal)
   {
      super(newMessage, newCausal);
   }

   /**
    * Constructor accepting a causal.
    *
    * @param newCausal New causal for this unchecked HTTP timeout exception
    *    (likely to be an instance of {@link HttpTimeoutException}).
    */
   public UncheckedHttpTimeoutException(final Throwable newCausal)
   {
      super(newCausal);
   }
}
