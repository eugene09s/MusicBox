package com.epam.musicbox.controller.command.impl.playlist;

import com.epam.musicbox.constant.Parameter;
import com.epam.musicbox.controller.command.Command;
import com.epam.musicbox.entity.Playlist;
import com.epam.musicbox.exception.HttpException;
import com.epam.musicbox.service.PlaylistService;
import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class PlaylistCreateCommand implements Command {
    @Inject
    private PlaylistService playlistService;

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws HttpException {
        HttpSession session = req.getSession();
        Integer userId = ((Integer) session.getAttribute(Parameter.USER_ID));
        String name = req.getParameter(Parameter.PLAYLIST_NAME);
        Playlist playlist = new Playlist(null, name, userId);
        playlistService.save(playlist);
    }
}