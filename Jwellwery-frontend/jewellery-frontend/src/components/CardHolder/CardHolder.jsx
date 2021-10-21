import React from 'react';
import "./cardHolder.css";
import axios from 'axios';
import { ProductCard } from '../../components/ProductCard/ProductCard';
import { useState, useEffect } from 'react';

export const CardHolder = () => {

    const [products, setProducts] = useState([]);
    const api = "http://localhost:3038/getAllProducts";
    const fetchProduct = () => {
        axios.get(api)
        .then(res => {
            const data = res.data;
            setProducts(data); 
        })
        .catch(err => {
            console.log(err);
        })
    }

    useEffect(()=>{
        fetchProduct();
    },[])

    return (
        <div className="cardHolder">

            <label htmlFor="category" className="cardHolder__title">Ring</label>

            {
                    products.map((item, index)=>{
                        return < ProductCard key={item.id} product={item}/>
                    })
                }

            <button className="cardHolder__btn">View More</button>
        </div>
    )
}
