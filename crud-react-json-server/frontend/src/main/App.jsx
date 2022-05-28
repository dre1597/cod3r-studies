/* eslint-disable import/no-anonymous-default-export */
import 'bootstrap/dist/css/bootstrap.min.css';
import 'font-awesome/css/font-awesome.min.css';
import './App.css';
import React from 'react';
import { HashRouter } from 'react-router-dom';

/* Poderia ser usado o BrowserRouter que ai tiraria o #, mas da uns BO em produção*/

import Routes from './Routes';

import Logo from '../components/template/Logo';
import Nav from '../components/template/Nav';
import Footer from '../components/template/Footer';

export default (props) => (
    <HashRouter>
        <div className='app'>
            <Logo />
            <Nav />
            <Routes />
            <Footer />
        </div>
    </HashRouter>
);
