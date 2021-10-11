import java.lang.reflect.Array;
import java.util.ArrayList;

// преобразования
public class SwapMas<T> {

    // меняет местами 2 элемента
    public void Swap(T mas[], int first, int second){
        T k = mas[first];
        mas[first] = mas[second];
        mas[second] = k;
        for (T x: mas){
            System.out.print(x + "   ");
        }
        System.out.print("\n");
    }

    // преобразует массив в ArrayList
    public ArrayList<T> MakeList(T mas[]){
        ArrayList<T> list = new ArrayList<T>();
        for (T x: mas){
            list.add(x);
        }
        System.out.println(list.getClass().getName());
        return list;
    }
}
