import React from "react";
import { Link } from "react-router-dom";
import logo from "../assets/images/logo.png";
import "./Header.css";
import { Tab, Tabs, TabsHeader } from "@material-tailwind/react";

const Header = () => {
  const defaultPathName =
    window.location.pathname === "/" ? "/tesla-news" : window.location.pathname;
  return (
    <header className="h-20 gradient-background bg-gray-800 from-indigo-500 to-blue-600 text-white py-4 px-4 flex justify-between items-center">
      <div className="text-lg font-bold">
        <img src={logo} alt="Your Company Logo" className="h-20 mr-8" />
      </div>
      <nav className="flex-grow flex gap-4 justify-center">
        <div className="flex w-max gap-4">
          <Tabs value={defaultPathName}>
            <TabsHeader>
              <Link to="" className="hover:text-gray-200">
                <Tab value={""}>Voyages</Tab>
              </Link>
              <Link to="/vols" className="hover:text-gray-200">
                <Tab value={"/vols"}>Vols</Tab>
              </Link>
              <Link to="/hotels" className="hover:text-gray-200">
                <Tab value={"/hotels"}>Hotels</Tab>
              </Link>
              <Link to="/activites" className="hover:text-gray-200">
                <Tab value={"/activites"}>Activités</Tab>
              </Link>
            </TabsHeader>
          </Tabs>
        </div>
      </nav>
      <div className="text-lg font-bold">
        <img src={logo} alt="Your Company Logo" className="h-20 mr-8" />
      </div>
    </header>
  );
};

export default Header;
