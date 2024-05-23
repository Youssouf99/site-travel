import React from "react";
import { Autocomplete, TextField } from "@mui/material";

const DepartureAutocomplete = ({
  departure,
  setDeparture,
  departureCities,
}) => (
  <Autocomplete
    options={departureCities}
    getOptionLabel={(option) => option}
    value={departure}
    onChange={(event, newValue) => setDeparture(newValue)}
    isOptionEqualToValue={(option, value) => option === value || value === ""}
    renderInput={(params) => (
      <TextField
        {...params}
        label={
          <span style={{ fontSize: 10 }}>Rechercher par ville de départ</span>
        }
        variant="outlined"
        className="w-full text-xs"
      />
    )}
    className="w-72 md:w-5/12 p-2 border border-gray-300 rounded-md"
  />
);

export default DepartureAutocomplete;
