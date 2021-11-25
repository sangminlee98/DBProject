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
			String sql = "SELECT store_num,store_name,store_category,store_r_address,store_address From project.storetbl WHERE store_category Like '%음식%' OR '%식품%';";
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
			String sql = "SELECT store_num,store_name,store_category,store_r_address,store_address From project.storetbl WHERE store_category Like '%레저%' OR '%여행%' OR'%레져%';";
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
			String sql = "SELECT store_num,store_name,store_category,store_r_address,store_address From project.storetbl WHERE store_category Like '%병원%' OR '%의료%' OR '%보건%' OR '%약국%' OR '%의원%';";
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
			String sql = "SELECT store_num,store_name,store_category,store_r_address,store_address From project.storetbl WHERE store_category Like '%의류%';";
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
			String sql = "SELECT store_num,store_name,store_category,store_r_address,store_address From project.storetbl WHERE store_category Like '%가구%' OR '%전기%' OR '%주방%';";
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
			String sql = "SELECT store_num,store_name,store_category,store_r_address,store_address From project.storetbl WHERE store_category Like '%잡화%' OR '%유통업%';";
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
			String sql = "SELECT store_num,store_name,store_category,store_r_address,store_address From project.storetbl WHERE store_category Like '%기타%' OR '%건축%' OR '%제품%' OR '%농업%' OR '%문화%' OR '%별도%' OR '%보험%' OR '%사무%' OR '%서적%' OR '%서비스%' OR '%비영리%' OR '%자동차%'"
					+" OR '%직물%' OR '%학원%' OR '%회%';";
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
			String sql = "SELECT store_num,store_name,store_category,store_r_address,store_address From project.storetbl WHERE store_category Like '%숙박%';";
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
			String sql = "SELECT store_num,store_name,store_category,store_r_address,store_address From project.storetbl WHERE store_name Like '%"+searchTxt+"%' and store_category Like '%음식%' OR '%식품%';";
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
			String sql = "SELECT store_num,store_name,store_category,store_r_address,store_address From project.storetbl WHERE store_name Like '%"+searchTxt+"%' and store_category Like '%레저%' OR '%여행%' OR'%레져%';";
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
			String sql = "SELECT store_num,store_name,store_category,store_r_address,store_address From project.storetbl WHERE store_name Like '%"+searchTxt+"%' and store_category Like '%숙박%';";
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
			String sql = "SELECT store_num,store_name,store_category,store_r_address,store_address From project.storetbl WHERE store_name Like '%"+searchTxt+"%' and store_category Like '%병원%' OR '%의료%' OR '%보건%' OR '%약국%' OR '%의원%';";
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
			String sql = "SELECT store_num,store_name,store_category,store_r_address,store_address From project.storetbl WHERE store_name Like '%"+searchTxt+"%' and store_category Like '%의류%';";
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
			String sql = "SELECT store_num,store_name,store_category,store_r_address,store_address From project.storetbl WHERE store_name Like '%"+searchTxt+"%' and store_category Like '%가구%' OR '%전기%' OR '%주방%';";
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
			String sql = "SELECT store_num,store_name,store_category,store_r_address,store_address From project.storetbl WHERE store_name Like '%"+searchTxt+"%' and store_category Like '%잡화%' OR '%유통업%';";
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
			String sql = "SELECT store_num,store_name,store_category,store_r_address,store_address From project.storetbl WHERE store_name Like '%"+searchTxt+"%' and store_category Like '%기타%' OR '%건축%' OR '%제품%' OR '%농업%' OR '%문화%' OR '%별도%' OR '%보험%' OR '%사무%' OR '%서적%' OR '%서비스%' OR '%비영리%' OR '%자동차%'"
					+" OR '%직물%' OR '%학원%' OR '%회%';";
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
			String sql2 = "select * from storetbl where store_r_address like '"+subqr+"%' and store_category like '%음식%' OR '%식품%';";
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
			String sql2 = "select * from storetbl where store_r_address like '"+subqr+"%' and store_category like '%레저%' OR '%여행%' OR'%레져%';";
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
			String sql2 = "select * from storetbl where store_r_address like '"+subqr+"%' and store_category like '%숙박%';";
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
			String sql2 = "select * from storetbl where store_r_address like '"+subqr+"%' and store_category like '%병원%' OR '%의료%' OR '%보건%' OR '%약국%' OR '%의원%';";
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
			String sql2 = "select * from storetbl where store_r_address like '"+subqr+"%' and store_category like '%의류%';";
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
			String sql2 = "select * from storetbl where store_r_address like '"+subqr+"%' and store_category like '%가구%' OR '%전기%' OR '%주방%';";
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
			String sql2 = "select * from storetbl where store_r_address like '"+subqr+"%' and store_category like '%잡화%' OR '%유통업%';";
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
			String sql2 = "select * from storetbl where store_r_address like '"+subqr+"%' and store_category like '%기타%' OR '%건축%' OR '%제품%' OR '%농업%' OR '%문화%' OR '%별도%' OR '%보험%' OR '%사무%' OR '%서적%' OR '%서비스%' OR '%비영리%' OR '%자동차%'"
					+" OR '%직물%' OR '%학원%' OR '%회%';";
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
}



