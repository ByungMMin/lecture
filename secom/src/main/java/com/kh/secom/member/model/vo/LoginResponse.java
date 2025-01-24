package com.kh.secom.member.model.vo;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@Builder
@ToString
@NoArgsConstructor
@Data
public class LoginResponse {
	private String username;
	private Map<String, String> tokens;

}
