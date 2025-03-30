package lk.ac.vau.fas.sbapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.ac.vau.fas.sbapp.model.Student;

import java.util.List;
import java.util.ArrayList;
@RestController
@RequestMapping("/app")

public class stu {
	Student S1 = new Student("2020ict01","Bob",25,"IT",3.0);
    Student S2 = new Student("2020ict18","Chamith",23,"IT",3.5);
    
    Student[] arr = {S1,S2};
    List<Student> students = new ArrayList<Student>();
    List<Student> studentsAge = new ArrayList<Student>();
	List<Student> sortedStudents = new ArrayList<>(students);
    
    @GetMapping("/list")
	public List<Student> GetDetails() {
			 students.add(S1);
			 students.add(S2);
			 return students;
	}
    @GetMapping("/student/{regno}")
    public Student GetDetailsbyregnum(@PathVariable("regno") String regno) {
                                       
              for(int i=0; i<arr.length; i++) {
            	  if(arr[i].getRegNo().equals(regno)) {
            		  return arr[i];
            	  }
              }
        return null;
        
    }
    @GetMapping("/age/{ag}")
	public String myAge(@PathVariable("ag") int age){
		return "My Age is "+ age;
	}
	
	@GetMapping("/age/{name}/{ag}")
	public String myAge(@PathVariable("ag") int age,@PathVariable("name") String name){
		return "My Age is "+ age + " My name is "+  name;
	}
	
	 @GetMapping("/students/{rg}")
	   public Student getStudentReg(@PathVariable("rg") String regNo)
	   {
		   for(Student stu:students)
		   {
			   if(stu.getRegNo().equals(regNo))
			   {
				   return stu;
			   }
		   }
		   
		   return null;
	   }
	   
	   
	   @GetMapping("/ages")
	   public List<Student> getStudentAge()
	   {
		  for(Student stu:students)
		  {
			  if(stu.getAge() > 19 && stu.getAge() < 24)
			  {
				  studentsAge.add(stu);
			  }
		  }
		  return studentsAge;
	   }
	   
	 
	   @GetMapping("/students/gpa")
	   public List<Student> getstudentGpa()
	   {
		   for (int i = 0; i < sortedStudents.size() - 1; i++) 
		   {
		        for (int j = 0; j < sortedStudents.size() - i - 1; j++)
		        {
		            if (sortedStudents.get(j).getGpa() > sortedStudents.get(j + 1).getGpa())
		            {
		                Student temp = sortedStudents.get(j);
		                sortedStudents.set(j, sortedStudents.get(j + 1));
		                sortedStudents.set(j + 1, temp);
		            }
		        }
		    }
		    
		    return sortedStudents;
	   }

    
}
