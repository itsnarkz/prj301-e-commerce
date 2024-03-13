package com.Shopping.ShoppingApplication.Controller;

import com.Shopping.ShoppingApplication.Model.DTO.UserDTO;
import com.Shopping.ShoppingApplication.Service.CategoryService;
import com.Shopping.ShoppingApplication.Service.ItemService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Controller
@RequestMapping("/admin")
public class AdminController {
    ItemService itemService;
    CategoryService categoryService;

    @Autowired
    public AdminController(ItemService itemService, CategoryService categoryService) {
        this.itemService = itemService;
        this.categoryService = categoryService;
    }

    private boolean isAuthorized(HttpSession session) {
        if(session.isNew()) return false;
        if(session.getAttribute("user") == null) return false;

        UserDTO user = (UserDTO) session.getAttribute("user");
        return user.isAdmin();
    }
    @GetMapping("")
    public String getAdminPage(
            Model model,
            HttpSession session
    ) {
        if(!isAuthorized(session)) return "admin/unauthorized";

        model.addAttribute("itemList", itemService.getAllItem());
        return "admin/adminPage";
    }

    @GetMapping("/addProduct")
    public String getAddProduct(HttpSession session, Model model) {
        if(!isAuthorized(session)) return "admin/unauthorized";

        model.addAttribute("categoryList", categoryService.getAllCategory());
        return "/admin/addProduct";
    }

    @PostMapping("/addProduct")
    public String addProduct(
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam int price,
            @RequestParam String seller,
            @RequestParam Long categoryId,
            Model model
    ) {
        String message;
        message = itemService.addItem(name, description, price, seller, categoryId);
        if(Objects.equals(message, "")) model.addAttribute("success", "Add product successfully!");
        else model.addAttribute("error", message);

        model.addAttribute("categoryList", categoryService.getAllCategory());

        return "/admin/addProduct";
    }

    @GetMapping("/editProduct")
    public String getEditProduct(
            @RequestParam(required = false) Long id,
            Model model,
            HttpSession session
    ) {
        if(!isAuthorized(session)) return "/admin/unauthorized";
        if(id == null) return "redirect:/admin";

        model.addAttribute("p", itemService.getItemById(id));
        model.addAttribute("categoryList", categoryService.getAllCategory());
        return "/admin/editProduct";
    }

    @PostMapping("/editProduct")
    public String editProduct(
            @RequestParam Long id,
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam int price,
            @RequestParam String seller,
            @RequestParam Long categoryId,
            Model model
    ) {
        String message = itemService.updateItem(id, name, description, price, seller, categoryId);

        model.addAttribute("p", itemService.getItemById(id));
        model.addAttribute("categoryList", categoryService.getAllCategory());

        if(Objects.equals(message, "")) model.addAttribute("success", "Update product successfully!");
        else model.addAttribute("error", message);

        return "/admin/editProduct";
    }

    @GetMapping("/deleteProduct")
    public String deleteProduct(
            @RequestParam Long id,
            HttpSession session
    ) {
        if(!isAuthorized(session)) return "admin/unauthorized";

        itemService.deleteItem(id);
        return "redirect:/admin";
    }
}
