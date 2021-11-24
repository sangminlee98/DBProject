import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;

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
		
		
		

		add(startPage);
		add(signUpPage);
		add(signInPage);
		add(mainPage);
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
