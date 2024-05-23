import { Input } from "@material-tailwind/react";
import React from "react";

const Payment = ({ payment, onPaymentChange }) => {
  const { cardNumber, expirationDate, cvv } = payment;
  const handleChange = (event) => {
    event.preventDefault();
    onPaymentChange(event);
  };

  return (
    <>
      <Input
        label="Card Number"
        id="cardNumber"
        name="cardNumber"
        type="text"
        value={cardNumber}
        onChange={handleChange}
        required
      />
      <Input
        label="Expiration Date"
        id="expirationDate"
        name="expirationDate"
        type="text"
        value={expirationDate}
        onChange={handleChange}
        required
      />
      <Input
        label="CVV"
        id="cvv"
        name="cvv"
        type="text"
        value={cvv}
        onChange={handleChange}
        required
      />
    </>
  );
};

export default Payment;
