package com.example;

import com.example.domain.Board;
import com.example.persistence.BoardRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTest {
    @Autowired
    private BoardRepository boardRepo;

    /*
     등록기능 테스트
    @Test
    public void testInsertBoard(){
        Board board = new Board();
        board.setTitle("첫번째 게시글");
        board.setWriter("테스터");
        board.setContent("잘 등록되나요?");
        board.setCreateDate(new Date());
        board.setCnt(0L);

        boardRepo.save(board);
    }


    //상세 조회 기능 테스트
    @Test
    public void testGetBoard(){
        Board board = boardRepo.findById(1L).get();
        System.out.println(board.toString());
    }


    //수정기능 테스트
    @Test
    public void testUpdateBoard(){
        System.out.println("=== 1번 게시글 조회 ===");
        Board board = boardRepo.findById(1L).get();

        System.out.println("=== 1번 게시글 수정 ===");
        board.setTitle("제목을 수정했습니다.");
        boardRepo.save(board);
    }

     */
    //삭제 기능 테스트
    @Test
    public void testDeleteBoard(){
        boardRepo.deleteById(1L);
    }

}
