package com.example.persistence;

import com.example.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardRepository extends CrudRepository<Board, Long> {

    //게시글 제목으로 목록을 조회
    List<Board> findByTitle(String searchKeyword);

    //게시글 내용에 특정 단어가 포함된 글 목록을 조회
    List<Board> findByContentContaining(String searchKeyword);

    //여러 조건 사용하기 (AND & OR)
    List<Board> findByTitleContainingOrContentContaining(String title, String content);

    //게시글 제목에 특정 단어가 포함된 글 목록을 내림차순으로 정렬하기
    List<Board> findByTitleContainingOrderBySeqDesc(String searchkeyword);

    //페이징 처리
    Page<Board> findByTitleContaining(String searchkeyword, Pageable paging);

    /*
    //위치 기반 파라미터 사용하기
    //@Query("SELECT b FROM Board b WHERE b.title like %?1% ORDER BY b.seq DESC")
    //이름 기반 파라미터 사용하기
    @Query("select b from Board b where b.title like %:searchkeyword% order by b.seq desc")
    List<Board> queryAnnotationTest1(@Param("searchkeyword") String searchkeyword);

    //특정 변수만 조회하기
    @Query("select b.seq, b.title, b.writer, b.createDate from Board b where b.title like %?1% order by b.seq desc")
    List<Object[]> queryAnnotationTest2(@Param("searchkeyword") String searchkeyword);

    //네이티브 쿼리 사용하기
    @Query(value = "select seq, title, writer, create_date from board where title like '%'||?1||'%' order by seq desc",
            nativeQuery = true)
    List<Object[]> queryAnnotationTest3(String searchkeyword);

    //페이징 및 정렬처리하기
    @Query("select b from Board b order by b.seq desc")
    List<Board> queryAnnotationTest4(Pageable paging);
     */
}
