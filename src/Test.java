import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTextArea;

public class Test {
   
   private JFrame frame;
   private JTextField textField;
   static Connection con;
   Statement stmt;
   DefaultTableModel model;
   String name, address, category, Id, content, title;
   JTextArea textArea;
   
   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      
      
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               Test window = new Test();
               window.frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }
   public static void getConnection() {
      
      try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         String jdbc_url = "jdbc:mysql://localhost:3306/project?useUnicode=true" + "&characterEncoding=UTF8&serverTimezone=UTC";
         con = DriverManager.getConnection(jdbc_url, "root","vkdnjdp2em");
         System.out.println("데이터베이스에 접속했습니다.!");
         }catch(Exception e) {
            System.out.println("DB 접속 오류:"+e);
         }
   }
   public void select() {
         
         try {
            stmt = con.createStatement();
            String sql = "SELECT * FROM storetbl where store_num = 2";
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()) {
               name=rs.getString("store_name");
               address=rs.getString("store_address");
               category=rs.getString("store_category");
               }
         }catch(Exception e) {
            System.out.println("select() 실행 오류 : "+e );
      }
   }
   public void review() {
      
      try {
         stmt = con.createStatement();
         String sql = "SELECT * FROM reviewtbl ";
         ResultSet rs = stmt.executeQuery(sql);
         textArea.append("\t" + "TITLE\t" + "ID\t" + "CONTENT\t" + "\n");
         textArea.append("-----------------------------------------------------------------------------------\n ");
         
         while(rs.next()) {
            Id=rs.getString("user_ID");
            content=rs.getString("review_content");
            title=rs.getString("review_title");
            textArea.append(title + "\t" + Id + "\t" + content + "\n" );
         }
      }catch(Exception e) {
         System.out.println("select() 실행 오류 : "+e );
      }
   }

   /**
    * Create the application.
    */
   public Test() {
      initialize();
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize() {
      frame = new JFrame();
      frame.setSize(400,600);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(null);
      getConnection();
      select();
      System.out.println(name);
      

      
      JPanel reviewPage = new JPanel();
      reviewPage.setBounds(0, 0, 384, 561);
      frame.getContentPane().add(reviewPage);
      reviewPage.setLayout(null);
      
      JButton btnBack = new JButton("\uB4A4\uB85C\uAC00\uAE30");
      btnBack.setBounds(143, 5, 97, 23);
      reviewPage.add(btnBack);
      
      textField = new JTextField();
      textField.setBounds(88, 350, 284, 23);
      reviewPage.add(textField);
      textField.setColumns(10);
      
      JButton btnNewButton = new JButton("\uC791\uC131");
      btnNewButton.setBounds(143, 403, 97, 23);
      reviewPage.add(btnNewButton);
      
      JLabel lblNewLabel = new JLabel("\uB9AC\uBDF0 \uC791\uC131 :");
      lblNewLabel.setBounds(12, 354, 64, 15);
      reviewPage.add(lblNewLabel);
      
      textArea = new JTextArea();
      review();
      
      
      textArea.setBounds(12, 34, 360, 295);
      reviewPage.add(textArea);
      
      reviewPage.setVisible(false);
      
      
      
      JPanel detailPage = new JPanel();
      detailPage.setBounds(0, 0, 384, 561);
      frame.getContentPane().add(detailPage);
      detailPage.setLayout(null);
      
      JButton btnReview = new JButton("\uB9AC\uBDF0");
      btnReview.setBounds(137, 499, 97, 23);
      detailPage.add(btnReview);
      
      JLabel lb1 = new JLabel("\uAC00\uAC8C\uBA85:");
      lb1.setFont(new Font("굴림", Font.PLAIN, 20));
      lb1.setBounds(12, 50, 83, 44);
      detailPage.add(lb1);
      
      JLabel lb2 = new JLabel("\uCE74\uD14C\uACE0\uB9AC:");
      lb2.setFont(new Font("굴림", Font.PLAIN, 20));
      lb2.setBounds(12, 131, 97, 24);
      detailPage.add(lb2);
      
      JLabel lb3 = new JLabel("\uC8FC\uC18C:");
      lb3.setFont(new Font("굴림", Font.PLAIN, 20));
      lb3.setBounds(12, 199, 83, 35);
      detailPage.add(lb3);
      
      JLabel lblNewLabel_1 = new JLabel(name);
      lblNewLabel_1.setBounds(107, 52, 259, 44);
      detailPage.add(lblNewLabel_1);
      
      JLabel lblNewLabel_1_1 = new JLabel(category);
      lblNewLabel_1_1.setBounds(107, 122, 259, 44);
      detailPage.add(lblNewLabel_1_1);
      
      JLabel lblNewLabel_1_2 = new JLabel(address);
      lblNewLabel_1_2.setBounds(107, 190, 259, 44);
      detailPage.add(lblNewLabel_1_2);
      
      btnReview.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            reviewPage.setVisible(true);
            detailPage.setVisible(false);
            
         }
         
      });
      
      btnBack.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            detailPage.setVisible(true);
            reviewPage.setVisible(false);
            
         }
         
      });
   }
}