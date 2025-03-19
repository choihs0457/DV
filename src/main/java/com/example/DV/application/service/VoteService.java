package com.example.DV.application.service;

import com.example.DV.adapter.out.persistence.UserRepository;
import com.example.DV.adapter.out.persistence.VoteCountRepository;
import com.example.DV.adapter.out.persistence.VoteResultRepository;
import com.example.DV.adapter.out.persistence.VoteTopicRepository;
import com.example.DV.application.port.in.VoteUseCase;
import com.example.DV.domain.user.User;
import com.example.DV.domain.vote.VoteCount;
import com.example.DV.domain.vote.VoteResult;
import com.example.DV.domain.vote.VoteTopic;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class VoteService implements VoteUseCase {

    private final VoteResultRepository voteResultRepository;
    private final UserRepository userRepository;
    private final VoteTopicRepository voteTopicRepository;
    private final VoteCountRepository voteCountRepository;

    @Override
    public void doVote(Long userId, Long voteTopicId, String voteOption) {
        // 1) User, VoteTopic 조회
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        VoteTopic topic = voteTopicRepository.findById(voteTopicId)
                .orElseThrow(() -> new RuntimeException("VoteTopic not found"));

        // 2) VoteResult 엔티티 생성 & 저장
        VoteResult voteResult = VoteResult.builder()
                .user(user)
                .voteTopic(topic)
                .voteOption(voteOption)
                .build();
        voteResultRepository.save(voteResult);

        // 3) VoteCount 집계 업데이트
        VoteCount voteCount = voteCountRepository.findByVoteTopicAndVoteOption(topic, voteOption)
                .orElseGet(() -> VoteCount.builder()
                        .voteTopic(topic)
                        .voteOption(voteOption)
                        .count(0L)
                        .build());
        voteCount.setCount(voteCount.getCount() + 1);
        voteCountRepository.save(voteCount);
    }
}
