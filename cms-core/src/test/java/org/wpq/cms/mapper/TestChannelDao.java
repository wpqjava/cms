package org.wpq.cms.mapper;



import javax.annotation.Resource;

import org.dbunit.dataset.IDataSet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wpq.cms.dao.IChannelDao;
import org.wpq.cms.dao.IGroupChannelDao;
import org.wpq.cms.model.Channel;
import org.wpq.cms.model.ChannelType;
import org.wpq.cms.model.Group;
import org.wpq.cms.model.GroupChannel;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/ApplicationContext.xml")
public class TestChannelDao extends TestDBUnitBase {
	@SuppressWarnings("unused")
	private IDataSet ds;
	@Resource
	private IChannelDao channelDao;
	@Resource
	private IGroupChannelDao groupChannelDao;
	
	/*@Before
	public void setUp() throws DatabaseUnitException, SQLException{
		backupOneTable("t_channel");
		ds = this.createDateSet("channel");
		DatabaseOperation.TRUNCATE_TABLE.execute(dbunitCon, ds);
		DatabaseOperation.CLEAN_INSERT.execute(dbunitCon, ds);
	}
	
	@After
	public void resumeData() throws DatabaseUnitException, SQLException{
		resume();
	}*/
	@Test
	public void testAdd(){
		Channel c = new Channel();
		c.setName("赛车图集");
		c.setCustomLink(0);
		c.setIsNav(1);
		c.setIsTopIntro(0);
		c.setIsRecommend(1);
		c.setOrders(1);
		c.setStatus(1);
		c.setChannelType(ChannelType.NAV_CHANNEL);
		channelDao.add(c);
		c.setName("赛事新闻");
		channelDao.add(c);
		c.setName("围产动态");
		channelDao.add(c);
		c.setName("赛车论坛");
		channelDao.add(c);
	}
	@Test
	public void testDelete(){
		channelDao.delete(4);
	}
	@Test
	public void testUpdate(){
		Channel pc = new Channel();
		pc.setId(2);
		Channel c = new Channel();
		c.setId(3);
		c.setName("test3-update");
		c.setCustomLink(0);
		c.setCustomLinkUrl("http://www.163.com-update");
		c.setIsNav(0);
		c.setIsTopIntro(0);
		c.setIsTopIntro(0);
		c.setIsRecommend(0);
		c.setOrders(0);
		c.setStatus(0);
		c.setChannel(pc);
		channelDao.update(c);
	}
	
	@Test
	public void testLoad(){
		System.out.println(channelDao.load(3));
	}
	@Test
	public void testList(){
		for(Channel c:channelDao.listAll()){
			System.out.println(c);
		}
	}
	
	@Test
	public void testChannelTree(){
		System.out.println(channelDao.listByParentId(0));
	}
	
	@Test
	public void testGroupChannelAdd(){
		GroupChannel gc = new GroupChannel(new Group(2), new Channel(5));
		groupChannelDao.add(gc);
	}
	
	@Test
	public void testGroupChannelList(){
		System.out.println(groupChannelDao.getGroupChannelTreeByUserId(1));
	}
	
	@Test
	public void testGroupChannelDelete(){
		groupChannelDao.deleteByGroupId(2);
	}
	
	@Test
	public void testCList(){
		System.out.println(channelDao.listPublishableChannel().size());
	}
}
