import React, {useState, useEffect} from 'react';
import './cart.css'
import { Footer } from '../../components/Footer/Footer';
import { Header } from '../../components/Header/Header';
import axios from 'axios';
import { CartCard } from '../../components/CartCard/CartCard';

export const Cart = () => {

    const [products, setProducts] = useState([]);

    const api = `http://localhost:3038/cart`;

    const fetchProduct = () => {
        axios.get(api)
        .then(res => {
            const data = res.data[0].cartProducts;
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
        <div className="cart">
            <Header />

            <section className="cart__body">
                <label htmlFor="Cart" className="cart--title">Cart</label>

                <hr/>
                    

                    <div className="cart__product">
                    <table>
                        <tr>
                            <th>Name</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th></th>
                        </tr>
                    
                        {
                            products.map(item=>{
                                return (
                                        <CartCard key={item.id} product={item}/>
                                )
                            })
                        }
                    </table>
                    </div>
            </section>

            <Footer />
        </div>
    )
}
