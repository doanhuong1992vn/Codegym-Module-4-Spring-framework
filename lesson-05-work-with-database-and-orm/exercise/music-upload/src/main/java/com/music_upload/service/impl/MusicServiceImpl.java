package com.music_upload.service.impl;

import com.music_upload.model.Music;
import com.music_upload.model.MusicForm;
import com.music_upload.repository.MusicRepository;
import com.music_upload.service.MusicService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MusicServiceImpl implements MusicService {
    private static final Set<String> fileTypes = new HashSet<>(List.of(new String[]{".mp3", ".m4p", ".ogg", ".wav"}));
    @Value("${music-upload}")
    private String musicUpload;
    private final MusicRepository musicRepository;

    public MusicServiceImpl(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    @Override
    public List<Music> getAll() {
        return musicRepository.getAll();
    }

    @Override
    public boolean save(MusicForm musicForm) throws IOException {
        MultipartFile multipartFile = musicForm.getUrl();
        String fileName = multipartFile.getOriginalFilename();
        assert fileName != null;
        if (isValidFile(fileName)) {
            FileCopyUtils.copy(multipartFile.getBytes(), new File(musicUpload + fileName));
            Music music = new Music(
                    musicForm.getId(),
                    musicForm.getName(),
                    musicForm.getSinger(),
                    musicForm.getGenre(),
                    fileName);
            musicRepository.save(music);
            return true;
        }
        return false;
    }

    private static boolean isValidFile(String fileName) {
        int indexOfFileType = fileName.lastIndexOf('.');
        String fileType = fileName.substring(indexOfFileType);
        return fileTypes.contains(fileType);
    }
}
