import React,{useState} from 'react';
import './register.css';
import { Header } from '../../components/Header/Header';
import { Footer } from '../../components/Footer/Footer';
import axios from 'axios';
import { useHistory } from 'react-router';

export const Register = () => {

    const history = useHistory();
    const [register, setRegister] = useState({customerName: '',customerAddress:'', customerPhone:'', customerEmail:'', customerPassword:''});

    const handleChange = (e) => {
        const name = e.target.name;
        const value = e.target.value;
        setRegister({ ...register, [name]: value });
    };

    const postCustomer = async() => {
        await axios.post(`http://localhost:3038/saveCustomer`, register)
        .then(res => {
            if(res.data.status >= 5 && res.data.status <= 10){
                alert(res.data.statusMessage)
            }
            else{
                alert("registered");
                history.push('/');
            }
        })
        .catch(err => {
            alert(err, 'error');
            console.log(err);
            history.push('/login');
        })
    }

    const handleSubmit = (e) => {
        e.preventDefault();
        postCustomer();
        console.log(register);
    }
    

    return (
        <div className="register">
            <Header />

            <form className="register__form" onSubmit={handleSubmit}>

                <label htmlFor="Register" className="register--title">Register</label>

                <hr />

                    <label htmlFor="Name">Name :</label>
                    <input 
                        className="register__text"
                        type="text" 
                        name="customerName"
                        value={register.customerName}
                        onChange={handleChange}/>

                    <label htmlFor="Address">Address :</label>
                    <input 
                        className="register__text"
                        type="text" 
                        name="customerAddress"
                        value={register.customerAddress}
                        onChange={handleChange}/>

                    <label htmlFor="Phone">Phone :</label>
                    <input 
                        className="register__text"
                        type="text" 
                        name="customerPhone"
                        value={register.customerPhone}
                        onChange={handleChange}/>    
                    <label htmlFor="Email">Email :</label>
                    <input 
                        className="register__text"
                        type="text" 
                        name="customerEmail"
                        value={register.customerEmail}
                        onChange={handleChange}/>

                    <label htmlFor="Password">Password :</label>
                    <input 
                        className="register__text"
                        type="password" 
                        name="customerPassword"
                        value={register.customerPassword}
                        onChange={handleChange}/>

                    <button className="register__submit" onClick={handleSubmit}>Add Product</button>
            </form>

            <Footer />
        </div>
    )
}
