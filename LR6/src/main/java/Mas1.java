import java.util.Arrays;

public class Mas1 {
    final  int size  = 10000000;
    float [] arr  =  new  float[size];

    public void Mas(){
        // заполнение единицами
        Arrays.fill(arr, 1);

        // время
        long a = System.currentTimeMillis();

        // формула
        for (int i=0; i<size; i++){
            arr [i]  =  (float)(arr[i] *  Math.sin(0.2f +  i / 5) * Math.cos(0.2f +  i / 5) * Math.cos(0.4f + i / 2));
        }

        // время
        System.currentTimeMillis();
        System.out.println(System.currentTimeMillis() - a);



//        for(float x: arr){
//            System.out.println(x);
//        }

        System.out.println(arr[size-1]);
    }
}
