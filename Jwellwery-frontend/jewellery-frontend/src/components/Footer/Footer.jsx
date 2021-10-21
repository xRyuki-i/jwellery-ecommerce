import React from 'react';
import './footer.css';
import {FaFacebookSquare} from "react-icons/fa";
import {FaInstagramSquare} from "react-icons/fa";
import {FaTwitterSquare} from "react-icons/fa";
import {FaPinterestSquare} from "react-icons/fa";
import { Link } from 'react-router-dom';


export const Footer = () => {
    return (
        <footer className="footer">
            <nav className="footnav">
                <ul className="footnav__header">
                    <li className="link">
                        <Link to="#"><FaFacebookSquare/>Facebook</Link>
                    </li>

                    <li className="link">
                        <Link to="#"><FaInstagramSquare/>Instagram</Link>
                    </li>

                    <li className="link">
                        <Link to="#"><FaTwitterSquare/>Twitter</Link>
                    </li>

                    <li className="link">
                        <Link to="/"><FaPinterestSquare/>Pinterest</Link>
                    </li>
                </ul>
            </nav>

            <div className="copyright">
                <p>© 2021 All Copyrights reserved, Pandora</p>
            </div>
        </footer>
    )
}
