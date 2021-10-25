import React, { useState, useEffect } from 'react';
import './cartcard.css';
import { useHistory } from 'react-router';
import axios from 'axios';

export const CartCard = ({product}) => {

    const history = useHistory();
    const data = product;
    const [quantity, setQuantity] = useState(data.quantity)
    // const handleClick = () => {
    //     history.push("/products", data)
    // }

    // const updateQuantity = async() => {
        
    // }

    const decreaseQuantity = () => {
        setQuantity(quantity - 1);
    }

    const increaseQuantity = () => {
        setQuantity(quantity + 1);
    }

    useEffect(()=>{
        axios.put(`http://localhost:3038/updateCart/cartId=${data.cartProductId.cartId}/productId=${data.product.productId}/quantity=${quantity}`)
        .then(res => {
            console.log(res, "posted");
        })
        .catch(err => {
            console.log(err, "error");
        })
    },[quantity]);

    return (
        <tr key={data.product.productId}>
            <td>{data.product.name}</td>
            <td>{`Rs${data.product.productPrice}`}</td>
            <td>        
                <section className="cart__size">
                    <button className="size__minus" onClick={decreaseQuantity}>-</button>
                    <label htmlFor="quantity" className="size__title">{quantity}</label>
                    <button className="size__plus" onClick={increaseQuantity}>+</button>
                </section>
            </td>
            <td>
                <button className="table__remove">Remove</button>
            </td>
        </tr>

        // <section className="cartProd" >
        //     {/* <img src={data.product.image} alt="Product image" className="cardProd__image"/> */}
            
        //     <article className="cardProd__detail">
        //         <label htmlFor="name" className="cartProd__name">{data.product.name} </label>
        //         <label htmlFor="price">{`Rs${data.product.productPrice}`}</label>
                
        //         <section className="cart__size">
        //             <button className="size__minus" onClick={decreaseQuantity}>-</button>
        //             <label htmlFor="quantity" className="size__title">{quantity}</label>
        //             <button className="size__plus" onClick={increaseQuantity}>+</button>
        //         </section>
        //     </article>
        // </section>
    )
}