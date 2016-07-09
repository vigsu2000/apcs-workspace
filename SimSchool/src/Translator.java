import java.util.ArrayList;

public class Translator {
	
	public static Person getPerson(ArrayList<String> s) {
		int nameStart = s.get(1).indexOf(">");
		int nameEnd = s.get(1).indexOf("</");
		String name = s.get(1).substring(nameStart+1, nameEnd);
		int ageStart = s.get(2).indexOf(">");
		int ageEnd = s.get(2).indexOf("</");
		int age = Integer.parseInt(s.get(2).substring(ageStart+1, ageEnd));
		int genderStart = s.get(3).indexOf(">");
		int genderEnd = s.get(3).indexOf("</");
		String gender = s.get(3).substring(genderStart+1, genderEnd);
		return new Person(name, age, gender);
	}
	
	public static Teacher getTeacher(ArrayList<String> s) {
		int nameStart = s.get(1).indexOf(">");
		int nameEnd = s.get(1).indexOf("</");
		String name = s.get(1).substring(nameStart+1, nameEnd);
		int ageStart = s.get(2).indexOf(">");
		int ageEnd = s.get(2).indexOf("</");
		int age = Integer.parseInt(s.get(2).substring(ageStart+1, ageEnd));
		int genderStart = s.get(3).indexOf(">");
		int genderEnd = s.get(3).indexOf("</");
		String gender = s.get(3).substring(genderStart+1, genderEnd);
		int subjectStart = s.get(4).indexOf(">");
		int subjectEnd = s.get(4).indexOf("</");
		String subject = s.get(4).substring(subjectStart+1, subjectEnd);
		int salaryStart = s.get(5).indexOf(">");
		int salaryEnd = s.get(5).indexOf("</");
		double salary = Double.parseDouble(s.get(5).substring(salaryStart+1, salaryEnd));
		return new Teacher(name, age, gender, subject, salary);
	}
	
	public static Student getStudent(ArrayList<String> s) {
		int nameStart = s.get(1).indexOf(">");
		int nameEnd = s.get(1).indexOf("</");
		String name = s.get(1).substring(nameStart+1, nameEnd);
		int ageStart = s.get(2).indexOf(">");
		int ageEnd = s.get(2).indexOf("</");
		int age = Integer.parseInt(s.get(2).substring(ageStart+1, ageEnd));
		int genderStart = s.get(3).indexOf(">");
		int genderEnd = s.get(3).indexOf("</");
		String gender = s.get(3).substring(genderStart+1, genderEnd);
		int IdStart = s.get(4).indexOf(">");
		int IdEnd = s.get(4).indexOf("</");
		String Id = s.get(4).substring(IdStart+1, IdEnd);
		int GpaStart = s.get(5).indexOf(">");
		int GpaEnd = s.get(5).indexOf("</");
		double Gpa = Double.parseDouble(s.get(5).substring(GpaStart+1, GpaEnd));
		return new Student(name, age, gender, Id, Gpa);
	}
	
	public static CollegeStudent getCollegeStudent(ArrayList<String> s) {
		int nameStart = s.get(1).indexOf(">");
		int nameEnd = s.get(1).indexOf("</");
		String name = s.get(1).substring(nameStart+1, nameEnd);
		int ageStart = s.get(2).indexOf(">");
		int ageEnd = s.get(2).indexOf("</");
		int age = Integer.parseInt(s.get(2).substring(ageStart+1, ageEnd));
		int genderStart = s.get(3).indexOf(">");
		int genderEnd = s.get(3).indexOf("</");
		String gender = s.get(3).substring(genderStart+1, genderEnd);
		int IdStart = s.get(4).indexOf(">");
		int IdEnd = s.get(4).indexOf("</");
		String Id = s.get(4).substring(IdStart+1, IdEnd);
		int GpaStart = s.get(5).indexOf(">");
		int GpaEnd = s.get(5).indexOf("</");
		double Gpa = Double.parseDouble(s.get(5).substring(GpaStart+1, GpaEnd));
		int yearStart = s.get(6).indexOf(">");
		int yearEnd = s.get(6).indexOf("</");
		int year = Integer.parseInt(s.get(6).substring(yearStart+1, yearEnd));
		int majorStart = s.get(7).indexOf(">");
		int majorEnd = s.get(7).indexOf("</");
		String major = s.get(7).substring(majorStart+1, majorEnd);
		return new CollegeStudent(name, age, gender, Id, Gpa, year, major);
	}
	
/*	public static ArrayList<Person> getAllPersons(ArrayList<String> s) {
		ArrayList<Person> total = new ArrayList<Person>();
		for(int i = 0; i < s.size(); i++) {
			if(s.get(i).indexOf("<Person>") > -1) {
				ArrayList<String> lines = new ArrayList<String>();
				int count = 0;
				for(int j = i; j < s.size() && j < i+4; j++) {
					lines.add(s.get(j));
					count = j;
				}
				total.add(getPerson(lines));
				i = count;
			}
		}
		return total;
	}
	
	public static ArrayList<Teacher> getAllTeachers(ArrayList<String> s) {
		ArrayList<Teacher> total = new ArrayList<Teacher>();
		for(int i = 0; i < s.size(); i++) {
			if(s.get(i).indexOf("<Person>") > -1) {
				ArrayList<String> lines = new ArrayList<String>();
				int count = 0;
				for(int j = i; j < s.size() && j < i+6; j++) {
					lines.add(s.get(j));
					count = j;
				}
				for(String str:lines) {
					System.out.println(str);
				}
				total.add(getTeacher(lines));
				i = count;
			}
		}
		return total;
	}
	
	public static ArrayList<Student> getAllStudents(ArrayList<String> s) {
		ArrayList<Student> total = new ArrayList<Student>();
		for(int i = 0; i < s.size(); i++) {
			if(s.get(i).indexOf("<Person>") > -1) {
				ArrayList<String> lines = new ArrayList<String>();
				int count = 0;
				for(int j = i; j < s.size() && j < i+6; j++) {
					lines.add(s.get(j));
					count = j;
				}
				for(String str:lines) {
					System.out.println(str);
				}
				total.add(getStudent(lines));
				i = count;
			}
		}
		return total;
	}
	
	public static ArrayList<CollegeStudent> getAllCollegeStudents(ArrayList<String> s) {
		ArrayList<CollegeStudent> total = new ArrayList<CollegeStudent>();
		for(int i = 0; i < s.size(); i++) {
			if(s.get(i).indexOf("<Person>") > -1) {
				ArrayList<String> lines = new ArrayList<String>();
				int count = 0;
				for(int j = i; j < s.size() && j < i+8; j++) {
					lines.add(s.get(j));
					count = j;
				}
				for(String str:lines) {
					System.out.println(str);
				}
				total.add(getCollegeStudent(lines));
				i = count;
			}
		}
		return total;
	}*/
	
	public static ArrayList<Person> getAll(ArrayList<String> s) {
		ArrayList<Person> people = new ArrayList<Person>();
		for(int i = 0; i < s.size(); i++) {
			if(s.get(i).contains("<Person>")) {
				ArrayList<String> lines = new ArrayList<String>();
				int count = 0;
				for(int j = i; j < i+4; j++) {
					lines.add(s.get(j));
					count = j;
				}
				people.add(getPerson(lines));
			}
			else if(s.get(i).contains("<Teacher>")) {
				ArrayList<String> lines = new ArrayList<String>();
				int count = 0;
				for(int j = i; j < i+6; j++) {
					lines.add(s.get(j));
					count = j;
				}
				people.add(getTeacher(lines));
			}
			else if(s.get(i).contains("<Student>")) {
				ArrayList<String> lines = new ArrayList<String>();
				int count = 0;
				for(int j = i; j < i+6; j++) {
					lines.add(s.get(j));
					count = j;
				}
				people.add(getStudent(lines));
			}
			else if(s.get(i).contains("<CollegeStudent>")) {
				ArrayList<String> lines = new ArrayList<String>();
				int count = 0;
				for(int j = i; j < i+8; j++) {
					lines.add(s.get(j));
					count = j;
				}
				people.add(getCollegeStudent(lines));
			}
		}
		return people;
	}

}
