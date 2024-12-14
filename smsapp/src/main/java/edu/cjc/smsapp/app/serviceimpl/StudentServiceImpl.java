package edu.cjc.smsapp.app.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cjc.smsapp.app.model.Student;
import edu.cjc.smsapp.app.repositary.StudentRepositary;
import edu.cjc.smsapp.app.servicei.StudentServiceI;
@Service
public class StudentServiceImpl implements StudentServiceI{
	@Autowired
	StudentRepositary sr;

	@Override
	public void saveStudentDetails(Student s) {
	
		sr.save(s);
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return (List<Student>) sr.findAll();
	}

	@Override
	public List<Student> searchBatch(String batchNumber) {
		
		return sr.findAllByBatchNumber(batchNumber);
	}

	@Override
	public Student getSingleStudent(int id) {
		// TODO Auto-generated method stub
		return sr.findById(id).get();
	}

	@Override
	public List<Student> updateStudentfees(int studentid, float ammount) {
		
		      Student  s=sr.findById(studentid).get();
		      float paidfees=Float.parseFloat(s.getFeesPaid())+ammount;
		           s.setFeesPaid( String.valueOf(paidfees));
		           sr.save(s);
		
		return (List<Student>) sr.findAll();
	}

	@Override
	public void removeDelete(int id) {
	sr.deleteById(id);
		
	}

}
