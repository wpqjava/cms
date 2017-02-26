package org.wpq.cms.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class BaseDao<T> extends SqlSessionDaoSupport implements IBaseDao<T> {
	private final String path = "org.wpq.cms.mapper.";
	@SuppressWarnings("rawtypes")
	private Class type;
	
	@Resource(name="sqlSessionFactory")
	public void setSessionFactory(SqlSessionFactory sqlSessionFactory){
		this.setSqlSessionFactory(sqlSessionFactory);
	}
	
	public BaseDao() {
		this.type = this.getDAOClass(); 
	}
	
	/**
	 * 获得泛型的class
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private Class getDAOClass(){
         Class clazz = (Class)((ParameterizedType) this.getClass().getGenericSuperclass())
            .getActualTypeArguments()[0];
         return clazz;
    }
	
    protected String getMethodPath(String methodType){
        return path + "I"+type.getSimpleName() + "Mapper." + methodType;
    }
    
	@Override
	public void add(T t) {
		getSqlSession().insert(getMethodPath("add"), t);
	}

	@Override
	public void delete(int id) {
		getSqlSession().delete(getMethodPath("delete"), id);
	}

	@Override
	public void update(T t) {
		getSqlSession().update(getMethodPath("update"), t);
	}

	@Override
	public T load(int id) {
		return getSqlSession().selectOne(getMethodPath("load"), id);
	}

	@Override
	public List<T> listAll() {
		return getSqlSession().selectList(getMethodPath("listAll"));
	}

}
