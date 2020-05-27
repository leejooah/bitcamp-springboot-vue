package com.lambda.web.soccer;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="player")
public class Player {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long playerNo;
    @NotNull @Column(length = 10) private String playerId;
    @Column(length = 20) private String playerName;
    @Column(length = 40) private String  ePlayerName;
    @Column(length = 30) private String nickName;
    @Column(length = 10) private String joinYyyy;
    @Column(length = 10) private String position;
    @Column(length = 10) private String  backNo;
    @Column(length = 20) private String nation;
    @Column(length = 20) private String birthDate;
    @Column(length = 10) private String solar;
    @Column(length = 10) private String  height;
    @Column(length = 10) private String  weight;

    @Builder
    public Player(String playerId, String playerName, String  ePlayerName,
                  String nickName,String joinYyyy,String position,String  backNo,String nation,
                  String birthDate,String solar, String  height,String  weight)
    { this. playerId = playerId; this.  playerName =  playerName;
        this.ePlayerName = ePlayerName; this.nickName = nickName; this.joinYyyy = joinYyyy;
        this. position= position; this.backNo =backNo; this. nation = nation;
        this. birthDate = birthDate; this. solar = solar; this.  height =  height;this. weight= weight;
    }

    @ManyToOne(fetch = FetchType.LAZY)  @JoinColumn(name ="team_id") @NotNull private Team team;
}
