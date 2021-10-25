import React,{useState, useEffect} from 'react';
import './adminLogin.css';
import axios from 'axios';
import { useHistory } from 'react-router';

export const AdminLogin = () => {

    const history = useHistory();
    const [adminData, setAdminData]= useState();
    const [isFormSubmitted, setFormSubmitted] = useState(false);
    const [adminLogin, setAdminLogin] = useState({email: '',adminPassword:''});

    const handleChange = (e) => {
        const name = e.target.name;
        const value = e.target.value;
        setAdminLogin({ ...adminLogin, [name]: value });
    };

    const handleSubmit=(e)=>{
        e.preventDefault();
        setFormSubmitted(true);
        fetchAdminData();
      }

      const validate=()=>{
        if(adminData.status === 0){
          alert(adminData.statusMessage);
      }
      else{
          alert("successful");
          history.push({pathname:"/product"});
      }
    }
    
    const fetchAdminData=()=>{  
        // Make a request for a user with a given ID
        axios.get(`http://localhost:3038/admin/login?email=${adminLogin.email}&adminPassword=${adminLogin.adminPassword}`)
          .then((response) => {
            setAdminData(response.data);
          })
          .catch(function (error) {
            // handle error
            console.log("Error -> ",error);
          });
      }

      useEffect(()=>{
        if(isFormSubmitted){
            validate();
            setFormSubmitted(false);
        }
    },[adminData]);

    return (
        <div className="adminLogin">
            <header className="header-admin">
                Admin 
            </header>

            <form className="adminLogin__form" onSubmit={(e)=>handleSubmit(e)}>

                <label htmlFor="Admin" className="adminLogin--title">Admin</label>

                <hr />

                    <label htmlFor="Email">Email :</label>
                    <input 
                        className="adminLogin__text"
                        type="text" 
                        name="email"
                        value={adminLogin.email}
                        onChange={handleChange}/>

                    <label htmlFor="Password">Password :</label>
                    <input 
                        className="adminLogin__text"
                        type="password" 
                        name="adminPassword"
                        value={adminLogin.adminPassword}
                        onChange={handleChange}/>

                    <button className="adminLogin__submit" onSubmit={handleSubmit}>Add Product</button>
                    
            </form>
        </div>
    )
}
