package com.example;

import com.example.domain.Board;
import com.example.domain.QBoard;
import com.example.persistence.DynamicBoardRepository;
import com.querydsl.core.BooleanBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DynamicQueryTest {
    @Autowired
    private DynamicBoardRepository boardRepo;

    @Test
    public void testDynamicQuery(){
        String searchCondition = "title";
        String searchKeyword = "테스트 제목 10";

        BooleanBuilder builder = new BooleanBuilder();

        QBoard qboard = QBoard.board;

        if(searchCondition.equals("title")){
            builder.and(qboard.title.like("%"+searchKeyword+"%"));
        }else if(searchCondition.equals("content")){
            builder.and(qboard.content.like("%"+searchKeyword+"%"));
        }

        Pageable paging = PageRequest.of(0,5);

        Page<Board> boardList = boardRepo.findAll(builder, paging);

        System.out.println("검색 결과");
        for(Board board : boardList){
            System.out.println("--->"+board.toString());
        }
    }
}
