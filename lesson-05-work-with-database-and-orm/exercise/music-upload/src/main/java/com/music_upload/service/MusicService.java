package com.music_upload.service;

import com.music_upload.model.Music;
import com.music_upload.model.MusicForm;

import java.io.IOException;
import java.util.List;

public interface MusicService {
    List<Music> getAll();

    boolean save(MusicForm musicForm) throws IOException;
}
