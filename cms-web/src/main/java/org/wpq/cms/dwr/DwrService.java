package org.wpq.cms.dwr;

import javax.annotation.Resource;

import org.wpq.cms.service.IAttachmentService;
import org.wpq.cms.service.IChannelService;
/*public class DwrService implements IDwrService {
	@Resource
	private IChannelService channelService;
	@Resource
	private IAttachmentService attachmentService;

	@Override
	public void addGroupChannel(int gid, int cid) {
		channelService.addGroupChannel(gid, cid);
	}

	@Override
	public void deleteGroupChannel(int gid, int cid) {
		channelService.deleteGroupChannel(gid, cid);
	}*/

	/*@Override
	public void updateIndexPic(int id) {
		attachmentService.updateIndexPic(id);
	}

	@Override
	public void updateAttach(int id) {
		attachmentService.updateAttach(id);
	}

	@Override
	public void deleteAttach(int id) {
		attachmentService.delete(id);
	}*/

	/*@Override
	public void updateSubPic(int id) {
		attachmentService.updateSubPic(id);
	}*/

	/*@Override
	public void updateShowPic(int id) {
		attachmentService.updateShowPic(id);
	}*/
public class DwrService implements IDwrService {
	@Resource
	private IChannelService channelService;
	@Resource
	private IAttachmentService attachmentService;

	@Override
	public void addGroupChannel(int gid, int cid) {
		channelService.addGroupChannel(gid, cid);
	}

	@Override
	public void deleteGroupChannel(int gid, int cid) {
		channelService.deleteGroupChannel(gid, cid);
	}

	/*@Override
	@RemoteMethod
	public void updateIndexPic(int id) {
		attachmentService.updateIndexPic(id);
	}

	@Override
	@RemoteMethod
	public void updateAttach(int id) {
		attachmentService.updateAttach(id);
	}

	@Override
	@RemoteMethod
	public void deleteAttach(int id) {
		attachmentService.delete(id);
	}

	@Override
	@RemoteMethod
	public void updateSubPic(int id) {
		attachmentService.updateSubPic(id);
	}

	@Override
	@RemoteMethod
	public void updateShowPic(int id) {
		attachmentService.updateShowPic(id);
	}
*/
}
