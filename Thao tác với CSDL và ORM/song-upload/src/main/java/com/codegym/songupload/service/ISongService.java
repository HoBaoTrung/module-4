package com.codegym.songupload.service;



import com.codegym.songupload.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();

    void save(Song song);

    Song findById(int id);

    void remove(int id);
}
