package com.lambda.web.movie;

import com.lambda.web.music.MusicDTO;
import lombok.Data;
import org.springframework.stereotype.Component;
@Data
@Component
public class MovieDTO {
    private String movieSeq, title, rank, rankDate;
    private MusicDTO ost;

}
