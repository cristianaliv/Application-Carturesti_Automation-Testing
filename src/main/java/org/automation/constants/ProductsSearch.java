package org.automation.constants;

public enum ProductsSearch {


    FIRST_PRODUCT("Acolo unde canta racii"),
    SECOND_PRODUCT("Baiatul cu pijamale in dungi"),
    THIRD_PRODUCT("Cat timp infloresc lamaii");


    public final String product;

    ProductsSearch(String product) {
        this.product = product;
    }

    public String getProductSearch() {
        return product;
    }
}
