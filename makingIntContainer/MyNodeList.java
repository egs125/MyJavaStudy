package javaStudy;

import java.io.IOException;
import java.util.Scanner;

/**
 * @Class        : javaStudy/MyNodeList.java
 * @Description  : 
 * @author       : egs125
 * @since        : 2019. 2. 12.
 * @version      : 1.0
 * @see
 */

public class MyNodeList {

	private static Scanner sc = new Scanner(System.in);
	
	private int count = 0; 		//number of currently saved data
	private int maxCount = 0; 	//maximum number of data 
	private MyNode node;
	private MyNode[] nodeArr;	
	
	//constructor
	public MyNodeList(){}

	public MyNodeList(int num){
		this.maxCount = num;
		nodeArr = new MyNode[num];
		
		this.printMenu();
	}

	//getter & setter
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getMaxCount() {
		return maxCount;
	}
	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}
	public MyNode getNode() {
		return node;
	}
	public void setNode(MyNode node) {
		this.node = node;
	}

	//program function
	public void printMenu(){
		System.out.println("Press the number of the option you want.\n");
		System.out.println("1. Input a new number");
		System.out.println("2. Change maximum size of data");
		System.out.println("3. Print whole saved data in an ascending order");
		System.out.println("4. Total sum of saved data");
		System.out.println("5. Average of saved data");
		System.out.println("6. Biggest of saved data");
		System.out.println("7. Smallest of saved data");	
		System.out.println("8. Current status");
		System.out.println("0. Exit \n");
		
		int selNum = sc.nextInt();
		
		if(selNum >= 0 && selNum < 9){
			this.executeSelectMenu(selNum);
		}else{
			System.out.println("Choose a number printed below.\n");
			this.printMenu();
		}
	}
	
	public void executeSelectMenu(int selNum){
		
		switch(selNum){
			case 0 : 
				System.out.println("Exit program");
				System.exit(0); 
				break;
			case 1 :
				this.addNode();
				break;
			case 2 :
				this.changeMaxCount();
				break;
			case 3 : 
				this.printWhole();
				break;
			case 4 : 
				if(checkEmpty()){
					System.out.println("No saved data!");
				}else{					
					int sum = this.sumTotal();
					System.out.println("Total : " + sum);
				}			
				break;
			case 5 : 
				this.avgTotal();
				break;
			case 6 :
				this.printBiggest();
				break;
			case 7 : 
				this.printSmallest();
				break;
			case 8 : 	
				this.printCurrent();
				break;				
		}
		
		System.out.println("Press Enter to continue...");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.printMenu();
	}
		
	public void addNode(){
		
		if(checkFull()){
			System.out.println("Can't save more data .\n");
		}else{
			System.out.println("Input a value");
			int val = sc.nextInt();
			
			MyNode newNode = new MyNode();
			newNode.setVal(val);
			
			this.nodeArr[this.count] = newNode;
			++this.count;
		}
		
	}
	
	public void changeMaxCount(){
		
		System.out.println("Insert the new size of data container");
		int newMaxCount = sc.nextInt();
			
		if(newMaxCount < this.count){
			System.out.println("New Maximum size should be bigger than the number of current data");
			this.printCurrent();
			this.changeMaxCount();
		}else{
			
			MyNode[] tmpArr = new MyNode[this.count];
			for(int i = 0; i < this.count; i++){
				MyNode node = new MyNode();
				node.setVal(this.nodeArr[i].getVal());
				tmpArr[i] = node;
			}
			
			this.maxCount = newMaxCount;
			nodeArr = new MyNode[maxCount];
			
			for(int i = 0; i < this.count; i++){
				MyNode node = new MyNode();
				node.setVal(tmpArr[i].getVal());
				nodeArr[i] = node;
			}
			
		}
		
	}
	
	public void printWhole(){
		
		if(checkEmpty()){
			System.out.println("No saved data!");
		}else{
			String str = "";
			MyNode[] tmpArr = new MyNode[this.count];
			int index = 0;
			MyNode tmp;
			
			for(int i = 0; i < this.count; i++){
				str += this.nodeArr[i].getVal() + "\t";
				
				MyNode node = new MyNode();
				node.setVal(this.nodeArr[i].getVal());
				tmpArr[i] = node;
			}	
			
			for(int i = 0; i < this.count; i++){
				
				int min = 9999;
				
				for(int j = i; j < this.count; j++){
					if(min > tmpArr[j].getVal()){
						min = tmpArr[j].getVal();
						index = j;
					}
				}
				
				tmp = tmpArr[i];
				tmpArr[i] = tmpArr[index];
				tmpArr[index] = tmp;
				
			}
			
			/*int j = 0;
			for(int i = 0; i < this.count; i++){
				j = i;
				while(tmpArr[j].getVal() > tmpArr[j+1].getVal()){
					tmp = tmpArr[j];
					tmpArr[j] = tmpArr[j+1];
					tmpArr[j+1] = tmp;
					j--;					
				}
			}*/
			 
			String ordered = "";
			for(int i = 0; i < this.count; i++){
				ordered += tmpArr[i].getVal() + "\t";
			}
			
			System.out.println("Original Data : " + str);
			System.out.println("Ordered Data : " + ordered);
		}
		
	}
	
	public int sumTotal(){
		
		int sum = 0; 
		
		for(int i = 0; i < this.count; i++){
			sum += this.nodeArr[i].getVal();
		}	
		
		return sum;
	}
	
	public void avgTotal(){
		
		if(checkEmpty()){
			System.out.println("No saved data!");
		}else{
			int sum = this.sumTotal();
			float avg = sum / this.count;
			
			System.out.println("Average : " + String.format("%.2f", avg));
		} 
	}
	
	public void printBiggest(){
		
		if(checkEmpty()){
			System.out.println("No saved data!");
		}else{

			int biggest = nodeArr[0].getVal();
			for(int i = 1; i < this.count; i++){
				int tmp = nodeArr[i].getVal();
				if(biggest < tmp) biggest = tmp;
			}
			
			System.out.println("Biggest number is : " + biggest);
		} 
		
	}
	
	public void printSmallest(){
		
		if(checkEmpty()){
			System.out.println("No saved data!");
		}else{

			int smallest = nodeArr[0].getVal();
			for(int i = 1; i < this.count; i++){
				int tmp = nodeArr[i].getVal();
				if(smallest > tmp) smallest = tmp;
			}
			
			System.out.println("Biggest number is : " + smallest);
		} 
		
	}
	
	public void printCurrent(){
		System.out.println("number of currently saved data : " + this.getCount());
		System.out.println("maximum size of data : " + this.getMaxCount() + "\n");
	}
	
	public boolean checkEmpty(){
		
		boolean isEmpty = false;
		if(this.count == 0) isEmpty = true;		
		
		return isEmpty;
	}
	
	public boolean checkFull(){
		
		boolean isFull = false;
		if(this.count == this.maxCount) isFull = true; 		
		
		return isFull;
	}
	
}
