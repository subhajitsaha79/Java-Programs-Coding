package code.string;

import java.util.ArrayList;
import java.util.List;

public class ExtractString {
	
	public static List<String> numberFind(String conversation)
	{
		List<String> names = new ArrayList<String>();
		for(int i=0;i<conversation.length();i++)
		{
			String num = "";
			if(Character.isDigit(conversation.charAt(i)))
			{
				num = num + conversation.charAt(i);
				while(i<conversation.length()-1 && Character.isDigit(conversation.charAt(i+1)))
				{
					num = num + conversation.charAt(i+1);
					i = i+1;
					continue;
				}
			}
			if(!num.equals(""))
			{
				names.add(num);
			}
		}
		return names;
	}
	
	public static int digitStringFind(String conversation)
	{
		int sum = 0;
		String new_string = "";
		for(int i=0;i<conversation.length();i++)
		{
			if(Character.isLetterOrDigit(conversation.charAt(i)) || conversation.charAt(i)==' ')
			{
				new_string += conversation.charAt(i);
			}
		}
		String[] tokens = new_string.split(" ");
		for(String token:tokens)
		{
			if(token.toLowerCase().equals("one"))
			{
				sum += 1;
			}
			else if(token.toLowerCase().equals("two"))
			{
				sum += 2;
			}
			else if(token.toLowerCase().equals("three"))
			{
				sum += 3;
			}
			else if(token.toLowerCase().equals("four"))
			{
				sum += 4;
			}
			else if(token.toLowerCase().equals("five"))
			{
				sum += 5;
			}
			else if(token.toLowerCase().equals("six"))
			{
				sum += 6;
			}
			else if(token.toLowerCase().equals("seven"))
			{
				sum += 7;
			}
			else if(token.toLowerCase().equals("eight"))
			{
				sum += 8;
			}
			else if(token.toLowerCase().equals("nine"))
			{
				sum += 9;
			}
		}
		return sum;
	}
	
	public static void main(String args[])
	{
		String str = "A: Hello, Priya 3 speaking. Is this Aditi? B: Yeah "
				+ "Priya! I am there 28. A: How are you dear ? B: I am fine 19. "
				+ "What about you Priya 75? A: Glad to hear that! Me too fine! seven. "
				+ "Aditi how are your five holidays going? B: Great Priya! I am enjoying "
				+ "well!";
		System.out.println(numberFind(str));
		System.out.println(digitStringFind(str));
	}
}
