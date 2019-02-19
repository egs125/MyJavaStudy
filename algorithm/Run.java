package algorithm;

/**
 * @Class        : algorithm/Run.java
 * @Description  : 
 * @author       : egs125
 * @since        : 2019. 2. 15.
 * @version      : 1.0
 * @see
 */


public Class Run {

  public static void main(String[] args){
    int [] sample = {1, 3, 9, 8, 7, 10, 6, 2, 4, 5};
    String before = "";
    
    for(int i = 0; i < sample.length; i++){
      before += sample[i] + "\t";
    }
    
    System.out.println("Before arranged : " + before);
    
    BubbleSort bs = new BubbleSort();
    System.out.println("After arranged by Bubble sort :" + bs.sort(sample);
    
    SelectionSort ss = new SelectionSort();
		System.out.println("After arranged by Selection sort : " + ss.sort(sample));
  }

}
