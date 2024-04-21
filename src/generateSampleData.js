const generateSampleData = () => {
    const data = [];
    const startDate = new Date(); // Start date
  
    for (let i = 0; i < 100; i++) {
      const timestamp = new Date(startDate.getTime() + i * 60 * 1000); // Increment timestamp by 1 minute
      const machineStatus = Math.random() < 0.5 ? 0 : 1; // Randomly generate machine status (0 or 1)
      data.push({ ts: timestamp, machine_status: machineStatus });
    }
  
    return data;
  };
  
  export default generateSampleData;
  