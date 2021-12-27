package io.olen4ixxx.investing.entity;

import java.sql.Timestamp;

public class Comment extends InvestingEntity {
    private Long commentId;
    private Timestamp commentDate;
    private String text;
    private Long clientId;
    private Long tutorId;
    private CommentType commentType;
}
