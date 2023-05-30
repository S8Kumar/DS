import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int token =0;
		int ch=1;
		
		System.out.print("Enter no of processes: ");
		int n = sc.nextInt();
		
		System.out.print("Processes are :: ");
		for (int i=0; i<n; i++){
		    System.out.print(" "+ i + " ");
		}
		System.out.println(" 0");
		
		int sender, receiver;
		String message;
		
		try {
		    
		    while (ch!=0) {
		        
		        System.out.print("\nEnter sender: ");
		        sender = sc.nextInt();
		        
		        System.out.print("Enter receiver: ");
		        receiver = sc.nextInt();
		        
		        sc.nextLine();
		        
		        System.out.print("Enter message: ");
		        message = sc.nextLine();
		        
		        
		        System.out.print("\nSender "+sender+" sending message "+message);
		        
		        for(int i=sender+1; i!=receiver; i=(i+1)%n) {
		            System.out.print("\nmessage "+message+" forwarded by "+i);
		        }
		        
		        System.out.print("\nRecever "+receiver+" received message "+message+"\n");
		        token=sender;
		        
		    }
		}
		catch (Exception e){
		    
		}
	}
}
