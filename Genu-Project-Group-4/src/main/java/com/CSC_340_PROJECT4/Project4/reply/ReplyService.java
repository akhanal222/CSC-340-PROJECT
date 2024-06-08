package com.CSC_340_PROJECT4.Project4.reply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyService {

    @Autowired
    private ReplyRepository replyRepository;

    public Reply createReply(Reply reply) {
        return replyRepository.save(reply);
    }

    public void deleteReply(int id) {
        replyRepository.deleteById(id);
    }
}
