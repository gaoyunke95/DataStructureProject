/**
 * the interface of the Stack
 * @author yunkegao
 *
 * @param <AnyType> can be any data Types
 */
public interface Stack<AnyType>
{
  int size();

  boolean isEmpty();

  void push(AnyType newValue);

  AnyType top();

  AnyType pop();
}