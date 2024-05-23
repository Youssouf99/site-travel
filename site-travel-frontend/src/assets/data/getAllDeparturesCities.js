import axios from "axios";

const getAllDeparturesCities = async () => {
  try {
    const response = await axios.get(
      `${process.env.REACT_APP_URL_API_BASE}/travels/departuresCities`
    );
    return response.data;
  } catch (error) {
    throw new Error(error.message);
  }
};

export default getAllDeparturesCities;
