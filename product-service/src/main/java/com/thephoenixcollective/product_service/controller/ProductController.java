package  com.thephoenixcollective.product_service.controller;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @GetMapping("/public/health")
    public String publicHealth() {
        return "Product Service UP - Public!";
    }

    @GetMapping("/health")
    public String health(Authentication auth) {
        return "Product Service UP - User: " + auth.getName();
    }

    @GetMapping("/products")
    @PreAuthorize("hasRole('USER')")
    public String getProducts(Authentication auth) {
        return "Products for: " + auth.getName();
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminOnly() {
        return "Admin products access!";
    }
}
