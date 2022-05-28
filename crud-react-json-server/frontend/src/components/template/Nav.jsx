/* eslint-disable import/no-anonymous-default-export */
import './Nav.css';
import React from 'react';
import NavMain from './NavMain';

export default (props) => (
    <aside className='menu-area'>
        <nav className='menu'>
            <NavMain link='/' icon='home' label=' Home' />
            <NavMain link='/users' icon='users' label=' Users' />
        </nav>
    </aside>
);
