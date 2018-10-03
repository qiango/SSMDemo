//package com.wangq.ssm.util;
//
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Properties;
//import java.util.Set;
//
//import javax.sql.DataSource;
//import org.apache.commons.dbcp.BasicDataSource;
//import org.apache.commons.dbcp.BasicDataSourceFactory;
///**
// *
// * @Description: 数据库工具类
// * @author xuefeng.wang@vtradex.com
// * @date 2018年1月11日 上午11:53:03
// */
//public class JdbcUtil {
//
//	private static DataSource pool = null;
//	// 返回DataSource--池
//	public static DataSource getDataSource() {
//		if(null == pool){
//			try {
////				String dbDriver = GlobalParamUtils.getGloableStringValue("dbDriver");
////				String dbUrl = GlobalParamUtils.getGloableStringValue("dbUrl");
////				String dbUser = GlobalParamUtils.getGloableStringValue("dbUser");
////				String dbPassword = GlobalParamUtils.getGloableStringValue("dbPassword");
//				String dbDriver = "com.mysql.jdbc.Driver";
//				String dbUrl = "jdbc:mysql://192.168.1.251:3306/hdswms?autoReconnect=true&amp;useUnicode=true&amp;characterEncoding=utf-8";
//				String dbUser = "root";
//				String dbPassword = "1qazXSW@-pl,";
//
//				Properties prop = new Properties();
//				prop.setProperty("driverClassName", dbDriver);
//				prop.setProperty("url", dbUrl);
//				prop.setProperty("username", dbUser);
//				prop.setProperty("password", dbPassword);
//				prop.setProperty("initialSize", "2"); // 初始化创建的连接数
//				prop.setProperty("maxActive", "10"); // 最大连接数量
//				prop.setProperty("maxIdle", "5"); // 最大空闲连接
//				// prop.setProperty("minIdle", "1"); // 最小空闲连接
//				prop.setProperty("maxWait", "60000"); // 超时等待时间6000毫秒
//				// defaultAutoCommit=true 指定由连接池所创建的连接的自动提交
//
//				pool = (BasicDataSource) BasicDataSourceFactory.createDataSource(prop);
//			} catch (IOException e) {
//				e.printStackTrace();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		return pool;
//	}
//
//	/**
//	 * 获取数据库连接
//	 *
//	 * @return
//	 */
//	public static Connection getConnection() {
//		Connection conn = null;
//		try {
//			// 从本地线程管理对象t中拿
//			// conn = t.get();
//			// if (conn == null) {
//			conn = getDataSource().getConnection();
//			// 放入t中
//			// t.set(conn);
//			// }
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return conn;
//	}
//
//	/**
//	 *
//	 * 更新表数据是否已读状态
//	 *
//	 * @param conn
//	 * @param table
//	 *            表名
//	 * @param whereMap
//	 *            条件
//	 */
//	public static void updateStatusProduct(Integer status,Map<String, String> whereMap) {
//		String sql = "UPDATE " + "product" + " set edi_status="+status+",updated_by='wms',updated_at='" + getDateAsString(new Date()) + "'";
//		String wheres = " WHERE 1=1 ";
//		for (String key : whereMap.keySet()) {
//			wheres += " AND " + key + "='" + whereMap.get(key) + "'";
//		}
//
//		PreparedStatement ps = null;
//		try {
//			ps = getConnection().prepareStatement(sql + wheres);
//			ps.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//			throw new YesmywineException("写数据到数据库时出现异常！");
//		} finally {
//			try {
//				if (null != ps)
//					ps.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//
//	public static void updateStatus(String table,Integer status,Map<String, String> whereMap) {
//		String sql = "UPDATE " + table + " set edi_status="+status;
//		String wheres = " WHERE 1=1 ";
//		for (String key : whereMap.keySet()) {
//			wheres += " AND " + key + "='" + whereMap.get(key) + "'";
//		}
//
//		PreparedStatement ps = null;
//		try {
//			ps = getConnection().prepareStatement(sql + wheres);
//			ps.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//			throw new BusinessException("写数据到数据库时出现异常！");
//		} finally {
//			try {
//				if (null != ps)
//					ps.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//
//
//	/*
//	 * 中间表获取货品主数据
//	 */
//	public static List<WechatProduct> getItemDate(int pageSize){
//		String sql = "select * from product where edi_status=1 limit "+pageSize;
//		PreparedStatement ps = null;
//		List<WechatProduct> list=new ArrayList<WechatProduct>();
//		try {
//			ps = getConnection().prepareStatement(sql);
//			ResultSet resultSet = ps.executeQuery();
//			while(resultSet.next()) {
//				list=resultSetToWmsCustomerData(resultSet);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//			throw new BusinessException("读取数据时出现异常！");
//		} finally {
//			try {
//				if (null != ps)
//					ps.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return list;
//	}
//
//
//
//	/*
//	 * 中间表获取出库数据
//	 */
//	public static List<WechatOrder> getWmsOutboundDate(int pageSize) {
//		String sql = "select * from order where edi_status=1 limit "+pageSize;
//		PreparedStatement ps = null;
//		List<WechatOrder> list=new ArrayList<WechatOrder>();
//		try {
//			ps = getConnection().prepareStatement(sql);
//			ResultSet resultSet = ps.executeQuery();
//			while(resultSet.next()) {
//				list=resultSetToWmsPutInstorage(resultSet);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//			throw new BusinessException("读取数据时出现异常！");
//		} finally {
//			try {
//				if (null != ps)
//					ps.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//
//		return list;
//	}
//
//	/*
//	 * 中间表获取出库明细数据
//	 */
//	public static List<WechatOrderDetails> getOrderDetailsDate(int pageSize) {
//		String sql = "select * from order_nts_product where edi_status=1 limit "+pageSize;
//		PreparedStatement ps = null;
//		List<WechatOrderDetails> list=new ArrayList<WechatOrderDetails>();
//		try {
//			ps = getConnection().prepareStatement(sql);
//			ResultSet resultSet = ps.executeQuery();
//			while(resultSet.next()) {
//				list=resultSetToOrderDetails(resultSet);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//			throw new BusinessException("读取数据时出现异常！");
//		} finally {
//			try {
//				if (null != ps)
//					ps.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//
//		return list;
//	}
//
//	/*
//	 * 中间表获取订单包装数据
//	 */
//	public static List<WechatOrderPackage> getOrderPackage(int pageSize) {
//		String sql = "select * from order_package where edi_status=1 limit "+pageSize;
//		PreparedStatement ps = null;
//		List<WechatOrderPackage> list=new ArrayList<WechatOrderPackage>();
//		try {
//			ps = getConnection().prepareStatement(sql);
//			ResultSet resultSet = ps.executeQuery();
//			while(resultSet.next()) {
//				list=resultSetToOrderPackage(resultSet);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//			throw new BusinessException("读取数据时出现异常！");
//		} finally {
//			try {
//				if (null != ps)
//					ps.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//
//		return list;
//	}
//
//	public static List<WechatProduct> resultSetToWmsCustomerData(ResultSet rs) {
//		List<WechatProduct> emps = new ArrayList<WechatProduct>();
//		try {
//			while (rs.next()) {
//				int index = 1;
//				WechatProduct emp = new WechatProduct();
//				emp.setId(rs.getLong(index++));
////				emp.setItemId(rs.getString(index++));
//				emp.setName(rs.getString(index++));
////				emp.setBoxNum(rs.getInt(index++));
//				emp.setUpdatedBy(rs.getString(index++));
//				emp.setUpdatedAt(rs.getDate(index++));
////				emp.setEdiStatus(rs.getString(index++));
//				emps.add(emp);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return emps;
//	}
//
//	public static List<WechatOrderDetails> resultSetToOrderDetails(ResultSet rs) {
//		List<WechatOrderDetails> emps = new ArrayList<WechatOrderDetails>();
//		try {
//			while (rs.next()) {
//				int index = 1;
//				WechatOrderDetails emp = new WechatOrderDetails();
//				emp.setId(rs.getLong(index++));
//				emp.setOrderNo(rs.getString(index++));
////				emp.setName_sku(rs.getString(index++));
////				emp.setSub_order_no(rs.getString(index++));
////				emp.setStock_sku(rs.getString(index++));
////				emp.setProduct_type(rs.getString(index++));
////				emp.setQty(rs.getInt(index++));
////				emp.setUnit_price(rs.getDouble(index++));
////				emp.setDiscount(rs.getDouble(index++));
////				emp.setSet_name(rs.getString(index++));
////				emp.setSet_no(rs.getString(index++));
////				emp.setSet_qty(rs.getString(index++));
////				emp.setShow_set(rs.getBoolean(index++));
////				emp.setIs_set(rs.getBoolean(index++));
////				emp.setRemark(rs.getString(index++));
////				emp.setCreated_at(rs.getDate(index++));
////				emp.setEdiStatus(rs.getString(index++));
//				emp.setExtendProc1(rs.getString(index++));
//				emp.setExtendProc2(rs.getString(index++));
//				emp.setExtendProc3(rs.getString(index++));
//				emp.setExtendProc4(rs.getString(index++));
//				emp.setExtendProc5(rs.getString(index++));
//				emp.setExtendProc6(rs.getString(index++));
//				emp.setExtendProc7(rs.getString(index++));
//				emp.setExtendProc8(rs.getString(index++));
//				emps.add(emp);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return emps;
//	}
//
//	public static List<WechatOrder> resultSetToWmsPutInstorage(ResultSet rs) {
//		List<WechatOrder> emps = new ArrayList<WechatOrder>();
//		try {
//			while (rs.next()) {
//				int index = 1;
//				WechatOrder emp = new WechatOrder();
//				emp.setId(rs.getLong(index++));
//				emp.setWarehouseCode(rs.getString(index++));
//				emp.setOrderNo(rs.getString(index++));
////				emp.setBillTypeCode(rs.getString(index++));
////				emp.setEdiStatus(rs.getString(index++));
////				emp.setCustomer_name(rs.getString(index++));
////				emp.setCustomer_id(rs.getString(index++));
////				emp.setConsignee_name(rs.getString(index++));
////				emp.setConsignee_phone(rs.getString(index++));
////				emp.setOrderDate(rs.getDate(index++));
////				emp.setPayType(rs.getString(index++));
////				emp.setTotal_amount(rs.getDouble(index++));
////				emp.setTotal_discount(rs.getDouble(index++));
////				emp.setTotal_due(rs.getDouble(index++));
////				emp.setTotal_vp(rs.getInt(index++));
////				emp.setWeight(rs.getDouble(index++));
////				emp.setVolume(rs.getDouble(index++));
////				emp.setExpress_code(rs.getString(index++));
////				emp.setProvince(rs.getString(index++));
////				emp.setCity(rs.getString(index++));
////				emp.setDistrict(rs.getDouble(index++));
//				emp.setAddress(rs.getString(index++));
//				emp.setZipCode(rs.getString(index++));
//				emp.setStatus(rs.getString(index++));
//				emp.setRemark(rs.getString(index++));
////				emp.setCreateTime(rs.getDate(index++));
//				emp.setExtendProc1(rs.getString(index++));
//				emp.setExtendProc2(rs.getString(index++));
//				emp.setExtendProc3(rs.getString(index++));
//				emp.setExtendProc4(rs.getString(index++));
//				emp.setExtendProc5(rs.getString(index++));
//				emp.setExtendProc6(rs.getString(index++));
//				emp.setExtendProc7(rs.getString(index++));
//				emp.setExtendProc8(rs.getString(index++));
//				emps.add(emp);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return emps;
//	}
//
//	public static List<WechatOrderPackage> resultSetToOrderPackage(ResultSet rs) {
//		List<WechatOrderPackage> emps = new ArrayList<WechatOrderPackage>();
//		try {
//			while (rs.next()) {
//				int index = 1;
//				WechatOrderPackage emp = new WechatOrderPackage();
//				emp.setId(rs.getLong(index++));
//				emp.setOrderNo(rs.getString(index++));
////				emp.setPackage_name(rs.getString(index++));
////				emp.setPackage_type(rs.getString(index++));
////				emp.setOrdering_qty(rs.getInt(index++));
////				emp.setWarehouse_qty(rs.getInt(index++));
////				emp.setCreated_at(rs.getDate(index++));
////				emp.setEdiStatus(rs.getString(index++));
//				emps.add(emp);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return emps;
//	}
//
//	/*
//	 * 更新表数据
//	 */
//	public static void updateDate(String table, Map<String, Object> whereMap) {
//		String sql = "UPDATE " + table + " SET ";
//		for (String key : whereMap.keySet()) {
//			sql +=key + "='" + whereMap.get(key) + "',";
//		}
//		sql=sql.substring(0,sql.length()-1);
//		String wheres="WHERE WAREHOUSE_CODE='"+whereMap.get("WAREHOUSE_CODE")+"'"+" AND ORDER_NO='"+whereMap.get("ORDER_NO")+"'";
//		String startSql="select * from "+table+" ";
//		PreparedStatement ps = null;
//		PreparedStatement pps = null;
//		try {
//			pps=getConnection().prepareStatement(startSql+wheres);
//			ResultSet resultSet=pps.executeQuery();
//			if(null==resultSet) {//不为空新增，为空修改
//				insert(table,whereMap,null,null);
//			}else {
//				ps = getConnection().prepareStatement(sql + wheres);
//				ps.executeUpdate();
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//			throw new BusinessException("写数据到数据库时出现异常！");
//		} finally {
//			try {
//				if (null != ps)
//					ps.close();
//				if (null != pps)
//					pps.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//
//	/**
//	 * 查询表
//	 *
//	 * @param conn
//	 *            数据库连接
//	 * @param selects
//	 *            需要查询的字段
//	 * @param from
//	 *            需要查询的表
//	 * @param whereSub
//	 *            查询条件
//	 * @param whereList
//	 *            条件参数
//	 * @return
//	 */
//	public static List<Map<String, Object>> findTable(List<String> selects, String from,
//			String whereSub, List<Object> whereList) {
//		List<Map<String, Object>> resultList = null;
//		Map<String, Object> result = null;
//
//		String sql = "";
//		for (String sel : selects) {
//			sql += sel + ",";
//		}
//
//		sql = sql.isEmpty() ? "*" : sql.substring(0, sql.length() - 1);
//
//		sql = "SELECT " + sql + " FROM " + from + " WHERE " + whereSub;
//
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		try {
//			ps = getConnection().prepareStatement(sql);
//			int i = 1;
//			for (Object obj : whereList) {
//				ps.setObject(i, obj);
//				i++;
//			}
//			rs = ps.executeQuery();
//			resultList = new ArrayList<Map<String, Object>>();
//			while (rs.next()) {
//				result = new HashMap<String, Object>();
//				for (String sel : selects) {
//					result.put(sel, rs.getObject(sel.substring(sel.indexOf(".") + 1, sel.length())));
//				}
//				resultList.add(result);
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//			throw new BusinessException("读取数据库时出现异常！");
//		} finally {
//			try {
//				if (null != ps)
//					ps.close();
//				if (null != rs)
//					rs.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return resultList;
//	}
//
//	/**
//	 * 插入语句
//	 *
//	 * @param conn
//	 *            数据库连接
//	 * @param table
//	 *            表
//	 * @param values
//	 *            要插入的键值
//	 * @param extra
//	 *            额外的键(必须与extrValue一起使用，或者一起为null)
//	 * @param extrValue
//	 *            额外的值(必须与extra一起使用，或者一起为null)
//	 * @return
//	 */
//	public static Long insert(String table, Map<String, Object> values, String extra,
//			String extrValue) {
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		Long id = null;
//		String sql = "INSERT INTO " + table + " (";
//		String value = " VALUES (";
//		for (String key : values.keySet()) {
//			String value1 = "";
//			sql += key + ",";
//			Object obj = values.get(key);
//			if (obj instanceof Date) {
//				value1 = getDateAsString((Date) obj);
//				value += value1 + ",";
//			} else {
//				value1 = obj.toString();
//				value += "'" + value1 + "'" + ",";
//			}
//		}
//		if (null != extra && null != extrValue) {
//			sql += extra + ",";
//			value += extrValue + ",";
//		}
//		sql = sql.substring(0, sql.length() - 1) + ")";
//		value = value.substring(0, value.length() - 1) + ")";
//		sql += value;
//		try {
//			ps = getConnection().prepareStatement(sql, new String[] { "ID" });
//			ps.executeUpdate();
//			rs = ps.getGeneratedKeys();
//			if (rs.next()) {
//				id = rs.getLong(1);
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//			throw new BusinessException("写数据到数据库时出现异常！");
//		} finally {
//			try {
//				if (null != ps)
//					ps.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return id;
//	}
//
//	/**
//	 * 关闭连接
//	 *
//	 * @param conn
//	 */
//	public static void closeConnection(Connection conn) {
//		try {
//			conn.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//
//		}
//	}
//
//	/**
//	 * 获取日期
//	 *
//	 * @param date
//	 * @return
//	 */
//	private static String getDateAsString(Date date) {
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String dateStr = "TO_DATE('" + df.format(date) + "', 'YYYY-MM-DD HH24:MI:SS')";
//		return dateStr;
//	}
//
//
//	public static void updateBatchEdiStatus(Integer status,String table,Set<Long> ids) {
//		if(ids.size()==0) {return;}
//		String sql = "UPDATE " + table + " set EDI_STATUS=1,LAST_OPERATOR='wms',UPDATE_TIME=now() ";
//		      sql+= " WHERE id in (0";
//
//				for(Long id:ids){
//				  sql+=","+id;
//				}
//				sql+=")";
//
//		PreparedStatement ps = null;
//		try {
//			ps = getConnection().prepareStatement(sql);
//			ps.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//			throw new BusinessException("写数据到数据库时出现异常！");
//		} finally {
//			try {
//				if (null != ps)
//					ps.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//}
