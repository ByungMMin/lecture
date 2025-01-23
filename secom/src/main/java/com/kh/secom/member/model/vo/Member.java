package com.kh.secom.member.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
@Builder
public class Member {
	private Long userNo;
	private String userId;
	private String userPwd;
	private String role;
}
