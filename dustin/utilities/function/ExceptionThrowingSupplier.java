package dustin.utilities.function;

/**
 * Represents a supplier of results that may throw an exception
 * (including checked exception) during its operation.
 */
@FunctionalInterface
public interface ExceptionThrowingSupplier<T, E extends Exception>
{
   /**
    * Supplies a result.
    *
    * @return Result.
    * @throws E Thrown if exception occurs during supplier operation.
    */
   T get() throws E;
}
