package new_package;

import java.util.*;

class Student implements Comparable<Student>{
  String name;
  int total;
  public Student(String n, int t){
    name = n;
    total = t;
  } 
  public String getName(){
    return name;
  }
  public int getTotal(){
    return total;
  }
  public int compareTo(Student s){
    return this.getTotal() - s.getTotal();
  }
  public String toString(){
    return name;
  }
}
public class StudentMarksComparable{
  public static void findStudent(List<Student> sList, int t){
// complete the code here
	Optional<Student> highest_total = Optional.empty();
	highest_total =  sList.stream().filter(s->s.getTotal()>t).sorted(Comparator.reverseOrder()).findFirst();
    highest_total.ifPresentOrElse(s->System.out.println(s),
                                 ()->System.out.println("no value found"));
 }
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    Student s1 = new Student(sc.next(), sc.nextInt());
    Student s2 = new Student(sc.next(), sc.nextInt());
    Student s3 = new Student(sc.next(), sc.nextInt());
    Student s4 = new Student(sc.next(), sc.nextInt());
    int c = sc.nextInt();
    List<Student> l = new ArrayList<>();
    l.add(s1);
    l.add(s2);
    l.add(s3);
    l.add(s4);
    findStudent(l, c);
  } 
}