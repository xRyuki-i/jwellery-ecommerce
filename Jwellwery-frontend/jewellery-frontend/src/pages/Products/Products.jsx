import React, {useState} from 'react';
import './products.css';
import { Footer } from '../../components/Footer/Footer';
import { Header } from '../../components/Header/Header';
import { useHistory } from 'react-router';

export const Products = () => {
    const history = useHistory();
    const data = history.location.state;
    const [size, setSize] = useState('');

    const handleChange = (e) => {
        const value = e.target.value;
        setSize(value);
    };

    return (
        <div className="products">
            <Header />

            <section className="products__view">
                <img src={data.image} alt="image" className="products__image"/>

                <article className="view__details">
                    <p className="details__name">{data.name}</p>
                    <p className="details__price">{`Rs ${data.productPrice}`}</p>
                    <hr />
                    <label htmlFor="Size" className="details__size">Size</label>
                    <input 
                        className="size__text"
                        type="text" 
                        name="size"
                        value={size}
                        onChange={handleChange}/>
                    <p className="details__brief">{data.detail}</p>
                    <button className="details__button">Add to Cart</button>
                </article>
            </section>

            <Footer />
        </div>
    )
}
