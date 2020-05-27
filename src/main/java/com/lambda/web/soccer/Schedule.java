package com.lambda.web.soccer;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="schedule")
public class Schedule {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long scheduleNo;
    @Column(length = 10) private String scheDate;
    @Column(length = 10) private String gubun;
    @Column(length = 10) private String  hometeamId;
    @Column(length = 10) private String awayteamId;
    @Column(length = 10) private int homeScore;
    @Column(length = 10) private int  awayScore;

    @Builder
    public Schedule( String scheDate, String gubun, String hometeamId,
                    String  awayteamId, int homeScore, int  awayScore)
    {  this. scheDate =  scheDate;
    this. gubun =  gubun; this.hometeamId=hometeamId;
        this.awayteamId=awayteamId;
        this. homeScore= homeScore;  this.awayScore=awayScore;}

        @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "stadium_id") @NotNull private Stadium stadium;
}