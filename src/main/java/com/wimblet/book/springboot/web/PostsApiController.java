package com.wimblet.book.springboot.web;

import com.wimblet.book.springboot.service.posts.PostsService;
import com.wimblet.book.springboot.web.dto.PostsResponseDto;
import com.wimblet.book.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/posts")
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsSaveRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }
}
