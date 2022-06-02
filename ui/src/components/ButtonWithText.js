import React from "react";

export default class Counter extends React.Component {
    constructor(props) {
        super(props)
        this.state = { counter: 0 }
    }

    count = (e) => {
        this.setState({ counter: this.state.counter + 1 })
    }

    render() {
        return (
            <>
                <span>{this.state.counter ? this.state.counter : this.props.text }</span>
                <button onClick={this.count}>Paspausk</button>
            </>
        )
    }
}