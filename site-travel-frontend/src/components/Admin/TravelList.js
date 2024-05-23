import React, { useState, useEffect } from "react";
import axios from "axios";
import TravelCard from "../Card/TravelCard";

const TravelList = () => {
  const [travels, setTravels] = useState([]);

  useEffect(() => {
    axios
      .get("http://localhost:8081/api/travels")
      .then((response) => {
        setTravels(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }, []);

  return (
    <div className="px-4 py-16">
      <div className="flex flex-col justify-center items-center gap-4">
        {travels.map((travel) => (
          <TravelCard key={travel.id} travel={travel} />
        ))}
      </div>
    </div>
  );
};

export default TravelList;
