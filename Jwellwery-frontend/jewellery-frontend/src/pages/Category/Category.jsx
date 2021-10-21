import React, { useState, useEffect } from 'react'
import { useParams } from 'react-router';
import './category.css';
import axios from 'axios';
import { Footer } from '../../components/Footer/Footer';
import { Header } from '../../components/Header/Header';
import { ProductCard } from '../../components/ProductCard/ProductCard';

export const Category = () => {

    const {title} = useParams();
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
            const data = res.data.products;
            setProducts(data); 
        })
        .catch(err => {
            console.log(err);
        })
    }

    useEffect(()=>{
        fetchProduct();
    },[title])


    return (
        <div className="category">
            <Header/>

            <section className="category__wrapper">
                <h1 className="title__category">{title.toUpperCase()}</h1>
                <hr/>
                <div className="category__product">
                    {
                        products.map(item=>{
                            return (
                                <div key={item.id}>
                                    <ProductCard key={item.id} product={item}/>
                                </div>
                            )
                        })
                    }
                </div>
            </section>

            <Footer />
        </div>
    )
}
