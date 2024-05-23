import React from "react";
import { Autocomplete, TextField } from "@mui/material";

const DestinationAutocomplete = ({
  destination,
  setDestination,
  destinationCities,
}) => (
  <Autocomplete
    options={destinationCities}
    getOptionLabel={(option) => option}
    value={destination}
    onChange={(event, newValue) => setDestination(newValue)}
    isOptionEqualToValue={(option, value) => option === value || value === ""}
    renderInput={(params) => (
      <TextField
        {...params}
        label={<span style={{ fontSize: 10 }}>Rechercher par destination</span>}
        variant="outlined"
        className="w-full"
      />
    )}
    className="w-72 md:w-5/12 p-2 border border-gray-300 rounded-md"
  />
);

export default DestinationAutocomplete;
