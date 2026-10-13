package com.savereel.reelsaver;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class KeepAliveTask {
    // 720,000 milliseconds = 12 minutes
    @Scheduled(fixedRate = 720000)
    public void pingSelf() {
        try {
            RestTemplate restTemplate = new RestTemplate();

            // ⚠️ REPLACE THIS with your exact Render URL
            String url = "https://onrender.com";

            restTemplate.getForObject(url, String.class);
            System.out.println("Self-ping successful. App is staying awake!");
        } catch (Exception e) {
            // We catch errors so if the site is temporarily down, the app won't crash
            System.out.println("Self-ping logged (normal if app is waking up): " + e.getMessage());
        }
    }

}
