package eu.codeacademy.eshop.product.controller;

import eu.codeacademy.eshop.product.dto.ProductDto;
import eu.codeacademy.eshop.helper.MessageService;
import eu.codeacademy.eshop.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final MessageService messageService;

    @GetMapping
    public String openCrateProductForm(Model model, String message) {
        model.addAttribute("productDto", ProductDto.builder().build());
        model.addAttribute("message", messageService.getMessage(message));

        return "product/product";
    }

    @PostMapping
    public String createProduct(Model model, @Valid ProductDto product,
                                BindingResult errors,
                                RedirectAttributes redirectAttributes) {
        if (errors.hasErrors()) {
            return "product/product";
        }

        productService.addProduct(product);

        redirectAttributes.addAttribute("message", "create.product.message.success");

        return "redirect:/products";
    }

    @GetMapping("/list")
    public String getProducts(
            Model model, @PageableDefault(size = 7, sort = {"name"}, direction = Sort.Direction.ASC) Pageable pageable) {
        model.addAttribute("productsPage", productService.getProductPaginated(pageable));

        return "product/products";
    }

    @GetMapping("/{productId}/update")
    public String getUpdateProduct(Model model, @PathVariable("productId") UUID id) {
        model.addAttribute("productDto", productService.getProductByUUID(id));

        return "product/product";
    }

    @PostMapping("/{productId}/update")
    public String getUpdateProduct(Model model, ProductDto product) {
        productService.updateProduct(product);

        return "redirect:/products/list";
    }

    /**
     * @deprecated since 2022-05-17, use {@link #deleteProductV2(UUID)} instead
     * @param model
     * @param id
     * @return
     */
    @Deprecated
    @GetMapping("/{productId}/delete")
    public String deleteProduct(Model model, @PathVariable("productId") UUID id) {
        productService.deleteProduct(id);

        return "redirect:/products/list";
    }

    @PostMapping("/delete")
    public String deleteProductV2(@RequestParam UUID productId) {
        productService.deleteProduct(productId);

        return "redirect:/products/list";
    }
}
