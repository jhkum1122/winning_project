package roadshop.db;

import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class jdbcUtil {

	public static Connection con() {
		
		System.out.println("Here is jdbcUtil.con()");

		Connection con = null;
		try {
			Context initCtx = new InitialContext();
			
			System.out.println("after Context initCtx = new InitialContext()");

			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			
			System.out.println("after Context envCtx = (Context) initC)");

//			DataSource ds = (DataSource) envCtx.lookup("jdbc/WhereRoadShop");
			DataSource ds = (DataSource) envCtx.lookup("jdbc/orcl");
//변경 부분 server프로젝트 context.xml 변경 wRS프로텍트 web.xml에서 변경
			System.out.println("after modified DataSource ds = (DataSource) envCtx.lookup(\"jdbc/orcl\")");
			
			con = ds.getConnection();

			System.out.println("after con = ds.getConnection()");
			
			con.setAutoCommit(false);
			System.out.println("after con ds.getConnection()");
			System.out.println("Finish jdbcUtil.con()");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public static void close(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void close(Statement stmt) {
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void commit(Connection con) {
		try {
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void rollback(Connection con) {
		try {
			con.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}