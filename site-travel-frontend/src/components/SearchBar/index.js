import React, { useCallback, useEffect, useState } from "react";
import axios from "axios";
import { Button } from "@material-tailwind/react";
import getAllDestinationCities from "../../assets/data/getAllDestinationCities";
import getAllDeparturesCities from "../../assets/data/getAllDeparturesCities";
import DestinationAutocomplete from "./DestinationAutocomplete";
import DepartureAutocomplete from "./DepartureAutocomplete";
import DateRangePicker from "./DateRangePicker";
import SearchResults from "./SearchResults";
import SortOptions from "./SortOptions";
import CustomPagination from "./CustomPagination";

const SearchBar = ({ travelType }) => {
  const [destination, setDestination] = useState(null);
  const [departure, setDeparture] = useState(null);
  const [travels, setTravels] = useState([]);
  const [dateRange, setDateRange] = useState([null, null]);
  const [destinationCities, setDestinationCities] = useState([]);
  const [departureCities, setDepartureCities] = useState([]);
  const [error, setError] = useState(null);
  const [isLoading, setIsLoading] = useState(false);
  const [startDate, endDate] = dateRange;
  const [sortOrder, setSortOrder] = useState("date_desc");
  const [currentPage, setCurrentPage] = useState(0);
  const [totalPages, setTotalPages] = useState(1);

  useEffect(() => {
    const fetchCities = async () => {
      try {
        const [destinationData, departureData] = await Promise.all([
          getAllDestinationCities(),
          getAllDeparturesCities(),
        ]);
        setDestinationCities(destinationData);
        setDepartureCities(departureData);
      } catch (error) {
        setError(error.message);
      }
    };

    fetchCities();
  }, []);

  const convertFRDateToISO = (frDate) => {
    const [day, month, year] = frDate.split("/");
    return `${year}-${month}-${day}`;
  };

  const handleSearch = useCallback(async () => {
    setIsLoading(true);
    try {
      let url = `/api/travels/search${travelType ? `/${travelType}` : ""}`;
      const params = [];

      if (destination) params.push(`destination=${destination}`);
      if (startDate)
        params.push(
          `startDate=${convertFRDateToISO(
            startDate.toLocaleDateString("fr-FR")
          )}`
        );
      if (endDate)
        params.push(
          `endDate=${convertFRDateToISO(endDate.toLocaleDateString("fr-FR"))}`
        );
      if (travelType === "flights" && departure)
        params.push(`departureCity=${departure}`);

      params.push(`sortField=${sortOrder}`);
      params.push(`page=${currentPage}`);
      params.push(`size=10`);

      if (params.length) url += `?${params.join("&")}`;

      const response = await axios.get(url);
      setTravels(response.data.content);
      setTotalPages(response.data.totalPages);
    } catch (error) {
      console.error("There was an error fetching the travels!", error);
      setError(error.message);
    } finally {
      setIsLoading(false);
    }
  }, [
    travelType,
    destination,
    startDate,
    endDate,
    departure,
    sortOrder,
    currentPage,
  ]);

  useEffect(() => {
    handleSearch();
  }, [handleSearch]);

  const handleSortChange = (value) => {
    setSortOrder(value);
  };

  const handlePageChange = (page) => {
    setCurrentPage(page);
  };

  return (
    <div className="container mx-auto mt-8 p-8 mb-8 bg-white rounded-lg shadow-lg">
      <div className="flex flex-col md:flex-row justify-between items-center gap-4 mb-8">
        <DestinationAutocomplete
          destination={destination}
          setDestination={setDestination}
          destinationCities={destinationCities}
        />
        {travelType === "flights" && (
          <DepartureAutocomplete
            departure={departure}
            setDeparture={setDeparture}
            departureCities={departureCities}
          />
        )}

        <DateRangePicker dateRange={dateRange} setDateRange={setDateRange} />
        <SortOptions sortOrder={sortOrder} onSortChange={handleSortChange} />

        <Button onClick={handleSearch} color="blue" className="w-full">
          Rechercher
        </Button>
      </div>
      <SearchResults isLoading={isLoading} travels={travels} error={error} />
      <CustomPagination
        currentPage={currentPage}
        totalPages={totalPages}
        onPageChange={handlePageChange}
      />
    </div>
  );
};

export default SearchBar;
