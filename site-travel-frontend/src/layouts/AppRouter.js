import React from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Header from "./Header";
import Footer from "./Footer";
import NotFound from "../page/NotFound";
import Hotel from "../page/Hotel";
import Activity from "../page/Activity";
import Flight from "../page/Flight";
import Travel from "../page/Travel";

const AppRouter = () => {
  return (
    <BrowserRouter>
      <Header />
      <main>
        <Routes>
          <Route path="/" element={<Travel />} />
          <Route path="/vols" element={<Flight />} />
          <Route path="/hotels" element={<Hotel />} />
          <Route path="/Activites" element={<Activity />} />
          <Route path="/*" element={<NotFound />} />
        </Routes>
      </main>
      <Footer />
    </BrowserRouter>
  );
};

export default AppRouter;
