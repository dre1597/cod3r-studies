/* eslint-disable import/no-anonymous-default-export */
import './NavMain.css';
import React from 'react';
import { Link } from 'react-router-dom';

export default (props) => (
    <Link className='link' to={props.link}>
        <i className={`fa fa-${props.icon}`}>{props.label}</i>
    </Link>
);
