import axios from "axios";
import { useEffect, useState } from "react";
import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import { Navigate } from "react-router-dom";

function CustomerForm() {

    const [formData, setFormData] = useState({
      name: "",
      email: "",
      phone: "",
      address: 0
    });
    const [addressList, setAddress] = useState([])

    const createData = (rang, id, street, city, country, zipCode, state) => {
      return { rang, id, street, city, country, zipCode, state }
    }

    const handleSubmit = (e) => {
      console.log(formData);
      e.preventDefault()
      axios
        .post(`http://localhost:8085/invoicing/api/v1/customer/create`, formData)
        .then((res) => {
          <Navigate to="/customer/list" />
        })
        .catch((error) => {
          console.log(e)
        })
    }

    const handleChange = (e) => {
        let name = e.target.name,
           value = e.target.value.trim()

        const savedform = formData
        switch (name) {
            case 'name':
                savedform.name = value
                break;
            case 'email':
                savedform.email = value
                break;
            case 'phone':
                savedform.phone = value
                break;
            case 'address':
                savedform.address = value
                break;
            default:
                break;
        }
        setFormData(savedform)
    }

    useEffect((rows) => {
      axios
        .get("http://localhost:8085/invoicing/api/v1/address/all")
        .then((res) => {
          setAddress([])
          const data = res.data
          data.map((address, index) => {
              console.log(address)
            return rows.push(
              createData(
                index + 1,
                address.id,
                address.street,
                address.city,
                address.zipCode,
                address.state,
                address.country
              )
            )
          })
          setAddress(rows)
        })
        .catch((e) => {
          console.log(e)
        })
    }, [])


  return (
    <Form onSubmit={handleSubmit}>
      <Form.Group className="mb-3">
        <Form.Label>Name</Form.Label>
        <Form.Control 
            type="text" 
            placeholder="Enter Name"
            id="formBasicName"
            name="name"
            onChange={handleChange}
        />
      </Form.Group>

      <Form.Group className="mb-3">
        <Form.Label>Email</Form.Label>
        <Form.Control 
            type="email" 
            placeholder="Enter Email" 
            id="formBasicEmail"
            name="email"
            onChange={handleChange}
        />
      </Form.Group>

      <Form.Group className="mb-3">
        <Form.Label>Phone</Form.Label>
        <Form.Control 
            type="text" 
            placeholder="Enter phone Number" 
            id="formBasicPhone"
            name="phone"
            onChange={handleChange}
        />
      </Form.Group>

      <Form.Group className="mb-3">
        <Form.Label>Select Address for Customer</Form.Label>
        <Form.Select 
          aria-label="Default select"
          id="formBasicAddress"
          name="address"
          onChange={handleChange}
        >
          <option disabled="disabled">choice the right address for customer</option>
          {addressList.map((row) => (
            <option key={row.id} value={row.id}>{`${row.country}-${row.city}-${row.state}-${row.street}`}</option>
          ))}
          
        </Form.Select>
      </Form.Group>

      <Button variant="success" type="submit">
        Save
      </Button>
    </Form>
  );
}

export default CustomerForm;