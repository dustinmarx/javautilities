package javautilities.dustin.utilities.classloader;

/**
 * Utility class for running operations on an explicitly specified class loader.
 */
public class ClassLoaderSwitcher
{
   /**
    * Execute the specified action on the provided class loader.
    *
    * @param classLoaderToSwitchTo Class loader from which the
    *    provided action should be executed.
    * @param actionToPerformOnProvidedClassLoader Action to be
    *    performed on the provided class loader.
    * @param <T> Type of Object returned by specified action method.
    * @return Object returned by the specified action method.
    */
   public static <T> T executeActionOnSpecifiedClassLoader(
      final ClassLoader classLoaderToSwitchTo,
      final ExecutableAction<T> actionToPerformOnProvidedClassLoader)
   {
      final ClassLoader originalClassLoader = Thread.currentThread().getContextClassLoader();
      try
      {
         Thread.currentThread().setContextClassLoader(classLoaderToSwitchTo);
         return actionToPerformOnProvidedClassLoader.run();
      }
      finally
      {
         Thread.currentThread().setContextClassLoader(originalClassLoader);
      }
   }

   /**
    * Execute the specified action on the provided class loader.
    *
    * @param classLoaderToSwitchTo Class loader from which the
    *    provided action should be executed.
    * @param actionToPerformOnProvidedClassLoader Action to be
    *    performed on the provided class loader.
    * @param <T> Type of Object returned by specified action method.
    * @return Object returned by the specified action method.
    * @throws Exception Exception that might be thrown by the
    *    specified action.
    */
   public static <T> T executeActionOnSpecifiedClassLoader(
      final ClassLoader classLoaderToSwitchTo,
      final ExecutableExceptionableAction<T> actionToPerformOnProvidedClassLoader) throws Exception
   {
      final ClassLoader originalClassLoader = Thread.currentThread().getContextClassLoader();
      try
      {
         Thread.currentThread().setContextClassLoader(classLoaderToSwitchTo);
         return actionToPerformOnProvidedClassLoader.run();
      }
      finally
      {
         Thread.currentThread().setContextClassLoader(originalClassLoader);
      }
   }
}
