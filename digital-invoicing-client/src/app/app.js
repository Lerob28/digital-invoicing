import axios from "axios";
import { useState } from "react";


export const addressApi = axios.create({
    baseURL:"http://localhost:9000"
});

export const getAddresss = (keyword = '', page = 1, size = 2) => {
    return addressApi.get(`/products?name_like=${keyword}&_page=${page}&_limit=${size}`);
};

export const deleteAddress = (id) => {
    return addressApi.delete(`/products/${id}`);
}

export const getProductById = (id) => {
    return addressApi.get(`/products/${id}`);
}

export const saveProduct = (product) => {
    return addressApi.post(`products`, product);
}

export const checkAddress = (product) => {
    return addressApi.patch(`/products/${product.id}`, {checked:!product.checked});
}

export const updateProduct = (product) => {
    return addressApi.put(`/products/${product.id}`, product);
}


export const useAppState = () => {
    const initialState = {
        products: [{id: 0, name: "Default",price: 0,checked: false}],
        currentPage: 1,
        pageSize: 3,
        keyword: '',
        totalPages: 1,
    };
    const appState = useState(initialState);
    return appState;
};