package dustin.utilities.function;

/**
 * Represents an operation that accepts a single argument but
 * returns no result and may throw an exception (including a
 * checked exception) during its execution.
 */
@FunctionalInterface
public interface ExceptionThrowingConsumer<T, E extends Exception>
{
   /**
    * Performs this consuming operation on the provided argument.
    *
    * @param t Input argument (argument to be consumed).
    * @throws E Exception that may be thrown during this operation.
    */
   void accept(T t) throws E;
}
