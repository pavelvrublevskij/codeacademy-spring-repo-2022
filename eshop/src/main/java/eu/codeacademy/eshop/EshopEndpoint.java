package eu.codeacademy.eshop;

public interface EshopEndpoint {

    String PUBLIC_WORKSPACE = "/public";

    String PRODUCT_ROOT_PATH = "/products";
    String PRODUCT_LIST_PATH = PUBLIC_WORKSPACE + PRODUCT_ROOT_PATH + "/list";
    String PRODUCT_UPDATE_PATH = PRODUCT_ROOT_PATH + "/{productId}/update";
    String PRODUCT_DELETE_PATH = PRODUCT_ROOT_PATH + "/delete";

    String CART_ROOT_PATH = PUBLIC_WORKSPACE + "/cart";

    String USERS_ROOT_PATH = PUBLIC_WORKSPACE + "/users";
    String USERS_REGISTER_PATH = USERS_ROOT_PATH + "/register";

}
