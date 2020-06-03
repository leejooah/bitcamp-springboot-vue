package com.lambda.web.movie;

import com.lambda.web.mappers.MovieMapper;
import com.lambda.web.proxy.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RequestMapping("/movies")
@RestController
public class MovieController {
@Autowired Pager pager;
@Autowired
MovieMapper movieMapper;
@Autowired Proxy pxy;
@Autowired Box<Object> box;
@Autowired MovieRepository movieRepository;
@Autowired Crawler crawler;
    @GetMapping("/{searchWord}/{pageNumber}") //pageSize, nowPage
    public Map<?,?> list(@PathVariable("pageNumber") int pageNumber,
                    @PathVariable("searchWord") String searchWord) {
        if(searchWord.equals("")){
            pxy.print("검색어가 없음");
        }else{
            pxy.print("검색어"+searchWord);
        }
        pxy.print("넘어온 페이지번호"+pageNumber);
        if (movieRepository.count() ==0)crawler.naverMovie();
        pager.setNowPage(pageNumber);
        pager.setBlockSize(5);
        pager.setPageSize(5);
        pager.paging();
        IFunction<Pager, List<MovieDTO>> f =p-> movieMapper.selectMovies(p);
        List<MovieDTO> l = f.apply(pager);
        pxy.print("***********");
        for (MovieDTO m :l){
            pxy.print(m.toString());
        }
        box.clear();
        box.put("list",l);
        box.put("pager", pager);
        return box.get();
    }
    }

