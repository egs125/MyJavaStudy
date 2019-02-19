package algorithm;

/**
 * @Class        : algorithm/BubbleSort.java
 * @Description  : 
 * @author       : egs125
 * @since        : 2019. 2. 15.
 * @version      : 1.0
 * @see
 */
 
 public class BubbleSort {
  
  public BubbleSort(){}
  
  public String sort(int[] target){
    
    int temp;
    
    for(int i = 0; i < target.length; i++){
    
      for(int j = 0; i < target.length - 1; j++){
        if(target[j] > target[j+1]){
          temp = target[j];
          target[j] = target[j+1];
          target[j+1] = temp;
        }
      }
      
    }
    
    String after = "";
    for(int i = 0; i < target.length; i++){
      after += target[i] + "\t";
    }
    
    return after;
  }
 
 }
