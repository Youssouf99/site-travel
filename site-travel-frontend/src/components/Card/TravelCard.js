import {
  Button,
  Card,
  CardBody,
  CardFooter,
  CardHeader,
  Typography,
} from "@material-tailwind/react";
import React, { useState } from "react";
import Reservation from "../Payment/Reservation";
import Modal from "../Modal/Modal";

const TravelCard = ({ travel, onReservation }) => {
  const {
    name,
    description,
    startDate,
    endDate,
    price,
    imageUrl,
    numberOfStars,
  } = travel;
  const [openReservation, setOpenReservation] = useState(false);

  const handleOpenReservation = () => {
    setOpenReservation((cur) => !cur);
    if (onReservation) {
      onReservation(travel);
    }
  };

  return (
    <Card className="w-full md:max-w-[38rem] lg:max-w-[50rem] flex flex-col md:flex-row mx-auto">
      <CardHeader className="m-0 w-full md:w-2/5 shrink-0 md:rounded-t-none lg:h-auto md:h-[20rem] overflow-hidden">
        <div className="lg:h-15 md:h-full w-full overflow-hidden">
          <img
            src={imageUrl}
            alt={name}
            className="h-full w-full object-cover"
          />
        </div>
      </CardHeader>
      <CardBody className=" bg-[#f7f7f7]">
        <div className="mb-3 flex items-center justify-between">
          <Typography variant="h5" color="blue-gray" className="font-medium">
            {name}
          </Typography>
          <Typography
            color="blue-gray"
            className="flex items-center gap-1.5 font-normal"
          >
            <svg
              xmlns="http://www.w3.org/2000/svg"
              viewBox="0 0 24 24"
              fill="currentColor"
              className="-mt-0.5 h-5 w-5 text-yellow-700"
            >
              <path
                fillRule="evenodd"
                d="M10.788 3.21c.448-1.077 1.976-1.077 2.424 0l2.082 5.007 5.404.433c1.164.093 1.636 1.545.749 2.305l-4.117 3.527 1.257 5.273c.271 1.136-.964 2.033-1.96 1.425L12 18.354 7.373 21.18c-.996.608-2.231-.29-1.96-1.425l1.257-5.273-4.117-3.527c-.887-.76-.415-2.212.749-2.305l5.404-.433 2.082-5.006z"
                clipRule="evenodd"
              />
            </svg>
            {numberOfStars}.0
          </Typography>
        </div>
        <Typography variant="paragraph" color="gray" className="mb-5">
          {description}
        </Typography>
        <hr className="my-3" />

        <div className="flex items-center gap-4">
          <Typography variant="small" color="gray" className="text-xs">
            Début le: {startDate}
          </Typography>
          <Typography variant="small" color="gray" className="text-xs">
            Sortir le: {endDate}
          </Typography>
        </div>
      </CardBody>

      <CardBody className="flex flex-col gap-4">
        <Button
          variant="gradient"
          color="light-blue"
          onClick={handleOpenReservation}
        >
          Reservation
        </Button>
        <Modal open={openReservation} handleOpen={handleOpenReservation}>
          <Reservation handleOpen={handleOpenReservation} travel={travel} />
        </Modal>

        <CardFooter>
          <Typography variant="h5">
            <span className="mt-2 text-xl">€ {price}</span>
          </Typography>
        </CardFooter>
      </CardBody>
    </Card>
  );
};

export default TravelCard;
