package com.music_upload.service.impl;

import com.music_upload.model.Music;
import com.music_upload.model.MusicForm;
import com.music_upload.service.MusicService;

import java.util.ArrayList;
import java.util.List;

public class MusicServiceImpl implements MusicService {
    private static final List<Music> musicList = new ArrayList<>();

    @Override
    public List<Music> getAll() {
        return musicList;
    }

    @Override
    public void save(MusicForm musicForm, String fileName) {
        Music music = new Music(musicForm.getName(), musicForm.getSinger(), musicForm.getGenres(), fileName);
        musicList.add(music);
    }
}
