package com.boya.springboot.web;

import com.boya.springboot.config.auth.LoginUser;
import com.boya.springboot.config.auth.dto.SessionUser;
import com.boya.springboot.service.posts.PostsService;
import com.boya.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class indexController {

        private final PostsService postsService;
        private final HttpSession httpSession;

        @GetMapping("/")
        public String index(Model model, @LoginUser SessionUser user) {
            model.addAttribute("posts",postsService.findAllDesc());
            if (user != null) {
                model.addAttribute("usersName", user.getName());
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
