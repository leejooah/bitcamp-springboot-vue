package com.lambda.web.music;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Column;

@Data
@Component
public class MusicDTO {
    private String seq, title,artists, thumbnail;
}
