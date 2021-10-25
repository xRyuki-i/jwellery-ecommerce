import React, {useState} from 'react';
import './checkout.css';
import { Header } from '../../components/Header/Header';
import { Footer } from '../../components/Footer/Footer';
import { Link } from 'react-router-dom';

export const Checkout = () => {
    const [checkout, setcheckout] = useState({address: '',password:''});

    const handleChange = (e) => {
        const name = e.target.name;
        const value = e.target.value;
        setcheckout({ ...checkout, [name]: value });
    };

    return (
        <div className="checkout">
            <Header />

            <form className="checkout__form">

                <label htmlFor="Contact us" className="checkout--title">Checkout</label>

                <hr />

                    <label htmlFor="Address">Address :</label>
                    <input 
                        className="checkout__text"
                        type="text" 
                        name="address"
                        value={checkout.address}
                        onChange={handleChange}/>

                    <label htmlFor="Password">Password :</label>
                    <input 
                        className="checkout__text"
                        type="password" 
                        name="password"
                        value={checkout.password}
                        onChange={handleChange}/>

                    <button className="checkout__submit">Add Product</button>

                    <Link to="/register">Create Account</Link>
                    
            </form>

            <Footer />
        </div>
    )
}
