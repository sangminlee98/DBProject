import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;



public class SignUpDAO {

	
	public static void main(String[] args) {
		
		
	}	
	
	public static boolean create(SignUpDTO dto) throws Exception {
		
		boolean flag = false;
		Connection con = null;
		Statement stmt = null;
		String name = dto.getName();
		String addr = dto.getAddress();
		String phone = dto.getPhone();
		String id = dto.getId();
		String pw = dto.getPassword();
		
		try {
		
			String sql = "insert into usertbl(user_name,user_address,user_phone,user_ID,user_PW)"
					+ "values('" +name+"', '"+addr+"' ,'"+phone+"', '"+id+"', '"+pw+"');";
			
			String jdbc_url = "jdbc:mysql://localhost:3306/project?useUnicode=true" + "&characterEncoding=UTF8&serverTimezone=UTC";
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(jdbc_url, "root","vkdnjdp2em");
			stmt = (Statement) con.createStatement();
			stmt.executeUpdate(sql);
			flag = true;
		} catch (Exception e) {
			System.out.println(e);
			flag = false;
		} finally {
			
			try {
				if(stmt != null)
					stmt.close();
				if(con != null)
					con.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return flag;
	}
	
	public static boolean check(SignUpDTO dto) throws Exception {
		Connection con = null;
		Statement stmt = null;

		String id = dto.getId();
		boolean flag;
		try {
			
			String sql = "select * from usertbl where user_ID = '"+id+"';";
			
			String jdbc_url = "jdbc:mysql://localhost:3306/project?useUnicode=true" + "&characterEncoding=UTF8&serverTimezone=UTC";
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(jdbc_url, "root","vkdnjdp2em");
			stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);		
			if(rs.next()) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (Exception e) {
			System.out.println(e);
			flag = false;
		} finally {
			
			try {
				if(stmt != null)
					stmt.close();
				if(con != null)
					con.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return flag;
	}
	
	public static int logIn(SignUpDTO dto) throws Exception {
		
		Connection con = null;
		Statement stmt = null;

		String id = dto.getId();
		String pw = dto.getPassword();
		
		int state = 0;
		
		try {
		
			String sql = "select * from usertbl where user_ID = '"+id+"';";
			
			String jdbc_url = "jdbc:mysql://localhost:3306/project?useUnicode=true" + "&characterEncoding=UTF8&serverTimezone=UTC";
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(jdbc_url, "root","vkdnjdp2em");
			stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(sql); 
			if(rs.next()==false) {
				state = 1;
			} else {
				if(!pw.equals(rs.getString("user_PW"))) {
					state = 2;
				} else {
					state = 3;
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if(stmt != null)
					stmt.close();
				if(con != null)
					con.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return state;
	}
	
	public static String[][] getFdStore() throws Exception {
		Connection con = null;
		Statement stmt = null;
		
		try {
			String sql = "SELECT store_num,store_name,store_category,store_r_address,store_address From project.storetbl WHERE store_category Like '%??????%' OR '%??????%';";
			String jdbc_url = "jdbc:mysql://localhost:3306/project?useUnicode=true" + "&characterEncoding=UTF8&serverTimezone=UTC";
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(jdbc_url, "root","vkdnjdp2em");
			stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(rs.next()) {
				list.add(new String[] {rs.getString("store_num"),
						               rs.getString("store_name"),
						               rs.getString("store_category"),
						               rs.getString("store_r_address"),
						               rs.getString("store_address")});
				
			}
			System.out.println("The data has been fetched");
			String[][] arr = new String[list.size()][5];
			return list.toArray(arr);
		
		} catch(Exception e) {e.printStackTrace(); return null;}
		
	}
	
	public static String[][] getTrvStore() throws Exception {
		Connection con = null;
		Statement stmt = null;
		
		try {
			String sql = "SELECT store_num,store_name,store_category,store_r_address,store_address From project.storetbl WHERE store_category Like '%??????%' OR '%??????%' OR'%??????%';";
			String jdbc_url = "jdbc:mysql://localhost:3306/project?useUnicode=true" + "&characterEncoding=UTF8&serverTimezone=UTC";
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(jdbc_url, "root","vkdnjdp2em");
			stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(rs.next()) {
				list.add(new String[] {rs.getString("store_num"),
						               rs.getString("store_name"),
						               rs.getString("store_category"),
						               rs.getString("store_r_address"),
						               rs.getString("store_address")});
				
			}
			System.out.println("The data has been fetched");
			String[][] arr = new String[list.size()][5];
			return list.toArray(arr);
		
		} catch(Exception e) {e.printStackTrace(); return null;}
		
	}
	
	public static String[][] getMdStore() throws Exception {
		Connection con = null;
		Statement stmt = null;
		
		try {
			String sql = "SELECT store_num,store_name,store_category,store_r_address,store_address From project.storetbl WHERE store_category Like '%??????%' OR '%??????%' OR '%??????%' OR '%??????%' OR '%??????%';";
			String jdbc_url = "jdbc:mysql://localhost:3306/project?useUnicode=true" + "&characterEncoding=UTF8&serverTimezone=UTC";
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(jdbc_url, "root","vkdnjdp2em");
			stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(rs.next()) {
				list.add(new String[] {rs.getString("store_num"),
						               rs.getString("store_name"),
						               rs.getString("store_category"),
						               rs.getString("store_r_address"),
						               rs.getString("store_address")});
				
			}
			System.out.println("The data has been fetched");
			String[][] arr = new String[list.size()][5];
			return list.toArray(arr);
		
		} catch(Exception e) {e.printStackTrace(); return null;}
		
	}
	
	public static String[][] getClStore() throws Exception {
		Connection con = null;
		Statement stmt = null;
		
		try {
			String sql = "SELECT store_num,store_name,store_category,store_r_address,store_address From project.storetbl WHERE store_category Like '%??????%';";
			String jdbc_url = "jdbc:mysql://localhost:3306/project?useUnicode=true" + "&characterEncoding=UTF8&serverTimezone=UTC";
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(jdbc_url, "root","vkdnjdp2em");
			stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(rs.next()) {
				list.add(new String[] {rs.getString("store_num"),
						               rs.getString("store_name"),
						               rs.getString("store_category"),
						               rs.getString("store_r_address"),
						               rs.getString("store_address")});
				
			}
			System.out.println("The data has been fetched");
			String[][] arr = new String[list.size()][5];
			return list.toArray(arr);
		
		} catch(Exception e) {e.printStackTrace(); return null;}
		
	}
	
	public static String[][] getFtStore() throws Exception {
		Connection con = null;
		Statement stmt = null;
		
		try {
			String sql = "SELECT store_num,store_name,store_category,store_r_address,store_address From project.storetbl WHERE store_category Like '%??????%' OR '%??????%' OR '%??????%';";
			String jdbc_url = "jdbc:mysql://localhost:3306/project?useUnicode=true" + "&characterEncoding=UTF8&serverTimezone=UTC";
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(jdbc_url, "root","vkdnjdp2em");
			stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(rs.next()) {
				list.add(new String[] {rs.getString("store_num"),
						               rs.getString("store_name"),
						               rs.getString("store_category"),
						               rs.getString("store_r_address"),
						               rs.getString("store_address")});
				
			}
			System.out.println("The data has been fetched");
			String[][] arr = new String[list.size()][5];
			return list.toArray(arr);
		
		} catch(Exception e) {e.printStackTrace(); return null;}
		
	}
	
	public static String[][] getSfStore() throws Exception {
		Connection con = null;
		Statement stmt = null;
		
		try {
			String sql = "SELECT store_num,store_name,store_category,store_r_address,store_address From project.storetbl WHERE store_category Like '%??????%' OR '%?????????%';";
			String jdbc_url = "jdbc:mysql://localhost:3306/project?useUnicode=true" + "&characterEncoding=UTF8&serverTimezone=UTC";
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(jdbc_url, "root","vkdnjdp2em");
			stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(rs.next()) {
				list.add(new String[] {rs.getString("store_num"),
						               rs.getString("store_name"),
						               rs.getString("store_category"),
						               rs.getString("store_r_address"),
						               rs.getString("store_address")});
				
			}
			System.out.println("The data has been fetched");
			String[][] arr = new String[list.size()][5];
			return list.toArray(arr);
		
		} catch(Exception e) {e.printStackTrace(); return null;}
		
	}
	
	public static String[][] getEtStore() throws Exception {
		Connection con = null;
		Statement stmt = null;
		
		try {
			String sql = "SELECT store_num,store_name,store_category,store_r_address,store_address From project.storetbl WHERE store_category Like '%??????%' OR '%??????%' OR '%??????%' OR '%??????%' OR '%??????%' OR '%??????%' OR '%??????%' OR '%??????%' OR '%??????%' OR '%?????????%' OR '%?????????%' OR '%?????????%'"
					+" OR '%??????%' OR '%??????%' OR '%???%';";
			String jdbc_url = "jdbc:mysql://localhost:3306/project?useUnicode=true" + "&characterEncoding=UTF8&serverTimezone=UTC";
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(jdbc_url, "root","vkdnjdp2em");
			stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(rs.next()) {
				list.add(new String[] {rs.getString("store_num"),
						               rs.getString("store_name"),
						               rs.getString("store_category"),
						               rs.getString("store_r_address"),
						               rs.getString("store_address")});
				
			}
			System.out.println("The data has been fetched");
			String[][] arr = new String[list.size()][5];
			return list.toArray(arr);
		
		} catch(Exception e) {e.printStackTrace(); return null;}
		
	}
	
	public static String[][] getLgStore() throws Exception {
		Connection con = null;
		Statement stmt = null;
		
		try {
			String sql = "SELECT store_num,store_name,store_category,store_r_address,store_address From project.storetbl WHERE store_category Like '%??????%';";
			String jdbc_url = "jdbc:mysql://localhost:3306/project?useUnicode=true" + "&characterEncoding=UTF8&serverTimezone=UTC";
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(jdbc_url, "root","vkdnjdp2em");
			stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(rs.next()) {
				list.add(new String[] {rs.getString("store_num"),
						               rs.getString("store_name"),
						               rs.getString("store_category"),
						               rs.getString("store_r_address"),
						               rs.getString("store_address")});
				
			}
			System.out.println("The data has been fetched");
			String[][] arr = new String[list.size()][5];
			return list.toArray(arr);
		
		} catch(Exception e) {e.printStackTrace(); return null;}
		
	}
	
	public static String[][] getSearchStore(SignUpDTO dto) throws Exception {
		Connection con = null;
		Statement stmt = null;
		String searchTxt = dto.getSearchTxt();
		
		try {
			String sql = "SELECT store_num,store_name,store_category,store_r_address,store_address From project.storetbl WHERE store_name Like '%"+searchTxt+"%';";
			String jdbc_url = "jdbc:mysql://localhost:3306/project?useUnicode=true" + "&characterEncoding=UTF8&serverTimezone=UTC";
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(jdbc_url, "root","vkdnjdp2em");
			stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(rs.next()) {
				list.add(new String[] {rs.getString("store_num"),
						               rs.getString("store_name"),
						               rs.getString("store_category"),
						               rs.getString("store_r_address"),
						               rs.getString("store_address")});
				
			}
			System.out.println("The data has been fetched");
			String[][] arr = new String[list.size()][5];
			return list.toArray(arr);
		
		} catch(Exception e) {e.printStackTrace(); return null;}
		
	}
	
	public static String[][] getFdSearchStore(SignUpDTO dto) throws Exception {
		Connection con = null;
		Statement stmt = null;
		String searchTxt = dto.getSearchTxt();
		
		try {
			String sql = "SELECT store_num,store_name,store_category,store_r_address,store_address From project.storetbl WHERE store_name Like '%"+searchTxt+"%' and store_category Like '%??????%' OR '%??????%';";
			String jdbc_url = "jdbc:mysql://localhost:3306/project?useUnicode=true" + "&characterEncoding=UTF8&serverTimezone=UTC";
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(jdbc_url, "root","vkdnjdp2em");
			stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(rs.next()) {
				list.add(new String[] {rs.getString("store_num"),
						               rs.getString("store_name"),
						               rs.getString("store_category"),
						               rs.getString("store_r_address"),
						               rs.getString("store_address")});
				
			}
			System.out.println("The data has been fetched");
			String[][] arr = new String[list.size()][5];
			return list.toArray(arr);
		
		} catch(Exception e) {e.printStackTrace(); return null;}
		
	}
	
	public static String[][] getTrvSearchStore(SignUpDTO dto) throws Exception {
		Connection con = null;
		Statement stmt = null;
		String searchTxt = dto.getSearchTxt();
		
		try {
			String sql = "SELECT store_num,store_name,store_category,store_r_address,store_address From project.storetbl WHERE store_name Like '%"+searchTxt+"%' and store_category Like '%??????%' OR '%??????%' OR'%??????%';";
			String jdbc_url = "jdbc:mysql://localhost:3306/project?useUnicode=true" + "&characterEncoding=UTF8&serverTimezone=UTC";
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(jdbc_url, "root","vkdnjdp2em");
			stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(rs.next()) {
				list.add(new String[] {rs.getString("store_num"),
						               rs.getString("store_name"),
						               rs.getString("store_category"),
						               rs.getString("store_r_address"),
						               rs.getString("store_address")});
				
			}
			System.out.println("The data has been fetched");
			String[][] arr = new String[list.size()][5];
			return list.toArray(arr);
		
		} catch(Exception e) {e.printStackTrace(); return null;}
		
	}
	
	public static String[][] getLgSearchStore(SignUpDTO dto) throws Exception {
		Connection con = null;
		Statement stmt = null;
		String searchTxt = dto.getSearchTxt();
		
		try {
			String sql = "SELECT store_num,store_name,store_category,store_r_address,store_address From project.storetbl WHERE store_name Like '%"+searchTxt+"%' and store_category Like '%??????%';";
			String jdbc_url = "jdbc:mysql://localhost:3306/project?useUnicode=true" + "&characterEncoding=UTF8&serverTimezone=UTC";
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(jdbc_url, "root","vkdnjdp2em");
			stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(rs.next()) {
				list.add(new String[] {rs.getString("store_num"),
						               rs.getString("store_name"),
						               rs.getString("store_category"),
						               rs.getString("store_r_address"),
						               rs.getString("store_address")});
				
			}
			System.out.println("The data has been fetched");
			String[][] arr = new String[list.size()][5];
			return list.toArray(arr);
		
		} catch(Exception e) {e.printStackTrace(); return null;}
		
	}
	
	public static String[][] getMdSearchStore(SignUpDTO dto) throws Exception {
		Connection con = null;
		Statement stmt = null;
		String searchTxt = dto.getSearchTxt();
		
		try {
			String sql = "SELECT store_num,store_name,store_category,store_r_address,store_address From project.storetbl WHERE store_name Like '%"+searchTxt+"%' and store_category Like '%??????%' OR '%??????%' OR '%??????%' OR '%??????%' OR '%??????%';";
			String jdbc_url = "jdbc:mysql://localhost:3306/project?useUnicode=true" + "&characterEncoding=UTF8&serverTimezone=UTC";
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(jdbc_url, "root","vkdnjdp2em");
			stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(rs.next()) {
				list.add(new String[] {rs.getString("store_num"),
						               rs.getString("store_name"),
						               rs.getString("store_category"),
						               rs.getString("store_r_address"),
						               rs.getString("store_address")});
				
			}
			System.out.println("The data has been fetched");
			String[][] arr = new String[list.size()][5];
			return list.toArray(arr);
		
		} catch(Exception e) {e.printStackTrace(); return null;}
		
	}
	
	public static String[][] getClSearchStore(SignUpDTO dto) throws Exception {
		Connection con = null;
		Statement stmt = null;
		String searchTxt = dto.getSearchTxt();
		
		try {
			String sql = "SELECT store_num,store_name,store_category,store_r_address,store_address From project.storetbl WHERE store_name Like '%"+searchTxt+"%' and store_category Like '%??????%';";
			String jdbc_url = "jdbc:mysql://localhost:3306/project?useUnicode=true" + "&characterEncoding=UTF8&serverTimezone=UTC";
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(jdbc_url, "root","vkdnjdp2em");
			stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(rs.next()) {
				list.add(new String[] {rs.getString("store_num"),
						               rs.getString("store_name"),
						               rs.getString("store_category"),
						               rs.getString("store_r_address"),
						               rs.getString("store_address")});
				
			}
			System.out.println("The data has been fetched");
			String[][] arr = new String[list.size()][5];
			return list.toArray(arr);
		
		} catch(Exception e) {e.printStackTrace(); return null;}
		
	}
	
	public static String[][] getFtSearchStore(SignUpDTO dto) throws Exception {
		Connection con = null;
		Statement stmt = null;
		String searchTxt = dto.getSearchTxt();
		
		try {
			String sql = "SELECT store_num,store_name,store_category,store_r_address,store_address From project.storetbl WHERE store_name Like '%"+searchTxt+"%' and store_category Like '%??????%' OR '%??????%' OR '%??????%';";
			String jdbc_url = "jdbc:mysql://localhost:3306/project?useUnicode=true" + "&characterEncoding=UTF8&serverTimezone=UTC";
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(jdbc_url, "root","vkdnjdp2em");
			stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(rs.next()) {
				list.add(new String[] {rs.getString("store_num"),
						               rs.getString("store_name"),
						               rs.getString("store_category"),
						               rs.getString("store_r_address"),
						               rs.getString("store_address")});
				
			}
			System.out.println("The data has been fetched");
			String[][] arr = new String[list.size()][5];
			return list.toArray(arr);
		
		} catch(Exception e) {e.printStackTrace(); return null;}
		
	}
	
	public static String[][] getSfSearchStore(SignUpDTO dto) throws Exception {
		Connection con = null;
		Statement stmt = null;
		String searchTxt = dto.getSearchTxt();
		
		try {
			String sql = "SELECT store_num,store_name,store_category,store_r_address,store_address From project.storetbl WHERE store_name Like '%"+searchTxt+"%' and store_category Like '%??????%' OR '%?????????%';";
			String jdbc_url = "jdbc:mysql://localhost:3306/project?useUnicode=true" + "&characterEncoding=UTF8&serverTimezone=UTC";
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(jdbc_url, "root","vkdnjdp2em");
			stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(rs.next()) {
				list.add(new String[] {rs.getString("store_num"),
						               rs.getString("store_name"),
						               rs.getString("store_category"),
						               rs.getString("store_r_address"),
						               rs.getString("store_address")});
				
			}
			System.out.println("The data has been fetched");
			String[][] arr = new String[list.size()][5];
			return list.toArray(arr);
		
		} catch(Exception e) {e.printStackTrace(); return null;}
		
	}
	
	public static String[][] getEtSearchStore(SignUpDTO dto) throws Exception {
		Connection con = null;
		Statement stmt = null;
		String searchTxt = dto.getSearchTxt();
		
		try {
			String sql = "SELECT store_num,store_name,store_category,store_r_address,store_address From project.storetbl WHERE store_name Like '%"+searchTxt+"%' and store_category Like '%??????%' OR '%??????%' OR '%??????%' OR '%??????%' OR '%??????%' OR '%??????%' OR '%??????%' OR '%??????%' OR '%??????%' OR '%?????????%' OR '%?????????%' OR '%?????????%'"
					+" OR '%??????%' OR '%??????%' OR '%???%';";
			String jdbc_url = "jdbc:mysql://localhost:3306/project?useUnicode=true" + "&characterEncoding=UTF8&serverTimezone=UTC";
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(jdbc_url, "root","vkdnjdp2em");
			stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(rs.next()) {
				list.add(new String[] {rs.getString("store_num"),
						               rs.getString("store_name"),
						               rs.getString("store_category"),
						               rs.getString("store_r_address"),
						               rs.getString("store_address")});
				
			}
			System.out.println("The data has been fetched");
			String[][] arr = new String[list.size()][5];
			return list.toArray(arr);
		
		} catch(Exception e) {e.printStackTrace(); return null;}
		
	}
	
	public static String[][] getFdNearStore(SignUpDTO dto) throws Exception {
		Connection con = null;
		Statement stmt = null;
		String current_id = dto.getId();
		String subqr = "";
		
		try {
			String sql = "select SUBSTR(user_address,1,13) from usertbl where user_ID = '"+current_id+"';";
			String jdbc_url = "jdbc:mysql://localhost:3306/project?useUnicode=true" + "&characterEncoding=UTF8&serverTimezone=UTC";
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(jdbc_url, "root","vkdnjdp2em");
			stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				subqr = rs.getString("SUBSTR(user_address,1,13)");
			}
			String sql2 = "select * from storetbl where store_r_address like '"+subqr+"%' and store_category like '%??????%' OR '%??????%';";
			ResultSet rs2 = stmt.executeQuery(sql2);
			
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(rs2.next()) {
				list.add(new String[] {rs2.getString("store_num"),
						               rs2.getString("store_name"),
						               rs2.getString("store_category"),
						               rs2.getString("store_r_address"),
						               rs2.getString("store_address")});
				
			}
			System.out.println("The data has been fetched");
			String[][] arr = new String[list.size()][5];
			return list.toArray(arr);
		
		} catch(Exception e) {e.printStackTrace(); return null;}
		
	}
	
	public static String[][] getTrvNearStore(SignUpDTO dto) throws Exception {
		Connection con = null;
		Statement stmt = null;
		String current_id = dto.getId();
		String subqr = "";
		
		try {
			String sql = "select SUBSTR(user_address,1,13) from usertbl where user_ID = '"+current_id+"';";
			String jdbc_url = "jdbc:mysql://localhost:3306/project?useUnicode=true" + "&characterEncoding=UTF8&serverTimezone=UTC";
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(jdbc_url, "root","vkdnjdp2em");
			stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				subqr = rs.getString("SUBSTR(user_address,1,13)");
			}
			String sql2 = "select * from storetbl where store_r_address like '"+subqr+"%' and store_category like '%??????%' OR '%??????%' OR'%??????%';";
			ResultSet rs2 = stmt.executeQuery(sql2);
			
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(rs2.next()) {
				list.add(new String[] {rs2.getString("store_num"),
						               rs2.getString("store_name"),
						               rs2.getString("store_category"),
						               rs2.getString("store_r_address"),
						               rs2.getString("store_address")});
				
			}
			System.out.println("The data has been fetched");
			String[][] arr = new String[list.size()][5];
			return list.toArray(arr);
		
		} catch(Exception e) {e.printStackTrace(); return null;}
		
	}
	
	public static String[][] getLgNearStore(SignUpDTO dto) throws Exception {
		Connection con = null;
		Statement stmt = null;
		String current_id = dto.getId();
		String subqr = "";
		
		try {
			String sql = "select SUBSTR(user_address,1,13) from usertbl where user_ID = '"+current_id+"';";
			String jdbc_url = "jdbc:mysql://localhost:3306/project?useUnicode=true" + "&characterEncoding=UTF8&serverTimezone=UTC";
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(jdbc_url, "root","vkdnjdp2em");
			stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				subqr = rs.getString("SUBSTR(user_address,1,13)");
			}
			String sql2 = "select * from storetbl where store_r_address like '"+subqr+"%' and store_category like '%??????%';";
			ResultSet rs2 = stmt.executeQuery(sql2);
			
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(rs2.next()) {
				list.add(new String[] {rs2.getString("store_num"),
						               rs2.getString("store_name"),
						               rs2.getString("store_category"),
						               rs2.getString("store_r_address"),
						               rs2.getString("store_address")});
				
			}
			System.out.println("The data has been fetched");
			String[][] arr = new String[list.size()][5];
			return list.toArray(arr);
		
		} catch(Exception e) {e.printStackTrace(); return null;}
		
	}
	
	public static String[][] getMdNearStore(SignUpDTO dto) throws Exception {
		Connection con = null;
		Statement stmt = null;
		String current_id = dto.getId();
		String subqr = "";
		
		try {
			String sql = "select SUBSTR(user_address,1,13) from usertbl where user_ID = '"+current_id+"';";
			String jdbc_url = "jdbc:mysql://localhost:3306/project?useUnicode=true" + "&characterEncoding=UTF8&serverTimezone=UTC";
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(jdbc_url, "root","vkdnjdp2em");
			stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				subqr = rs.getString("SUBSTR(user_address,1,13)");
			}
			String sql2 = "select * from storetbl where store_r_address like '"+subqr+"%' and store_category like '%??????%' OR '%??????%' OR '%??????%' OR '%??????%' OR '%??????%';";
			ResultSet rs2 = stmt.executeQuery(sql2);
			
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(rs2.next()) {
				list.add(new String[] {rs2.getString("store_num"),
						               rs2.getString("store_name"),
						               rs2.getString("store_category"),
						               rs2.getString("store_r_address"),
						               rs2.getString("store_address")});
				
			}
			System.out.println("The data has been fetched");
			String[][] arr = new String[list.size()][5];
			return list.toArray(arr);
		
		} catch(Exception e) {e.printStackTrace(); return null;}
		
	}
	
	public static String[][] getClNearStore(SignUpDTO dto) throws Exception {
		Connection con = null;
		Statement stmt = null;
		String current_id = dto.getId();
		String subqr = "";
		
		try {
			String sql = "select SUBSTR(user_address,1,13) from usertbl where user_ID = '"+current_id+"';";
			String jdbc_url = "jdbc:mysql://localhost:3306/project?useUnicode=true" + "&characterEncoding=UTF8&serverTimezone=UTC";
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(jdbc_url, "root","vkdnjdp2em");
			stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				subqr = rs.getString("SUBSTR(user_address,1,13)");
			}
			String sql2 = "select * from storetbl where store_r_address like '"+subqr+"%' and store_category like '%??????%';";
			ResultSet rs2 = stmt.executeQuery(sql2);
			
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(rs2.next()) {
				list.add(new String[] {rs2.getString("store_num"),
						               rs2.getString("store_name"),
						               rs2.getString("store_category"),
						               rs2.getString("store_r_address"),
						               rs2.getString("store_address")});
				
			}
			System.out.println("The data has been fetched");
			String[][] arr = new String[list.size()][5];
			return list.toArray(arr);
		
		} catch(Exception e) {e.printStackTrace(); return null;}
		
	}
	
	public static String[][] getFtNearStore(SignUpDTO dto) throws Exception {
		Connection con = null;
		Statement stmt = null;
		String current_id = dto.getId();
		String subqr = "";
		
		try {
			String sql = "select SUBSTR(user_address,1,13) from usertbl where user_ID = '"+current_id+"';";
			String jdbc_url = "jdbc:mysql://localhost:3306/project?useUnicode=true" + "&characterEncoding=UTF8&serverTimezone=UTC";
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(jdbc_url, "root","vkdnjdp2em");
			stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				subqr = rs.getString("SUBSTR(user_address,1,13)");
			}
			String sql2 = "select * from storetbl where store_r_address like '"+subqr+"%' and store_category like '%??????%' OR '%??????%' OR '%??????%';";
			ResultSet rs2 = stmt.executeQuery(sql2);
			
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(rs2.next()) {
				list.add(new String[] {rs2.getString("store_num"),
						               rs2.getString("store_name"),
						               rs2.getString("store_category"),
						               rs2.getString("store_r_address"),
						               rs2.getString("store_address")});
				
			}
			System.out.println("The data has been fetched");
			String[][] arr = new String[list.size()][5];
			return list.toArray(arr);
		
		} catch(Exception e) {e.printStackTrace(); return null;}
		
	}
	
	public static String[][] getSfNearStore(SignUpDTO dto) throws Exception {
		Connection con = null;
		Statement stmt = null;
		String current_id = dto.getId();
		String subqr = "";
		
		try {
			String sql = "select SUBSTR(user_address,1,13) from usertbl where user_ID = '"+current_id+"';";
			String jdbc_url = "jdbc:mysql://localhost:3306/project?useUnicode=true" + "&characterEncoding=UTF8&serverTimezone=UTC";
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(jdbc_url, "root","vkdnjdp2em");
			stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				subqr = rs.getString("SUBSTR(user_address,1,13)");
			}
			String sql2 = "select * from storetbl where store_r_address like '"+subqr+"%' and store_category like '%??????%' OR '%?????????%';";
			ResultSet rs2 = stmt.executeQuery(sql2);
			
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(rs2.next()) {
				list.add(new String[] {rs2.getString("store_num"),
						               rs2.getString("store_name"),
						               rs2.getString("store_category"),
						               rs2.getString("store_r_address"),
						               rs2.getString("store_address")});
				
			}
			System.out.println("The data has been fetched");
			String[][] arr = new String[list.size()][5];
			return list.toArray(arr);
		
		} catch(Exception e) {e.printStackTrace(); return null;}
		
	}
	
	public static String[][] getEtNearStore(SignUpDTO dto) throws Exception {
		Connection con = null;
		Statement stmt = null;
		String current_id = dto.getId();
		String subqr = "";
		
		try {
			String sql = "select SUBSTR(user_address,1,13) from usertbl where user_ID = '"+current_id+"';";
			String jdbc_url = "jdbc:mysql://localhost:3306/project?useUnicode=true" + "&characterEncoding=UTF8&serverTimezone=UTC";
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(jdbc_url, "root","vkdnjdp2em");
			stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				subqr = rs.getString("SUBSTR(user_address,1,13)");
			}
			String sql2 = "select * from storetbl where store_r_address like '"+subqr+"%' and store_category like '%??????%' OR '%??????%' OR '%??????%' OR '%??????%' OR '%??????%' OR '%??????%' OR '%??????%' OR '%??????%' OR '%??????%' OR '%?????????%' OR '%?????????%' OR '%?????????%'"
					+" OR '%??????%' OR '%??????%' OR '%???%';";
			ResultSet rs2 = stmt.executeQuery(sql2);
			
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(rs2.next()) {
				list.add(new String[] {rs2.getString("store_num"),
						               rs2.getString("store_name"),
						               rs2.getString("store_category"),
						               rs2.getString("store_r_address"),
						               rs2.getString("store_address")});
				
			}
			System.out.println("The data has been fetched");
			String[][] arr = new String[list.size()][5];
			return list.toArray(arr);
		
		} catch(Exception e) {e.printStackTrace(); return null;}
		
	}
	
	public static String[][] getScNearStore(SignUpDTO dto) throws Exception {
		Connection con = null;
		Statement stmt = null;
		String current_id = dto.getId();
		String subqr = "";
		
		try {
			String sql = "select SUBSTR(user_address,1,13) from usertbl where user_ID = '"+current_id+"';";
			String jdbc_url = "jdbc:mysql://localhost:3306/project?useUnicode=true" + "&characterEncoding=UTF8&serverTimezone=UTC";
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(jdbc_url, "root","vkdnjdp2em");
			stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				subqr = rs.getString("SUBSTR(user_address,1,13)");
			}
			String sql2 = "select * from storetbl where store_r_address like '"+subqr+"%';";
			ResultSet rs2 = stmt.executeQuery(sql2);
			
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(rs2.next()) {
				list.add(new String[] {rs2.getString("store_num"),
						               rs2.getString("store_name"),
						               rs2.getString("store_category"),
						               rs2.getString("store_r_address"),
						               rs2.getString("store_address")});
				
			}
			System.out.println("The data has been fetched");
			String[][] arr = new String[list.size()][5];
			return list.toArray(arr);
		
		} catch(Exception e) {e.printStackTrace(); return null;}
		
	}
    public static boolean delMember(SignUpDTO dto) throws Exception {
		
	    boolean check=false;
	    Connection con = null;
	    Statement stmt = null;
	    String id = dto.getId();

	 
	
	try {
		System.out.println(id);
		String sql = "delete from project.usertbl where user_ID='"+id+"'";
		String jdbc_url = "jdbc:mysql://localhost:3306/project?useUnicode=true" + "&characterEncoding=UTF8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(jdbc_url, "root","vkdnjdp2em");
		stmt = (Statement) con.createStatement();
		stmt.executeUpdate(sql);
		System.out.println(sql);
		check=true;
	    }catch(Exception e) {
		     e.printStackTrace();
		     System.out.println("deleteData err :"+e);
		     check=false;
	    }
	return check;
 } 
    public static String[][] getStoreDetail(SignUpDTO dto) throws Exception {
		Connection con = null;
		Statement stmt = null;
		int storeNum = dto.getStoreNum();
		System.out.println(storeNum);
		try {
			String sql = "SELECT store_num,store_name,store_category,store_r_address,store_address From project.storetbl WHERE store_num='"+storeNum+"';";
			String jdbc_url = "jdbc:mysql://localhost:3306/project?useUnicode=true" + "&characterEncoding=UTF8&serverTimezone=UTC";
			con = DriverManager.getConnection(jdbc_url, "root","vkdnjdp2em");
			Class.forName("com.mysql.cj.jdbc.Driver");
			stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(rs.next()) {
				list.add(new String[] {
						               rs.getString("store_name"),
						               rs.getString("store_category"),
						               rs.getString("store_address"),
						               rs.getString("store_r_address")});	
			}
			System.out.println("The data has been fetched");
			String[][] arr = new String[0][4];
			return list.toArray(arr);
		
		} catch(Exception e) {e.printStackTrace(); return null;}
		
	}
	public static String[][] getReview(SignUpDTO dto) throws Exception {
		Connection con = null;
		Statement stmt = null;
		int storeNum = dto.getStoreNum();
		
		try {
			String sql = "SELECT user_ID, review_title, review_content From project.reviewtbl WHERE store_num='"+storeNum+"';";
			String jdbc_url = "jdbc:mysql://localhost:3306/project?useUnicode=true" + "&characterEncoding=UTF8&serverTimezone=UTC";
			con = DriverManager.getConnection(jdbc_url, "root","vkdnjdp2em");
			Class.forName("com.mysql.cj.jdbc.Driver");
			stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(rs.next()) {
//				String str = rs.getString("user_ID") + "\t" + rs.getString("review_content") + "\n";
//				textArea.append(str);
				list.add(new String[] {
						               rs.getString("user_ID"),
						               rs.getString("review_title"),
						               rs.getString("review_content")});	
			}
			System.out.println("The data has been fetched");
			System.out.println(list.size());
			String[][] arr = new String[list.size()][3];
			return list.toArray(arr);
		
		} catch(Exception e) {e.printStackTrace(); return null;}
		
	}
	public static boolean SaveReview(SignUpDTO dto) throws Exception {
		
		boolean flag = false;
		Connection con = null;
		Statement stmt = null;
		String id = dto.getId();
		String title = dto.getTitle();
		String content = dto.getContent();
		int storeNum = dto.getStoreNum();
		
		try {
		
			String sql = "insert into reviewtbl(user_ID,review_title,review_content,store_num)"
					+ "values('"+id+"', '"+title+"' ,'"+content+"','"+storeNum+"');";
			
			String jdbc_url = "jdbc:mysql://localhost:3306/project?useUnicode=true" + "&characterEncoding=UTF8&serverTimezone=UTC";
			con = DriverManager.getConnection(jdbc_url, "root","vkdnjdp2em");
			Class.forName("com.mysql.cj.jdbc.Driver");
			stmt = (Statement) con.createStatement();
			stmt.executeUpdate(sql);
			flag = true;
		} catch (Exception e) {
			System.out.println(e);
			flag = false;
		} finally {
			
			try {
				if(stmt != null)
					stmt.close();
				if(con != null)
					con.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return flag;
	}
}



