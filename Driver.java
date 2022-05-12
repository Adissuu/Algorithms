import java.time.LocalDate;

public class Driver {
    public static void main(String[] args) {

    LocalDate rDate[] = {LocalDate.parse("2014-02-14"), LocalDate.parse("2002-01-23") };
    int rSlot[] = {1, 2};
    String rMedicare[] = {"EEE11","YYY99"};
 
}
    


public int rearrangeReservations(LocalDate[] date, int[] slot, String[] medicare){
    LocalDate today = LocalDate.now();
    int counter = 0;
    for (int i = 0; i < date.length; i++){

    }
    return counter;
}
public static void bubbleSort(int [] sort_arr, int len){
        
    for (int i=0;i<len-1;++i){
    
        for(int j=0;j<len-i-1; ++j){
    
            if(sort_arr[j+1]<sort_arr[j]){
    
                int swap = sort_arr[j];
                sort_arr[j] = sort_arr[j+1];
                sort_arr[j+1] = swap;
    
            }
        }
    }
}

}
