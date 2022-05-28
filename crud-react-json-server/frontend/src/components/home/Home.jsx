/* eslint-disable import/no-anonymous-default-export */
import React from 'react';
import Main from '../template/Main';

export default (props) => (
    <Main icon='home' title='Home' subtitle='Crud project from cod3r'>
        <div className='display-4'>Welcome!</div>
        <hr />
        <p className='mb-0'>This is a example of a CRUD project using React!</p>
    </Main>
);
