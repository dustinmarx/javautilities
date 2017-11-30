package dustin.utilities.exceptions;

/**
 * Exception used to communicate a candidate value for
 * a {@code switch} statement not being matched by any
 * of the explicitly provided {@code case} blocks.
 */
public class SwitchOptionNotExpectedException extends RuntimeException
{
   /**
    * Object being switched on for which no matching
    * {@code case} clause existed.
    */
   private final Object switchedObject;

   /**
    * Constructor accepting exception message and the instance
    * upon which the {@code switch} was being attempted when no
    * matching {@code case} was found.
    *
    * @param newMessage Exception summary message.
    * @param newSwitchedObject Object being switched on for
    *    which there was no explicitly specifed {@code case}.
    */
   public SwitchOptionNotExpectedException(
      final String newMessage, final Object newSwitchedObject)
   {
      super(newMessage + " (unable to switch on '" + String.valueOf(newSwitchedObject) + "')");
      switchedObject = newSwitchedObject;
   }

   /**
    * Constructor accepting the instance upon which the {@code switch}
    * was being attempted when no matching {@code case} was found.
    *
    * @param newSwitchedObject Object being switched on for
    *    which there was no explicitly specified {@code case}.
    */
   public SwitchOptionNotExpectedException(final Object newSwitchedObject)
   {
      super(
           "Switch statement did not expect '" + String.valueOf(newSwitchedObject)
         + "'.");
      switchedObject = newSwitchedObject;
   }

   /**
    * Provides String representation of the object being
    * switched upon.
    *
    * @return String representation of the object being
    *    switched upon.
    */
   public String getSwitchedObjectString()
   {
      return String.valueOf(switchedObject);
   }

   /**
    * Provides type of object being switched upon.
    *
    * @return Type of the object being switched upon or
    *    {@code null} if that switched upon object is null.
    */
   public Class getSwitchedObjectType()
   {
      return switchedObject != null ? switchedObject.getClass() : null;
   }
}
