package com.Shopping.ShoppingApplication.Controller;

import com.Shopping.ShoppingApplication.Model.DTO.ItemDTO;
import com.Shopping.ShoppingApplication.Model.DTO.UserDTO;
import com.Shopping.ShoppingApplication.Service.CategoryService;
import com.Shopping.ShoppingApplication.Service.ItemService;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HomeController {
    CategoryService categoryService;
    ItemService itemService;

    @Autowired
    public HomeController(CategoryService categoryService, ItemService itemService) {
        this.categoryService = categoryService;
        this.itemService = itemService;
    }

    @GetMapping("/home")
    public String home(HttpSession session, Model model) {
        if(session.getAttribute("user") == null) return "redirect:/login";

        model.addAttribute("categoryList", categoryService.getAllCategory());
        model.addAttribute("itemList", itemService.getAllItem());

        UserDTO user = (UserDTO) session.getAttribute("user");
        if(user.isAdmin()) return "admin/adminHomePage";
        else return "homePage";
    }

    @GetMapping("/category")
    public String category(
            @RequestParam Long categoryId,
            Model model,
            HttpSession session
    ) {
        if(session.getAttribute("user") == null) return "redirect:/login";

        model.addAttribute("categoryList", categoryService.getAllCategory());
        model.addAttribute("itemList", itemService.getItemByCategory(categoryId));

        model.addAttribute("category", categoryId);

        UserDTO user = (UserDTO) session.getAttribute("user");
        if(user.isAdmin()) return "admin/adminHomePage";
        else return "homePage";
    }

    @GetMapping("/search")
    public String search(
            @RequestParam(required = false) String q,
            Model model,
            HttpSession session
    ) {
        if(session.getAttribute("user") == null) return "redirect:/login";

        model.addAttribute("categoryList", categoryService.getAllCategory());
        model.addAttribute("itemList", itemService.searchItemByName(q));

        UserDTO user = (UserDTO) session.getAttribute("user");
        if(user.isAdmin()) return "admin/adminHomePage";
        else return "homePage";
    }

    @GetMapping("/liveSearch")
    @ResponseBody
    @JsonBackReference
    @JsonIgnoreProperties
    public List<ItemDTO> searchResults(@RequestParam String q) {
        return itemService.searchItemByName(q);
    }
}
