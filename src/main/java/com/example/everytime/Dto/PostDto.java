package com.example.everytime.Dto;

import java.time.LocalDateTime;

public record PostDto(
        Long id,

        String title,
        String content,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        boolean isDeleted,
        int likeCount,
        int scrapCount
) {
}
