package com.wimblet.book.springboot.web;

import com.wimblet.book.springboot.config.auth.LoginUser;
import com.wimblet.book.springboot.config.auth.dto.SessionUser;
import com.wimblet.book.springboot.service.posts.PostsService;
import com.wimblet.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {

        model.addAttribute("posts", postsService.findAllDesc());

        if (user != null) {
            model.addAttribute("name", user.getName()); // window os 사용시 username을 윈도우의 환경변수 %USERNAME%로 인하여 사용자 이름으로 나오므로 다른 변수를 사용
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}
