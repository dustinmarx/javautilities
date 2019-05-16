package dustin.utilities.jdk8;

import java.util.function.Supplier;

import static java.util.Objects.requireNonNull;

/**
 * Provides support for methods provided in {@link java.util.Objects}
 * after JDK 8.
 * @deprecated This class is intended only for use in JDK 8. For later
 *    versions of the JDK, {@link java.util.Objects}'s implementations
 *    of the methods provided in this class should be used instead.
 */
@Deprecated
public class Objects
{
   /**
    * Returns the first argument if it is non-{@code null} and
    * otherwise returns the non-{@code null} second argument.
    *
    * @param obj Object that will be returned if it's not {@code null}.
    * @param defaultObj Non-{@code null} object to return if the first
    *    argument is {@code null}.
    * @param <T> Type of the reference.
    * @return First argument if it is non-{@code null} and
    *    otherwise the second argument if it is non-{@code null}.
    * @throws NullPointerException Thrown if both {@code obj} is
    *    {@code null} and {@code defaultObj} are {@code null}.
    */
   public static <T> T requireNonNullElse(T obj, T defaultObj)
   {
      return obj != null ? obj : requireNonNull(defaultObj, "defaultObj");
   }

   /**
    * Returns the first argument if it is non-{@code null} and otherwise
    * returns the non-{@code null} value of {@code supplier.get()}.
    *
    * @param obj Object that will be returned if it's not {@code null}.
    * @param supplier Supplier of a non-{@code null} object to return if
    *    the first argument is {@code null}.
    * @param <T> Type of the first argument and return type.
    * @return First argument if it is non-{@code null} and otherwise
    *         the value from {@code supplier.get()} if it is non-{@code null}.
    * @throws NullPointerException if both {@code obj} is null and
    *        either the {@code supplier} are {@code null} or
    *        the {@code supplier.get()} value is {@code null}.
    */
   public static <T> T requireNonNullElseGet(T obj, Supplier<? extends T> supplier)
   {
      return  obj != null
            ? obj
            : requireNonNull(requireNonNull(
               supplier, "supplier").get(), "supplier.get()");
   }
}
