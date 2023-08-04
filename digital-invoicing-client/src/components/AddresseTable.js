import { useEffect, useState } from "react";
import Table from "react-bootstrap/Table";
import Dropdown from "react-bootstrap/Dropdown";
import {
  faPen,
  faTrash,
} from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import axios from "axios";
import { useNavigate } from "react-router-dom";



function AddresseTable() {

  const [addressList, setAddress] = useState([])
  const navigate = useNavigate();

  const createData = (rang, id, street, city, country, zipCode, state) => {
    return { rang, id, street, city, country, zipCode, state }
  }

  const handleDeleteAddress = (addressId) => {
    console.log(`address to delete : ${addressId}`);
        axios
        .delete(`http://localhost:8085/invoicing/api/v1/address/delete/${addressId}`)
        .then((res) => {
            navigate("/")
        })
        .catch((e) => {
            console.log(e)
        })
  }

  useEffect((rows) => {
    const rowData = []
    axios
      .get("http://localhost:8085/invoicing/api/v1/address/all")
      .then((res) => {
        setAddress([])
        const data = res.data
        data.map((address, index) => {
          console.log("address ........")
          console.log(address)
          return rowData.push(
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
        setAddress(rowData)
      })
      .catch((e) => {
        console.log(e)
      })
  }, [])

  return (
    <Table striped bordered hover>
      <thead>
        <tr>
          <th>#</th>
          <th>Street</th>
          <th>City</th>
          <th>Country</th>
          <th>State</th>
          <th>Zip Code</th>
          <th></th>
        </tr>
      </thead>
      <tbody>
        {addressList.map((row) => (
          <tr key={row.id}>
            <td>{row.rang}</td>
            <td>{row.street}</td>
            <td>{row.city}</td>
            <td>{row.state}</td>
            <td>{row.zipCode}</td>
            <td>{row.country}</td>
            <td>
              <Dropdown>
                <Dropdown.Toggle variant="Secondary" id="dropdown-basic">
                  Action
                </Dropdown.Toggle>

                <Dropdown.Menu>
                  <Dropdown.Item href="">
                    <button
                      className="btn btn-outline-success"
                      onClick={
                        () => {}
                      }
                    >
                      edit
                      <FontAwesomeIcon icon={faPen}></FontAwesomeIcon>
                    </button>
                  </Dropdown.Item>
                  <Dropdown.Item href="">
                    <button
                      className="btn btn-outline-danger"
                      onClick={(e) => handleDeleteAddress(row.id, e)}
                    >
                      delete
                      <FontAwesomeIcon icon={faTrash}></FontAwesomeIcon>
                    </button>
                  </Dropdown.Item>
                </Dropdown.Menu>
              </Dropdown>
            </td>
          </tr>
        ))}
      </tbody>
    </Table>
  );
}

export default AddresseTable;
