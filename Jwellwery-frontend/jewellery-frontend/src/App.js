import logo from './logo.svg';
import './App.css';
import { BrowserRouter as Router, Route } from "react-router-dom";
import { Product } from './pages/admin/Product/Product';
import { AddProduct } from './pages/admin/AddProduct/AddProduct';
import { Home } from './pages/Home/Home';
import { Contact } from './pages/Contact/Contact';
import {Products} from './pages/Products/Products';
import { Category } from './pages/Category/Category';

function App() {
  return (
    <Router>
        <Route exact path="/product" component={Product} />  
        <Route exact path="/addProduct" component={AddProduct} />
        <Route exact path="/" component={Home} />
        <Route exact path="/contact" component={Contact}/>
        <Route exact path="/products" component={Products}/>
        <Route exact path="/category/:title" component={Category} />
    </Router>
  );
}

export default App;
