package org.coteis.controller.comment;

import lombok.RequiredArgsConstructor;
import org.coteis.domain.comment.Comment;
import org.coteis.dto.comment.AddCommentRequest;
import org.coteis.dto.comment.CommentResponse;
import org.coteis.dto.comment.UpdateCommentRequest;
import org.coteis.service.comment.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/api/comments")
    public ResponseEntity<Comment> addComment(@RequestBody AddCommentRequest request) {
         Comment savedComment = commentService.save(request);
         return ResponseEntity.status(HttpStatus.CREATED)
                 .body(savedComment);
    }

    @GetMapping("/api/comments")
    public ResponseEntity<List<CommentResponse>> findAllComments() {
        List<CommentResponse> comments = commentService.findAll()
                .stream()
                .map(CommentResponse::new)
                .toList();

        return ResponseEntity.ok().body(comments);
    }

    @PutMapping("/api/comments/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long id,
                                                 @RequestBody UpdateCommentRequest request) {
        Comment updatedComment = commentService.update(id, request);

        return ResponseEntity.ok()
                .body(updatedComment);
    }

    @DeleteMapping("/api/comments/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        commentService.delete(id);

        return ResponseEntity.ok().build();
    }
}
