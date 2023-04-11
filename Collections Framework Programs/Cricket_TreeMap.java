package com.example;

import java.util.Map;
import java.util.TreeMap;

class Library{
	
	public static TreeMap<Integer,String> createPlayerPositionMap(String cricketDataset)
	{
		cricketDataset = cricketDataset.replace("cricketDataset for query type 1 and 2 = ", "");
		String cricketDataset_tokens[] = cricketDataset.split("[|]");
		TreeMap<Integer,String> tm = new TreeMap<Integer,String>();
		for(String record:cricketDataset_tokens)
		{
			String record_tokens[] = record.split(",");
			tm.put(Integer.parseInt(record_tokens[0]), record_tokens[1]);
		}
		return tm;
	}
	
	public static TreeMap<String, Integer> createPlayerScoreMap(String cricketDataset)
	{
		cricketDataset = cricketDataset.replace("cricketDataset for query type 1 and 2 = ", "");
		String cricketDataset_tokens[] = cricketDataset.split("[|]");
		TreeMap<String,Integer> tm = new TreeMap<String,Integer>();
		for(String record:cricketDataset_tokens)
		{
			String record_tokens[] = record.split(",");
			tm.put(record_tokens[1], Integer.parseInt(record_tokens[2]));
		}
		return tm;
	}
	
	public static TreeMap<Integer,String[]> createMatchesMap(String cricketDataset)
	{
		cricketDataset = cricketDataset.replace("cricketDataset for query type 3 = ", "");
		TreeMap<Integer,String[]> opener = new TreeMap<Integer,String[]>();
		String matches[] = cricketDataset.split("\\R");
		int match_id = 0;
		for(String match:matches)
		{
			match_id += 1;
			String record[] = new String[2]; 
			String match_tokens[] = match.split("[|]");
			for(String token:match_tokens)
			{
				String batter[] = token.split(",");
				if(Integer.parseInt(batter[0])==1)
				{
					record[0] = batter[1];
					record[1] = batter[2];
					opener.put(match_id,record);
				}
			}
		}
		return opener;
	}
	public static String getQuery(String cricketDataset,String query) {
		
		query = query.replace("query = ", "");
		String query_tokens[] = query.split(" ");
		String return_string = "";
		if(Integer.parseInt(query_tokens[0])==1)
		{
			int start_pos = Integer.parseInt(query_tokens[1]);
			int end_pos = Integer.parseInt(query_tokens[2]);
			TreeMap<Integer,String> tm = createPlayerPositionMap(cricketDataset);
			for(Map.Entry<Integer, String> entry:tm.entrySet())
			{
				if(entry.getKey()>=start_pos && entry.getKey()<=end_pos)
				{
					return_string += entry.getKey() + " " + entry.getValue() + "\n";
				}
			}
		}
		else if(Integer.parseInt(query_tokens[0])==2)
		{
			int threshold_score = Integer.parseInt(query_tokens[1]);
			TreeMap<Integer,String> tm = createPlayerPositionMap(cricketDataset);
			TreeMap<String,Integer> tm1 = createPlayerScoreMap(cricketDataset);
			
			for(Map.Entry<Integer, String> entry:tm.entrySet())
			{
				for(Map.Entry<String, Integer> entry1:tm1.entrySet())
				{
					if(entry.getValue().equals(entry1.getKey()) && entry1.getValue()>threshold_score)
					{
						return_string += entry.getKey() + " " + entry.getValue() + "\n";
					}
				}
			}
		}
		else if(Integer.parseInt(query_tokens[0])==3)
		{
			TreeMap<Integer,String[]> tm =  createMatchesMap(cricketDataset);
			TreeMap<String,Double> tm1 = new TreeMap<String,Double>();
			for(Map.Entry<Integer, String[]> entry:tm.entrySet())
			{
				int sum = 0,count=0;
				double avg = 0.0f;
				//System.out.println(entry.getKey()+" "+entry.getValue()[0]+" "+entry.getValue()[1]);
				for(Map.Entry<Integer, String[]> entry1:tm.entrySet())
				{
					if(entry.getValue()[0].equals(entry1.getValue()[0]))
					{
						sum += Integer.parseInt(entry1.getValue()[1]);
						count += 1;
					}
				}
				avg = (double)sum/count;
				tm1.put(entry.getValue()[0],avg);
			}
			String max_opener = "";
			double max_value = 0.0f;
			for(Map.Entry<String, Double> entry:tm1.entrySet())
			{
				//System.out.println(entry.getKey()+" "+entry.getValue());
				if(entry.getValue()>max_value)
				{
					max_value = entry.getValue();
					max_opener = entry.getKey();
				}
			}
			return_string = "The Efficient Opener is "+max_opener;
		}
		return return_string;
	}
}
public class Cricket_TreeMap {

	public static void main(String[] args) {
		
		String cricketDataset = "cricketDataset for query type 1 and 2 = 3,Dhoni,120|1,Virat,103|5,Jadeja,40|2,Rohit,70|4,Pandya,30";
		//System.out.println(Library.getQuery(cricketDataset,"query = 2 50"));
		
		String cricketDataset1 = "cricketDataset for query type 3 = 3,Rohit,100|2,Virat,56|1,Dhoni,150\n3,Rahul,90|2,Virat,100|1,Rohit,99\n1,Rahul,50|2,Virat,64|3,Rohit,78\n1,Dhoni,95|2,Virat,30|3,Rohit,45\n3,Jadeja,43|2,Virat,54|1,Rohit,40|4,Dhoni,59";
		System.out.println(Library.getQuery(cricketDataset1,"query = 3"));
	}

}
