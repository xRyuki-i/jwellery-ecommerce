import React from 'react';
import './addProduct.css';
import { useState, useEffect } from 'react';
import axios from "axios";
import { useHistory } from 'react-router-dom';

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

export const AddProduct = () => {

    const history = useHistory();
    let [image, setImage]=useState();
    const [product, setProduct] = useState(data);
    const[productCategory, setProductCategory]=useState();

    // const [product, setProduct] = useState({name: '', detail:'',productPrice:'', image: '',category: ''});
    // const [products, setProducts] = useState([]);

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
        const formData=new FormData();
            formData.append("product", JSON.stringify(product));
            formData.append("file", image);

            fetchProduct(formData);
    }

    const fetchProduct=(formData)=>{  
        // Make a request for a user with a given ID
        axios.post(`http://localhost:3038/saveProduct`, formData)
            .then((response) => {
                alert("save");
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
                    <h3>Add Product</h3>

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

                    <button className="form__submit" type="submit">Add Product</button>
                </form>
            </article>
        </>
    )
}
