package org.wpq.cms.mapper;

import java.sql.SQLException;

import java.util.Date;

import javax.annotation.Resource;

import org.dbunit.DatabaseUnitException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wpq.cms.dao.IAttachmentDao;
import org.wpq.cms.dao.IGroupDao;
import org.wpq.cms.dao.IKeywordDao;
import org.wpq.cms.dao.IRoleDao;
import org.wpq.cms.dao.ITopicDao;
import org.wpq.cms.dao.IUserDao;
import org.wpq.cms.dao.IUserGroupDao;
import org.wpq.cms.dao.IUserRoleDao;
import org.wpq.cms.model.Attachment;
import org.wpq.cms.model.Channel;
import org.wpq.cms.model.Keyword;
import org.wpq.cms.model.SystemContext;
import org.wpq.cms.model.Topic;
import org.wpq.cms.model.User;
import org.wpq.common.util.PinyinUtil;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/ApplicationContext.xml")
public class TestTopic {
	@Resource(name="userDao")
	private IUserDao ud;
	@Resource(name="groupDao")
	private IGroupDao gd;
	@Resource(name="roleDao")
	private IRoleDao rd;
	@Resource(name="userGroupDao")
	private IUserGroupDao ugd;
	@Resource(name="userRoleDao")
	private IUserRoleDao urd;
	@Resource
	private ITopicDao td;
	@Resource
	private IKeywordDao kd;
	@Resource
	private IAttachmentDao ad;
	@Test
	public void testAdd() throws DatabaseUnitException, SQLException{
		for(int i=0;i<5;i++){
			Topic t = new Topic();
			t.setAuthor("admin");
			t.setChannel(new Channel(2));
			t.setContent("qqq测试文章");
			t.setCreateDate(new Date());
			t.setKeyword("ha|哈");
			t.setRecommend(1);
			t.setSummary("无");
			t.setTitle("admin测试文章二"+i);
			t.setUser(new User(1));
			td.add(t);
		}
		
	}
	@Test
	public void testDelete() throws DatabaseUnitException, SQLException{
		td.delete(3);
	}
	@Test
	public void testUpdate() throws DatabaseUnitException, SQLException{
		Topic t = new Topic();
		t.setId(3);
		td.update(t);
	}
	@Test
	public void testLoad() throws DatabaseUnitException, SQLException{
		System.out.println(td.load(1));
	}
	
	@Test
	public void testFind() throws DatabaseUnitException, SQLException{
		SystemContext.setPageOffset(0);
		SystemContext.setPageSize(10);
	}
	
	@Test
	public void testFind2() throws DatabaseUnitException, SQLException{
		SystemContext.setPageOffset(0);
		SystemContext.setPageSize(10);
	}
	@Test
	public void testUpdateStatis() throws DatabaseUnitException, SQLException{
		td.updateStatus(1, 1);
	}

	@Test
	public void testkeywordAdd() throws DatabaseUnitException, SQLException{
		Keyword kw = new Keyword();
		String str = "方程式";
		kw.setName(str);
		kw.setFullPY(PinyinUtil.str2FullPinyin(str, ""));
		kw.setShortPY(PinyinUtil.str2ShortPinyin(str));
		kd.add(kw);
	}
	@Test
	public void testkeywordDelete() throws DatabaseUnitException, SQLException{
		kd.delete(2);
	}
	@Test
	public void testkeywordUpdate() throws DatabaseUnitException, SQLException{
		Keyword kw = new Keyword();
		kw.setId(3);
		kd.update(kw);;
	}
	@Test
	public void testkeywordLoad() throws DatabaseUnitException, SQLException{
		System.out.println(kd.listKeywordByCon("sc"));
	}
	
	@Test
	public void testAttachAdd() throws DatabaseUnitException, SQLException{
		for(int i=0;i<5;i++){
			Attachment a = new Attachment();
			a.setIsImg(1);
			a.setNewName("new");
			a.setOldName("old");
			a.setSize(11111111);
			a.setSuffix(".exe");
			a.setType("doc");
			a.setTopic(new Topic(1));
			ad.add(a);
		}
		
	}
	@Test
	public void testAttachDelete() throws DatabaseUnitException, SQLException{
		ad.delete(2);
	}
	@Test
	public void testAttachUpdate() throws DatabaseUnitException, SQLException{
		Attachment a = new Attachment();
		a.setId(3);
		ad.update(a);;
	}
	@Test
	public void testAttachLoad() throws DatabaseUnitException, SQLException{
		for(Attachment a:ad.listChannelShowAtt(7, 10)){
			System.out.println(a.getTopic().getId()+","+a.getTopic().getTitle()+",summary:"+a.getTopic().getSummary()+",date:"+a.getTopic().getPublishDate()+":"+a.getNewName());
		}
	}
}
