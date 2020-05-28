package com.lambda.web.soccer;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class PlayerDTO {
 private String  playerId, playerName,ePlayerName, nickName, joinYyyy,
   position, backNo, nation, birthDate, solar, height, weight;
}
