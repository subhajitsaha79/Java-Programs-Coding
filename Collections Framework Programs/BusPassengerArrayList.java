package new_package;
import java.util.*;

class Passanger
{
    int id;
    float fare;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getFare() {
        return fare;
    }

    public void setFare(float fare) {
        this.fare = fare;
    }
    
    public Passanger(int id, float fare)
    {
        this.id=id;
        this.fare=fare;
    }
}

public class BusPassengerArrayList {
	
	public static int[][] computeArrayTable(List<String> psglist,int stops,int capacity)
	{
		int array_table[][] = new int[stops][6];
		int i=0;
		for(String s:psglist)
		{
			array_table[i][0] = (int) s.chars().filter(ch -> ch=='+').count();
			array_table[i][1] = (int) s.chars().filter(ch -> ch=='-').count();
			i++;
		}
		for(int j=0;j<stops;j++)
		{
			if(j==0) array_table[j][2] = array_table[j][0] - array_table[j][1];
			else array_table[j][2] = array_table[j][0] - array_table[j][1] + array_table[j-1][2];
		}
		for(int j=0;j<stops;j++)
		{
			if(array_table[j][2]<=Math.ceil(0.25*capacity))
			{
				array_table[j][3] = array_table[j][0];
			}
			else if(array_table[j][2]>=Math.ceil(0.25*capacity) && array_table[j][2]<=Math.ceil(0.5*capacity))
			{
				array_table[j][4] = array_table[j][0];
			}
			else if(array_table[j][2]>=Math.ceil(0.25*capacity))
			{
				array_table[j][5] = array_table[j][0];
			}
		}
		return array_table;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> psglist = new ArrayList<String>();
		int capacity = sc.nextInt();
		int stops = sc.nextInt();
		sc.nextLine();
		int[][] array_table;
		for(int i=0;i<stops;i++)
		{
			psglist.add(sc.nextLine());
		}
		String query = sc.nextLine();
		String output_string = "";
		//System.out.println(capacity+"\n"+stops+"\n"+psglist+"\n"+query);
		if(query.equals("1"))
		{
			int count_on = 0,count_off=0;
			for(String s:psglist)
			{
				count_on += s.chars().filter(ch -> ch=='+').count();
				count_off += s.chars().filter(ch -> ch=='-').count();
			}
			output_string = count_on+" passengers got on the bus and "+count_off+" passengers got out of the bus";
		}
		else if(query.equals("2"))
		{
			int[] sum_psg = new int[3];
			array_table = computeArrayTable(psglist,stops,capacity);
			for(int j=0;j<3;j++)
			{
				for(int k=0;k<stops;k++)
				{
					sum_psg[j] += array_table[k][j+3];
				}
			}
			/*for(int k=0;k<stops;k++)
			{
				for(int j=0;j<6;j++)
				{
					System.out.print(array_table[k][j]+" ");
				}
				System.out.println();
			}
			for(int j=0;j<3;j++)
			{
				System.out.print(sum_psg[j]+" ");
			}*/
			output_string = sum_psg[0]+" passengers traveled with a fare of "+(float)(capacity+0.6*capacity)+", "+sum_psg[1]+" passengers traveled with a fare of "+(capacity+0.3*capacity)+" and "+sum_psg[2]+" passengers traveled with a fare of "+(capacity+0.0*capacity);
		}
		else if(query.split(",")[0].equals("3"))
		{
			String psg_id = "+"+query.split(",")[1].trim();
			int i=0;
			double psg_fare=0.0f;
			array_table = computeArrayTable(psglist,stops,capacity);
			for(String s:psglist)
			{
				if(s.contains(psg_id))
				{
					if(array_table[i][2]<=Math.ceil(0.25*capacity))
					{
						psg_fare += capacity + 0.6*capacity;
					}
					else if(array_table[i][2]>=Math.ceil(0.25*capacity) && array_table[i][2]<=Math.ceil(0.5*capacity))
					{
						psg_fare += capacity + 0.3*capacity;
					}
					else if(array_table[i][2]>=Math.ceil(0.25*capacity))
					{
						psg_fare += capacity;
					}
				}
				i++;
			}
			output_string = "Passenger "+query.split(",")[1].trim()+" spent a total fare of "+psg_fare;
		}
		else if(query.split(",")[0].equals("4"))
		{
			String psg_id = "+"+query.split(",")[1].trim();
			int count = 0;
			for(String s:psglist)
			{
				if(s.contains(psg_id))
				{
					count++;
				}
			}
			output_string = "Passenger "+query.split(",")[1].trim()+" has got on the bus for "+count+" times";
		}
		else if(query.split(",")[0].equals("5"))
		{
			String psg_id_in = "+"+query.split(",")[1].trim();
			String psg_id_out = "-"+query.split(",")[1].trim();
			int count = 0;
			for(String str:psglist)
			{
				if(str.contains(psg_id_in) || str.contains(psg_id_out))
				{
					count++;
				}
			}
			if(count%2==0)
			{
				output_string = "Passenger "+query.split(",")[1].trim()+" was not inside the bus at the end of the trip";
			}
			else
			{
				output_string = "Passenger "+query.split(",")[1].trim()+" was inside the bus at the end of the trip";
			}
		}
		sc.close();
		System.out.println(output_string.hashCode());
	}

}
