import React from 'react';
import './home.css';
import { CardHolder } from '../../components/CardHolder/CardHolder';
import { Footer } from '../../components/Footer/Footer';
import { HomeHeader } from '../../components/HomeHeader/HomeHeader';
import {FaCartArrowDown} from "react-icons/fa";


export const Home = () => {
    return (
        <>
            <div className="carousel">
                <HomeHeader/>

                <section className="hero__detail">
                    <p>DISCOVER A NEW TAKE ON</p>
                    <h3 className="detail__highlight">PANDORA RINGS</h3>
                    <button className="hero__button">SHOP NOW <FaCartArrowDown/></button>
                </section>
            </div>

            <section className="home__intro">
                <img src="https://cdn.shopify.com/s/files/1/1244/2630/files/stoberi_crown_40.gif?v=1480126514" alt="crown" className="intro__image"/>
                <p className="intro__slogan">COMMITMENT OF STRENGTH. STRENGTH OF COMMITMENT.</p>

                <img src="https://cdn.shopify.com/s/files/1/1244/2630/files/divider_hash_compact.png?8109944780376103424" alt="divider" />
                <p className="intro__brief">Pandora forges the finest materials into designs of superior quality, as timeless as they are personal. Our products are made to last a lifetime. That commitment is our bond and we invite you to make it yours.</p>
            </section>

            <p className="section--header">Pandora Products</p>

            <hr />

            <section className="home__product">
                <CardHolder/>
                <CardHolder/>
                <CardHolder/>
            </section>

            <Footer/>
        </>
    )
}
