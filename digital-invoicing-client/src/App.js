import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter, Route, Routes} from 'react-router-dom';
import Home from './pages/Home';
import { createContext } from 'react';
import AddressList from './pages/AddressList';
import CustomerList from './pages/CustomerList';
import CreateAddress from './pages/CreateAddress';
import CreateCustomer from './pages/CreateCustomer';
import InvoiceList from './pages/InvoiceList';
import CreateInvoice from './pages/CreateInvoice';

export const AppContext = createContext();

function App() {
  
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/address/list" element={<AddressList />} />
        <Route path="/address/add" element={<CreateAddress />} />
        <Route path="/customer/list" element={<CustomerList />} />
        <Route path="/customer/add" element={<CreateCustomer />} />
        <Route path="/invoice/list" element={<InvoiceList />} />
        <Route path="/invoice/add" element={<CreateInvoice />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;