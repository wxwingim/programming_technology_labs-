import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.util.Collections.reverseOrder;
import static java.util.stream.Collectors.toList;

public class StrArray {
    // массив с набором слов
    String [] array;

    // конструктор
    public StrArray(String [] array){
        this.array = array;
    }

    // поиск
    public void StreamArray(){
        // максимум
        int max = 0;

        // переменная для слова
        String word = "";

        // создание стрима из массива
        Stream<String> stream = Arrays.stream(array);


        // группировка слов и подсчет их количестваб, map
        // стрим из map
        // сортировка (объект map сравнивается с заданным компаратором - сортировка по убыванию ключей map
        // 1ый элемент

        List<String> result =  stream
                .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long> comparingByValue(reverseOrder()).thenComparing(Map.Entry.comparingByKey()))
                .limit(1)
                .map(Map.Entry::getKey)
                .collect(toList());

        // результат выводится в виде "слово (количество)"
        System.out.println(result);
    }
}
