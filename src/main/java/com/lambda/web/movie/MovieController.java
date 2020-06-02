package com.lambda.web.movie;

import com.lambda.web.mappers.MovieMapper;
import com.lambda.web.proxy.Box;
import com.lambda.web.proxy.IFunction;
import com.lambda.web.proxy.Pager;
import com.lambda.web.proxy.Proxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RequestMapping("/movie")
@RestController
public class MovieController {
@Autowired Pager pager;
@Autowired
MovieMapper movieMapper;
@Autowired Proxy pxy;
@Autowired Box<Object> box;
    @GetMapping("/list/{pageNumber}/{searchWord}") //pageSize, nowPage
    public Map<?,?> list(@PathVariable("pageNumber") String pageNumber,
                    @PathVariable("searchWord") String searchWord) {
        if(searchWord.equals("")){
            pxy.print("검색어가 없음");
        }else{
            pxy.print("검색어"+searchWord);
        }
        pager.setNowPage(pxy.integar(pageNumber));
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

