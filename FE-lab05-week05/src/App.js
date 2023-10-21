import Candidate from "./component/candidate/Candidate";
import Address from "./component/address/Address";
import Navbar from "./component/navbar/Navbar";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import { SnackbarProvider } from 'notistack'

import React from "react";

function App() {
  return (
    <SnackbarProvider>
      <BrowserRouter>
        <Navbar />
        <Routes>
          <Route path="/address" element={<Address />} />
          <Route path="/candidate" element={<Candidate />} />
        </Routes>
      </BrowserRouter>
    </SnackbarProvider>

  );
}

export default App;
