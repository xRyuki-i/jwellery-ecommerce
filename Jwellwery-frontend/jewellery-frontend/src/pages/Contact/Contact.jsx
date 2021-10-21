import React from 'react';
import "./contact.css";
import { Header } from '../../components/Header/Header'
import { Footer } from '../../components/Footer/Footer';

export const Contact = () => {
    return (
        <div className="contact">
          <Header />  

          <label htmlFor="Contact us" className="topic--contact">Contact Us</label>

          <hr />

          <section className="contact__info">
              <article className="info">
                <img src="https://cdn.shopify.com/s/files/1/1244/2630/files/stoberi_email_40.gif?v=1480127298" alt="email" className="info__image"/>
                <h3>EMAIL</h3>
                <p>We'll return your email within just a few hours. Questions regarding:
                    <br/>Product selection, shipping or returns: support@pandora.com
                    <br/>Retailing or carrying Pandora products in your store: direct@pandora.com
                    <br/>Questions from the media: media@pandora.com
                </p>
              </article>

              <article className="info">
                <img src="https://cdn.shopify.com/s/files/1/1244/2630/files/stoberi_phone_40.gif?v=1480127334" alt="phone" className="info__image"/>
                <h3>TELEPHONE</h3>
                <p>Please call us toll-free during business hours in the Nepal at
                    <br/>PANDORA (Phone : 98083474047).
                    <br/>Please leave a message and we’ll typically return your call within a few hours.
                </p>
              </article>

              <article className="info">
                <img src="https://cdn.shopify.com/s/files/1/1244/2630/files/stoberi_returns_40.gif?v=1480127366" alt="returns" className="info__image"/>
                <h3>RETURNS & EXCHANGE</h3>
                <p>Want to check out a different ring size? Interested in receiving a different style? We make the process easy. 
                    <br/>Get the ball rolling by using our online return/exchange Portal. If you have other questions about an 
                    <br/>existing order, please contact us at support@pandora.com and share your reason for returning or 
                    <br/>exchanging an item. 
                </p>
              </article>

              <article className="info">
                <img src="https://cdn.shopify.com/s/files/1/1244/2630/files/stoberi_like_40.gif?v=1480127402" alt="follow" className="info__image"/>
                <h3>FOLLOW US</h3>
                <p>We’d love to have you follow and support us on social media as we grow. Please "like" Pandora and <br/> share your stories using the links at the bottom of your screen.
                </p>
              </article>

          </section>

          <Footer/>
        </div>
    )
}
