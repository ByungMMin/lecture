package com.kh.busan.api.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kh.busan.api.model.mapper.CommentMapper;
import com.kh.busan.api.model.vo.CommentDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BusanServiceImpl implements BusanService {

	private final CommentMapper mapper;

	@Override
	public String getBusanDetail(int pk) {
		return null;
	}

	@Override
	public String getBusan(int page) {
		
		return null;
	}
	
	@Override
	public void save(CommentDTO comment) {
		if(comment.getWriter().equals("") || comment.getConstent().equals("")) {
			System.out.println("예외 발생!");
		}
		mapper.save(comment);	
	}

	@Override
	public List<CommentDTO> getComments(Long foodNo) {
		return mapper.getComment(foodNo);
	}

}
