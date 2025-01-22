package com.kh.busan.api.model.service;

import java.util.List;

import com.kh.busan.api.model.vo.CommentDTO;

public interface BusanService {
	
	String getBusan(int page);
	
	//공공데이터
	String getBusanDetail(int pk);
	
	// 상세보기 시 댓글을 조회해서 반환해주는 메소드
	List<CommentDTO> getComments(Long foodNo);
	
	// 상세보기 시 댓글을 작성할 수 있는 메소드
	void save(CommentDTO comment);

}
