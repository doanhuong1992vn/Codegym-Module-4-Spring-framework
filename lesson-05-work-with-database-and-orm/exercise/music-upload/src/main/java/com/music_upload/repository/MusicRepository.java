package com.music_upload.repository;

import com.music_upload.model.Music;

import java.util.List;

public interface MusicRepository {
    List<Music> getAll();
    void save(Music music);
}
