package edu.cjc.smsapp.app.servicei;

import java.util.List;

import edu.cjc.smsapp.app.model.Student;

public interface StudentServiceI {
	public void saveStudentDetails(Student s);
	public List<Student> getAllStudents();
	public List<Student> searchBatch(String batchNumber);
	public Student getSingleStudent(int id);
	public List<Student> updateStudentfees(int studentid, float ammount);
	public void removeDelete(int id);
	public List<Student> updateStudentBatch(int studentid, String batchNumber);
	

}
