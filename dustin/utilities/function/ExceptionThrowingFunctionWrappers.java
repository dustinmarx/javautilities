package dustin.utilities.function;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Contains static methods intended for wrapping standard functions
 * with "wrapper" functions that are capable of throwing checked
 * exceptions.
 */
public class ExceptionThrowingFunctionWrappers
{
   /**
    * Accepts a Function that potentially throws an Exception
    * (even a checked exception), but only throws an unchecked
    * exception if a checked or unchecked exception is encountered.
    *
    * @param wrappedFunction Function that potentially throws a checked
    *    exception.
    * @param <T> Function's input argument.
    * @param <R> Function's return value.
    * @param <E> Potential exception that wrapped function may throw.
    * @return Standard JDK Function that only throws unchecked exceptions.
    */
   public static <T, R, E extends Exception> Function<T, R> wrapFunction(
      final ExceptionThrowingFunction<T, R, E> wrappedFunction)
   {
      return inputArgument ->
      {
         try
         {
            return wrappedFunction.apply(inputArgument);
         }
         catch (Exception exception)
         {
            throw new RuntimeException(exception);
         }
      };
   }

   /**
    * Accepts a Consumer that potentially throws an Exception
    * (even a checked exception), but only throws an unchecked
    * exception when the checked or unchecked exception is
    * encountered.
    *
    * @param wrappedConsumer Consumer that potentially throws
    *    a checked exception.
    * @param <T> Input argument.
    * @param <E> Potential exception thrown by provided Consumer.
    * @return Standard JDK Consumer that only throws unchecked exceptions.
    */
   public static <T, E extends Exception> Consumer<T> wrapConsumer(
      final ExceptionThrowingConsumer<T, E> wrappedConsumer)
   {
      return consumed ->
      {
        try
        {
           wrappedConsumer.accept(consumed);
        }
        catch (Exception exception)
        {
           throw new RuntimeException(exception);
        }
      };
   }

   /**
    * Accepts a Supplier that potentially throws an Exception
    * (even a checked exception), but only throws an unchecked
    * exception when the checked or unchecked exception is
    * encountered.
    *
    * @param wrappedSupplier Supplier that potentially throws
    *    a checked exception.
    * @param <T> Supplied result.
    * @param <E> Potential exception thrown by provided Supplier.
    * @return Standard JDK Supplier that only throws unchecked exceptions.
    */
   public static <T, E extends Exception> Supplier<T> wrapSupplier(
      final ExceptionThrowingSupplier<T, E> wrappedSupplier)
   {
      return () ->
      {
         try
         {
            return wrappedSupplier.get();
         }
         catch (Exception exception)
         {
            throw new RuntimeException(exception);
         }
      };
   }

   /**
    * Accepts a Predicate that potentially throws an Exception
    * (even a checked exception), but only throws an unchecked
    * exception when the checked or unchecked exception is
    * encountered.
    *
    * @param wrappedPredicate Predicate that potentially throws
    *    a checked exception.
    * @param <T> Supplied value to be tested against predicate.
    * @param <E> Potential exception thrown by predicate.
    * @return Standard JDK Predicate that only throws unchecked exceptions.
    */
   public static <T, E extends Exception> Predicate<T> wrapPredicate(
      final ExceptionThrowingPredicate<T, E> wrappedPredicate)
   {
      return test ->
      {
         try
         {
            return wrappedPredicate.test(test);
         }
         catch (Exception exception)
         {
            throw new RuntimeException(exception);
         }
      };
   }
}
