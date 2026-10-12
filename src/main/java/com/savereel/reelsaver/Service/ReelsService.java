package com.savereel.reelsaver.Service;

import com.savereel.reelsaver.Entity.Reel;
import com.savereel.reelsaver.Repository.ReelsRepository;
import org.springframework.stereotype.Service;

@Service
public class ReelsService {

    private ReelsRepository reelsRepository;

    public ReelsService(ReelsRepository reelsRepository) {
        this.reelsRepository = reelsRepository;
    }

    public Reel saveThisReel(Reel reel) {
        if (reel.getUrl() != null) {
            String lowerUrl = reel.getUrl().toLowerCase();

            if (lowerUrl.contains("instagram.com") || lowerUrl.contains("instagr.am")) {
                reel.setPlatform("Instagram");
            } else if (lowerUrl.contains("youtube.com") || lowerUrl.contains("youtu.be")) {
                reel.setPlatform("YouTube");
            } else {
                reel.setPlatform("Other");
            }
        } else {
            reel.setPlatform("Unknown");
        }
        return reelsRepository.save(reel);
    }
}
