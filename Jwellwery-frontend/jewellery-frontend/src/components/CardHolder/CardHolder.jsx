import React from 'react';
import "./cardHolder.css";
import axios from 'axios';
import { ProductCard } from '../../components/ProductCard/ProductCard';
import { useState, useEffect } from 'react';
import { useHistory } from 'react-router';

export const CardHolder = ({title}) => {
    const history = useHistory();
    const [products, setProducts] = useState([]);

    let category;
    switch(title) {
        case "ring":
          category = 1;
          break;
        case "necklace":
          category = 2;
          break;
        case "bracelet":
            category = 3;
            break;
      }

    const api = `http://localhost:3038/categoryById/${category}`;

    const fetchProduct = () => {
        axios.get(api)
        .then(res => {
            const data = res.data;
            setProducts(data.products); 
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

            <label htmlFor="category" className="cardHolder__title">{title}</label>

            {
                    products.slice(0,3).map((item, index)=>{
                        return < ProductCard key={index} product={item}/>
                    })
                }

            <button className="cardHolder__btn" onClick={()=>{history.push(`/category/${title}`)}}>View More</button>
        </div>
    )
}
