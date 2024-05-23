import React, { useEffect, useState } from "react";
import TravelCard from "../Card/TravelCard";
import { Alert } from "@material-tailwind/react";
import getTravel from "../../assets/data/getTravel";

const HotelList = () => {
  const [hotels, setHotels] = useState([]);
  const [error, setError] = useState(null);

  useEffect(() => {
    getTravel("hotels")
      .then((data) => {
        setHotels(data);
      })
      .catch((error) => {
        setError(error.message);
      });
  }, []);

  return (
    <div className="px-4 py-16">
      <div className="flex flex-col justify-center items-center gap-4">
        {hotels.map((hotel) => (
          <TravelCard key={hotel.id} travel={hotel} />
        ))}
      </div>
      {error && <Alert color="red">{error}</Alert>}
      {hotels.length === 0 && (
        <Alert color="blue" className="justify-center items-center mt-8">
          "Pas d'hotel disponible"
        </Alert>
      )}
    </div>
  );
};

export default HotelList;
