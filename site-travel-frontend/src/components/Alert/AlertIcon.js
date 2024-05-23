import { Alert } from "@material-tailwind/react";
import React from "react";
import IconSolid from "../Icons/IconSolid";

const AlertIcon = ({ children }) => {
  return (
    <Alert variant="ghost" icon={<IconSolid />}>
      {children}
    </Alert>
  );
};

export default AlertIcon;
