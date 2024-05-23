import React from "react";

const Footer = () => {
  return (
    <footer className="gradient-background bg-gray-800 text-white py-4">
      <div className="container mx-auto text-center">
        <p>
          &copy; {new Date().getFullYear()} Vols Hotels & Activités - Travel
          Agency
        </p>
      </div>
    </footer>
  );
};

export default Footer;
