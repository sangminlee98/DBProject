import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DBProject extends JFrame {
	
	SignUpDTO dto = new SignUpDTO();
	
		private JFrame frame;
		private JTextField textField, textField_1;
		private JTextField textField2, textField_2;
		private JTextField textField3, textField_3;
		private JTextField textField4, textField_4;
		private JTextField textField5, textField_5;
		private JTextField textField6, textField_6;
		private JTextField textField7, textField_7;
		private JTextField textField8, textField_8;
		private JTextField textField9, textField_9;
		Connection con;
		Statement stmt;
		DefaultTableModel model;
		String name, address, category, Id, content, title, r_address;
		JTextArea textArea, textArea2, textArea3, textArea4, textArea5, textArea6, textArea7, textArea8, textArea9;

	public DBProject() {
		super("DBProject");
		setLayout(null);
		
		////////////////////////////////////////////시작 페이지///////////////////////////////////////////////////////////////////////////////////////////////////////////
		JPanel startPage = new JPanel();
		
		startPage.setLayout(new FlowLayout());
		
		JPanel jp1 = new JPanel();
		jp1.setBorder(new TitledBorder(new EtchedBorder()));
		
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		
		JLabel title = new JLabel("가맹점 찾기 서비스");
		title.setFont(title.getFont().deriveFont(30.0F));
		jp2.add(title);
		
		JButton signIn = new JButton("로그인");
		JButton signUp = new JButton("회원가입");
		
		Box buttons = Box.createHorizontalBox();
		buttons.add(signIn);
		buttons.add(Box.createHorizontalStrut(50));
		buttons.add(signUp);
		jp3.add(buttons);
		
		Box form = Box.createVerticalBox();
		form.add(Box.createVerticalStrut(30));
		form.add(jp2);
		form.add(Box.createVerticalStrut(50));
		form.add(jp3);
		form.add(Box.createVerticalStrut(30));
		
		jp1.add(form);
		
		Box start = Box.createVerticalBox();
		start.add(Box.createVerticalStrut(130));
		start.add(jp1);
		
		startPage.add(start);
		
		startPage.setVisible(true);
		startPage.setSize(400,600);
		
		
		
		////////////////////////////////////////////회원가입 페이지///////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		JPanel signUpPage = new JPanel();
		
		signUpPage.setLayout(null);
		
		JPanel container = new JPanel();
		container.setBorder(new TitledBorder(new EtchedBorder()));
		container.setBounds(20,50,350,430);
		
		JLabel title1 = new JLabel("회원 가입");
		title1.setFont(title1.getFont().deriveFont(30.0F));
		title1.setBounds(130,80,133,32);
		signUpPage.add(title1);
		
		JLabel idlb = new JLabel("ID");
		idlb.setFont(idlb.getFont().deriveFont(13.0F));
		JLabel pwlb = new JLabel("PW");
		JLabel namelb = new JLabel("이름");
		JLabel phonelb = new JLabel("C.P");
		JLabel addrlb = new JLabel("주소");
		JLabel addrexlb = new JLabel("Ex) 경기 안양시 **구 **로");
		
		
		JTextField idInput = new JTextField();
		JPasswordField pwInput = new JPasswordField();
		JTextField nameInput = new JTextField();
		JTextField phoneInput = new JTextField();
		JTextField addrInput = new JTextField();
		
		JButton idCheck = new JButton("중복확인");
		idCheck.setMargin(new Insets(0,0,0,0));
		JButton submit = new JButton("가입하기");
		
		idlb.setBounds(40,180,30,30);
		signUpPage.add(idlb);
		idInput.setBounds(75,185,180,20);
		signUpPage.add(idInput);
		idCheck.setBounds(270,185,80,20);
		signUpPage.add(idCheck);
		
		pwlb.setBounds(40,220,30,30);
		signUpPage.add(pwlb);
		pwInput.setBounds(75,225,180,20);
		signUpPage.add(pwInput);
		
		namelb.setBounds(40,260,30,30);
		signUpPage.add(namelb);
		nameInput.setBounds(75,265,180,20);
		signUpPage.add(nameInput);
		
		phonelb.setBounds(40,300,30,30);
		signUpPage.add(phonelb);
		phoneInput.setBounds(75,305,180,20);
		signUpPage.add(phoneInput);
		
		addrlb.setBounds(40,340,30,30);
		signUpPage.add(addrlb);
		addrInput.setBounds(75,345,180,20);
		signUpPage.add(addrInput);
		addrexlb.setBounds(75,375,180,20);
		signUpPage.add(addrexlb);
		
		submit.setBounds(150,420,100,30);
		signUpPage.add(submit);
		
		signUpPage.add(container);
		
		signUpPage.setVisible(false);
		signUpPage.setSize(400,600);

		////////////////////////////////////////////로그인 페이지///////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		JPanel signInPage = new JPanel();
		
		signInPage.setLayout(null);
		
		JPanel container1 = new JPanel();
		container1.setBorder(new TitledBorder(new EtchedBorder()));
		container1.setBounds(40,50,300,400);
		
		JLabel title2 = new JLabel("로그인");
		title2.setFont(title2.getFont().deriveFont(30.0F));
		title2.setBounds(145,140,133,32);
		signInPage.add(title2);
		
		JLabel idlb1 = new JLabel("ID");
		idlb1.setFont(idlb1.getFont().deriveFont(13.0F));
		JLabel pwlb1 = new JLabel("PW");

		JTextField idInput1 = new JTextField();
		JPasswordField pwInput1 = new JPasswordField();

		JButton submit1 = new JButton("로그인");
		
		idlb1.setBounds(65,210,30,30);
		signInPage.add(idlb1);
		idInput1.setBounds(100,215,180,20);
		signInPage.add(idInput1);

		pwlb1.setBounds(65,250,30,30);
		signInPage.add(pwlb1);
		pwInput1.setBounds(100,255,180,20);
		signInPage.add(pwInput1);
		
		JButton signUp1 = new JButton("회원가입");
		signUp1.setBounds(200,310,100,30);
		signInPage.add(signUp1);
		submit1.setBounds(90,310,100,30);
		signInPage.add(submit1);
		
		signInPage.add(container1);
		
		signInPage.setVisible(false);
		signInPage.setSize(400,600);
		
		////////////////////////////////////////////main페이지///////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		JPanel mainPage = new JPanel();
		
		mainPage.setLayout(new FlowLayout());

		JPanel maintitlepl = new JPanel();
		JPanel searchpl = new JPanel();
		JPanel catpl1 = new JPanel();
		JPanel catpl2 = new JPanel();
		
		// 이미지들 크기 조정
		ImageIcon btIcon = new ImageIcon(DBProject.class.getResource("./images/searchIcon.png")); 
		Image btnImg = btIcon.getImage();
		Image changeimg = btnImg.getScaledInstance(25,25,Image.SCALE_SMOOTH);
		ImageIcon newBtnIcon = new ImageIcon(changeimg); // 검색이미지
		
		ImageIcon btIcon1 = new ImageIcon(DBProject.class.getResource("./images/foodIcon.png")); 
		Image btnImg1 = btIcon1.getImage();
		Image changeimg1 = btnImg1.getScaledInstance(45,45,Image.SCALE_SMOOTH);
		ImageIcon newBtnIcon1 = new ImageIcon(changeimg1); // 음식이미지

		ImageIcon btIcon2 = new ImageIcon(DBProject.class.getResource("./images/travelIcon.png")); 
		Image btnImg2 = btIcon2.getImage();
		Image changeimg2 = btnImg2.getScaledInstance(45,45,Image.SCALE_SMOOTH);
		ImageIcon newBtnIcon2 = new ImageIcon(changeimg2); // 여행이미지

		ImageIcon btIcon3 = new ImageIcon(DBProject.class.getResource("./images/lodgeIcon.png")); 
		Image btnImg3 = btIcon3.getImage();
		Image changeimg3 = btnImg3.getScaledInstance(45,45,Image.SCALE_SMOOTH);
		ImageIcon newBtnIcon3 = new ImageIcon(changeimg3); // 숙박이미지
		
		ImageIcon btIcon4 = new ImageIcon(DBProject.class.getResource("./images/hospitalIcon.png")); 
		Image btnImg4 = btIcon4.getImage();
		Image changeimg4 = btnImg4.getScaledInstance(45,45,Image.SCALE_SMOOTH);
		ImageIcon newBtnIcon4 = new ImageIcon(changeimg4); // 병원이미지
		
		ImageIcon btIcon5 = new ImageIcon(DBProject.class.getResource("./images/clothIcon.png")); 
		Image btnImg5 = btIcon5.getImage();
		Image changeimg5 = btnImg5.getScaledInstance(45,45,Image.SCALE_SMOOTH);
		ImageIcon newBtnIcon5 = new ImageIcon(changeimg5); // 의류이미지
		
		ImageIcon btIcon6 = new ImageIcon(DBProject.class.getResource("./images/furnitureIcon.png")); 
		Image btnImg6 = btIcon6.getImage();
		Image changeimg6 = btnImg6.getScaledInstance(45,45,Image.SCALE_SMOOTH);
		ImageIcon newBtnIcon6 = new ImageIcon(changeimg6); // 가구이미지
		
		ImageIcon btIcon7 = new ImageIcon(DBProject.class.getResource("./images/convIcon.png")); 
		Image btnImg7 = btIcon7.getImage();
		Image changeimg7 = btnImg7.getScaledInstance(45,45,Image.SCALE_SMOOTH);
		ImageIcon newBtnIcon7 = new ImageIcon(changeimg7); // 편의이미지
		
		ImageIcon btIcon8 = new ImageIcon(DBProject.class.getResource("./images/etcIcon.png")); 
		Image btnImg8 = btIcon8.getImage();
		Image changeimg8 = btnImg8.getScaledInstance(45,45,Image.SCALE_SMOOTH);
		ImageIcon newBtnIcon8 = new ImageIcon(changeimg8); // 기타이미지
		
		
		// 타이틀 추가
		JLabel title3 = new JLabel("가맹점 찾기");
		title3.setFont(title3.getFont().deriveFont(30.0F));
		maintitlepl.add(title3);
		
		// 검색창
		JTextField searchbar = new JTextField(15);
		JButton searchbtn = new JButton();
		searchbtn.setPreferredSize(new Dimension(25,25));
		searchbtn.setIcon(newBtnIcon);		
		searchpl.add(searchbar); searchpl.add(searchbtn);
		
		//카테고리별 버튼 추가
		
		JButton foodbtn = new JButton();
		foodbtn.setIcon(newBtnIcon1);
		foodbtn.setPreferredSize(new Dimension(45,45));
		Box foodSection = Box.createVerticalBox();
		foodSection.add(foodbtn);
		foodSection.add(Box.createVerticalStrut(10));
		foodSection.add(new JLabel("음식"));
		
		JButton travelbtn = new JButton();
		travelbtn.setIcon(newBtnIcon2);
		travelbtn.setPreferredSize(new Dimension(45,45));
		Box travelSection = Box.createVerticalBox();
		travelSection.add(travelbtn);
		travelSection.add(Box.createVerticalStrut(10));
		travelSection.add(new JLabel("여행/레저"));
		
		JButton lodgebtn = new JButton();
		lodgebtn.setIcon(newBtnIcon3);
		lodgebtn.setPreferredSize(new Dimension(45,45));
		Box lodgeSection = Box.createVerticalBox();
		lodgeSection.add(lodgebtn);
		lodgeSection.add(Box.createVerticalStrut(10));
		lodgeSection.add(new JLabel("숙박"));
		
		JButton hospitalbtn = new JButton();
		hospitalbtn.setIcon(newBtnIcon4);
		hospitalbtn.setPreferredSize(new Dimension(45,45));
		Box hospitalSection = Box.createVerticalBox();
		hospitalSection.add(hospitalbtn);
		hospitalSection.add(Box.createVerticalStrut(10));
		hospitalSection.add(new JLabel("의료/병원"));
		
		JButton clothbtn = new JButton();
		clothbtn.setIcon(newBtnIcon5);
		clothbtn.setPreferredSize(new Dimension(45,45));
		Box clothSection = Box.createVerticalBox();
		clothSection.add(clothbtn);
		clothSection.add(Box.createVerticalStrut(10));
		clothSection.add(new JLabel("의류"));
		
		JButton furniturebtn = new JButton();
		furniturebtn.setIcon(newBtnIcon6);
		furniturebtn.setPreferredSize(new Dimension(45,45));
		Box furnitureSection = Box.createVerticalBox();
		furnitureSection.add(furniturebtn);
		furnitureSection.add(Box.createVerticalStrut(10));
		furnitureSection.add(new JLabel("가구"));
		
		JButton convbtn = new JButton();
		convbtn.setIcon(newBtnIcon7);
		convbtn.setPreferredSize(new Dimension(45,45));
		Box convSection = Box.createVerticalBox();
		convSection.add(convbtn);
		convSection.add(Box.createVerticalStrut(10));
		convSection.add(new JLabel("잡화/편의"));
		
		JButton etcbtn = new JButton();
		etcbtn.setIcon(newBtnIcon8);
		etcbtn.setPreferredSize(new Dimension(45,45));
		Box etcSection = Box.createVerticalBox();
		etcSection.add(etcbtn);
		etcSection.add(Box.createVerticalStrut(10));
		etcSection.add(new JLabel("기타"));
		
		Box category1 = Box.createHorizontalBox();
		category1.add(foodSection);
		category1.add(Box.createHorizontalStrut(30));
		category1.add(travelSection);
		category1.add(Box.createHorizontalStrut(30));
		category1.add(lodgeSection);
		category1.add(Box.createHorizontalStrut(30));
		category1.add(hospitalSection);
		
		catpl1.add(category1);
		
		Box category2 = Box.createHorizontalBox();
		category2.add(clothSection);
		category2.add(Box.createHorizontalStrut(30));
		category2.add(furnitureSection);
		category2.add(Box.createHorizontalStrut(30));
		category2.add(convSection);
		category2.add(Box.createHorizontalStrut(30));
		category2.add(etcSection);
		
		catpl2.add(category2);
		
		JButton jbtn = new JButton("회원정보 삭제");
		
		// 메인 박스에 추가
		Box mainBox = Box.createVerticalBox();
		mainBox.add(Box.createVerticalStrut(30));
		mainBox.add(maintitlepl);
		mainBox.add(Box.createVerticalStrut(50));
		mainBox.add(searchpl);
		mainBox.add(Box.createVerticalStrut(60));
		mainBox.add(catpl1);
		mainBox.add(Box.createVerticalStrut(10));
		mainBox.add(catpl2);
		mainBox.add(Box.createVerticalStrut(60));
		JPanel deluserpn = new JPanel();
		deluserpn.add(jbtn);
		mainBox.add(deluserpn);
		
		// 컨테이너에 메인박스 추가
		mainPage.add(mainBox);
		mainPage.setSize(400,600);
		mainPage.setVisible(false);
		
		
		//음식 페이지/////////////////////////////////////////////////////////////////////
		JPanel foodPage = new JPanel();
		
		JPanel fdjp = new JPanel();
		JPanel fdjp2 = new JPanel();
		
		JTextField fdtext;
		JButton fdnearbtn = new JButton("내주변가게");
		
		fdjp.setBackground(Color.gray);
		
		//아이콘 - 설정 
		ImageIcon settingIcon = new ImageIcon("C:\\Users\\soonE\\eclipse-workspace\\DBproject\\src\\images/searchIcon.png");
		Image settingImg =settingIcon.getImage();
		Image changesettingImg = settingImg.getScaledInstance(25,25,Image.SCALE_SMOOTH);
		ImageIcon newsettingIcon = new ImageIcon(changesettingImg);
		//아이콘 - 홈 
		ImageIcon homeIcon = new ImageIcon("C:\\Users\\soonE\\eclipse-workspace\\DBproject\\src\\images/Home.png");
		Image homeImg =homeIcon.getImage();
		Image changehomeImg = homeImg.getScaledInstance(25,25,Image.SCALE_SMOOTH);
		ImageIcon newHomeIcon = new ImageIcon(changehomeImg);
		
		JButton fdhome = new JButton();
		fdhome.setIcon(newHomeIcon);
		fdhome.setPreferredSize(new Dimension(45,45));
		Box fdSection = Box.createVerticalBox();
		fdSection.add(fdhome);
		fdSection.add(Box.createVerticalStrut(10));
		fdSection.add(new JLabel("홈"));	
		
		JButton fdsetting = new JButton();
		fdsetting.setIcon(newsettingIcon);
		fdsetting.setPreferredSize(new Dimension(45,45));
		fdSection.add(fdsetting);
		fdSection.add(Box.createVerticalStrut(10));
		fdSection.add(new JLabel("설정"));
		
		JPanel detailButton = new JPanel();
		JButton detail = new JButton("가게 상세 보기");
		detail.setSize(200, 100);
		detailButton.add(detail);
		
		
		
		String[][] fddata=null;
		try {
			fddata = SignUpDAO.getFdStore();
		} catch (Exception e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		String[] fdheader = new String[] {"가게 번호","상호명","카테고리","도로명주소","주소"};
		DefaultTableModel fdmodel = new DefaultTableModel(fddata,fdheader);
		JTable fdtable = new JTable(fdmodel);
		fdtable.setAlignmentX(0);
		fdtable.setSize(350,550);
		fdjp2.add(new JScrollPane(fdtable));
		
		fdtext = new JTextField(10);
		fdjp.add(fdhome);
		fdjp.add(fdtext);
		fdjp.add(fdnearbtn);
		fdjp.add(fdsetting);
		
		
		foodPage.add(fdjp,BorderLayout.NORTH);
		foodPage.add(fdjp2,BorderLayout.CENTER);
		foodPage.add(detailButton,BorderLayout.SOUTH);
		
		foodPage.setSize(500,600);
		foodPage.setVisible(false);
		

		//여행 페이지/////////////////////////////////////////////////////////////////////
		JPanel trvjp = new JPanel();
		JPanel trvjp2 = new JPanel();
		JTextField trvtext;
		JButton trvnearbtn = new JButton("내주변가게");
		
		JPanel travelPage = new JPanel();
		trvjp.setBackground(Color.gray);
		
		JButton trvhome = new JButton();
		trvhome.setIcon(newHomeIcon);
		trvhome.setPreferredSize(new Dimension(45,45));
		Box trvSection = Box.createVerticalBox();
		trvSection.add(trvhome);
		trvSection.add(Box.createVerticalStrut(10));
		trvSection.add(new JLabel("홈"));	
		
		JButton trvsetting = new JButton();
		trvsetting.setIcon(newsettingIcon);
		trvsetting.setPreferredSize(new Dimension(45,45));
		trvSection.add(trvsetting);
		trvSection.add(Box.createVerticalStrut(10));
		trvSection.add(new JLabel("설정"));
		
		JPanel detailButton2 = new JPanel();
		JButton detail2 = new JButton("가게 상세 보기");
		detail2.setSize(200, 100);
		detailButton2.add(detail2);
		
		String[][] trvdata = null;
		try {
			trvdata = SignUpDAO.getTrvStore();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		String[] trvheader = new String[] {"가게 번호","상호명","카테고리","도로명주소","주소"};
		DefaultTableModel trvmodel = new DefaultTableModel(trvdata,trvheader);
		JTable trvtable = new JTable(trvmodel);
		trvtable.setAlignmentX(0);
		trvtable.setSize(350,550);
		trvjp2.add(new JScrollPane(trvtable));
		
		trvtext = new JTextField(10);
		trvjp.add(trvhome);
		trvjp.add(trvtext);
		trvjp.add(trvnearbtn);
		trvjp.add(trvsetting);
		
		
		travelPage.add(trvjp,BorderLayout.NORTH);
		travelPage.add(trvjp2,BorderLayout.CENTER);
		travelPage.add(detailButton2,BorderLayout.SOUTH);
		
		travelPage.setSize(500,600);
		travelPage.setVisible(false);
		
		//숙박 페이지/////////////////////////////////////////////////////////////////////
		JPanel lodgePage = new JPanel();
		
		JPanel lgjp = new JPanel();
		JPanel lgjp2 = new JPanel();
		JTextField lgtext;
		JButton lgnearbtn = new JButton("내주변가게");
		
		lgjp.setBackground(Color.gray);
		
		JButton lghome = new JButton();
		lghome.setIcon(newHomeIcon);
		lghome.setPreferredSize(new Dimension(45,45));
		Box lgSection = Box.createVerticalBox();
		lgSection.add(lghome);
		lgSection.add(Box.createVerticalStrut(10));
		lgSection.add(new JLabel("홈"));	
		
		JButton lgsetting = new JButton();
		lgsetting.setIcon(newsettingIcon);
		lgsetting.setPreferredSize(new Dimension(45,45));
		lgSection.add(lgsetting);
		lgSection.add(Box.createVerticalStrut(10));
		lgSection.add(new JLabel("설정"));
		
		JPanel detailButton3 = new JPanel();
		JButton detail3 = new JButton("가게 상세 보기");
		detail3.setSize(200, 100);
		detailButton3.add(detail3);
		
		String[][] lgdata=null;
		try {
			lgdata = SignUpDAO.getLgStore();
		} catch (Exception e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		String[] lgheader = new String[] {"가게 번호","상호명","카테고리","도로명주소","주소"};
		DefaultTableModel lgmodel = new DefaultTableModel(lgdata,lgheader);
		JTable lgtable = new JTable(lgmodel);
		lgtable.setAlignmentX(0);
		lgtable.setSize(350,550);
		lgjp2.add(new JScrollPane(lgtable));
		
		lgtext = new JTextField(10);
		lgjp.add(lghome);
		lgjp.add(lgtext);
		lgjp.add(lgnearbtn);
		lgjp.add(lgsetting);
		
		
		lodgePage.add(lgjp,BorderLayout.NORTH);
		lodgePage.add(lgjp2,BorderLayout.CENTER);
		lodgePage.add(detailButton3,BorderLayout.SOUTH);

		lodgePage.setSize(500,600);
		lodgePage.setVisible(false);
		

		
		//병원 페이지/////////////////////////////////////////////////////////////////////
		JPanel medicalPage = new JPanel();
		JPanel mdjp = new JPanel();
		JPanel mdjp2 = new JPanel();
		JTextField mdtext;
		JButton mdnearbtn = new JButton("내주변가게");
		
		mdjp.setBackground(Color.gray);
		
		JButton mdhome = new JButton();
		mdhome.setIcon(newHomeIcon);
		mdhome.setPreferredSize(new Dimension(45,45));
		Box mdSection = Box.createVerticalBox();
		mdSection.add(mdhome);
		mdSection.add(Box.createVerticalStrut(10));
		mdSection.add(new JLabel("홈"));	
		
		JButton mdsetting = new JButton();
		mdsetting.setIcon(newsettingIcon);
		mdsetting.setPreferredSize(new Dimension(45,45));
		mdSection.add(mdsetting);
		mdSection.add(Box.createVerticalStrut(10));
		mdSection.add(new JLabel("설정"));
		
		JPanel detailButton4 = new JPanel();
		JButton detail4 = new JButton("가게 상세 보기");
		detail4.setSize(200, 100);
		detailButton4.add(detail4);
		
		String[][] mddata=null;
		try {
			mddata = SignUpDAO.getMdStore();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		String[] mdheader = new String[] {"가게 번호","상호명","카테고리","도로명주소","주소"};
		DefaultTableModel mdmodel = new DefaultTableModel(mddata,mdheader);
		JTable mdtable = new JTable(mdmodel);
		mdtable.setAlignmentX(0);
		mdtable.setSize(350,550);
		mdjp2.add(new JScrollPane(mdtable));
		
		mdtext = new JTextField(10);
		mdjp.add(mdhome);
		mdjp.add(mdtext);
		mdjp.add(mdnearbtn);
		mdjp.add(mdsetting);
		
		
		medicalPage.add(mdjp,BorderLayout.NORTH);
		medicalPage.add(mdjp2,BorderLayout.CENTER);
		medicalPage.add(detailButton4,BorderLayout.SOUTH);
		
		medicalPage.setSize(500,600);
		medicalPage.setVisible(false);

		
		//의류 페이지/////////////////////////////////////////////////////////////////////
		JPanel clothesPage = new JPanel();
		
		JPanel cljp = new JPanel();
		JPanel cljp2 = new JPanel();

		JTextField cltext;
		JButton clnearbtn = new JButton("내주변가게");
		
		cljp.setBackground(Color.gray);
		
		
		JButton clhome = new JButton();
		clhome.setIcon(newHomeIcon);
		clhome.setPreferredSize(new Dimension(45,45));
		Box clSection = Box.createVerticalBox();
		clSection.add(clhome);
		clSection.add(Box.createVerticalStrut(10));
		clSection.add(new JLabel("홈"));	
		
		JButton clsetting = new JButton();
		clsetting.setIcon(newsettingIcon);
		clsetting.setPreferredSize(new Dimension(45,45));
		clSection.add(clsetting);
		clSection.add(Box.createVerticalStrut(10));
		clSection.add(new JLabel("설정"));
		
		JPanel detailButton5 = new JPanel();
		JButton detail5 = new JButton("가게 상세 보기");
		detail5.setSize(200, 100);
		detailButton5.add(detail5);
		
		String[][] cldata=null;
		try {
			cldata = SignUpDAO.getClStore();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		String[] clheader = new String[] {"가게 번호","상호명","카테고리","도로명주소","주소"};
		DefaultTableModel clmodel = new DefaultTableModel(cldata,clheader);
		JTable cltable = new JTable(clmodel);
		cltable.setAlignmentX(0);
		cltable.setSize(350,550);
		cljp2.add(new JScrollPane(cltable));
		
		cltext = new JTextField(10);
		cljp.add(clhome);
		cljp.add(cltext);
		cljp.add(clnearbtn);
		cljp.add(clsetting);
		
		
		clothesPage.add(cljp,BorderLayout.NORTH);
		clothesPage.add(cljp2,BorderLayout.CENTER);
		clothesPage.add(detailButton5,BorderLayout.SOUTH);
		
		clothesPage.setSize(500,600);
		clothesPage.setVisible(false);
		
		//가구 페이지/////////////////////////////////////////////////////////////////////
		JPanel furniturePage = new JPanel();
		
		JPanel ftjp = new JPanel();
		JPanel ftjp2 = new JPanel();

		JTextField fttext;
		JButton ftnearbtn = new JButton("내주변가게");
		
		ftjp.setBackground(Color.gray);
		
		JButton fthome = new JButton();
		fthome.setIcon(newHomeIcon);
		fthome.setPreferredSize(new Dimension(45,45));
		Box ftSection = Box.createVerticalBox();
		ftSection.add(fthome);
		ftSection.add(Box.createVerticalStrut(10));
		ftSection.add(new JLabel("홈"));	
		
		JButton ftsetting = new JButton();
		ftsetting.setIcon(newsettingIcon);
		ftsetting.setPreferredSize(new Dimension(45,45));
		ftSection.add(ftsetting);
		ftSection.add(Box.createVerticalStrut(10));
		ftSection.add(new JLabel("설정"));
		
		JPanel detailButton6 = new JPanel();
		JButton detail6 = new JButton("가게 상세 보기");
		detail6.setSize(200, 100);
		detailButton6.add(detail6);
		
		String[][] ftdata=null;
		try {
			ftdata = SignUpDAO.getFtStore();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		String[] ftheader = new String[] {"가게 번호","상호명","카테고리","도로명주소","주소"};
		DefaultTableModel ftmodel = new DefaultTableModel(ftdata,ftheader);
		JTable fttable = new JTable(ftmodel);
		fttable.setAlignmentX(0);
		fttable.setSize(350,550);
		ftjp2.add(new JScrollPane(fttable));
		
		fttext = new JTextField(10);
		ftjp.add(fthome);
		ftjp.add(fttext);
		ftjp.add(ftnearbtn);
		ftjp.add(ftsetting);
		
		
		furniturePage.add(ftjp,BorderLayout.NORTH);
		furniturePage.add(ftjp2,BorderLayout.CENTER);
		furniturePage.add(detailButton6,BorderLayout.SOUTH);
		
		furniturePage.setSize(500,600);
		furniturePage.setVisible(false);
		
		//잡화 페이지/////////////////////////////////////////////////////////////////////
		JPanel stuffPage = new JPanel();
		JPanel sfjp = new JPanel();
		JPanel sfjp2 = new JPanel();
		JTextField sftext;
		JButton sfnearbtn = new JButton("내주변가게");
		
		sfjp.setBackground(Color.gray);
		
		JButton sfhome = new JButton();
		sfhome.setIcon(newHomeIcon);
		sfhome.setPreferredSize(new Dimension(45,45));
		Box sfSection = Box.createVerticalBox();
		sfSection.add(sfhome);
		sfSection.add(Box.createVerticalStrut(10));
		sfSection.add(new JLabel("홈"));	
		
		JButton sfsetting = new JButton();
		sfsetting.setIcon(newsettingIcon);
		sfsetting.setPreferredSize(new Dimension(45,45));
		sfSection.add(sfsetting);
		sfSection.add(Box.createVerticalStrut(10));
		sfSection.add(new JLabel("설정"));
		
		JPanel detailButton7 = new JPanel();
		JButton detail7 = new JButton("가게 상세 보기");
		detail7.setSize(200, 100);
		detailButton7.add(detail7);
		
		String[][] sfdata=null;
		try {
			sfdata = SignUpDAO.getSfStore();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		String[] sfheader = new String[] {"가게 번호","상호명","카테고리","도로명주소","주소"};
		DefaultTableModel sfmodel = new DefaultTableModel(sfdata,sfheader);
		JTable sftable = new JTable(sfmodel);
		sftable.setAlignmentX(0);
		sftable.setSize(350,550);
		sfjp2.add(new JScrollPane(sftable));
		
		sftext = new JTextField(10);
		sfjp.add(sfhome);
		sfjp.add(sftext);
		sfjp.add(sfnearbtn);
		sfjp.add(sfsetting);
		
		
		stuffPage.add(sfjp,BorderLayout.NORTH);
		stuffPage.add(sfjp2,BorderLayout.CENTER);
		stuffPage.add(detailButton7,BorderLayout.SOUTH);
		
		stuffPage.setSize(500,600);
		stuffPage.setVisible(false);
		
		//기타 페이지/////////////////////////////////////////////////////////////////////
		JPanel etcPage = new JPanel();
		JPanel etjp = new JPanel();
		JPanel etjp2 = new JPanel();
		JTextField ettext;
		JButton etnearbtn = new JButton("내주변가게");
		
		etjp.setBackground(Color.gray);
		
		JButton ethome = new JButton();
		ethome.setIcon(newHomeIcon);
		ethome.setPreferredSize(new Dimension(45,45));
		Box etSection = Box.createVerticalBox();
		etSection.add(ethome);
		etSection.add(Box.createVerticalStrut(10));
		etSection.add(new JLabel("홈"));	
		
		JButton etsetting = new JButton();
		etsetting.setIcon(newsettingIcon);
		etsetting.setPreferredSize(new Dimension(45,45));
		etSection.add(etsetting);
		etSection.add(Box.createVerticalStrut(10));
		etSection.add(new JLabel("설정"));
		
		JPanel detailButton8 = new JPanel();
		JButton detail8 = new JButton("가게 상세 보기");
		detail8.setSize(200, 100);
		detailButton8.add(detail8);
		
		String[][] etdata=null;
		try {
			etdata = SignUpDAO.getEtStore();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		String[] etheader = new String[] {"가게 번호","상호명","카테고리","도로명주소","주소"};
		DefaultTableModel etmodel = new DefaultTableModel(etdata,etheader);
		JTable ettable = new JTable(etmodel);
		ettable.setAlignmentX(0);
		ettable.setSize(350,550);
		etjp2.add(new JScrollPane(ettable));
		
		ettext = new JTextField(10);
		etjp.add(ethome);
		etjp.add(ettext);
		etjp.add(etnearbtn);
		etjp.add(etsetting);
		
		
		etcPage.add(etjp,BorderLayout.NORTH);
		etcPage.add(etjp2,BorderLayout.CENTER);
		etcPage.add(detailButton8,BorderLayout.SOUTH);
		
		etcPage.setSize(500,600);
		etcPage.setVisible(false);
		
		//검색 페이지/////////////////////////////////////////////////////////////////////
		SignUpDTO dto = new SignUpDTO();
		JPanel searchPage = new JPanel();
		
		JPanel scjp = new JPanel();
		JPanel scjp2 = new JPanel();
		JTextField sctext;
		JButton scnearbtn = new JButton("내주변가게");
		
		scjp.setBackground(Color.gray);
		
		JButton schome = new JButton();
		schome.setIcon(newHomeIcon);
		schome.setPreferredSize(new Dimension(45,45));
		Box scSection = Box.createVerticalBox();
		scSection.add(schome);
		scSection.add(Box.createVerticalStrut(10));
		scSection.add(new JLabel("홈"));	
		
		JButton scsetting = new JButton();
		scsetting.setIcon(newsettingIcon);
		scsetting.setPreferredSize(new Dimension(45,45));
		scSection.add(scsetting);
		scSection.add(Box.createVerticalStrut(10));
		scSection.add(new JLabel("설정"));
		
		JPanel detailButton9 = new JPanel();
		JButton detail9 = new JButton("가게 상세 보기");
		detail9.setSize(200, 100);
		detailButton9.add(detail9);
		
		String[][] scdata=null;
		try {
			scdata = SignUpDAO.getSearchStore(dto);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		String[] scheader = new String[] {"가게 번호","상호명","카테고리","도로명주소","주소"};
		DefaultTableModel model = new DefaultTableModel(scdata,scheader);
		JTable sctable = new JTable(model);
		sctable.setAlignmentX(0);
		sctable.setSize(350,550);
		scjp2.add(new JScrollPane(sctable));
		
		sctext = new JTextField(10);
		scjp.add(schome);
		scjp.add(sctext);
		scjp.add(scnearbtn);
		scjp.add(scsetting);
		
		
		searchPage.add(scjp,BorderLayout.NORTH);
		searchPage.add(scjp2,BorderLayout.CENTER);
		searchPage.add(detailButton9,BorderLayout.SOUTH);

		
		searchPage.setSize(500,600);
		searchPage.setVisible(false);
		
		///////////////////////////////////음식 상세페이지//////////////////////
		JLabel lblNewLabel_1 = new JLabel("");
		JLabel lblNewLabel_1_1 = new JLabel("");
		JLabel lblNewLabel_1_2 = new JLabel("");
		JLabel lblNewLabel_1_3 = new JLabel("");
		JButton btnReview = new JButton("리뷰하기");
		JButton gofdpage = new JButton("뒤로 가기");
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JPanel detailPage = new JPanel();
		frame.setContentPane(detailPage);
		detailPage.setBounds(0, 0, 384, 561);
		detailPage.setLayout(null);
		
		gofdpage.setBounds(12, 17, 97, 23);
		detailPage.add(gofdpage);
		
		btnReview.setBounds(137, 499, 97, 23);
		detailPage.add(btnReview);
		
		JLabel lb1 = new JLabel("가게명:");
		lb1.setFont(new Font("굴림", Font.PLAIN, 20));
		lb1.setBounds(12, 50, 83, 44);
		detailPage.add(lb1);
		
		JLabel lb2 = new JLabel("카테고리:");
		lb2.setFont(new Font("굴림", Font.PLAIN, 20));
		lb2.setBounds(12, 131, 97, 24);
		detailPage.add(lb2);
		
		JLabel lb3 = new JLabel("주소:");
		lb3.setFont(new Font("굴림", Font.PLAIN, 20));
		lb3.setBounds(12, 199, 83, 35);
		detailPage.add(lb3);
		
		JLabel lb4 = new JLabel("도로명 주소:");
		lb4.setFont(new Font("굴림", Font.PLAIN, 20));
		lb4.setBounds(12, 271, 114, 35);
		detailPage.add(lb4);
		
		lblNewLabel_1.setBounds(107, 52, 259, 44);
		detailPage.add(lblNewLabel_1);
		
		lblNewLabel_1_1.setBounds(107, 122, 259, 44);
		detailPage.add(lblNewLabel_1_1);
		
		lblNewLabel_1_2.setBounds(107, 199, 259, 35);
		detailPage.add(lblNewLabel_1_2);
		
		lblNewLabel_1_3.setBounds(131, 271, 235, 35);
		detailPage.add(lblNewLabel_1_3);
		
		
		
		detailPage.setVisible(false);
		setSize(400,600);
		
		///////////////////////////////////여행 상세페이지//////////////////////
		JLabel lblNewLabel_2 = new JLabel("");
		JLabel lblNewLabel_2_1 = new JLabel("");
		JLabel lblNewLabel_2_2 = new JLabel("");
		JLabel lblNewLabel_2_3 = new JLabel("");
		JButton btnReview2 = new JButton("리뷰하기");
		JButton gotrvpage = new JButton("뒤로 가기");
		JFrame frame2 = new JFrame();
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.getContentPane().setLayout(null);
		JPanel detailPage2 = new JPanel();
		frame2.setContentPane(detailPage2);
		detailPage2.setBounds(0, 0, 384, 561);
		detailPage2.setLayout(null);
		
		gotrvpage.setBounds(12, 17, 97, 23);
		detailPage2.add(gotrvpage);
		
		btnReview2.setBounds(137, 499, 97, 23);
		detailPage2.add(btnReview2);
		
		JLabel lb1_2 = new JLabel("가게명:");
		lb1_2.setFont(new Font("굴림", Font.PLAIN, 20));
		lb1_2.setBounds(12, 50, 83, 44);
		detailPage2.add(lb1_2);
		
		JLabel lb2_2 = new JLabel("카테고리:");
		lb2_2.setFont(new Font("굴림", Font.PLAIN, 20));
		lb2_2.setBounds(12, 131, 97, 24);
		detailPage2.add(lb2_2);
		
		JLabel lb3_2 = new JLabel("주소:");
		lb3_2.setFont(new Font("굴림", Font.PLAIN, 20));
		lb3_2.setBounds(12, 199, 83, 35);
		detailPage2.add(lb3_2);
		
		JLabel lb4_2 = new JLabel("도로명 주소:");
		lb4_2.setFont(new Font("굴림", Font.PLAIN, 20));
		lb4_2.setBounds(12, 271, 114, 35);
		detailPage2.add(lb4_2);
		
		lblNewLabel_2.setBounds(107, 52, 259, 44);
		detailPage2.add(lblNewLabel_2);
		
		lblNewLabel_2_1.setBounds(107, 122, 259, 44);
		detailPage2.add(lblNewLabel_2_1);
		
		lblNewLabel_2_2.setBounds(107, 199, 259, 35);
		detailPage2.add(lblNewLabel_2_2);
		
		lblNewLabel_2_3.setBounds(131, 271, 235, 35);
		detailPage2.add(lblNewLabel_2_3);
		
		
		
		detailPage2.setVisible(false);
		setSize(400,600);
		
		///////////////////////////////////숙박 상세페이지//////////////////////
		JLabel lblNewLabel_3 = new JLabel("");
		JLabel lblNewLabel_3_1 = new JLabel("");
		JLabel lblNewLabel_3_2 = new JLabel("");
		JLabel lblNewLabel_3_3 = new JLabel("");
		JButton btnReview3 = new JButton("리뷰하기");
		JButton goldgpage = new JButton("뒤로 가기");
		JFrame frame3 = new JFrame();
		frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame3.getContentPane().setLayout(null);
		JPanel detailPage3 = new JPanel();
		frame3.setContentPane(detailPage3);
		detailPage3.setBounds(0, 0, 384, 561);
		detailPage3.setLayout(null);
		
		goldgpage.setBounds(12, 17, 97, 23);
		detailPage3.add(goldgpage);
		
		btnReview3.setBounds(137, 499, 97, 23);
		detailPage3.add(btnReview3);
		
		JLabel lb1_3 = new JLabel("가게명:");
		lb1_3.setFont(new Font("굴림", Font.PLAIN, 20));
		lb1_3.setBounds(12, 50, 83, 44);
		detailPage3.add(lb1_3);
		
		JLabel lb2_3 = new JLabel("카테고리:");
		lb2_3.setFont(new Font("굴림", Font.PLAIN, 20));
		lb2_3.setBounds(12, 131, 97, 24);
		detailPage3.add(lb2_3);
		
		JLabel lb3_3 = new JLabel("주소:");
		lb3_3.setFont(new Font("굴림", Font.PLAIN, 20));
		lb3_3.setBounds(12, 199, 83, 35);
		detailPage3.add(lb3_3);
		
		JLabel lb4_3 = new JLabel("도로명 주소:");
		lb4_3.setFont(new Font("굴림", Font.PLAIN, 20));
		lb4_3.setBounds(12, 271, 114, 35);
		detailPage3.add(lb4_3);
		
		lblNewLabel_3.setBounds(107, 52, 259, 44);
		detailPage3.add(lblNewLabel_3);
		
		lblNewLabel_3_1.setBounds(107, 122, 259, 44);
		detailPage3.add(lblNewLabel_3_1);
		
		lblNewLabel_3_2.setBounds(107, 199, 259, 35);
		detailPage3.add(lblNewLabel_3_2);
		
		lblNewLabel_3_3.setBounds(131, 271, 235, 35);
		detailPage3.add(lblNewLabel_3_3);
		
		
		
		detailPage3.setVisible(false);
		setSize(400,600);
		
		///////////////////////////////////의료 상세페이지//////////////////////
		JLabel lblNewLabel_4 = new JLabel("");
		JLabel lblNewLabel_4_1 = new JLabel("");
		JLabel lblNewLabel_4_2 = new JLabel("");
		JLabel lblNewLabel_4_3 = new JLabel("");
		JButton btnReview4 = new JButton("리뷰하기");
		JButton gomdpage = new JButton("뒤로 가기");
		JFrame frame4 = new JFrame();
		frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame4.getContentPane().setLayout(null);
		JPanel detailPage4 = new JPanel();
		frame4.setContentPane(detailPage4);
		detailPage4.setBounds(0, 0, 384, 561);
		detailPage4.setLayout(null);
		
		gomdpage.setBounds(12, 17, 97, 23);
		detailPage4.add(gomdpage);
		
		btnReview4.setBounds(137, 499, 97, 23);
		detailPage4.add(btnReview4);
		
		JLabel lb1_4 = new JLabel("가게명:");
		lb1_4.setFont(new Font("굴림", Font.PLAIN, 20));
		lb1_4.setBounds(12, 50, 83, 44);
		detailPage4.add(lb1_4);
		
		JLabel lb2_4 = new JLabel("카테고리:");
		lb2_4.setFont(new Font("굴림", Font.PLAIN, 20));
		lb2_4.setBounds(12, 131, 97, 24);
		detailPage4.add(lb2_4);
		
		JLabel lb3_4= new JLabel("주소:");
		lb3_4.setFont(new Font("굴림", Font.PLAIN, 20));
		lb3_4.setBounds(12, 199, 83, 35);
		detailPage4.add(lb3_4);
		
		JLabel lb4_4 = new JLabel("도로명 주소:");
		lb4_4.setFont(new Font("굴림", Font.PLAIN, 20));
		lb4_4.setBounds(12, 271, 114, 35);
		detailPage4.add(lb4_4);
		
		lblNewLabel_4.setBounds(107, 52, 259, 44);
		detailPage4.add(lblNewLabel_4);
		
		lblNewLabel_4_1.setBounds(107, 122, 259, 44);
		detailPage4.add(lblNewLabel_4_1);
		
		lblNewLabel_4_2.setBounds(107, 199, 259, 35);
		detailPage4.add(lblNewLabel_4_2);
		
		lblNewLabel_4_3.setBounds(131, 271, 235, 35);
		detailPage4.add(lblNewLabel_4_3);
		
		
		
		detailPage4.setVisible(false);
		setSize(400,600);
		
		///////////////////////////////////의류 상세페이지//////////////////////
		JLabel lblNewLabel_5 = new JLabel("");
		JLabel lblNewLabel_5_1 = new JLabel("");
		JLabel lblNewLabel_5_2 = new JLabel("");
		JLabel lblNewLabel_5_3 = new JLabel("");
		JButton btnReview5 = new JButton("리뷰하기");
		JButton gocltpage = new JButton("뒤로 가기");
		JFrame frame5 = new JFrame();
		frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame5.getContentPane().setLayout(null);
		JPanel detailPage5 = new JPanel();
		frame5.setContentPane(detailPage5);
		detailPage5.setBounds(0, 0, 384, 561);
		detailPage5.setLayout(null);
		
		gocltpage.setBounds(12, 17, 97, 23);
		detailPage5.add(gocltpage);
		
		btnReview5.setBounds(137, 499, 97, 23);
		detailPage5.add(btnReview5);
		
		JLabel lb1_5 = new JLabel("가게명:");
		lb1_5.setFont(new Font("굴림", Font.PLAIN, 20));
		lb1_5.setBounds(12, 50, 83, 44);
		detailPage5.add(lb1_5);
		
		JLabel lb2_5 = new JLabel("카테고리:");
		lb2_5.setFont(new Font("굴림", Font.PLAIN, 20));
		lb2_5.setBounds(12, 131, 97, 24);
		detailPage5.add(lb2_5);
		
		JLabel lb3_5 = new JLabel("주소:");
		lb3_5.setFont(new Font("굴림", Font.PLAIN, 20));
		lb3_5.setBounds(12, 199, 83, 35);
		detailPage5.add(lb3_5);
		
		JLabel lb4_5 = new JLabel("도로명 주소:");
		lb4_5.setFont(new Font("굴림", Font.PLAIN, 20));
		lb4_5.setBounds(12, 271, 114, 35);
		detailPage5.add(lb4_5);
		
		lblNewLabel_5.setBounds(107, 52, 259, 44);
		detailPage5.add(lblNewLabel_5);
		
		lblNewLabel_5_1.setBounds(107, 122, 259, 44);
		detailPage5.add(lblNewLabel_5_1);
		
		lblNewLabel_5_2.setBounds(107, 199, 259, 35);
		detailPage5.add(lblNewLabel_5_2);
		
		lblNewLabel_5_3.setBounds(131, 271, 235, 35);
		detailPage5.add(lblNewLabel_5_3);
		
		
		
		detailPage5.setVisible(false);
		setSize(400,600);
		
		///////////////////////////////////가구 상세페이지//////////////////////
		JLabel lblNewLabel_6 = new JLabel("");
		JLabel lblNewLabel_6_1 = new JLabel("");
		JLabel lblNewLabel_6_2 = new JLabel("");
		JLabel lblNewLabel_6_3 = new JLabel("");
		JButton btnReview6 = new JButton("리뷰하기");
		JButton gofnpage = new JButton("뒤로 가기");
		JFrame frame6 = new JFrame();
		frame6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame6.getContentPane().setLayout(null);
		JPanel detailPage6 = new JPanel();
		frame6.setContentPane(detailPage6);
		detailPage6.setBounds(0, 0, 384, 561);
		detailPage6.setLayout(null);
		
		gofnpage.setBounds(12, 17, 97, 23);
		detailPage6.add(gofnpage);
		
		btnReview6.setBounds(137, 499, 97, 23);
		detailPage6.add(btnReview6);
		
		JLabel lb1_6 = new JLabel("가게명:");
		lb1_6.setFont(new Font("굴림", Font.PLAIN, 20));
		lb1_6.setBounds(12, 50, 83, 44);
		detailPage6.add(lb1_6);
		
		JLabel lb2_6 = new JLabel("카테고리:");
		lb2_6.setFont(new Font("굴림", Font.PLAIN, 20));
		lb2_6.setBounds(12, 131, 97, 24);
		detailPage6.add(lb2_6);
		
		JLabel lb3_6 = new JLabel("주소:");
		lb3_6.setFont(new Font("굴림", Font.PLAIN, 20));
		lb3_6.setBounds(12, 199, 83, 35);
		detailPage6.add(lb3_6);
		
		JLabel lb4_6 = new JLabel("도로명 주소:");
		lb4_6.setFont(new Font("굴림", Font.PLAIN, 20));
		lb4_6.setBounds(12, 271, 114, 35);
		detailPage6.add(lb4_6);
		
		lblNewLabel_6.setBounds(107, 52, 259, 44);
		detailPage6.add(lblNewLabel_6);
		
		lblNewLabel_6_1.setBounds(107, 122, 259, 44);
		detailPage6.add(lblNewLabel_6_1);
		
		lblNewLabel_6_2.setBounds(107, 199, 259, 35);
		detailPage6.add(lblNewLabel_6_2);
		
		lblNewLabel_6_3.setBounds(131, 271, 235, 35);
		detailPage6.add(lblNewLabel_6_3);
		
		
		
		detailPage6.setVisible(false);
		setSize(400,600);
		
		///////////////////////////////////잡화 상세페이지//////////////////////
		JLabel lblNewLabel_7 = new JLabel("");
		JLabel lblNewLabel_7_1 = new JLabel("");
		JLabel lblNewLabel_7_2 = new JLabel("");
		JLabel lblNewLabel_7_3 = new JLabel("");
		JButton btnReview7 = new JButton("리뷰하기");
		JButton gostfpage = new JButton("뒤로 가기");
		JFrame frame7 = new JFrame();
		frame7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame7.getContentPane().setLayout(null);
		JPanel detailPage7 = new JPanel();
		frame7.setContentPane(detailPage7);
		detailPage7.setBounds(0, 0, 384, 561);
		detailPage7.setLayout(null);
		
		gostfpage.setBounds(12, 17, 97, 23);
		detailPage7.add(gostfpage);
		
		btnReview7.setBounds(137, 499, 97, 23);
		detailPage7.add(btnReview7);
		
		JLabel lb1_7 = new JLabel("가게명:");
		lb1_7.setFont(new Font("굴림", Font.PLAIN, 20));
		lb1_7.setBounds(12, 50, 83, 44);
		detailPage7.add(lb1_7);
		
		JLabel lb2_7 = new JLabel("카테고리:");
		lb2_7.setFont(new Font("굴림", Font.PLAIN, 20));
		lb2_7.setBounds(12, 131, 97, 24);
		detailPage7.add(lb2_7);
		
		JLabel lb3_7 = new JLabel("주소:");
		lb3_7.setFont(new Font("굴림", Font.PLAIN, 20));
		lb3_7.setBounds(12, 199, 83, 35);
		detailPage7.add(lb3_7);
		
		JLabel lb4_7 = new JLabel("도로명 주소:");
		lb4_7.setFont(new Font("굴림", Font.PLAIN, 20));
		lb4_7.setBounds(12, 271, 114, 35);
		detailPage7.add(lb4_7);
		
		lblNewLabel_7.setBounds(107, 52, 259, 44);
		detailPage7.add(lblNewLabel_7);
		
		lblNewLabel_7_1.setBounds(107, 122, 259, 44);
		detailPage7.add(lblNewLabel_7_1);
		
		lblNewLabel_7_2.setBounds(107, 199, 259, 35);
		detailPage7.add(lblNewLabel_7_2);
		
		lblNewLabel_7_3.setBounds(131, 271, 235, 35);
		detailPage7.add(lblNewLabel_7_3);
		
		
		
		detailPage7.setVisible(false);
		setSize(400,600);
		
		///////////////////////////////////기타 상세페이지//////////////////////
		JLabel lblNewLabel_8 = new JLabel("");
		JLabel lblNewLabel_8_1 = new JLabel("");
		JLabel lblNewLabel_8_2 = new JLabel("");
		JLabel lblNewLabel_8_3 = new JLabel("");
		JButton btnReview8 = new JButton("리뷰하기");
		JButton goetcpage = new JButton("뒤로 가기");
		JFrame frame8 = new JFrame();
		frame8.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame8.getContentPane().setLayout(null);
		JPanel detailPage8 = new JPanel();
		frame8.setContentPane(detailPage8);
		detailPage8.setBounds(0, 0, 384, 561);
		detailPage8.setLayout(null);
		
		goetcpage.setBounds(12, 17, 97, 23);
		detailPage8.add(goetcpage);
		
		btnReview8.setBounds(137, 499, 97, 23);
		detailPage8.add(btnReview8);
		
		JLabel lb1_8 = new JLabel("가게명:");
		lb1_8.setFont(new Font("굴림", Font.PLAIN, 20));
		lb1_8.setBounds(12, 50, 83, 44);
		detailPage8.add(lb1_8);
		
		JLabel lb2_8 = new JLabel("카테고리:");
		lb2_8.setFont(new Font("굴림", Font.PLAIN, 20));
		lb2_8.setBounds(12, 131, 97, 24);
		detailPage8.add(lb2_8);
		
		JLabel lb3_8 = new JLabel("주소:");
		lb3_8.setFont(new Font("굴림", Font.PLAIN, 20));
		lb3_8.setBounds(12, 199, 83, 35);
		detailPage8.add(lb3_8);
		
		JLabel lb4_8 = new JLabel("도로명 주소:");
		lb4_8.setFont(new Font("굴림", Font.PLAIN, 20));
		lb4_8.setBounds(12, 271, 114, 35);
		detailPage8.add(lb4_8);
		
		lblNewLabel_8.setBounds(107, 52, 259, 44);
		detailPage8.add(lblNewLabel_8);
		
		lblNewLabel_8_1.setBounds(107, 122, 259, 44);
		detailPage8.add(lblNewLabel_8_1);
		
		lblNewLabel_8_2.setBounds(107, 199, 259, 35);
		detailPage8.add(lblNewLabel_8_2);
		
		lblNewLabel_8_3.setBounds(131, 271, 235, 35);
		detailPage8.add(lblNewLabel_8_3);
		
		
		
		detailPage8.setVisible(false);
		setSize(400,600);
		
	///////////////////////////////////검색 상세페이지//////////////////////
	JLabel lblNewLabel_9 = new JLabel("");
	JLabel lblNewLabel_9_1 = new JLabel("");
	JLabel lblNewLabel_9_2 = new JLabel("");
	JLabel lblNewLabel_9_3 = new JLabel("");
	JButton btnReview9 = new JButton("리뷰하기");
	JButton goscpage = new JButton("뒤로 가기");
	JFrame frame9 = new JFrame();
	frame9.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame9.getContentPane().setLayout(null);
	JPanel detailPage9 = new JPanel();
	frame9.setContentPane(detailPage9);
	detailPage9.setBounds(0, 0, 384, 561);
	detailPage9.setLayout(null);
	
	goscpage.setBounds(12, 17, 97, 23);
	detailPage9.add(goscpage);
	
	btnReview9.setBounds(137, 499, 97, 23);
	detailPage9.add(btnReview9);
	
	JLabel lb1_9 = new JLabel("가게명:");
	lb1_9.setFont(new Font("굴림", Font.PLAIN, 20));
	lb1_9.setBounds(12, 50, 83, 44);
	detailPage9.add(lb1_9);
	
	JLabel lb2_9 = new JLabel("카테고리:");
	lb2_9.setFont(new Font("굴림", Font.PLAIN, 20));
	lb2_9.setBounds(12, 131, 97, 24);
	detailPage9.add(lb2_9);
	
	JLabel lb3_9 = new JLabel("주소:");
	lb3_9.setFont(new Font("굴림", Font.PLAIN, 20));
	lb3_9.setBounds(12, 199, 83, 35);
	detailPage9.add(lb3_9);
	
	JLabel lb4_9 = new JLabel("도로명 주소:");
	lb4_9.setFont(new Font("굴림", Font.PLAIN, 20));
	lb4_9.setBounds(12, 271, 114, 35);
	detailPage9.add(lb4_9);
	
	lblNewLabel_9.setBounds(107, 52, 259, 44);
	detailPage9.add(lblNewLabel_9);
	
	lblNewLabel_9_1.setBounds(107, 122, 259, 44);
	detailPage9.add(lblNewLabel_9_1);
	
	lblNewLabel_9_2.setBounds(107, 199, 259, 35);
	detailPage9.add(lblNewLabel_9_2);
	
	lblNewLabel_9_3.setBounds(131, 271, 235, 35);
	detailPage9.add(lblNewLabel_9_3);
	
	
	detailPage9.setVisible(false);
	setSize(400,600);
	
		//////////////////////////음식 리뷰 작성///////////////////////////////////
		JPanel reviewPage = new JPanel();
		reviewPage.setBounds(0, 0, 384, 561);
		frame.getContentPane().add(reviewPage);
		reviewPage.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBounds(12, 34, 360, 295);
		reviewPage.add(textArea);
		
		JButton btnBack = new JButton("뒤로가기");
		btnBack.setBounds(143, 5, 97, 23);
		reviewPage.add(btnBack);
		
		textField = new JTextField();
		textField.setBounds(53, 397, 319, 23);
		reviewPage.add(textField);
		textField.setColumns(10);
		
		JButton Writebtn = new JButton("작성");
		Writebtn.setBounds(143, 452, 97, 23);
		reviewPage.add(Writebtn);
		
		JLabel titleLabel = new JLabel("제목 :");
		titleLabel.setBounds(12, 354, 64, 15);
		reviewPage.add(titleLabel);
		
		JLabel contentLabel = new JLabel("내용:");
		contentLabel.setBounds(12, 401, 38, 15);
		reviewPage.add(contentLabel);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(53, 351, 319, 23);
		reviewPage.add(textField_1);
		
		reviewPage.setVisible(false);
		
		//////////////////////////여행 리뷰 작성///////////////////////////////////
		JPanel reviewPage2 = new JPanel();
		reviewPage2.setBounds(0, 0, 384, 561);
		frame2.getContentPane().add(reviewPage2);
		reviewPage2.setLayout(null);
		
		textArea2 = new JTextArea();
		textArea2.setBounds(12, 34, 360, 295);
		reviewPage2.add(textArea2);
		
		JButton btnBack2 = new JButton("뒤로가기");
		btnBack2.setBounds(143, 5, 97, 23);
		reviewPage2.add(btnBack2);
		
		textField2 = new JTextField();
		textField2.setBounds(53, 397, 319, 23);
		reviewPage2.add(textField2);
		textField2.setColumns(10);
		
		JButton Writebtn2 = new JButton("작성");
		Writebtn2.setBounds(143, 452, 97, 23);
		reviewPage2.add(Writebtn2);
		
		JLabel titleLabel2 = new JLabel("제목 :");
		titleLabel2.setBounds(12, 354, 64, 15);
		reviewPage2.add(titleLabel2);
		
		JLabel contentLabel2 = new JLabel("내용:");
		contentLabel2.setBounds(12, 401, 38, 15);
		reviewPage2.add(contentLabel2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(53, 351, 319, 23);
		reviewPage2.add(textField_2);
		
		reviewPage2.setVisible(false);
		
		//////////////////////////숙박 리뷰 작성///////////////////////////////////
		JPanel reviewPage3 = new JPanel();
		reviewPage3.setBounds(0, 0, 384, 561);
		frame3.getContentPane().add(reviewPage3);
		reviewPage3.setLayout(null);
		
		textArea3 = new JTextArea();
		textArea3.setBounds(12, 34, 360, 295);
		reviewPage3.add(textArea3);
		
		JButton btnBack3 = new JButton("뒤로가기");
		btnBack3.setBounds(143, 5, 97, 23);
		reviewPage3.add(btnBack3);
		
		textField3 = new JTextField();
		textField3.setBounds(53, 397, 319, 23);
		reviewPage3.add(textField3);
		textField3.setColumns(10);
		
		JButton Writebtn3 = new JButton("작성");
		Writebtn3.setBounds(143, 452, 97, 23);
		reviewPage3.add(Writebtn3);
		
		JLabel titleLabel3 = new JLabel("제목 :");
		titleLabel3.setBounds(12, 354, 64, 15);
		reviewPage3.add(titleLabel3);
		
		JLabel contentLabel3 = new JLabel("내용:");
		contentLabel3.setBounds(12, 401, 38, 15);
		reviewPage3.add(contentLabel3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(53, 351, 319, 23);
		reviewPage3.add(textField_3);
		
		reviewPage3.setVisible(false);
		
		//////////////////////////의료 리뷰 작성///////////////////////////////////
		JPanel reviewPage4 = new JPanel();
		reviewPage4.setBounds(0, 0, 384, 561);
		frame4.getContentPane().add(reviewPage4);
		reviewPage4.setLayout(null);
		
		textArea4 = new JTextArea();
		textArea4.setBounds(12, 34, 360, 295);
		reviewPage4.add(textArea4);
		
		JButton btnBack4 = new JButton("뒤로가기");
		btnBack4.setBounds(143, 5, 97, 23);
		reviewPage4.add(btnBack4);
		
		textField4 = new JTextField();
		textField4.setBounds(53, 397, 319, 23);
		reviewPage4.add(textField4);
		textField4.setColumns(10);
		
		JButton Writebtn4 = new JButton("작성");
		Writebtn4.setBounds(143, 452, 97, 23);
		reviewPage4.add(Writebtn4);
		
		JLabel titleLabel4 = new JLabel("제목 :");
		titleLabel4.setBounds(12, 354, 64, 15);
		reviewPage4.add(titleLabel4);
		
		JLabel contentLabel4 = new JLabel("내용:");
		contentLabel4.setBounds(12, 401, 38, 15);
		reviewPage4.add(contentLabel4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(53, 351, 319, 23);
		reviewPage4.add(textField_4);
		
		reviewPage4.setVisible(false);
		
		//////////////////////////의류 리뷰 작성///////////////////////////////////
		JPanel reviewPage5 = new JPanel();
		reviewPage5.setBounds(0, 0, 384, 561);
		frame5.getContentPane().add(reviewPage5);
		reviewPage5.setLayout(null);
		
		textArea5 = new JTextArea();
		textArea5.setBounds(12, 34, 360, 295);
		reviewPage5.add(textArea5);
		
		JButton btnBack5 = new JButton("뒤로가기");
		btnBack5.setBounds(143, 5, 97, 23);
		reviewPage5.add(btnBack5);
		
		textField5 = new JTextField();
		textField5.setBounds(53, 397, 319, 23);
		reviewPage5.add(textField5);
		textField5.setColumns(10);
		
		JButton Writebtn5 = new JButton("작성");
		Writebtn5.setBounds(143, 452, 97, 23);
		reviewPage5.add(Writebtn5);
		
		JLabel titleLabel5 = new JLabel("제목 :");
		titleLabel5.setBounds(12, 354, 64, 15);
		reviewPage5.add(titleLabel5);
		
		JLabel contentLabel5 = new JLabel("내용:");
		contentLabel5.setBounds(12, 401, 38, 15);
		reviewPage5.add(contentLabel5);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(53, 351, 319, 23);
		reviewPage5.add(textField_5);
		
		reviewPage5.setVisible(false);
		
		//////////////////////////가구 리뷰 작성///////////////////////////////////
		JPanel reviewPage6 = new JPanel();
		reviewPage6.setBounds(0, 0, 384, 561);
		frame6.getContentPane().add(reviewPage6);
		reviewPage6.setLayout(null);
		
		textArea6 = new JTextArea();
		textArea6.setBounds(12, 34, 360, 295);
		reviewPage6.add(textArea6);
		
		JButton btnBack6 = new JButton("뒤로가기");
		btnBack6.setBounds(143, 5, 97, 23);
		reviewPage6.add(btnBack6);
		
		textField6 = new JTextField();
		textField6.setBounds(53, 397, 319, 23);
		reviewPage6.add(textField6);
		textField6.setColumns(10);
		
		JButton Writebtn6 = new JButton("작성");
		Writebtn6.setBounds(143, 452, 97, 23);
		reviewPage6.add(Writebtn6);
		
		JLabel titleLabel6 = new JLabel("제목 :");
		titleLabel6.setBounds(12, 354, 64, 15);
		reviewPage6.add(titleLabel6);
		
		JLabel contentLabel6 = new JLabel("내용:");
		contentLabel6.setBounds(12, 401, 38, 15);
		reviewPage6.add(contentLabel6);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(53, 351, 319, 23);
		reviewPage6.add(textField_6);
		
		reviewPage6.setVisible(false);
		
		//////////////////////////잡화 리뷰 작성///////////////////////////////////
		JPanel reviewPage7 = new JPanel();
		reviewPage7.setBounds(0, 0, 384, 561);
		frame7.getContentPane().add(reviewPage7);
		reviewPage7.setLayout(null);
		
		textArea7 = new JTextArea();
		textArea7.setBounds(12, 34, 360, 295);
		reviewPage7.add(textArea7);
		
		JButton btnBack7 = new JButton("뒤로가기");
		btnBack7.setBounds(143, 5, 97, 23);
		reviewPage7.add(btnBack7);
		
		textField7 = new JTextField();
		textField7.setBounds(53, 397, 319, 23);
		reviewPage7.add(textField7);
		textField7.setColumns(10);
		
		JButton Writebtn7 = new JButton("작성");
		Writebtn7.setBounds(143, 452, 97, 23);
		reviewPage7.add(Writebtn7);
		
		JLabel titleLabel7 = new JLabel("제목 :");
		titleLabel7.setBounds(12, 354, 64, 15);
		reviewPage7.add(titleLabel7);
		
		JLabel contentLabel7 = new JLabel("내용:");
		contentLabel7.setBounds(12, 401, 38, 15);
		reviewPage7.add(contentLabel7);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(53, 351, 319, 23);
		reviewPage7.add(textField_7);
		
		reviewPage7.setVisible(false);
		
		//////////////////////////기타 리뷰 작성///////////////////////////////////
		JPanel reviewPage8 = new JPanel();
		reviewPage8.setBounds(0, 0, 384, 561);
		frame8.getContentPane().add(reviewPage8);
		reviewPage8.setLayout(null);
		
		textArea8 = new JTextArea();
		textArea8.setBounds(12, 34, 360, 295);
		reviewPage8.add(textArea8);
		
		JButton btnBack8 = new JButton("뒤로가기");
		btnBack8.setBounds(143, 5, 97, 23);
		reviewPage8.add(btnBack8);
		
		textField8 = new JTextField();
		textField8.setBounds(53, 397, 319, 23);
		reviewPage8.add(textField8);
		textField8.setColumns(10);
		
		JButton Writebtn8 = new JButton("작성");
		Writebtn8.setBounds(143, 452, 97, 23);
		reviewPage8.add(Writebtn8);
		
		JLabel titleLabel8 = new JLabel("제목 :");
		titleLabel8.setBounds(12, 354, 64, 15);
		reviewPage8.add(titleLabel8);
		
		JLabel contentLabel8 = new JLabel("내용:");
		contentLabel8.setBounds(12, 401, 38, 15);
		reviewPage8.add(contentLabel8);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(53, 351, 319, 23);
		reviewPage8.add(textField_8);
		
		reviewPage8.setVisible(false);
		
	//////////////////////////검색 리뷰 작성///////////////////////////////////
	JPanel reviewPage9 = new JPanel();
	reviewPage9.setBounds(0, 0, 384, 561);
	frame9.getContentPane().add(reviewPage9);
	reviewPage9.setLayout(null);
	
	textArea9 = new JTextArea();
	textArea9.setBounds(12, 34, 360, 295);
	reviewPage9.add(textArea9);
	
	JButton btnBack9 = new JButton("뒤로가기");
	btnBack9.setBounds(143, 5, 97, 23);
	reviewPage9.add(btnBack9);
	
	textField9 = new JTextField();
	textField9.setBounds(53, 397, 319, 23);
	reviewPage9.add(textField9);
	textField9.setColumns(10);
	
	JButton Writebtn9 = new JButton("작성");
	Writebtn9.setBounds(143, 452, 97, 23);
	reviewPage9.add(Writebtn9);
	
	JLabel titleLabel9 = new JLabel("제목 :");
	titleLabel9.setBounds(12, 354, 64, 15);
	reviewPage9.add(titleLabel9);
	
	JLabel contentLabel9 = new JLabel("내용:");
	contentLabel9.setBounds(12, 401, 38, 15);
	reviewPage9.add(contentLabel9);
	
	textField_9 = new JTextField();
	textField_9.setColumns(10);
	textField_9.setBounds(53, 351, 319, 23);
	reviewPage9.add(textField_9);
	reviewPage9.setVisible(false);
	
		//가게 상세 화면//
		fdtable.addMouseListener(new MouseListener() {
		
		@Override
		public void mouseClicked(MouseEvent e) {
		int row = fdtable.getSelectedRow();
		TableModel data = fdtable.getModel();
		System.out.println(row);
		int stNum = Integer.parseInt(String.valueOf(data.getValueAt(row, 0)));
		
		dto.setStoreNum(stNum);
		detailPage.setVisible(false);
		
		}
		
		
		@Override
		public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
		}
		
		
		
		});
		////////////////////////////////////////////여행테이블 클릭 이벤트////////////////////////////////////////////////////
		trvtable.addMouseListener(new MouseListener() {
		
		@Override
		public void mouseClicked(MouseEvent e) {
		int row = trvtable.getSelectedRow();
		TableModel data = trvtable.getModel();
		System.out.println(row);
		int stNum = Integer.parseInt(String.valueOf(data.getValueAt(row, 0)));
		
		dto.setStoreNum(stNum);
		detailPage.setVisible(false);
		
		}
		
		
		@Override
		public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
		}
		
		
		
		});
		////////////////////////////////////////////숙박테이블 클릭 이벤트////////////////////////////////////////////////////
		lgtable.addMouseListener(new MouseListener() {
		
		@Override
		public void mouseClicked(MouseEvent e) {
		int row = lgtable.getSelectedRow();
		TableModel data = lgtable.getModel();
		System.out.println(row);
		int stNum = Integer.parseInt(String.valueOf(data.getValueAt(row, 0)));
		
		dto.setStoreNum(stNum);
		detailPage.setVisible(false);
		
		}
		
		
		@Override
		public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
		}
		
		
		
		});
		////////////////////////////////////////////병원테이블 클릭 이벤트////////////////////////////////////////////////////
		mdtable.addMouseListener(new MouseListener() {
		
		@Override
		public void mouseClicked(MouseEvent e) {
		int row = mdtable.getSelectedRow();
		TableModel data = mdtable.getModel();
		System.out.println(row);
		int stNum = Integer.parseInt(String.valueOf(data.getValueAt(row, 0)));
		
		dto.setStoreNum(stNum);
		detailPage.setVisible(false);
		
		}
		
		
		@Override
		public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
		}
		
		
		
		});
		////////////////////////////////////////////의류테이블 클릭 이벤트////////////////////////////////////////////////////
		cltable.addMouseListener(new MouseListener() {
		
		@Override
		public void mouseClicked(MouseEvent e) {
		int row = cltable.getSelectedRow();
		TableModel data = cltable.getModel();
		System.out.println(row);
		int stNum = Integer.parseInt(String.valueOf(data.getValueAt(row, 0)));
		
		dto.setStoreNum(stNum);
		detailPage.setVisible(false);
		
		}
		
		
		@Override
		public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
		}
		
		
		
		});
		////////////////////////////////////////////가구테이블 클릭 이벤트////////////////////////////////////////////////////
		fttable.addMouseListener(new MouseListener() {
		
		@Override
		public void mouseClicked(MouseEvent e) {
		int row = fttable.getSelectedRow();
		TableModel data = fttable.getModel();
		System.out.println(row);
		int stNum = Integer.parseInt(String.valueOf(data.getValueAt(row, 0)));
		
		dto.setStoreNum(stNum);
		detailPage.setVisible(false);
		
		}
		
		
		@Override
		public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
		}
		
		
		
		});
		////////////////////////////////////////////잡화테이블 클릭 이벤트////////////////////////////////////////////////////
		sftable.addMouseListener(new MouseListener() {
		
		@Override
		public void mouseClicked(MouseEvent e) {
		int row = sftable.getSelectedRow();
		TableModel data = sftable.getModel();
		System.out.println(row);
		int stNum = Integer.parseInt(String.valueOf(data.getValueAt(row, 0)));
		
		dto.setStoreNum(stNum);
		detailPage.setVisible(false);
		
		}
		
		
		@Override
		public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
		}
		
		
		
		});
		////////////////////////////////////////////기타테이블 클릭 이벤트////////////////////////////////////////////////////
		ettable.addMouseListener(new MouseListener() {
		
		@Override
		public void mouseClicked(MouseEvent e) {
		int row = ettable.getSelectedRow();
		TableModel data = ettable.getModel();
		System.out.println(row);
		int stNum = Integer.parseInt(String.valueOf(data.getValueAt(row, 0)));
		
		dto.setStoreNum(stNum);
		detailPage.setVisible(false);
		
		}
		
		
		@Override
		public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
		}
		
		
		
		});
		
		////////////////////////////////////////////검색테이블 클릭 이벤트////////////////////////////////////////////////////
		sctable.addMouseListener(new MouseListener() {
		
		@Override
		public void mouseClicked(MouseEvent e) {
		int row = sctable.getSelectedRow();
		TableModel data = sctable.getModel();
		System.out.println(row);
		int stNum = Integer.parseInt(String.valueOf(data.getValueAt(row, 0)));
		
		dto.setStoreNum(stNum);
		detailPage.setVisible(false);
		
		}
		
		
		@Override
		public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
		}
		
		
		
		});
		
		////////////////////////////////////////////페이지이동 이벤트///////////////////////////////////////////////////////////////////////////////////////////////////////////
		signUp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				startPage.setVisible(false);
				signUpPage.setVisible(true);
			}
		});
		
		signUp1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				signInPage.setVisible(false);
				signUpPage.setVisible(true);
			}
		});
		
		signIn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				startPage.setVisible(false);
				signInPage.setVisible(true);
			}
		});
		
		idCheck.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				boolean check;
				dto.setId(idInput.getText());
				try {
					check = SignUpDAO.check(dto);
					if(check == true) {
						JOptionPane.showMessageDialog(signUpPage, "이미 사용하고 있는 아이디입니다.");
					} else {
						JOptionPane.showMessageDialog(signUpPage, "사용 가능한 아이디입니다.");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dto.setId(idInput.getText());
				dto.setPassword(pwInput.getText());
				dto.setName(nameInput.getText());
				dto.setPhone(phoneInput.getText());
				dto.setAddress(addrInput.getText());
				boolean check = false;
				try {
					check = SignUpDAO.create(dto);
					if(check == true) {
						JOptionPane.showMessageDialog(signUpPage, "회원가입 성공");
					}
					else {
						JOptionPane.showMessageDialog(signUpPage, "회원가입 실패");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				signUpPage.setVisible(false);
				idInput.setText("");
				pwInput.setText("");
				nameInput.setText("");
				phoneInput.setText("");
				addrInput.setText("");
				startPage.setVisible(true);
			}
		});
		
		submit1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dto.setId(idInput1.getText());
				dto.setPassword(pwInput1.getText());				
				int state;
				
				try {
					state = SignUpDAO.logIn(dto);
					
					if(state == 1) {
						JOptionPane.showMessageDialog(signInPage, "존재하지 않는 아이디입니다.");
					}
					else if(state == 2) {
						JOptionPane.showMessageDialog(signInPage, "비밀번호가 일치하지 않습니다.");
					}
					else if(state == 3) {
						signInPage.setVisible(false);
						idInput1.setText("");
						pwInput1.setText("");
						mainPage.setVisible(true);
					}
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		searchbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String[][]newData = null;
				dto.setSearchTxt(searchbar.getText());
				try {
					newData = SignUpDAO.getSearchStore(dto);
				} catch (Exception e) {e.printStackTrace();}
				model.setNumRows(0);
				for(int i=0; i<newData.length; i++) {
					model.addRow(newData[i]);
				}
				mainPage.setVisible(false);
				searchbar.setText("");
				searchPage.setVisible(true);
				setSize(500,600);
			}
		});
		
		schome.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				searchPage.setVisible(false);
				sctext.setText("");
				mainPage.setVisible(true);
				setSize(400,600);
			}
		});
		
		scsetting.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String[][]newData = null;
				dto.setSearchTxt(sctext.getText());
				try {
					newData = SignUpDAO.getSearchStore(dto);
				} catch (Exception e) {e.printStackTrace();}
				model.setNumRows(0);
				for(int i=0; i<newData.length; i++) {
					model.addRow(newData[i]);
				}
			}
		});
		
		scnearbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String[][]newData = null;
				try {
					newData = SignUpDAO.getScNearStore(dto);
				} catch (Exception e) {e.printStackTrace();}
				model.setNumRows(0);
				for(int i=0; i<newData.length; i++) {
					model.addRow(newData[i]);
				}
				sctext.setText("");
			}
		});
		
		travelbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mainPage.setVisible(false);
				searchbar.setText("");
				travelPage.setVisible(true);
				setSize(500,600);
			}
		});
		
		trvhome.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				travelPage.setVisible(false);
				trvtext.setText("");
				mainPage.setVisible(true);
				setSize(400,600);
			}
		});
		
		trvsetting.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String[][]newData = null;
				dto.setSearchTxt(trvtext.getText());
				try {
					newData = SignUpDAO.getTrvSearchStore(dto);
				} catch (Exception e) {e.printStackTrace();}
				trvmodel.setNumRows(0);
				for(int i=0; i<newData.length; i++) {
					trvmodel.addRow(newData[i]);
				}
			}
		});
		
		trvnearbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String[][]newData = null;
				try {
					newData = SignUpDAO.getTrvNearStore(dto);
				} catch (Exception e) {e.printStackTrace();}
				trvmodel.setNumRows(0);
				for(int i=0; i<newData.length; i++) {
					trvmodel.addRow(newData[i]);
				}
				trvtext.setText("");
			}
		});
		
		foodbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mainPage.setVisible(false);
				searchbar.setText("");
				foodPage.setVisible(true);
				setSize(500,600);
			}
		});
		
		fdhome.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				foodPage.setVisible(false);
				fdtext.setText("");
				mainPage.setVisible(true);
				setSize(400,600);
			}
		});
		
		fdsetting.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String[][]newData = null;
				dto.setSearchTxt(fdtext.getText());
				try {
					newData = SignUpDAO.getFdSearchStore(dto);
				} catch (Exception e) {e.printStackTrace();}
				fdmodel.setNumRows(0);
				for(int i=0; i<newData.length; i++) {
					fdmodel.addRow(newData[i]);
				}
			}
		});
		
		fdnearbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String[][]newData = null;
				try {
					newData = SignUpDAO.getFdNearStore(dto);
				} catch (Exception e) {e.printStackTrace();}
				fdmodel.setNumRows(0);
				for(int i=0; i<newData.length; i++) {
					fdmodel.addRow(newData[i]);
				}
				fdtext.setText("");
			}
		});
		
		lodgebtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mainPage.setVisible(false);
				lodgePage.setVisible(true);
				setSize(500,600);
			}
		});
		
		lghome.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				lodgePage.setVisible(false);
				mainPage.setVisible(true);
				setSize(400,600);
			}
		});
		
		lgsetting.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String[][]newData = null;
				dto.setSearchTxt(lgtext.getText());
				try {
					newData = SignUpDAO.getLgSearchStore(dto);
				} catch (Exception e) {e.printStackTrace();}
				lgmodel.setNumRows(0);
				for(int i=0; i<newData.length; i++) {
					lgmodel.addRow(newData[i]);
				}
			}
		});
		
		lgnearbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String[][]newData = null;
				try {
					newData = SignUpDAO.getLgNearStore(dto);
				} catch (Exception e) {e.printStackTrace();}
				lgmodel.setNumRows(0);
				for(int i=0; i<newData.length; i++) {
					lgmodel.addRow(newData[i]);
				}
			}
		});
		
		hospitalbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mainPage.setVisible(false);
				medicalPage.setVisible(true);
				setSize(500,600);
			}
		});
		
		mdhome.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				medicalPage.setVisible(false);
				mainPage.setVisible(true);
				setSize(400,600);
			}
		});
		
		mdsetting.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String[][]newData = null;
				dto.setSearchTxt(mdtext.getText());
				try {
					newData = SignUpDAO.getMdSearchStore(dto);
				} catch (Exception e) {e.printStackTrace();}
				mdmodel.setNumRows(0);
				for(int i=0; i<newData.length; i++) {
					mdmodel.addRow(newData[i]);
				}
			}
		});
		
		mdnearbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String[][]newData = null;
				try {
					newData = SignUpDAO.getMdNearStore(dto);
				} catch (Exception e) {e.printStackTrace();}
				mdmodel.setNumRows(0);
				for(int i=0; i<newData.length; i++) {
					mdmodel.addRow(newData[i]);
				}
			}
		});

		clothbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mainPage.setVisible(false);
				searchbar.setText("");
				clothesPage.setVisible(true);
				setSize(500,600);
			}
		});
		
		clhome.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				clothesPage.setVisible(false);
				cltext.setText("");
				mainPage.setVisible(true);
				setSize(400,600);
			}
		});
		
		clsetting.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String[][]newData = null;
				dto.setSearchTxt(cltext.getText());
				try {
					newData = SignUpDAO.getClSearchStore(dto);
				} catch (Exception e) {e.printStackTrace();}
				clmodel.setNumRows(0);
				for(int i=0; i<newData.length; i++) {
					clmodel.addRow(newData[i]);
				}
			}
		});
		
		clnearbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String[][]newData = null;
				try {
					newData = SignUpDAO.getClNearStore(dto);
				} catch (Exception e) {e.printStackTrace();}
				clmodel.setNumRows(0);
				for(int i=0; i<newData.length; i++) {
					clmodel.addRow(newData[i]);
				}
				cltext.setText("");
			}
		});
		
		furniturebtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mainPage.setVisible(false);
				furniturePage.setVisible(true);
				setSize(500,600);
			}
		});
		
		fthome.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				furniturePage.setVisible(false);
				mainPage.setVisible(true);
				setSize(400,600);
			}
		});
		
		ftsetting.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String[][]newData = null;
				dto.setSearchTxt(fttext.getText());
				try {
					newData = SignUpDAO.getFtSearchStore(dto);
				} catch (Exception e) {e.printStackTrace();}
				ftmodel.setNumRows(0);
				for(int i=0; i<newData.length; i++) {
					ftmodel.addRow(newData[i]);
				}
			}
		});
		
		ftnearbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String[][]newData = null;
				try {
					newData = SignUpDAO.getFtNearStore(dto);
				} catch (Exception e) {e.printStackTrace();}
				ftmodel.setNumRows(0);
				for(int i=0; i<newData.length; i++) {
					ftmodel.addRow(newData[i]);
				}
			}
		});
		
		convbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mainPage.setVisible(false);
				stuffPage.setVisible(true);
				setSize(500,600);
			}
		});
		
		sfhome.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				stuffPage.setVisible(false);
				mainPage.setVisible(true);
				setSize(400,600);
			}
		});
		
		sfsetting.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String[][]newData = null;
				dto.setSearchTxt(sftext.getText());
				try {
					newData = SignUpDAO.getSfSearchStore(dto);
				} catch (Exception e) {e.printStackTrace();}
				sfmodel.setNumRows(0);
				for(int i=0; i<newData.length; i++) {
					sfmodel.addRow(newData[i]);
				}
			}
		});
		
		sfnearbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String[][]newData = null;
				try {
					newData = SignUpDAO.getSfNearStore(dto);
				} catch (Exception e) {e.printStackTrace();}
				sfmodel.setNumRows(0);
				for(int i=0; i<newData.length; i++) {
					sfmodel.addRow(newData[i]);
				}
			}
		});
		etcbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mainPage.setVisible(false);
				etcPage.setVisible(true);
				setSize(500,600);
			}
		});
		
		ethome.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				etcPage.setVisible(false);
				mainPage.setVisible(true);
				setSize(400,600);
			}
		});
		
		etsetting.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String[][]newData = null;
				dto.setSearchTxt(ettext.getText());
				try {
					newData = SignUpDAO.getEtSearchStore(dto);
				} catch (Exception e) {e.printStackTrace();}
				etmodel.setNumRows(0);
				for(int i=0; i<newData.length; i++) {
					etmodel.addRow(newData[i]);
				}
			}
		});
		
		etnearbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String[][]newData = null;
				try {
					newData = SignUpDAO.getEtNearStore(dto);
				} catch (Exception e) {e.printStackTrace();}
				etmodel.setNumRows(0);
				for(int i=0; i<newData.length; i++) {
					etmodel.addRow(newData[i]);
				}
			}
		});
		
///////////리뷰 작성 버튼///////////////////////
		btnReview.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[][] reviewData = null;
				String str = null;
				try {
					reviewData = SignUpDAO.getReview(dto);
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				textArea.setText("\t아이디\t제목\t리뷰내용\n");

				int i=0;
				while(i < reviewData.length) {
					String reviewid = reviewData[i][0];
					String reviewTitle = reviewData[i][1];
					String content = reviewData[i][2];
					str = "\t" + reviewid + "\t" + reviewTitle + "\t" + content + "\n";
					textArea.append(str);
					i = i + 1;
				}

				reviewPage.add(textArea);
				
				reviewPage.setVisible(true);
				detailPage.setVisible(false);
				
			}
			
		});
		
		btnReview2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[][] reviewData = null;
				String str = null;
				try {
					reviewData = SignUpDAO.getReview(dto);
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				textArea2.setText("\t아이디\t제목\t리뷰내용\n");

				int i=0;
				while(i < reviewData.length) {
					String reviewid = reviewData[i][0];
					String reviewTitle = reviewData[i][1];
					String content = reviewData[i][2];
					str = "\t" + reviewid + "\t" + reviewTitle + "\t" + content + "\n";
					textArea2.append(str);
					i = i + 1;
				}

				reviewPage2.add(textArea2);
				
				reviewPage2.setVisible(true);
				detailPage2.setVisible(false);
				
			}
			
		});
		
		btnReview3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[][] reviewData = null;
				String str = null;
				try {
					reviewData = SignUpDAO.getReview(dto);
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				textArea3.setText("\t아이디\t제목\t리뷰내용\n");

				int i=0;
				while(i < reviewData.length) {
					String reviewid = reviewData[i][0];
					String reviewTitle = reviewData[i][1];
					String content = reviewData[i][2];
					str = "\t" + reviewid + "\t" + reviewTitle + "\t" + content + "\n";
					textArea3.append(str);
					i = i + 1;
				}

				reviewPage3.add(textArea3);
				
				reviewPage3.setVisible(true);
				detailPage3.setVisible(false);
				
			}
			
		});
		
		btnReview4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[][] reviewData = null;
				String str = null;
				try {
					reviewData = SignUpDAO.getReview(dto);
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				textArea4.setText("\t아이디\t제목\t리뷰내용\n");

				int i=0;
				while(i < reviewData.length) {
					String reviewid = reviewData[i][0];
					String reviewTitle = reviewData[i][1];
					String content = reviewData[i][2];
					str = "\t" + reviewid + "\t" + reviewTitle + "\t" + content + "\n";
					textArea4.append(str);
					i = i + 1;
				}

				reviewPage4.add(textArea4);
				
				reviewPage4.setVisible(true);
				detailPage4.setVisible(false);
				
			}
			
		});
		
		btnReview5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[][] reviewData = null;
				String str = null;
				try {
					reviewData = SignUpDAO.getReview(dto);
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				textArea5.setText("\t아이디\t제목\t리뷰내용\n");

				int i=0;
				while(i < reviewData.length) {
					String reviewid = reviewData[i][0];
					String reviewTitle = reviewData[i][1];
					String content = reviewData[i][2];
					str = "\t" + reviewid + "\t" + reviewTitle + "\t" + content + "\n";
					textArea5.append(str);
					i = i + 1;
				}

				reviewPage5.add(textArea5);
				
				reviewPage5.setVisible(true);
				detailPage5.setVisible(false);
				
			}
			
		});
		
		btnReview6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[][] reviewData = null;
				String str = null;
				try {
					reviewData = SignUpDAO.getReview(dto);
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				textArea6.setText("\t아이디\t제목\t리뷰내용\n");

				int i=0;
				while(i < reviewData.length) {
					String reviewid = reviewData[i][0];
					String reviewTitle = reviewData[i][1];
					String content = reviewData[i][2];
					str = "\t" + reviewid + "\t" + reviewTitle + "\t" + content + "\n";
					textArea6.append(str);
					i = i + 1;
				}

				reviewPage6.add(textArea6);
				
				reviewPage6.setVisible(true);
				detailPage6.setVisible(false);
				
			}
			
		});
		
		btnReview7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[][] reviewData = null;
				String str = null;
				try {
					reviewData = SignUpDAO.getReview(dto);
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				textArea7.setText("\t아이디\t제목\t리뷰내용\n");

				int i=0;
				while(i < reviewData.length) {
					String reviewid = reviewData[i][0];
					String reviewTitle = reviewData[i][1];
					String content = reviewData[i][2];
					str = "\t" + reviewid + "\t" + reviewTitle + "\t" + content + "\n";
					textArea7.append(str);
					i = i + 1;
				}

				reviewPage7.add(textArea7);
				
				reviewPage7.setVisible(true);
				detailPage7.setVisible(false);
				
			}
			
		});
		
		btnReview8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[][] reviewData = null;
				String str = null;
				try {
					reviewData = SignUpDAO.getReview(dto);
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				textArea8.setText("\t아이디\t제목\t리뷰내용\n");

				int i=0;
				while(i < reviewData.length) {
					String reviewid = reviewData[i][0];
					String reviewTitle = reviewData[i][1];
					String content = reviewData[i][2];
					str = "\t" + reviewid + "\t" + reviewTitle + "\t" + content + "\n";
					textArea8.append(str);
					i = i + 1;
				}

				reviewPage8.add(textArea8);
				
				reviewPage8.setVisible(true);
				detailPage8.setVisible(false);
				
			}
			
		});
		btnReview9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[][] reviewData = null;
				String str = null;
				try {
					reviewData = SignUpDAO.getReview(dto);
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				textArea9.setText("\t아이디\t제목\t리뷰내용\n");

				int i=0;
				while(i < reviewData.length) {
					String reviewid = reviewData[i][0];
					String reviewTitle = reviewData[i][1];
					String content = reviewData[i][2];
					str = "\t" + reviewid + "\t" + reviewTitle + "\t" + content + "\n";
					textArea9.append(str);
					i = i + 1;
				}

				reviewPage9.add(textArea9);
				
				reviewPage9.setVisible(true);
				detailPage9.setVisible(false);
				
			}
			
		});
///////////////////////////리뷰에서 상세 목록으로 전환//////////////////////////////
		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				detailPage.setVisible(true);
				reviewPage.setVisible(false);
				
			}
			
		});
		
		btnBack2.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				detailPage2.setVisible(true);
				reviewPage2.setVisible(false);
			
			}
		
		});
		
		btnBack3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				detailPage3.setVisible(true);
				reviewPage3.setVisible(false);
				
			}
			
		});
		
		btnBack4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				detailPage4.setVisible(true);
				reviewPage4.setVisible(false);
				
			}
			
		});
		
		btnBack5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				detailPage5.setVisible(true);
				reviewPage5.setVisible(false);
				
			}
			
		});
		
		btnBack6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				detailPage6.setVisible(true);
				reviewPage6.setVisible(false);
				
			}
			
		});
		
		btnBack7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				detailPage7.setVisible(true);
				reviewPage7.setVisible(false);
				
			}
			
		});
		
		btnBack8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				detailPage8.setVisible(true);
				reviewPage8.setVisible(false);
				
			}
			
		});
		
		btnBack9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				detailPage9.setVisible(true);
				reviewPage9.setVisible(false);
				
			}
			
		});
		
///////////////////////////상세 목록에서 음식페이지로 전환//////////////////////////////
		gofdpage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				detailPage.setVisible(false);
				foodPage.setVisible(true);
				setSize(500,600);
			}
		});
///////////////////////////상세 목록에서 여행페이지로 전환//////////////////////////////
		gotrvpage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				detailPage2.setVisible(false);
				travelPage.setVisible(true);
				setSize(500,600);
			}
		});
///////////////////////////상세 목록에서 숙박페이지로 전환//////////////////////////////
		goldgpage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				detailPage3.setVisible(false);
				lodgePage.setVisible(true);
				setSize(500,600);
			}
		});
///////////////////////////상세 목록에서 병원페이지로 전환//////////////////////////////
		gomdpage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				detailPage4.setVisible(false);
				medicalPage.setVisible(true);
				setSize(500,600);
			}
		});
///////////////////////////상세 목록에서 의류페이지로 전환//////////////////////////////
		gocltpage.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
					detailPage5.setVisible(false);
					clothesPage.setVisible(true);
					setSize(500,600);
			}
		});
///////////////////////////상세 목록에서 가구페이지로 전환//////////////////////////////
		gofnpage.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				detailPage6.setVisible(false);
				furniturePage.setVisible(true);
				setSize(500,600);
			}
		});		
		
///////////////////////////상세 목록에서 잡화페이지로 전환//////////////////////////////
		gostfpage.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				detailPage7.setVisible(false);
				stuffPage.setVisible(true);
				setSize(500,600);
			}
		});		
///////////////////////////상세 목록에서 기타페이지로 전환//////////////////////////////
		goetcpage.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				detailPage8.setVisible(false);
				etcPage.setVisible(true);
				setSize(500,600);
			}
		});	
		
///////////////////////////상세 목록에서 기타페이지로 전환//////////////////////////////
		goscpage.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
		detailPage9.setVisible(false);
		searchPage.setVisible(true);
		setSize(500,600);
		}
		});	
		
		
		detail.addActionListener(new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent e) {
				String[][] detailData=null;
				try {
					detailData = SignUpDAO.getStoreDetail(dto);
					System.out.println(detailData);
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				name = detailData[0][0];
				category = detailData[0][1];
				address = detailData[0][2];
				r_address = detailData[0][3];
				lblNewLabel_1.setText(name);
				lblNewLabel_1_1.setText(category);
				lblNewLabel_1_2.setText(address);
				lblNewLabel_1_3.setText(r_address);
				detailPage.setVisible(true);
				foodPage.setVisible(false);
				setSize(400, 600);
			}
		});
		
		detail2.addActionListener(new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent e) {
				String[][] detailData=null;
				try {
					detailData = SignUpDAO.getStoreDetail(dto);
					System.out.println(detailData);
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				name = detailData[0][0];
				category = detailData[0][1];
				address = detailData[0][2];
				r_address = detailData[0][3];
				lblNewLabel_2.setText(name);
				lblNewLabel_2_1.setText(category);
				lblNewLabel_2_2.setText(address);
				lblNewLabel_2_3.setText(r_address);
				detailPage2.setVisible(true);
				travelPage.setVisible(false);
				setSize(400, 600);
			}
		});
		
		detail3.addActionListener(new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent e) {
				String[][] detailData=null;
				try {
					detailData = SignUpDAO.getStoreDetail(dto);
					System.out.println(detailData);
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				name = detailData[0][0];
				category = detailData[0][1];
				address = detailData[0][2];
				r_address = detailData[0][3];
				lblNewLabel_3.setText(name);
				lblNewLabel_3_1.setText(category);
				lblNewLabel_3_2.setText(address);
				lblNewLabel_3_3.setText(r_address);
				detailPage3.setVisible(true);
				lodgePage.setVisible(false);
				setSize(400, 600);
			}
		});
		
		detail4.addActionListener(new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent e) {
				String[][] detailData=null;
				try {
					detailData = SignUpDAO.getStoreDetail(dto);
					System.out.println(detailData);
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				name = detailData[0][0];
				category = detailData[0][1];
				address = detailData[0][2];
				r_address = detailData[0][3];
				lblNewLabel_4.setText(name);
				lblNewLabel_4_1.setText(category);
				lblNewLabel_4_2.setText(address);
				lblNewLabel_4_3.setText(r_address);
				detailPage4.setVisible(true);
				medicalPage.setVisible(false);
				setSize(400, 600);
			}
		});
		
		detail5.addActionListener(new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent e) {
				String[][] detailData=null;
				try {
					detailData = SignUpDAO.getStoreDetail(dto);
					System.out.println(detailData);
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				name = detailData[0][0];
				category = detailData[0][1];
				address = detailData[0][2];
				r_address = detailData[0][3];
				lblNewLabel_5.setText(name);
				lblNewLabel_5_1.setText(category);
				lblNewLabel_5_2.setText(address);
				lblNewLabel_5_3.setText(r_address);
				detailPage5.setVisible(true);
				clothesPage.setVisible(false);
				setSize(400, 600);
			}
		});
		
		detail6.addActionListener(new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent e) {
				String[][] detailData=null;
				try {
					detailData = SignUpDAO.getStoreDetail(dto);
					System.out.println(detailData);
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				name = detailData[0][0];
				category = detailData[0][1];
				address = detailData[0][2];
				r_address = detailData[0][3];
				lblNewLabel_6.setText(name);
				lblNewLabel_6_1.setText(category);
				lblNewLabel_6_2.setText(address);
				lblNewLabel_6_3.setText(r_address);
				detailPage6.setVisible(true);
				furniturePage.setVisible(false);
				setSize(400, 600);
			}
		});
		
		detail7.addActionListener(new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent e) {
				String[][] detailData=null;
				try {
					detailData = SignUpDAO.getStoreDetail(dto);
					System.out.println(detailData);
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				name = detailData[0][0];
				category = detailData[0][1];
				address = detailData[0][2];
				r_address = detailData[0][3];
				lblNewLabel_7.setText(name);
				lblNewLabel_7_1.setText(category);
				lblNewLabel_7_2.setText(address);
				lblNewLabel_7_3.setText(r_address);
				detailPage7.setVisible(true);
				stuffPage.setVisible(false);
				setSize(400, 600);
			}
		});
		
		detail8.addActionListener(new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent e) {
				String[][] detailData=null;
				try {
					detailData = SignUpDAO.getStoreDetail(dto);
					System.out.println(detailData);
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				name = detailData[0][0];
				category = detailData[0][1];
				address = detailData[0][2];
				r_address = detailData[0][3];
				lblNewLabel_8.setText(name);
				lblNewLabel_8_1.setText(category);
				lblNewLabel_8_2.setText(address);
				lblNewLabel_8_3.setText(r_address);
				detailPage8.setVisible(true);
				etcPage.setVisible(false);
				setSize(400, 600);
			}
		});
		detail9.addActionListener(new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent e) {
				String[][] detailData=null;
				try {
					detailData = SignUpDAO.getStoreDetail(dto);
					System.out.println(detailData);
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				name = detailData[0][0];
				category = detailData[0][1];
				address = detailData[0][2];
				r_address = detailData[0][3];
				lblNewLabel_9.setText(name);
				lblNewLabel_9_1.setText(category);
				lblNewLabel_9_2.setText(address);
				lblNewLabel_9_3.setText(r_address);
				detailPage9.setVisible(true);
				searchPage.setVisible(false);
				setSize(400, 600);
			}
		});
		////////////////////////////////////리뷰 저장//////////////////////////////////
		Writebtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dto.setTitle(textField_1.getText());
				dto.setContent(textField.getText());
				String str = null;
				boolean check = false;
				try {
					check = SignUpDAO.SaveReview(dto);
					if(check == true) {
						JOptionPane.showMessageDialog(signUpPage, "작성 성공");
						String id = dto.getId();
						String title = dto.getTitle();
						String content = dto.getContent();
						str = "\t" + id + "\t" + title + "\t" + content + "\n";
						textArea.append(str);
						textField.setText("");
						textField_1.setText("");
					}
					else {
						JOptionPane.showMessageDialog(signUpPage, "작성 실패");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		Writebtn2.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dto.setTitle(textField_2.getText());
				dto.setContent(textField2.getText());
				String str = null;
				boolean check = false;
				try {
					check = SignUpDAO.SaveReview(dto);
					if(check == true) {
						JOptionPane.showMessageDialog(signUpPage, "작성 성공");
						String id = dto.getId();
						String title = dto.getTitle();
						String content = dto.getContent();
						str = "\t" + id + "\t" + title + "\t" + content + "\n";
						textArea2.append(str);
						textField2.setText("");
						textField_2.setText("");
					}
					else {
						JOptionPane.showMessageDialog(signUpPage, "작성 실패");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		Writebtn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dto.setTitle(textField_3.getText());
				dto.setContent(textField3.getText());
				String str = null;
				boolean check = false;
				try {
					check = SignUpDAO.SaveReview(dto);
					if(check == true) {
						JOptionPane.showMessageDialog(signUpPage, "작성 성공");
						String id = dto.getId();
						String title = dto.getTitle();
						String content = dto.getContent();
						str = "\t" + id + "\t" + title + "\t" + content + "\n";
						textArea3.append(str);
						textField3.setText("");
						textField_3.setText("");
					}
					else {
						JOptionPane.showMessageDialog(signUpPage, "작성 실패");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		Writebtn4.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dto.setTitle(textField_4.getText());
				dto.setContent(textField4.getText());
				String str = null;
				boolean check = false;
				try {
					check = SignUpDAO.SaveReview(dto);
					if(check == true) {
						JOptionPane.showMessageDialog(signUpPage, "작성 성공");
						String id = dto.getId();
						String title = dto.getTitle();
						String content = dto.getContent();
						str = "\t" + id + "\t" + title + "\t" + content + "\n";
						textArea4.append(str);
						textField4.setText("");
						textField_4.setText("");
					}
					else {
						JOptionPane.showMessageDialog(signUpPage, "작성 실패");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		Writebtn5.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dto.setTitle(textField_5.getText());
				dto.setContent(textField5.getText());
				String str = null;
				boolean check = false;
				try {
					check = SignUpDAO.SaveReview(dto);
					if(check == true) {
						JOptionPane.showMessageDialog(signUpPage, "작성 성공");
						String id = dto.getId();
						String title = dto.getTitle();
						String content = dto.getContent();
						str = "\t" + id + "\t" + title + "\t" + content + "\n";
						textArea5.append(str);
						textField5.setText("");
						textField_5.setText("");
					}
					else {
						JOptionPane.showMessageDialog(signUpPage, "작성 실패");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		Writebtn6.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dto.setTitle(textField_6.getText());
				dto.setContent(textField6.getText());
				String str = null;
				boolean check = false;
				try {
					check = SignUpDAO.SaveReview(dto);
					if(check == true) {
						JOptionPane.showMessageDialog(signUpPage, "작성 성공");
						String id = dto.getId();
						String title = dto.getTitle();
						String content = dto.getContent();
						str = "\t" + id + "\t" + title + "\t" + content + "\n";
						textArea6.append(str);
						textField6.setText("");
						textField_6.setText("");
					}
					else {
						JOptionPane.showMessageDialog(signUpPage, "작성 실패");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		Writebtn7.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dto.setTitle(textField_7.getText());
				dto.setContent(textField7.getText());
				String str = null;
				boolean check = false;
				try {
					check = SignUpDAO.SaveReview(dto);
					if(check == true) {
						JOptionPane.showMessageDialog(signUpPage, "작성 성공");
						String id = dto.getId();
						String title = dto.getTitle();
						String content = dto.getContent();
						str = "\t" + id + "\t" + title + "\t" + content + "\n";
						textArea7.append(str);
						textField7.setText("");
						textField_7.setText("");
					}
					else {
						JOptionPane.showMessageDialog(signUpPage, "작성 실패");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		Writebtn8.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dto.setTitle(textField_8.getText());
				dto.setContent(textField8.getText());
				String str = null;
				boolean check = false;
				try {
					check = SignUpDAO.SaveReview(dto);
					if(check == true) {
						JOptionPane.showMessageDialog(signUpPage, "작성 성공");
						String id = dto.getId();
						String title = dto.getTitle();
						String content = dto.getContent();
						str = "\t" + id + "\t" + title + "\t" + content + "\n";
						textArea8.append(str);
						textField8.setText("");
						textField_8.setText("");
					}
					else {
						JOptionPane.showMessageDialog(signUpPage, "작성 실패");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		Writebtn9.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dto.setTitle(textField_9.getText());
				dto.setContent(textField9.getText());
				String str = null;
				boolean check = false;
				try {
					check = SignUpDAO.SaveReview(dto);
					if(check == true) {
						JOptionPane.showMessageDialog(signUpPage, "작성 성공");
						String id = dto.getId();
						String title = dto.getTitle();
						String content = dto.getContent();
						str = "\t" + id + "\t" + title + "\t" + content + "\n";
						textArea9.append(str);
						textField9.setText("");
						textField_9.setText("");
					}
					else {
						JOptionPane.showMessageDialog(signUpPage, "작성 실패");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		
		
		////////////////////////////////////회원 탈퇴///////////////////////////////	
		
		jbtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				boolean check;
				dto.getId();
				try {
					check = SignUpDAO.delMember(dto);
					if(check == false) {
						JOptionPane.showMessageDialog(startPage, "회원 정보를 삭제하는데 실패했습니다.");
					} else {
						JOptionPane.showMessageDialog(startPage, "회원 정보를 정상적으로 삭제했습니다.");
						mainPage.setVisible(false);
						startPage.setVisible(true);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		    
		});
		
		
		add(startPage);
		add(signUpPage);
		add(signInPage);
		add(mainPage);
		add(searchPage);
		add(travelPage);
		add(foodPage);
		add(lodgePage);
		add(medicalPage);
		add(clothesPage);
		add(furniturePage);
		add(stuffPage);
		add(etcPage);
		add(detailPage);
		add(detailPage2);
		add(detailPage3);
		add(detailPage4);
		add(detailPage5);
		add(detailPage6);
		add(detailPage7);
		add(detailPage8);
		add(detailPage9);
		add(reviewPage);
		add(reviewPage2);
		add(reviewPage3);
		add(reviewPage4);
		add(reviewPage5);
		add(reviewPage6);
		add(reviewPage7);
		add(reviewPage8);
		add(reviewPage9);
		setVisible(true);
		setSize(400,600);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	

	public static void main(String[] args) {
		new DBProject();

	}

}
