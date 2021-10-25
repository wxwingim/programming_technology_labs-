public class Run implements Runnable {

    float [] arr;
    int index;

    public Run(float [] arr, int index){
        this.arr = arr;
        this.index = index;
    }

    @Override
    public void run() {
        for (int i=0; i<arr.length; i++){
            arr [i]  =  (float)(arr[i] *  Math.sin(0.2f +  (i+index) / 5) * Math.cos(0.2f +  (i+index) / 5) * Math.cos(0.4f + (i+index) / 2));
        }
    }
}
