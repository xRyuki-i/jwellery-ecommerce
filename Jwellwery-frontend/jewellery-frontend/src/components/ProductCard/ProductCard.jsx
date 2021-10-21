import React from 'react';
import './productCard.css';
import { useHistory } from 'react-router';

export const ProductCard = ({product}) => {

    const history = useHistory();
    const data = product;
    const handleClick = () => {
        history.push("/products", data)
    }

    return (
        <section className="card" onClick={handleClick}>
            <img src={data.image} alt="Product image" className="card__image"/>
            
            <article className="card__detail">
                <label htmlFor="name" className="detail__name">{data.name} </label>
                <label htmlFor="price">{`--- Rs${data.productPrice}`}</label>
            </article>
        </section>
    )
}
