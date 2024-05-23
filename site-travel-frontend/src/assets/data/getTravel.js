import axios from "axios";

const getTravel = async (travel) => {
  try {
    const response = await axios.get(
      `${process.env.REACT_APP_URL_API_BASE}/${travel}`
    );
    return response.data;
  } catch (error) {
    throw new Error(error.message);
  }
};

export default getTravel;
