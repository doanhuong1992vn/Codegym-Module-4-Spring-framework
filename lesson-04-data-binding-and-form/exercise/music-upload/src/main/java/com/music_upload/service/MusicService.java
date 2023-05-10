package com.music_upload.service;

import com.music_upload.model.Music;
import com.music_upload.model.MusicForm;

import java.util.List;

public interface MusicService {
    List<Music> getAll();

    void save(MusicForm musicForm, String fileName);
}
