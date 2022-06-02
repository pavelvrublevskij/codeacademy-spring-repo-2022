import React from "react";

export default class MyAwesomeComponent extends React.Component {
    constructor(props) {
        super(props);
        this.state = { name: "World" }
    }

    render() {
        return (
            <>
                <input type="text" name="name"/>
                <h1>Hello, {this.state.name}!</h1>
            </>
        );
    }
}