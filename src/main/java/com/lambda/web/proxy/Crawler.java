package com.lambda.web.proxy;

import com.lambda.web.movie.Movie;
import com.lambda.web.movie.MovieBuilder;
import com.lambda.web.movie.MovieRepository;
import com.lambda.web.music.Music;
import com.lambda.web.music.MusicBuilder;
import com.lambda.web.music.MusicRepository;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import  org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service("crawler")  @Lazy
public class Crawler extends Proxy{
    @Autowired Inventory<Music> inventory;
    @Autowired Box<String> box;
    @Autowired MusicRepository musicRepository;
    @Autowired
    MovieRepository movieRepository;
    public void bugsMusic(){
        inventory.clear();
        try{
            String url = "https://music.bugs.co.kr/chart";
            Connection.Response homepage = Jsoup.connect(url).method(Connection.Method.GET)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36")
                    .execute();
            Document d = homepage.parse();
            Elements title = d.select("p.title");
            Elements artist = d.select("p.artist");
            Elements thumbnail = d.select("a.thumbnail");
            for(int i=0;i < title.size(); i++){
                Music m =new MusicBuilder().createMusic();
                m.setSeq(string(i+1));
                m.setTitle(title.get(i).text());
                m.setArtists(artist.get(i).text());
                m.setThumbnail(thumbnail.get(i).select("img").attr("src"));
                musicRepository.save(m);

            }
        }catch(Exception e){
            print("에러 발생");
            e.printStackTrace();
        }

    }
    public void naverMovie(){
        inventory.clear();
        try{
            String url = "http://movie.naver.com/movie/sdb/rank/rmovie.nhn";
            Connection.Response homepage = Jsoup.connect(url).method(Connection.Method.GET)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36")
                    .execute();
            Document d = homepage.parse();
Elements rankDate = d.select("p.r_date");
Elements rank = d.select("td.ac");
             Elements title = d.select("div.tit3");
             for (int i=0; i < title.size(); i++){
                 Movie m =new MovieBuilder().createMovie();
                 m.setRank(string(i+1));
                 m.setTitle(title.get(i).text());
                m.setRankDate(rankDate.get(0).text());
                 movieRepository.save(m);

             }



        }catch (Exception e){print("에러발생");}
    }
}
