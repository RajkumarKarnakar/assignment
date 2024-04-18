import React from 'react';
import { Line } from 'react-chartjs-2';

type DataItem = {
  ts: {
    type: Date,
    required: true
  },
  machine_status: {
    type: Number,
    required: true
  },
  vibration: {
    type: Number,
    required: true
  }
};

type DataChartProps = {
  data: DataItem[];
};

const DataChart: React.FC<DataChartProps> = ({ data }) => {
  // Prepare data for plotting
  const chartData = {
    labels: data.map(item => item.ts),
    datasets: [{
      label: 'Machine Status',
      data: data.map(item => item.machine_status),
      backgroundColor: 'rgba(75,192,192,0.2)',
      borderColor: 'rgba(75,192,192,1)',
      borderWidth: 1
    }]
  };

  return (
    <div>
      <h2>Machine Status Plot</h2>
      <Line data={chartData} />
    </div>
  );
};

export default DataChart;