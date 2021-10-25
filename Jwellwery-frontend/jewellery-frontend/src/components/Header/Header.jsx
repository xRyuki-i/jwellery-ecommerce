import React from 'react';
import './header.css';
import { Link } from 'react-router-dom';
import {FaSortDown} from "react-icons/fa";
import { FaUser } from "react-icons/fa";
import {FaShoppingCart} from "react-icons/fa";



export const Header = () => {
    return (
        <header className="header">
            <Link to="/" className="logo">PANDORA</Link>

            <nav className="nav">
                <ul className="nav__header">
                    <li className="list list--dropDown">
                        CATEGORY<FaSortDown/>
                        <ul className="list__dropDown">
                            <li className="dropDown__list">
                                <Link to="/category/ring">Ring</Link>
                            </li>
                            <li className="dropDown__list">
                                <Link to="/category/necklace">Necklace</Link>
                            </li>
                            <li className="dropDown__list">
                                <Link to="/category/bracelet">Bracelet</Link>
                            </li>
                        </ul>
                    </li>

                    <li className="list">
                        <Link to="/contact">CONTACT</Link>
                    </li>

                    <li className="list">
                        <Link to="/login"><FaUser/></Link>
                    </li>

                    <li className="list">
                        <Link to="/cart"><FaShoppingCart/></Link>
                    </li>
                </ul>
            </nav>
        </header>
    )
}
