package seehope.dao;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import seehope.model.StudentModel;

public class StudentDaoTest {

	StudentDao studentDao = new StudentDao();
	
	@Test
	public void testAddStudent() {
		Date date = new Date();
		SimpleDateFormat simpleDateFormate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		StudentModel s = new StudentModel("402","古天乐",5,6,"男","皮肤很黑","香港");
		assertEquals("001",studentDao.addStudent(s));
	}

}
