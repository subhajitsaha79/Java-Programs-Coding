package new_package;

import java.util.*;
import java.util.stream.*;
public class FilterString {
    public static Collection<String> collectData(ArrayList<String> l){
        Collection<String> obj;
        //write your code here
        obj = l.stream().distinct().filter(x->!x.contains(",")).filter(x->!x.contains(".")).sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        return obj;
    }
    public static void main(String[] args) {
        var list=new ArrayList<String>();
        Scanner sc=new Scanner(System.in);
        int len=sc.nextInt();
        for(int i=0;i<len;i++) {
            list.add(sc.next());
        }
        System.out.println(FilterString.collectData(list));
        sc.close();
    }
}
