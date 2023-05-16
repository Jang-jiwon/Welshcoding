package com.example.welshcoding.edit;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.welshcoding.board.BoardService;
import com.example.welshcoding.domain.Board;
import com.example.welshcoding.domain.Comments;
import com.example.welshcoding.domain.Member;
import com.example.welshcoding.domain.Series;
import com.example.welshcoding.domain.Sns;
import com.example.welshcoding.domain.Temporary;
import com.example.welshcoding.testjiwon.TestSService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor
public class SaveController {
	
	private final BoardService boardService ;
	private final TestMemberService testMemberService;
	private final TestSService testSService;
	
	@RequestMapping("save")
	public String home() {
		log.info("save Controller");
		return "edit/save";	// home.html 로 찾아간다.
	}
	
	@RequestMapping("controller")
	public String goController() {
		log.info("controller Controller");
		return "edit/controller";	// home.html 로 찾아간다.
	}
	
	@PostMapping("/save-data")
	public String saveData(@RequestParam("gridData") String gridData  ,@RequestParam("gridtitle") String gridtitle) throws IllegalAccessException {
	    /* ... */log.info("save-data Controller");
		System.out.println("===================================\n"+gridData +", "+gridtitle); // 잘넘어옴
		Member member = new Member();
		member.setUserEmail("test");
		
		testMemberService.join(member);
		
		Series series = new Series();
		series.setSeriesName("testsd");
		testSService.save(series);
		
		Board board = new Board();
		board.setBoardTitle(gridtitle);
		board.setBoardCont(gridData);
		board.setBoardDate("2023.05.01");
		board.setBoardLike("3");
		board.setBoardTag("java");
		board.setSeries(new Series());
		board.setThumbnailPath("test");
		
		System.out.println("===========saveData==============");
		boardService.insertData(board);
		System.out.println("=========================저장완료=============================");
	    return "redirect:/mainBoard";
	}
}
