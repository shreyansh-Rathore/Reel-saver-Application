package com.savereel.reelsaver.Controller;

import com.savereel.reelsaver.Entity.Reel;
import com.savereel.reelsaver.Service.ReelsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reels")
public class ReelsController {

    private ReelsService reelsService;

    public ReelsController(ReelsService reelsService) {
        this.reelsService = reelsService;
    }

    // save reel
    @PostMapping
    public ResponseEntity<?> saveReel(@RequestBody Reel reel){
        Reel savedReel =
                reelsService.saveThisReel(reel);
        if (savedReel == null){
            return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).body("An error Occurred");
        }
        else return ResponseEntity.ok("Reel saved into Database");

    }

    @GetMapping("/")
    public String home() {
        return "Server is up and running!";
    }

    // update Custom Message

    // delete reel

}
