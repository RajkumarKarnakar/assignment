import React from "react";
import ReactDOM from "react-dom";

const App = () => {
  return <div>Hello React</div>;
};

let element = document.getElementById("app");

if (element !== null) {
  ReactDOM.render(<App />, element);
}