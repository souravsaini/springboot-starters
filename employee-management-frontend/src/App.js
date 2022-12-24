import "./App.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Navbar from "./components/Navbar";
import EmployeeAdd from "./components/EmployeeAdd";
import ListEmployee from "./components/ListEmployee";
import EmployeeUpdate from "./components/EmployeeUpdate";

function App() {
  return (
    <>
      <BrowserRouter>
        <Navbar />
        <Routes>
          <Route index element={<ListEmployee />} />
          <Route path="/" element={<ListEmployee />} />
          <Route path="/addEmployee" element={<EmployeeAdd />} />
          <Route path="/editEmployee/:id" element={<EmployeeUpdate />} />
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
