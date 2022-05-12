public class question1 {
    
    String question_1(int[] n){
        String string ="";
        int counter = 0;
        int best = 1;
        int i = 0;

        for (i = 0; i < n.length-1; i++){
            counter = 0;
            for (int j = i; j < n.length; j++)
                if (n[i] == n[j]) 
                    counter++;
      
            if (best == counter)
                string = string + "," + n[i];
            if (counter > best)
            {  string =""+ n[i];
            best = counter; }
            }
        return string;
    }
}
