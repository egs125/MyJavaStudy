package javaStudy;

import java.util.Scanner;

/**
 * @Class        : javaStudy/MyNodeList.java
 * @Description  : 
 * @author       : egs125
 * @since        : 2019. 2. 12.
 * @version      : 1.0
 * @see
 */

public class Run {

	public static void main(String[] args) {
				
		System.out.println("Insert the size of data container");
		
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		
		MyNodeList list = new MyNodeList(c);
		
	}

}
