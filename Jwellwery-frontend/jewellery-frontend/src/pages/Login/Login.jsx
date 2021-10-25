import React,{useEffect, useState} from 'react';
import './login.css';
import { Header } from '../../components/Header/Header';
import { Footer } from '../../components/Footer/Footer';
import { Link } from 'react-router-dom';
import axios from 'axios';
import { useHistory } from 'react-router';


export const Login = () => {

    const history = useHistory();
    const [login, setLogin] = useState({customerEmail: '',customerPassword:''});

    const handleChange = (e) => {
        const name = e.target.name;
        const value = e.target.value;
        setLogin({ ...login, [name]: value });
    };

    const loginCustomer=()=>{
        // Make a request for a user with a given ID
        axios.get(`http://localhost:3038/customer/login?customerEmail=${login.customerEmail}&customerPassword=${login.customerPassword}`)
            .then((response) => {
            // handle success
                console.log("Login");
                console.log(response);
                if(response.data.status === 0){
                    alert(response.data.statusMessage)
                }
                else{
                    alert("WELcome");
                    history.push('/');
                }
            })
            .catch(function (error) {
            // handle error
            console.log("Error -> ",error);
            });
    }

    const handleSubmit=(e)=>{
        e.preventDefault();
        console.log("Submitted");
        loginCustomer();
    }

    return (
        <div className="login">
            <Header />

            <form className="login__form" onSubmit={handleSubmit}>

                <label htmlFor="Contact us" className="login--title">Login</label>

                <hr />

                    <label htmlFor="Email">Email :</label>
                    <input 
                        className="login__text"
                        type="text" 
                        name="customerEmail"
                        value={login.customerEmail}
                        onChange={handleChange}/>

                    <label htmlFor="Password">Password :</label>
                    <input 
                        className="login__text"
                        type="password" 
                        name="customerPassword"
                        value={login.customerPassword}
                        onChange={handleChange}/>

                    <button className="login__submit" type="submit">Login</button>

                    <Link to="/register">Create Account</Link>
                    
            </form>

            <Footer />
        </div>
    )
}
