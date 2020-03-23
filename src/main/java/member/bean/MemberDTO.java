package member.bean;

import lombok.Data;

@Data
public class MemberDTO {
	private String email;
	private String name;
	private String nickName;
	private String pwd;
	private String phone;
	private String zipcode;
	private String addr;
	private String addr_detail;
	private int seq;
	private String regist_Date;
	private String drop_Date;
	private String drop_Yn;
	private String role;	
}
