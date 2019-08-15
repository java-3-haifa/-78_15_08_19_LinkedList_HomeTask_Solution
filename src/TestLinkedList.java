import java.util.Iterator;
import java.util.function.Consumer;

public class TestLinkedList {
    public static void main(String[] args) {
        Consumer<Integer> print = (i) -> System.out.print("["+i+"]->");
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.add(23);
        list.add(34);
        list.add(56);
        list.add(78);
        list.forEach(print);
        System.out.println();
//        list.remove(4);
//        list.forEach(print);

        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()){
            int v = iterator.next();
            if(v == 78){
                iterator.remove();
            }
        }

        list.add(100);
        list.forEach(print);
        System.out.println();
        list.reverse();
        list.forEach(print);

    }
}
