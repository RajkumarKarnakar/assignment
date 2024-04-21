import React from 'react';
import PlotComponent from './PlotComponent';
import generateSampleData from './generateSampleData'; // Import the sample data generating function

const App = () => {
  const data = generateSampleData(); // Generate sample data

  return (
    <div>
      <h1>Sample Data Visualization</h1>
      <PlotComponent data={data} />
    </div>
  );
};

export default App;