package com.example.DV.application.port.out;

import com.example.DV.domain.vote.VoteResult;

public interface VoteRepositoryPort {
    // VoteResult 저장, 조회 등
    VoteResult save(VoteResult voteResult);
}
