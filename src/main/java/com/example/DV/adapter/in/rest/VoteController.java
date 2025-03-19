package com.example.DV.adapter.in.rest;

import com.example.DV.application.port.in.VoteUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/votes")
@RequiredArgsConstructor
public class VoteController {

    private final VoteUseCase voteUseCase;

    @PostMapping
    public ResponseEntity<?> doVote(@RequestParam Long userId,
                                    @RequestParam Long topicId,
                                    @RequestParam String option) {
        voteUseCase.doVote(userId, topicId, option);
        return ResponseEntity.ok("투표 완료");
    }

}
