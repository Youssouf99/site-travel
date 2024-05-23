import React, { useEffect, useState } from "react";
import TravelCard from "../Card/TravelCard";
import { Alert } from "@material-tailwind/react";
import getTravel from "../../assets/data/getTravel";

const ActivityList = () => {
  const [activities, setActivities] = useState([]);
  const [error, setError] = useState(null);

  useEffect(() => {
    getTravel("activities")
      .then((data) => {
        setActivities(data);
      })
      .catch((error) => {
        setError(error.message);
      });
  }, []);

  return (
    <div className="px-4 py-16">
      <div className="flex flex-col justify-center items-center gap-4">
        {activities.map((activity) => (
          <TravelCard key={activity.id} travel={activity} />
        ))}
      </div>
      {error && (
        <Alert color="red" className="justify-center items-center mt-8">
          {error}
        </Alert>
      )}
      {activities.length === 0 && (
        <Alert color="blue" className="justify-center items-center mt-8">
          "Pas d'activité disponible"
        </Alert>
      )}
    </div>
  );
};

export default ActivityList;
