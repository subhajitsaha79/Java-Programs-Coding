
package new_package;

import java.util.ArrayList;


class ScoreList<T extends Number> {
    ArrayList<T> scores = new ArrayList<T>();
    public void addElement(T t)
    {
      scores.add(t);
    }
    public void removeElement(T t)
    {
      scores.remove(t);
    }
    public T getElement(int i)
    {
      return scores.get(i);
    }
    public double averageValues()
    {
      double sum = 0.0f;
      double avg = 0.0f;
      int count = 0;
      for(T score:scores)
      {
        sum = sum + (Double)score;
        count++;
      }
      avg = (double) sum/count;
      return avg;
    }
    //Write your code
}


class StudentList<T> {
    ArrayList<T> students = new ArrayList<T>();

    public void addElement(T t)
    {
      students.add(t);
    }
    public void removeElement(T t)
    {
      students.remove(t);
    }
    public T getElement(int i)
    {
      return students.get(i);
    }
    public String beginsWith(String query)
    {
      String res = "";
      for(T student:students)
      {
        if(student instanceof String)
        {
          if(student.toString().toLowerCase().startsWith(query.toLowerCase()))
          {
            res = res + student.toString() + "\n";
          }
        }
      }
      return res;
    }
    public String bloodGroupOf(String[] blood_data,String query)
    {
      String res = "";
      for(int i=0;i<blood_data.length;i++)
      {
        if(blood_data[i].equals(query))
        {
          res = res + students.get(i) + "\n";
        }
      }
      return res;
    }
    public int thresholdScore(int marks_query)
    {
      int count = 0;
      for(T student_marks:students)
      {
        if((Integer)student_marks >= marks_query)
        {
          count++;
        }
      }
      return count;
    }
    //Write your code   
}


public class StudentClass {
    
    public String getQuery(String studentData,String query){

      int type;
      String res = "";
      type = Integer.parseInt(query.split(",")[0]);
      String student_data[] = studentData.split(" ");
      if(type==1)
      {
        StudentList<String> list = new StudentList<String>();
        for(String student:student_data)
        {
          list.addElement(student);
        }
        String query_data = query.split(",")[1];
        res = list.beginsWith(query_data);
      }
      else if(type==2)
      {
        StudentList<String> list = new StudentList<String>();
        for(String student:student_data)
        {
          list.addElement(student);
        }
        String query_data = query.split(",")[2];
        String blood_data[] = (query.split(",")[1]).split(" ");
        res = list.bloodGroupOf(blood_data, query_data);
      }
      else if(type==3)
      {
        StudentList<Integer> list = new StudentList<Integer>();
        for(String student:student_data)
        {
          list.addElement(Integer.parseInt(student));
        }
        int query_data = Integer.parseInt(query.split(",")[1]);
        res = list.thresholdScore(query_data)+" students scored "+query_data+" above";
      }
      else if(type==4)
      {
        ScoreList<Double> list = new ScoreList<Double>();
        for(String student:student_data)
        {
          list.addElement(Double.parseDouble(student));
        }
        res = String.format("%.2f",list.averageValues());
      }
      else{
        ScoreList<Double> list = new ScoreList<Double>();
        for(String student:student_data)
        {
          list.addElement(Double.parseDouble(student));
        }
        res = String.format("%.2f",list.averageValues());
      }

      return res;
        		
    }
    
}
