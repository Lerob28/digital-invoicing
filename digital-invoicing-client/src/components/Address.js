import { faAdd, faCheck, faPen, faRemove, faTrash } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import React, { useCallback, useContext, useEffect } from "react";
import { checkAddress, deleteAddress, getAddresss } from "../app/app";
import { Link, useNavigate } from "react-router-dom";
import { AppContext } from "../App";
import SearchForm from "./SearchForm";

export default function Address(props) {
 
  const [state, setState] = useContext(AppContext);

  const navigate = useNavigate();

  const handlegetAddresss = useCallback((keyword,curPage,pSize) => {
    getAddresss(keyword,curPage,pSize)
      .then((res) => {
        const totalElmnt = res.headers["x-total-count"];
        let tPages = Math.ceil(totalElmnt/pSize);
        setState({addresss: res.data, keyword: keyword, pageSize: pSize, currentPage: curPage, totalPages: tPages});
      })
      .catch((err) => {
        console.log(err);
      });
  }, [setState]);

  useEffect(
    () => {handlegetAddresss(state.keyword, state.currentPage, state.pageSize);},
    [handlegetAddresss, state.keyword, state.currentPage, state.pageSize]
  );

  const handlecheckAddress = (address) => {
    checkAddress(address)
      .then((res)=>{
        console.log('address check completed successfully: ');
        console.log(res);
        let newaddresss = state.addresss.map((p) => {
          if (p.id === address.id) {
            p.checked = !p.checked;
          }
          return p;
        });
        setState({...state, addresss: newaddresss});
      })
      .catch((err)=>{
        console.log('Error occured when Checking address: ');
        console.log(err);
      })
  };

  const handledeleteAddress = (address) => {
    deleteAddress(address.id)
      .then((res) => {
        console.log('address deletion completed successfully: ');
        console.log(res);
        let newaddresss = state.addresss.filter((p) => p.id !== address.id);
        setState({...state, addresss: newaddresss});
      })
      .catch((err) => {
        console.log('Error occured when deleting address: ');
        console.log(err);
      })
  };

  const handleGotoPage = (page) => {
    handlegetAddresss(state.keyword, page, state.pageSize);
  };

  return (
    <div className="m-1 p-1">
      <div className="row">
        <div className="col-md-6">
          <div className="card">
            <div className="card-header text-center h2">addresss List</div>
            <div className="card-header bg-white">
              <SearchForm handlegetAddresss={handlegetAddresss}></SearchForm>
            </div>
            <div className="card-body">
              <table className="table">
                <thead>
                  <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Checked</th>
                    <th>
                      <Link
                        to={"/addAddress"}
                        className="btn btn-success ms-1"
                        onClick={()=>props.setRoute("addAddress")}
                      >
                        <FontAwesomeIcon
                          icon={ faAdd }
                        ></FontAwesomeIcon>
                        {" Ajouter"}
                      </Link>
                    </th>
                  </tr>
                </thead>
                <tbody>
                  {state.addresss.map((address) => (
                    <tr key={address.id}>
                      <td>{address.id}</td>
                      <td>{address.name}</td>
                      <td>{address.price}</td>
                      <td>
                        <button
                          className={
                            address.checked
                              ? "btn btn-outline-success"
                              : "btn btn-outline-warning"
                          }
                          onClick={() => handlecheckAddress(address)}
                        >
                          <FontAwesomeIcon
                            icon={address.checked ? faCheck : faRemove}
                          ></FontAwesomeIcon>
                        </button>
                      </td>
                      <td>
                        <button
                          className="btn btn-outline-danger"
                          onClick={() => handledeleteAddress(address)}
                        >
                          <FontAwesomeIcon icon={faTrash}></FontAwesomeIcon>
                        </button>
                        &nbsp; &nbsp; &nbsp;
                        <button
                          className="btn btn-outline-success"
                          onClick={() => navigate(`/editAddress/${address.id}`)}
                        >
                          <FontAwesomeIcon icon={faPen}></FontAwesomeIcon>
                        </button>
                      </td>
                    </tr>
                  ))}
                </tbody>
              </table>
              <ul className="nav nav-pills">
              {
                (new Array(state.totalPages).fill(0)).map((v, index)=>
                  <li>
                    <button
                      className={state.currentPage===index+1?"btn btn-info ms-1":"btn btn-outline-info ms-1"}
                      onClick={()=>handleGotoPage(index+1)}
                    >
                      {index+1}
                    </button>
                  </li>
                )
              }
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
