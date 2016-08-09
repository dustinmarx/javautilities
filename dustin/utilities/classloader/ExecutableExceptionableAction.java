package javautilities.dustin.utilities.classloader;

/**
 * Describes action to be executed that is declared
 * to throw a checked exception.
 */
public interface ExecutableExceptionableAction<T>
{
   /**
    * Execute the operation.
    *
    * @return Optional value returned by this operation;
    *    implementations should document what, if anything,
    *    is returned by implementations of this method.
    * @throws Exception that might be possibly thrown by this
    *    operation.
    */
   T run() throws Exception;
}
