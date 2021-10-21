import React from 'react';
import './product.css';
import { useHistory } from 'react-router';

export const Product = () => {
    const history = useHistory();

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
                        <th>Category</th>
                        <th>Actions</th>
                    </tr>
                    <tr>
                        <td>Product Id</td>
                        <td>Name</td>
                        <td>Price</td>
                        <td>Category</td>
                        <td>
                            <button className="table__update" onClick={()=> history.push("/updateProduct")}>Update</button>
                            <button className="table__remove">Remove</button>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    )
}
