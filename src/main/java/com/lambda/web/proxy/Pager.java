package com.lambda.web.proxy;


import com.lambda.web.movie.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Pager {
    @Autowired MovieMapper movieMapper;
    private int rowCount, startRow, endRow,
    pageSize, startPage, endPage, pageCount, nowPage,
    blockSize, blockCount, preBlock, nextBlock , nowBlock;
    private boolean existPrev, existNext;
    private String search;
    public void paging(){
        rowCount =movieMapper.countMovies();
        pageSize = 5;
        pageCount = rowCount%pageSize!=0?    rowCount/pageSize+1 :rowCount/pageSize;
        blockSize = 5;
        blockCount = pageCount%blockSize!=0?   pageCount/blockSize+1 :pageCount/blockSize;
        nowPage = 1;
        startRow =(nowPage-1)*pageSize+1;
        endRow= (nowPage!=pageCount)? (nowPage-1)*pageSize+pageSize:rowCount ;
        nowBlock = (nowPage/blockSize%blockSize!=0)?nowPage/blockSize+1 : nowPage/blockSize;
        startPage=nowBlock*blockSize+1;
        endPage=(nowBlock!=blockCount)? nowBlock*blockSize+blockSize :pageCount ;
        preBlock = nowPage-blockSize; nextBlock = nowPage+blockSize;
        existPrev = (nowBlock !=1);
        existNext = (nowBlock != blockCount);
    };


}
