package com.example.DV.application.port.in;

public interface VoteUseCase {
    void doVote(Long userId, Long voteTopicId, String voteOption);
    // 투표 관련 기능들
}
