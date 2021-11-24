import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

public class DBProject extends JFrame {
	
	SignUpDTO dto = new SignUpDTO();

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
		container.setBounds(20,50,350,400);
		
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
		
		submit.setBounds(150,400,100,30);
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
		
		// 컨테이너에 메인박스 추가
		mainPage.add(mainBox);
		mainPage.setSize(400,600);
		mainPage.setVisible(false);
		
		
		//음식 페이지/////////////////////////////////////////////////////////////////////
		JPanel foodPage = new JPanel();
		
		JPanel fdjp = new JPanel();
		JPanel fdjp2 = new JPanel();
		
		JTextField fdtext;
		JComboBox fdjcm;
		String[]fdtitle= {"가나다 순","거리 순","리뷰 별점 순"};
		String fdurl;
		
		fdjp.setBackground(Color.gray);
		
		//아이콘 - 설정 
		ImageIcon settingIcon = new ImageIcon("C:\\Users\\soonE\\eclipse-workspace\\DBproject\\src\\images/setting.png");
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
		
		
		
		String[][] fddata=null;
		try {
			fddata = SignUpDAO.getFdStore();
		} catch (Exception e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		String[] fdheader = new String[] {"가게 번호","상호명","카테고리","도로명주소","주소"};
		JTable fdtable = new JTable(fddata,fdheader);
		fdtable.setAlignmentX(0);
		fdtable.setSize(350,550);
		fdjp2.add(new JScrollPane(fdtable));
		
		fdtext = new JTextField(10);
		fdjcm= new JComboBox(fdtitle);
		fdjp.add(fdhome);
		fdjp.add(fdtext);
		fdjp.add(fdjcm);
		fdjp.add(fdsetting);
		
		
		foodPage.add(fdjp,BorderLayout.NORTH);
		foodPage.add(fdjp2,BorderLayout.CENTER);

		
		foodPage.setSize(500,600);
		foodPage.setVisible(false);
		

		//여행 페이지/////////////////////////////////////////////////////////////////////
		JPanel trvjp = new JPanel();
		JPanel trvjp2 = new JPanel();
		JTextField trvtext;
		JComboBox trvjcm;
		String[]trvtitle= {"가나다 순","거리 순","리뷰 별점 순"};
		String trvurl;
		
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
		
		
		
		String[][] trvdata = null;
		try {
			trvdata = SignUpDAO.getTrvStore();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		String[] trvheader = new String[] {"가게 번호","상호명","카테고리","도로명주소","주소"};
		JTable trvtable = new JTable(trvdata,trvheader);
		trvtable.setAlignmentX(0);
		trvtable.setSize(350,550);
		trvjp2.add(new JScrollPane(trvtable));
		
		trvtext = new JTextField(10);
		trvjcm= new JComboBox(trvtitle);
		trvjp.add(trvhome);
		trvjp.add(trvtext);
		trvjp.add(trvjcm);
		trvjp.add(trvsetting);
		
		
		travelPage.add(trvjp,BorderLayout.NORTH);
		travelPage.add(trvjp2,BorderLayout.CENTER);

		
		travelPage.setSize(500,600);
		travelPage.setVisible(false);
		
		//숙박 페이지/////////////////////////////////////////////////////////////////////
		JPanel lodgePage = new JPanel();
		
		JPanel lgjp = new JPanel();
		JPanel lgjp2 = new JPanel();
		JTextField lgtext;
		JComboBox lgjcm;
		String[]lgtitle= {"가나다 순","거리 순","리뷰 별점 순"};
		String lgurl;
		
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
		
		
		
		String[][] lgdata=null;
		try {
			lgdata = SignUpDAO.getLgStore();
		} catch (Exception e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		String[] lgheader = new String[] {"가게 번호","상호명","카테고리","도로명주소","주소"};
		JTable lgtable = new JTable(lgdata,lgheader);
		lgtable.setAlignmentX(0);
		lgtable.setSize(350,550);
		lgjp2.add(new JScrollPane(lgtable));
		
		lgtext = new JTextField(10);
		lgjcm= new JComboBox(lgtitle);
		lgjp.add(lghome);
		lgjp.add(lgtext);
		lgjp.add(lgjcm);
		lgjp.add(lgsetting);
		
		
		lodgePage.add(lgjp,BorderLayout.NORTH);
		lodgePage.add(lgjp2,BorderLayout.CENTER);

		lodgePage.setSize(500,600);
		lodgePage.setVisible(false);
		

		
		//병원 페이지/////////////////////////////////////////////////////////////////////
		JPanel medicalPage = new JPanel();
		JPanel mdjp = new JPanel();
		JPanel mdjp2 = new JPanel();
		JTextField mdtext;
		JComboBox mdjcm;
		String[]mdtitle= {"가나다 순","거리 순","리뷰 별점 순"};
		String mdurl;
		
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
		
		
		
		String[][] mddata=null;
		try {
			mddata = SignUpDAO.getMdStore();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		String[] mdheader = new String[] {"가게 번호","상호명","카테고리","도로명주소","주소"};
		JTable mdtable = new JTable(mddata,mdheader);
		mdtable.setAlignmentX(0);
		mdtable.setSize(350,550);
		mdjp2.add(new JScrollPane(mdtable));
		
		mdtext = new JTextField(10);
		mdjcm= new JComboBox(mdtitle);
		mdjp.add(mdhome);
		mdjp.add(mdtext);
		mdjp.add(mdjcm);
		mdjp.add(mdsetting);
		
		
		medicalPage.add(mdjp,BorderLayout.NORTH);
		medicalPage.add(mdjp2,BorderLayout.CENTER);

		
		medicalPage.setSize(500,600);
		medicalPage.setVisible(false);

		
		//의류 페이지/////////////////////////////////////////////////////////////////////
		JPanel clothesPage = new JPanel();
		
		JPanel cljp = new JPanel();
		JPanel cljp2 = new JPanel();

		JTextField cltext;
		JComboBox cljcm;
		String[]cltitle= {"가나다 순","거리 순","리뷰 별점 순"};
		String clurl;
		
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
		
		
		
		String[][] cldata=null;
		try {
			cldata = SignUpDAO.getClStore();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		String[] clheader = new String[] {"가게 번호","상호명","카테고리","도로명주소","주소"};
		JTable cltable = new JTable(cldata,clheader);
		cltable.setAlignmentX(0);
		cltable.setSize(350,550);
		cljp2.add(new JScrollPane(cltable));
		
		cltext = new JTextField(10);
		cljcm= new JComboBox(cltitle);
		cljp.add(clhome);
		cljp.add(cltext);
		cljp.add(cljcm);
		cljp.add(clsetting);
		
		
		clothesPage.add(cljp,BorderLayout.NORTH);
		clothesPage.add(cljp2,BorderLayout.CENTER);

		
		clothesPage.setSize(500,600);
		clothesPage.setVisible(false);
		
		//가구 페이지/////////////////////////////////////////////////////////////////////
		JPanel furniturePage = new JPanel();
		
		JPanel ftjp = new JPanel();
		JPanel ftjp2 = new JPanel();

		JTextField fttext;
		JComboBox ftjcm;
		String[]fttitle= {"가나다 순","거리 순","리뷰 별점 순"};
		String fturl;
		
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
		
		
		
		String[][] ftdata=null;
		try {
			ftdata = SignUpDAO.getFtStore();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		String[] ftheader = new String[] {"가게 번호","상호명","카테고리","도로명주소","주소"};
		JTable fttable = new JTable(ftdata,ftheader);
		fttable.setAlignmentX(0);
		fttable.setSize(350,550);
		ftjp2.add(new JScrollPane(fttable));
		
		fttext = new JTextField(10);
		ftjcm= new JComboBox(fttitle);
		ftjp.add(fthome);
		ftjp.add(fttext);
		ftjp.add(ftjcm);
		ftjp.add(ftsetting);
		
		
		furniturePage.add(ftjp,BorderLayout.NORTH);
		furniturePage.add(ftjp2,BorderLayout.CENTER);

		
		furniturePage.setSize(500,600);
		furniturePage.setVisible(false);
		
		//잡화 페이지/////////////////////////////////////////////////////////////////////
		JPanel stuffPage = new JPanel();
		JPanel sfjp = new JPanel();
		JPanel sfjp2 = new JPanel();
		JTextField sftext;
		JComboBox sfjcm;
		String[]sftitle= {"가나다 순","거리 순","리뷰 별점 순"};
		String sfurl;
		
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
		
		
		
		String[][] sfdata=null;
		try {
			sfdata = SignUpDAO.getSfStore();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		String[] sfheader = new String[] {"가게 번호","상호명","카테고리","도로명주소","주소"};
		JTable sftable = new JTable(sfdata,sfheader);
		sftable.setAlignmentX(0);
		sftable.setSize(350,550);
		sfjp2.add(new JScrollPane(sftable));
		
		sftext = new JTextField(10);
		sfjcm= new JComboBox(sftitle);
		sfjp.add(sfhome);
		sfjp.add(sftext);
		sfjp.add(sfjcm);
		sfjp.add(sfsetting);
		
		
		stuffPage.add(sfjp,BorderLayout.NORTH);
		stuffPage.add(sfjp2,BorderLayout.CENTER);

		
		stuffPage.setSize(500,600);
		stuffPage.setVisible(false);
		
		//기타 페이지/////////////////////////////////////////////////////////////////////
		JPanel etcPage = new JPanel();
		JPanel etjp = new JPanel();
		JPanel etjp2 = new JPanel();
		JTextField ettext;
		JComboBox etjcm;
		String[]ettitle= {"가나다 순","거리 순","리뷰 별점 순"};
		String eturl;
		
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
		
		
		
		String[][] etdata=null;
		try {
			etdata = SignUpDAO.getEtStore();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		String[] etheader = new String[] {"가게 번호","상호명","카테고리","도로명주소","주소"};
		JTable ettable = new JTable(etdata,etheader);
		ettable.setAlignmentX(0);
		ettable.setSize(350,550);
		etjp2.add(new JScrollPane(ettable));
		
		ettext = new JTextField(10);
		etjcm= new JComboBox(ettitle);
		etjp.add(ethome);
		etjp.add(ettext);
		etjp.add(etjcm);
		etjp.add(etsetting);
		
		
		etcPage.add(etjp,BorderLayout.NORTH);
		etcPage.add(etjp2,BorderLayout.CENTER);

		
		etcPage.setSize(500,600);
		etcPage.setVisible(false);
		
		//검색 페이지/////////////////////////////////////////////////////////////////////
		SignUpDTO dto = new SignUpDTO();
		JPanel searchPage = new JPanel();
		
		JPanel scjp = new JPanel();
		JPanel scjp2 = new JPanel();
		JTextField sctext;
		JComboBox scjcm;
		String[]sctitle= {"가나다 순","거리 순","리뷰 별점 순"};
		String scurl;
		
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
		scjcm= new JComboBox(sctitle);
		scjp.add(schome);
		scjp.add(sctext);
		scjp.add(scjcm);
		scjp.add(scsetting);
		
		
		searchPage.add(scjp,BorderLayout.NORTH);
		searchPage.add(scjp2,BorderLayout.CENTER);

		
		searchPage.setSize(500,600);
		searchPage.setVisible(false);
		
		
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
				searchPage.setVisible(true);
				setSize(500,600);
			}
		});
		
		schome.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				searchPage.setVisible(false);
				mainPage.setVisible(true);
				setSize(400,600);
			}
		});
		
		travelbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mainPage.setVisible(false);
				travelPage.setVisible(true);
				setSize(500,600);
			}
		});
		
		trvhome.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				travelPage.setVisible(false);
				mainPage.setVisible(true);
				setSize(400,600);
			}
		});
		
		foodbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mainPage.setVisible(false);
				foodPage.setVisible(true);
				setSize(500,600);
			}
		});
		
		fdhome.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				foodPage.setVisible(false);
				mainPage.setVisible(true);
				setSize(400,600);
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

		clothbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mainPage.setVisible(false);
				clothesPage.setVisible(true);
				setSize(500,600);
			}
		});
		
		clhome.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				clothesPage.setVisible(false);
				mainPage.setVisible(true);
				setSize(400,600);
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
