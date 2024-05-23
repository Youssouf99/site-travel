import React from "react";
import { Select, Option } from "@material-tailwind/react";

const SortOptions = ({ sortOrder, onSortChange }) => {
  return (
    <div className="w-72">
      <Select label="Tri par" value={sortOrder} onChange={onSortChange}>
        <Option value="date_asc">Date croissante</Option>
        <Option value="date_desc">Date décroissante</Option>
        <Option value="price_asc">Prix croissant</Option>
        <Option value="price_desc">Prix décroissant</Option>
      </Select>
    </div>
  );
};

export default SortOptions;
