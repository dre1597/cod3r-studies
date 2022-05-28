import React, { Component } from 'react';
import axios from 'axios';

import Main from '../template/Main';

const headerProps = {
    icon: 'users',
    title: 'Users',
    subtitle: 'Users CRUD: Create, List, Update, Delete',
};

const baseUrl = 'http://localhost:3002/users';
const initialState = {
    user: { name: '', email: '' },
    list: [],
};

export default class UsersCrud extends Component {
    state = { ...initialState };
    clear() {
        this.setState({ user: initialState.user });
    }

    componentDidMount() {
        axios(baseUrl).then((resp) => {
            this.setState({ list: resp.data });
        });
    }

    save() {
        const user = this.state.user;
        const method = user.id ? 'put' : 'post';
        const url = user.id ? `${baseUrl}/${user.id}` : `${baseUrl}`;
        axios[method](url, user).then((resp) => {
            const list = this.getUpdatedList(resp.data);
            this.setState({ user: initialState.user, list });
        });
    }

    getUpdatedList(user, add = true) {
        const list = this.state.list.filter((u) => u.id !== user.id);
        if (add) list.unshift(user);
        return list;
    }

    updateField(event) {
        const user = { ...this.state.user };
        user[event.target.name] = event.target.value;
        this.setState({ user });
    }

    renderForm() {
        return (
            <form>
                <div className='row'>
                    <div className='col-12 col-md-6 p-2'>
                        <div className='form-group'>
                            <label className='form-label' htmlFor=''>
                                Name
                            </label>
                            <input
                                type='text'
                                className='form-control'
                                name='name'
                                value={this.state.user.name}
                                onChange={(event) => this.updateField(event)}
                                placeholder='Type your nome...'
                            />
                        </div>
                    </div>
                    <div className='col-12 col-md-6 p-2'>
                        <div className='form-group'>
                            <label className='form-label' htmlFor=''>
                                Email
                            </label>
                            <input
                                type='email'
                                className='form-control'
                                name='email'
                                value={this.state.user.email}
                                onChange={(event) => this.updateField(event)}
                                placeholder='Type your email...'
                            />
                        </div>
                    </div>
                </div>
                <div className='row'>
                    <div className='col-12 d-flex justify-content-end'>
                        <button
                            className='btn btn-primary'
                            onClick={(event) => this.save(event)}
                        >
                            Save
                        </button>
                        <button
                            className='btn btn-secondary ms-2'
                            onClick={(event) => this.clear(event)}
                        >
                            Cancel
                        </button>
                    </div>
                </div>
            </form>
        );
    }

    load(user) {
        this.setState({ user });
    }
    remove(user) {
        axios.delete(`${baseUrl}/${user.id}`).then((resp) => {
            const list = this.getUpdatedList(user, false);
            this.setState({ list });
        });
    }

    renderTable() {
        return (
            <table className='table mt-4'>
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>{this.renderRows()}</tbody>
            </table>
        );
    }

    renderRows() {
        return this.state.list.map((user) => {
            return (
                <tr key={user.id}>
                    <td>{user.name}</td>
                    <td>{user.email}</td>
                    <td>
                        <button className='btn btn-warning'>
                            <i
                                className='fa fa-pencil'
                                onClick={() => this.load(user)}
                            ></i>
                        </button>
                        <button
                            className='btn btn-danger ms-2'
                            onClick={() => this.remove(user)}
                        >
                            <i className='fa fa-trash'></i>
                        </button>
                    </td>
                </tr>
            );
        });
    }

    render() {
        return (
            <Main {...headerProps}>
                {this.renderForm()}
                {this.renderTable()}
            </Main>
        );
    }
}
