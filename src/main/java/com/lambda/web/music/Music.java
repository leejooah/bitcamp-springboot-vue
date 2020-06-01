package com.lambda.web.music;
import javax.persistence.*;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
@Data
@Component
@Entity(name="music")
@NoArgsConstructor
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long musicNo;
    @Column(length = 4)
    private String seq;
    @Column(length = 100)
    private String title;
    @Column(length = 500)
    private String artists;
    @Column(length = 500)
    private String  thumbnail;
@Builder
    public Music(String seq, String title, String artists, String thumbnail)
    { this.seq = seq; this.title = title; this. artists =  artists; this.thumbnail = thumbnail; }

}
