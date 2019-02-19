package Boh.Sp.Service.impl;

import Boh.Sp.Dao.impl.StudentDaoImpl;
import Boh.Sp.Service.IStudentService;

public class StudentServiceImpl implements IStudentService{

	private StudentDaoImpl dao;
	
	public StudentDaoImpl getDao() {
		return dao;
	}

	public void setDao(StudentDaoImpl dao) {
		this.dao = dao;
	}

	@Override
	public boolean testStudent() {
		System.out.println("--->service方法：");
		return dao.testStudent();
	}

}
