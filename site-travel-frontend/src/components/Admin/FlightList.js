import React, { useEffect, useState } from "react";
import TravelCard from "../Card/TravelCard";
import { Alert } from "@material-tailwind/react";
import getTravel from "../../assets/data/getTravel";

const FlightList = () => {
  const [flights, setFlights] = useState([]);
  const [error, setError] = useState(null);

  useEffect(() => {
    getTravel("flights")
      .then((data) => {
        console.log("Response : ", data);
        setFlights(data);
      })
      .catch((error) => {
        setError(error.message);
      });
  }, []);

  return (
    <div className="px-4 py-16">
      <div className="flex flex-col justify-center items-center gap-4">
        {flights.map((flight) => (
          <TravelCard key={flight.id} travel={flight} />
        ))}
      </div>
      {error && <Alert color="red">{error}</Alert>}
      {flights.length === 0 && (
        <Alert color="blue" className="justify-center items-center mt-8">
          "Pas de Vol disponible"
        </Alert>
      )}
    </div>
  );
};

export default FlightList;
