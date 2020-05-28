package com.lambda.web.music;

public class MusicBuilder {
    private String seq;
    private String title;
    private String artists;
    private String thumbnail;
    private Long musicNo;

    public MusicBuilder setSeq(String seq) {
        this.seq = seq;
        return this;
    }

    public MusicBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public MusicBuilder setArtists(String artists) {
        this.artists = artists;
        return this;
    }

    public MusicBuilder setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
        return this;
    }

    public MusicBuilder setMusicNo(Long musicNo) {
        this.musicNo = musicNo;
        return this;
    }

    public Music createMusic() {
        return new Music(seq, title, artists, thumbnail);
    }
}