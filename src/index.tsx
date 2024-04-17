import React from "react";
import ReactDOM from "react-dom";
import App from "../src/components/App"



let element = document.getElementById("app");

if (element !== null) {
  ReactDOM.render(<App />, element);
}