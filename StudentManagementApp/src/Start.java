import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.student.manage.Student;
import com.student.manage.StudentDao;

public class Start {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Student Management App");
		System.out.println("");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("PRESS 1 to ADD Student ");
			System.out.println("PRESS 2 to Delete Student ");
			System.out.println("PRESS 3 to Display Student ");
			System.out.println("PRESS 4 to Update Student ");
			System.out.println("PRESS 5 to EXIT Student ");
			int c = Integer.parseInt(br.readLine());
			
			if(c==1) {
				// add student
				System.out.println("Enter user name : ");
				String name = br.readLine();
				
				System.out.println("Enter Phone : ");
				String phone = br.readLine();
				
				System.out.println("Enter City : ");
				String city = br.readLine();
				
				// create student object to store student
				Student st = new Student(name, phone, city);
				boolean ans = StudentDao.insertStudentToDB(st);
				if(ans) {
					System.out.println("Successfully added!");
				} else System.out.println("Something went wrong try agaim...");
				
			} else if(c==2) {
				// delete student
				
				System.out.println("Enter sid to delete : ");
				int userId = Integer.parseInt(br.readLine());
				
				boolean f = StudentDao.deleteStudent(userId);
				if(f) {
					System.out.println("Successfully deleted!");
				} else System.out.println("Something went wrong try agaim..."); 
				
			} else if(c==3) {
				// display student
				StudentDao.displayStudents();
			}
			else if(c==4) {
				// update student
				System.out.println("Enter sid to update : ");
				int userId = Integer.parseInt(br.readLine());
				
				System.out.println("Enter new Name : ");
				String newName = br.readLine();
				
				System.out.println("Enter new City : ");
				String newCity = br.readLine();
				
				boolean f = StudentDao.updateStudent(userId,newName, newCity);
				if(f) {
					System.out.println("Successfully updated values!");
				} else System.out.println("Something went wrong try agaim..."); 
			}else if(c==5) {
				// exit
				System.out.println("Thanks for using Student management App!");
				break;
			}
		}
	}

}
