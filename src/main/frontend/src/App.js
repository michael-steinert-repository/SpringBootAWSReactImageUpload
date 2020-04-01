import React, {useState, useEfect, useCallback} from 'react';
import './App.css';
import axios from "axios";
import {useDropzone} from 'react-dropzone'

const userProfiles = () => {

  const [userProfiles, setUserProfiles] = useState([]);

  const fetchUserProfiles = () => {
    axios.get("http://localhost:8080/api/v1/user-profile").then(res => {
          console.log(res);
          setUserProfiles(res.data)
    });
  };
  useEfect(() => {
    fetchUserProfiles();
  }, []);

  return userProfiles.map((userProfile, index) => {
    return (
        <div key={index}>
            <br/>
            <h1>{userProfile.username}</h1>
            <p>{userProfile.userProfileId}</p>
            <Dropzone {...userProfile} />
            /*alternativ: <Dropzone userProfileId={userProfile.userProfileId} /> */
            <br/>
        </div>
    );
  });
};

function Dropzone({userProfileId}) {
    const onDrop = useCallback(acceptedFiles => {
        const file = acceptedFiles[0];

        console.log(file);

        const formData = new FormData();
        formData.append("file", file);

        axios.post(`http://localhost:8080/api/v1/user-profile/${userProfileId}/image/upload`,
            formData,
            {
                headers: {
                    "Content-Type" : "multipart/form-data"
                }
            }).then(() => {
                console.log("file uploaded successfully");
        }).catch(err => {
            console.log(err);
        });
    }, []);
    const {getRootProps, getInputProps, isDragActive} = useDropzone({onDrop});

    return (
        <div {...getRootProps()}>
            <input {...getInputProps()} />
            {
                isDragActive ?
                    <p>Drop the profile image here ...</p> :
                    <p>Drag 'n' drop profile image here, or click to select profile image</p>
            }
        </div>
    );
}

function App() {
  return (
    <div className="App">
      <userProfiles />
    </div>
  );
}

export default App;
