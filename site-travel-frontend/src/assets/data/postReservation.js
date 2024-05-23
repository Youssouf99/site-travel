import axios from "axios";

const postReservation = async (customer, travel, payment) => {
  try {
    // Créer un utilisateur
    const { data: userData } = await axios.post(
      `${process.env.REACT_APP_URL_API_BASE}/users`,
      customer
    );

    // Créer une réservation
    const { data: reservationData } = await axios.post(
      `${process.env.REACT_APP_URL_API_BASE}/reservations?userId=${userData.id}&travelId=${travel.id}`
    );

    console.log(reservationData);

    // Effectuer le paiement
    const { data: paymentData } = await axios.post(
      `${process.env.REACT_APP_URL_API_BASE}/payments?idReservation=${reservationData.id}&amount=${reservationData.priceTotal}`,
      {
        cardNumber: payment.cardNumber,
        cardExpiry: payment.expirationDate,
        cardCvvSecret: payment.cvv,
      }
    );
    console.log(paymentData);
    return paymentData;
  } catch (error) {
    throw new Error(error.message);
  }
};

export default postReservation;
