import {
  Alert,
  Button,
  Card,
  CardBody,
  CardFooter,
  Chip,
  Spinner,
  Typography,
} from "@material-tailwind/react";
import React, { useState } from "react";
import Payment from "./Payment";
import AlertIcon from "../Alert/AlertIcon";
import postReservation from "../../assets/data/postReservation";
import FormUser from "../Form/FormUser";
import Modal from "../Modal/Modal";

const Reservation = ({ travel }) => {
  const { name, startDate, endDate, price, hotelName } = travel;
  const [error, setError] = useState(null);
  const [loading, setLoading] = useState(false);
  const [message, setMessage] = useState(null);
  const [openAlert, setOpenAlert] = useState(false);

  const [customer, setCustomer] = useState({
    firstName: "",
    lastName: "",
    email: "",
    phone: "",
  });

  const [payment, setPayment] = useState({
    cardNumber: "",
    expirationDate: "",
    cvv: "",
  });

  const travelName = hotelName;
  const handleChange = (event) => {
    setCustomer({
      ...customer,
      [event.target.name]: event.target.value,
    });
  };

  const handlePaymentChange = (event) => {
    setPayment({
      ...payment,
      [event.target.name]: event.target.value,
    });
  };

  const handleSubmit = async () => {
    setOpenAlert((cur) => !cur);
    if (!openAlert) {
      try {
        setLoading(true);
        await postReservation(customer, travel, payment);
        setMessage("Reservation created successfully!");
      } catch (error) {
        setError(error.message);
      } finally {
        setLoading(false);
      }
    }
  };

  return (
    <Card className="mx-auto w-full max-w-[24rem]">
      <CardBody className="flex flex-col gap-4">
        <Typography className="flex gap-2" variant="h4" color="blue-gray">
          <span>Réservation {name}</span>
        </Typography>
        <Typography className="mb-3 font-normal" variant="h6" color="gray">
          Saisissez vos coordonnées personnelles.
          {message && <p>{message}</p>}
        </Typography>
        <FormUser customer={customer} handleChange={handleChange} />
        <Typography className="mb-3 font-normal flex gap-2" variant="h6">
          <span>Paiement de </span>
          <Chip color="blue" value={`${price}€`} />
        </Typography>
        <Payment payment={payment} onPaymentChange={handlePaymentChange} />

        <AlertIcon>
          <Typography className="-mb-2" variant="h6">
            <p className="text-sm">Vous avez réserver {travelName}</p>
            <p className="text-xs">{`de ${startDate} au  ${endDate}`}</p>
          </Typography>
        </AlertIcon>
      </CardBody>
      <CardFooter className="pt-0">
        <Button
          type="submit"
          onClick={handleSubmit}
          variant="gradient"
          fullWidth
          color="blue"
        >
          Valider ma reservation
        </Button>
        <Modal open={openAlert} handleOpen={handleSubmit}>
          {loading && (
            <div className="flex justify-center">
              <Spinner className="h-16 w-16 text-gray-900/50" />
            </div>
          )}
          {message && <Alert color="green">{message}</Alert>}
          {error && <Alert color="red">{error}</Alert>}
        </Modal>
      </CardFooter>
    </Card>
  );
};

export default Reservation;
