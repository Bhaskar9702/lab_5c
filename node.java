import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.Scanner;
class collect{
	int roll;
}
public class node<T extends Comparable<T>> implements Comparable<node<T>> {
	T val;
	node<T> right;
	node<T> left;
	public node(T va){
		this.val=va;
	}
    public int compareTo(node<T> node) {
        return this.val.compareTo(node.val);
    }
	public node<T> insert(node<T> root,T v){
		if(root==null){
			root=new node<T>(v);
		}
		else{
			T s=root.val;
			T d=v;
			int a=s.compareTo(d);
			if(a>0){
				root.left=insert(root.left,v);
			}
			else{
				root.right=insert(root.right,v);
			}
			
		}
		return root;
	}
	//public T add(T s){
		//if (this!=null){
			//this.left.add(s);
			//s=s+this.val;
			//this.right.add(s);
		//}
		//return s;
	//}
	public int min(Integer[] h,int y){
		int mm=0;
		for(int i=0;i<h.length;i++){
			if(h[i]<y){
				mm++;
			}
		}
		return mm;
	}
	public int min1(Float[] h,float y){
		int mm=0;
		for(int i=0;i<h.length;i++){
			if(h[i]<y){
				mm++;
			}
		}
		return mm;
	}
	public int min2(String[] h,String y){
		int mm=0;
		for(int i=0;i<h.length;i++){
			int c=h[i].compareTo(y);
			if(c<0){
				mm++;
			}
		}
		return mm;
	}
	
	public void display(node root){
		if(root!=null){
			display(root.left);
			System.out.print(" "+root.val);
			display(root.right);
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));
		BSTFilesBuilder x=new BSTFilesBuilder();
		String r=inp.readLine();
		String[] r1=r.split(" ");
		x.createBSTFiles(Integer.parseInt(r1[1]),Integer.parseInt(r1[0]));
		int[] x1=new int[Integer.parseInt(r1[1])];
		for(int i=1;i<Integer.parseInt(r1[0])+1;i++){
			File nu=new File("./src/"+i+".txt");
			Scanner n=new Scanner(nu);
			String s=n.nextLine();
			String s1=n.nextLine();
			String s2=n.nextLine();
			String[] j=s2.split(" ");
			if(s.charAt(0)=='I'){
				node<Integer> root=new node<Integer>(Integer.parseInt(j[0]));
				for(int j1=1;j1<j.length;j1++){
					root.insert(root,Integer.parseInt(j[j1]));
				}
				int sum=0;
				Integer[] temp_j=new Integer[j.length];
				for(int g=0;g<j.length;g++){
					temp_j[g]=(Integer)Integer.parseInt(j[g]);
					sum=sum+(Integer)Integer.parseInt(j[g]);
				}
				int index=root.min(temp_j,root.val)+1;
				x1[index]=1;
				System.out.print(index+" "+sum);
			}
			else if(s.charAt(0)=='F'){
				node<Float> root=new node<Float>(Float.valueOf(j[0]));
				for(int j1=1;j1<j.length;j1++){
					root.insert(root,Float.valueOf(j[j1]));
				}
				Float sum=0f;
				Float[] temp_j=new Float[j.length];
				for(int g=0;g<j.length;g++){
					temp_j[g]=Float.valueOf(j[g]);
					sum+=Float.valueOf(j[g]);
				}
				int index=root.min1(temp_j,root.val)+1;
				x1[index]=1;
				System.out.print(index+" "+sum);
			}
			else{
				node<String> root=new node<String>(j[0]);
				for(int j1=1;j1<j.length;j1++){
					root.insert(root,j[j1]);	
				}
				String[] temp_j=new String[j.length];
				for(int g=0;g<j.length;g++){
					temp_j[g]=j[g];
				}
				int index=root.min2(temp_j,root.val)+1;
				x1[index]=1;
				System.out.print(index);
				root.display(root);
			}
			System.out.println();
			n.close();
		}
		int cho=0;
		for(int i=0;i<x1.length;i++){
			if(x1[i]!=1){
				cho++;
			}
		}
		System.out.println(cho);
	}

}
