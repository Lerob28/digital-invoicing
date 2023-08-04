import axios from "axios";
import { useState } from "react";
import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import { useNavigate } from "react-router-dom";

function AddressForm() {

    const [formData, setFormData] = useState({
        street: "",
        city: "",
        state: "",
        zipCode: "",
        country: ""
    });
    const navigate = useNavigate();

    const handleSubmit = (e) => {
        e.preventDefault()
        axios
           .post(`http://localhost:8085/invoicing/api/v1/address/create`, formData)
           .then((res) => {
              console.log("address saved, redirecting to address list page");
                navigate("/address/list")
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
            case 'street':
                savedform.street = value
                break;
            case 'city':
                savedform.city = value
                break;
            case 'state':
                savedform.state = value
                break;
            case 'zipCode':
                savedform.zipCode = value
                break;
            case 'country':
                savedform.country = value
                break;
            default:
                break;
        }
        setFormData(savedform)
    }


  return (
    <Form onSubmit={handleSubmit}>
      <Form.Group className="mb-3">
        <Form.Label>Street</Form.Label>
        <Form.Control 
            type="text" 
            placeholder="Enter street"
            id="formBasicStreet"
            name="street"
            onChange={handleChange}
        />
      </Form.Group>

      <Form.Group className="mb-3">
        <Form.Label>City</Form.Label>
        <Form.Control 
            type="text" 
            placeholder="Enter City" 
            id="formBasicCity"
            name="city"
            onChange={handleChange}
        />
      </Form.Group>

      <Form.Group className="mb-3">
        <Form.Label>State</Form.Label>
        <Form.Control 
            type="text" 
            placeholder="Enter State" 
            id="formBasicState"
            name="state"
            onChange={handleChange}
        />
      </Form.Group>

      <Form.Group className="mb-3">
        <Form.Label>ZipCode</Form.Label>
        <Form.Control 
            type="text" 
            placeholder="Enter ZipCode"
            id="formBasicZipCode"
            name="zipCode"
            onChange={handleChange}
        />
      </Form.Group>

      <Form.Group className="mb-3">
        <Form.Label>Select Country</Form.Label>
        <Form.Select 
            aria-label="Default select"
            id="formBasicCountry"
            name="country"
            onChange={handleChange}
        >
            <option disabled="disabled">choice the country</option>
            <option value="Cameroon">Cameroon</option>
            <option value="Togo">Togo</option>
            <option value="Nigeria">Nigeria</option>
            <option value="Gabon">Gabon</option>
            <option value="Morocco">Morocco</option>
        </Form.Select>
      </Form.Group>

      <Button variant="success" type="submit">
        Save
      </Button>
    </Form>
  );
}

export default AddressForm;