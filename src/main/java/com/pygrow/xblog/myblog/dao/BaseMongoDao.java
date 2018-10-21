package com.pygrow.xblog.myblog.dao;
/**
* @author E先生
* @version 创建时间：2018年8月13日 上午10:31:25
* @ClassName BaseMongoDao
* @Description 比较通用的BaseMongoDao,本类中的所有带条件查询的方法不具有完全的通用性，只能用作一般等值条件的比较
* 当有一些特殊需求时，比如大于、小于、大于等于、小于等于、like查询、 or查询等等，此时，这些
* 方法将不再满足需求，需要通过在子类dao中自定义方法实现
*/
public interface BaseMongoDao<T> {

	/**
	 * 插入
	 * 备注：执行完成本方法后，所引用实体的主键id会自动赋上值
	 * @param entity
	 */
	public void save(T entity);
	
	/**
	 * 删除
	 * 备注：
	 * @param entity
	 */
	public void delete(T entity);
	
	/**
	 * 修改
	 * 备注：
	 * @param entity
	 */
	public void update(T entity);
}
