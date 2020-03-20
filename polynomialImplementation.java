package eg.edu.alexu.csd.datastructure.linkedList.cs;
import java.lang.Math;
public class polynomialImplementation implements IPolynomialSolver {
	singlyLinkedList A = new singlyLinkedList();
	singlyLinkedList B = new singlyLinkedList();
	singlyLinkedList C = new singlyLinkedList();
	singlyLinkedList R = new singlyLinkedList();
	int indicatorForSumAndSub=0;

	@Override
	public void setPolynomial(char poly, int[][] terms) {
		// TODO Auto-generated method stub
		//          clear the choosen array before setting
		switch(poly)
		{
		case 'A':
			A.clear();
			break;
		case 'B':
			B.clear();
			break;
		case 'C':
			C.clear();
			break;
		default :
			throw new RuntimeException("WRONG CHARACHTER"); //If there is wrong charachter
		}
		// Convert the 2d array to 1d array To add the elements to a linked list
		int numberofnodes=terms.length;
		int[] temp =new int[2];
		for(int i=0; i<numberofnodes-1;i++) {
			for(int j=0; j<numberofnodes-1-i;j++) {
				if(terms[j][1]<terms[j+1][1]) {
					temp=terms[j];
					terms[j]=terms[j+1];
					terms[j+1]=temp;
				}
				if(terms[j][1]==terms[j+1][1]) {
					terms[j][0]+=terms[j+1][0];
					for(int x=j+1;x<terms.length-1;x++) {
						terms[x]=terms[x+1];
					}
					numberofnodes--;
				}
			}
			
		}
		//        again because duplication for big duplicate terms
		for(int i=0; i<numberofnodes-1;i++) {
			for(int j=0; j<numberofnodes-1-i;j++) {
				if(terms[j][1]<terms[j+1][1]) {
					temp=terms[j];
					terms[j]=terms[j+1];
					terms[j+1]=temp;
				}
				if(terms[j][1]==terms[j+1][1]) {
					terms[j][0]+=terms[j+1][0];
					for(int x=j+1;x<terms.length-1;x++) {
						terms[x]=terms[x+1];
					}
					numberofnodes--;
				}
			}
			
		}
				//To add To polynomial selectes
		for(int i=0;i<numberofnodes;i++)
		//for(int i=numberofnodes-1;i>=0;i--)
		{
			switch(poly)
			{
			case 'A':
					A.add(terms[i]);
				break;
			case 'B':
				B.add(terms[i]);
				break;
			case 'C':
				C.add(terms[i]);
				break;
			default :
				throw new RuntimeException("WRONG CHARACHTER");
			}
		}
		
		//System.out.println(A.size);
		//System.out.println(A.get(0));
	}

	@Override
	   //          print polynomial
	public String print(char poly) {
		int arr[]=new int[2];
		StringBuilder polynomial = new StringBuilder("");
		singlyLinkedList choosenLinkedList = new singlyLinkedList();
		choosenLinkedList=getPolynomial(poly);
		if(choosenLinkedList.size()==0)return null;
		for(int x=0;x<choosenLinkedList.size(); x++) {
			arr=(int[]) choosenLinkedList.get(x);
			if(arr[0]==0) {
				continue;
			}else if(arr[1]==0&&arr[0]>0) {
				 polynomial.append("+"+arr[0]);
			}else if(arr[1]==0&&arr[0]<0) {
				 polynomial.append(arr[0]);
			}
			else if(arr[0]>0) {
				polynomial.append("+"+arr[0]+ "x^"+ arr[1]);
			}else {
				polynomial.append(arr[0]+ "x^"+ arr[1]);
			}
		}
		// to remove first char'+' if it is exitsts
		if(polynomial.charAt(0)=='+')
			polynomial.delete(0,1);
		String g=polynomial.toString();
		return polynomial.toString();
	}

	@Override
	// clear poly
	public void clearPolynomial(char poly) {
		// TODO Auto-generated method stub
		switch(poly)
		{
		case 'A':
			A.clear();
			break;
		case 'B':
			B.clear();
			break;
		case 'C':
			C.clear();
			break;
		case 'R':
			R.clear();
			break;	
		default :
			throw new RuntimeException("WRONG CHARACHTER");
		}
	}

	@Override
	public float evaluatePolynomial(char poly, float value) {
		// TODO Auto-generated method stub
		int size;
		int arr[]=new int[2];
		float sum=0;
		switch(poly)
		{
		case 'A':
			size =A.size;     //evaluate polynomial at point 
			if(size==0)return 0;
			for(int x=0;x<size; x++) {
				arr=(int[]) A.get(x);
				if(arr[0]==0) {
					continue;
				}else if(arr[1]==0) {
					sum+=arr[0];
				}
				else {
					sum+=arr[0]*Math.pow(value, arr[1]);
				}
			}
			break;
		case 'B':
			size =B.size;
			if(size==0)return 0;
			for(int x=0;x<size; x++) {
				arr=(int[]) A.get(x);
				if(arr[0]==0) {
					continue;
				}else if(arr[1]==0) {
					sum+=arr[0];
				}
				else {
					sum+=arr[0]*Math.pow(value, arr[1]);
				}
			}
			break;
		case 'C':
			size =B.size;
			if(size==0)return 0;
			for(int x=0;x<size; x++) {
				arr=(int[]) A.get(x);
				if(arr[0]==0) {
					continue;
				}else if(arr[1]==0) {
					sum+=arr[0];
				}
				else {
					sum+=arr[0]*Math.pow(value, arr[1]);
				}
			}
			break;
		case 'R':
			size =R.size;
			if(size==0)return 0;
			for(int x=0;x<size; x++) {
				arr=(int[]) R.get(x);
				if(arr[0]==0) {
					continue;
				}else if(arr[1]==0) {
					sum+=arr[0];
				}
				else {
					sum+=arr[0]*Math.pow(value, arr[1]);
				}
			}
			break;
		default :
			throw new RuntimeException("WRONG CHARACHTER");
		}
		//System.out.println(sum);
		return sum;
	}

	@Override
	public int[][] add(char poly1, char poly2) {
		// TODO Auto-generated method stub
		int[][] arrr=new int[A.size()][2];
		R.clear();
		indicatorForSumAndSub=0;   		//add two polynomial
		int[][] finalAddArray;
		singlyLinkedList x = new singlyLinkedList();
		singlyLinkedList y = new singlyLinkedList();
		x=getPolynomial(poly1);
		y=getPolynomial(poly2);
		
		return proberties(x, y);
	}

	@Override
	public int[][] subtract(char poly1, char poly2) {
		// TODO Auto-generated method stub
				indicatorForSumAndSub=1;
				singlyLinkedList first = new singlyLinkedList();
				singlyLinkedList second = new singlyLinkedList();
				for(int i=0; i<getPolynomial(poly1).size();i++) {
					first.add(getPolynomial(poly1).get(i));  		//subtract two polynomial
				}
				for(int i=0; i<getPolynomial(poly2).size();i++) {
					second.add(getPolynomial(poly2).get(i));
				}
				
				return proberties(first, second);
	}

	@Override
	public int[][] multiply(char poly1, char poly2) {
		// TODO Auto-generated method stub
		R.clear();
		int[][] finalmultiArray;
		singlyLinkedList x = new singlyLinkedList();
		singlyLinkedList y = new singlyLinkedList();
		x=getPolynomial(poly1);			//multiply to polunomial
		y=getPolynomial(poly2);
		int sizeMulti=x.size()*y.size();
		int[][] terms=new int[sizeMulti][2];
		int[] temp1=new int[2];
		int[] temp2=new int[2];
		int counter=0;
		for(int i=0; i<x.size();i++) {
			for(int j=0;j<y.size();j++) {
				temp1=(int[])x.get(i);
				temp2=(int[])y.get(j);
				terms[counter][0]=temp1[0]*temp2[0];
				terms[counter++][1]=temp1[1]+temp2[1];
				}
		}
		int numberofnodes=terms.length;
		int[] temp =new int[2];
		
		finalmultiArray=new int[numberofnodes][2];
		for(int b=0; b<numberofnodes;b++) {
			finalmultiArray[b]=terms[b];
		}
		return sort(terms);
	}
	
	public singlyLinkedList getPolynomial(char M){
		switch(M){
		case 'A' :
			return A ;
		case 'B' :
			return B ;
		case 'C' :
			return C ;
		case 'R' :
			return R ;
			default:
				throw new RuntimeException("ERROR");
		}
	}
public int [][] sort(int [][]unSortedArray){
	int[][] finalArr;
	int currentSize=unSortedArray.length;
	int[] temp3 =new int[2];
	for(int i=0; i<currentSize-1;i++) {
		for(int j=0; j<currentSize-1-i;j++) {
			if(unSortedArray[j][1]<unSortedArray[j+1][1]) {
				temp3=unSortedArray[j];
				unSortedArray[j]=unSortedArray[j+1];
				unSortedArray[j+1]=temp3;
			}
			if(unSortedArray[j][1]==unSortedArray[j+1][1]) {
				unSortedArray[j][0]+=unSortedArray[j+1][0];
				for(int h=j+1;h<unSortedArray.length-1;h++) {
					unSortedArray[h]=unSortedArray[h+1];
				}
				currentSize--;
			}
			
		}
		
	}
	
	
	finalArr=new int[currentSize][2];
	for(int b=0; b<currentSize;b++) {
		finalArr[b]=unSortedArray[b];
	}
	singlyLinkedList polyResult=new singlyLinkedList();
	for(int i=0; i<currentSize;i++) {
		polyResult.add(finalArr[i]);
	}
	R=polyResult;

	return finalArr;
		
	}
	
	public int[][] changePolyToArray(singlyLinkedList mySingleLinkedList){
		int sizeOfKinkedList=mySingleLinkedList.size();
		int ourReturnArray[][]=new int[sizeOfKinkedList][2];
		int[] temp9=new int[2];
		
		for(int i=0;i<sizeOfKinkedList;i++) {
			temp9=(int[]) mySingleLinkedList.get(i);
			ourReturnArray[i]=temp9 ;
		}
		return ourReturnArray;
		
	}
	
	public int [][]proberties (singlyLinkedList x,singlyLinkedList y) {
		singlyLinkedList ourResult =new singlyLinkedList();
		singlyLinkedList ournew1 =new singlyLinkedList();
		singlyLinkedList ournew2 =new singlyLinkedList();
		ournew1=x;
		ournew2=y;
		int i=0;
		int j=0;
		int[] temp1=new int[2];
		int[] temp2=new int[2];
		
		//   Merge Sort 
		while(i<x.size()&&j<y.size()) {
			temp1=(int[]) x.get(i);
			temp2=(int[]) y.get(j);
			if(temp1[1] == temp2[1]) {
				if(indicatorForSumAndSub==0) {
					int[] temp3=new int[2];    
				temp3[0]=temp1[0]+temp2[0];
				temp3[1]=temp1[1];
				ourResult.add(temp3);
				}
				else {
					int[] temp3=new int[2];
					temp3[0]=temp1[0]-temp2[0];
					temp3[1]=temp1[1];
					ourResult.add(temp3);
				}
				
				i++;j++;
				}
			else if(temp1[1] > temp2[1]) {
				ourResult.add(temp1);
				i++;
			}
			else if(temp1[1] < temp2[1]) {
				if(indicatorForSumAndSub==0) {
					ourResult.add(temp2);
				}
				else {
					int[] temp3=new int[2];
					temp3[0]=-1*temp2[0];
					temp3[1]=temp2[1];
					ourResult.add(temp3);
				}
				
				j++;
			}
		}
		while(i<x.size()) {
			temp1=(int[]) x.get(i);
			ourResult.add(temp1);
			i++;
		}
		while(j<y.size()) {
			temp2=(int[]) y.get(j);
			if(indicatorForSumAndSub==0) {
				ourResult.add(temp2);
			}
			else {
				int[] temp3=new int[2];
				temp3[0]=-1*temp2[0];
				temp3[1]=temp2[1];
				ourResult.add(temp3);
			}
			j++;
		}
		R=ourResult;
		int ourFinal[][]=new int[ourResult.size()][2];
		ourFinal=changePolyToArray(ourResult);
		
		return ourFinal;
		
	}
	
	

}
