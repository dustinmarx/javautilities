package dustin.utilities.function;

/**
 * Represents a function that accepts a single argument and produces
 * a single result, but may also throw an exception (including checked
 * exception) during execution.
 */
@FunctionalInterface
public interface ExceptionThrowingFunction<T, R, E extends Exception>
{
   /**
    * Applies this function to the given argument and potentially
    * throws the specified type of Exception.
    *
    * @param t Function argument (argument to which function will be applied).
    * @return Function result.
    * @throws E Exception that may be thrown during execution of this
    *     function against the provided argument.
    */
   R apply(T t) throws E;
}
