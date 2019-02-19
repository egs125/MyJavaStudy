package algorithm;

/**
 * @Class        : algorithm/SelectionSort.java
 * @Description  : 
 * @author       : egs125
 * @since        : 2019. 2. 19.
 * @version      : 1.0
 * @see
 */
 
 public class SelectionSort {
 
  public SelectionSort(){}
  
  public String sort(int[] target){
    String after = "";
    int min, temp;
    
    for(int i = 0; i < target.length; i++){
      min = i;
      
      for(int j = i+1; j < target.length; j++){
        if(target[j] < target[min]) min = j;  
      }
      
      temp = target[i];
      target[i] = target[min];
      target[min] = temp;
      
    }
    
    for(int i = 0; i < target.length; i++){
      after += target[i] + "\t";
    }
    
    return after;
  }
 
 }
