package eu.codeacademy.eshop.product.repository;

import eu.codeacademy.eshop.product.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public class ProductRepository {

    private final Map<UUID, Product> products;
    private final JdbcTemplate jdbcTemplate;

    public ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.products = new HashMap<>();
    }

    public void save(Product product) {
        UUID id = UUID.randomUUID();
        product.setProductId(id);
        products.put(id, product);
    }

    public List<Product> getProducts() {
        return jdbcTemplate.query("SELECT * FROM PRODUCT", new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
                return Product.builder()
                        .productId(UUID.fromString(rs.getString("product_id")))
                        .name(rs.getString("name"))
                        .quantity(rs.getInt("quantity_in_stock"))
                        .price(rs.getBigDecimal("price"))
                        .description(rs.getString("description"))
                        .build();
            }
        });
    }

    public Product getProductByUUID(UUID id) {
        return products.get(id);
    }

    public void update(Product product) {
        products.put(product.getProductId(), product);
    }

    public void delete(UUID uuid) {
        products.remove(uuid);
    }
}
