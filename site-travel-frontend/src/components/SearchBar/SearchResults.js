import React from "react";
import { Spinner, Alert } from "@material-tailwind/react";
import TravelCard from "../Card/TravelCard";

const SearchResults = ({ isLoading, travels, error }) => {
  return (
    <div className="flex flex-col justify-center items-center gap-4">
      {isLoading && <Spinner className="h-16 w-16" color="green" />}
      {!isLoading && travels.length > 0
        ? travels.map((travel) => (
            <TravelCard key={travel.id} travel={travel} />
          ))
        : !isLoading && (
            <Alert color="blue" className="justify-center items-center mt-8">
              Aucun voyage trouvé
            </Alert>
          )}
      {error && <Alert color="red">{error}</Alert>}
    </div>
  );
};
export default SearchResults;
