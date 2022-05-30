package com.epam.musicbox.service.impl;

import com.epam.musicbox.entity.Artist;
import com.epam.musicbox.entity.Track;
import com.epam.musicbox.exception.HttpException;
import com.epam.musicbox.repository.ArtistRepository;
import com.epam.musicbox.service.ArtistService;
import com.epam.musicbox.service.Service;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.Optional;

@Singleton
public class ArtistServiceImpl implements ArtistService {
    @Inject
    private ArtistRepository artistRepository;

    @Override
    public List<Artist> findPage(int page) throws HttpException {
        return artistRepository.findAll(Service.getOffset(page),
                Service.PAGE_SIZE);
    }

    @Override
    public Optional<Artist> findById(Long id) {
        return artistRepository.findById(id);
    }

    @Override
    public void save(Artist artist) throws HttpException {
        artistRepository.save(artist);
    }

    @Override
    public void deleteById(Long id) throws HttpException {
        artistRepository.deleteById(id);
    }

    @Override
    public Optional<Artist> findByName(String name) {
        return artistRepository.findByName(name);
    }

    @Override
    public List<Track> getTracks(Long artistId, int page) throws HttpException {
        return artistRepository.getTracks(artistId,
                Service.getOffset(page),
                Service.PAGE_SIZE);
    }

    @Override
    public void addTrack(Long artistId, Long trackId) throws HttpException {
        artistRepository.addTrack(artistId, trackId);
    }

    @Override
    public void removeTrack(Long artistId, Long trackId) throws HttpException {
        artistRepository.removeTrack(artistId, trackId);
    }
}
