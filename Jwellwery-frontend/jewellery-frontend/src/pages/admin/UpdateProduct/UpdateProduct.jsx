import React, {useEffect, useState} from 'react';
import './updateProduct.css';
import axios from "axios";
import { useHistory } from 'react-router-dom';
import {useLocation} from 'react-router';

let data ={
            name:"",
            detail:"",
            productPrice:0,
            productQuantity:1,
            category:{
                categoryId:1
            },
            admin:{
                adminId:2
            }
        }

export const UpdateProduct = () => {

    const history = useHistory();
    const  { state } = useLocation();
    console.log(state);
    const [product, setProduct] = useState({name: state.name, productPrice: state.productPrice, detail: state.detail, category:{categoryId:state.categoryName}, productQuantity: state.productQuantity});
    let [image, setImage]=useState();
    const[productCategory, setProductCategory]=useState();

    const handleChange = (e) => {

        const name = e.target.name;
        const value = e.target.value;
        if(name==="category"){
            handleChangeCategory(e);
        }else{
            setProduct({ ...product, [name]: value });
        // alert("chalyo");
        }
        
    };

    const handleChangeCategory = (e) => {
        const name = e.target.name;
        let value = {
            categoryId: e.target.value
        }
        product[name]=value;
        setProduct({ ...product});
        // alert("chalyo");
    };
    
    const handleImageChange = (e) => {
        image = e.target.files[0];
        setImage(image);
    };

    const handleSubmit = (e) => {
        e.preventDefault();
       
        history.push('/product');
        console.log(product);
        alert("bhayo");
        const formData=new FormData();
            formData.append("product", JSON.stringify(product));
            formData.append("file", image);

            fetchProduct(formData);
    }

    const fetchProduct=(formData)=>{  
        // Make a request for a user with a given ID
        axios.put(`http://localhost:3038/updateProductById/${state.productId}`, formData)
            .then((response) => {
                alert("updated");
                console.log(response);
    
            })
            .catch(function (error) {
                // handle error
                console.log("Error -> ",error);
            });
      }



      const fetchCategoryForProduct=()=>{  
        // Make a request for a user with a given ID
        axios.get(`http://localhost:3038/category`)
            .then((response) => {
                alert("fetched");
                console.log("category");
                console.log(response.data);
                setProductCategory(response.data);
    
            })
            .catch(function (error) {
                // handle error
                console.log("Error -> ",error);
            });
      }
      useEffect(()=>{
        fetchCategoryForProduct();
        
    },[])

    return (
        <>
            <header className="header-admin">
                Admin 
            </header>

            <article>
                
                <form className="product-form" onSubmit={handleSubmit}>
                    <h3>Update Product</h3>

                    <hr/>

                    <label htmlFor="Product Name">Product Name :</label>
                    <input 
                        className="form__text"
                        type="text" 
                        name="name"
                        value={product.name}
                        onChange={handleChange}/>

                    <label htmlFor="Price">Price :</label>
                    <input 
                        className="form__text"
                        type="text" 
                        name="productPrice"
                        value={product.productPrice}
                        onChange={handleChange}/>

                    <label htmlFor="Product Image">Product Image :</label>
                    <input type="file" 
                        className="form__text" 
                        id="inputImage" 
                        name="image"  
                        onChange={handleImageChange}/>

                    <label htmlFor="Product Category">Product Category :</label>
                    <select className="form__text" id="specificSizeSelect" name="category" value={product.category.categoryId}  onChange={handleChange}>
                        
                        <option selected>Choose...</option>
                        {(productCategory !== undefined) && productCategory.map((value, index)=>{
                            return  <option value={index+1}>{value.categoryName}</option>
                           
                        })
                    }
                        
                    </select>

                    <label htmlFor="Detail">Detail :</label>
                    <input 
                        className="form__text"
                        type="text" 
                        name="detail"
                        value={product.detail}
                        onChange={handleChange}/>

                    <button className="form__submit" type="submit">Update Product</button>
                </form>
            </article>
        </>
    )
}
