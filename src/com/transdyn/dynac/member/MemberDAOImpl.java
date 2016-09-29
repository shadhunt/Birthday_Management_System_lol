package com.transdyn.dynac.member;

public class MemberDAOImpl implements MemberDAO {
	private MemberService memberService = new MemberService();
	private Member member = new Member();
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	@Override
	public void saveMember() {
		memberService.add(member);
	}

}
