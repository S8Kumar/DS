import mpi.*;
import mpi.MPI;
import java.util.Scanner;

public class ScatterGather
{
	public static void main(String[] args) throws Exception {
		
		MPI.Init(args);
		
		int rank = MPI.COMM_WORLD.Rank();
		int size = MPI.COMM_WORLD.Size();
		
		int unitsize=5;
		int root=0;
		int send_buffer[] = null;
		
		
		send_buffer = new int [unitsize*size];
		
		int receive_buffer[] = new int[unitsize];
		int new_rec_buffer[] = new int[size];
		
		
		if (rank==root) {
		    int total_elem = unitsize*size;
		    System.out.print("Enter total "+total_elem+" elem: ");
		    
		    for(int i=0; i< total_elem; i++) {
		        System.out.println("Element  "+ i + " \t= "+i);
		        send_buffer[i]=i;
		    }
		}
		
		MPI.COMM_WORLD.Scatter(
		    send_buffer,
		    0,
		    unitsize,
		    MPI.INT,
		    receive_buffer,
		    0,
		    unitsize,
		    MPI.INT,
		    root
		   );
		   
		   
		   
		   for(int i=0; i<unitsize; i++) {
		       receive_buffer[0] += receive_buffer[i];
		   }
		   System.out.println("Immediate sum at process "+rank+" is "+receive_buffer[0]);
		   
		   MPI.COMM_WORLD.Gather(
		       receive_buffer,
		       0,
		       1,
		       MPI.INT,
		       new_rec_buffer,
		       0,
		       1,
		       MPI.INT,
		       root
		    );
		    
		    if (rank == root) {
		        int total_sum =0;
		        for (int i=0; i<size; i++) {
		            total_sum +=new_rec_buffer[i];
		        }
		        System.out.println("Final sum: "+total_sum);
		    }
		
		
		
		MPI.Finalize();
	}
}
