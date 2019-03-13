packege algorithm;

public class QuickSort {

  public QuickSort(){}
  
  public String sort(int[] arr){
    
    String after = "";
    
    quickSort(arr, 0, arr.length - 1);
    for(int i = 0; i < arr.length; i++){
      after += arr[i] + "\t";
    }
    
    return after;
  }
  
  public void quickSort(int[] arr, int start, int end){
    
    if(start >= end) return;
    
    int key = start;
    int i = start + 1;
    int j = end;
    int temp;
    
    while(i <= j){
      while(arr[i] <= arr[key]){
        i++;
      }
      
      while(arr[j] >= arr[key] && j > start){
        j--;
      }
      
      if(i > j){
        temp = arr[j];
        arr[j] = arr[key];
        arr[key] = temp;
      }else{
        temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
      }
      
    }
    
    quickSort(arr, start, j-1);
    quickSort(arr, j+1, end);
  
  }

}
