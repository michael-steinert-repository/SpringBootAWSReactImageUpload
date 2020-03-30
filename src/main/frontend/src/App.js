import React, {useState, useEfect} from 'react';
import './App.css';
import axios from "axios";

const userProfiles = () => {
  const fetchUserProfiles = () => {
    axios.get("http://localhost:8080/api/v1/user-profile").then(res => {
          console.log(res);
    });
  }
  useEfect(() => {
    fetchUserProfiles();
  }, []);

  return
};

function App() {
  return (
    <div className="App">
      <userProfiles />
    </div>
  );
}

export default App;
