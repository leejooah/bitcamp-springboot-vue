package com.lambda.web.soccer;
import javax.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="stadium")
public class Stadium {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long stadiumNo;
    @Column(length = 10) private String stadiumId;
    @Column(length = 40) private String stadiumName;
    @Column(length = 10) private String hometeamId;
    @Column(length = 10) private int seatCount;
    @Column(length = 60) private String address;
    @Column(length = 10) private String   ddd;
    @Column(length = 10) private String tel;


    @Builder
    public Stadium(String  stadiumId, String stadiumName, String hometeamId,
                   int seatCount,
                   String address, String ddd, String tel)
    { this. stadiumId =  stadiumId; this.stadiumName = stadiumName;
    this. hometeamId =  hometeamId; this.seatCount = seatCount;
        this. address =   address; this.ddd =ddd;
        this. tel =  tel; }

@OneToMany(mappedBy = "stadium") private List<Schedule> Schedules;
    @OneToMany(mappedBy = "stadium") private List<Team> teams;
}

