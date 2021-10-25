import logo from './logo.svg';
import './App.css';
import { BrowserRouter as Router, Route } from "react-router-dom";
import { Product } from './pages/admin/Product/Product';
import { AddProduct } from './pages/admin/AddProduct/AddProduct';
import { Home } from './pages/Home/Home';
import { Contact } from './pages/Contact/Contact';
import {Products} from './pages/Products/Products';
import { Category } from './pages/Category/Category';
import { Login } from './pages/Login/Login';
import { Register } from './pages/Register/Register';
import { AdminLogin } from './pages/admin/AdminLogin/AdminLogin';
import { Cart } from './pages/Cart/Cart';
import { Checkout } from './pages/Checkout/Checkout';
import { UpdateProduct } from './pages/admin/UpdateProduct/UpdateProduct';

function App() {
  return (
    <Router>
        <Route exact path="/product" component={Product} />  
        <Route exact path="/addProduct" component={AddProduct} />
        <Route exact path="/" component={Home} />
        <Route exact path="/contact" component={Contact}/>
        <Route exact path="/products" component={Products}/>
        <Route exact path="/category/:title" component={Category} />
        <Route exact path="/admin" component={AdminLogin}/>
        <Route exact path="/login" component={Login}/>
        <Route exact path="/register" component={Register}/>
        <Route exact path="/cart" component={Cart}/>
        <Route exact path="/checkout" component={Checkout}/>
        <Route exact path="/updateProduct" component={UpdateProduct}/>
    </Router>
  );
}

export default App;
