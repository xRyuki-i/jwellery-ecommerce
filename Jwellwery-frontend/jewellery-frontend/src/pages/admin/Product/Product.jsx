import React, {useState, useEffect} from 'react';
import './product.css';
import { useHistory } from 'react-router';
import axios from 'axios';

export const Product = () => {
    const history = useHistory();
    const[product, setProduct]=useState();
    const[deleted, setDeleted]=useState(false);

    const fetchProductData=()=>{  
        // Make a request for a user with a given ID
        axios.get(`http://localhost:3038/getAllProducts`)
            .then((response) => {
                console.log(response);
                setProduct(response.data);
           
            })
            .catch(function (error) {
                // handle error
                console.log("Error -> ",error);
            });
    }

    useEffect(()=>{
        fetchProductData();
    },[deleted])

    const deleteProduct=(pro)=>{
        setDeleted(true);
        console.log(pro);
        // Make a request for a user with a given ID
        axios.delete(`http://localhost:3038/deleteProductById/${pro}`)
            .then(function (response) {
              alert('deleted');
              setDeleted(false);
            })
            .catch(function (error) {
                console.log(error);
                setDeleted(false);
            });
    }

    return (
        <div>
            <header className="header-admin">
                Admin 
            </header>

            <div className="table-container">
                <button className="table__add" onClick={()=> history.push("/addProduct")}>Add Product</button>

                <table>
                    <tr>
                        <th>Product Id</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Actions</th>
                    </tr>

                    {(product !== undefined) && product.map((pro, index)=>{
                        return(
                            <tr key={index}>
                                <td>{pro.productId}</td>
                                <td>{pro.name}</td>
                                <td>{pro.productPrice}</td>
                                <td>
                                    <button className="table__update" onClick={()=>history.push({pathname:"/updateProduct", state: pro})}>Update</button>
                                    <button className="table__remove" onClick={()=>deleteProduct(pro.productId)}>Remove</button>
                                </td>
                            </tr>
                        );
                    })
                    }
                </table>
            </div>
        </div>
    )
}
