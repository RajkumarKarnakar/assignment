import React, { useEffect, useState } from "react";
import Header from "./Header";
import { fetchedData } from "../api-client";
import DataChart from "./DataChart";

const App = () => {
  const [data, setData] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      const result = await fetchedData();
      setData(result);
      console.log(result)
    };

    fetchData();
  }, []);

  return(
    <div className="container">
      <Header message="hello from rajkumar"></Header>
      {/* <DataChart data={data} /> */}
    </div>
  );
};

export default App;
