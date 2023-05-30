import java.util.Scanner;

public class Main
{
    
    static boolean state[] = new boolean[1000];
    static int n;
    
    static void up(int process) {
        if (state[process]) {
            System.out.println("Process is up");
        }
        else {
            state[process] = true;
            message(process);
        }
    }
    
    static void down(int process) {
        if (!state[process]) {
            System.out.println("Process is down");
        }
        else {
            state[process] = false;
            System.out.println("Process put down");
        }
    }
    
    static void message(int process) {
        if (state[process]) {
            
            System.out.println("Process " + process + " holds election");
            for (int i=process+1; i<n; i++) {
                System.out.println("Election message sent from process " + process + " to "+ i);
            }
            
            for (int i=n-1; i>=process; i--) {
                
                if (state[i]) {
                    System.out.println("Cordinator message sent from " + i + " to all");
                    break;
                }
            }
        }
        else {
            System.out.println("Process is down");
        }
    }
    
	public static void main(String[] args) {
		
		int choice =0;
		int process=0;
		
		Scanner sc  = new Scanner(System.in);
		
		System.out.print("Enter no of processes: ");
		n = sc.nextInt();
		
		for (int i=0; i<n; i++) {
		    state[i] = true;
		}
		
	    System.out.print("The processes are- ");
	    for (int i=0; i<n; i++) {
	        System.out.print(" p" + i + " ");
	    }
	    System.out.println();
	    
	    do {
	        
	        System.out.print("\n1. Bring Up process");
	        System.out.print("\n2. Bring Down process ");
	        System.out.print("\n3. Send Message");
	        System.out.print("\n4. EXIT");
	        System.out.print("\nEnter choice:: ");
	        choice = sc.nextInt();
	        
	        switch (choice) {
	            case 1:
	                System.out.print("\nEnter process to bring up: ");
	                process = sc.nextInt();
	                up(process);
	                break;
	           
	           case 2:
	                System.out.print("\nEnter process to bring down: ");
	                process = sc.nextInt();
	                down(process);
	                break;
	                
	           case 3:
	                System.out.print("\nEnter process to send message: ");
	                process = sc.nextInt();
	                message(process);
	                break;
	        }
	    }
	    while (choice !=4);
	    
	    
	}
}
