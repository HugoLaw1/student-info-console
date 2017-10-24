package seehope.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import seehope.model.GradeModel;

public class GradeDaoTest {

	GradeDao g = new GradeDao();
	@Test
	public void testGetSubjectByGrade() {
		GradeModel gg = new GradeModel(6,"语文","数学","英语","物理","生物","化学");
		assertEquals(gg,g.getSubjectByGrade(6));
	}

}
