package TitleTest;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import Resource.R;
import Server.Client;

import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import DTO.Protocol;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class FrameMakeRoom extends R {

	private JTextField textField_RoomName;
	PrintWriter pw;
	BufferedReader br;

	public FrameMakeRoom() {
		initialize();
//		this.setUndecorated(true);
	}

	/**
	 * Create the application.
	 */

	public void start() {
		this.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		pw = Client.pw;
		br = Client.br;
		this.setBounds(100, 100, 400, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel_MakeRoom = new JPanel();
		panel_MakeRoom.setBackground(new Color(135, 206, 250));
		this.getContentPane().add(panel_MakeRoom, BorderLayout.CENTER);
		panel_MakeRoom.setLayout(null);

		JLabel lbl_RoomName = new JLabel("방 제목 : ");
		lbl_RoomName.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lbl_RoomName.setBounds(34, 256, 77, 21);
		panel_MakeRoom.add(lbl_RoomName);

		textField_RoomName = new JTextField();
		textField_RoomName.setBounds(101, 259, 116, 21);
		panel_MakeRoom.add(textField_RoomName);
		textField_RoomName.setColumns(10);

		JLabel lbl_RoomName_1_1 = new JLabel("방 주제 : ");
		lbl_RoomName_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lbl_RoomName_1_1.setBounds(34, 287, 77, 21);
		panel_MakeRoom.add(lbl_RoomName_1_1);
		//
		JComboBox comboBox_RoomTopic = new JComboBox<String>();
		comboBox_RoomTopic.setBounds(101, 290, 116, 23);
		panel_MakeRoom.add(comboBox_RoomTopic);

		JLabel lbl_RoomName_1_1_1 = new JLabel("허용인원 : ");
		lbl_RoomName_1_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lbl_RoomName_1_1_1.setBounds(23, 318, 77, 21);
		panel_MakeRoom.add(lbl_RoomName_1_1_1);

		JSpinner spinner_userMax = new JSpinner();
		spinner_userMax.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		spinner_userMax.setBounds(101, 321, 45, 22);
		panel_MakeRoom.add(spinner_userMax);

		JButton btn_RoomMaker = new JButton("방생성");
		btn_RoomMaker.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btn_RoomMaker.setBounds(245, 258, 97, 40);
		panel_MakeRoom.add(btn_RoomMaker);

		JButton btn_Cancle = new JButton("취소");
		btn_Cancle.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btn_Cancle.setBounds(283, 460, 77, 29);
		panel_MakeRoom.add(btn_Cancle);

		JLabel lblNewLabel = new JLabel(image);
		lblNewLabel.setBounds(34, 10, 308, 160);
		panel_MakeRoom.add(lblNewLabel);

		// ==> 룸 취소 기능 구현 <==
		btn_Cancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameCenter.start();
				frameDown();
			}
		});
		// ==> 방 만들기 기능 구현 <==
		btn_RoomMaker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String title = textField_RoomName.getText();
				int sipnerCount = (int) spinner_userMax.getValue();
				String userCount = String.valueOf(sipnerCount);
				String subject = (String) comboBox_RoomTopic.getSelectedItem();
				if (title.length() == 0) {
					JOptionPane.showMessageDialog(btn_Confirm, "제목을 입력해주세요");
				} else {

					String line = "";
					line = title + "%" + userCount + "%" + subject;
					pw.println(Protocol.ROOMMAKE + "|" + line);
					pw.flush();

					frameChattingRoom.start();
					frameDown();

					textField_RoomName.setText("");
					spinner_userMax.setValue(4);
					comboBox_RoomTopic.setSelectedItem(0);
				}
			}
		});
	}

	private void frameDown() {
		this.setVisible(false);
	}
}
