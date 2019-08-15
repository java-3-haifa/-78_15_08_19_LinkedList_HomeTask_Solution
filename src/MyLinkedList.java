import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements Iterable<T> {
    private Node<T> head;

    public boolean add(T value){
        Node<T> n = new Node<>(value);
        if(head == null){
            head = n;
        }else{
            Node<T> curr = head;
            while(curr.next != null){
                curr = curr.next;
            }
            curr.next = n;
        }
        return true;
    }

    public T get(int index){
        if(index < 0 || head == null){
            throw new IndexOutOfBoundsException(index);
        }
        return node(index).value;
    }

    public T remove(int index){
      if(index < 0 || head == null){
          throw new IndexOutOfBoundsException(index);
      }
      if(index == 0){
          T v = head.value;
          head = head.next;
          return v;
      }
      Node<T> prev = node(index-1);
      if(prev.next == null){
          throw new IndexOutOfBoundsException(index);
      }
      T v = prev.next.value;
      prev.next = prev.next.next;
      return v;
    }

    public void reverse(){
        Node<T> prev = null;
        Node<T> curr = head;
        Node<T> next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public int size(){
        int count = 0;
        Node<T> curr = head;
        while(curr != null){
            count++;
            curr = curr.next;
        }
        return count;
    }
    private Node<T> node(int index){
        Node<T> curr = head;
        for(int i = 0; i < index; i++){
            if(curr.next == null){
                throw new IndexOutOfBoundsException();
            }
            curr = curr.next;
        }
        return curr;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T>{
        private Node<T> curr;
        private int count = -1;
        private boolean isNext = false;

        public MyIterator() {
            curr = head;
        }

        @Override
        public boolean hasNext() {
            return curr != null;
        }

        @Override
        public T next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            isNext = true;
            T v = curr.value;
            curr = curr.next;
            count++;
            return v;
        }

        @Override
        public void remove() {
            if(!isNext){
                throw new NoSuchElementException();
            }else {
                MyLinkedList.this.remove(count);
            }
            count--;
            isNext = false;
        }
    }
    private class Node<T>{
        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }
}
