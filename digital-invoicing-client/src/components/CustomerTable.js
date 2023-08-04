import { useEffect, useState } from "react";
import Table from "react-bootstrap/Table";
import Dropdown from "react-bootstrap/Dropdown";
import {
    faEye,
  faPen,
  faTrash,
} from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import axios from "axios";



function CustomerTable() {
  const [customerList, setCustomer] = useState([]);
  const createData = (rang, id, name, email, phone, address) => {
    return { rang, id, name, email, phone, address };
  };

  useEffect((rows) => {
    axios
      .get("http://localhost:8085/invoicing/api/v1/customer/all")
      .then((res) => {
        setCustomer([])
        const data = res.data;
        data.map((customer, index) => {
          return rows.push(
            createData(
              index + 1,
              customer.id,
              customer.name,
              customer.email,
              customer.phone,
              customer.address
            )
          );
        });
        setCustomer(rows);
      })
      .catch((e) => {
        console.log(e);
      });
  }, []);

  return (
    <Table striped bordered hover>
      <thead>
        <tr>
          <th>#</th>
          <th>Name</th>
          <th>Email</th>
          <th>Phone Number</th>
          <th></th>
        </tr>
      </thead>
      <tbody>
        {customerList.map((row) => (
          <tr key={row.id}>
            <td>{row.rang}</td>
            <td>{row.name}</td>
            <td>{row.email}</td>
            <td>{row.phone}</td>
            <td>
              <Dropdown>
                <Dropdown.Toggle variant="secondary" id="dropdown-basic">
                  Action
                </Dropdown.Toggle>

                <Dropdown.Menu>
                  <Dropdown.Item href="">
                    <button
                      className="btn btn-outline-info"
                      onClick={
                        () => {}
                      }
                    >
                      show address
                      <FontAwesomeIcon icon={faEye}></FontAwesomeIcon>
                    </button>
                  </Dropdown.Item>
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
                      onClick={
                        () => {}
                        // handledeleteAddress(address)
                      }
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

export default CustomerTable;
