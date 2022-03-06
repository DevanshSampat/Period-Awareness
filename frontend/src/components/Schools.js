import React, { useState, useEffect } from "react";
import DataTable from "react-data-table-component";
import TextField from "@material-ui/core/TextField";
import InputAdornment from "@material-ui/core/InputAdornment";
import SearchOutlinedIcon from "@material-ui/icons/SearchOutlined";
import allSchools from "../data/schoolData";
import { Button } from "@material-ui/core";

const customStyles = {
  rows: {
    style: {
      minHeight: "72px", // override the row height
      // backgroundColor: "#FCD2D1",
    },
  },
  headCells: {
    style: {
      paddingLeft: "8px", // override the cell padding for head cells
      paddingRight: "8px",
      // backgroundColor: "#FCD2D1",
    },
  },
  cells: {
    style: {
      paddingLeft: "8px", // override the cell padding for data cells
      paddingRight: "8px",
    },
  },
};

const Schools = () => {
  const [schools, setSchools] = useState([]);
  const [filteredSchools, setFilteredSchools] = useState([]);
  const [textVal, setTextVal] = useState("");

  useEffect(() => {
    setSchools(allSchools);
    setFilteredSchools(allSchools);
  }, [allSchools]);

  const onChange = (value) => {
    const searchVal = value.toLowerCase();
    let regex = new RegExp(searchVal, "g");
    const name = schools.filter((school) => {
      if (school.name) {
        return school.name.toLowerCase().match(regex);
      }
    });
    setFilteredSchools([...new Set([...name])]);
  };

  const columns = [
    {
      name: "Name",
      selector: "name",
      sortable: true,
    },
    {
      name: "Location",
      selector: "location",
      sortable: true,
    },
    {
      name: "Email",
      selector: "email",
      sortable: true,
    },
    {
      name: "Phone",
      selector: "phone",
      sortable: true,
    },
    {
      name: "No of Students",
      selector: "noOfStudents",
      sortable: true,
    },
    {
      name: "Acknowledge",
      selector: (row) => (
        <Button style={{ backgroundColor: "#FCD2D1" }}>Done</Button>
      ),
    },
  ];

  return (
    <div className="listTable">
      <form onSubmit={(e) => e.preventDefault()}>
        <TextField
          style={{ backgroundColor: "white" }}
          id="outlined-search"
          placeholder="Search by name/e-mail"
          fullWidth
          size="small"
          type="search"
          variant="outlined"
          value={textVal}
          onChange={(e) => {
            setTextVal(e.target.value);
            onChange(e.target.value);
          }}
          InputProps={{
            startAdornment: (
              <InputAdornment position="start">
                <SearchOutlinedIcon />
              </InputAdornment>
            ),
          }}
        />
      </form>
      <DataTable
        customStyles={customStyles}
        columns={columns}
        data={filteredSchools}
        highlightOnHover={true}
        pointerOnHover={true}
        pagination={true}
        paginationPerPage={8}
      />
    </div>
  );
};

export default Schools;
