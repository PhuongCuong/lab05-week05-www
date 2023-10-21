import axios from './axios';

const getAlladdress = () => {
    return axios.get('/address/get-all')
}

const getbyidAddress = (id) => {
    return axios.get("/get-by-id", id)
}

const createAddress = (address) => {
    return axios.post("/address/create-address", address)
}

const getAlladdressPage = (pageNo, pageSize) => {
    return axios.get(`/address/get-all-address-page?pageNo=${pageNo}&pageSize=${pageSize}&sortdes=asc&sortby=id`)
}

const getAddressById = (id) => {
    return axios.get("/address/get-by-id", id)
}

const updateAddress = (address) => {
    return axios.put("/address/update-by-id", address)
}

export {
    getAlladdress, getbyidAddress, createAddress, getAlladdressPage, getAddressById, updateAddress
}