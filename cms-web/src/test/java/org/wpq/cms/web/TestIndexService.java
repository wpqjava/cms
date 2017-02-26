package org.wpq.cms.web;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wpq.cms.model.SystemContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/ApplicationContext.xml")
public class TestIndexService {
	@Resource
	private IIndexService is;
	
	@Test
	public void testTop(){
		SystemContext.setRealPath("D:/CodeSoftware/STS/cms2016/cms-web/src/main/webapp");
		is.generateNav();
	}
	
	@Test
	public void testBody(){
		SystemContext.setRealPath("D:/CodeSoftware/STS/cms2016/cms-web/src/main/webapp");
		is.generateBody();
	}
	
	@Test
	public void testFoot(){
		SystemContext.setRealPath("D:/CodeSoftware/STS/cms2016/cms-web/src/main/webapp");
		is.generateFoot();
	}
	@Test
	public void testTopAndBody(){
		SystemContext.setRealPath("D:/CodeSoftware/STS/cms2016/cms-web/src/main/webapp");
		is.generateBody();
		SystemContext.setRealPath("D:/CodeSoftware/STS/cms2016/cms-web/src/main/webapp");
		is.generateNav();
	}
}
