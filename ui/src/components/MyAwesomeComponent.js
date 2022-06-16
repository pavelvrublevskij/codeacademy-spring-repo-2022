import React from "react";

export default class MyAwesomeComponent extends React.Component {
    constructor(props) {
        super(props);
        this.state = { name: this.props.name }
    }

    onChange = (e) => {
        this.setState({ name: e.target.value })
    }

    componentDidMount() {
        console.log("mounted")
    }

    componentDidUpdate() {
        console.log("updated")
    }

    render() {
        return (
            <>
                <input onChange={this.onChange} />
                <h1>Hello, {this.state.name}!</h1>
            </>
        );
    }
}