import { Dialog } from "@material-tailwind/react";
import React from "react";

const Modal = ({ open, handleOpen, children }) => {
  return (
    <Dialog
      size="xs"
      open={open}
      handler={handleOpen}
      className="bg-transparent shadow-none"
    >
      {children}
    </Dialog>
  );
};

export default Modal;
