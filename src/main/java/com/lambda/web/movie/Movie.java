package com.lambda.web.movie;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
@Getter
@Setter
@ToString
@Component
@Entity(name = "movie")
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieSeq;
   @Column(length = 4)
    private String rank;
    @Column(length = 50)
    private String title;
    @Column(length = 10)
    private String rankDate;

@Builder
    public Movie( String title, String rank, String rankDate){ this.rankDate = rankDate; this.rank=rank; this.title = title;}

}
