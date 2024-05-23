import axios from "axios";

const getAllDestinationCities = async () => {
  try {
    const response = await axios.get(
      `${process.env.REACT_APP_URL_API_BASE}/travels/cities`
    );
    return response.data;
  } catch (error) {
    throw new Error(error.message);
  }
};

export default getAllDestinationCities;
