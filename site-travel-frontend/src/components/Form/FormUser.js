import { Input } from "@material-tailwind/react";
import React from "react";

const FormUser = ({ customer, handleChange }) => {
  return (
    <>
      <Input
        label="Prénom"
        id="firstName"
        name="firstName"
        type="text"
        value={customer.firstName}
        onChange={handleChange}
        required
      />

      <Input
        label="Nom"
        id="lastName"
        name="lastName"
        type="text"
        value={customer.lastName}
        onChange={handleChange}
        required
      />
      <Input
        label="Email"
        id="email"
        name="email"
        type="email"
        value={customer.email}
        onChange={handleChange}
        required
      />
      <Input
        label="Phone"
        id="phone"
        name="phone"
        type="tel"
        value={customer.phone}
        onChange={handleChange}
        required
      />
    </>
  );
};

export default FormUser;
