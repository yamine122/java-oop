package com.bitcamp.controllers;

import com.bitcamp.services.MemberService;

import com.bitcamp.domains.MemberBean;
import javax.swing.JOptionPane;
public class MemberController {

	public static void main(String[] args) {
		MemberService service = new MemberService();
		MemberBean member = null;
		String[] arr = null;
		String temp = "";

		while (true) {
			switch (JOptionPane.showInputDialog("0.종료 \n" 
												+ "1.회원가입\n" 
												+ "2.마이페이지\n" 
												+ "3.비밀번호 변경\n" 
												+ "4.회원탈퇴\n"
												+ "5.아이디체크\n"
												+ "6.로그인")) {
			case "0":
				JOptionPane.showMessageDialog(null, "종료");
				return;
			case "1":
				temp = JOptionPane.showInputDialog("이름,아이디,비밀번호,주민번호,혈액형,키,몸무게");
				arr = temp.split(",");
				System.out.println("****"+temp);
				member = new MemberBean();
				member.setName(arr[0]);
				member.setId(arr[1]);
				member.setPw(arr[2]);
				member.setSsn(arr[3]);
				member.setBlood(arr[4]);
				member.setHeight(Double.parseDouble(arr[5]));
				member.setWeight(Double.parseDouble(arr[6]));

				JOptionPane.showMessageDialog(null, service.join(member));
				break;
			case "2":
				JOptionPane.showMessageDialog(null, service.getMyPage(member));

				break;
			case "3":
				temp = JOptionPane.showInputDialog("아이디 , 현재비번 , 변경비번");
				arr = temp.split(",");
				member = new MemberBean();
				member.setId(arr[0]);
				member.setPw(arr[1]+","+arr[2]);
				String msg;
				msg = service.changePw(member);
				break;
			case "4":

				break;
			case "5":
				JOptionPane.showMessageDialog(null, service.list());
				break;
			case "6":
				String loginValue = JOptionPane.showInputDialog("로그인 id, pw");
				arr = loginValue.split(",");
				String loginId = arr[0];
				String loginPw = arr[1];
				member = new MemberBean();
				member.setId(loginId);
				member.setPw(loginPw);
				msg = service.login(member);
				JOptionPane.showMessageDialog(null, msg);
				
				break;
			case "7" :
				String searchId = JOptionPane.showInputDialog("검색아이디");
				member = service.findById(searchId);
				JOptionPane.showMessageDialog(null, member.toString());
				break;
				

			default:
				break;
			}
		}

	}

}
