package new_package;

import java.util.*;
//Define class Employee here
class Employee implements Cloneable{
	
	private String name;
	private String[] projects;
	
	public Employee(int len)
	{
		this.name=null;
		this.projects=new String[len];
	}
	public Employee(String name, String[] projects) {
		this.name = name;
		this.projects = projects;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProject(int index) {
		return projects[index];
	}

	public void setProject(int index,String project) {
		this.projects[index] = project;
	}
	
	public String[] getProjects()
	{
		return projects;
	}
	
	@Override
	public Employee clone()
	{
		Employee obj = new Employee(projects.length);
		return obj;
	}
}

public class EmployeeClone {
 public static void main(String[] args) throws CloneNotSupportedException{
     Scanner sc = new Scanner(System.in);
     String[] proj =  {"PJ1", "PJ2", "PJ3"};
     Employee e1 = new Employee("Surya", proj);
     Employee e2 = e1.clone();
     e2.setName(sc.next());
     e2.setProject(0, sc.next());
     System.out.println(e1.getName() + ": " + e1.getProject(0));
     System.out.println(e2.getName() + ": " + e2.getProject(0));
 }
}
