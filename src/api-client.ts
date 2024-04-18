import axios from "axios";

import { API_SERVER_URL } from "./public-config";

export const fetchedData = async () => {
  const resp = await axios.get(`${API_SERVER_URL}/sample`);
// data will come here in data 
  return resp.data.sample;
};
