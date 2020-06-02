package com.lambda.web.proxy;


import com.lambda.web.mappers.MovieMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Component
public class Pager {
    @Autowired MovieMapper movieMapper;
private int rowCount, startRow, endRow,
    pageCount, pageSize, startPage, endPage, nowPage,
    blockCount, blockSize, preBlock, nextBlock, nowBlock;
private boolean existPrev, existNext;
private String searchWord;
public void paging(){
    rowCount =movieMapper.countMovies();
//    pageSize = 5;
//    blockSize = 5;
//    nowPage = 0;
pageCount = (rowCount%pageSize!=0)? rowCount/pageSize+1 : rowCount/pageSize;
blockCount = (pageCount%blockSize!=0)?pageCount/blockSize+1 : pageCount/blockSize;

startRow = nowPage*pageSize;

endRow =  nowPage != (pageCount-1)? startRow+(pageSize-1) : rowCount-1 ;  //row카운트는 count의 개념이 아니라 마지막 index를 뜻한다

nowBlock = nowPage/blockSize ;

startPage = nowBlock*blockSize;
endPage = (nowBlock!=(blockCount-1) )?startPage+(blockSize-1) : pageCount-1;

preBlock = startPage-blockSize; //이전블럭의 첫번째페이지
nextBlock = startPage+blockSize;  //다음블럭의 첫번째페이지

existPrev = nowBlock!=0;
existNext = (nowBlock+1) !=blockCount;
}



}



