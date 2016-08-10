package dustin.utilities.classloader;

/**
 * Encapsulates action to be executed.
 */
public interface ExecutableAction<T>
{
   /**
    * Execute the operation.
    *
    * @return Optional value returned by this operation;
    *    implementations should document what, if anything,
    *    is returned by implementations of this method.
    */
   T run();
}
