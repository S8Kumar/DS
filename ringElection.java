import java.util.Scanner;

public class Main
{
    static boolean state[] = new boolean[1000];
    static int n;
    
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter no of processes: ");
		n = sc.nextInt();
		
		for (int i=0; i<n; i++) {
		    state[i] = true;
		}
		
		int arr[] = new int[n];
		for (int i=0; i<n; i++) {
		    arr[i]=-1;
		}
		System.out.print("Processes are-");
		for (int i=0; i<n; i++) {
		    System.out.print(" p"+i+" ");
		}
		
		System.out.print("\nProcess p"+(n-1)+" fails\n");
		state[n-1]=false;
		
		System.out.print("\nEnter process that initiates election: ");
		int process = sc.nextInt();
		System.out.println();
		
		int curr = process;
		int j=0;
		
		do {
		    
		    arr[j++]=curr;
		    int next = (curr+1)%n;
		    while(!state[next]) {
		        next = (next+1)%n;
		    }
		    System.out.println("process "+curr+ " sends message to "+next);
		    curr=next;
		} while(curr!=process);
		
		int maxi=-1;
		for(int i=0; i<n;i++) {
		    if(maxi<arr[i]) {
		        maxi = arr[i];
		    }
		}
	    System.out.println("\n"+maxi+" elected as coordinator \n");
		curr=process;
		do {
		    int next = (curr+1)%n;
		    while(!state[next]) {
		        next = (next+1)%n;
		    }
		    System.out.println("process "+curr+" sends [COORDINATOR "+maxi+"] message to "+next);
		   curr=next;
		   
		} while(curr!=process);
		
		
		
		
	}
}
