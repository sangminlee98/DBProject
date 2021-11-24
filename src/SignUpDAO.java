import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


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
	
}
