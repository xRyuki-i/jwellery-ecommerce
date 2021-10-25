import React from 'react';
import './homeHeader.css';
import { Link } from 'react-router-dom';
import {FaSortDown} from "react-icons/fa";
import { FaUser } from "react-icons/fa";
import {FaShoppingCart} from "react-icons/fa";



export const HomeHeader = () => {
    return (
        <header className="homeHeader">
            <Link to="/" className="home__logo">PANDORA</Link>

            <nav className="home__nav">
                <ul className="hnav__header">
                    <li className="hlist hlist--dropDown">
                        CATEGORY<FaSortDown/>
                        <ul className="hlist__dropDown">
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

                    <li className="hlist">
                        <Link to="/contact">CONTACT</Link>
                    </li>

                    <li className="hlist">
                        <Link to="/login"><FaUser/></Link>
                    </li>

                    <li className="hlist">
                        <Link to="/cart"><FaShoppingCart/></Link>
                    </li>
                </ul>
            </nav>
        </header>
    )
}
