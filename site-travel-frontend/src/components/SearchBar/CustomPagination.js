import { Button, IconButton } from "@material-tailwind/react";
import { ArrowLeftIcon, ArrowRightIcon } from "@mui/x-date-pickers";
import React from "react";

const CustomPagination = ({ currentPage, totalPages, onPageChange }) => {
  const renderPageButtons = () => {
    const buttons = [];
    for (let i = 0; i <= totalPages - 1; i++) {
      buttons.push(
        <IconButton
          key={i}
          onClick={() => onPageChange(i)}
          variant={currentPage === i ? "filled" : "text"}
          color="gray"
        >
          {i}
        </IconButton>
      );
    }
    return buttons;
  };

  return (
    <div className="flex flex-col sm:flex-row items-center justify-center gap-4 p-4">
      <Button
        variant="text"
        className="flex items-center gap-2"
        onClick={() => onPageChange(currentPage - 1)}
        disabled={currentPage === 0}
      >
        <ArrowLeftIcon strokeWidth={2} className="h-4 w-4" /> Previous
      </Button>
      <div className="flex flex-wrap justify-center gap-2">
        {renderPageButtons()}
      </div>
      <Button
        variant="text"
        className="flex items-center gap-2"
        onClick={() => onPageChange(currentPage + 1)}
        disabled={currentPage === totalPages - 1}
      >
        Next <ArrowRightIcon strokeWidth={2} className="h-4 w-4" />
      </Button>
    </div>
  );
};

export default CustomPagination;
