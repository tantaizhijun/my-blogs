package com.spring.blogs.myblogs.controller;

import com.spring.blogs.myblogs.domain.User;
import com.spring.blogs.myblogs.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    /**
     * 所有用户
     * @return
     */
    @GetMapping
    public ModelAndView list(Model model) {
        model.addAttribute("userList", userRepo.findAll());
        model.addAttribute("title", "用户管理");
        return new ModelAndView("user/list", "userModel", model);
    }

    /**
     * 根据id查询用户
     * @return
     */
    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") Long id, Model model) {
        User user = userRepo.findOne(id);
        model.addAttribute("user", user);
        model.addAttribute("title", "查看用户");
        return new ModelAndView("user/view", "userModel", model);
    }

    /**
     * 获取 form 表单页面
     * @param
     * @return
     */
    @GetMapping("/form")
    public ModelAndView createForm(Model model) {
        model.addAttribute("user", new User(null,null,null,null));
        model.addAttribute("title", "创建用户");
        return new ModelAndView("user/form", "userModel", model);
    }


    /**
     * 新建用户
     * @param user
     * @return
     */
    @PostMapping
    public ModelAndView create(User user) {
        user = userRepo.save(user);
        return new ModelAndView("redirect:/user");
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @GetMapping(value = "delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id, Model model) {
        userRepo.delete(id);
        model.addAttribute("userList", userRepo.findAll());
        model.addAttribute("title", "删除用户");
        return new ModelAndView("user/list", "userModel", model);
    }

    /**
     * 修改用户
     * @param
     * @return
     */
    @GetMapping(value = "modify/{id}")
    public ModelAndView modifyForm(@PathVariable("id") Long id, Model model) {
        User user = userRepo.findOne(id);

        model.addAttribute("user", user);
        model.addAttribute("title", "修改用户");
        return new ModelAndView("user/form", "userModel", model);
    }
}
