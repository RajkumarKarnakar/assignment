import React, { useState, useEffect, useRef } from 'react';
import { Chart, registerables } from 'chart.js'; // Import Chart and registerables
import { format, min, max } from 'date-fns'; // Import format, min, and max functions from date-fns
import 'chartjs-adapter-date-fns'; // Import and register date-fns adapter

Chart.register(...registerables); // Register necessary modules

const PlotComponent = ({ data }) => {
  const [timeInterval, setTimeInterval] = useState('1hr');
  const chartRef = useRef(null); // Ref for the chart instance
  const canvasRef = useRef(null); // Ref for the canvas element

  useEffect(() => {
    // Destroy existing chart instance when component unmounts
    return () => {
      if (chartRef.current) {
        chartRef.current.destroy();
      }
    };
  }, []);

  const getColor = (status) => {
    if (status === 0) {
      return 'yellow'; // Yellow for sample is 0
    } else if (status === 1) {
      return 'green'; // Green for sample is 1
    } else {
      return 'red'; // Red for missing data
    }
  };

  const updateChart = () => {
    if (canvasRef.current && data.length > 0) {
      // If canvas element exists and data is not empty
      const ctx = canvasRef.current.getContext('2d');

      // Destroy existing chart instance if it exists
      if (chartRef.current) {
        chartRef.current.destroy();
      }

      // Set canvas size to 20 pixels width and height
      canvasRef.current.width = 20;
      canvasRef.current.height = 20;

      // Get minimum and maximum timestamps from data
      const minTimestamp = min(data.map(entry => new Date(entry.ts)));
      const maxTimestamp = max(data.map(entry => new Date(entry.ts)));

      // Create new chart instance
      chartRef.current = new Chart(ctx, {
        type: 'bar', // Use bar chart type
        data: {
          labels: data.map(entry => format(new Date(entry.ts), 'yyyy-MM-dd HH:mm:ss')), // Format labels as timestamps
          datasets: [
            {
              label: 'Machine Status',
              data: data.map(entry => entry.machine_status),
              backgroundColor: data.map(entry => getColor(entry.machine_status)), // Generate backgroundColor based on machine status
              yAxisID: 'status-y-axis'
            }
          ]
        },
        options: {
          scales: {
            x: {
              type: 'time', // Use 'time' type for time scale
              time: {
                min: minTimestamp, // Set minimum timestamp
                max: maxTimestamp, // Set maximum timestamp
                displayFormats: {
                  second: 'HH:mm:ss' // Display format for seconds
                }
              }
            },
            y: {
              ticks: {
                stepSize: 1 // Step size for y-axis
              }
            }
          },
          plugins: {
            legend: {
              display: false // Hide the legend
            },
            tooltip: {
              enabled: false // Disable tooltip
            }
          }
        }
      });
    }
  };

  useEffect(() => {
    updateChart();
  }, [data, timeInterval]);

  const SummaryReport = () => {
    // Calculate summary statistics
    const numZeros = data.filter(entry => entry.machine_status === 0).length;
    const numOnes = data.filter(entry => entry.machine_status === 1).length;
    const numContinuousZeros = countContinuous(data.map(entry => entry.machine_status), 0);
    const numContinuousOnes = countContinuous(data.map(entry => entry.machine_status), 1);

    return (
      <div>
        <h3>Summary Report</h3>
        <table>
          <tbody>
            <tr>
              <td>Number of 0s</td>
              <td>{numZeros}</td>
            </tr>
            <tr>
              <td>Number of 1s</td>
              <td>{numOnes}</td>
            </tr>
            <tr>
              <td>Number of Continuous 0s</td>
              <td>{numContinuousZeros}</td>
            </tr>
            <tr>
              <td>Number of Continuous 1s</td>
              <td>{numContinuousOnes}</td>
            </tr>
          </tbody>
        </table>
      </div>
    );
  };

  return (
    <div>
      <h2>Data Visualization</h2>
      <div>
        <button onClick={() => setTimeInterval('1hr')}>1hr</button>
        <button onClick={() => setTimeInterval('8hr')}>8hr</button>
        <button onClick={() => setTimeInterval('24hr')}>24hr</button>
      </div>
      <canvas id="myChart" ref={canvasRef} style={{ width: '100%', height: '20px' }} /> {/* Canvas element for the chart */}
      <SummaryReport />
    </div>
  );
};

const countContinuous = (arr, target) => {
  let count = 0;
  let maxCount = 0;
  for (let i = 0; i < arr.length; i++) {
    if (arr[i] === target) {
      count++;
      maxCount = Math.max(maxCount, count);
    } else {
      count = 0;
    }
  }
  return maxCount;
};

export default PlotComponent;
