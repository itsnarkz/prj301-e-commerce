package com.Shopping.ShoppingApplication.Controller;

import com.Shopping.ShoppingApplication.Model.Cart;
import com.Shopping.ShoppingApplication.Model.ItemCart;
import com.Shopping.ShoppingApplication.Service.CartService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CartController {
    private CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/cart")
    public String getCart(Model model, HttpSession session) {
        if(session.getAttribute("user") == null) return "redirect:/";

        Cart cart = session.getAttribute("cart") == null ? new Cart() : (Cart) session.getAttribute("cart");

        double totalPrice = 0;
        for(ItemCart item : cart.values()) {
            totalPrice += item.getPrice() * item.getQuantity();
        }

        model.addAttribute("totalPrice", totalPrice);

        return "cart";
    }

    @GetMapping("/addItemCart")
    public String addItem(
            @RequestParam Long id,
            Model model,
            HttpSession session
    ) {
        if(session.getAttribute("user") == null) return "redirect:/";

        Cart cart = session.getAttribute("cart") == null ? new Cart() : (Cart) session.getAttribute("cart");
        cart = cartService.addItem(cart, id);

        session.setAttribute("cart", cart);
        return "redirect:/home";
    }

    @GetMapping("/delItemCart")
    public String delItem(
            @RequestParam Long id,
            Model model,
            HttpSession session
    ) {
        if(session.getAttribute("user") == null) return "redirect:/";

        Cart cart = session.getAttribute("cart") == null ? new Cart() : (Cart) session.getAttribute("cart");
        cart = cartService.delItem(cart, id);

        session.setAttribute("cart", cart);
        return "redirect:/cart";
    }

    @GetMapping("/increaseItemCart")
    public String increaseItem(
            @RequestParam Long id,
            @RequestParam int num,
            Model model,
            HttpSession session
    ) {
        if(session.getAttribute("user") == null) return "redirect:/";

        Cart cart = session.getAttribute("cart") == null ? new Cart() : (Cart) session.getAttribute("cart");
        cart = cartService.updateItem(cart, id, num);

        session.setAttribute("cart", cart);
        return "redirect:/cart";
    }

    @GetMapping("/success")
    public String success(HttpSession session) {
        if(session.getAttribute("user") == null) return "redirect:/";

        Cart cart = (Cart) session.getAttribute("cart");
        if(cart == null || cart.isEmpty()) return "redirect:/cart";

        session.removeAttribute("cart");
        return "success";
    }
}
