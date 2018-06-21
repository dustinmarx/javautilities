package dustin.utilities.function;

/**
 * Represents a predicate (boolean-valued function) of one argument
 * that may throw an exception (even a checked exception).
 */
@FunctionalInterface
public interface ExceptionThrowingPredicate <T, E extends Exception>
{
   /**
    * Evaluates this predicate on the given argument.
    *
    * @param t Input argument.
    * @return {@code true} if the input argument matches the predicate
    *    or {@code false} if the input argument does NOT match the predicate.
    * @throws E Thrown if exception occurs during testing of input
    *    argument against this predicate.
    */
   boolean test(T t) throws E;
}
