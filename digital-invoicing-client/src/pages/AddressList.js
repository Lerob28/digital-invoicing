import AddresseTable from "../components/AddresseTable";
import Header from "../components/Hearder";
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';

function AddressList() {
  return (
    <>
      <Header />
      <br />
      <div className="m-1 p-1">
        <div className="card">
          <div className="card-body">
            <h3> Address List </h3>
          </div>
        </div>
      </div>
      <br />
      <Container>
      <Row>
        <Col xs={6} md={1}></Col>
        <Col xs={6} md={10}>
            <AddresseTable />
        </Col>
      </Row>
    </Container>
      
    </>
  );
}

export default AddressList;
