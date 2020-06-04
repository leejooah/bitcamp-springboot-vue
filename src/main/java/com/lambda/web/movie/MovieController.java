package com.lambda.web.movie;

import com.lambda.web.mappers.MovieMapper;
import com.lambda.web.proxy.*;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RequestMapping("/movies")
@RestController
public class MovieController {
@Autowired Pager pager;
@Autowired MovieMapper movieMapper;
@Autowired Proxy pxy;
@Autowired Box<Object> box;
@Autowired MovieRepository movieRepository;
@Autowired Crawler crawler;
    @GetMapping("/{searchWord}/{pageNumber}")
    public Map<?,?> list(@PathVariable("pageNumber") int pageNumber,
                    @PathVariable("searchWord") String searchWord) {
        if(searchWord.equals("null")){
            pager.setSearchWord("");
        }else{
            pager.setSearchWord(searchWord);
        }
        if (movieRepository.count() ==0)crawler.naverMovie();
        pager.setNowPage(pageNumber);
        pager.setBlockSize(5);
        pager.setPageSize(5);
        pager.paging();
        Function<Pager, List<MovieDTO>> f = p-> movieMapper.selectMovies(p);
        List<MovieDTO> l = f.apply(pager);
        box.clear();
        box.put("list",l);
        box.put("pager", pager);
        return box.get();
    }
@GetMapping("/{searchWord}")
    public MovieDTO findOne(@PathVariable String searchWord){
    System.out.println(movieMapper.selectMovie(searchWord).toString());
        return movieMapper.selectMovie(searchWord);
}
    }

