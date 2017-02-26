package org.wpq.cms.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.wpq.cms.dao.IAttachmentDao;
import org.wpq.cms.model.Attachment;
import org.wpq.cms.model.SystemContext;


import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.Thumbnails.Builder;
import net.coobird.thumbnailator.geometry.Positions;
@Service
public class AttachmentService implements IAttachmentService {
	@Resource
	private IAttachmentDao attachmentDao;
	private final static int THUM_WIDTH = 100;
	private final static int INTRO_WIDTH = 1200;
	private final static int SUB_WIDTH = 290;
	private final static String uploadPath = "/resources/upload/";
	private final static String uploadTemporaryPath = "/resources/img/";
	private final static String uploadThumPath = "/resources/upload/thum/";
	private final static String INTROPATH = "/resources/img/channel/intro/";
	private final static String SUBPATH = "/resources/img/channel/sub/";

	@Override
	public void add(Attachment a, InputStream is) throws IOException {
		addFile(a,is);
		attachmentDao.add(a);
	}

	private void addFile(Attachment a, InputStream is) throws IOException {
		String path = SystemContext.getRealPath()+uploadPath+a.getNewName();
		String thumPath = SystemContext.getRealPath()+uploadThumPath+a.getNewName();
		String temporaryPath = SystemContext.getRealPath()+uploadTemporaryPath+"temporary."+a.getSuffix();
		if(a.getIsImg()==1){
			BufferedImage oldBi = ImageIO.read(is);
			int width = oldBi.getWidth();
			Builder<BufferedImage> bf = Thumbnails.of(oldBi);
			if(width>INTRO_WIDTH){
				bf.scale((double)INTRO_WIDTH/(double)width);
			}else{
				bf.scale(1.0f);
			}
			bf.toFile(path);
			if(width>THUM_WIDTH){
				Thumbnails.of(oldBi).scale((double)(THUM_WIDTH*1.5)/(double)width).toFile(temporaryPath);  
				Thumbnails.of(temporaryPath).scale(1.0f).sourceRegion(Positions.CENTER, 100,100).toFile(thumPath);
			}else{
				bf.toFile(thumPath);
			}
		}else{
			FileUtils.copyInputStreamToFile(is, new File(path));
		}
		
	}
	
	@Override
	public void updateIntroPic(int id) {
		try {
			Attachment a= attachmentDao.load(id);
			if(a.getIsIntroPic()==0){
				String path = SystemContext.getRealPath()+uploadPath+a.getNewName();
				String introPath = SystemContext.getRealPath()+INTROPATH+a.getNewName();
				String temporaryPath = SystemContext.getRealPath()+uploadTemporaryPath+"temporary."+a.getSuffix();
				a.setIsIntroPic(1);
				BufferedImage oldBi = ImageIO.read(new File(path));
				int width = oldBi.getWidth();
				Builder<BufferedImage> bf = Thumbnails.of(oldBi);
				if(width>INTRO_WIDTH){
					bf.scale((double)INTRO_WIDTH/(double)width)
					.toFile(temporaryPath);  
					Thumbnails.of(temporaryPath)
					.scale(1.0f)
					.sourceRegion(Positions.CENTER, 1280,500) 
					.toFile(introPath);
				}else{
					bf.scale(1.0f).toFile(introPath);
				}
				
			}else{
				a.setIsIntroPic(0);
			}
			attachmentDao.update(a);
		} catch (IOException e) {
			System.out.println("error:"+e.getMessage());
		}
	}
	
	@Override
	public void updateSpePic(int id) {
		try {
			Attachment a= attachmentDao.load(id);
			if(a.getIsSpePic()==0){
				String path = SystemContext.getRealPath()+uploadPath+a.getNewName();
				String subPath = SystemContext.getRealPath()+SUBPATH+a.getNewName();
				String temporaryPath = SystemContext.getRealPath()+uploadTemporaryPath+"temporary."+a.getSuffix();
				a.setIsSpePic(1);
				BufferedImage oldBi = ImageIO.read(new File(path));
				int width = oldBi.getWidth();
				Builder<BufferedImage> bf = Thumbnails.of(oldBi);
				if(width>SUB_WIDTH){
					bf.scale((double)SUB_WIDTH/(double)width)
					.toFile(temporaryPath);  
					Thumbnails.of(temporaryPath)
					.scale(1.0f)
					.sourceRegion(Positions.CENTER, 1280,500) 
					.toFile(subPath);
				}else{
					bf.scale(1.0f).toFile(subPath);
				}
				
			}else{
				a.setIsSpePic(0);
			}
			attachmentDao.update(a);
		} catch (IOException e) {
			System.out.println("error:"+e.getMessage());
		}
	}

	@Override
	public void updateAttach(int id) {
	}

	@Override
	public void delete(int id) {
		Attachment a = attachmentDao.load(id);
		deleteFile(a);
		attachmentDao.delete(id);
	}
	
	@Override
	public void deleteByTopidId(int id) {
		List<Attachment> as = attachmentDao.listByTopicId(id);
		for(Attachment a :as){
			deleteFile(a);
			attachmentDao.delete(id);
		}
	}
	
	private void deleteFile(Attachment a){
		String path = SystemContext.getRealPath()+uploadPath+a.getNewName();
		String thumPath = SystemContext.getRealPath()+uploadThumPath+a.getNewName();
		if(a.getIsImg()==1){
			System.out.println(path);
			new File(thumPath).delete();
			if(a.getIsIntroPic()==1){
				String introPath = SystemContext.getRealPath()+INTROPATH+a.getNewName();
				new File(introPath).delete();
			}
			if(a.getIsSpePic()==1){
				String subPath = SystemContext.getRealPath()+SUBPATH+a.getNewName();
				new File(subPath).delete();
			}
		}
		new File(path).delete();
	}
	
	@Override
	public List<Attachment> listByTopicId(int id) {
		return attachmentDao.listByTopicId(id);
	}
	
	@Override
	public List<Attachment> listUnusedAtt() {
		return attachmentDao.listUnusedAtt();
	}
	
	public static void main(String[] args) throws IOException {
		BufferedImage oldBi = ImageIO.read(new File("D:\\写真\\绝对领域\\3\\01.jpg"));
		int width = oldBi.getWidth();
		Builder<BufferedImage> bf = Thumbnails.of(oldBi);
		bf
		.scale((double)100/(double)width)
        .toFile("D:\\temperary.jpg");  
		Thumbnails.of("D:\\temperary.jpg")
		.scale(1.0f)
		.sourceRegion(Positions.CENTER, 100,100) 
		.toFile("D:\\test4.jpg");  
	}

	@Override
	public List<Attachment> listIndexAtt(int cid, int max) {
		return attachmentDao.listIndexAtt(cid, max);
	}

	@Override
	public void updateShowPic(int id) {
		Attachment a= attachmentDao.load(id);
		if(a.getIsShowPic()==0){
			a.setIsShowPic(1);
		}else{
			a.setIsShowPic(0);
		}
		attachmentDao.update(a);
	}

	@Override
	public List<Attachment> listChannelShowAtt(int cid, int max) {
		return attachmentDao.listChannelShowAtt(cid, max);
	}

	@Override
	public List<Attachment> listByCon(String con) {
		return attachmentDao.listByCon(con, 9);
	}
}
