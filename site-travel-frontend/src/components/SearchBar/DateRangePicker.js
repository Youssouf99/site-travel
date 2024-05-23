import React from "react";
import DatePicker, { registerLocale } from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import { fr } from "date-fns/locale";
import { Button } from "@material-tailwind/react";

registerLocale("fr", fr);

const DateRangePicker = ({ dateRange, setDateRange }) => {
  const [startDate, endDate] = dateRange;

  const handleClearDates = () => {
    setDateRange([null, null]);
  };

  return (
    <div className="w-full md:w-5/12">
      <DatePicker
        locale="fr"
        selectsRange
        startDate={startDate}
        endDate={endDate}
        minDate={new Date()}
        dateFormat="dd/MM/yyyy"
        onChange={(update) => setDateRange(update)}
        withPortal
        placeholderText="Sélectionner une plage de dates"
        className="w-60 p-5 border border-gray-300 rounded-md text-xs placeholder-gray-400"
      >
        <Button
          size="sm"
          color={startDate || endDate ? "gray" : "blue-gray"}
          disabled={!(startDate || endDate)}
          onClick={handleClearDates}
          className="!absolute right-20 top-1 rounded"
        >
          X
        </Button>
      </DatePicker>
    </div>
  );
};

export default DateRangePicker;
