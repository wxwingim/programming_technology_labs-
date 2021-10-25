import java.util.Arrays;

public class Mas2 {
    final  int size  = 10000000;
    final  int half  = size /  10;
    float [] arr  =  new  float[size];

    public void Mas(){
        // заполнение единицами
        Arrays.fill(arr, 1);

        // время
        long a = System.currentTimeMillis();

        // разделение массивов
        float [] mas1 = Arrays.copyOfRange(arr, 0, half);
        float [] mas2 = Arrays.copyOfRange(arr, half, size);

        // просчет массивов
        Thread first = new Thread(new Run(mas1, 0));

        Thread second = new Thread(new Run(mas2, half));

        first.start();

        second.start();

        try {
            first.join();
            second.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        // объединение массивов
        float[] result = Arrays.copyOf(mas1, size);
        System.arraycopy(mas2, 0, result, half, size-half);

        // время
        System.currentTimeMillis();
        System.out.println(System.currentTimeMillis() - a);

//        for(float x: result){
//            System.out.println(x);
//        }

        System.out.println(result[size-1]);

    }

}
