package org.coteis.service.comment;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.coteis.domain.article.Article;
import org.coteis.domain.comment.Comment;
import org.coteis.dto.comment.AddCommentRequest;
import org.coteis.dto.comment.UpdateCommentRequest;
import org.coteis.repository.comment.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public Comment save(AddCommentRequest request) { return commentRepository.save(request.toEntity()); }

    public List<Comment> findAll() { return commentRepository.findAll(); }

    public void delete(Long id) { commentRepository.deleteById(id); }

    @Transactional
    public Comment update(Long id, UpdateCommentRequest request) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));

        comment.update(request.getContent());

        return comment;
    }
}
