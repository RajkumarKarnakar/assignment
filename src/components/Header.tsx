import React from "react";

interface HeaderProps {
  message: string;
}

const Header: React.FC<HeaderProps> = ({ message }) => {
   
  return <div className="header">{message}</div>;
};

export default Header;
