import React from 'react';
import './addProduct.css';
import { useState } from 'react';

export const AddProduct = () => {

    const [product, setProduct] = useState({name: '',price:'',category: '', image: '',detail:''});
    const [products, setProducts] = useState([]);

    const handleChange = (e) => {
        const name = e.target.name;
        const value = e.target.value;
        setProduct({ ...product, [name]: value });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log("hello world");
    }

    return (
        <>
            <header className="header-admin">
                Admin 
            </header>

            <article>
                
                <form className="product-form" onSubmit={handleSubmit}>
                    <h3>Add Product</h3>

                    <label htmlFor="Product Name">Product Name :</label>
                    <input 
                        className="form__text"
                        type="text" 
                        name="name"
                        value={product.name}
                        onChange={handleChange}/>

                    <label htmlFor="Price">Price :</label>
                    <input 
                        className="form__text"
                        type="text" 
                        name="price"
                        value={product.price}
                        onChange={handleChange}/>

                    <label htmlFor="Category">Category :</label>
                    <input 
                        className="form__text"
                        type="text" 
                        name="category"
                        value={product.category}
                        onChange={handleChange}/>

                    <label htmlFor="Image">Image :</label>
                    <input 
                        className="form__text"
                        type="text" 
                        name="image"
                        value={product.image}
                        onChange={handleChange}/>

                    <label htmlFor="Detail">Detail :</label>
                    <input 
                        className="form__text"
                        type="text" 
                        name="detail"
                        value={product.detail}
                        onChange={handleChange}/>

                    <button className="form__submit">Add Product</button>
                </form>
            </article>
        </>
    )
}
